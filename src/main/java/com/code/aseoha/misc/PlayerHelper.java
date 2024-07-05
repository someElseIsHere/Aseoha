package com.code.aseoha.misc;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.minecraft.util.IItemProvider;

public class PlayerHelper {
    public static void decreaseExp(PlayerEntity player, int amount) {
        player.giveExperiencePoints(-amount);
    }
    public static void increaseExp(PlayerEntity player, int amount){
        player.giveExperiencePoints(amount);
    }
    public static void giveItemStack(PlayerEntity player, IItemProvider item, int amount){
        player.addItem(new ItemStack(item, amount));
    }
    public static void removeItemInHand(PlayerEntity player, Hand hand, int amount){
        ItemStack itemstack = player.getItemInHand(hand);
        itemstack.shrink(amount);
    }
}
