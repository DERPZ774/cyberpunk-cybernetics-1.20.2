package com.derpz.cyberpunkcybernetics.item;

import com.derpz.cyberpunkcybernetics.CyberpunkCybernetics;
import net.fabricmc.fabric.api.item.v1.FabricItem;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {
    //Cyberware
    public static final Item SANDEVISTAN = registerItem("sandevistan", new Item(new FabricItemSettings()));

    private static void addItemToArmorTab(FabricItemGroupEntries entries) {
        entries.add(SANDEVISTAN);
    }
    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(CyberpunkCybernetics.MOD_ID, name), item);
    }
    public static void registerModItems() {

        CyberpunkCybernetics.LOGGER.info("Registering Mod Items for " + CyberpunkCybernetics.MOD_ID);
    }

//todo item group event
}
