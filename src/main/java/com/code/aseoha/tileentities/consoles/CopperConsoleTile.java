//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.code.aseoha.tileentities.consoles;

import com.code.aseoha.texturevariants.ConsoleTextureVariants;
import com.code.aseoha.tileentities.AseohaTiles;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.math.AxisAlignedBB;
import net.tardis.mod.registries.ControlRegistry;
import net.tardis.mod.tileentities.ConsoleTile;
import net.tardis.mod.tileentities.TTiles;

public class CopperConsoleTile extends ConsoleTile {
    public CopperConsoleTile() {
        super((TileEntityType)AseohaTiles.CONSOLE_COPPER.get());
        this.variants = ConsoleTextureVariants.COPPER;
    }

    public CopperConsoleTile(TileEntityType<?> type) {
        super(type);
    }

    public AxisAlignedBB getRenderBoundingBox() {
        return (new AxisAlignedBB(this.getBlockPos())).expandTowards(2.0, 4.0, 2.0);
    }
//    public ItemStack getSonicItem() {
//            return this.sonic;
//        }
}
