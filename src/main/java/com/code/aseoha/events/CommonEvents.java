package com.code.aseoha.events;

import com.code.aseoha.Constants;
import com.code.aseoha.aseoha;
import com.code.aseoha.client.Sounds;
import com.code.aseoha.commands.Commands;
import com.code.aseoha.entities.k9;
import com.code.aseoha.items.ModItems;
import com.code.aseoha.misc.TARDISHelper;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.Direction;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.StringTextComponent;
import net.minecraftforge.event.RegisterCommandsEvent;
import net.minecraftforge.event.ServerChatEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.event.entity.player.AttackEntityEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.tardis.api.events.TardisEvent;
import net.tardis.mod.cap.Capabilities;
import net.tardis.mod.commands.TardisCommand;
import net.tardis.mod.entity.ControlEntity;
import net.tardis.mod.entity.TardisEntity;
import net.tardis.mod.helper.TardisHelper;
import net.tardis.mod.items.SonicItem;
import net.tardis.mod.items.TItems;
import net.tardis.mod.sounds.TSounds;
import net.tardis.mod.subsystem.StabilizerSubsystem;
import net.tardis.mod.tileentities.exteriors.ExteriorTile;
import net.tardis.mod.tileentities.inventory.PanelInventory;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.util.Objects;
import java.util.Random;

//******************************Apparently canceling the flight event with the doors crashes the game when outside the TARDIS**********************************************/
@Mod.EventBusSubscriber(modid = aseoha.MODID)
public class CommonEvents {

    /**
     * @param event The RegisterCommandsEvent, I use this to register custom commands
     */
    @SubscribeEvent public static void registerCommands(RegisterCommandsEvent event) {Commands.register(event.getDispatcher());}

    /**
     * I use this to check if the player respawns, if they did, remove the GotASEOHABook tag, I do this so that the manual gets thrown at em since they don't have the tag
     */
    @SubscribeEvent
    public static void respawnEvent(PlayerEvent.PlayerRespawnEvent event){
        event.getPlayer().removeTag("GotASEOHABook");
    }


