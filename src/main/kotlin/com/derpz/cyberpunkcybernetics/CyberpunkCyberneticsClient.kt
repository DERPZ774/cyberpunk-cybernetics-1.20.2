package com.derpz.cyberpunkcybernetics

import networking.ModMessages
import net.fabricmc.api.ClientModInitializer

class CyberpunkCyberneticsClient : ClientModInitializer {
    override fun onInitializeClient() {
        ModMessages.registerS2CPackets()
    }
}
