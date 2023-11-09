package com.derpz.cyberpunkcybernetics.client.models;

import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.Entity;

// Made with Blockbench 4.8.3
// Exported for Minecraft version 1.17+ for Yarn
// Paste this class into your mod and generate all required imports
public class SandevistanModel extends EntityModel<Entity> {
    private final ModelPart Head;
    private final ModelPart Body;
    private final ModelPart RightArm;
    private final ModelPart LeftArm;
    private final ModelPart RightLeg;
    private final ModelPart LeftLeg;
    private final ModelPart bone;
    private final ModelPart bone2;
    private final ModelPart cube_r1;
    private final ModelPart cube_r2;
    private final ModelPart cube_r3;
    private final ModelPart cube_r4;
    private final ModelPart cube_r5;
    private final ModelPart cube_r6;
    private final ModelPart cube_r7;
    private final ModelPart cube_r8;
    private final ModelPart cube_r9;
    private final ModelPart cube_r10;
    private final ModelPart cube_r11;
    public SandevistanModel(ModelPart root) {
        this.Head = root.getChild("Head");
        this.Body = root.getChild("Body");
        this.RightArm = root.getChild("RightArm");
        this.LeftArm = root.getChild("LeftArm");
        this.RightLeg = root.getChild("RightLeg");
        this.LeftLeg = root.getChild("LeftLeg");
        this.bone2 = root.getChild("bone2");
        this.bone = root.getChild("bone");
        this.cube_r1 = root.getChild("cube_r1");
        this.cube_r2 = root.getChild("cube_r2");
        this.cube_r3 = root.getChild("cube_r3");
        this.cube_r4 = root.getChild("cube_r4");
        this.cube_r5 = root.getChild("cube_r5");
        this.cube_r6 = root.getChild("cube_r6");
        this.cube_r7 = root.getChild("cube_r7");
        this.cube_r8 = root.getChild("cube_r8");
        this.cube_r9 = root.getChild("cube_r9");
        this.cube_r10 = root.getChild("cube_r10");
        this.cube_r11 = root.getChild("cube_r11");
    }
    public static TexturedModelData getTexturedModelData() {
        ModelData modelData = new ModelData();
        ModelPartData modelPartData = modelData.getRoot();
        ModelPartData Head = modelPartData.addChild("Head", ModelPartBuilder.create().uv(32, 0).cuboid(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, new Dilation(0.5F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

        ModelPartData Body = modelPartData.addChild("Body", ModelPartBuilder.create().uv(16, 32).cuboid(-4.0F, 0.0F, -2.0F, 8.0F, 12.0F, 4.0F, new Dilation(0.25F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

        ModelPartData RightArm = modelPartData.addChild("RightArm", ModelPartBuilder.create().uv(40, 32).cuboid(-3.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, new Dilation(0.25F)), ModelTransform.pivot(-5.0F, 2.0F, 0.0F));

        ModelPartData LeftArm = modelPartData.addChild("LeftArm", ModelPartBuilder.create().uv(48, 48).cuboid(-1.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, new Dilation(0.25F)), ModelTransform.pivot(5.0F, 2.0F, 0.0F));

        ModelPartData RightLeg = modelPartData.addChild("RightLeg", ModelPartBuilder.create().uv(0, 32).cuboid(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new Dilation(0.25F)), ModelTransform.pivot(-1.9F, 12.0F, 0.0F));

        ModelPartData LeftLeg = modelPartData.addChild("LeftLeg", ModelPartBuilder.create().uv(0, 48).cuboid(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new Dilation(0.25F)), ModelTransform.pivot(1.9F, 12.0F, 0.0F));

        ModelPartData bone = LeftLeg.addChild("bone", ModelPartBuilder.create(), ModelTransform.pivot(-1.9F, 12.0F, 0.0F));

        ModelPartData bone2 = modelPartData.addChild("bone2", ModelPartBuilder.create().uv(40, 22).cuboid(-2.4F, -12.0F, -3.0F, 1.0F, 2.0F, 1.0F, new Dilation(0.0F))
                .uv(40, 19).cuboid(-2.4F, -4.0F, -3.0F, 1.0F, 2.0F, 1.0F, new Dilation(0.0F))
                .uv(24, 0).cuboid(-3.9F, -8.0F, -3.0F, 4.0F, 2.0F, 1.0F, new Dilation(0.0F))
                .uv(20, 16).cuboid(-2.9F, -6.0F, -3.0F, 2.0F, 2.0F, 1.0F, new Dilation(0.0F))
                .uv(39, 34).cuboid(-2.9F, -10.0F, -3.0F, 2.0F, 2.0F, 1.0F, new Dilation(0.0F)), ModelTransform.pivot(1.9F, 13.4F, 0.0F));

        ModelPartData cube_r1 = bone2.addChild("cube_r1", ModelPartBuilder.create().uv(12, 32).cuboid(-19.0F, -2.0F, -1.0F, 2.0F, 2.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(12.0992F, -2.0F, -11.9316F, 0.0F, 0.6109F, 0.0F));

        ModelPartData cube_r2 = bone2.addChild("cube_r2", ModelPartBuilder.create().uv(0, 0).cuboid(-19.0F, -2.0F, -1.0F, 2.0F, 2.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(11.5992F, -4.0F, -11.9316F, 0.0F, 0.6109F, 0.0F));

        ModelPartData cube_r3 = bone2.addChild("cube_r3", ModelPartBuilder.create().uv(34, 32).cuboid(-19.0F, -2.0F, -1.0F, 2.0F, 2.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(10.5992F, -6.0F, -11.9316F, 0.0F, 0.6109F, 0.0F));

        ModelPartData cube_r4 = bone2.addChild("cube_r4", ModelPartBuilder.create().uv(32, 35).cuboid(-6.0F, -2.0F, -1.0F, 2.0F, 2.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(0.9502F, -8.0F, -4.4752F, 0.0F, 0.6109F, 0.0F));

        ModelPartData cube_r5 = bone2.addChild("cube_r5", ModelPartBuilder.create().uv(37, 37).cuboid(13.0F, -2.0F, -1.0F, 2.0F, 2.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-14.1137F, -10.0F, 6.4228F, 0.0F, 0.6109F, 0.0F));

        ModelPartData cube_r6 = bone2.addChild("cube_r6", ModelPartBuilder.create().uv(24, 3).cuboid(25.0F, -2.0F, -1.0F, 2.0F, 2.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-22.4524F, -2.0F, -16.5203F, 0.0F, -0.6109F, 0.0F));

        ModelPartData cube_r7 = bone2.addChild("cube_r7", ModelPartBuilder.create().uv(0, 3).cuboid(25.0F, -2.0F, -1.0F, 2.0F, 2.0F, 1.0F, new Dilation(0.0F))
                .uv(36, 16).cuboid(25.0F, -6.0F, -1.0F, 2.0F, 2.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-21.9524F, -4.0F, -16.5203F, 0.0F, -0.6109F, 0.0F));

        ModelPartData cube_r8 = bone2.addChild("cube_r8", ModelPartBuilder.create().uv(28, 32).cuboid(25.0F, -2.0F, -1.0F, 2.0F, 2.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-20.9524F, -6.0F, -16.5203F, 0.0F, -0.6109F, 0.0F));

        ModelPartData cube_r9 = bone2.addChild("cube_r9", ModelPartBuilder.create().uv(32, 39).cuboid(13.0F, -2.0F, -1.0F, 2.0F, 2.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-12.6226F, -10.0F, -9.6373F, 0.0F, -0.6109F, 0.0F));

        ModelPartData cube_r10 = bone2.addChild("cube_r10", ModelPartBuilder.create().uv(0, 16).cuboid(-0.5F, -14.0F, -3.0F, 1.0F, 2.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-1.9F, -0.4494F, -7.4255F, -0.6109F, 0.0F, 0.0F));

        ModelPartData cube_r11 = bone2.addChild("cube_r11", ModelPartBuilder.create().uv(0, 32).cuboid(-0.5F, -14.0F, -3.0F, 1.0F, 2.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-1.9F, 7.7474F, 7.4875F, 0.6109F, 0.0F, 0.0F));
        return TexturedModelData.of(modelData, 64, 64);
    }

    @Override
    public void setAngles(Entity entity, float limbAngle, float limbDistance, float animationProgress, float headYaw, float headPitch) {

    }

    @Override
    public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, float red, float green, float blue, float alpha) {
        Head.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
        Body.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
        RightArm.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
        LeftArm.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
        RightLeg.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
        LeftLeg.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
        bone2.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
    }

}