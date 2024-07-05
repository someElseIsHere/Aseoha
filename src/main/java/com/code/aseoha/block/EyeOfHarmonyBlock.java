package com.code.aseoha.block;
import com.code.aseoha.aseoha;
import net.minecraft.block.Block;
import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;
import net.minecraft.block.IWaterLoggable;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.PotionEntity;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.BlockItem;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.state.Property;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.text.IFormattableTextComponent;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.player.PlayerContainerEvent;
import net.tardis.mod.blocks.MultiblockBlock;
import net.tardis.mod.blocks.multiblock.MultiblockPatterns;
import net.tardis.mod.constants.TardisConstants;
import net.tardis.mod.constants.TardisConstants.Translations;
import net.tardis.mod.helper.*;
import net.tardis.mod.items.MultiblockBlockItem;
import net.tardis.mod.tileentities.ConsoleTile;
import net.tardis.mod.tileentities.machines.QuantiscopeTile;

import java.util.List;

public class EyeOfHarmonyBlock extends Block {
    public EyeOfHarmonyBlock(Properties prop) {
        super(prop);
        this.registerDefaultState((BlockState)this.defaultBlockState().setValue(BlockStateProperties.WATERLOGGED, false));
    }

    public BlockRenderType getRenderShape(BlockState state) {
        return BlockRenderType.MODEL;
    }

    protected void createBlockStateDefinition(StateContainer.Builder<Block, BlockState> builder) {
        builder.add(new Property[]{BlockStateProperties.HORIZONTAL_FACING, BlockStateProperties.WATERLOGGED});
    }

