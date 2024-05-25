//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.code.aseoha.tileentities.consoles;

import com.code.aseoha.texturevariants.ConsoleTextureVariants;
import com.code.aseoha.tileentities.AseohaTiles;
import net.minecraft.entity.EntitySize;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.vector.Vector3d;
import net.tardis.mod.controls.*;
import net.tardis.mod.registries.ControlRegistry;
import net.tardis.mod.tileentities.ConsoleTile;
import net.tardis.mod.tileentities.TTiles;
import net.tardis.mod.tileentities.console.misc.ControlOverride;

public class CopperConsoleTile extends ConsoleTile {



    public CopperConsoleTile() {
        this(AseohaTiles.console_copper.get());
//        super((TileEntityType)AseohaTiles.CONSOLE_COPPER.get());
        this.variants = ConsoleTextureVariants.COPPER;
    }

    public CopperConsoleTile(TileEntityType<?> type) {

        super(type);
//        this.controlOverrides.put(FacingControl.class new ControlOverride(new Vector3d()))
//        this.registerControlEntry(ControlRegistry.MONITOR.get());
        this.controlOverrides.put(FacingControl.class, new ControlOverride(new Vector3d(-0.45, 1.0, 0.125), EntitySize.scalable(0.15F, 0.15F)));
        //Done
        this.controlOverrides.put(StabilizerControl.class, new ControlOverride(new Vector3d(0.50, 0.75, 0.35),EntitySize.scalable(0.15F, 0.15F)));
        //Done
        this.controlOverrides.put(TelepathicControl.class, new ControlOverride(new Vector3d(0.35, 1.0, -0.225),EntitySize.scalable(0.2F, 0.15F)));
        //Done
        this.controlOverrides.put(CommunicatorControl.class, new ControlOverride(new Vector3d(-0.5, 1.0, -0.4),EntitySize.scalable(0.1875F, 0.1875F)));
        //Done
        this.controlOverrides.put(RefuelerControl.class, new ControlOverride(new Vector3d(0.18, 1.0, -0.7),EntitySize.scalable(0.175F, 0.075F)));
        //Done
        this.controlOverrides.put(RandomiserControl.class, new ControlOverride(new Vector3d(-0.65, 1.0, 0.125),EntitySize.scalable(0.15F, 0.15F)));
        //Done
        this.controlOverrides.put(HandbrakeControl.class, new ControlOverride(new Vector3d(-0.301, 0.750, 0.300),EntitySize.scalable(0.15F, 0.15F)));
        //Done
        this.controlOverrides.put(DoorControl.class, new ControlOverride(new Vector3d(-0.6, 1.0, -0.125),EntitySize.scalable(0.1875F, 0.1875F)));
        //Done
        this.controlOverrides.put(IncModControl.class, new ControlOverride(new Vector3d(-0.24, 1.0, -0.7),EntitySize.scalable(0.075F, 0.075F)));
        //Done
        this.controlOverrides.put(DimensionControl.class, new ControlOverride(new Vector3d(-0, 1.55, -0.45),EntitySize.scalable(0.3F, 0.2F)));
        //Done
        this.controlOverrides.put(LandingTypeControl.class, new ControlOverride(new Vector3d(-0.45, 1.5, 0.5),EntitySize.scalable(0.15F, 0.15F)));

        this.controlOverrides.put(SonicPortControl.class, new ControlOverride(new Vector3d(-0.4, .7, -0.1),EntitySize.scalable(0.15F, 0.15F)));
        //Done
        this.controlOverrides.put(XControl.class, new ControlOverride(new Vector3d(0.02, 1.0, -0.7),EntitySize.scalable(0.075F, 0.075F)));
        //Done
        this.controlOverrides.put(YControl.class, new ControlOverride(new Vector3d(-0.065, 1.0, -0.7),EntitySize.scalable(0.075F, 0.075F)));
        //Done
        this.controlOverrides.put(ZControl.class, new ControlOverride(new Vector3d(-0.15, 1.0, -0.7),EntitySize.scalable(0.075F, 0.075F)));

        this.controlOverrides.put(ThrottleControl.class, new ControlOverride(new Vector3d(0.165, 1.0, 0.575),EntitySize.scalable(0.2F, 0.15F)));
        //Done
        this.controlOverrides.put(FastReturnControl.class, new ControlOverride(new Vector3d(0.575, 1.0, -0.325),EntitySize.scalable(0.15F, 0.15F)));

    }

    public AxisAlignedBB getRenderBoundingBox() {
        return (new AxisAlignedBB(this.getBlockPos())).expandTowards(2.0, 4.0, 2.0);
    }
//    public ItemStack getSonicItem() {
//            return this.sonic;
//        }
}
