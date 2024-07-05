package com.code.aseoha.items;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUseContext;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.tardis.mod.enums.EnumDoorState;
import net.tardis.mod.tileentities.exteriors.ExteriorTile;

import javax.annotation.Nullable;
import java.util.List;

public class deadLocker extends Item {


    public deadLocker() {
        super(new Properties().stacksTo(1).tab(ModItemGroup.ASEOHA_GROUP));
    }

    public ActionResultType useOn(ItemUseContext itemUseContext) {
        World worldIn = itemUseContext.getLevel();
        BlockPos blockpos = itemUseContext.getClickedPos();
        TileEntity clicked = worldIn.getBlockEntity(blockpos);
        if (clicked instanceof ExteriorTile && worldIn != null && blockpos != null) {
            ((ExteriorTile) clicked).setAdditionalLockLevel(1);
            ((ExteriorTile) clicked).setLocked(true);
            ((ExteriorTile) clicked).setDoorState(EnumDoorState.CLOSED);
            ((ExteriorTile) clicked).copyDoorStateToInteriorDoor();
            return ActionResultType.SUCCESS;
        }
        else return ActionResultType.FAIL;
    }



    public void appendHoverText(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {

            tooltip.add(new TranslationTextComponent("tooltip.aseoha.deadlocker"));

            super.appendHoverText(stack, worldIn, tooltip, flagIn);
    }
}
