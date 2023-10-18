package com.derpz.cyberpunkcybernetics.item

import com.derpz.cyberpunkcybernetics.CyberpunkCybernetics
import com.derpz.cyberpunkcybernetics.CyberpunkCybernetics.Companion.LOGGER
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup
import net.minecraft.item.ItemGroup
import net.minecraft.item.ItemStack
import net.minecraft.registry.Registries
import net.minecraft.registry.Registry
import net.minecraft.text.Text
import net.minecraft.util.Identifier

object ModItemGroups {
    val CYBERWARE_GROUP = Registry.register<ItemGroup, ItemGroup>(
        Registries.ITEM_GROUP,
        Identifier(CyberpunkCybernetics.MOD_ID, "cyberware"),
        FabricItemGroup.builder()
            .displayName(Text.translatable("itemgroup.cyberware"))
            .icon { ItemStack(ModItems.SANDEVISTAN) }
            .entries { displayContext: ItemGroup.DisplayContext?, entries: ItemGroup.Entries ->
                for (item in ModItems.getAllModItems()) {
                    entries.add { ItemStack(item).item }
                }
            }
            .build())

    fun registerItemGroups() {
        // CyberpunkCybernetics.LOGGER.info("Registering Item Groups for " + CyberpunkCybernetics.MOD_ID);
        LOGGER.info("Registering Item Groups for " + CyberpunkCybernetics.MOD_ID)
    }
}
