package com.derpz.cyberpunkcybernetics.item.custom

import net.minecraft.item.Item

class SandevistanItem(settings: Settings?) : Item(settings) {
    companion object {
        private const val MAX_DURATION = 600 // Maximum duration in ticks (30 seconds at 20 ticks per second)
    }
}
