//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.code.aseoha.client;

import com.code.aseoha.aseoha;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class Sounds {
    public static final DeferredRegister<SoundEvent> SOUNDS = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, aseoha.MODID);
    public static final RegistryObject<SoundEvent> LOW_ARTRON_TAKEOFF = SOUNDS.register("distorted_takeoff", () -> {
        return setupSound("distorted_takeoff");

    });
    public static final RegistryObject<SoundEvent> MAJESTIC_TALE = SOUNDS.register("majestic_tale", () -> {
        return setupSound("majestic_tale");

    });

    public Sounds() {
    }

    private static SoundEvent setupSound(String soundName) {
        return new SoundEvent(new ResourceLocation("aseoha", soundName));
    }
}
