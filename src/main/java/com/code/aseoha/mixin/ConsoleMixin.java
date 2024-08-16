package com.code.aseoha.mixin;

import com.code.aseoha.aseoha;
import net.tardis.mod.entity.TardisEntity;
import net.tardis.mod.tileentities.ConsoleTile;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import javax.annotation.Nullable;
import java.util.Objects;

@Mixin(ConsoleTile.class)
public abstract class ConsoleMixin {













//    protected ConsoleMixin(ConsoleTile aseoha$currConsole) {
//    }
//    @Shadow(remap = false) public abstract void removeControls();
//
//    @Shadow(remap = false) public abstract void getOrCreateControls();
//
//    @Shadow(remap = false) @Nullable public abstract TardisEntity getEntity();
//
//    @Unique
//    private ConsoleTile aseoha$prevConsole = Objects.requireNonNull(Objects.requireNonNull(this.getEntity()).getConsole());
//
//    @Inject(remap = false, method = "tick", at = @At("HEAD"))
//    private void tick(CallbackInfo info) {
//        if (Objects.requireNonNull(this.getEntity()).getConsole() != null) {
//            if (aseoha$prevConsole == null) aseoha$prevConsole = Objects.requireNonNull(this.getEntity()).getConsole();
//            if (Objects.requireNonNull(this.getEntity()).getConsole() != this.aseoha$prevConsole) {
//                this.removeControls();
//                this.getOrCreateControls();
//            }
//            this.aseoha$prevConsole = Objects.requireNonNull(this.getEntity()).getConsole();
//        }
//    }
}
