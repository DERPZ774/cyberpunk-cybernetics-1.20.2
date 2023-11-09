package com.derpz.cyberpunkcybernetics.item.custom;

import com.derpz.cyberpunkcybernetics.CyberpunkCybernetics;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.NotNull;

public class SandevistanArmorItem extends ArmorItem {

    public SandevistanArmorItem(ArmorMaterial material, Type type, Settings settings) {
        super(material, type, settings);
    }



    @NotNull
    public Identifier getArmorTexture(ItemStack stack, EquipmentSlot slot) {
        return new Identifier(CyberpunkCybernetics.MOD_ID, "textures/models/texture.png");
    }
}

