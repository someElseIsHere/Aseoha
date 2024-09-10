package com.code.aseoha.tileentities.exteriors;

import com.code.aseoha.texturevariants.TextureVariants;
import com.code.aseoha.tileentities.AseohaTiles;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraftforge.client.event.TextureStitchEvent;
import net.tardis.mod.tileentities.exteriors.ExteriorTile;

import static net.minecraft.entity.ai.RandomPositionGenerator.getPos;

public class OlwarriorTile extends ExteriorTile {

    public static final AxisAlignedBB RENDER = new AxisAlignedBB(-1, -1, -1, 2, 2, 2);
    public OlwarriorTile() {
        super(AseohaTiles.exterior_olwarrior.get());
        this.setVariants(TextureVariants.OLWARRIOR);}

    @Override
    public AxisAlignedBB getDoorAABB() {
        if (level!= null && level.getBlockState(getBlockPos()).hasProperty(BlockStateProperties.HORIZONTAL_FACING)){
            switch(level.getBlockState(this.getBlockPos()).getValue(BlockStateProperties.HORIZONTAL_FACING)) {
                case EAST:
                    return new AxisAlignedBB(0.5, -1, 0, 1.1, 1, 1);
                case SOUTH:
                    return new AxisAlignedBB(0, -1, 0.5, 1, 1, 1.1);
                case WEST:
                    return new AxisAlignedBB(-0.1, -1, 0, 0.5, 1, 1);
                default:
                    return new AxisAlignedBB(0, 0, -0.1, 1, 2, 0.5);
            }
        }
        return new AxisAlignedBB(0, 0, 0, 0, 0, 0);
    }

//    @Override
//    public AxisAlignedBB getRenderBoundingBox() {
//        return RENDER.offset(this.getBlockPos());
//    }
}