package com.code.aseoha.block;

import com.code.aseoha.items.ModItemGroup;
import com.code.aseoha.items.ModItems;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import net.tardis.api.events.DimensionLightMapModificationEvent;
import net.tardis.mod.ars.IARS;
import net.tardis.mod.blocks.RoundelBlock;
import net.tardis.mod.itemgroups.TItemGroups;
import net.tardis.mod.properties.TardisBlockProperties;

import java.util.function.Supplier;
import java.util.function.ToIntFunction;

import static com.code.aseoha.aseoha.MODID;

public class ModBlocks {
    public static ToIntFunction<BlockState> maxLightLevel = BlockState -> 15;

    public static final DeferredRegister<Block> BLOCKS
            = DeferredRegister.create(ForgeRegistries.BLOCKS, MODID);


    /*****************************  ROUNDELS  **********************************/

    public static final RegistryObject<Block> HELLBENT_ROUNDEL1 = registerBlock("hb_roundel01",
            () -> {
                return (net.tardis.mod.blocks.RoundelBlock) setUpBlock(new RoundelBlock(AbstractBlock.Properties.of(Material.STONE), SoundType.STONE, 1.25F, 4.2F));
            });

    public static final RegistryObject<Block> HELLBENT_ROUNDEL2 = registerBlock("hb_roundel02",
            () -> {
                return (net.tardis.mod.blocks.RoundelBlock) setUpBlock(new RoundelBlock(AbstractBlock.Properties.of(Material.STONE), SoundType.STONE, 1.25F, 4.2F));
            });

    public static final RegistryObject<Block> HELLBENT_ROUNDEL3 = registerBlock("hb_roundel03",
            () -> {
                return (net.tardis.mod.blocks.RoundelBlock) setUpBlock(new RoundelBlock(AbstractBlock.Properties.of(Material.STONE), SoundType.STONE, 1.25F, 4.2F));
            });

    public static final RegistryObject<Block> COPPER_ROUNDEL = registerBlock("copper_roundel",
            () -> {
                return (net.tardis.mod.blocks.RoundelBlock) setUpBlock(new RoundelBlock(AbstractBlock.Properties.of(Material.STONE), SoundType.STONE, 1.25F, 4.2F));
            });

    public static final RegistryObject<Block> ORANGE_TERRACOTTA_ROUNDEL = registerBlock("orange_terracotta_roundel",
            () -> {
                return (net.tardis.mod.blocks.RoundelBlock) setUpBlock(new RoundelBlock(AbstractBlock.Properties.of(Material.STONE), SoundType.STONE, 1.25F, 4.2F));
            });

    public static final RegistryObject<Block> ORANGE_TERRACOTTA_ROUNDEL_HALF = registerBlock("orange_terracotta_roundel_half",
            () -> {
                return (net.tardis.mod.blocks.RoundelBlock) setUpBlock(new RoundelBlock(AbstractBlock.Properties.of(Material.STONE), SoundType.STONE, 1.25F, 4.2F));
            });


    /**********************************  LEGACY NTM ROUNDELS  ********************************/


    public static final RegistryObject<Block> MEGLOS_ROUNDEL1 = registerBlock("mg_roundel1",
            () -> {
                return (net.tardis.mod.blocks.RoundelBlock) setUpBlock(new RoundelBlock(AbstractBlock.Properties.of(Material.STONE), SoundType.STONE, 1.25F, 4.2F));
            });

    public static final RegistryObject<Block> MEGLOS_ROUNDEL2 = registerBlock("mg_roundel2",
            () -> {
                return (net.tardis.mod.blocks.RoundelBlock) setUpBlock(new RoundelBlock(AbstractBlock.Properties.of(Material.STONE), SoundType.STONE, 1.25F, 4.2F));
            });

    public static final RegistryObject<Block> MEGLOS_ROUNDEL3 = registerBlock("mg_roundel3",
            () -> {
                return (net.tardis.mod.blocks.RoundelBlock) setUpBlock(new RoundelBlock(AbstractBlock.Properties.of(Material.STONE), SoundType.STONE, 1.25F, 4.2F));
            });

    public static final RegistryObject<Block> MEGLOS_ROUNDEL4 = registerBlock("mg_roundel4",
            () -> {
                return (net.tardis.mod.blocks.RoundelBlock) setUpBlock(new RoundelBlock(AbstractBlock.Properties.of(Material.STONE), SoundType.STONE, 1.25F, 4.2F));
            });

    public static final RegistryObject<Block> MEGLOS_ROUNDEL5 = registerBlock("mg_roundel5",
            () -> {
                return (net.tardis.mod.blocks.RoundelBlock) setUpBlock(new RoundelBlock(AbstractBlock.Properties.of(Material.STONE), SoundType.STONE, 1.25F, 4.2F));
            });


    /*****************************  MISC  *************************************/
    public static final RegistryObject<Block> FAULTLOCATOR = registerBlock("faultlocator",
            () -> {
                return (net.tardis.mod.blocks.RoundelBlock) setUpBlock(new RoundelBlock(AbstractBlock.Properties.of(Material.STONE), SoundType.STONE, 1.25F, 4.2F));
            });

    public static final RegistryObject<Block> FAULTLOCATOR_S = registerBlock("faultlocator_s",
            () -> {
                return (net.tardis.mod.blocks.RoundelBlock) setUpBlock(new RoundelBlock(AbstractBlock.Properties.of(Material.STONE), SoundType.STONE, 1.25F, 4.2F));
            });

