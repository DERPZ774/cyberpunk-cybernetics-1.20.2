package com.derpz.cyberpunkcybernetics.item.custom;

import net.minecraft.entity.Entity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import net.minecraft.nbt.NbtCompound;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

import java.util.List;
import java.util.function.Predicate;

public class SandevistanItem extends Item {
    private static final int MAX_DURATION = 600; // Maximum duration in ticks (30 seconds at 20 ticks per second)

    public SandevistanItem(Settings settings) {
        super(settings);
    }

//    @Override
//    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
//        ItemStack stack = user.getStackInHand(hand);
//        System.out.println("Sandi used!");
//
//        // Check if the player is not already under the effect of Sandevistan
//        if (!user.hasStatusEffect(StatusEffects.SPEED)) {
//            // Apply speed effect to the player with a long duration
//            user.addStatusEffect(new StatusEffectInstance(StatusEffects.SPEED, MAX_DURATION, 2));
//
//            // Set a custom NBT tag to indicate the Sandevistan is active and set the duration
//            setSandevistanActive(stack, true);
//            setSandevistanDuration(stack, MAX_DURATION);
//
//            return TypedActionResult.success(stack);
//        }
//
//        return TypedActionResult.fail(stack);
//    }
//
//    @Override
//    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
//        // Check if the Sandevistan is active
//        if (isSandevistanActive(stack) && entity instanceof PlayerEntity) {
//            PlayerEntity player = (PlayerEntity) entity;
//
//            // Slow down time for all entities in the world except the player
//            slowDownEntities(world, player);
//
//            // Decrement the remaining Sandevistan duration
//            int remainingDuration = getRemainingSandevistanDuration(stack);
//            if (remainingDuration <= 0) {
//                // Deactivate Sandevistan when the duration is over
//                setSandevistanActive(stack, false);
//                player.removeStatusEffect(StatusEffects.SPEED);
//            } else {
//                setSandevistanDuration(stack, remainingDuration - 1);
//            }
//        }
//    }
//
//    // Helper methods to manage NBT tags for Sandevistan activation and duration
//    private boolean isSandevistanActive(ItemStack stack) {
//        NbtCompound tag = stack.getOrCreateNbt();
//        return tag.getBoolean("SandevistanActive");
//    }
//
//    private void setSandevistanActive(ItemStack stack, boolean active) {
//        NbtCompound tag = stack.getOrCreateNbt();
//        tag.putBoolean("SandevistanActive", active);
//    }
//
//    private int getRemainingSandevistanDuration(ItemStack stack) {
//        NbtCompound tag = stack.getOrCreateNbt();
//        return tag.getInt("RemainingSandevistanDuration");
//    }
//
//    private void setSandevistanDuration(ItemStack stack, int duration) {
//        NbtCompound tag = stack.getOrCreateNbt();
//        tag.putInt("RemainingSandevistanDuration", duration);
//    }
//
//    // Slow down time for all entities in the world except the player
//    private void slowDownEntities(World world, PlayerEntity player) {
//        double playerSpeed = 0.05; // Adjust the player's movement speed as needed
//        Box searchBox = player.getBoundingBox().expand(16.0, 16.0, 16.0);
//
//        Predicate<Entity> entityPredicate = entity -> entity != player;
//        List<Entity> entities = world.getEntitiesByClass(Entity.class, searchBox, entityPredicate);
//
//        for (Entity entity : entities) {
//            // Slow down entity's movement and adjust other properties
//            Vec3d motion = entity.getVelocity();
//            entity.setVelocity(motion.multiply(playerSpeed, 1.0, playerSpeed));
//
//            // Create a visual particle effect to make the entity appear slower
//            for (int i = 0; i < 10; i++) { // You can adjust the number of particles
//                double xOffset = (world.random.nextDouble() - 0.5) * entity.getWidth();
//                double yOffset = (world.random.nextDouble() - 0.5) * entity.getHeight();
//                double zOffset = (world.random.nextDouble() - 0.5) * entity.getWidth();
//                world.addParticle(ParticleTypes.SMOKE,
//                        entity.getX() + xOffset, entity.getY() + yOffset, entity.getZ() + zOffset,
//                        0.0, 0.0, 0.0
//                );
//            }
//        }
//    }
}