    /**
     * This is just to check if somebody enters something in chat, what they entered, and mostly for K9 voice prompts
     */
    @SubscribeEvent
    public static void onServerChat(ServerChatEvent event) {
        String message = event.getMessage();
        ScriptEngineManager mgr = new ScriptEngineManager();
        ScriptEngine engine = mgr.getEngineByName("JavaScript");

        if (event.getMessage().toLowerCase().contains("aseoha") && event.getMessage().toLowerCase().contains("give") && event.getMessage().toLowerCase().contains("manual")) {
            event.getPlayer().removeTag("GotASEOHABook");
        }
        //HELP
        if (event.getMessage().toLowerCase().replace(" ", "").contains("aseoha") && event.getMessage().toLowerCase().replace(" ", "").contains("help") && event.getMessage().toLowerCase().replace(" ", "").contains("k9")) {
//            event.getPlayer().sendMessage(new StringTextComponent("Operation of K9 Mark II: \n\nTo ensure proper operation of K-9 Mark II make sure that your K-9 Unit is located within 20 blocks of the console unit of the TARDIS you would like to operate with your K-9 unit\n\nWhenever you would like to use your K-9 Unit, start by opening the chat, and type in \"K9\", You can also type \"K 9\" or \"K-9\", it is important to note that you may type it in uppercase, or lowercase.\n\nAfter typing K9, type in one of the many keywords available, each of these keywords corresponds to one of K9s many functions\n\nKeywords can be mixed with other words and phrases and will still work, for instance, I could say \"K9 [keyword]\" or I could say \"K9, Please do [keyword] now\" and K9 would still perform the function corresponding to the keyword (Note, when using keywords, capitalization does not matter)\n\nKeywords:\n\nThe keyword for K9s math function is: \"math\" and \"calculate\", the math function allows for Addition (+) Subtraction (-) Multiplication (*) and Division (/) it also supports parentheses ()\n\nThe Keywords for K9s Power Off function are \"power\" + \"off\"/\"down\" (Please note, you must include both power AND off in your sentence) K9's Power Off function will initiate the TARDIS Power Off Procedure, Turning all the lights off, and emitting some noises as it powers down.\n\nThe Keywords for K9's Destination Set function are \"set\"+\"destination\"/\"location\"/\"coord\" (Please note: while you can say coord, you could also add letters to the end of the keyword, like coordINATE or coordBanannaCreamPie) This will set the destination coordinate for one axis (X, Y, or Z) in order to set the coordinate, you must specify the axis (X, Y, or Z) in your message\n\nThe Keyword for K9's light function is \"set\"+\"light\" followed by a number, this number can be any number from 1-15, however, if you go above 15, it will automatically be set to 15. K9's light function sets the light level of the TARDIS.\n\nThe Keyword for K9's flight function is \"fly\", K9's flight function will activate the TARDIS Stabilizers (if present) and initiate the TARDIS flight sequence (Important Note, if you are flying a Type 40 TARDIS or older, you will have to manually pilot your TARDIS around any temporal disturbances (Flight Events), unless you have the Stabilizer Circuits installed, otherwise you run the risk of crashing and damaging your timeship, and landing in the wrong location)\n\nThe Keyword for K9's lock function are \"lock\", the lock function will lock the TARDIS doors, in order to unlock them, ensure the keywords \"disengage\" or \"un\" are present in you message to K9\n\nThe Keywords for K9's deadlock function are \"dead\"+\"lock\", K9's deadlock function will deadlock the doors. (WARNING, DEADLOCKED DOORS CAN ONLY BE UNLOCKED BY A DEADLOCKER KEY WHICH MUST BE ATTUNED TO YOUR TARDIS, OR BY ANOTHER K9), If you wish to un-deadlock the TARDIS doors with your K9, ensure the keywords \"un\"/\"disengage\" are present in your message\n\nWe Thank you for purchasing your new K9 Mark II, and wish you happy travels!\nTo file a complaint with your K9 call the ASEOHA helpline by typing \"call 770-090-0461\" in the chat\nMade in China\n K9 Mark II complies with part 15 of the FCC Rules.\nOperation is subject to the following two conditions:\n(1) this device may not cause harmful interference, \nand (2) this device must accept any interference \nreceived, including interference that may cause undesired operation.\nComplies with Canadian ICES-003 Class B.\nConforme á la NMB-003 classe B du Canada."), event.getPlayer().getUUID());
            event.getPlayer().sendMessage(new StringTextComponent("Upon crafting K-9, you must tame your K-9, which you can do with your sonic screwdriver, then you must recharge your K-9 Unit, in order to do so, click on him with any item that holds an Artron Charge (Sonic Screwdriver, Artron Battery, etc) his maximum capacity is 100 AU, and by default will drain 1 AU every 25 seconds (this can be configured via the server config), upon charging him up, it will now be able to move and you can now open up it's inventory and GUI, to open the GUI, simply right click the K-9, to open up his inventory, simply Right Click K-9 while you are Crouching. \nWe Thank you for purchasing your new K9 Mark II, and wish you happy travels!\nTo file a complaint with your K9 call the ASEOHA helpline by typing \"call 770-090-0461\" in the chat\nMade in China\n K9 Mark II complies with part 15 of the FCC Rules.\nOperation is subject to the following two conditions:\n(1) this device may not cause harmful interference, \nand (2) this device must accept any interference \nreceived, including interference that may cause undesired operation.\nComplies with Canadian ICES-003 Class B.\nConforme á la NMB-003 classe B du Canada."), event.getPlayer().getUUID());
        }
        if (event.getMessage().toLowerCase().replace("-", "").replace(" ", "").contains("7700900461")) {
            event.getPlayer().sendMessage(new StringTextComponent("You have reached the TARDIS, She's busy routing you through the vortex, please hold!"), event.getPlayer().getUUID());
        }

        TardisHelper.getConsoleInWorld(event.getPlayer().getLevel()).ifPresent((consoleTile -> {
//        assert consoleTile != null;
//        if (consoleTile.getLevel() != null) {


            ////////////////////////////////////////////////////K-9!
            if (message.toLowerCase().replace(" ", "").contains("k9") || message.toLowerCase().replace(" ", "").contains("k-9") || message.toLowerCase().replace(" ", "").contains("k 9")) {
                for (LivingEntity liv : Objects.requireNonNull(consoleTile.getLevel()).getEntitiesOfClass(LivingEntity.class, new AxisAlignedBB(consoleTile.getBlockPos()).inflate(20))) {
                    if (liv instanceof k9) {
                        if (!((k9) liv).isDead) {
                            if (message.toLowerCase().contains("fly")) {
                                k9.Talk(1, event.getPlayer(), event.getPlayer().level);
                                consoleTile.getSubsystem(StabilizerSubsystem.class).ifPresent((stabs) -> stabs.setActivated(true));
                                consoleTile.takeoff();

                            }


                            if (message.toLowerCase().contains("power")) {
                                if (message.toLowerCase().contains("off") || message.toLowerCase().contains("down")) {
                                    k9.Talk(1, event.getPlayer(), event.getPlayer().level);
                                    consoleTile.onPowerDown(true);

                                }
                            }


                            if (message.toLowerCase().contains("set")) {
                                if (message.toLowerCase().contains("light")) {
                                    k9.Talk(1, event.getPlayer(), event.getPlayer().level);
                                    int lightLevel = Integer.parseInt(message.toLowerCase().replace(" ", "").replace("k-9", "").replace("k9", "").replace("k 9", "").replaceAll("[^1234567890]", ""));
                                    if (lightLevel > 15) lightLevel = 15;
                                    consoleTile.getInteriorManager().setLight(lightLevel);

                                }

                                if (message.toLowerCase().contains("coord") || message.toLowerCase().contains("location") || message.toLowerCase().contains("destination")) {

                                    if (message.toLowerCase().contains("x") && !message.toLowerCase().contains("y") && !message.toLowerCase().contains("z")) {
                                        consoleTile.setDestination(consoleTile.getDestinationDimension(), new BlockPos(Integer.parseInt(message.toLowerCase().replace(" ", "").replace("k-9", "").replace("k9", "").replaceAll("[^1234567890]", "")), consoleTile.getDestinationPosition().getY(), consoleTile.getDestinationPosition().getZ()));
                                        k9.Talk(1, event.getPlayer(), event.getPlayer().level);
                                    }

                                    if (message.toLowerCase().contains("y") && !message.toLowerCase().contains("x") && !message.toLowerCase().contains("z")) {
                                        consoleTile.setDestination(consoleTile.getDestinationDimension(), new BlockPos(consoleTile.getDestinationPosition().getX(), Integer.parseInt(message.toLowerCase().replace(" ", "").replace("k-9", "").replace("k9", "").replaceAll("[^1234567890]", "")), consoleTile.getDestinationPosition().getZ()));
                                        k9.Talk(1, event.getPlayer(), event.getPlayer().level);
                                    }

                                    if (message.toLowerCase().contains("z") && !message.toLowerCase().contains("x") && !message.toLowerCase().contains("y")) {
                                        consoleTile.setDestination(consoleTile.getDestinationDimension(), new BlockPos(consoleTile.getDestinationPosition().getX(), consoleTile.getDestinationPosition().getY(), Integer.parseInt(message.toLowerCase().replace(" ", "").replace("k-9", "").replace("k9", "").replaceAll("[^1234567890]", ""))));
                                        k9.Talk(1, event.getPlayer(), event.getPlayer().level);
                                    }
                                    if ((message.toLowerCase().contains("x") && message.toLowerCase().contains("y")) || (message.toLowerCase().contains("x") && message.contains("z")) || (message.toLowerCase().contains("z") && message.toLowerCase().contains("y"))) {
                                        k9.Talk(2, event.getPlayer(), event.getPlayer().level);
                                    }
                                }
                            }

                            if (message.toLowerCase().contains("dead") && message.toLowerCase().contains("lock")) {
                                if ((message.toLowerCase().contains("engage") || message.toLowerCase().contains("on")) && !message.toLowerCase().contains("dis") && !message.toLowerCase().contains("off")) {
                                    TARDISHelper.setDoorState(consoleTile, 0);
                                    consoleTile.getExteriorType().getExteriorTile(consoleTile).setAdditionalLockLevel(1);
                                    consoleTile.getExteriorType().getExteriorTile(consoleTile).copyDoorStateToInteriorDoor();
                                    consoleTile.getExteriorType().getExteriorTile(consoleTile).updateClient();
                                    k9.Talk(1, event.getPlayer(), event.getPlayer().level);
                                }
                                if ((message.toLowerCase().contains("dis") && message.toLowerCase().contains("engage")) || message.toLowerCase().contains("off")) {
                                    TARDISHelper.setDoorState(consoleTile, 0);
                                    consoleTile.getExteriorType().getExteriorTile(consoleTile).setAdditionalLockLevel(0);
                                    consoleTile.getExteriorType().getExteriorTile(consoleTile).copyDoorStateToInteriorDoor();
                                    consoleTile.getExteriorType().getExteriorTile(consoleTile).updateClient();
                                    k9.Talk(1, event.getPlayer(), event.getPlayer().level);
                                }
                            }

                            if (message.toLowerCase().contains("lock") && !message.toLowerCase().contains("dead")) {
                                if (!(message.toLowerCase().contains("engage") && message.toLowerCase().contains("dis")) || !message.toLowerCase().contains("un")) {
                                    TARDISHelper.setDoorState(consoleTile, 0);
                                    consoleTile.getExteriorType().getExteriorTile(consoleTile).setLocked(true);
                                    consoleTile.getExteriorType().getExteriorTile(consoleTile).copyDoorStateToInteriorDoor();
                                    consoleTile.getExteriorType().getExteriorTile(consoleTile).updateClient();
                                    k9.Talk(1, event.getPlayer(), event.getPlayer().level);
                                } else {
                                    TARDISHelper.setDoorState(consoleTile, 0);
                                    consoleTile.getExteriorType().getExteriorTile(consoleTile).setLocked(false);
                                    consoleTile.getExteriorType().getExteriorTile(consoleTile).copyDoorStateToInteriorDoor();
                                    consoleTile.getExteriorType().getExteriorTile(consoleTile).updateClient();
                                    k9.Talk(1, event.getPlayer(), event.getPlayer().level);
                                }
                            }


                            //Very complicated, but basically it uses regex and smart stuff to replace every variant of "K9" and then everything that isn't a number, and then print a JavaScript evaluation of the string (basically JS goes through the string, does mathy stuff)

                            if (message.toLowerCase().contains("math") || message.toLowerCase().contains("calculate")) {
//                            aseoha.LOGGER.info(engine.eval(message.toLowerCase().replace(" ", "").replace("k9", "").replace("k 9", "").replace("k-9", "").replaceAll("[^1234567890()^+*/-]", "")).toString());
                                try {
                                    k9.Say("[K9] The result of the equation is " + engine.eval(message.toLowerCase().replace(" ", "").replace("k9", "").replace("k 9", "").replace("k-9", "").replaceAll("[^1234567890()^+*/-]", "")).toString(), event.getPlayer(), event.getPlayer().level);
                                } catch (ScriptException e) {
                                    throw new RuntimeException(e);
                                }
                            }
                            if (message.toLowerCase().contains("scan")) {
//                            if(new BlockPos(consoleTile.getCurrentLocation().getX()+1,consoleTile.getCurrentLocation().getY(), consoleTile.getCurrentLocation().getZ()).equals(Blocks.LAVA))
//                                if(new BlockPos(consoleTile.getCurrentLocation().getX()-1,consoleTile.getCurrentLocation().getY(), consoleTile.getCurrentLocation().getZ()).equals(Blocks.LAVA))
//                                    if(new BlockPos(consoleTile.getCurrentLocation().getX(),consoleTile.getCurrentLocation().getY(), consoleTile.getCurrentLocation().getZ()+1).equals(Blocks.LAVA))
//                                        if(new BlockPos(consoleTile.getCurrentLocation().getX(),consoleTile.getCurrentLocation().getY(), consoleTile.getCurrentLocation().getZ()-1).equals(Blocks.LAVA))
                            }
//                    if(message.toLowerCase().contains("coord") || message.toLowerCase().contains("location") || message.toLowerCase().contains("destination")) {
//                        if (message.toLowerCase().contains("x") && !message.toLowerCase().contains("y") && !message.toLowerCase().contains("z")) {
//                            consoleTile.setDestination(consoleTile.getDestinationDimension(), new BlockPos(Integer.parseInt(nums), consoleTile.getDestinationPosition().getY(), consoleTile.getDestinationPosition().getZ()));
//                        }
//                    }
                        }
                    }
                }


            }
//                    K9.ifPresent(k9EntityType -> k9.Talk(1));

        }));
//        else {
//            Objects.requireNonNull(event.getPlayer().getServer()).sendMessage((ITextComponent) new TranslationTextComponent(message), event.getPlayer().getUUID());
//        }
//        }
    }

