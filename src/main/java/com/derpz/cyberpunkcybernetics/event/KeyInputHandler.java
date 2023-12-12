package com.derpz.cyberpunkcybernetics.event;

import com.derpz.cyberpunkcybernetics.item.ModItems;
import com.derpz.cyberpunkcybernetics.item.custom.Sandevistan;
import com.derpz.cyberpunkcybernetics.networking.ModMessages;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import net.minecraft.entity.EquipmentSlot;
import org.lwjgl.glfw.GLFW;

public class KeyInputHandler {
    public static final String KEY_CATEGORY_CYBERPUNK = "key.category.cyberpunk-cybernetics";
    public static final String KEY_SANDEVISTAN = "key.cyberpunk-cybernetics.sandevistan";

    public static KeyBinding sandevistanKey;

    public static void registerKeyInputs() {
        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            if (sandevistanKey.wasPressed()) {
                assert client.player != null;
                if (client.player.getEquippedStack(EquipmentSlot.CHEST) == ModItems.SANDEVISTAN.getDefaultStack()) {
                    assert client.player != null;
                    //client.player.sendMessage(Text.of("BOMBA"));
                    ClientPlayNetworking.send(ModMessages.SANDEVISTAN_ID, PacketByteBufs.create());
                }
            }
        });
    }

    public static void register() {
        sandevistanKey = KeyBindingHelper.registerKeyBinding(new KeyBinding(
                KEY_SANDEVISTAN,
                InputUtil.Type.KEYSYM,
                GLFW.GLFW_KEY_G,
                KEY_CATEGORY_CYBERPUNK
        ));
        registerKeyInputs();
    }

}
