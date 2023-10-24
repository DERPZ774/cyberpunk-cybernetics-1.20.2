package com.derpz.cyberpunkcybernetics.client.model;

import com.derpz.cyberpunkcybernetics.CyberpunkCybernetics;
import net.minecraft.client.model.TexturedModelData;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.util.Identifier;

import java.util.function.BiConsumer;

public class ModModels {
    public static final EntityModelLayer SANDEVISTAN = model("sandevistan");


    public static void init(BiConsumer<EntityModelLayer, TexturedModelData> consumer) {
        consumer.accept(SANDEVISTAN, TexturedModelData.of(SandevistanModel.getModelData(), 64, 32));
    }

    /* Shoutouts to Noaaan for this implementation (i also borrowed his comment shouting out williewillus from the same class):
     * https://github.com/Noaaan/MythicMetals/blob/1.20/src/main/java/nourl/mythicmetals/client/models/MythicModelHandler.java
     */
    public static EntityModelLayer model(String name, String layer) {
        var result = new EntityModelLayer(new Identifier(CyberpunkCybernetics.MOD_ID, name), layer);
        //EntityModelLayersAccessor.getLAYERS().add(result);
        return result;
    }

    public static EntityModelLayer model(String name) {
        return model(name, "main");
    }
}
