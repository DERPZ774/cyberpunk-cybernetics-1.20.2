package com.derpz.cyberpunkcybernetics.item;

import com.derpz.cyberpunkcybernetics.CyberpunkCybernetics;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {
    public static final ItemGroup CYBERWARE_GROUP = Registry.register(Registries.ITEM_GROUP,
            new Identifier(CyberpunkCybernetics.MOD_ID, "cyberware"),
            FabricItemGroup.builder()
                    .displayName(Text.translatable("itemgroup.cyberware"))
                    .icon(() -> new ItemStack(ModItems.SANDEVISTAN))
                    .entries((displayContext, entries) -> {
                        for (Item item : ModItems.getAllModItems()) {
                            entries.add(() -> new ItemStack(item).getItem());
                        }
                    })
                    .build());
    public static void registerItemGroups() {
        CyberpunkCybernetics.LOGGER.info("Registering Item Groups for " + CyberpunkCybernetics.MOD_ID);

    }
}
