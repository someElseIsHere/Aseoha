//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.code.aseoha.registries;

import com.code.aseoha.aseoha;
import com.code.aseoha.block.ModBlocks;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.tardis.mod.misc.Console;

public class ConsolesRegistry {
    public static final DeferredRegister<Console> CONSOLES = DeferredRegister.create(net.tardis.mod.misc.Console.class, aseoha.MODID);

    public static final RegistryObject<com.code.aseoha.misc.Console> COPPER =
            CONSOLES.register("copper", () -> new com.code.aseoha.misc.Console(() -> ModBlocks.console_copper.get().defaultBlockState(), "copperconsole"));

    public static final RegistryObject<com.code.aseoha.misc.Console> BATTLE =
            CONSOLES.register("battle", () -> new com.code.aseoha.misc.Console(() -> ModBlocks.console_battle.get().defaultBlockState(), "battleconsole"));

    public static final RegistryObject<com.code.aseoha.misc.Console> BRACKOLIN =
            CONSOLES.register("brackolin", ()-> new com.code.aseoha.misc.Console(() -> ModBlocks.console_brackolin.get().defaultBlockState(),"brackolinconsole"));

//    public static final RegistryObject<com.code.aseoha.misc.Console> TAKOMAK =
//            CONSOLES.register("takomak", ()-> new com.code.aseoha.misc.Console(() -> ModBlocks.console_takomak.get().defaultBlockState(),"takomakconsole"));
}
