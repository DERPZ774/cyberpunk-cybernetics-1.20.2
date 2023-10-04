package com.derpz.cyberpunkcybernetics.sandevistan;

import com.derpz.cyberpunkcybernetics.item.ModItems;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.fabricmc.fabric.api.event.player.UseItemCallback;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.TypedActionResult;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;

import java.util.Objects;
import java.util.UUID;

public class SandevistanEffectHandler {
    private static boolean isSandevistanActive = false;
    private static int sandevistanDurationTicks = 0;
    private static final int MAX_SANDEVISTAN_DURATION_TICKS = 200; // Adjust the duration as needed
    private static final double SANDIVESTAN_PLAYER_SPEED_MODIFIER = 2.0; // Adjust player speed as needed
    private static PlayerEntity activePlayer = null; // Store the player who activated the effect
    private static final int activationCooldownTicks = 20; // 20 ticks cooldown (1 second), adjust as needed
    private static int activationCooldownCounter = 0;
    private static final UUID SPEED_MODIFIER_ID = UUID.fromString("9B39F804-5C68-4C0A-BF7F-6979F5EC3FF3");

    public static void registerEventHandlers() {
        UseItemCallback.EVENT.register((player, world, hand) -> {
            ItemStack heldItem = player.getStackInHand(hand);

            // Check if the player is using the Sandevistan item and if the cooldown has expired
            if (heldItem.getItem() == ModItems.SANDEVISTAN && activationCooldownCounter <= 0) {
                if (!isSandevistanActive) {
                    activateSandevistan(player);
                } else {
                    deactivateSandevistan();
                }
                activationCooldownCounter = activationCooldownTicks;
                return TypedActionResult.success(heldItem);
            }

            return TypedActionResult.pass(heldItem);
        });

        // Register the tick event
        ServerTickEvents.END_SERVER_TICK.register(server -> {
            if (activationCooldownCounter > 0) {
                activationCooldownCounter--;
            }

            if (isSandevistanActive) {
                sandevistanDurationTicks--;

                if (sandevistanDurationTicks <= 0 && activePlayer != null) {
                    deactivateSandevistan();
                }

                // Debug code to print remaining ticks
                System.out.println("Sandevistan ticks remaining: " + sandevistanDurationTicks);
            }
        });
    }

    public static void activateSandevistan(PlayerEntity player) {
        isSandevistanActive = true;
        sandevistanDurationTicks = MAX_SANDEVISTAN_DURATION_TICKS;

        // Get the player's current movement speed attribute
        EntityAttribute movementSpeedAttribute = EntityAttributes.GENERIC_MOVEMENT_SPEED;

        // Create an AttributeModifier to increase speed
        EntityAttributeModifier speedModifier = new EntityAttributeModifier(
                SPEED_MODIFIER_ID,
                "Sandevistan Speed Boost",
                SANDIVESTAN_PLAYER_SPEED_MODIFIER,
                EntityAttributeModifier.Operation.MULTIPLY_BASE
        );

        // Apply the modifier to the player's movement speed attribute
        Objects.requireNonNull(player.getAttributeInstance(movementSpeedAttribute)).addPersistentModifier(speedModifier);

        player.sendMessage(Text.of("Sandevistan activated"), true);

        // Store the player who activated the effect
        activePlayer = player;

        // Debug print for activation
        System.out.println("Sandevistan activated by player: " + player.getName().toString());
    }

    public static void deactivateSandevistan() {
        if (activePlayer != null) {
            isSandevistanActive = false;

            // Get the player's current movement speed attribute
            EntityAttribute movementSpeedAttribute = EntityAttributes.GENERIC_MOVEMENT_SPEED;

            // Remove the modifier from the player's movement speed attribute
            Objects.requireNonNull(activePlayer.getAttributeInstance(movementSpeedAttribute)).removeModifier(SPEED_MODIFIER_ID);

            activePlayer.sendMessage(Text.of("Sandevistan deactivated"), true);

            // Debug print for deactivation
            System.out.println("Sandevistan deactivated for player: " + activePlayer.getName().toString());

            // Clear the active player reference
            activePlayer = null;
        }
    }

    public static boolean isSandevistanActive() {
        return isSandevistanActive;
    }
}
/// TODO: 10/3/2023 fix attribute going away after sprint 