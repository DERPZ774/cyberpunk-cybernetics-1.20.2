package com.derpz.cyberpunkcybernetics.item.custom

import networking.ModMessages
import com.derpz.cyberpunkcybernetics.sound.ModSounds
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking
import net.fabricmc.fabric.api.networking.v1.PacketByteBufs
import net.minecraft.entity.player.PlayerEntity
import net.minecraft.item.Item
import net.minecraft.item.ItemStack
import net.minecraft.util.Hand
import net.minecraft.util.TypedActionResult
import net.minecraft.world.World

class SandevistanItem(settings: Settings?) : Item(settings) {
    companion object {
        private const val MAX_DURATION = 600 // Maximum duration in ticks (30 seconds at 20 ticks per second)
    }

    override fun use(world: World?, user: PlayerEntity?, hand: Hand?): TypedActionResult<ItemStack> {
        user?.playSound(ModSounds.DEBUG_SOUND, 1f, 1f)
        //ServerPlayerNetworking.send(user as ServerPlayerEntity?, ModPackets.SANDEVISTAN_PACKET_ID, PacketByteBufs.empty())
        ClientPlayNetworking.send(ModMessages.SANDEVISTAN_ID, PacketByteBufs.create())
        return super.use(world, user, hand)
    }
}
