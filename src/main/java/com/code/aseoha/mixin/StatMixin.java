package com.code.aseoha.mixin;

import com.code.aseoha.aseoha;
import com.code.aseoha.config;
import net.minecraft.item.ItemUseContext;
import net.minecraft.util.ActionResultType;
import net.tardis.mod.cap.Capabilities;
import net.tardis.mod.constants.TardisConstants;
import net.tardis.mod.helper.WorldHelper;
import net.tardis.mod.items.StatRemoteItem;
import net.tardis.mod.world.dimensions.TDimensions;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

import java.util.Objects;

import static net.tardis.mod.helper.WorldHelper.areDimensionTypesSame;

@Mixin(StatRemoteItem.class)
public class StatMixin {
    /**
     * @author Me
     * @reason So you can summon TARDIS in TARDIS
     */
    @Overwrite
    public ActionResultType useOn(ItemUseContext context) {
        boolean isTardis = areDimensionTypesSame(context.getLevel(), TDimensions.DimensionTypes.TARDIS_TYPE); //&& config.SERVER.SummonTARDISinTARDIS.get();
        aseoha.LOGGER.info(isTardis);
        if (!context.getLevel().isClientSide() && (WorldHelper.canTravelToDimension(context.getLevel()) || isTardis)) {
            context.getItemInHand().getCapability(Capabilities.REMOTE_CAP).ifPresent((cap) -> cap.onClick(context.getLevel(), context.getPlayer(), context.getClickedPos()));
            return ActionResultType.SUCCESS;
        } else if (!context.getLevel().isClientSide() && (!WorldHelper.canTravelToDimension(context.getLevel()) && !isTardis)) {
            Objects.requireNonNull(context.getPlayer()).displayClientMessage(TardisConstants.Translations.CANT_USE_IN_DIM, true);
            return ActionResultType.FAIL;
        } else {
            return ActionResultType.SUCCESS;
        }
    }
}
