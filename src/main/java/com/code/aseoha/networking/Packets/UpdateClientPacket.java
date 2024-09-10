package com.code.aseoha.networking.Packets;

import net.minecraft.network.PacketBuffer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.fml.network.NetworkEvent;
import net.tardis.mod.helper.TardisHelper;
import net.tardis.mod.helper.WorldHelper;
import net.tardis.mod.tileentities.ConsoleTile;
import net.tardis.mod.world.dimensions.TDimensions;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;
import java.util.function.Supplier;

public class UpdateClientPacket {
    public ResourceLocation console;
    public int Coord;
    public Byte Axis;

    /**
     * Used for setting X, Y, or Z coord
     * @param console The ResourceLocation of the consoletile of the TARDIS that will have the coords set
     */
    public UpdateClientPacket(ResourceLocation console) {
        this.console = console;
    }

    public static void encode(@NotNull UpdateClientPacket mes, @NotNull PacketBuffer buffer) {
        buffer.writeResourceLocation(mes.console);
    }

    @NotNull
    @Contract("_ -> new")
    public static UpdateClientPacket decode(@NotNull PacketBuffer buffer) {
        return new UpdateClientPacket(buffer.readResourceLocation());
    }

    public static void handle(UpdateClientPacket mes, @NotNull Supplier<NetworkEvent.Context> ctx) {
        ((NetworkEvent.Context) ctx.get()).enqueueWork(() -> {
            ServerWorld world = Objects.requireNonNull(((NetworkEvent.Context) ctx.get()).getSender()).getLevel();
            if (WorldHelper.areDimensionTypesSame(world, TDimensions.DimensionTypes.TARDIS_TYPE)) {
                TileEntity te = world.getBlockEntity(TardisHelper.TARDIS_POS);
                if (te instanceof ConsoleTile) {
                    if (((ConsoleTile) te) != null) {
                        ((ConsoleTile) te).updateClient();
                    }
                }
            }
        });
        ((NetworkEvent.Context) ctx.get()).setPacketHandled(true);
    }


}