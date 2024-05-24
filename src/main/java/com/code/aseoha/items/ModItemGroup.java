package com.code.aseoha.items;

import com.code.aseoha.block.ModBlocks;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class ModItemGroup {
    public static final ItemGroup ASEOHA_GROUP = new ItemGroup("aseoha") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ModBlocks.HELLBENT_ROUNDEL1.get());
        }
    };

    public static final ItemGroup ASEOHA_FOOD_GROUP = new ItemGroup("aseoha_food") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ModItems.GOLDEN_POTATO.get());
        }
    };
}