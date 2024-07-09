package com.code.aseoha.items;
import com.code.aseoha.aseoha;
import com.code.aseoha.client.Sounds;
import com.code.aseoha.entities.ModEntityTypes;
import com.code.aseoha.items.ModItemGroup;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.NetherPortalBlock;
import net.minecraft.block.material.Material;
import net.minecraft.item.*;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.tardis.mod.constants.TardisConstants;
import net.tardis.mod.entity.TEntities;
import net.tardis.mod.items.SonicItem;
import net.tardis.mod.items.TardisPartItem;
import org.apache.logging.log4j.core.util.Loader;

import java.util.function.Supplier;

import static com.code.aseoha.aseoha.MODID;

public class ModItems{
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, MODID);

    public static final RegistryObject<Item> HADS = ITEMS.register("upgrades/hads", () -> {
        return (TardisPartItem)createItem(new TardisPartItem((new Item.Properties()).tab(ModItemGroup.ASEOHA_GROUP), TardisConstants.Part.PartType.UPGRADE, false, false, TardisConstants.Translations.DEMAT_CIRCUIT));
    });

    public static final RegistryObject<Item> ENGINE_BOOSTER = ITEMS.register("upgrades/engine_booster", () -> {
        return (TardisPartItem)createItem(new TardisPartItem((new Item.Properties()).tab(ModItemGroup.ASEOHA_GROUP), TardisConstants.Part.PartType.UPGRADE, false, false, TardisConstants.Translations.DEMAT_CIRCUIT));
    });

    public static final RegistryObject<SpawnEggs> K9_SPAWN_EGG = ITEMS.register("k9_spawn_egg",
            () -> new SpawnEggs(ModEntityTypes.K9, 0x879995, 0x576ABC,
                    new Item.Properties().tab(ModItemGroup.ASEOHA_GROUP)));

    public static final RegistryObject<SpawnEggs> WALLE_SPAWN_EGG = ITEMS.register("walle_spawn_egg",
            () -> new SpawnEggs(ModEntityTypes.WALLE, 0xFF871D, 0xFF800F,
                    new Item.Properties().tab(ModItemGroup.ASEOHA_GROUP)));

//    public static final RegistryObject<BlockItem> PORTAL_ITEM = ITEMS.register("portal",
//            () -> new NetherPortalBlock())
    public static final RegistryObject<deadLocker> DEADLOCKER = ITEMS.register("deadlocker",
            () -> new deadLocker());

//    if(aseoha.){}
//    public static final RegistryObject<unDeadLocker> UNDEADLOCKER = ITEMS.register("undeadlocker",
//            () -> new unDeadLocker());

    public static final RegistryObject<SpawnEggs> BESSIE_SPAWN_EGG = ITEMS.register("bessie_spawn_egg",
            () -> new SpawnEggs(TEntities.BESSIE, 0xFF871D, 0x999999,
                    new Item.Properties().tab(ModItemGroup.ASEOHA_GROUP)));

    public static final RegistryObject<Item> GOLDEN_POTATO = ITEMS.register("golden_potato",
            () -> new Item((new Item.Properties()).food(new Food.Builder().nutrition(9).saturationMod(2).effect(() -> new EffectInstance(Effects.FIRE_RESISTANCE, 1200, 0), 1.0F).alwaysEat().build()).tab(ModItemGroup.ASEOHA_FOOD_GROUP).rarity(Rarity.EPIC).fireResistant()));

    public static final RegistryObject<Item> sonic_fourteenth = ITEMS.register("sonic_fourteenth",
            () -> new SonicItem());

    public static final RegistryObject<Item> TWINKIE = ITEMS.register("twinkie",
        () -> new Item(new Item.Properties().food(new Food.Builder().nutrition(4).saturationMod(0.7f).fast().build()).tab(ModItemGroup.ASEOHA_FOOD_GROUP)));

    public static final RegistryObject<Item> TEZARAK_COIN = ITEMS.register("tezarak_coin",
            ()-> new Item(new Item.Properties().tab(ModItemGroup.ASEOHA_GROUP).stacksTo(16).rarity(Rarity.RARE).fireResistant()));

    public static final RegistryObject<Item> CONTROL_MOLD = ITEMS.register("control_mold",
            ()-> new Item(new Item.Properties().tab(ModItemGroup.ASEOHA_GROUP).stacksTo(1).rarity(Rarity.UNCOMMON)));

    public static final RegistryObject<Item> MAJESTIC_TALE_DISC = ITEMS.register("majestic_tale_disc",
            () -> new MusicDiscItem(1, () -> Sounds.MAJESTIC_TALE.get(), new Item.Properties().stacksTo(1).tab(ModItemGroup.ASEOHA_GROUP)));

//    public static final RegistryObject<Item> SONIC_LASER = ITEMS.register("sonic_laser",
//            ()-> new );

    public static <T extends Item> T createItem(T item) {
        return item;
    }
    public static void register(IEventBus eventBus){ITEMS.register(eventBus);}


}