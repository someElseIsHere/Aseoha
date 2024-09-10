package com.code.aseoha.tileentities.consoles;


import com.code.aseoha.texturevariants.TextureVariants;
import com.code.aseoha.tileentities.AseohaTiles;
import net.minecraft.entity.EntitySize;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.vector.Vector3d;
import net.tardis.mod.controls.*;
import net.tardis.mod.registries.ControlRegistry;
import net.tardis.mod.tileentities.ConsoleTile;
import net.tardis.mod.tileentities.console.misc.ControlOverride;


public class CustardConsoleTile extends ConsoleTile {

    public static final AxisAlignedBB RENDER_BOX = new AxisAlignedBB(-2, -1, -2, 2, 2.5, 2);

//    @Override
//    public AxisAlignedBB getRenderBoundingBox() {return (new AxisAlignedBB(this.getBlockPos())).expandTowards(2.7, 5.0, 2.7);
////        return RENDER_BOX.getCenter(this.getPos());
//    }

    public CustardConsoleTile() {
        this(AseohaTiles.console_custard.get());
//        this.registerControlEntry(ControlRegistry.MONITOR.get());
        this.variants = TextureVariants.CUSTARD;
    }

    public CustardConsoleTile(TileEntityType<?> type) {
        super(type);
//       this.registerControlEntry(ControlRegistry.MONITOR.get());
      //Done
       this.controlOverrides.put(FacingControl.class, new ControlOverride(new Vector3d(-0.45, 0.6, 0.125),EntitySize.scalable(0.15F, 0.15F)));
       //Done
       this.controlOverrides.put(StabilizerControl.class, new ControlOverride(new Vector3d(-0.4, 0.6, 0.35),EntitySize.scalable(0.15F, 0.15F)));
       //Done
       this.controlOverrides.put(TelepathicControl.class, new ControlOverride(new Vector3d(0.35, 0.6, -0.225),EntitySize.scalable(0.2F, 0.15F)));
        //Done
       this.controlOverrides.put(CommunicatorControl.class, new ControlOverride(new Vector3d(-0.5, 0.475, -0.4),EntitySize.scalable(0.1875F, 0.1875F)));
        //Done
       this.controlOverrides.put(RefuelerControl.class, new ControlOverride(new Vector3d(0.47, 1, -0.264),EntitySize.scalable(0.125F, 0.125F)));
        //Done
       this.controlOverrides.put(RandomiserControl.class, new ControlOverride(new Vector3d(-0.65, 0.5, 0.125),EntitySize.scalable(0.15F, 0.15F)));
        //Done
       this.controlOverrides.put(HandbrakeControl.class, new ControlOverride(new Vector3d(-0.509, 1.1, 0),EntitySize.scalable(0.25F, 0.25F)));
        //Done
       this.controlOverrides.put(DoorControl.class, new ControlOverride(new Vector3d(-0.7, .7, -0.382),EntitySize.scalable(0.12499999999999997F, 0.125F)));
       //Done
       this.controlOverrides.put(IncModControl.class, new ControlOverride(new Vector3d(-0.24, 0.5, -0.7),EntitySize.scalable(0.075F, 0.075F)));
        //Done
       this.controlOverrides.put(DimensionControl.class, new ControlOverride(new Vector3d(-0, 0.55, -0.45),EntitySize.scalable(0.3F, 0.2F)));
        //Done
       this.controlOverrides.put(LandingTypeControl.class, new ControlOverride(new Vector3d(-0.45, 0.5, 0.5),EntitySize.scalable(0.15F, 0.15F)));

       this.controlOverrides.put(SonicPortControl.class, new ControlOverride(new Vector3d(-0.4, 0.6, -0.1),EntitySize.scalable(0.15F, 0.15F)));
       //Done
       this.controlOverrides.put(XControl.class, new ControlOverride(new Vector3d(0.02, 0.5, -0.7),EntitySize.scalable(0.075F, 0.075F)));
       //Done
       this.controlOverrides.put(YControl.class, new ControlOverride(new Vector3d(-0.065, 0.5, -0.7),EntitySize.scalable(0.075F, 0.075F)));
       //Done
       this.controlOverrides.put(ZControl.class, new ControlOverride(new Vector3d(-0.15, 0.5, -0.7),EntitySize.scalable(0.075F, 0.075F)));

       this.controlOverrides.put(ThrottleControl.class, new ControlOverride(new Vector3d(0.567, 1.1, 0),EntitySize.scalable(0.25F, 0.25F)));
       //Done
        this.controlOverrides.put(FastReturnControl.class, new ControlOverride(new Vector3d(0.575, 0.475, -0.325),EntitySize.scalable(0.15F, 0.15F)));

       this.controlOverrides.put(MonitorControl.class, new ControlOverride(new Vector3d(0.4,0.3,0.2),EntitySize.scalable(0.3125F, 0.3125F)));
    }


}