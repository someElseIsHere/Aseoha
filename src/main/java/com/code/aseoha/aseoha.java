package com.code.aseoha;
import com.code.aseoha.block.ModBlocks;
import com.code.aseoha.client.Sounds;
import com.code.aseoha.client.renderers.blocks.TardisCoralRenderer;
import com.code.aseoha.client.renderers.blocks.UpsideDownEngineRenderer;
import com.code.aseoha.client.renderers.console.*;
import com.code.aseoha.commands.Commands;
import com.code.aseoha.entities.ModEntityTypes;
import com.code.aseoha.items.ModItems;
import com.code.aseoha.client.renderers.k9render;
import com.code.aseoha.client.renderers.wallerender;
import com.code.aseoha.items.NoTadditionsItems;
import com.code.aseoha.networking.Networking;
import com.code.aseoha.protocol.RegisterProtocols;
import com.code.aseoha.registries.ConsolesRegistry;
import com.code.aseoha.registries.ExteriorsRegistry;
import com.code.aseoha.registries.RegisterFlightEvent;
import com.code.aseoha.registries.SoundSchemeRegister;
import com.code.aseoha.tileentities.AseohaTiles;
import com.code.aseoha.upgrades.RegisterUpgrades;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.event.lifecycle.InterModProcessEvent;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.stream.Collectors;

/**
 * @author Codiak
 * <br />
 * Why? Because I did
 */
@Mod("aseoha")
public class aseoha {
    public static final String MODID = "aseoha";
    // Directly reference a log4j logger.
    public static final Logger LOGGER = LogManager.getLogger();

    public aseoha() {

        // Register the setup method for modloading
        IEventBus modBus = FMLJavaModLoadingContext.get().getModEventBus();
        STStructures.DEFERRED_REGISTRY_STRUCTURE.register(modBus);
        ExteriorsRegistry.EXTERIORS.register(modBus);
//        ModelRegistry.Register(eventBus);
        ModBlocks.register(modBus);
        ModItems.register(modBus);
        if (!(ModList.get().isLoaded("tadditions")))
            NoTadditionsItems.register(modBus);
        //ConsolesRegistry.CONSOLES.register(modBus);
        RegisterProtocols.PROTOCOLSREGISTER.register(modBus);
        ConsolesRegistry.CONSOLES.register(modBus);
        AseohaTiles.TILES.register(modBus);
        Sounds.SOUNDS.register(modBus);
        ModEntityTypes.register(modBus);
        RegisterFlightEvent.FLIGHT_EVENTS.register(modBus);
        RegisterUpgrades.UPGRADES.register(modBus);
        SoundSchemeRegister.SOUND_SCHEMES.register(modBus);

        //ModBiomes.register(eventBus);
        // For events that happen after initialization. This is probably going to be use a lot.


        /*IEventBus forgeBus = MinecraftForge.EVENT_BUS;
        forgeBus.addListener(EventPriority.NORMAL, this::addDimensionalSpacing);


        // The comments for BiomeLoadingEvent and StructureSpawnListGatherEvent says to do HIGH for additions.
        forgeBus.addListener(EventPriority.HIGH, this::biomeModification);
        */


        modBus.addListener(this::setup);
        // Register the enqueueIMC method for modloading
        modBus.addListener(this::enqueueIMC);
        // Register the processIMC method for modloading
        modBus.addListener(this::processIMC);
        // Register the doClientStuff method for modloading
        modBus.addListener(this::doClientStuff);

        //NETWORKING
        Networking.init();

        //Register the Configs
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, config.COMMON_SPEC);
        ModLoadingContext.get().registerConfig(ModConfig.Type.SERVER, config.SERVER_SPEC);

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(final FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
            //Flight Event
            RegisterFlightEvent.registerRandomEntries();
            Commands.registerCustomArgumentTypes();
            //ModBiomeGeneration.generateBiomes();
            STStructures.setupStructures();
            STConfiguredStructures.registerConfiguredStructures();
        });
        // some preinit code
