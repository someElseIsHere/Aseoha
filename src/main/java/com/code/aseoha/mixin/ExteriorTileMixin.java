package com.code.aseoha.mixin;

import com.code.aseoha.aseoha;
import net.minecraft.entity.Entity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.ItemStackHandler;
import net.minecraftforge.registries.IForgeRegistry;
import net.tardis.mod.boti.BotiHandler;
import net.tardis.mod.boti.WorldShell;
import net.tardis.mod.client.animation.ExteriorAnimationEntry;
import net.tardis.mod.client.animation.IExteriorAnimation;
import net.tardis.mod.energy.TardisEnergy;
import net.tardis.mod.entity.TardisEntity;
import net.tardis.mod.enums.EnumDoorState;
import net.tardis.mod.enums.EnumMatterState;
import net.tardis.mod.exterior.AbstractExterior;
import net.tardis.mod.misc.TexVariant;
import net.tardis.mod.network.packets.exterior.ExteriorData;
import net.tardis.mod.network.packets.exterior.LightData;
import net.tardis.mod.registries.ExteriorAnimationRegistry;
import net.tardis.mod.registries.ExteriorRegistry;
import net.tardis.mod.tileentities.exteriors.ExteriorTile;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Mixin(ExteriorTile.class)
public abstract class ExteriorTileMixin extends TileEntity {

    public ExteriorTileMixin(TileEntityType<?> tileEntityTypeIn) {
        super(tileEntityTypeIn);
        this.lightLevel = 15.0F;
        aseoha.LOGGER.info("hi");
    }
    /**
     * @author
     * @reason
     */




    @Shadow(remap = false) public float lightLevel = 15F;

    @Shadow(remap = false) public abstract void updateSpecific(ExteriorData data);

    /**
     * @author
     * @reason
     */
    @Overwrite(remap = false) public int getLightEmittingLevel() {
        return 15;
    }
    /**
     * @author
     * @reason
     */
    @Overwrite(remap = false) public float getLightLevel() {
        return 15;
    }

    /**
     * @author Me
     * @reason Because I fucking did kay?
     */
    @Overwrite(remap=false) public void setLightLevel(float percent){
        percent = 15F;
        this.lightLevel = (float) MathHelper.clamp((double)percent + 0.2, 0.0, 1.0);
        this.setChanged();
        this.updateSpecific(new LightData(this.lightLevel));
    }


}