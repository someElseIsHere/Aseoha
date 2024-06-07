package com.code.aseoha.items;
import com.code.aseoha.items.ModItemGroup;
import net.minecraft.item.*;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import static com.code.aseoha.aseoha.MODID;

public class ModItems{
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, MODID);

public static final RegistryObject<Item> GOLDEN_POTATO = ITEMS.register("golden_potato",
        () -> new Item((new Item.Properties()).food(new Food.Builder().nutrition(9).saturationMod(2).effect(() -> new EffectInstance(Effects.FIRE_RESISTANCE, 1200, 0), 1.0F).alwaysEat().build()).tab(ModItemGroup.ASEOHA_FOOD_GROUP).rarity(Rarity.EPIC).fireResistant()));

public static final RegistryObject<Item> TWINKIE = ITEMS.register("twinkie",
        () -> new Item(new Item.Properties().food(new Food.Builder().nutrition(4).saturationMod(0.7f).fast().build()).tab(ModItemGroup.ASEOHA_FOOD_GROUP)));

    public static final RegistryObject<Item> TEZARAK_COIN = ITEMS.register("tezarak_coin",
            ()-> new Item(new Item.Properties().tab(ModItemGroup.ASEOHA_GROUP).stacksTo(16).rarity(Rarity.RARE).fireResistant()));



    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }


}