package com.code.aseoha.items;
import com.code.aseoha.items.ModItemGroup;
import net.minecraft.item.Food;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import static com.code.aseoha.aseoha.MODID;

public class ModItems{
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, MODID);
//
//    public static final RegistryObject<Item> GOLDEN_POTATO = ITEMS.register("golden_potato",
//            () -> new Item(new Item.Properties().tab(ModItemGroup.ASEOHA_GROUP)));
//
//    public static final RegistryObject<Item> GOLDEN_POTATO = ITEMS.register("golden_potato",
//            () -> new Item(new Item.Properties()
//                    .food(new Food.Builder().hunger(1).saturation(0.1f).fastToEat().build())
//                    .tab(ModItemGroup.ASEOHA_GROUP))));
public static final RegistryObject<Item> GOLDEN_POTATO = ITEMS.register("golden_potato",
            () -> new Item(new Item.Properties()
                    .food(new Food.Builder().nutrition(9).saturationMod(1)
                            .build()).tab(ModItemGroup.ASEOHA_FOOD_GROUP).fireResistant()));

public static final RegistryObject<Item> TWINKIE = ITEMS.register("twinkie",
        () -> new Item(new Item.Properties()
                .food(new Food.Builder().nutrition(4).saturationMod(0.7f).fast()
                        .build()).tab(ModItemGroup.ASEOHA_FOOD_GROUP)));



    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }


}