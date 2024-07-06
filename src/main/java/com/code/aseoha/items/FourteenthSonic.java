//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.code.aseoha.items;

import java.util.List;
import java.util.Objects;
import javax.annotation.Nullable;

import com.code.aseoha.Constants;
import com.code.aseoha.aseoha;
import com.code.aseoha.items.ModItemGroup;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.TNTBlock;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUseContext;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ActionResult;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.EntityRayTraceResult;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.RayTraceResult.Type;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.common.util.NonNullSupplier;
import net.tardis.mod.artron.IArtronItemStackBattery;
import net.tardis.mod.cap.Capabilities;
import net.tardis.mod.cap.items.sonic.ISonic;
import net.tardis.mod.cap.items.sonic.SonicCapability;
import net.tardis.mod.client.ClientHelper;
import net.tardis.mod.client.renderers.SonicRenderer;
import net.tardis.mod.constants.TardisConstants.Translations;
import net.tardis.mod.enums.EnumDoorState;
import net.tardis.mod.helper.PlayerHelper;
import net.tardis.mod.helper.TardisHelper;
import net.tardis.mod.helper.TextHelper;
import net.tardis.mod.itemgroups.TItemGroups;
import net.tardis.mod.items.misc.ConsoleBoundItem;
import net.tardis.mod.misc.GuiContext;
import net.tardis.mod.sonic.AbstractSonicMode;
import net.tardis.mod.sounds.TSounds;
import net.tardis.mod.tileentities.ConsoleTile;
import net.tardis.mod.tileentities.exteriors.ExteriorTile;

public class FourteenthSonic extends ConsoleBoundItem implements IArtronItemStackBattery {
    private static final Integer COOLDOWN_TIME = 40;
    private static final Integer MAX_CHARGE = 500;

    public FourteenthSonic() {
        super((new Item.Properties()).stacksTo(1).tab(ModItemGroup.ASEOHA_GROUP).setISTER(() -> {
            return SonicRenderer::new;
        }));
    }

    public ActionResult use(World worldIn, PlayerEntity playerIn, Hand handIn) {
//        if(playerIn != null){
        aseoha.LOGGER.info("inside use");
        ItemStack itemstack = playerIn.getItemInHand(handIn);
        if (playerIn.getUsedItemHand() != null && !worldIn.isClientSide() && !playerIn.getCooldowns().isOnCooldown(itemstack.getItem()) && !playerIn.isShiftKeyDown()) {
            playerIn.startUsingItem(handIn);
            aseoha.LOGGER.info("inside if not shift key on server");

            if(!worldIn.isClientSide) playerIn.displayClientMessage(new TranslationTextComponent("hi"), true);
        }

//        if (worldIn.isClientSide() && playerIn.isShiftKeyDown()) {
//
//            aseoha.LOGGER.info("inside if shift key on client");
//            ClientHelper.openGUI(27, new GuiContext());
//        }

        aseoha.LOGGER.info("success");
        return new ActionResult(ActionResultType.SUCCESS, itemstack);
//    }
//        return new ActionResult(ActionResultType.PASS);
        }

    public void releaseUsing(ItemStack stack, World world, LivingEntity livingEntity, int timeLeft) {
        if (!world.isClientSide) {
//            AbstractSonicMode mode = getCurrentMode(stack);
            if (livingEntity instanceof PlayerEntity) {
                PlayerEntity player = (PlayerEntity) livingEntity;
                RayTraceResult raytraceresult = PlayerHelper.getPosLookingAt(player, 10);
                if (raytraceresult != null) {
                    if (raytraceresult.getType() == Type.BLOCK) {
                        if(!world.isClientSide) ((PlayerEntity) livingEntity).displayClientMessage(new TranslationTextComponent("hi"), true);
                    }
                }
            }
        }
//                        BlockRayTraceResult blockraytraceresult = (BlockRayTraceResult)raytraceresult;
//                        BlockPos pos = blockraytraceresult.getBlockPos();
//                        boolean flag = mode.processBlock(player, world.getBlockState(pos), player.getUseItem(), pos);
//                        this.runPassFail(player, world, pos, flag);
//                        SonicCapability.getForStack(stack).ifPresent((cap) -> {
//                            cap.sync(player, Hand.MAIN_HAND);
//                        });
//                    } else if (raytraceresult.getType() == Type.ENTITY) {
//                        EntityRayTraceResult entityRayTraceResult = (EntityRayTraceResult)raytraceresult;
//                        boolean worked = mode.processEntity(player, entityRayTraceResult.getEntity(), stack);
//                        this.runPassFail(player, world, entityRayTraceResult.getEntity().blockPosition(), worked);
//                        SonicCapability.getForStack(stack).ifPresent((cap) -> {
//                            cap.sync(player, Hand.MAIN_HAND);
//                        });
//                    }
//                }
//            }
//
//        }
    }