    //@SubscribeEvent
    //public static void onSuccessfulFlightEvent(FlightEventEvent.SuccessFlightEvent event){}

    /**
     * Use this to make sure if a player is on midnight, fire em
     */
    @SubscribeEvent
    public static void onLivingTick(LivingEvent.LivingUpdateEvent event){
        LivingEntity entity = event.getEntityLiving();
        if (entity.level.dimension() == Constants.MIDNIGHT)
            entity.setSecondsOnFire(5);
    }


//    @SubscribeEvent
//    public static void onEventPopup(FlightEventEvent.StartFlightEvent event){
//    HADS hads = event.getConsole().getUpgrade(HADS.class).orElse(null);
//    if(hads.isActivated())
//        if(event.getConsole().isInFlight())
//            if(event.getConsole().doesConsoleWorldHaveNoPlayers())
//                if(event.getConsole().getInteriorManager().isAlarmOn())
//                    event.setCanceled(true);
//    ConsoleTile console = TardisHelper.getConsoleInWorld(Objects.requireNonNull(event.getConsole().getLevel())).get();
//    AutoStabilizer autostabs = console.getUpgrade(AutoStabilizer.class).orElse(null);
//    if(autostabs != null) {
//        if (console.doesConsoleWorldHaveNoPlayers()) {
//                if (autostabs.isUsable() && autostabs.isActivated()) {
//                    event.setCanceled(true);
//                }
//        }
//    }
//        event.isCanceled();

//    }