//        LOGGER.info("HELLO FROM PREINIT");
//        LOGGER.info("DIRT BLOCK >> {}", Blocks.DIRT.getRegistryName());
    }

    /*public void biomeModification(final BiomeLoadingEvent event) {
        /*
         * Add our structure to all biomes including other modded biomes.
         * You can skip or add only to certain biomes based on stuff like biome category,
         * temperature, scale, precipitation, mod id, etc. All kinds of options!
         *
         * You can even use the BiomeDictionary as well! To use BiomeDictionary, do
         * RegistryKey.getOrCreateKey(Registry.BIOME_KEY, event.getName()) to get the biome's
         * registrykey. Then that can be fed into the dictionary to get the biome's types.
         */
    /*
        if(Objects.requireNonNull(event.getName()).toString().equals("aseoha:newearth")){
            event.getGeneration().getStructures().add(() -> STConfiguredStructures.CONFIGURED_ROAD);
        }


    }*/
    private void doClientStuff(final FMLClientSetupEvent event) {
        // do something that can only be done on the client
//        LOGGER.info("Got game settings {}", event.getMinecraftSupplier().get().options);
        // do something that can only be done with blocks

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////// ROUNDELS/MISC
        RenderTypeLookup.setRenderLayer(ModBlocks.FAULTLOCATOR.get(), RenderType.cutout());
        RenderTypeLookup.setRenderLayer(ModBlocks.FAULTLOCATOR_S.get(), RenderType.cutout());
        RenderTypeLookup.setRenderLayer(ModBlocks.HELLBENT_GLASS01.get(), RenderType.solid());
        RenderTypeLookup.setRenderLayer(ModBlocks.HELLBENT_GLASS02.get(), RenderType.solid());
        RenderTypeLookup.setRenderLayer(ModBlocks.HELLBENT_GLASS03.get(), RenderType.solid());
        RenderTypeLookup.setRenderLayer(ModBlocks.HELLBENT_GLASS04.get(), RenderType.solid());
        RenderTypeLookup.setRenderLayer(ModBlocks.HELLBENT_GLASS05.get(), RenderType.solid());
        RenderTypeLookup.setRenderLayer(ModBlocks.HELLBENT_GLASS06.get(), RenderType.solid());
        RenderTypeLookup.setRenderLayer(ModBlocks.HELLBENT_GLASS07.get(), RenderType.solid());
        RenderTypeLookup.setRenderLayer(ModBlocks.HELLBENT_GLASS08.get(), RenderType.solid());
        RenderTypeLookup.setRenderLayer(ModBlocks.HELLBENT_HEX.get(), RenderType.cutout());
        RenderTypeLookup.setRenderLayer(ModBlocks.HELLBENT_VENT.get(), RenderType.solid());
        RenderTypeLookup.setRenderLayer(ModBlocks.HELLBENT_FLOOR.get(), RenderType.solid());
        RenderTypeLookup.setRenderLayer(ModBlocks.HELLBENT_ROUNDEL1.get(), RenderType.solid());
        RenderTypeLookup.setRenderLayer(ModBlocks.HELLBENT_ROUNDEL2.get(), RenderType.solid());
        RenderTypeLookup.setRenderLayer(ModBlocks.HELLBENT_ROUNDEL3.get(), RenderType.solid());
        RenderTypeLookup.setRenderLayer(ModBlocks.HELLBENT_WALL.get(), RenderType.solid());
        RenderTypeLookup.setRenderLayer(ModBlocks.HELLBENT_WALLSILVER.get(), RenderType.solid());
        RenderTypeLookup.setRenderLayer(ModBlocks.HELLBENT_POLE.get(), RenderType.cutout());
        RenderTypeLookup.setRenderLayer(ModBlocks.TOASTER.get(), RenderType.cutout());
//        RenderTypeLookup.setRenderLayer(ModBlocks.MEGLOS_BLANK.get(), RenderType.solid());
//        RenderTypeLookup.setRenderLayer(ModBlocks.MEGLOS_BLANK_WALL.get(), RenderType.solid());
//        RenderTypeLookup.setRenderLayer(ModBlocks.MEGLOS_FLOOR.get(), RenderType.solid());
        RenderTypeLookup.setRenderLayer(ModBlocks.MEGLOS_ROUNDEL1.get(), RenderType.solid());
        RenderTypeLookup.setRenderLayer(ModBlocks.MEGLOS_ROUNDEL2.get(), RenderType.solid());
        RenderTypeLookup.setRenderLayer(ModBlocks.MEGLOS_ROUNDEL3.get(), RenderType.solid());
        RenderTypeLookup.setRenderLayer(ModBlocks.MEGLOS_ROUNDEL4.get(), RenderType.solid());
        RenderTypeLookup.setRenderLayer(ModBlocks.MEGLOS_ROUNDEL5.get(), RenderType.solid());
        RenderTypeLookup.setRenderLayer(ModBlocks.COATRACK.get(), RenderType.cutout());
        RenderTypeLookup.setRenderLayer(ModBlocks.ORANGE_TERRACOTTA_ROUNDEL.get(), RenderType.solid());
        //RenderTypeLookup.setRenderLayer(ModBlocks.ORANGE_TERRACOTTA_ROUNDEL_HALF.get(), RenderType.solid());
//        RenderTypeLookup.setRenderLayer(ModBlocks.COPPER_COLUMN.get(), RenderType.translucent());
//        RenderTypeLookup.setRenderLayer(ModBlocks.COPPER_COLUMN_TOP.get(), RenderType.translucent());
        RenderTypeLookup.setRenderLayer(ModBlocks.COPPER_ROUNDEL.get(), RenderType.solid());
//        RenderTypeLookup.setRenderLayer(ModBlocks.LOOTCRATE.get(), RenderType.cutout());
//        RenderTypeLookup.setRenderLayer(ModBlocks.LOOTCRATEX.get(), RenderType.cutout());
        RenderTypeLookup.setRenderLayer(ModBlocks.BLUE_CRYSTAL.get(), RenderType.translucent());
        RenderTypeLookup.setRenderLayer(ModBlocks.OCHRE_FROGLIGHT.get(), RenderType.solid());
        RenderTypeLookup.setRenderLayer(ModBlocks.VERDANT_FROGLIGHT.get(), RenderType.solid());

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////// COOL BLOCKS
        RenderTypeLookup.setRenderLayer(ModBlocks.foodmachine_old.get(), RenderType.solid());
        RenderTypeLookup.setRenderLayer(ModBlocks.DIMENSIONAL_BUTTON.get(), RenderType.cutout());
        RenderTypeLookup.setRenderLayer(ModBlocks.FACING_CONTROL.get(), RenderType.cutout());
        RenderTypeLookup.setRenderLayer(ModBlocks.HANDBREAK_CONTROL.get(), RenderType.cutout());
        RenderTypeLookup.setRenderLayer(ModBlocks.INC_CONTROL.get(), RenderType.cutout());
        RenderTypeLookup.setRenderLayer(ModBlocks.RANDOMIZER_CONTROL.get(), RenderType.cutout());
        RenderTypeLookup.setRenderLayer(ModBlocks.REFUELER_CONTROL.get(), RenderType.cutout());
        RenderTypeLookup.setRenderLayer(ModBlocks.X_CONTROL.get(), RenderType.cutout());
        RenderTypeLookup.setRenderLayer(ModBlocks.Y_CONTROL.get(), RenderType.cutout());
        RenderTypeLookup.setRenderLayer(ModBlocks.Z_CONTROL.get(), RenderType.cutout());
//        RenderTypeLookup.setRenderLayer(ModBlocks.EOH.get(), RenderType.solid());
        RenderTypeLookup.setRenderLayer(ModBlocks.FLIGHT_BUTTON.get(), RenderType.solid());


        RenderTypeLookup.setRenderLayer(ModBlocks.AZALEA.get(), RenderType.cutout());
        RenderTypeLookup.setRenderLayer(ModBlocks.FLOWERING_AZALEA.get(), RenderType.cutout());
        RenderTypeLookup.setRenderLayer(ModBlocks.FLOWERING_AZALEA_LEAVES.get(), RenderType.cutoutMipped());
        RenderTypeLookup.setRenderLayer(ModBlocks.AZALEA_LEAVES.get(), RenderType.cutout());


//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////// CONSOLES

        RenderTypeLookup.setRenderLayer(ModBlocks.console_copper.get(), RenderType.translucent());
        ClientRegistry.bindTileEntityRenderer(AseohaTiles.console_copper.get(), CopperConsoleRenderer::new);

        RenderTypeLookup.setRenderLayer(ModBlocks.console_brackolin.get(), RenderType.translucent());
        ClientRegistry.bindTileEntityRenderer(AseohaTiles.console_brackolin.get(), BrackolinConsoleRender::new);

        RenderTypeLookup.setRenderLayer(ModBlocks.console_battle.get(), RenderType.translucent());
        ClientRegistry.bindTileEntityRenderer(AseohaTiles.console_battle.get(), BattleConsoleRender::new);

//        RenderTypeLookup.setRenderLayer(ModBlocks.console_takomak.get(), RenderType.translucent());
//        ClientRegistry.bindTileEntityRenderer(AseohaTiles.console_takomak.get(), TakomakConsoleRender::new);

        RenderTypeLookup.setRenderLayer(ModBlocks.console_bluemarble.get(), RenderType.translucent());
        ClientRegistry.bindTileEntityRenderer(AseohaTiles.console_bluemarble.get(), BlueMarbleRender::new);

        RenderTypeLookup.setRenderLayer(ModBlocks.console_hartnell.get(), RenderType.translucent());
        ClientRegistry.bindTileEntityRenderer(AseohaTiles.console_hartnell.get(), HartnellConsoleRender::new);

        RenderTypeLookup.setRenderLayer(ModBlocks.console_custard.get(), RenderType.translucent());
        ClientRegistry.bindTileEntityRenderer(AseohaTiles.console_custard.get(), CustardConsoleRenderer::new);

        RenderTypeLookup.setRenderLayer(ModBlocks.CORAL.get(), RenderType.translucent());
        ClientRegistry.bindTileEntityRenderer(AseohaTiles.TARDIS_CORAL.get(), TardisCoralRenderer::new);

//        RenderTypeLookup.setRenderLayer(ModBlocks.UPSIDEDOWN_ENGINE.get(), RenderType.translucent());
//        ClientRegistry.bindTileEntityRenderer(AseohaTiles.UPSIDEDOWN_ENGINE.get(), UpsideDownEngineRenderer::new);

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////// ENTITIES

        RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.K9.get(), k9render::new);
        RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.WALLE.get(), wallerender::new);

