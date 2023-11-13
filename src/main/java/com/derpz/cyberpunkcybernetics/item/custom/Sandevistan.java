package com.derpz.cyberpunkcybernetics.item.custom;

import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.*;

public class Sandevistan extends Item implements Equipment {

    public Sandevistan(Settings settings) {
        super(settings);
    }
    @Override
    public EquipmentSlot getSlotType() {
        return EquipmentSlot.CHEST;
    }


}

