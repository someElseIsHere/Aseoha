package com.code.aseoha.mixin;

import com.code.aseoha.block.ModBlocks;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.tardis.mod.blocks.TBlocks;
import net.tardis.mod.blocks.exteriors.TardisExteriorBottomBlock;
import net.tardis.mod.itemgroups.TItemGroups;
import net.tardis.mod.items.TItems;
import net.tardis.mod.properties.Prop;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;

import java.util.function.Supplier;
import java.util.function.ToIntFunction;

@Mixin(TBlocks.class)
public class TBlocksMixin {
    private TBlocksMixin(){
    }


    @Mutable @Final @Shadow(remap = false) public static final DeferredRegister<Block> BLOCKS;
    @Mutable @Final @Shadow(remap = false) public static final RegistryObject<Block> bottom_exterior;

    @Shadow(remap = false) private static <T extends Block> T setUpBlock(T block) {
        return block;
    }

    @Shadow(remap = false) private static <T extends Block> RegistryObject<T> register(String id, Supplier<T> blockSupplier, ItemGroup itemGroup) {
        RegistryObject<T> registryObject = BLOCKS.register(id, blockSupplier);
        TItems.ITEMS.register(id, () -> {
            return new BlockItem((Block)registryObject.get(), (new Item.Properties()).tab(itemGroup));
        });
        return registryObject;
    }

    @Shadow(remap = false) private static <T extends Block> RegistryObject<T> registerBlockOnly(String id, Supplier<T> blockSupplier) {
        RegistryObject<T> registryObject = BLOCKS.register(id, blockSupplier);
        return registryObject;
    }

    @Shadow(remap = false) private static <T extends Block> RegistryObject<T> register(String id, Supplier<T> blockSupplier) {
        RegistryObject<T> registryObject = BLOCKS.register(id, blockSupplier);
        TItems.ITEMS.register(id, () -> {
            return new BlockItem((Block)registryObject.get(), (new Item.Properties()).tab(TItemGroups.FUTURE));
        });
        return registryObject;
    }

    @Shadow(remap = false) private static <T extends Block> RegistryObject<T> register(String id, Supplier<T> blockSupplier, boolean hasItem) {
        RegistryObject<T> registryObject = BLOCKS.register(id, blockSupplier);
        if (hasItem) {
            TItems.ITEMS.register(id, () -> {
                return new BlockItem((Block)registryObject.get(), (new Item.Properties()).tab(TItemGroups.FUTURE));
            });
        }

        return registryObject;
    }

    @Shadow(remap = false) private static ToIntFunction<BlockState> getLightValueLit(int lightValue) {
        return (state) -> {
            return (Boolean)state.getValue(BlockStateProperties.LIT) ? lightValue : 0;
        };
    }



    static{
        BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, "tardis");

        bottom_exterior = register("bottom_exterior", () -> {
            return (TardisExteriorBottomBlock)setUpBlock(new TardisExteriorBottomBlock((AbstractBlock.Properties) Prop.Blocks.UNBREAKABLE.get().lightLevel(ModBlocks.maxLightLevel)));
        }, false);
    }

}