//        RenderingRegistry.registerEntityRenderingHandler(ModItems.PRYDONIAN_HELM.get(), wallerender::new);
    }

    private void enqueueIMC(final InterModEnqueueEvent event) {
        // some example code to dispatch IMC to another mod
//        InterModComms.sendTo("aseoha", "helloworld", () -> { LOGGER.info("Hello world from the MDK"); return "Hello world";});
    }

    private void processIMC(final InterModProcessEvent event) {
        // some example code to receive and process InterModComms from other mods
        LOGGER.info("Got IMC {}", event.getIMCStream().
                map(m -> m.getMessageSupplier().get()).
                collect(Collectors.toList()));
    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
//    @SubscribeEvent
//    public void onServerStarting(FMLServerStartingEvent event) {
    // do something when the server starts
//        LOGGER.info("HELLO from aseoha server starting");
//    }

    // You can use EventBusSubscriber to automatically subscribe events on the contained class (this is subscribing to the MOD
    // Event bus for receiving Registry Events)
    @Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class RegistryEvents {
        @SubscribeEvent
        public static void onBlocksRegistry(final RegistryEvent.Register<Block> blockRegistryEvent) {
            // register a new block here
//            LOGGER.info("HELLO from Register Block");
        }
    }

    @OnlyIn(Dist.DEDICATED_SERVER)
    public static void SendDebugToServer(String DebugMessage) {
        if (config.SERVER.DebugMode.get())
            System.out.println("[ASEOHA Debug] " + DebugMessage);
    }

    @OnlyIn(Dist.CLIENT)
    public static void SendDebugToClient(String DebugMessage) {
        if (config.COMMON.DebugMode.get())
            System.out.println("[ASEOHA Debug] " + DebugMessage);
    }


    public static void SendDebugToAll(String DebugMessage) {
        if (config.COMMON.DebugMode.get())
            System.out.println("[ASEOHA Debug] " + DebugMessage);
        if (config.SERVER.DebugMode.get())
            System.out.println("[ASEOHA Debug] " + DebugMessage);
    }
}

