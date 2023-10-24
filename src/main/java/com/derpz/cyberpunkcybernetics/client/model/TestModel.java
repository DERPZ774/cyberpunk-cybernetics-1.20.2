package com.derpz.cyberpunkcybernetics.client.model;

import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.render.entity.model.EntityModelPartNames;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.Entity;

// Made with Blockbench 4.8.3
// Exported for Minecraft version 1.17+ for Yarn
// Paste this class into your mod and generate all required imports
public class TestModel extends EntityModel<Entity> {
    private final ModelPart sandevistan;
    private final ModelPart seg1;
    private final ModelPart Body_r1;
    private final ModelPart seg2;
    private final ModelPart Body_r2;
    private final ModelPart seg3;
    private final ModelPart Body_r3;
    private final ModelPart seg4;
    private final ModelPart Body_r4;
    public TestModel(ModelPart root, ModelPart seg1, ModelPart bodyR1, ModelPart seg2, ModelPart bodyR2, ModelPart seg3, ModelPart bodyR3, ModelPart seg4, ModelPart bodyR4) {
        this.sandevistan = root.getChild("sandevistan");
        this.seg1 = seg1;
        Body_r1 = bodyR1;
        this.seg2 = seg2;
        Body_r2 = bodyR2;
        this.seg3 = seg3;
        Body_r3 = bodyR3;
        this.seg4 = seg4;
        Body_r4 = bodyR4;
    }
    public static TexturedModelData getTexturedModelData() {
        ModelData modelData = new ModelData();
        ModelPartData modelPartData = modelData.getRoot();
        ModelPartData sandevistan = modelPartData.addChild("sandevistan", ModelPartBuilder.create().uv(0, 0).cuboid(-0.5F, -23.0F, 2.1F, 1.0F, 9.0F, 1.0F, new Dilation(0.0F))
                .uv(4, 6).cuboid(-0.5F, -16.3F, 2.1F, 1.0F, 2.0F, 1.0F, new Dilation(0.1F))
                .uv(8, 6).cuboid(-0.5F, -14.8F, 2.1F, 1.0F, 2.0F, 1.0F, new Dilation(-0.1F))
                .uv(4, 2).cuboid(-1.5F, -23.25F, 2.2F, 3.0F, 1.0F, 1.0F, new Dilation(0.0F))
                .uv(4, 0).cuboid(-2.0F, -23.9F, 2.4F, 4.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 24.0F, -0.75F));

        ModelPartData seg1 = sandevistan.addChild("seg1", ModelPartBuilder.create().uv(4, 4).cuboid(-1.0F, -21.75F, 1.95F, 2.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

        ModelPartData Body_r1 = seg1.addChild("Body_r1", ModelPartBuilder.create().uv(3, 9).cuboid(-0.5F, 0.0F, -0.25F, 1.0F, 1.0F, 1.0F, new Dilation(-0.1F)), ModelTransform.of(0.0F, -22.0F, 2.45F, 0.3927F, 0.0F, 0.0F));

        ModelPartData seg2 = sandevistan.addChild("seg2", ModelPartBuilder.create().uv(4, 4).cuboid(-1.0F, -21.75F, 1.95F, 2.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 1.5F, 0.0F));

        ModelPartData Body_r2 = seg2.addChild("Body_r2", ModelPartBuilder.create().uv(3, 9).cuboid(-0.5F, 0.0F, -0.25F, 1.0F, 1.0F, 1.0F, new Dilation(-0.1F)), ModelTransform.of(0.0F, -22.0F, 2.45F, 0.3927F, 0.0F, 0.0F));

        ModelPartData seg3 = sandevistan.addChild("seg3", ModelPartBuilder.create().uv(4, 4).cuboid(-1.0F, -21.75F, 1.95F, 2.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 3.0F, 0.0F));

        ModelPartData Body_r3 = seg3.addChild("Body_r3", ModelPartBuilder.create().uv(3, 9).cuboid(-0.5F, 0.0F, -0.25F, 1.0F, 1.0F, 1.0F, new Dilation(-0.1F)), ModelTransform.of(0.0F, -22.0F, 2.45F, 0.3927F, 0.0F, 0.0F));

        ModelPartData seg4 = sandevistan.addChild("seg4", ModelPartBuilder.create().uv(4, 4).cuboid(-1.0F, -21.75F, 1.95F, 2.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 4.5F, 0.0F));

        ModelPartData Body_r4 = seg4.addChild("Body_r4", ModelPartBuilder.create().uv(3, 9).cuboid(-0.5F, 0.0F, -0.25F, 1.0F, 1.0F, 1.0F, new Dilation(-0.1F)), ModelTransform.of(0.0F, -22.0F, 2.45F, 0.3927F, 0.0F, 0.0F));
        return TexturedModelData.of(modelData, 16, 16);
    }

    public static ModelData getModelData(Dilation dilation, float pivotOffsetY) {
        ModelData modelData = new ModelData();
        ModelPartData modelPartData = modelData.getRoot();
        ModelPartData sandevistan = modelPartData.addChild("sandevistan", ModelPartBuilder.create().uv(0, 0).cuboid(-0.5F, -23.0F, 2.1F, 1.0F, 9.0F, 1.0F, new Dilation(0.0F))
                .uv(4, 6).cuboid(-0.5F, -16.3F, 2.1F, 1.0F, 2.0F, 1.0F, new Dilation(0.1F))
                .uv(8, 6).cuboid(-0.5F, -14.8F, 2.1F, 1.0F, 2.0F, 1.0F, new Dilation(-0.1F))
                .uv(4, 2).cuboid(-1.5F, -23.25F, 2.2F, 3.0F, 1.0F, 1.0F, new Dilation(0.0F))
                .uv(4, 0).cuboid(-2.0F, -23.9F, 2.4F, 4.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 24.0F, -0.75F));

        ModelPartData seg1 = sandevistan.addChild("seg1", ModelPartBuilder.create().uv(4, 4).cuboid(-1.0F, -21.75F, 1.95F, 2.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

        ModelPartData Body_r1 = seg1.addChild("Body_r1", ModelPartBuilder.create().uv(3, 9).cuboid(-0.5F, 0.0F, -0.25F, 1.0F, 1.0F, 1.0F, new Dilation(-0.1F)), ModelTransform.of(0.0F, -22.0F, 2.45F, 0.3927F, 0.0F, 0.0F));

        ModelPartData seg2 = sandevistan.addChild("seg2", ModelPartBuilder.create().uv(4, 4).cuboid(-1.0F, -21.75F, 1.95F, 2.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 1.5F, 0.0F));

        ModelPartData Body_r2 = seg2.addChild("Body_r2", ModelPartBuilder.create().uv(3, 9).cuboid(-0.5F, 0.0F, -0.25F, 1.0F, 1.0F, 1.0F, new Dilation(-0.1F)), ModelTransform.of(0.0F, -22.0F, 2.45F, 0.3927F, 0.0F, 0.0F));

        ModelPartData seg3 = sandevistan.addChild("seg3", ModelPartBuilder.create().uv(4, 4).cuboid(-1.0F, -21.75F, 1.95F, 2.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 3.0F, 0.0F));

        ModelPartData Body_r3 = seg3.addChild("Body_r3", ModelPartBuilder.create().uv(3, 9).cuboid(-0.5F, 0.0F, -0.25F, 1.0F, 1.0F, 1.0F, new Dilation(-0.1F)), ModelTransform.of(0.0F, -22.0F, 2.45F, 0.3927F, 0.0F, 0.0F));

        ModelPartData seg4 = sandevistan.addChild("seg4", ModelPartBuilder.create().uv(4, 4).cuboid(-1.0F, -21.75F, 1.95F, 2.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 4.5F, 0.0F));

        ModelPartData Body_r4 = seg4.addChild("Body_r4", ModelPartBuilder.create().uv(3, 9).cuboid(-0.5F, 0.0F, -0.25F, 1.0F, 1.0F, 1.0F, new Dilation(-0.1F)), ModelTransform.of(0.0F, -22.0F, 2.45F, 0.3927F, 0.0F, 0.0F));
        return modelData;
    }
    @Override
    public void setAngles(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
    }
    @Override
    public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, float red, float green, float blue, float alpha) {
        sandevistan.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
    }
}