    public FluidState getFluidState(BlockState state) {
        return (Boolean)state.getValue(BlockStateProperties.WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(state);
    }

    @Override
    public void onPlace(BlockState blockState, World world, BlockPos blockpos, BlockState p_220082_4_, boolean p_220082_5_) {
        super.onPlace(blockState, world, blockpos, p_220082_4_, p_220082_5_);
//        ConsoleTile console = (ConsoleTile)world.getBlockEntity(TardisHelper.TARDIS_POS);

//        console.setMaxArtron(console.getMaxArtron() + (float) 32);
    }

    //    private boolean Used = false;
    private float ArtronAmount = Float.POSITIVE_INFINITY;
    private boolean OpenState = false;
//    private long time;
    public ActionResultType use(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult hit) {
        long time = worldIn.getGameTime();
        if (!WorldHelper.isDimensionBlocked(worldIn)) {
            ConsoleTile console = (ConsoleTile)worldIn.getBlockEntity(TardisHelper.TARDIS_POS);
            if(!worldIn.isClientSide) {

                for(; time-worldIn.getGameTime() < 15000; time++) {
                    if(OpenState){//(time-worldIn.getGameTime()) < 1500) {
//                        aseoha.LOGGER.info(time - worldIn.getGameTime());
                        player.addEffect(new EffectInstance(Effects.CONFUSION, 300));
                        console.setArtron(console.getMaxArtron());
                    }
                }
                OpenState = OpenState ? false : true;

//            if (!worldIn.isClientSide) {
//
//
//            }
//            if(console.getArtron() >= (float) (ArtronAmount*16)) {
            }
//            }
        } else if (WorldHelper.isDimensionBlocked(worldIn)) {
            player.displayClientMessage(TardisConstants.Translations.NO_USE_OUTSIDE_TARDIS, true);
        }

        return ActionResultType.SUCCESS;

    }

//    public static class ArtronBankItem extends BlockItem {
//        private final IFormattableTextComponent descriptionTooltip = TextHelper.createDescriptionItemTooltip(new TranslationTextComponent("tooltip.artronbank.desc"));
//
//        public ArtronBankItem(Block p_i48527_1_, Properties p_i48527_2_) {
//            super(p_i48527_1_, p_i48527_2_);
//        }

    //        public ArtronBankItem(Block blockIn, MultiblockPatterns.MultiblockPattern pattern, Properties builder) {
//            super(blockIn, pattern, builder);
//        }
    private final IFormattableTextComponent descriptionTooltip = TextHelper.createDescriptionItemTooltip(new TranslationTextComponent("tooltip.eoh.desc"));
    public void appendHoverText(ItemStack stack, World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        super.appendHoverText(stack, worldIn, tooltip, flagIn);

        tooltip.add(TardisConstants.Translations.TOOLTIP_CONTROL);
        if (Screen.hasControlDown()) {
            tooltip.clear();
            tooltip.add(0, stack.getHoverName());
            tooltip.add(this.descriptionTooltip);
        }

    }}

//    public void onRemove(BlockState state, World worldIn, BlockPos pos, BlockState newState, boolean isMoving) {
//        QuantiscopeTile tileEntity = (QuantiscopeTile)worldIn.getBlockEntity(pos);
//        if (tileEntity != null && state.getBlock() != newState.getBlock()) {
//            TInventoryHelper.dropInventoryItems(worldIn, pos, tileEntity);
//            worldIn.removeBlockEntity(pos);
//        ConsoleTile console = (ConsoleTile) worldIn.getBlockEntity(TardisHelper.TARDIS_POS);
//        if (worldIn.isClientSide) {
//            if(Used==true){
//        console.setMaxArtron(console.getMaxArtron() - 64);
//        Used=false;
//    }
//        }}
//    }



//package com.code.aseoha.block;
//
//import java.util.List;
//import net.minecraft.block.AbstractBlock;
//import net.minecraft.block.Block;
//import net.minecraft.block.BlockRenderType;
//import net.minecraft.block.BlockState;
//import net.minecraft.block.IWaterLoggable;
//import net.minecraft.client.gui.screen.Screen;
//import net.minecraft.client.util.ITooltipFlag;
//import net.minecraft.entity.player.PlayerEntity;
//import net.minecraft.entity.player.ServerPlayerEntity;
//import net.minecraft.fluid.FluidState;
//import net.minecraft.fluid.Fluids;
//import net.minecraft.item.BlockItemUseContext;
//import net.minecraft.item.Item;
//import net.minecraft.item.ItemStack;
//import net.minecraft.item.Items;
//import net.minecraft.state.Property;
//import net.minecraft.state.StateContainer;
//import net.minecraft.state.properties.BlockStateProperties;
//import net.minecraft.tags.FluidTags;
//import net.minecraft.util.ActionResultType;
//import net.minecraft.util.Hand;
//import net.minecraft.util.math.BlockPos;
//import net.minecraft.util.math.BlockRayTraceResult;
//import net.minecraft.util.text.IFormattableTextComponent;
//import net.minecraft.util.text.ITextComponent;
//import net.minecraft.util.text.TranslationTextComponent;
//import net.minecraft.world.World;
//import net.minecraftforge.fml.network.NetworkHooks;
//import net.tardis.mod.blocks.MultiblockBlock;
//import net.tardis.mod.blocks.multiblock.MultiblockPatterns;
//import net.tardis.mod.constants.TardisConstants;
//import net.tardis.mod.constants.TardisConstants.Translations;
//import net.tardis.mod.containers.WaypointBankContainer;
//import net.tardis.mod.helper.TextHelper;
//import net.tardis.mod.helper.WorldHelper;
//import net.tardis.mod.items.MultiblockBlockItem;
//import net.tardis.mod.misc.ContainerProvider;
//import net.tardis.mod.tileentities.WaypointBankTile;
//
//public class FoodMachineBlock extends MultiblockBlock implements IWaterLoggable {
//    public FoodMachineBlock(AbstractBlock.Properties prop) {
//        super(prop);
//        this.registerDefaultState((BlockState)this.defaultBlockState().setValue(BlockStateProperties.WATERLOGGED, false));
//    }
//
//    public BlockRenderType getRenderShape(BlockState state) {
//        return BlockRenderType.MODEL;
//    }
//
//    protected void createBlockStateDefinition(StateContainer.Builder<Block, BlockState> builder) {
//        builder.add(new Property[]{BlockStateProperties.HORIZONTAL_FACING, BlockStateProperties.WATERLOGGED});
//    }
//
//    public FluidState getFluidState(BlockState state) {
//        return (Boolean)state.getValue(BlockStateProperties.WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(state);
//    }
//
//    public BlockState getStateForPlacement(BlockItemUseContext context) {
//        FluidState fluid = context.getLevel().getFluidState(context.getClickedPos());
//        return (BlockState)((BlockState)super.getStateForPlacement(context).setValue(BlockStateProperties.HORIZONTAL_FACING, context.getPlayer().getDirection().getOpposite())).setValue(BlockStateProperties.WATERLOGGED, fluid.getFluidState().is(FluidTags.WATER));
//    }
//
//    public ActionResultType use(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult hit) {
////        if (!worldIn.isClientSide) {
////            NetworkHooks.openGui((ServerPlayerEntity)player, new ContainerProvider("container.tardis.waypoint", (id, inv, player1) -> {
////                return new WaypointBankContainer(id, inv, (WaypointBankTile)worldIn.getBlockEntity(pos));
////            }), pos);
////        }
////
////        return ActionResultType.SUCCESS;
//
//        if (!WorldHelper.isDimensionBlocked(worldIn)) {
//            if (worldIn.isClientSide) {
//                if (player.isCrouching()) {
//                    player.addItem(new ItemStack(Items.COOKED_BEEF, 16));
//                }
//                else  {
//                    player.addItem(new ItemStack(Items.COOKED_BEEF, 1));
//                }
//            }
//        } else if (!worldIn.isClientSide()) {
//            player.displayClientMessage(TardisConstants.Translations.NO_USE_OUTSIDE_TARDIS, true);
//        }
//
//        return ActionResultType.SUCCESS;
//    }
//
//}
//
//public static class FoodMachineBlockItem extends MultiblockBlockItem {
//    private final IFormattableTextComponent descriptionTooltip = TextHelper.createDescriptionItemTooltip(new TranslationTextComponent("tooltip.food_machine.desc"));
//
//    public FoodMachineBlockItem(Block blockIn, MultiblockPatterns.MultiblockPattern pattern, Item.Properties builder) {
//        super(blockIn, pattern, builder);
//    }
//
//    public void appendHoverText(ItemStack stack, World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
//        super.appendHoverText(stack, worldIn, tooltip, flagIn);
//        tooltip.add(Translations.TOOLTIP_CONTROL);
//        if (Screen.hasControlDown()) {
//            tooltip.clear();
//            tooltip.add(0, stack.getHoverName());
//            tooltip.add(this.descriptionTooltip);
//        }
//
//    }
//}
//}
