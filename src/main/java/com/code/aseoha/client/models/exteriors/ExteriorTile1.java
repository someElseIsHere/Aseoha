package com.code.aseoha.client.models.exteriors;

import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.math.AxisAlignedBB;
import net.tardis.mod.tileentities.exteriors.ExteriorTile;
public class ExteriorTile1 extends ExteriorTile{
    public ExteriorTile1(TileEntityType<?> tileEntityTypeIn) {
        super(tileEntityTypeIn);
        this.setLightLevel(15);
        lightLevel = 15;
    }

    @Override
    public AxisAlignedBB getDoorAABB() {
        return null;
    }

    @Override
    public int getLightEmittingLevel(){
        return 15;
    }


}
//    @Override
//    public int getLightEmittingLevel() {
//        super.getLightEmittingLevel();
//        return 15;
//    }