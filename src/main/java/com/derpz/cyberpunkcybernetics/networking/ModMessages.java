package com.derpz.cyberpunkcybernetics.networking;

import com.derpz.cyberpunkcybernetics.CyberpunkCybernetics;
import com.derpz.cyberpunkcybernetics.networking.client.SandevistanC2S;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.util.Identifier;

public class ModMessages {
    public static final Identifier SANDEVISTAN_ID = new Identifier(CyberpunkCybernetics.MOD_ID, "sandevistan");

    public static void registerC2SPackets() {
        ServerPlayNetworking.registerGlobalReceiver(SANDEVISTAN_ID, SandevistanC2S::receive);
    }

    public static void registerS2CPackets() {

    }
}
