//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.code.aseoha.tileentities.consoles;

import com.code.aseoha.block.ModBlocks;
import com.code.aseoha.texturevariants.TextureVariants;
import com.code.aseoha.tileentities.AseohaTiles;
import net.minecraft.entity.EntitySize;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.vector.Vector3d;
import net.tardis.mod.controls.*;
import net.tardis.mod.entity.ControlEntity;
import net.tardis.mod.registries.ControlRegistry;
import net.tardis.mod.texturevariants.ConsoleTextureVariants;
import net.tardis.mod.tileentities.ConsoleTile;
import net.tardis.mod.tileentities.TTiles;
import net.tardis.mod.tileentities.console.misc.ControlOverride;

import java.util.ArrayList;

public class CopperConsoleTile extends ConsoleTile implements ITickableTileEntity {

    public static final AxisAlignedBB RENDER_BOX = new AxisAlignedBB(-2, -1, -2, 2, 2.5, 2);
//    private ArrayList<ControlEntity> controls = new ArrayList();
//    private ArrayList<ControlRegistry.ControlEntry<?>> controlEntries = new ArrayList();

//    private static final AxisAlignedBB CONRTROL_HITBOX = new AxisAlignedBB(-1.0D, 0.0D, -1.0D, 2.0D, 2.0D, 2.0D);
//    private ArrayList<ControlEntity> controls = new ArrayList();
//    private ArrayList<ControlRegistry.ControlEntry> controlEntries = new ArrayList();