    /**
     * Make sure TARDIS Doors close on takeoff, and low on artron sounds
     */
    @SubscribeEvent
public static void onTardisTakeoff(TardisEvent.Takeoff event){
//    if(!TARDISHelper.areDoorsClosed(event.getConsole()) && !HADS.hadsActivate(event.getConsole()))
//        event.setCanceled(true);
    TARDISHelper.setDoorState(event.getConsole(), 0);

    if(event.getConsole().getArtron() < 64 && TARDISHelper.areDoorsClosed(event.getConsole()))
        Objects.requireNonNull(event.getConsole().getLevel()).playSound(null, event.getConsole().getBlockPos(), Sounds.LOW_ARTRON_TAKEOFF.get(), SoundCategory.BLOCKS, 1.0f,1.0f);

}

    /**
     * This is SUPPOSED to trigger HADS when you hit the exterior, unfortunatally I never did get it working, also used it at one point for the hammer
     */
    @SubscribeEvent
public static void onAttack(AttackEntityEvent event) {
    if(event.getTarget() instanceof TardisEntity) {
        ((TardisEntity) event.getTarget()).getConsole().getInteriorManager().setAlarmOn(true);
    }
    if (event.getTarget() instanceof ControlEntity){
        ControlEntity entity = (ControlEntity) event.getTarget();
//

//////////////////////////////////////////////////////////////////////////////////////////Old ass low on artron code + non-working hammer
//        if(event.getPlayer().getUseItem().equals(new ItemStack(ModItems.HAMMER.get()))){
//            ConsoleTile console = ((ControlEntity) event.getTarget()).getControl().getConsole();
//            console.setDestinationReachedTick(console.getReachDestinationTick() - (console.getReachDestinationTick() / 8));
//            console.getSubsystem(FluidLinksSubsystem.class).ifPresent(fluid -> fluid.getItem().setDamageValue(fluid.getItem().getDamageValue() - 300)); //Not working: (Hammer)
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
//        }
    }
}

