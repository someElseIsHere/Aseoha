////
//// Source code recreated from a .class file by IntelliJ IDEA
//// (powered by FernFlower decompiler)
////
//
//package com.code.aseoha.mixin;
//
//import com.code.aseoha.aseoha;
//import corgitaco.shutupexperimentalsettings.ShutupExperimentalSettings;
//import net.minecraft.client.Minecraft;
//import org.spongepowered.asm.mixin.Mixin;
//import org.spongepowered.asm.mixin.Overwrite;
//import org.spongepowered.asm.mixin.Shadow;
//import org.spongepowered.asm.mixin.injection.At;
//import org.spongepowered.asm.mixin.injection.ModifyVariable;
//
//@Mixin({Minecraft.class})
//public class FUExperimental {
//    public FUExperimental() {
//    }
//
//    @ModifyVariable(
//            method = {"func_238195_a_(Ljava/lang/String;Lnet/minecraft/util/registry/DynamicRegistries$Impl;Ljava/util/function/Function;Lcom/mojang/datafixers/util/Function4;ZLnet/minecraft/client/Minecraft$WorldSelectionType;)V"},
//            at = @At(
//                    value = "FIELD",
//                    target = "Lnet/minecraft/client/Minecraft$WorldSelectionType;NONE:Lnet/minecraft/client/Minecraft$WorldSelectionType;",
//                    ordinal = 0
//            ),
//            ordinal = 2,
//            index = 11,
//            name = {"flag2"},
//            require = 1
//    )
//    private boolean replaceflag2(boolean flag2) {
//        aseoha.LOGGER.info("Shutup!!!");
//        return false;
//    }
//}
