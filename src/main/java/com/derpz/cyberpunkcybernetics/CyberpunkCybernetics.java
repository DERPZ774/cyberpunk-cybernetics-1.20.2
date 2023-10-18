package com.derpz.cyberpunkcybernetics;


import com.derpz.cyberpunkcybernetics.item.ModItemGroups;
import com.derpz.cyberpunkcybernetics.item.ModItems;
import com.derpz.cyberpunkcybernetics.sandevistan.SandevistanEffectHandler;
import com.derpz.cyberpunkcybernetics.sound.ModSounds;
import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CyberpunkCybernetics implements ModInitializer {
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.

	public static final String MOD_ID = "cyberpunk-cybernetics";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

		LOGGER.info("Hello Fabric world!");
		ModItemGroups.registerItemGroups();
		ModItems.registerModItems();
		SandevistanEffectHandler.registerEventHandlers();
		ModSounds.registerSounds();
	}
}