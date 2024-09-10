package com.code.aseoha.entities;

import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import com.code.aseoha.aseoha;

public class ModEntityTypes {
    public static DeferredRegister<EntityType<?>> ENTITY_TYPES
            = DeferredRegister.create(ForgeRegistries.ENTITIES, aseoha.MODID);

    public static final RegistryObject<EntityType<k9>> K9 =
            ENTITY_TYPES.register("k9",
                    () -> EntityType.Builder.of(k9::new,
                                    EntityClassification.MISC).sized(1.0f, 1.0f)
                            .build(new ResourceLocation(aseoha.MODID, "k9").toString()));


    public static final RegistryObject<EntityType<Walle>> WALLE =
            ENTITY_TYPES.register("walle",
                    () -> EntityType.Builder.of(Walle::new,
                                    EntityClassification.MISC).sized(1.0f, 1.0f)
                            .build(new ResourceLocation(aseoha.MODID, "walle").toString()));

    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }
}