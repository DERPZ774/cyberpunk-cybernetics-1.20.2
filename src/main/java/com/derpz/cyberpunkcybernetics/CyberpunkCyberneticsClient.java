package com.derpz.cyberpunkcybernetics;

import com.derpz.cyberpunkcybernetics.client.ModModelLayers;
import com.derpz.cyberpunkcybernetics.client.models.SandevistanModel;
import com.derpz.cyberpunkcybernetics.event.KeyInputHandler;
import com.derpz.cyberpunkcybernetics.networking.ModMessages;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;

public class CyberpunkCyberneticsClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        KeyInputHandler.register();
        EntityModelLayerRegistry.registerModelLayer(ModModelLayers.SANDEVISTAN, SandevistanModel::getTexturedModelData);
        ModMessages.registerS2CPackets();
    }

}
