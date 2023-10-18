package com.derpz.cyberpunkcybernetics.sound

import com.derpz.cyberpunkcybernetics.CyberpunkCybernetics
import com.derpz.cyberpunkcybernetics.CyberpunkCybernetics.Companion.LOGGER
import net.minecraft.registry.Registries
import net.minecraft.registry.Registry
import net.minecraft.sound.SoundEvent
import net.minecraft.util.Identifier

object ModSounds {
    val DEBUG_SOUND = registerSoundEvent("debug")
    private fun registerSoundEvent(name: String): SoundEvent {
        val id = Identifier(CyberpunkCybernetics.MOD_ID, name)
        return Registry.register(Registries.SOUND_EVENT, id, SoundEvent.of(id))
    }

    fun registerSounds() {
        // CyberpunkCybernetics.LOGGER.info("Registering Sounds for " + CyberpunkCybernetics.MOD_ID);
        LOGGER.info("Registering Sounds for " + CyberpunkCybernetics.MOD_ID)
    }
}