    /**
     * I was gonna use this for something. that's all.
     */
    @SubscribeEvent
    public static void onEntityJoin(EntityJoinWorldEvent event) {
        if (event.getEntity() instanceof PlayerEntity) {
            if (event.getEntity() != null) {
                PlayerEntity player = (PlayerEntity) event.getEntity();
//                player.s
            }
        }
    }


    /**
     * A LOT of stuff
     */
    @SubscribeEvent
    public static void onWorldTick(TickEvent.WorldTickEvent event) {
        TardisHelper.getConsoleInWorld(event.world).ifPresent(tardisTile -> {
            if(tardisTile.getInteriorManager().getLight()>15) tardisTile.getInteriorManager().setLight(0);
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
                            if (random.nextInt(100 * itemStack.getStack().getCount()) == 3) {
                                ItemStack itemStack1 = new ItemStack(ModItems.GOLDEN_POTATO.get());
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
            //Ignore the "tardistile.getsonicitem().getitem() != null is always true" that's bullshit because intelliJ doesn't account for it ACTUALLY being null, it assumes it always has a value, and if you leave out the != null it will nullPointer you
            if (tardisTile.getSonicItem().getItem() != null) {
                if (tardisTile.getSonicItem().getItem() == TItems.SONIC.get()) {
                    SonicItem sonic = (SonicItem) tardisTile.getSonicItem().getItem();
                    ItemStack sonicStack = tardisTile.getSonicItem().getStack();
                    if (event.world.getGameTime() % 20 == 0) {
                        sonic.charge(sonicStack, 1.5f);
                    }
                }
            }
        });
    }






///////////////////////////////////////Old ass HADS code, basically just take off if a !ignored entity enters the TARDIS, can't remember why I abandoned it.
//    if (!event.world.isClientSide) {
//        event.world.getServer().tell(new TickDelayedTask(1, () -> {
//            if (WorldHelper.areDimensionTypesSame(event.getWorld(), TDimensions.DimensionTypes.TARDIS_TYPE)) {
//                if (event.getEntity() instanceof IMob && !event.getEntity().getType().is(TardisEntityTypeTags.IGNORED_ALARM_ENTITIES)) {
//                    if (TardisHelper.getConsoleInWorld(event.getWorld()).isPresent()) {
//                        TardisHelper.getConsoleInWorld(event.getWorld()).ifPresent((tile) -> {
//                            ConsoleTile console = Objects.requireNonNull(TardisHelper.getConsoleInWorld(event.getWorld()).get());
//                            console.getUpgrade(HADS.class).ifPresent((hads) -> {
//                                if(hads.isActivated()){
//                                    HADS.hadsActivate(console);
//                                }
//                            });
//                        });
//                    }
//                }
//            }
//        }));
}