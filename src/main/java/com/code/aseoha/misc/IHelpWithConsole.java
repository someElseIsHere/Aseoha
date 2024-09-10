package com.code.aseoha.misc;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.World;
import net.tardis.mod.entity.TardisEntity;
import net.tardis.mod.tileentities.ConsoleTile;

public interface IHelpWithConsole {
//    List<RegistryKey<World>> getAvailable();
    boolean Aseoha$GetHads();

    void Aseoha$SetHads(boolean state);

    boolean Aseoha$GetMaintenance();

    void Aseoha$SetMaintenance(boolean maintenance);

    int Aseoha$GetExteriorSize();

    void Aseoha$SetExteriorSize(int aseoha$ExteriorSize);

    void Aseoha$Ride(PlayerEntity Player);

    void Aseoha$StopRide(boolean stop);

    void Aseoha$CleanupRide();

    TardisEntity Aseoha$GetTardisEntity();

    void Aseoha$SetInteriorDimension(World interiorDimension);

    ConsoleTile Aseoha$GetConsole();
    World Aseoha$GetInteriorDimension();

    boolean Aseoha$IsRealWorldFlight();

    void Aseoha$SetRealWorldFlight(boolean rwf);
}