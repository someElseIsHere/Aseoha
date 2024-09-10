package com.code.aseoha.networking.Packets;

import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.PacketBuffer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.concurrent.TickDelayedTask;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.fml.network.NetworkEvent;
import net.minecraftforge.registries.IForgeRegistry;
import net.tardis.mod.constants.TardisConstants;
import net.tardis.mod.controls.HandbrakeControl;
import net.tardis.mod.helper.TardisHelper;
import net.tardis.mod.helper.WorldHelper;
import net.tardis.mod.misc.Console;
import net.tardis.mod.registries.ConsoleRegistry;
import net.tardis.mod.subsystem.StabilizerSubsystem;
import net.tardis.mod.tileentities.ConsoleTile;
import net.tardis.mod.world.dimensions.TDimensions;

import java.util.Objects;
import java.util.function.Supplier;

public class ToggleLocks {
    public ResourceLocation console;

    public ToggleLocks(ResourceLocation console) {
        this.console = console;
    }

    public static void encode(ToggleLocks mes, PacketBuffer buffer) {
        buffer.writeResourceLocation(mes.console);
    }

    public static ToggleLocks decode(PacketBuffer buffer) {
        return new ToggleLocks(buffer.readResourceLocation());
    }

    public static void handle(ToggleLocks mes, Supplier<NetworkEvent.Context> ctx) {
        ((NetworkEvent.Context) ctx.get()).enqueueWork(() -> {
            ServerWorld world = Objects.requireNonNull(((NetworkEvent.Context) ctx.get()).getSender()).getLevel();
            if (WorldHelper.areDimensionTypesSame(world, TDimensions.DimensionTypes.TARDIS_TYPE)) {
                TileEntity te = world.getBlockEntity(TardisHelper.TARDIS_POS);
                if (te instanceof ConsoleTile) {
                    ConsoleTile consoleTile = (ConsoleTile) te;
//                    Console console = (Console)((IForgeRegistry) ConsoleRegistry.CONSOLE_REGISTRY.get()).getValue(mes.console);
                    consoleTile.getDoor().ifPresent((door) -> door.setLocked(!door.isLocked()));
                }
            }

        });
        ((NetworkEvent.Context) ctx.get()).setPacketHandled(true);
    }


}