package com.derpz.cyberpunkcybernetics.networking.server;

import com.derpz.cyberpunkcybernetics.entity.Modifiers;
import com.derpz.cyberpunkcybernetics.networking.ModMessages;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;
import net.fabricmc.fabric.api.networking.v1.PacketSender;
import net.minecraft.entity.attribute.EntityAttributeInstance;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.ServerTickManager;
import net.minecraft.server.network.ServerPlayNetworkHandler;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Style;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;

import java.util.HashMap;
import java.util.Map;

public class SandevistanC2S {

    private static final String MESSAGE_SANDEVISTAN_ACTIVATED = "message.cyberpunkcybernetics.sandevistan_activated";
    private static final String MESSAGE_SANDEVISTAN_DEACTIVATED = "message.cyberpunkcybernetics.sandevistan_deactivated";
    private static final float rateSpeed = 10, defaultRate = 20;
    private static final Map<ServerPlayerEntity, Boolean> playerActivationMap = new HashMap<>();

    public static void receive(MinecraftServer server, ServerPlayerEntity player, ServerPlayNetworkHandler handler,
                               PacketByteBuf buf, PacketSender responseSender) {
        // Everything here happens ONLY on the Server!
        ServerWorld world = (ServerWorld) player.getWorld();
        ServerTickManager serverTickManager = world.getServer().getTickManager();

        // Toggle Sandevistan state for the specific player
        boolean isSandevistanActive = !playerActivationMap.getOrDefault(player, false);

        if (isSandevistanActive) {
            activateSandevistan(player, world, serverTickManager);
            notifyPlayer(player, "Tick Rate: " + rateSpeed, Formatting.WHITE);
            applyAOETickChange(player, world, rateSpeed, 20.0); // Adjust radius as needed
        } else {
            deactivateSandevistan(player, world, serverTickManager);
            notifyPlayer(player, "Tick Rate: " + defaultRate, Formatting.WHITE);
            applyAOETickChange(player, world, defaultRate, 20.0); // Adjust radius as needed
        }

        // Update the Sandevistan state for the specific player
        playerActivationMap.put(player, isSandevistanActive);

        // Updates the sandevistanState
        sendStateUpdate(responseSender, isSandevistanActive);
    }

    private static void activateSandevistan(ServerPlayerEntity player, ServerWorld world, ServerTickManager serverTickManager) {
        player.sendMessage(Text.translatable(MESSAGE_SANDEVISTAN_ACTIVATED).formatted(Formatting.GREEN), true);
        playActivationSound(player, world);

        // Apply the Sandevistan effects
        applySandevistanEffects(player);

        // Adjust server tick rate
        serverTickManager.setTickRate(rateSpeed);
    }

    private static void deactivateSandevistan(ServerPlayerEntity player, ServerWorld world, ServerTickManager serverTickManager) {
        player.sendMessage(Text.translatable(MESSAGE_SANDEVISTAN_DEACTIVATED).formatted(Formatting.RED), true);

        // Remove the Sandevistan effects
        removeSandevistanEffects(player);

        // Adjust server tick rate back to default
        serverTickManager.setTickRate(defaultRate);
    }

    private static void applySandevistanEffects(ServerPlayerEntity player) {
        // Get the player's attribute modifier for movement speed
        EntityAttributeInstance movementSpeedAttribute = player.getAttributeInstance(EntityAttributes.GENERIC_MOVEMENT_SPEED);

        // Remove existing modifiers (in case there are any)
        assert movementSpeedAttribute != null;
        movementSpeedAttribute.removeModifier(Modifiers.SANDEVISTAN_SPEED);

        // Increase player's movement speed
        double speedMultiplier = 2.2; // You can adjust this multiplier as needed

        // Add a new modifier based on the speedMultiplier
        movementSpeedAttribute.addTemporaryModifier(new EntityAttributeModifier(Modifiers.SANDEVISTAN_SPEED, "Sandevistan Speed", speedMultiplier - 1.0, EntityAttributeModifier.Operation.MULTIPLY_TOTAL));
    }

    private static void removeSandevistanEffects(ServerPlayerEntity player) {
        // Remove the Sandevistan effects
        EntityAttributeInstance movementSpeedAttribute = player.getAttributeInstance(EntityAttributes.GENERIC_MOVEMENT_SPEED);

        assert movementSpeedAttribute != null;
        movementSpeedAttribute.removeModifier(Modifiers.SANDEVISTAN_SPEED);
    }

    private static void sendStateUpdate(PacketSender responseSender, boolean isSandevistanActive) {
        PacketByteBuf buf = PacketByteBufs.create();
        buf.writeBoolean(isSandevistanActive);
    }

    private static void notifyPlayer(ServerPlayerEntity player, String message, Formatting color) {
        player.sendMessage(Text.translatable(message).fillStyle(Style.EMPTY.withColor(color)), false);
    }

    private static void playActivationSound(ServerPlayerEntity player, ServerWorld world) {
        world.playSound(null, player.getBlockPos(), SoundEvents.BLOCK_BEACON_ACTIVATE, SoundCategory.PLAYERS, 1.0F, 1.0F);
    }

    private static void applyAOETickChange(ServerPlayerEntity player, ServerWorld world, float tickRate, double radius) {
        for (ServerPlayerEntity otherPlayer : world.getPlayers()) {
            // Check if the other player is within the specified radius
            if (player.getPos().distanceTo(otherPlayer.getPos()) <= radius) {

            }
        }
    }

}
