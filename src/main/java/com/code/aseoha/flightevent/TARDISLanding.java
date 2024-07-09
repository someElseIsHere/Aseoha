package com.code.aseoha.flightevent;

import com.google.common.collect.Lists;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundCategory;
import net.tardis.mod.flight.FlightEvent;
import net.tardis.mod.flight.FlightEventFactory;
import net.tardis.mod.misc.CrashTypes;
import net.tardis.mod.registries.ControlRegistry;
import net.tardis.mod.sounds.TSounds;
import net.tardis.mod.tileentities.ConsoleTile;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;


public class TARDISLanding extends FlightEvent {

    public TARDISLanding(FlightEventFactory entry, List<ResourceLocation> controls) {
        super(entry, controls);
    }

    public static final Supplier<ArrayList<ResourceLocation>> CONTROLS = () -> Lists.newArrayList(

            ControlRegistry.FAST_RETURN.get().getRegistryName(),
            ControlRegistry.THROTTLE.get().getRegistryName(),
            ControlRegistry.FACING.get().getRegistryName()
    );

    @Override
    public boolean onComplete(ConsoleTile tile) {
        boolean success = super.onComplete(tile);
        if(success) {
            tile.updateClient();
        }
        return success;
    }


    @Override
    public void onMiss(ConsoleTile tile) {
        super.onMiss(tile);
        tile.getLevel().playSound(null, tile.getBlockPos(), TSounds.CANT_START.get(), SoundCategory.PLAYERS, 1F, 1F);
        tile.damage(150F);
        tile.crash(CrashTypes.DEFAULT);
        tile.updateClient();
        tile.getInteriorManager().setAlarmOn(true);
    }

}
