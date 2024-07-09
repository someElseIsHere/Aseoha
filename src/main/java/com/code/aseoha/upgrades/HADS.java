package com.code.aseoha.upgrades;

import java.util.Objects;
import java.util.Random;

import java.util.Random;

import com.code.aseoha.aseoha;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.mistersecret312.temporal_api.events.ComponentEvent;
import net.mistersecret312.temporal_api.events.FlightEventEvent;
import net.tardis.mod.controls.StabilizerControl;
import net.tardis.mod.controls.ThrottleControl;
import net.tardis.mod.misc.ITickable;
import net.tardis.mod.subsystem.StabilizerSubsystem;
import net.tardis.mod.subsystem.Subsystem;
import net.tardis.mod.tileentities.ConsoleTile;
import net.tardis.mod.tileentities.console.misc.IAlarmType;
import net.tardis.mod.upgrades.Upgrade;
import net.tardis.mod.upgrades.UpgradeEntry;


public class HADS extends Upgrade implements ITickable {
    public Random random;

    public HADS(UpgradeEntry entry, ConsoleTile tile, Class<? extends Subsystem> clazz) {
        super(entry, tile, clazz);
        tile.registerTicker(this);
        this.random = new Random();
    }
//public boolean isActive = this.isActivated();
public static boolean hadsActivate(ConsoleTile console) {
    final boolean HADSACTIVE = console.getInteriorManager().isAlarmOn() && !console.isCrashing();
    console.getUpgrade(HADS.class).ifPresent((hads) -> {
        if(hads.isActivated()){
            if(HADSACTIVE) {
//                onEventPopup()
                if (!Objects.requireNonNull(console.getLevel()).isClientSide) {
                    console.getSubsystem(StabilizerSubsystem.class).ifPresent((stab) -> {
                        stab.setControlActivated(false);
                    });
                }
                console.takeoff();
                if(console.flightTicks == 12000){
                    console.initLand();
                    console.getInteriorManager().setAlarmOn(false);
                }
            }
        }
    });
    return HADSACTIVE;
}



    public static void deactivateHADS(ConsoleTile console) {
        console.getUpgrade(HADS.class).ifPresent((hads) -> {
            if(hads.isActivated()){
                console.initLand();
                console.getInteriorManager().setAlarmOn(false);
            }
        });
    }

    public void tick(ConsoleTile console) {
        hadsActivate(console);
    }

    public void onLand() {
    }

    public void onTakeoff() {
//        this.getConsole().getControl(ThrottleControl.class).ifPresent((control) -> {
//            if (control.getAmount() == 1.0F && this.isUsable() && this.isActivated()) {
//                this.getConsole().func_145831_w().func_184133_a((PlayerEntity)null, this.getConsole().func_174877_v(), (SoundEvent)RegSoundEvents.ENGINE_BOOST_START.get(), SoundCategory.PLAYERS, 0.5F, 1.0F);
//            }
//
//        });
    }

    public void onFlightSecond() {
//        if (this.random.nextInt(100) == 90) {
//            this.getConsole().func_145831_w().func_184133_a((PlayerEntity)null, this.getConsole().func_174877_v(), (SoundEvent)RegSoundEvents.VORTEX_AMBIENT_LOOP2.get(), SoundCategory.PLAYERS, 0.5F, 1.0F);
//        }
//
    }
}
