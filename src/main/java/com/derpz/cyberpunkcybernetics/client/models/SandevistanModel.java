package com.derpz.cyberpunkcybernetics.client.models;

import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.Entity;
import org.joml.Vector3f;

// Made with Blockbench 4.8.3
// Exported for Minecraft version 1.17+ for Yarn
// Paste this class into your mod and generate all required imports
public class SandevistanModel extends EntityModel<Entity> {
    private final ModelPart sandevistan;
    private final ModelPart vertebrae;

    public SandevistanModel(ModelPart root) {
        this.sandevistan = root.getChild("sandevistan");
        this.vertebrae = root.getChild("vertebrae");
    }

    public ModelPart getVertebrae() {
        return vertebrae;
    }
    public static TexturedModelData getTexturedModelData() {
        ModelData modelData = new ModelData();
        ModelPartData modelPartData = modelData.getRoot();
        ModelPartData sandevistan = modelPartData.addChild("sandevistan", ModelPartBuilder.create().uv(13, 13).cuboid(-0.5F, 8.5F, -0.4999F, 1.0F, 2.0F, 1.0F, new Dilation(0.0F))
                .uv(0, 0).cuboid(-2.0F, 6.25F, -0.4999F, 4.0F, 1.0F, 1.0F, new Dilation(0.0F))
                .uv(0, 2).cuboid(-2.0F, 4.25F, -0.4999F, 4.0F, 1.0F, 1.0F, new Dilation(0.0F))
                .uv(0, 4).cuboid(-2.0F, 2.25F, -0.4999F, 4.0F, 1.0F, 1.0F, new Dilation(0.0F))
                .uv(9, 1).cuboid(-1.5F, 0.75F, -0.4999F, 3.0F, 1.0F, 1.0F, new Dilation(0.0F))
                .uv(8, 12).cuboid(-1.0F, -0.999F, 0.0001F, 2.0F, 1.0F, 1.0F, new Dilation(0.0F))
                .uv(12, 8).cuboid(-0.5F, 0.001F, 0.0001F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.75F, 1.8249F));

        ModelPartData vertebrae = modelPartData.addChild("vertebrae", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 3.0F, 0.5F));

        ModelPartData vertebrae1_r1 = vertebrae.addChild("vertebrae1_r1", ModelPartBuilder.create().uv(0, 6).cuboid(-1.0F, 0.0F, 0.0F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.7854F, 0.0F, 0.0F));

        ModelPartData vertebrae2_r1 = vertebrae.addChild("vertebrae2_r1", ModelPartBuilder.create().uv(8, 4).cuboid(-1.0F, 0.0F, 0.0F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 2.0F, 0.0F, 0.7854F, 0.0F, 0.0F));

        ModelPartData vertebrae3_r1 = vertebrae.addChild("vertebrae3_r1", ModelPartBuilder.create().uv(6, 8).cuboid(-1.0F, 0.0F, 0.0F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 4.0F, 0.0F, 0.7854F, 0.0F, 0.0F));

        ModelPartData vertebrae4_r1 = vertebrae.addChild("vertebrae4_r1", ModelPartBuilder.create().uv(0, 10).cuboid(-1.0F, 0.0F, 0.0F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 6.0F, 0.0F, 0.7854F, 0.0F, 0.0F));
        return TexturedModelData.of(modelData, 32, 32);
    }
    @Override
    public void setAngles(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        // Adjust position based on crouch state
        boolean isCrouching = entity.isInSneakingPose();

        if (isCrouching) {
            this.sandevistan.pitch = 0.5F;
            this.sandevistan.pivotY = 2.5f;
            this.vertebrae.pitch = 0.8F;
            this.vertebrae.pivotY = 3.5F;
        } else {
            this.sandevistan.pitch = 0.0F;
            this.sandevistan.pivotY = 0.75F;
            this.vertebrae.pitch = 0F;
            this.vertebrae.pivotY = 3.0F;
        }
    }

    @Override
    public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, float red, float green, float blue, float alpha) {
        // Render sandevistan model
        renderModelPart(sandevistan, matrices, vertexConsumer, light, overlay, red, green, blue, alpha);

        // Render vertebrae model
        renderModelPart(vertebrae, matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
    }
    public void renderModelPart(ModelPart modelPart, MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, float red, float green, float blue, float alpha) {
        modelPart.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
    }
}