package com.derpz.cyberpunkcybernetics.client.model;

import net.minecraft.client.model.ModelPart;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.BipedEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.Identifier;

public class SandevistanModel extends BipedEntityModel<LivingEntity> {
    private final ModelPart yourModelPart;  // Replace 'yourModelPart' with your own model part(s)

    public SandevistanModel(ModelPart root) {
        super(root);
        yourModelPart = root.getChild("your_model_part");  // Replace 'your_model_part' with the name of your model part
    }

    @Override
    public void setAngles(LivingEntity entity, float limbAngle, float limbDistance, float animationProgress, float headYaw, float headPitch) {
        // Set the rotation angles for your armor model based on entity state
        // Adjust the rotations to make your model align properly with the player model
        // Example:
        yourModelPart.pitch = headPitch * 0.017453292F;
        yourModelPart.yaw = headYaw * 0.017453292F;
    }

    @Override
    public void render(MatrixStack matrices, VertexConsumer vertices, int light, int overlay, float red, float green, float blue, float alpha) {
        super.render(matrices, vertices, light, overlay, red, green, blue, alpha);
    }

    // Define a method to return a texture identifier for your armor's texture
    public Identifier getTextureForArmor(EquipmentSlot slot) {
        // Return the appropriate texture based on the slot (e.g., chestplate, helmet, etc.)
        // You can create a mapping or naming convention for your armor textures
        // and return the corresponding Identifier here.
        return null;
    }
}
