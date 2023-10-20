package com.derpz.cyberpunkcybernetics.item

import com.derpz.cyberpunkcybernetics.CyberpunkCybernetics
import com.derpz.cyberpunkcybernetics.CyberpunkCybernetics.Companion.LOGGER
import com.derpz.cyberpunkcybernetics.item.custom.SandevistanItem
import net.fabricmc.fabric.api.item.v1.FabricItemSettings
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents
import net.minecraft.item.ArmorItem
import net.minecraft.item.Item
import net.minecraft.item.ItemGroups
import net.minecraft.registry.Registries
import net.minecraft.registry.Registry
import net.minecraft.util.Identifier

object ModItems {
    //Cyberware
    @JvmField
    val SANDEVISTAN = registerItem("sandevistan", ArmorItem(ModArmorMaterials.CYBERWARE, ArmorItem.Type.CHESTPLATE, FabricItemSettings()))
    val DEBUG = registerItem("debug", Item(FabricItemSettings()))
    private fun addItemToArmorTab(entries: FabricItemGroupEntries) {
        entries.add(SANDEVISTAN)
        /// TODO: 10/2/2023 Redo with for loop to add to custom tab
    }

    private fun registerItem(name: String, item: Item): Item {
        return Registry.register(Registries.ITEM, Identifier(CyberpunkCybernetics.MOD_ID, name), item)
    }

    fun registerModItems() {
        // CyberpunkCybernetics.LOGGER.info("Registering Mod Items for " + CyberpunkCybernetics.MOD_ID);
        LOGGER.info("Registering Mod Items for " + CyberpunkCybernetics.MOD_ID)
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register { entries ->
            addItemToArmorTab(entries)
        }

    }

    fun getAllModItems(): Collection<Item> {
        val modItems: MutableList<Item> = ArrayList()
        val fields = ModItems::class.java.getDeclaredFields()
        for (field in fields) {
            if (Item::class.java.isAssignableFrom(field.type)) {
                try {
                    modItems.add(field[null] as Item)
                } catch (e: IllegalAccessException) {
                    e.printStackTrace()
                }
            }
        }
        return modItems
    }
}