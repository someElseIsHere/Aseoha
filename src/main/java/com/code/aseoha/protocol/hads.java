package com.code.aseoha.protocol;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.tardis.mod.constants.TardisConstants;
import net.tardis.mod.protocols.Protocol;
import net.tardis.mod.tileentities.ConsoleTile;

public class hads extends Protocol {

    public static final String HADS = "message.aseoha.hads.";
    public static final TranslationTextComponent HADS_ON = new TranslationTextComponent("protocol.aseoha.hads");
    public static final TranslationTextComponent HADS_OFF = new TranslationTextComponent("protocol.aseoha.hads");

    @Override
    public void call(World world, PlayerEntity playerIn, ConsoleTile console) {
        if (world.isClientSide) {
//            ((ITardisConsoleHelp) console).setHads(!((ITardisConsoleHelp) console).getHads());
//            console.getOrFindExteriorTile().ifPresent(ex -> ((ITardisExteriorHelper) ex).setHadsExterior(((ITardisConsoleHelp) console).getHads() ? aseoha.HadsState.ENABLED : aseoha.HadsState.DISABLED));
//            for (PlayerEntity player : world.getEntitiesOfClass(PlayerEntity.class, new AxisAlignedBB(console.getBlockPos()).inflate(16))) {
//                player.displayClientMessage(new TranslationTextComponent(HADS + ((ITardisConsoleHelp) console).getHads()), true);
            }
//        } else ClientHelper.openGUI(TardisConstants.Gui.NONE, new GuiContext());
    }

//    @Override
//    public TranslationTextComponent getDisplayName(ConsoleTile tile) {
//        return ((ITardisConsoleHelp) tile).getHads() ? HADS_ON : HADS_OFF;
//    }

    @Override
    public String getSubmenu() {
        return TardisConstants.Strings.SECURITY_MENU;
    }
}
