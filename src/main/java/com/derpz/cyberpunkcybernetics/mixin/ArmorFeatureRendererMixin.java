package com.derpz.cyberpunkcybernetics.mixin;

import com.derpz.cyberpunkcybernetics.item.custom.SandevistanArmorItem;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.feature.ArmorFeatureRenderer;
import net.minecraft.client.render.entity.model.BipedEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ArmorFeatureRenderer.class)
public class ArmorFeatureRendererMixin {

    @Inject(at = @At("HEAD"), method = "render*", cancellable = true)
    private void render(MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, LivingEntity entity, float limbAngle, float limbDistance, float customAngle, float headYaw, float headPitch, float tickDelta, CallbackInfo ci) {
        ItemStack itemStack = entity.getEquippedStack(EquipmentSlot.CHEST);
        Item item = itemStack.getItem();

        if (item instanceof SandevistanArmorItem) {
            ci.cancel(); // Exit early to skip rendering
            return;
        }
    }


}
