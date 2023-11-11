/*
 * Decompiled with CFR 0.2.1 (FabricMC 53fa44c9).
 */
package com.derpz.cyberpunkcybernetics.client.renderer;

import com.derpz.cyberpunkcybernetics.client.ModModelLayers;
import com.derpz.cyberpunkcybernetics.client.models.SandevistanModel;
import com.derpz.cyberpunkcybernetics.item.ModItems;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.network.AbstractClientPlayerEntity;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.PlayerModelPart;
import net.minecraft.client.render.entity.feature.FeatureRenderer;
import net.minecraft.client.render.entity.feature.FeatureRendererContext;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.render.entity.model.EntityModelLoader;
import net.minecraft.client.render.item.ItemRenderer;
import net.minecraft.client.util.SkinTextures;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.Identifier;

@Environment(value=EnvType.CLIENT)
public class SandevistanFeatureRenderer<T extends LivingEntity, M extends EntityModel<T>>
        extends FeatureRenderer<T, M> {
    private static final Identifier SKIN = new Identifier("textures/entity/elytra.png");
    private final SandevistanModel sandevistanModel;

    public SandevistanFeatureRenderer(FeatureRendererContext<T, M> context, EntityModelLoader loader) {
        super(context);
        this.sandevistanModel = new SandevistanModel(loader.getModelPart(ModModelLayers.SANDEVISTAN));
    }

    @Override
    public void render(MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i, T livingEntity, float f, float g, float h, float j, float k, float l) {
        AbstractClientPlayerEntity abstractClientPlayerEntity;
        SkinTextures skinTextures;
        ItemStack itemStack = ((LivingEntity)livingEntity).getEquippedStack(EquipmentSlot.CHEST);
//        if (!itemStack.isOf(ModItems.SANDEVISTAN)) {
//            return;
//        }
        Identifier identifier = livingEntity instanceof AbstractClientPlayerEntity ? ((skinTextures = (abstractClientPlayerEntity = (AbstractClientPlayerEntity)livingEntity).getSkinTextures()).elytraTexture() != null ? skinTextures.elytraTexture() : (skinTextures.capeTexture() != null && abstractClientPlayerEntity.isPartVisible(PlayerModelPart.CAPE) ? skinTextures.capeTexture() : SKIN)) : SKIN;
        matrixStack.push();
        matrixStack.translate(0.0f, 0.0f, 0.125f);
        ((EntityModel)this.getContextModel()).copyStateTo(this.sandevistanModel);
        this.sandevistanModel.setAngles(livingEntity, f, g, j, k, l);
        VertexConsumer vertexConsumer = ItemRenderer.getArmorGlintConsumer(vertexConsumerProvider, RenderLayer.getArmorCutoutNoCull(identifier), false, itemStack.hasGlint());
        this.sandevistanModel.render(matrixStack, vertexConsumer, i, OverlayTexture.DEFAULT_UV, 1.0f, 1.0f, 1.0f, 1.0f);
        matrixStack.pop();
    }
}

