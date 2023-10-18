package com.derpz.cyberpunkcybernetics.item;

import com.derpz.cyberpunkcybernetics.CyberpunkCybernetics;
import com.derpz.cyberpunkcybernetics.item.custom.SandevistanItem;
import net.fabricmc.fabric.api.item.v1.FabricItem;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ModItems {
    //Cyberware
    public static final Item SANDEVISTAN = registerItem("sandevistan", new SandevistanItem(new FabricItemSettings()));
    public static final Item DEBUG = registerItem("debug", new Item(new FabricItemSettings()));

    private static void addItemToArmorTab(FabricItemGroupEntries entries) {
        entries.add(SANDEVISTAN);
        /// TODO: 10/2/2023 Redo with for loop to add to custom tab
    }
    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(CyberpunkCybernetics.MOD_ID, name), item);
    }
    public static void registerModItems() {
       // CyberpunkCybernetics.LOGGER.info("Registering Mod Items for " + CyberpunkCybernetics.MOD_ID);
        CyberpunkCybernetics.Companion.getLOGGER().info("Registering Mod Items for " + CyberpunkCybernetics.MOD_ID);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register(ModItems::addItemToArmorTab);
    }
    public static Collection<Item> getAllModItems() {
        List<Item> modItems = new ArrayList<>();
        Field[] fields = ModItems.class.getDeclaredFields();
        for (Field field : fields) {
            if (Item.class.isAssignableFrom(field.getType())) {
                try {
                    modItems.add((Item) field.get(null));
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
        return modItems;
    }
}
