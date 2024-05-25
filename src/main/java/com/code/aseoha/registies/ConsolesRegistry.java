//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.code.aseoha.registies;

import java.util.function.Supplier;

import com.code.aseoha.aseoha;
import com.code.aseoha.block.ModBlocks;
import net.minecraft.block.Block;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.RegistryBuilder;
import net.tardis.mod.misc.Console;
import net.tardis.mod.registries.ConsoleRegistry;

import static net.tardis.mod.registries.ConsoleRegistry.CONSOLES;

//public class ConsolesRegistry {
    //public static final DeferredRegister<com.code.aseoha.misc.Console> CONSOLES = DeferredRegister.create(Console.class, "aseoha");
    //public static Supplier<IForgeRegistry<com.code.aseoha.misc.Console>> CONSOLE_REGISTRY;

//}



//public static final DeferredRegister<com.code.aseoha.misc.Console> CONSOLES = DeferredRegister.create(Console.class, "aseoha");
//public static Supplier<IForgeRegistry<com.code.aseoha.misc.Console>> CONSOLE_REGISTRY;
//public static final RegistryObject<com.code.aseoha.misc.Console> COPPER;
//
//public ConsolesRegistry() {
//}
//
//static {
//    CONSOLE_REGISTRY = CONSOLES.makeRegistry("console", () -> {
//        return (new RegistryBuilder()).setMaxID(2147483646);
//    });
//    COPPER = CONSOLES.register("copper", () -> {
//        return new Console(() -> {
//            return ((Block)ModBlocks.console_copper.get()).defaultBlockState();
//        }, "console");
//    });
//}
public class ConsolesRegistry {
    public static final DeferredRegister<Console> CONSOLES = DeferredRegister.create(net.tardis.mod.misc.Console.class, aseoha.MODID);

    public static final RegistryObject<com.code.aseoha.misc.Console> COPPER = CONSOLES.register("copper",
            () -> new com.code.aseoha.misc.Console(() -> ModBlocks.console_copper.get().defaultBlockState(), "copperconsole"));
}
