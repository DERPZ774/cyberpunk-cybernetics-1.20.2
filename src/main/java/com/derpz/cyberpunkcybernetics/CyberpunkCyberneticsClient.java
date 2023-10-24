package com.derpz.cyberpunkcybernetics;

import com.derpz.cyberpunkcybernetics.event.KeyInputHandler;
import net.fabricmc.api.ClientModInitializer;
import com.derpz.cyberpunkcybernetics.networking.ModMessages;

public class CyberpunkCyberneticsClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        KeyInputHandler.register();
        ModMessages.registerS2CPackets();
    }
}
