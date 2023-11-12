package com.derpz.cyberpunkcybernetics.client.models;

import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityPose;

// Made with Blockbench 4.8.3
// Exported for Minecraft version 1.17+ for Yarn
// Paste this class into your mod and generate all required imports
public class SandevistanModel extends EntityModel<Entity> {
    private final ModelPart sandevistan;
    private final ModelPart bone;

    private final ModelPart bone2;

    private final ModelPart bone3;

    private final ModelPart bone4;

    public SandevistanModel(ModelPart root) {
        this.sandevistan = root.getChild("sandevistan");
        this.bone = root.getChild("bone");
        this.bone2 = root.getChild("bone2");
        this.bone3 = root.getChild("bone3");
        this.bone4 = root.getChild("bone4");
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

        ModelPartData bone = modelPartData.addChild("bone", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 3.0F, 0.5F));

        ModelPartData vertebrae1_r1 = bone.addChild("vertebrae1_r1", ModelPartBuilder.create().uv(0, 6).cuboid(-1.0F, 0.0F, 0.0F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.7854F, 0.0F, 0.0F));

        ModelPartData bone2 = modelPartData.addChild("bone2", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 5.0F, 0.5F));

        ModelPartData vertebrae2_r1 = bone2.addChild("vertebrae2_r1", ModelPartBuilder.create().uv(8, 4).cuboid(-1.0F, 0.0F, 0.0F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.7854F, 0.0F, 0.0F));

        ModelPartData bone3 = modelPartData.addChild("bone3", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 7.0F, 0.5F));

        ModelPartData vertebrae3_r1 = bone3.addChild("vertebrae3_r1", ModelPartBuilder.create().uv(6, 8).cuboid(-1.0F, 0.0F, 0.0F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.7854F, 0.0F, 0.0F));

        ModelPartData bone4 = modelPartData.addChild("bone4", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 9.0F, 0.5F));

        ModelPartData vertebrae4_r1 = bone4.addChild("vertebrae4_r1", ModelPartBuilder.create().uv(0, 10).cuboid(-1.0F, 0.0F, 0.0F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.7854F, 0.0F, 0.0F));
        return TexturedModelData.of(modelData, 32, 32);
    }
    @Override
    public void setAngles(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        EntityPose pose = entity.getPose();

        if (pose == EntityPose.CROUCHING) {
            // Sandevistan specific positioning
            this.sandevistan.pitch = 0.5F;
            this.sandevistan.pivotY = 2.5F;

            // Set angles for other parts
            setPartAngles(this.bone, 4.5F, 2.0F, 0.45F);
            setPartAngles(this.bone2, 5.0F + 1.0F, 0.5F + 2.5F, 0.0F + 0.35F);
            setPartAngles(this.bone3, 7F + 1.0F, 0.5F + 3.5F, 0.0F + 0.55F);
            setPartAngles(this.bone4, 9F + 1.0F, 0.5F + 4.5F, 0.0F + 0.55F);
        } else {
            // Sandevistan specific positioning for standing
            this.sandevistan.pitch = 0.0F;
            this.sandevistan.pivotY = 0.75F;

            // Set angles for other parts
            setPartAngles(this.bone, 3F, 0.5F, 0.0F);
            setPartAngles(this.bone2, 5.0F, 0.5F, 0.0F);
            setPartAngles(this.bone3, 7.0F, 0.5F, 0.0F);
            setPartAngles(this.bone4, 9.0F, 0.5F, 0.0F);
        }
    }

    private void setPartAngles(ModelPart part, float pivotY, float pivotZ, float pitch) {
        part.pivotY = pivotY;
        part.pivotZ = pivotZ;
        part.pitch = pitch;
    }

    private void setPartAngles(ModelPart part, float pivotY, float pivotZ) {
        setPartAngles(part, pivotY, pivotZ, 0.0F);
    }

    @Override
    public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, float red, float green, float blue, float alpha) {
        // Render sandevistan model
        renderModelPart(sandevistan, matrices, vertexConsumer, light, overlay, red, green, blue, alpha);

        // Render vertebrae model
        renderModelPart(bone, matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
        renderModelPart(bone2, matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
        renderModelPart(bone3, matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
        renderModelPart(bone4, matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
    }

    public void renderModelPart(ModelPart modelPart, MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, float red, float green, float blue, float alpha) {
        modelPart.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
    }

    public ModelPart[] getVertebrae() {
        return new ModelPart[]{bone, bone2, bone3, bone4};
    }
}