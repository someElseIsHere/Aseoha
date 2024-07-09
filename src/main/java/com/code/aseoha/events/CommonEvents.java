package com.code.aseoha.events;

import com.code.aseoha.aseoha;
import com.code.aseoha.client.Sounds;
import com.code.aseoha.misc.TARDISHelper;
import com.code.aseoha.upgrades.EngineBoost;
import com.code.aseoha.upgrades.HADS;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.Direction;
import net.minecraft.util.SoundCategory;
import net.minecraft.world.Explosion;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.event.entity.player.AttackEntityEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.mistersecret312.temporal_api.events.FlightEventEvent;
import net.mistersecret312.temporal_api.events.TardisEvent;
import net.tardis.mod.blocks.exteriors.TardisExteriorBottomBlock;
import net.tardis.mod.cap.Capabilities;
import net.tardis.mod.entity.TardisEntity;
import net.tardis.mod.helper.TardisHelper;
import net.tardis.mod.items.SonicItem;
import net.tardis.mod.items.TItems;
import net.tardis.mod.sounds.TSounds;
import net.tardis.mod.tileentities.ConsoleTile;
import net.tardis.mod.tileentities.exteriors.ExteriorTile;
import net.tardis.mod.tileentities.inventory.PanelInventory;
import java.util.Objects;
import java.util.Random;


@Mod.EventBusSubscriber(modid = aseoha.MODID)

public class CommonEvents {

@SubscribeEvent
public static void onSuccessfulFlightEvent(FlightEventEvent.SuccessFlightEvent event){
//    aseoha.LOGGER.info("CHEWY! HIT THE HYPERDRIVE!");
//    aseoha.LOGGER.info(event.getConsole().getReachDestinationTick());
//    EngineBoost.BoostThemEngines(event.getConsole());
//    aseoha.LOGGER.info(event.getConsole().getReachDestinationTick());
//    aseoha.LOGGER.info("SHWOOOOM");
}
    @SubscribeEvent
    public static void onLivingTick(LivingEvent.LivingUpdateEvent event){
        LivingEntity entity = event.getEntityLiving();

            if (entity.level.dimension() == aseoha.MIDNIGHT)
                        entity.setSecondsOnFire(5);
    }


    @SubscribeEvent
    public static void onEventPopup(FlightEventEvent.StartFlightEvent event){
    if(HADS.hadsActivate(event.getConsole())){
        event.setCanceled(true);
//        event.isCanceled();
    }
    }


@SubscribeEvent
public static void onTardisTakeoff(TardisEvent.TakeoffEvent event){
    if(TARDISHelper.areDoorsOpen(event.getConsole()) || TARDISHelper.isOneDoorOpen(event.getConsole()) && !HADS.hadsActivate(event.getConsole()))
        event.setCanceled(true);

    if(event.getConsole().getArtron() < 64)
        event.getConsole().getLevel().playSound(null, event.getConsole().getBlockPos(), Sounds.LOW_ARTRON_TAKEOFF.get(), SoundCategory.BLOCKS, 1.0f,1.0f);

}

    @SubscribeEvent
    public static void onAttack(AttackEntityEvent event) {
        if(event.getTarget() instanceof TardisEntity) {
            ((TardisEntity) event.getTarget()).getConsole().getInteriorManager().setAlarmOn(true);
        }
//        if (event.getTarget() instanceof ControlEntity){
//            ControlEntity entity = (ControlEntity) event.getTarget();
//
//            if (entity.getControl() instanceof ThrottleControl) {
//                if (entity.getControl().getConsole().canFly() && !entity.getControl().getConsole().isInFlight() && !event.getPlayer().isCrouching()){
////                    console.getControl(DimensionControl.class).ifPresent((dimensionControl) -> {
//                    HandbrakeControl control = entity.getControl().getConsole().getControl(HandbrakeControl.class).get();
////                    // Check to make sure the handbreak isn't on.
//                    if (control instanceof HandbrakeControl){
//                        if (((HandbrakeControl) control).isFree()) {
//                            if(entity.getControl().getConsole().getArtron() < 64)
//                            event.getTarget().level.playSound(null, entity.getControl().getConsole().getBlockPos(), Sounds.LOW_ARTRON_TAKEOFF.get(), SoundCategory.BLOCKS, 1.0f,1.0f);
//                        }
//                    }
//                }
//            }
//        }
    }

    @SubscribeEvent
    public static void onEntityJoin(EntityJoinWorldEvent event){
//        if(event.getEntity().getName() == new TranslationTextComponent("codiak540") || event.getEntity().getName() == new TranslationTextComponent("Dev")) {
//            Objects.requireNonNull(event.getWorld().getServer()).sendMessage(new TranslationTextComponent("The dev is here!"), event.getEntity().getUUID());
////            event.getWorld().getServer()
//        }
//        if(event.getWorld().getDimension().getType().getModType() == TDimensions.VORTEX) {
//            if (event.getEntity() instanceof ServerPlayerEntity) {
//                event.getWorld().playSound(null, event.getEntity().getPosition(), MSounds.TIME_VORTEX, SoundCategory.MUSIC, 100f , 1);
//            }
//
//        }
//
//        // Advancements
//        if(event.getWorld().getDimension().getType().getModType() == TDimensions.TARDIS && !event.getWorld().isRemote) {
//            InteriorUnlocker.checkAchievementsForUnlock(event);
//        }
    }

//    @SubscribeEvent
//    public static void TardisEvent(net.mistersecret312.temporal_api.events.TardisEvent event){
//        event
//    }

