//package com.code.aseoha.entities;

import net.minecraft.entity.EntityType;
import net.minecraft.util.RegistryKey;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biomes;
import net.minecraft.world.biome.MobSpawnInfo;
import net.minecraftforge.common.world.MobSpawnInfoBuilder;
import net.minecraftforge.event.world.BiomeLoadingEvent;

import java.util.Arrays;
import java.util.List;

//public class ModEntityGeneration {
//    public static void onEntitySpawn(final BiomeLoadingEvent event) {
////        addEntityToAllBiomes(event.getSpawns(), ModEntityTypes.BUFF_ZOMBIE.get(), 40, 2, 4);
////        addEntityToAllBiomesExceptThese(event, ModEntityTypes.PIGEON.get(), 50, 4, 10,
////                Biomes.PLAINS, Biomes.BEACH, Biomes.BIRCH_FOREST);
//    }

//    private static void addEntityToAllBiomesExceptThese(BiomeLoadingEvent event, EntityType<?> type,
//                                                        int weight, int minCount, int maxCount, RegistryKey<Biome>... biomes) {
//        // Goes through each entry in the biomes and sees if it matches the current biome we are loading
//        boolean isBiomeSelected = Arrays.stream(biomes).map(RegistryKey::getLocation)
//                .map(Object::toString).anyMatch(s -> s.equals(event.getName().toString()));
//
//        if(!isBiomeSelected) {
//            addEntityToAllBiomes(event.getSpawns(), type, weight, minCount, maxCount);
//        }
//    }

//    private static void addEntityToSpecificBiomes(BiomeLoadingEvent event, EntityType<?> type,
//                                                  int weight, int minCount, int maxCount, RegistryKey<Biome>... biomes) {
//        // Goes through each entry in the biomes and sees if it matches the current biome we are loading
//        boolean isBiomeSelected = Arrays.stream(biomes).map(RegistryKey::getLocation)
//                .map(Object::toString).anyMatch(s -> s.equals(event.getName().toString()));
//
//        if(isBiomeSelected) {
//            addEntityToAllBiomes(event.getSpawns(), type, weight, minCount, maxCount);
//        }
//    }

//    private static void addEntityToAllBiomes(MobSpawnInfoBuilder spawns, EntityType<?> type,
////                                             int weight, int minCount, int maxCount) {
////        List<MobSpawnInfo.Spawners> base = spawns.getSpawner(type.getDescription());
////        base.add(new MobSpawnInfo.Spawners(type,weight, minCount, maxCount));
//    }
//}