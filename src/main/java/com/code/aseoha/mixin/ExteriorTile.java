package com.code.aseoha.mixin;

import com.code.aseoha.misc.IHelpWithExterior;
import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import net.minecraft.block.BlockState;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.RegistryKey;
import net.minecraft.world.World;
import net.minecraftforge.energy.IEnergyStorage;
import net.tardis.mod.boti.IBotiEnabled;
import net.tardis.mod.entity.TardisEntity;
import net.tardis.mod.enums.EnumDoorState;
import net.tardis.mod.enums.EnumMatterState;
import net.tardis.mod.exterior.AbstractExterior;
import net.tardis.mod.helper.TardisHelper;
import net.tardis.mod.tileentities.ConsoleTile;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Objects;

@Mixin(net.tardis.mod.tileentities.exteriors.ExteriorTile.class)
public abstract class ExteriorTile extends TileEntity implements ITickableTileEntity, IBotiEnabled, IEnergyStorage, IHelpWithExterior {

    public ExteriorTile(TileEntityType<?> p_i48289_1_) {
        super(p_i48289_1_);
    }

    @Shadow(remap = false)
    public abstract TardisEntity createEntity();

    @ModifyReturnValue(method = "getLightEmittingLevel()I", at = @At("RETURN"), remap = false)
    public int Aseoha$getLightEmittingLevel(int original) {
        return this.Aseoha$LightLevel;
    }

    @Shadow(remap = false)
    public abstract void setMatterState(EnumMatterState state);

    @Shadow(remap = false)
    public abstract void setDoorState(EnumDoorState state);

    @Shadow(remap = false)
    private boolean hasDemated;

    @Shadow(remap = false)
    public abstract void deleteExteriorBlocks();

    @Shadow(remap = false)
    public abstract int extractEnergy(int maxExtract, boolean simulate);

    @Shadow(remap = false)
    protected RegistryKey<World> interiorDimension;

    @Unique
    int Aseoha$Scale = 1;
    @Unique
    byte Aseoha$LightLevel;

    @Override
    public int Aseoha$GetScale() {
        return this.Aseoha$Scale;
    }

    @Override
    public void Aseoha$SetScale(int scale) {
        this.Aseoha$Scale = scale;
    }

    @Override
    public byte Aseoha$GetLight() {
        return this.Aseoha$LightLevel;
    }

    @Override
    public void Aseoha$SetLight(byte Level) {
        this.Aseoha$LightLevel = Level;
    }

    @Inject(method = "load(Lnet/minecraft/block/BlockState;Lnet/minecraft/nbt/CompoundNBT;)V", at = @At("TAIL"))
    private void Aseoha$Read(BlockState state, CompoundNBT compound, CallbackInfo ci) {
        this.Aseoha$Scale = compound.getInt("Aseoha$Scale");
        this.Aseoha$LightLevel = compound.getByte("Aseoha$LightLevel");
    }

    @Inject(method = "save(Lnet/minecraft/nbt/CompoundNBT;)Lnet/minecraft/nbt/CompoundNBT;", at = @At("TAIL"))
    private void Aseoha$Write(CompoundNBT compound, CallbackInfoReturnable<CompoundNBT> cir) {
        compound.putInt("Aseoha$Scale", this.Aseoha$Scale);
        compound.putByte("Aseoha$LightLevel", this.Aseoha$LightLevel);
    }

    @Override
    public void Aseoha$DematFly() {
        this.setMatterState(EnumMatterState.DEMAT);
        this.setDoorState(EnumDoorState.CLOSED);
        this.hasDemated = true;
//        this.alpha = 0.0F;

        this.deleteExteriorBlocks();
    }

    @Unique
    public TardisEntity Aseoha$GetOrCreateTardisEntity() {
        if (this.hasDemated) {
            return null;
        } else {
            TardisEntity ent = this.createEntity();
            if (ent != null) {
                assert this.level != null;
                ConsoleTile console = TardisHelper.getConsole(Objects.requireNonNull(this.level.getServer()), this.interiorDimension).orElse(null);
                if (console != null) {
                    if (console.getExteriorType().getExteriorTile(console) != null) {
                        ent.setExteriorTile(console.getExteriorType().getExteriorTile(console));
                        assert this.level != null;
                        TardisHelper.getConsole(Objects.requireNonNull(this.level.getServer()), this.interiorDimension).ifPresent(tile -> {
                            tile.setEntity(ent);
                        });
                    }
                }
            }
            return ent;
        }
    }
}
