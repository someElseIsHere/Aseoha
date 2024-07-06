package com.code.aseoha.mixin;

import com.code.aseoha.aseoha;
import com.code.aseoha.tileentities.consoles.CopperConsoleTile;
import net.minecraft.entity.EntitySize;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.vector.Vector3d;
import net.tardis.mod.Tardis;
import net.tardis.mod.controls.BaseControl;
import net.tardis.mod.controls.HandbrakeControl;
import net.tardis.mod.controls.ThrottleControl;
import net.tardis.mod.entity.ControlEntity;
import net.tardis.mod.misc.CrashTypes;
import net.tardis.mod.registries.ControlRegistry;
import net.tardis.mod.sounds.TSounds;
import net.tardis.mod.tileentities.ConsoleTile;
import net.tardis.mod.tileentities.consoles.*;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(HandbrakeControl.class)
public class HandbrakeMixin extends BaseControl {
    @Shadow(remap = false)
    public static final ResourceLocation SAVE_KEY = new ResourceLocation("tardis", "handbrake_data");
    @Shadow(remap = false)
    private boolean isFree = false;

    public HandbrakeMixin(ControlRegistry.ControlEntry entry, ConsoleTile console, ControlEntity entity) {
        super(entry, console, entity);
    }
@Shadow(remap = false)
    public EntitySize getSize() {
        if (this.getConsole() instanceof NemoConsoleTile) {
            return EntitySize.scalable(0.1875F, 0.1875F);
        } else if (this.getConsole() instanceof GalvanicConsoleTile) {
            return EntitySize.scalable(0.1875F, 0.1875F);
        } else if (this.getConsole() instanceof CoralConsoleTile) {
            return EntitySize.scalable(0.1875F, 0.1875F);
        } else if (this.getConsole() instanceof HartnellConsoleTile) {
            return EntitySize.scalable(0.1875F, 0.1875F);
        } else if (this.getConsole() instanceof XionConsoleTile) {
            return EntitySize.scalable(0.1875F, 0.1875F);
        } else if (this.getConsole() instanceof ToyotaConsoleTile) {
            return EntitySize.scalable(0.1875F, 0.1875F);
        } else if (this.getConsole() instanceof NeutronConsoleTile) {
            return EntitySize.scalable(0.25F, 0.25F);
        } else {
            return this.getConsole() instanceof KeltConsoleTile ? EntitySize.scalable(0.1875F, 0.1875F) : EntitySize.scalable(0.1875F, 0.1875F);
        }
    }
@Shadow(remap = false)
    public Vector3d getPos() {
        if (this.getConsole() instanceof NemoConsoleTile) {
            return new Vector3d(-0.125, 0.5, -0.8125);
        } else if (this.getConsole() instanceof GalvanicConsoleTile) {
            return new Vector3d(-0.2982304929003854, 0.375, 0.8465142260574359);
        } else if (this.getConsole() instanceof CoralConsoleTile) {
            return new Vector3d(-0.7203601993321677, 0.5625, -0.3625);
        } else if (this.getConsole() instanceof HartnellConsoleTile) {
            return new Vector3d(-0.059, 0.375, 0.774);
        } else if (this.getConsole() instanceof ToyotaConsoleTile) {
            return new Vector3d(-0.206, 0.375, 0.768);
        } else if (this.getConsole() instanceof XionConsoleTile) {
            return new Vector3d(-1.127392157437948, 0.1875, -0.0012375564178497278);
        } else if (this.getConsole() instanceof NeutronConsoleTile) {
            return new Vector3d(-1.1546022251848151, 0.59375, -0.00377360907123081);
        } else {
            return this.getConsole() instanceof KeltConsoleTile ? new Vector3d(0.4691775280536088, 0.375, 1.0251364745327698) : new Vector3d(0.31798977635472236, 0.48749999701976776, 0.9024203281819716);
        }
    }

    public void deserializeNBT(CompoundNBT tag) {
        this.isFree = tag.getBoolean("free");
    }

    public CompoundNBT serializeNBT() {
        CompoundNBT tag = new CompoundNBT();
        tag.putBoolean("free", this.isFree);
        return tag;
    }

    /**
     * @author Me
     * @reason OnRightClickFunction
     */
    @Overwrite(remap = false)
    public boolean onRightClicked(ConsoleTile console, PlayerEntity player) {
//        aseoha.LOGGER.info("CLICK!");
        if (console != null && console.hasLevel()) {
            if (!console.getLevel().isClientSide()) {
                this.isFree = !this.isFree;

                console.getControl(ThrottleControl.class).ifPresent((throttle) -> {
                            if (console.isInFlight() && !this.isFree && throttle.getAmount() != 0F) {
                                console.crash(CrashTypes.DEFAULT);
                            }
                        });
                console.getControl(ThrottleControl.class).ifPresent((throttle) -> {
                    if (throttle.getAmount() > 0.0F && this.isFree()) {
                        console.takeoff();
                    }

                });
                this.markDirty();
            }

            return true;
        } else {
            return false;
        }
    }
    @Shadow(remap = false)
    public SoundEvent getFailSound(ConsoleTile console) {
        return (SoundEvent) TSounds.SINGLE_CLOISTER.get();
    }
    @Shadow(remap = false)
    public SoundEvent getSuccessSound(ConsoleTile console) {
        return this.isFree() ? (SoundEvent)TSounds.HANDBRAKE_RELEASE.get() : (SoundEvent)TSounds.HANDBRAKE_ENGAGE.get();
    }
    @Shadow(remap = false)
    public boolean isFree() {
        return this.isFree;
    }
    @Shadow(remap = false)
    public void setFree(boolean free) {
        this.isFree = free;
        this.markDirty();
    }
    @Shadow(remap = false)
    public ResourceLocation getAdditionalDataSaveKey() {
        return SAVE_KEY;
    }
    @Shadow(remap = false)
    public void setConsole(ConsoleTile console, ControlEntity entity) {
        super.setConsole(console, entity);
        console.registerDataHandler(SAVE_KEY, this);
    }
}
