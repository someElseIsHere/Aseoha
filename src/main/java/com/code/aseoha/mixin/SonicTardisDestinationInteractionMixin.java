package com.code.aseoha.mixin;

import java.util.ArrayList;

import com.code.aseoha.upgrades.HADS;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IItemProvider;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TranslationTextComponent;
import net.tardis.mod.blocks.TBlocks;
import net.tardis.mod.config.TConfig;
import net.tardis.mod.constants.TardisConstants.Translations;
import net.tardis.mod.helper.PlayerHelper;
import net.tardis.mod.helper.TardisHelper;
import net.tardis.mod.helper.TextHelper;
import net.tardis.mod.helper.WorldHelper;
import net.tardis.mod.items.SonicItem;
import net.tardis.mod.items.TItems;
import net.tardis.mod.sonic.AbstractSonicMode;
import net.tardis.mod.sonic.interactions.SonicTardisDestinationInteraction;
import net.tardis.mod.tileentities.ConsoleTile;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(SonicTardisDestinationInteraction.class)
public class SonicTardisDestinationInteractionMixin extends AbstractSonicMode {
    public SonicTardisDestinationInteractionMixin() {
    }
    private static boolean flightFromSonic = false;
    private static boolean FlightFromSonic(ConsoleTile console, BlockState blockState){

//        if(flightFromSonic && console.isInFlight()){
//            console.initLand();
//            flightFromSonic = false;
//        }
        if(blockState.is(TBlocks.bottom_exterior.get())) flightFromSonic = true;
        else flightFromSonic = false;
            if (flightFromSonic) {
                console.takeoff();
//                if(console.getLevel().getGameTime() % 20 == 0)
                console.setDestinationReachedTick(1);
            }
            if (!flightFromSonic && console.isInFlight())
                console.initLand();

            return flightFromSonic;
    }
    /**
     * @author Me
     * @reason HADS & Stuff
     */
    @Overwrite(remap = false)
    public boolean processBlock(PlayerEntity player, BlockState blockState, ItemStack sonic, BlockPos pos) {
        if (!(Boolean)TConfig.SERVER.coordinateTardis.get()) {
            return false;
        } else {
            if (!player.level.isClientSide && WorldHelper.canTravelToDimension(player.level) && sonic.getItem() instanceof SonicItem) {
                SonicItem sonicItem = (SonicItem)sonic.getItem();
                if (sonicItem.getTardis(sonic) == null) {
                    PlayerHelper.sendMessageToPlayer(player, Translations.ITEM_NOT_ATTUNED, true);
                    return false;
                }
                ConsoleTile console = (ConsoleTile)TardisHelper.getConsole(player.getServer(), sonicItem.getTardis(sonic)).orElse((ConsoleTile) null);
                if (console != null) {
                    FlightFromSonic(console, blockState);
                    if(HADS.hadsActivate(console)){
                        HADS.deactivateHADS(console);
                    }
                    if (!console.isLanding()) {
                        if (this.handleDischarge(player, sonic, 25.0F)) {
                            console.setDestination(player.level.dimension(), pos);
                            console.setExteriorFacingDirection(player.getDirection());
                            PlayerHelper.sendMessageToPlayer(player, new TranslationTextComponent("message.sonic.tardis_dest_set", new Object[]{TextHelper.getBlockPosObject(pos)}), false);
                            return true;
                        }

                        return false;
                    }


                    return false;
                }
            }

            PlayerHelper.sendMessageToPlayer(player, new TranslationTextComponent("message.sonic.tardis_dest_fail"), true);
            return false;
        }
    }

    @Shadow(remap = false)
    public boolean processEntity(PlayerEntity user, Entity targeted, ItemStack sonic) {
        return false;
    }

    public ArrayList<TranslationTextComponent> getAdditionalInfo() {
        ArrayList<TranslationTextComponent> list = new ArrayList();
        list.add(new TranslationTextComponent("mixin.sonic.modes.info.set_coords"));
        return list;
    }

    @Shadow(remap = false)
    public boolean hasAdditionalInfo() {
        return true;
    }

    @Shadow(remap = false)
    public void updateHeld(PlayerEntity playerEntity, ItemStack stack) {
    }

    @Shadow(remap = false)
    public ItemStack getItemDisplayIcon() {
        return new ItemStack((IItemProvider)TItems.BROKEN_EXTERIOR.get());
    }
}