    public static final RegistryObject<Block> COATRACK = registerBlock("coatrack",
            () -> new Block(AbstractBlock.Properties.of(Material.STONE)
                    .noCollission()));

    public static final RegistryObject<Block> COPPER_COLUMN = registerBlock("copper_column",
            () -> new Block(AbstractBlock.Properties.of(Material.STONE)
                    .noOcclusion()));

    public static final RegistryObject<Block> COPPER_COLUMN_TOP = registerBlock("copper_column_top",
            () -> new Block(AbstractBlock.Properties.of(Material.STONE)
                    .noOcclusion()));



    public static final RegistryObject<Block> TOASTER = registerBlock("toaster",
            () -> new Block(AbstractBlock.Properties.of(Material.STONE)
                    .noOcclusion()));

    /*****************************  LEGACY NTM  *************************/

    public static final RegistryObject<Block> HELLBENT_POLE = registerBlock("hb_pole",
            () -> new Block(AbstractBlock.Properties.of(Material.STONE)
                    .noOcclusion()
                    .noCollission()));

    public static final RegistryObject<Block> HELLBENT_HEX = registerBlock("hb_hex",
            () -> {
                return (net.tardis.mod.blocks.RoundelBlock) setUpBlock(new RoundelBlock(AbstractBlock.Properties.of(Material.STONE), SoundType.STONE, 1.25F, 4.2F));
            });

    public static final RegistryObject<Block> HELLBENT_GLASS01 = registerBlock("hb_glass01",
            () -> new Block(AbstractBlock.Properties.of(Material.STONE)));

    public static final RegistryObject<Block> HELLBENT_GLASS02 = registerBlock("hb_glass02",
            () -> new Block(AbstractBlock.Properties.of(Material.STONE)));

    public static final RegistryObject<Block> HELLBENT_GLASS03 = registerBlock("hb_glass03",
            () -> new Block(AbstractBlock.Properties.of(Material.STONE)));

    public static final RegistryObject<Block> HELLBENT_GLASS04 = registerBlock("hb_glass04",
            () -> new Block(AbstractBlock.Properties.of(Material.STONE)));

    public static final RegistryObject<Block> HELLBENT_GLASS05 = registerBlock("hb_glass05",
            () -> new Block(AbstractBlock.Properties.of(Material.STONE)));

    public static final RegistryObject<Block> HELLBENT_GLASS06 = registerBlock("hb_glass06",
            () -> new Block(AbstractBlock.Properties.of(Material.STONE)));

    public static final RegistryObject<Block> HELLBENT_GLASS07 = registerBlock("hb_glass07",
            () -> new Block(AbstractBlock.Properties.of(Material.STONE)));

    public static final RegistryObject<Block> HELLBENT_GLASS08 = registerBlock("hb_glass08",
            () -> new Block(AbstractBlock.Properties.of(Material.STONE)));

    public static final RegistryObject<Block> HELLBENT_VENT = registerBlock("hb_vent",
            () -> {
                return (net.tardis.mod.blocks.RoundelBlock) setUpBlock(new RoundelBlock(AbstractBlock.Properties.of(Material.STONE), SoundType.STONE, 1.25F, 4.2F));
            });

    public static final RegistryObject<Block> HELLBENT_FLOOR = registerBlock("hb_floor",
            () -> new Block(AbstractBlock.Properties.of(Material.STONE)));

    public static final RegistryObject<Block> HELLBENT_WALL = registerBlock("hb_wall",
            () -> new Block(AbstractBlock.Properties.of(Material.STONE)));

    public static final RegistryObject<Block> HELLBENT_WALLSILVER = registerBlock("hb_wallsilver",
            () -> new Block(AbstractBlock.Properties.of(Material.STONE)));

    public static final RegistryObject<Block> MEGLOS_BLANK = registerBlock("mg_blank",
            () -> new Block(AbstractBlock.Properties.of(Material.STONE)));

    public static final RegistryObject<Block> MEGLOS_BLANK_WALL = registerBlock("mg_blank_wall",
            () -> new Block(AbstractBlock.Properties.of(Material.STONE)));

    public static final RegistryObject<Block> MEGLOS_FLOOR = registerBlock("mg_floor",
            () -> new Block(AbstractBlock.Properties.of(Material.STONE)));

    /************************CONSOLES**********************/


    public static final RegistryObject<Block> console_copper = registerBlock("console_copper", () -> {
        return setUpBlock(new ConsoleBlock());//return (ConsoleBlock) setUpBlock(new ConsoleBlock());
    });
            //registerBlock("console_copper",
//            () -> new net.tardis.mod.blocks.ConsoleBlock());


private static Block setUpBlock(Block block){return block;}
    //private static <T extends Block> T setUpBlock(T block) {
    //    return block;
    //}


    private static <T extends Block>RegistryObject<T> registerBlock(String name, Supplier<T> block){
                RegistryObject<T> toReturn = BLOCKS.register(name, block);
                registerBlockItem(name, toReturn);
                return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, RegistryObject<T> block) {
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(),
        new Item.Properties().tab(ModItemGroup.ASEOHA_GROUP)));
    }

    public static void register(IEventBus eventBus){
    BLOCKS.register(eventBus);
    }
}