    @SubscribeEvent
    public static void FlightEventSuccess(FlightEventEvent.SuccessFlightEvent event){

    }
@SubscribeEvent
public static void onWorldTick(TickEvent.WorldTickEvent event) {
//    final ArrayList<ControlEntity> controls = new ArrayList<ControlEntity>();
    TardisHelper.getConsoleInWorld(event.world).ifPresent(tardisTile -> {
        if(TARDISHelper.hasConsoleChanged(tardisTile)){
            tardisTile.removeControls();
            tardisTile.getOrCreateControls();
        }
        Random random = new Random();
        event.world.getCapability(Capabilities.TARDIS_DATA).ifPresent(cap -> {
            PanelInventory attunementPanel = cap.getEngineInventoryForSide(Direction.EAST);
            if (attunementPanel != null) {
                for (int i = 0; i < attunementPanel.getSlots(); ++i) {
                    ItemStack itemStack = attunementPanel.getStackInSlot(i);
                    if (itemStack.getItem() == Items.CHICKEN) {
                        if (random.nextInt(100 * itemStack.getStack().getCount()) == 1) {
                            ItemStack itemStack1 = new ItemStack(Items.COOKED_CHICKEN);
                            itemStack1.setCount(itemStack.getStack().getCount());
                            attunementPanel.getStackInSlot(i);
                            attunementPanel.setStackInSlot(i, itemStack1);
                            Objects.requireNonNull(tardisTile.getLevel()).playSound(null, tardisTile.getBlockPos(), TSounds.SINGLE_CLOISTER.get(), SoundCategory.BLOCKS, 10f, 1.5f);
                        }
                        if (random.nextInt(100 * itemStack.getStack().getCount()) == 2) {
                            ItemStack itemStack1 = new ItemStack(Items.EGG);
                            itemStack1.setCount(itemStack.getStack().getCount());
                            attunementPanel.getStackInSlot(i);
                            attunementPanel.setStackInSlot(i, itemStack1);
                            Objects.requireNonNull(tardisTile.getLevel()).playSound(null, tardisTile.getBlockPos(), TSounds.SINGLE_CLOISTER.get(), SoundCategory.BLOCKS, 10f, 1.5f);
                        }
                    }
                    if (itemStack.getItem() == Items.POTATO) {
                        if (random.nextInt(100 * itemStack.getStack().getCount()) == 1) {
                            ItemStack itemStack1 = new ItemStack(Items.POISONOUS_POTATO);
                            itemStack1.setCount(itemStack.getStack().getCount());
                            attunementPanel.getStackInSlot(i);
                            attunementPanel.setStackInSlot(i, itemStack1);
                            Objects.requireNonNull(tardisTile.getLevel()).playSound(null, tardisTile.getBlockPos(), TSounds.SINGLE_CLOISTER.get(), SoundCategory.BLOCKS, 10f, 1.5f);
                        }
                        if (random.nextInt(100 * itemStack.getStack().getCount()) == 2) {
                            ItemStack itemStack1 = new ItemStack(Items.BAKED_POTATO);
                            itemStack1.setCount(itemStack.getStack().getCount());
                            attunementPanel.getStackInSlot(i);
                            attunementPanel.setStackInSlot(i, itemStack1);
                            Objects.requireNonNull(tardisTile.getLevel()).playSound(null, tardisTile.getBlockPos(), TSounds.SINGLE_CLOISTER.get(), SoundCategory.BLOCKS, 10f, 1.5f);
                        }
                    }
                }
            }
        });
    ExteriorTile exteriorBlock = tardisTile.getExteriorType().getExteriorTile(tardisTile);
        if (exteriorBlock != null) {
            if (Objects.requireNonNull(tardisTile.getExteriorType().getExteriorTile(tardisTile).getLevel()).getGameTime() % 70 == 0 && !tardisTile.isInFlight()) {
        if (tardisTile.getInteriorManager().isAlarmOn()) {
            Objects.requireNonNull(exteriorBlock.getLevel()).playSound(null, tardisTile.getExteriorType().getExteriorTile(tardisTile).getBlockPos(), TSounds.SINGLE_CLOISTER.get(), SoundCategory.BLOCKS, 1.0F, 0.5F);//(PlayerEntity) null, tile.getExteriorType().getExteriorTile(tile).getBlockPos(), TSounds.SINGLE_CLOISTER, SoundCategory.BLOCKS, 2f, 1f);
        }
    }
            if (!tardisTile.getDistressSignals().isEmpty() && Objects.requireNonNull(tardisTile.getExteriorType().getExteriorTile(tardisTile).getLevel()).getGameTime() % 100 == 0 && !tardisTile.isInFlight()) {
                    Objects.requireNonNull(exteriorBlock.getLevel()).playSound(null, tardisTile.getExteriorType().getExteriorTile(tardisTile).getBlockPos(), TSounds.COMMUNICATOR_RING.get(), SoundCategory.BLOCKS, 1f, 1f);
            }
    }

        if (tardisTile.getSonicItem().getItem() != null) {
            if (tardisTile.getSonicItem().getItem() == TItems.SONIC.get()) {
                SonicItem sonic = (SonicItem) tardisTile.getSonicItem().getItem();
                ItemStack sonicStack = tardisTile.getSonicItem().getStack();
                if (event.world.getGameTime() % 20 == 0) {
                    sonic.charge(sonicStack, 2f);
                }
            }
        }


        //WIP Low on Artron sounds
//        if(tardisTile != null){
//            if(tardisTile.getArtron() <= 64){
////                aseoha.LOGGER.info(tardisTile.isInFlight());
//                if(tardisTile.isInFlight()){
//                    Objects.requireNonNull(tardisTile.getLevel()).playSound(null, tardisTile.getBlockPos(), Sounds.LOW_ARTRON_TAKEOFF.get(), SoundCategory.BLOCKS, 1f, 1f);
//                }
//            }
//        }
});
}
}