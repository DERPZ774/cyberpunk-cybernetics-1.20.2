package com.derpz.cyberpunkcybernetics.sandevistan

import com.derpz.cyberpunkcybernetics.item.ModItems
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents
import net.fabricmc.fabric.api.event.player.UseItemCallback
import net.minecraft.entity.attribute.EntityAttributeModifier
import net.minecraft.entity.attribute.EntityAttributes
import net.minecraft.entity.player.PlayerEntity
import net.minecraft.item.ItemStack
import net.minecraft.server.MinecraftServer
import net.minecraft.text.Text
import net.minecraft.util.Hand
import net.minecraft.util.TypedActionResult
import net.minecraft.world.World
import java.util.*

object SandevistanEffectHandler {
    var isSandevistanActive = false
        private set
    private var sandevistanDurationTicks = 0
    private const val MAX_SANDEVISTAN_DURATION_TICKS = 200 // Adjust the duration as needed
    private const val SANDIVESTAN_PLAYER_SPEED_MODIFIER = 2.0 // Adjust player speed as needed
    private var activePlayer: PlayerEntity? = null // Store the player who activated the effect
    private const val ACTIVATION_COOLDOWN_TICKS = 10 // 10 ticks cooldown, adjust as needed
    private var activationCooldownCounter = 0
    private val SPEED_MODIFIER_ID = UUID.fromString("9B39F804-5C68-4C0A-BF7F-6979F5EC3FF3")
    private var speedModifier: EntityAttributeModifier? = null
    private var remainingCooldownTicks = 0
    private var backgroundRechargeTicks = 0
    fun registerEventHandlers() {
        UseItemCallback.EVENT.register(UseItemCallback register@{ player: PlayerEntity, world: World?, hand: Hand? ->
            val heldItem = player.getStackInHand(hand)

            // Check if the player is using the Sandevistan item and if the cooldown has expired
            if (heldItem.item === ModItems.SANDEVISTAN && activationCooldownCounter <= 0) {
                if (!isSandevistanActive) {
                    activateSandevistan(player)
                } else {
                    deactivateSandevistan()
                }
                activationCooldownCounter =
                    ACTIVATION_COOLDOWN_TICKS
                return@register TypedActionResult.success<ItemStack>(heldItem)
            }
            TypedActionResult.pass<ItemStack>(heldItem)
        })

        // Register the tick event
        ServerTickEvents.END_SERVER_TICK.register(ServerTickEvents.EndTick { server: MinecraftServer? ->
            if (activationCooldownCounter > 0) {
                activationCooldownCounter--
            }
            if (isSandevistanActive) {
                sandevistanDurationTicks--
                if (sandevistanDurationTicks <= 0 && activePlayer != null) {
                    deactivateSandevistan()
                }

                // Debug code to print remaining ticks
                println("Sandevistan ticks remaining: " + sandevistanDurationTicks)
            } else {
                // If not active, recharge the cooldown
                if (remainingCooldownTicks > 0) {
                    remainingCooldownTicks--

                    // Debug code to print remaining cooldown ticks
                    println("Cooldown ticks remaining: " + remainingCooldownTicks)
                }

                // Background recharge
                if (backgroundRechargeTicks < MAX_SANDEVISTAN_DURATION_TICKS) {
                    backgroundRechargeTicks++
                }
            }

            // Apply the speed modifier every tick if Sandevistan is active
            if (isSandevistanActive && activePlayer != null) {
                if (speedModifier != null) {
                    Objects.requireNonNull(
                        activePlayer!!.getAttributeInstance(
                            EntityAttributes.GENERIC_MOVEMENT_SPEED
                        )
                    )
                        ?.removeModifier(speedModifier!!.id)
                }
                speedModifier =
                    EntityAttributeModifier(
                        SPEED_MODIFIER_ID,
                        "Sandevistan Speed Boost",
                        SANDIVESTAN_PLAYER_SPEED_MODIFIER,
                        EntityAttributeModifier.Operation.MULTIPLY_BASE
                    )
                Objects.requireNonNull(
                    activePlayer!!.getAttributeInstance(
                        EntityAttributes.GENERIC_MOVEMENT_SPEED
                    )
                )
                    ?.addPersistentModifier(speedModifier)
            }
        })
    }

    fun activateSandevistan(player: PlayerEntity) {
        // Only allow activation if the cooldown has elapsed
        if (remainingCooldownTicks <= 0) {
            isSandevistanActive = true

            // Calculate the remaining ticks based on the background recharge
            sandevistanDurationTicks = backgroundRechargeTicks

            // Adjust FOV when Sandevistan is activated
            player.sendMessage(Text.of("Sandevistan activated"), true)
            player.setSprinting(true) // Simulate sprinting to adjust FOV
            activePlayer = player

            // Debug print for activation
            println("Sandevistan activated by player: " + player.name.toString())
        } else {
            // Inform the player about the remaining cooldown
            player.sendMessage(
                Text.of("Sandevistan is on cooldown. Cooldown ticks remaining: $remainingCooldownTicks"),
                true
            )
        }
    }

    fun deactivateSandevistan() {
        if (activePlayer != null) {
            isSandevistanActive = false

            // Calculate the remaining cooldown based on the background recharge
            remainingCooldownTicks = MAX_SANDEVISTAN_DURATION_TICKS - backgroundRechargeTicks

            // Reset FOV when Sandevistan is deactivated
            activePlayer!!.sendMessage(Text.of("Sandevistan deactivated"), true)
            activePlayer!!.setSprinting(false) // Reset FOV adjustment

            // Remove the modifier from the player's movement speed attribute
            Objects.requireNonNull(activePlayer!!.getAttributeInstance(EntityAttributes.GENERIC_MOVEMENT_SPEED))
                ?.removeModifier(SPEED_MODIFIER_ID)

            // Debug print for deactivation
            println("Sandevistan deactivated for player: " + activePlayer!!.name.toString())

            // Clear the active player reference
            activePlayer = null
        }
    }
}
