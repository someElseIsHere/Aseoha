package com.code.aseoha.tileentities;
//import com.google.common.base.Supplier;
//import com.mojang.datafixers.types.Type;
//import net.minecraft.block.Block;
//import net.minecraft.tileentity.TileEntity;
//import net.tardis.mod.blocks.TBlocks;
//import net.tardis.mod.blocks.TileBlock;
//import net.tardis.mod.tileentities.TTiles;
//import com.code.aseoha.aseoha;
//import com.code.aseoha.block.ModBlocks;
//import com.code.aseoha.tileentities.consoles.CopperConsoleTile;
//import net.minecraft.tileentity.TileEntityType;
//import net.minecraftforge.fml.RegistryObject;
//import net.minecraftforge.registries.DeferredRegister;
//import net.minecraftforge.registries.ForgeRegistries;
////import net.tardis.mod.tileentities.consoles.SteamConsoleTile;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class AseohaTiles {
//
//    public static List<TileEntityType<?>> TYPES = new ArrayList();
//    public static final DeferredRegister<TileEntityType<?>> TILES = TTiles.TILES;
//    public static final RegistryObject<TileEntityType<CopperConsoleTile>> CONSOLE_COPPER;
//
//
//    private static <T extends TileEntity> TileEntityType<T> registerTiles(Supplier<T> tile, Block... validBlock) {
//        TileEntityType<T> type = TileEntityType.Builder.of(tile, validBlock).build((Type) null);
//        Block[] var3 = validBlock;
//        int var4 = validBlock.length;
//
//        for (int var5 = 0; var5 < var4; ++var5) {
//            Block block = var3[var5];
//            if (block instanceof TileBlock) {
//                ((TileBlock) block).setTileEntity(type);
//            }
//        }
//
//        return type;
//    }
//
//    static {
//        CONSOLE_COPPER = TILES.register("console_copper", () -> {
//            return registerTiles(CopperConsoleTile::new, (Block) ModBlocks.console_copper.get());
//        });
////    public static final RegistryObject<TileEntityType<CopperConsoleTile>> console_copper =
////           TILES.register("console_copper", () -> TILES.register(CopperConsoleTile::new,
////                    ModBlocks.CONSOLE_COPPER.get()));
//    }
//}


import com.code.aseoha.aseoha;
import com.code.aseoha.block.ModBlocks;
import com.code.aseoha.tileentities.consoles.BrackolinConsoleTile;
import com.code.aseoha.tileentities.consoles.CopperConsoleTile;
import com.code.aseoha.tileentities.exteriors.*;
import com.google.common.base.Supplier;
import net.minecraft.block.Block;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.tardis.mod.blocks.TileBlock;

public class AseohaTiles {
    public static final DeferredRegister<TileEntityType<?>> TILES = DeferredRegister.create(ForgeRegistries.TILE_ENTITIES, aseoha.MODID);

    public static final RegistryObject<TileEntityType<CopperConsoleTile>> console_copper =
            TILES.register("console_copper", () ->registerTiles(CopperConsoleTile::new,
                    ModBlocks.console_copper.get()));


    public static RegistryObject<TileEntityType<CoralTile>> EXTERIOR_CORAL =
            TILES.register("exterior_coral", () -> registerTiles(CoralTile::new,
                    ModBlocks.EXTERIOR_CORAL.get()));


    public static RegistryObject<TileEntityType<CapaldiTile>> exterior_capaldi =
            TILES.register("exterior_capaldi", () -> registerTiles(CapaldiTile::new,
                    ModBlocks.exterior_capaldi.get()));

    //WhoviansRest

    //Exteriors
    public static RegistryObject<TileEntityType<WardrobeTile>> exterior_wardrobe =
            TILES.register("exterior_wardrobe", () -> registerTiles(WardrobeTile::new,
                    ModBlocks.exterior_wardrobe.get()));

    public static RegistryObject<TileEntityType<RaniTile>> exterior_rani =
            TILES.register("exterior_rani", () -> registerTiles(RaniTile::new,
                    ModBlocks.exterior_rani.get()));

    public static RegistryObject<TileEntityType<OlwarriorTile>> exterior_olwarrior =
            TILES.register("exterior_olwarrior", () -> registerTiles(OlwarriorTile::new,
                    ModBlocks.exterior_olwarrior.get()));

    public static RegistryObject<TileEntityType<BlueDoctorTile>> exterior_bluedoctor =
            TILES.register("exterior_bluedoctor", () -> registerTiles(BlueDoctorTile::new,
                    ModBlocks.exterior_bluedoctor.get()));

    public static RegistryObject<TileEntityType<BrackolinTile>> exterior_brackolin =
            TILES.register("exterior_brackolin", () -> registerTiles(BrackolinTile::new,
                    ModBlocks.exterior_brackolin.get()));

    public static RegistryObject<TileEntityType<AlfieHudolinTile>> exterior_alfiehudolin =
            TILES.register("exterior_alfiehudolin", () -> registerTiles(AlfieHudolinTile::new,
                    ModBlocks.exterior_alfiehudolin.get()));

    public static RegistryObject<TileEntityType<Hartnell112Tile>> exterior_classic_hartnell =
            TILES.register("exterior_classic_hartnell", () -> registerTiles(Hartnell112Tile::new,
                    ModBlocks.exterior_classic_hartnell.get()));

    //Consoles
    public static final RegistryObject<TileEntityType<BrackolinConsoleTile>> console_brackolin =
            TILES.register("console_brackolin", () ->registerTiles(BrackolinConsoleTile::new,
                    ModBlocks.console_brackolin.get()));

    private static <T extends TileEntity> TileEntityType<T> registerTiles(Supplier<T> tile, Block... validBlock) {
        TileEntityType<T> type = TileEntityType.Builder.of(tile, validBlock).build(null);

        for (Block block : validBlock) {
            if (block instanceof TileBlock) {
                ((TileBlock) block).setTileEntity(type);
            }
        }

        return type;
    }

}