    public ActionResultType useOn(ItemUseContext context) {
        World worldIn = context.getLevel();
        BlockPos blockpos = context.getClickedPos();
        TileEntity clicked = worldIn.getBlockEntity(blockpos);
//        Block clickedBlock = worldIn.block(blockpos);
//        TileEntity clickedEnt = worldIn.get
        if (clicked instanceof ExteriorTile && worldIn != null && blockpos != null) {
            ((ExteriorTile) clicked).setAdditionalLockLevel(0);
            ((ExteriorTile) clicked).setLocked(false);
            ((ExteriorTile) clicked).setDoorState(EnumDoorState.ONE);
            ((ExteriorTile) clicked).copyDoorStateToInteriorDoor();
            return ActionResultType.SUCCESS;
        }
//        if(clickedBlock instanceof TNTBlock)
//        if (clicked instanceof Interior && worldIn != null && blockpos != null) {
//            ((ExteriorTile) clicked).setAdditionalLockLevel(0);
//            ((ExteriorTile) clicked).setLocked(false);
//            ((ExteriorTile) clicked).setDoorState(EnumDoorState.ONE);
//            ((ExteriorTile) clicked).copyDoorStateToInteriorDoor();
//            return ActionResultType.SUCCESS;
//        }
        else return ActionResultType.FAIL;
    }

    public void runPassFail(PlayerEntity playerEntity, World world, BlockPos pos, boolean worked) {
        world.playSound(null, (double)pos.getX(), (double)pos.getY(), (double)pos.getZ(), worked ? (SoundEvent)TSounds.SONIC_GENERIC.get() : (SoundEvent)TSounds.SONIC_FAIL.get(), SoundCategory.PLAYERS, 0.25F, 1.0F);
        if (worked) {
            playerEntity.getCooldowns().addCooldown(this, COOLDOWN_TIME);
        }

    }

    public void onUsingTick(ItemStack stack, LivingEntity player, int count) {
//        getCurrentMode(stack).updateHeld((PlayerEntity)player, stack);
    }

    public void inventoryTick(ItemStack stack, World worldIn, Entity entityIn, int itemSlot, boolean isSelected) {
        super.inventoryTick(stack, worldIn, entityIn, itemSlot, isSelected);
        if (entityIn instanceof PlayerEntity) {
//            stack.getCapability(Capabilities.SONIC_CAPABILITY).ifPresent((cap) -> {
//                AbstractSonicMode mode = getCurrentMode(stack);
//                if (mode != null) {
//                    mode.inventoryTick((PlayerEntity)entityIn, stack);
//                }

//            });
        }

    }

    public void appendHoverText(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        if (worldIn != null) {
            SonicCapability.getForStack(stack).ifPresent((data) -> {
                if (data.getTardis() != null && this.getTardisName(stack) != null) {
                    tooltip.add((new TranslationTextComponent("tooltip.item.attuned.owner")).append((new StringTextComponent(this.getTardisName(stack))).withStyle(TextFormatting.LIGHT_PURPLE)));
                } else {
                    tooltip.add(Translations.TOOLTIP_NO_ATTUNED);
                }

                tooltip.add(Translations.TOOLTIP_HOLD_SHIFT);
                tooltip.add(Translations.TOOLTIP_CONTROL);
                AbstractSonicMode mode;
                if (Screen.hasShiftDown()) {
                    tooltip.clear();
                    tooltip.add(0, stack.getHoverName());
//                    mode = getCurrentMode(stack);
//                    tooltip.add(new TranslationTextComponent("sonic.mode.type", new Object[]{mode.getTranslation().withStyle(TextFormatting.GRAY)}));
//                    tooltip.add(new TranslationTextComponent("sonic.mode.type.desc", new Object[]{(new TranslationTextComponent(mode.getDescriptionLangKey())).withStyle(TextFormatting.GRAY)}));
                    tooltip.add(new TranslationTextComponent("sonic.mode.charge", new Object[]{data.getCharge()}));
                    tooltip.add(new TranslationTextComponent("tooltip.tardis.stored_schematic"));
                    List<ITextComponent> schematicTexts = TextHelper.getSchematicsInList(data.getSchematics());
                    tooltip.addAll(schematicTexts);
                }

                if (Screen.hasControlDown()) {
                    tooltip.clear();
                    tooltip.add(0, stack.getHoverName());
//                    mode = getCurrentMode(stack);
//                    if (mode.hasAdditionalInfo()) {
//                        tooltip.addAll(mode.getAdditionalInfo());
//                    } else if (mode.hasAdditionalInfo()) {
//                        tooltip.add(Translations.TOOLTIP_HOLD_SHIFT);
//                    }
                }

            });
        }
    }

//    public void onCraftedBy(ItemStack stack, World worldIn, PlayerEntity playerIn) {
//        super.onCraftedBy(stack, worldIn, playerIn);
//        SonicCapability.getForStack(stack).ifPresent(ISonic::randomiseParts);
//    }

