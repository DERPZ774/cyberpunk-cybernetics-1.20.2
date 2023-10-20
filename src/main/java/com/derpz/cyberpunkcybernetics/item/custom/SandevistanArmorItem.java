package com.derpz.cyberpunkcybernetics.item.custom;

import net.minecraft.client.render.entity.feature.ArmorFeatureRenderer;
import net.minecraft.client.render.entity.model.BipedEntityModel;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;

public class SandevistanArmorItem extends ArmorItem {
    public SandevistanArmorItem(ArmorMaterial material, Type type, Settings settings) {
        super(material, type, settings);
    }

    public BipedEntityModel<LivingEntity> getCustomModel(EquipmentSlot slot, ArmorFeatureRenderer armor) {
        if (slot == EquipmentSlot.CHEST) {
            // Example: Return the chest model
            //return ;

        }
        return null;
    }
}
