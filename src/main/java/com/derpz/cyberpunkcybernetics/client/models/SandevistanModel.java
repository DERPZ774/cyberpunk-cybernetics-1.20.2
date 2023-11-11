package com.derpz.cyberpunkcybernetics.client.models;

import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.AnimalModel;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import org.spongepowered.include.com.google.common.collect.ImmutableList;

// Made with Blockbench 4.8.3
// Exported for Minecraft version 1.17+ for Yarn
// Paste this class into your mod and generate all required imports
public class SandevistanModel  <T extends LivingEntity> extends AnimalModel<T> {
    private final ModelPart hood;

    public SandevistanModel(ModelPart root) {
        this.hood = root.getChild("hood");
    }

    public static TexturedModelData getTexturedModelData() {
        ModelData modelData = new ModelData();
        ModelPartData modelPartData = modelData.getRoot();
        Dilation dilation = new Dilation(0.0F);
        modelPartData
                .addChild("hood", ModelPartBuilder.create()
                                .uv(32, 0)
                                .cuboid(-3, -12, 2, 6, 6, 1.0F, dilation)
                        , ModelTransform.of(0, 0, 0, 0, 0.0F, 0F))
                .addChild("back_hood", ModelPartBuilder.create().uv(32, 7)
                                .cuboid(-3, -13.435f, 2.08f, 6,6,2, dilation)
                        , ModelTransform.of(0, 1, -1, 0.0f, 0.0F, 0F));


        return TexturedModelData.of(modelData, 64, 32);
    }

    @Override
    protected Iterable<ModelPart> getHeadParts() {
        return ImmutableList.of(this.hood);
    }

    @Override
    protected Iterable<ModelPart> getBodyParts() {
        return ImmutableList.of();
    }



    @Override
    public void render(MatrixStack matrices, VertexConsumer vertices, int light, int overlay, float red, float green, float blue, float alpha) {

    }

    @Override
    public void setAngles(T entity, float limbAngle, float limbDistance, float animationProgress, float headYaw, float headPitch) {

    }
}