package com.code.aseoha.tileentities;
import com.google.common.base.Supplier;
import com.mojang.datafixers.types.Type;
import net.minecraft.block.Block;
import net.minecraft.tileentity.TileEntity;
import net.tardis.mod.blocks.TBlocks;
import net.tardis.mod.blocks.TileBlock;
import net.tardis.mod.tileentities.TTiles;
import com.code.aseoha.aseoha;
import com.code.aseoha.block.ModBlocks;
import com.code.aseoha.tileentities.consoles.CopperConsoleTile;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.tardis.mod.tileentities.consoles.SteamConsoleTile;

import java.util.ArrayList;
import java.util.List;

public class AseohaTiles {

    public static List<TileEntityType<?>> TYPES = new ArrayList();
    public static final DeferredRegister<TileEntityType<?>> TILES = TTiles.TILES;
    public static final RegistryObject<TileEntityType<CopperConsoleTile>> CONSOLE_COPPER;


    private static <T extends TileEntity> TileEntityType<T> registerTiles(Supplier<T> tile, Block... validBlock) {
        TileEntityType<T> type = TileEntityType.Builder.of(tile, validBlock).build((Type) null);
        Block[] var3 = validBlock;
        int var4 = validBlock.length;

        for (int var5 = 0; var5 < var4; ++var5) {
            Block block = var3[var5];
            if (block instanceof TileBlock) {
                ((TileBlock) block).setTileEntity(type);
            }
        }

        return type;
    }

    static {
        CONSOLE_COPPER = TILES.register("console_copper", () -> {
            return registerTiles(CopperConsoleTile::new, (Block) ModBlocks.console_copper.get());
        });
//    public static final RegistryObject<TileEntityType<CopperConsoleTile>> console_copper =
//           TILES.register("console_copper", () -> TILES.register(CopperConsoleTile::new,
//                    ModBlocks.CONSOLE_COPPER.get()));
    }
}