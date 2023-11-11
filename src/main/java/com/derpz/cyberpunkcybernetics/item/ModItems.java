package com.derpz.cyberpunkcybernetics.item;

import com.derpz.cyberpunkcybernetics.CyberpunkCybernetics;
import com.derpz.cyberpunkcybernetics.item.custom.SandevistanArmorItem;
import net.fabricmc.fabric.api.item.v1.FabricItem;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ModItems {
    // Cyberware
    public static final Item SANDEVISTAN = registerItem("sandevistan", new SandevistanArmorItem(ModArmorMaterials.CYBERWARE, ArmorItem.Type.CHESTPLATE, new FabricItemSettings()));
    public static final Item DEBUG = registerItem("debug", new Item(new FabricItemSettings()));

    // Add more mod items here

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(CyberpunkCybernetics.MOD_ID, name), item);
    }

    public static void registerModItems() {
        CyberpunkCybernetics.LOGGER.info("Registering Mod Items for " + CyberpunkCybernetics.MOD_ID);
    }

    // Use reflection to get all mod items
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
