package com.code.aseoha.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalBlock;
import net.minecraft.block.material.PushReaction;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.tardis.mod.constants.TardisConstants;
import net.tardis.mod.helper.WorldHelper;
import net.tardis.mod.properties.Prop;

public class FoodMachineBlock extends HorizontalBlock {
    public static final DirectionProperty facing;
    public static final BooleanProperty WATERLOGGED;
    protected static final VoxelShape east;
    protected static final VoxelShape west;
    protected static final VoxelShape south;
    protected static final VoxelShape north;
    public static final DirectionProperty HORIZONTAL_FACING = BlockStateProperties.HORIZONTAL_FACING;
    public FoodMachineBlock(Properties properties) {
        super(Prop.Blocks.BASIC_TECH.get());
    }

    //Recycled from various Java Blocks (Bell, Anvil, Chest, ect..
    public VoxelShape getShape(BlockState blockState, IBlockReader p_220053_2_, BlockPos p_220053_3_, ISelectionContext p_220053_4_) {
        switch ((Direction)blockState.getValue(facing)) {
            case NORTH:
                return north;
            case SOUTH:
                return south;
            case WEST:
                return west;
            case EAST:
            default:
                return east;
        }
    }

//    @Override
    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
        builder.add(BlockStateProperties.HORIZONTAL_FACING);
    }

    @Override
    public BlockState getStateForPlacement(BlockItemUseContext context) {

        return this.defaultBlockState().setValue(HORIZONTAL_FACING, context.getHorizontalDirection().getOpposite());

    }

    public BlockState rotate(BlockState blockState, Rotation rotation) {
        return (BlockState)blockState.setValue(facing, rotation.rotate((Direction)blockState.getValue(facing)));
    }

    public BlockState mirror(BlockState blockState, Mirror mirror) {
        return blockState.rotate(mirror.getRotation((Direction)blockState.getValue(facing)));
    }

    //Recycled from ARS Egg
    public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult hit) {
        if (!WorldHelper.isDimensionBlocked(worldIn)) {
            if (worldIn.isClientSide) {
                if (player.isCrouching()) {
                    player.addItem(new ItemStack(Items.COOKED_BEEF, 16));
                }
                else  {
                    player.addItem(new ItemStack(Items.COOKED_BEEF, 1));
                }
            }
        } else if (!worldIn.isClientSide()) {
            player.displayClientMessage(TardisConstants.Translations.NO_USE_OUTSIDE_TARDIS, true);
        }

        return ActionResultType.SUCCESS;
    }

    public PushReaction getPushReaction(BlockState p_149656_1_) {
        return PushReaction.DESTROY;
    }

    static {
        facing = HorizontalBlock.FACING;
        WATERLOGGED = BlockStateProperties.WATERLOGGED;
        north = Block.box(3, 0.0, 3.5, 13.0, 23.0, 12.0);
        west = Block.box(3.5, 0.0, 3, 12.0, 23.0, 13.0);
        south = Block.box(3, 0.0, 3.5, 13.0, 23.0, 12.0);
        east = Block.box(3.5, 0.0, 3, 12.0, 23.0, 13.0);
    }
}