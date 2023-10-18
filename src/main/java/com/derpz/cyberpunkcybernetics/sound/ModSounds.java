package com.derpz.cyberpunkcybernetics.sound;

import com.derpz.cyberpunkcybernetics.CyberpunkCybernetics;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;

public class ModSounds {
    public static final SoundEvent DEBUG_SOUND = registerSoundEvent("debug");
    private static SoundEvent registerSoundEvent(String name) {
        Identifier id = new Identifier(CyberpunkCybernetics.MOD_ID, name);
        return Registry.register(Registries.SOUND_EVENT, id, SoundEvent.of(id));
    }
    public static void registerSounds() {
       // CyberpunkCybernetics.LOGGER.info("Registering Sounds for " + CyberpunkCybernetics.MOD_ID);
        CyberpunkCybernetics.Companion.getLOGGER().info("Registering Sounds for " + CyberpunkCybernetics.MOD_ID);
    }
}
