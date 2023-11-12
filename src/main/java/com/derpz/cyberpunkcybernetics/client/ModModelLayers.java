package com.derpz.cyberpunkcybernetics.client;

import com.derpz.cyberpunkcybernetics.CyberpunkCybernetics;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.util.Identifier;

public class ModModelLayers {
    public static final EntityModelLayer SANDEVISTAN =
            new EntityModelLayer(new Identifier(CyberpunkCybernetics.MOD_ID, "sandevistan"), "main");

    public static final EntityModelLayer VERTEBRAE =
            new EntityModelLayer(new Identifier(CyberpunkCybernetics.MOD_ID, "vertebrae"), "main");

}