    @Override
    public AxisAlignedBB getRenderBoundingBox() {return (new AxisAlignedBB(this.getBlockPos())).expandTowards(2.7, 5.0, 2.7).expandTowards(-2.7,-1,-2.7);
//        return RENDER_BOX.getCenter(this.getPos());
    }
    public CopperConsoleTile(){
        this(AseohaTiles.console_copper.get());
        this.variants = TextureVariants.COPPER;
        this.registerControlEntry(ControlRegistry.MONITOR.get());
    }
    public CopperConsoleTile(TileEntityType<?> type) {
//        this(AseohaTiles.console_copper.get());
        super(type);
//        this.registerControlEntry((ControlRegistry.ControlEntry)ControlRegistry.MONITOR.get());
//        this.registerControlEntry(ControlRegistry.MONITOR.get());

//        this.controlOverrides.put(FacingControl.class, new ControlOverride(new Vector3d(-0.7534763617803086, 1.0, -0.36382471213789824), EntitySize.scalable(0.1875F, 0.1875F)));
//        this.controlOverrides.put(StabilizerControl.class, new ControlOverride(new Vector3d(-1.1643087550660156, 0.5, 0.3481751412158103), EntitySize.scalable(0.1875F, 0.1875F)));
        this.controlOverrides.put(TelepathicControl.class, new ControlOverride(new Vector3d(0.5808923733179254, 0.9375, 0.37844622476966494), EntitySize.scalable(0.3125F, 0.3125F)));
        this.controlOverrides.put(CommunicatorControl.class, new ControlOverride(new Vector3d(-0.03427925665249065, 0.9375, 0.6399601835707498), EntitySize.scalable(0.3125F, 0.3125F)));
//        this.controlOverrides.put(RefuelerControl.class, new ControlOverride(new Vector3d(-0.7957924223912113, 0.59375, -0.9627021071937257), EntitySize.scalable(0.25F, 0.25F)));
        this.controlOverrides.put(RandomiserControl.class, new ControlOverride(new Vector3d(-0.02549972424349578, 0.59375, 1.1994270443266681), EntitySize.scalable(0.375F, 0.375F)));
        this.controlOverrides.put(MonitorControl.class, new ControlOverride(new Vector3d(-0.400, 1.6, -0.125), EntitySize.scalable(0.7F, 0.7F)));

        this.controlOverrides.put(FacingControl.class, new ControlOverride(new Vector3d(-1.20, 0.6, -0.485), EntitySize.scalable(0.1F, 0.1F)));
        //Done
        this.controlOverrides.put(StabilizerControl.class, new ControlOverride(new Vector3d(0.86, 0.55, 0.60),EntitySize.scalable(0.15F, 0.19F)));
        //Done
//        this.controlOverrides.put(TelepathicControl.class, new ControlOverride(new Vector3d(-0.09, 0.5, 1.07),EntitySize.scalable(0.4F, 0.30F)));
        //Done
//        this.controlOverrides.put(CommunicatorControl.class, new ControlOverride(new Vector3d(-1.20, .4, -0.7075),EntitySize.scalable(0.40F, 0.09375F)));
        //Done
        this.controlOverrides.put(RefuelerControl.class, new ControlOverride(new Vector3d(-0.85, 0.6, -1.01),EntitySize.scalable(0.20F, 0.25F)));
        //Done
//        this.controlOverrides.put(RandomiserControl.class, new ControlOverride(new Vector3d(-0.885, 0.83, 0.115),EntitySize.scalable(0.15F, 0.15F)));
        //Done
        this.controlOverrides.put(HandbrakeControl.class, new ControlOverride(new Vector3d(-1.12, 0.7, 0.08),EntitySize.scalable(0.15F, 0.28F)));
        //Done
        this.controlOverrides.put(DoorControl.class, new ControlOverride(new Vector3d(0.96, 0.7, -0.2425),EntitySize.scalable(0.195F, 0.2F)));
        //Done
        this.controlOverrides.put(IncModControl.class, new ControlOverride(new Vector3d(-0.80, 0.6, 0.86),EntitySize.scalable(0.20F, 0.20F)));
        //Done
        this.controlOverrides.put(DimensionControl.class, new ControlOverride(new Vector3d(-0.95, 0.6, -0.56),EntitySize.scalable(0.2F, 0.2F)));
        //Done
        this.controlOverrides.put(LandingTypeControl.class, new ControlOverride(new Vector3d(0.80, 0.7, 0.1),EntitySize.scalable(0.20F, 0.40F)));

        this.controlOverrides.put(SonicPortControl.class, new ControlOverride(new Vector3d(-0.95, .7, 0.255),EntitySize.scalable(0.15F, 0.15F)));
        //Done
        this.controlOverrides.put(XControl.class, new ControlOverride(new Vector3d(0.69, 0.72, -0.67),EntitySize.scalable(0.075F, 0.075F)));
        //Done
        this.controlOverrides.put(YControl.class, new ControlOverride(new Vector3d(0.742, 0.65, -0.757),EntitySize.scalable(0.075F, 0.075F)));
        //Done
        this.controlOverrides.put(ZControl.class, new ControlOverride(new Vector3d(0.86, 0.6, -0.78),EntitySize.scalable(0.075F, 0.075F)));

        this.controlOverrides.put(ThrottleControl.class, new ControlOverride(new Vector3d(-0.42, 0.7, -1.0),EntitySize.scalable(0.25F, 0.32F)));
        //Done
        this.controlOverrides.put(FastReturnControl.class, new ControlOverride(new Vector3d(0.235, 0.7, -0.965),EntitySize.scalable(0.17F, 0.15F)));




        //        this.controlOverrides.put(HandbrakeControl.class, new ControlOverride(new Vector3d(0.9018302967985694, 0.6875, 0.16320698191949234), EntitySize.scalable(0.3125F, 0.3125F)));
//        this.controlOverrides.put(DoorControl.class, new ControlOverride(new Vector3d(1.0612555327866224, 0.625, -0.20421105175829007), EntitySize.scalable(0.1875F, 0.1875F)));
//        this.controlOverrides.put(IncModControl.class, new ControlOverride(new Vector3d(-0.7819954465462516, 0.5, 0.9752763159530988), EntitySize.scalable(0.1875F, 0.1875F)));
//        this.controlOverrides.put(DimensionControl.class, new ControlOverride(new Vector3d(-0.943399030463922, 0.46875, 0.6762460544720672), EntitySize.scalable(0.25F, 0.25F)));
//        this.controlOverrides.put(LandingTypeControl.class, new ControlOverride(new Vector3d(-1.0773927240168533, 0.65625, 0.1583647495799516), EntitySize.scalable(0.25F, 0.25F)));
//        this.controlOverrides.put(SonicPortControl.class, new ControlOverride(new Vector3d(-0.9046691972354738, 0.59375, 0.30652076157766595), EntitySize.scalable(0.25F, 0.25F)));
//        this.controlOverrides.put(XControl.class, new ControlOverride(new Vector3d(0.7459119752741321, 0.59375, -0.6373257471276913), EntitySize.scalable(0.125F, 0.125F)));
//        this.controlOverrides.put(YControl.class, new ControlOverride(new Vector3d(0.8036497612525688, 0.53125, -0.7272156070800373), EntitySize.scalable(0.125F, 0.125F)));
//        this.controlOverrides.put(ZControl.class, new ControlOverride(new Vector3d(0.9447360798374431, 0.46875, -0.7307087149206982), EntitySize.scalable(0.125F, 0.125F)));
//        this.controlOverrides.put(ThrottleControl.class, new ControlOverride(new Vector3d(-0.39533487419456625, 0.71875, -0.9099839260870719), EntitySize.scalable(0.375F, 0.375F)));
//        this.controlOverrides.put(MonitorControl.class, new ControlOverride(new Vector3d(-0.8346974723292676, 1.71875, -0.482832463322669), EntitySize.scalable(0.5F, 0.5F)));
//        this.controlOverrides.put(FastReturnControl.class, new ControlOverride(new Vector3d(0.3293461423898616, 0.65625, -0.9830153875983476), EntitySize.scalable(0.25F, 0.25F)));

    }


//        this.controlOverrides.put(FacingControl.class new ControlOverride(new Vector3d()))



//    public AxisAlignedBB getRenderBoundingBox() {
//        return (new AxisAlignedBB(this.getBlockPos())).expandTowards(2.7, 5.0, 2.7);
//    }
//    public ItemStack getSonicItem() {
//            return this.sonic;
//        }
}
