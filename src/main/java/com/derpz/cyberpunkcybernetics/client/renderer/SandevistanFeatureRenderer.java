package com.derpz.cyberpunkcybernetics.client.renderer;

import com.derpz.cyberpunkcybernetics.CyberpunkCybernetics;
import com.derpz.cyberpunkcybernetics.client.ModModelLayers;
import com.derpz.cyberpunkcybernetics.client.models.SandevistanModel;
import com.derpz.cyberpunkcybernetics.item.ModItems;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.model.ModelPart;
import net.minecraft.client.network.AbstractClientPlayerEntity;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
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
import net.minecraft.util.Identifier;

@Environment(value=EnvType.CLIENT)
public class SandevistanFeatureRenderer<T extends LivingEntity, M extends EntityModel<T>> extends FeatureRenderer<T, M> {
    private static final Identifier TEXTURE = new Identifier(CyberpunkCybernetics.MOD_ID, "textures/models/cyberware/sandevistan.png");
    private static final Identifier EMISSIVE_TEXTURE = new Identifier(CyberpunkCybernetics.MOD_ID, "textures/models/cyberware/sandevistan_lights.png");
    private final SandevistanModel sandevistanModel;

    public SandevistanFeatureRenderer(FeatureRendererContext<T, M> context, EntityModelLoader loader) {
        super(context);
        this.sandevistanModel = new SandevistanModel(loader.getModelPart(ModModelLayers.SANDEVISTAN));
    }

    @Override
    public void render(MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i, T livingEntity, float f, float g, float h, float j, float k, float l) {
        AbstractClientPlayerEntity abstractClientPlayerEntity = (AbstractClientPlayerEntity) livingEntity;
        SkinTextures skinTextures = abstractClientPlayerEntity.getSkinTextures();
        ItemStack itemStack = abstractClientPlayerEntity.getEquippedStack(EquipmentSlot.CHEST);

        if (!itemStack.isOf(ModItems.SANDEVISTAN)) {
            return;
        }

        matrixStack.push();
        matrixStack.translate(0.0f, 0.0f, 0.0f);
        this.sandevistanModel.setAngles(livingEntity, f, g, j, k, l);
        // Render regular texture
        VertexConsumer regularVertexConsumer = vertexConsumerProvider.getBuffer(RenderLayer.getEntityCutout(TEXTURE));
        this.sandevistanModel.render(matrixStack, regularVertexConsumer, i, OverlayTexture.DEFAULT_UV, 1.0f, 1.0f, 1.0f, 1.0f);

        // Render glowing texture for vertebrae
        RenderLayer emissiveRenderLayer = RenderLayer.getEyes(EMISSIVE_TEXTURE);
        VertexConsumer emissiveVertexConsumer = ItemRenderer.getItemGlintConsumer(
                vertexConsumerProvider,
                emissiveRenderLayer,
                false,
                false
        );

        ModelPart[] vertebrae = sandevistanModel.getVertebrae();
        for (ModelPart vertebra : vertebrae) {
            sandevistanModel.renderModelPart(vertebra, matrixStack, emissiveVertexConsumer, i, OverlayTexture.DEFAULT_UV, 1.0f, 1.0f, 1.0f, 1.0f);
        }
        matrixStack.pop();
    }
}