/////////////////////// Reaaaaaaaally old, crappy, and non-working structure gen I was trying to use for New (x15) York.
    /*
    private static Method GETCODEC_METHOD;
    public void addDimensionalSpacing(final WorldEvent.Load event) {
        if(event.getWorld() instanceof ServerWorld){
            ServerWorld serverWorld = (ServerWorld)event.getWorld();
*/
            /*
             * Skip Terraforged's chunk generator as they are a special case of a mod locking down their chunkgenerator.
             * They will handle your structure spacing for your if you add to WorldGenRegistries.NOISE_GENERATOR_SETTINGS in your structure's registration.
             * This here is done with reflection as this tutorial is not about setting up and using Mixins.
             * If you are using mixins, you can call the codec method with an invoker mixin instead of using reflection.
             */
    /*
            try {
                if(GETCODEC_METHOD == null) GETCODEC_METHOD = ObfuscationReflectionHelper.findMethod(ChunkGenerator.class, "func_230347_a_");
                ResourceLocation cgRL = Registry.CHUNK_GENERATOR.getKey((Codec<? extends ChunkGenerator>) GETCODEC_METHOD.invoke(serverWorld.getChunkSource().generator));
                if(cgRL != null && cgRL.getNamespace().equals("terraforged")) return;
            }
            catch(Exception e){
                aseoha.LOGGER.error("Was unable to check if " + serverWorld.dimension().location() + " is using Terraforged's ChunkGenerator.");
            }
*/
            /*
             * Prevent spawning our structure in Vanilla's superflat world as
             * people seem to want their superflat worlds free of modded structures.
             * Also that vanilla superflat is really tricky and buggy to work with in my experience.
             */
    /*
            if(serverWorld.getChunkSource().getGenerator() instanceof FlatChunkGenerator &&
                    serverWorld.dimension().equals(World.OVERWORLD)){
                return;
            }

            if(!(serverWorld.dimension().equals(NEWEARTH))){
                aseoha.LOGGER.info("NOT NEW EARTH");
                return;
            }
*/

            /*   6tt
             * putIfAbsent so people can override the spacing with dimension datapacks themselves if they wish to customize spacing more precisely per dimension.
             * Requires AccessTransformer  (see resources/META-INF/accesstransformer.cfg)
             *
             * NOTE: if you add per-dimension spacing configs, you can't use putIfAbsent as WorldGenRegistries.NOISE_GENERATOR_SETTINGS in FMLCommonSetupEvent
             * already added your default structure spacing to some dimensions. You would need to override the spacing with .put(...)
             * And if you want to do dimension blacklisting, you need to remove the spacing entry entirely from the map below to prevent generation safely.
             */
    /*
            if(serverWorld.dimension().equals(NEWEARTH)){
            aseoha.LOGGER.info("NEW EARTH");
            Map<Structure<?>, StructureSeparationSettings> tempMap = new HashMap<>(serverWorld.getChunkSource().generator.getSettings().structureConfig());
            tempMap.putIfAbsent(STStructures.ROAD.get(), DimensionStructuresSettings.DEFAULTS.get(STStructures.ROAD.get()));
            serverWorld.getChunkSource().generator.getSettings().structureConfig = tempMap;
            }
        }
    }
}
*/