    public ActionResultType interactLivingEntity(ItemStack sonic, PlayerEntity player, LivingEntity target, Hand hand) {
//        AbstractSonicMode mode = getCurrentMode(sonic);
        if (player.getCooldowns().isOnCooldown(sonic.getItem())) {
            return ActionResultType.FAIL;
        } else {
//            boolean flag = mode.processEntity(player, target, sonic);
//            this.runPassFail(player, player.level, target.blockPosition(), flag);
            return ActionResultType.PASS;
        }
    }

    public int getUseDuration(ItemStack stack) {
        return Integer.MAX_VALUE;
    }

    public boolean canAttackBlock(BlockState state, World worldIn, BlockPos pos, PlayerEntity player) {
        return true;
    }

    public boolean shouldOverrideMultiplayerNbt() {
        return true;
    }

    @Nullable
    public CompoundNBT getShareTag(ItemStack stack) {
        CompoundNBT tag = stack.getOrCreateTag();
        SonicCapability.getForStack(stack).ifPresent((handler) -> {
            tag.put("cap_sync", handler.serializeNBT());
        });
        return tag;
    }

    public void readShareTag(ItemStack stack, @Nullable CompoundNBT nbt) {
        super.readShareTag(stack, nbt);
        if (nbt != null && nbt.contains("cap_sync")) {
            SonicCapability.getForStack(stack).ifPresent((handler) -> {
                handler.deserializeNBT(nbt.getCompound("cap_sync"));
            });
        }

    }

    public boolean shouldCauseReequipAnimation(ItemStack oldStack, ItemStack newStack, boolean slotChanged) {
        return oldStack.getItem() != newStack.getItem();
    }

    public float charge(ItemStack stack, float amount, boolean simulate) {
        float charge = this.getCharge(stack);
        float maxCharge = this.getMaxCharge(stack);
        if (charge + amount >= maxCharge) {
            float chargeToAdd = maxCharge - charge;
            this.writeCharge(stack, chargeToAdd, false);
            return chargeToAdd;
        } else {
            this.writeCharge(stack, amount, false);
            return amount;
        }
    }

    public float discharge(ItemStack stack, float amount, boolean simulate) {
        float current = this.getCharge(stack);
        if (amount <= current) {
            this.writeCharge(stack, amount, true);
            return amount;
        } else {
            this.writeCharge(stack, 0.0F, true);
            return current;
        }
    }

    public float getCharge(ItemStack stack) {
        ISonic data = (ISonic)SonicCapability.getForStack(stack).orElse((ISonic) null);
        return data.getCharge();
    }

    public float getMaxCharge(ItemStack stack) {
        ISonic data = (ISonic)SonicCapability.getForStack(stack).orElse((ISonic) null);
        return data != null ? data.getMaxCharge() : (float)MAX_CHARGE;
    }

    public void writeCharge(ItemStack stack, float charge, boolean discharge) {
        ISonic data = (ISonic)SonicCapability.getForStack(stack).orElse((ISonic) null);
        data.setCharge(discharge ? this.getCharge(stack) - charge : this.getCharge(stack) + charge);
    }

    public ItemStack onAttuned(ItemStack stack, ConsoleTile tile) {
        this.setTardis(stack, Objects.requireNonNull(tile.getLevel()).dimension().location());
        tile.getLevel().getCapability(Capabilities.TARDIS_DATA).ifPresent((data) -> {
            this.setTardisName(stack, data.getTARDISName());
        });
        return stack;
    }

    public int getAttunementTime() {
        return 3600;
    }

    public ResourceLocation getTardis(ItemStack stack) {
        ISonic remote = (ISonic)stack.getCapability(Capabilities.SONIC_CAPABILITY).orElse((ISonic) null);
        return remote == null ? null : remote.getTardis();
    }

    public void setTardis(ItemStack stack, ResourceLocation world) {
        stack.getCapability(Capabilities.SONIC_CAPABILITY).ifPresent((sonic) -> {
            sonic.setTardis(world);
        });
    }

    public String getTardisName(ItemStack stack) {
        return stack.getTag() != null && stack.getTag().contains("tardis_name") ? stack.getTag().getString("tardis_name") : null;
    }

    public void setTardisName(ItemStack stack, String name) {
        stack.getOrCreateTag().putString("tardis_name", name);
    }

    public float charge(ItemStack stack, float amount) {
        return this.charge(stack, amount, false);
    }

    public float discharge(ItemStack stack, float amount) {
        return this.discharge(stack, amount, false);
    }
}
