package com.code.aseoha.mixin;

import com.code.aseoha.aseoha;
import com.code.aseoha.misc.IHelpWithConsole;
import com.code.aseoha.misc.IHelpWithTardisEntity;
import com.code.aseoha.networking.Networking;
import com.code.aseoha.networking.Packets.RWFPacket;
import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.concurrent.TickDelayedTask;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.tardis.mod.ars.ConsoleRoom;
import net.tardis.mod.client.ClientHelper;
import net.tardis.mod.controls.AbstractControl;
import net.tardis.mod.controls.HandbrakeControl;
import net.tardis.mod.controls.ThrottleControl;
import net.tardis.mod.entity.TardisEntity;
import net.tardis.mod.exterior.AbstractExterior;
import net.tardis.mod.helper.TardisHelper;
import net.tardis.mod.helper.WorldHelper;
import net.tardis.mod.misc.CrashType;
import net.tardis.mod.tileentities.ConsoleTile;
import net.tardis.mod.tileentities.console.misc.InteriorManager;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import javax.annotation.Nullable;
import java.util.Objects;
import java.util.Optional;

@Mixin(ConsoleTile.class)
public abstract class ConsoleMixin extends TileEntity implements ITickableTileEntity, IHelpWithConsole {

    public ConsoleMixin(TileEntityType<?> p_i48289_1_) {
        super(p_i48289_1_);
    }

    @Shadow(remap = false)
    private float artron;

    @Shadow(remap = false)
    public abstract float calcFuelUse();

    @Shadow(remap = false)
    public abstract <T extends AbstractControl> Optional<T> getControl(Class<T> clazz);

    @Shadow(remap = false)
    private TardisEntity tardisEntity;

    @Shadow(remap = false)
    public abstract RegistryKey<World> getDestinationDimension();

    @Shadow(remap = false)
    @Nullable
    public abstract TardisEntity getEntity();

    @Shadow(remap = false)
    public abstract InteriorManager getInteriorManager();

    @Shadow(remap = false)
    private BlockPos destination;

    @Shadow(remap = false)
    public abstract void land();

    @Shadow(remap = false)
    public abstract boolean isInFlight();

    @Shadow(remap = false)
    public abstract AbstractExterior getExteriorType();

    @Shadow(remap = false)
    private RegistryKey<World> destinationDimension;

    @Shadow(remap = false)
    public abstract BlockPos getDestinationPosition();

    @Shadow(remap = false)
    private InteriorManager interiorManager;

    @Shadow(remap = false)
    public abstract ConsoleRoom getConsoleRoom();

    @Shadow(remap = false)
    private RegistryKey<World> dimension;

    @Shadow(remap = false)
    public abstract void setConsoleRoom(ConsoleRoom room);

    @Shadow(remap = false)
    public int flightTicks;

    @Shadow(remap = false)
    private int reachDestinationTick;
    //TODO: FINISH MAINTENANCE MODE
//    @Shadow public abstract void initLand();
    @Unique
    public boolean Aseoha$Hads = false;
    @Unique
    public boolean Aseoha$Maintenance = false;
    @Unique
    public int Aseoha$ExteriorSize = 1;
//    @Unique
//    private ConsoleTile Aseoha$ConsoleTile;

    @Unique
    private boolean Aseoha$RealWorldFlight;
    @Unique
    private BlockPos Aseoha$RidingPlayerPos;
    @Unique
    private World Aseoha$InteriorDimension;

    @Inject(method = "load(Lnet/minecraft/block/BlockState;Lnet/minecraft/nbt/CompoundNBT;)V", at = @At("HEAD"))
    public void Aseoha$ConsoleRead(BlockState state, CompoundNBT compound, CallbackInfo ci) {
        this.Aseoha$Hads = compound.getBoolean("hads");
        this.Aseoha$Maintenance = compound.getBoolean("maintenance");
        this.Aseoha$ExteriorSize = compound.getInt("exterior_size_scale");
//        this.interiorDimension. = compound.
    }

    @Inject(method = "save(Lnet/minecraft/nbt/CompoundNBT;)Lnet/minecraft/nbt/CompoundNBT;", at = @At("HEAD"))
    public void Aseoha$ConsoleWrite(CompoundNBT compound, CallbackInfoReturnable<CompoundNBT> cir) {
        compound.putBoolean("hads", this.Aseoha$Hads);
        compound.putBoolean("maintenance", this.Aseoha$Maintenance);
        compound.putInt("exterior_size_scale", this.Aseoha$ExteriorSize);
    }

    @Override
    public boolean Aseoha$GetHads() {
        return Aseoha$Hads;
    }

    @Override
    public void Aseoha$SetHads(boolean Hads) {
        this.Aseoha$Hads = Hads;
    }

    @Override
    public boolean Aseoha$GetMaintenance() {
        return Aseoha$Maintenance;
    }

    @Override
    public void Aseoha$SetMaintenance(boolean maintenance) {
        this.Aseoha$Maintenance = maintenance;
    }

    @Override
    public int Aseoha$GetExteriorSize() {
        return Aseoha$ExteriorSize;
    }

    @Override
    public void Aseoha$SetExteriorSize(int aseoha$ExteriorSize) {
        Aseoha$ExteriorSize = aseoha$ExteriorSize;
    }

    @ModifyExpressionValue(method = "Lnet/tardis/mod/tileentities/ConsoleTile;fly()V", at = @At(value = "INVOKE", target = "Lnet/tardis/mod/tileentities/ConsoleTile;isInFlight()Z"), remap = false)
    private boolean Aseoha$OnlyFlyIfAllowed(boolean original) {
        return original && !this.Aseoha$RealWorldFlight;
    }


    @ModifyReturnValue(method = "isInFlight()Z", at = @At("RETURN"), remap = false)
    private boolean Aseoha$IsInFlight(boolean original) {
        return original || this.isInFlight();
    }


    @Inject(method = "Lnet/tardis/mod/tileentities/ConsoleTile;fly()V", at = @At("HEAD"), remap = false)
    private void Aseoha$Fly(CallbackInfo ci) {
        this.artron = this.Aseoha$RealWorldFlight ? this.artron - this.calcFuelUse() * 2 : this.artron;
        if (this.Aseoha$IsRealWorldFlight())
            Networking.sendToServer(new RWFPacket((this.getExteriorType().getRegistryName())));

    }

    @Inject(method = "lambda$land$11", at = @At(value = "INVOKE", target = "Lnet/tardis/mod/exterior/AbstractExterior;remat(Lnet/tardis/mod/tileentities/ConsoleTile;)V", shift = At.Shift.AFTER), remap = false)
    private void Aseoha$Land(CallbackInfo ci) {

        if (this.Aseoha$IsRealWorldFlight()) {
            this.Aseoha$RealWorldFlight = false;

            this.getControl(HandbrakeControl.class).ifPresent((brake) -> brake.setFree(false)); //TODO: REMOVE this

            this.tardisEntity.land(); //TODO: MAKE SURE THIS EXISTS: setHasLanded
            this.tardisEntity.remove();
        }
    }

    @Override
    public void Aseoha$Ride(PlayerEntity playerEntity) {
        this.Aseoha$StopRide(false);

        if (this.Aseoha$GetTardisEntity() != null) {
            ((IHelpWithTardisEntity) this.Aseoha$GetTardisEntity()).setCanDismount(false);


            this.Aseoha$RidingPlayerPos = playerEntity.blockPosition();

            BlockPos tardisPos = this.Aseoha$GetTardisEntity().blockPosition();
            WorldHelper.teleportEntities(playerEntity, Objects.requireNonNull(Objects.requireNonNull(this.getEntity()).level.getServer()).getLevel(this.getDestinationDimension()), tardisPos.getX(), tardisPos.getY(), tardisPos.getZ(), playerEntity.yRot, playerEntity.xRot);
            playerEntity.startRiding(this.Aseoha$GetTardisEntity(), true);
        }
    }

    @Override
    public void Aseoha$StopRide(boolean land) {
        assert this.level != null;
        if (this.level.isClientSide()) {
            if (this.tardisEntity != null) {
                if (!this.tardisEntity.getPassengers().isEmpty()) {
                    Entity entity = this.tardisEntity.getPassengers().get(0);

                    if (entity instanceof PlayerEntity) {
                        ((IHelpWithTardisEntity) this.tardisEntity).setCanDismount(true);

                        PlayerEntity playerEntity = (PlayerEntity) entity;
                        playerEntity.stopRiding();
                        if (this.Aseoha$InteriorDimension != null) {
                            assert this.Aseoha$GetInteriorDimension() != null;
                            Objects.requireNonNull(this.Aseoha$GetInteriorDimension().getServer()).tell(new TickDelayedTask(1, ()
                                    -> WorldHelper.teleportEntities(playerEntity, this.Aseoha$GetInteriorDimension().getServer().getLevel(this.Aseoha$GetInteriorDimension().dimension()), this.Aseoha$RidingPlayerPos.getX(), this.Aseoha$RidingPlayerPos.getY(), this.Aseoha$RidingPlayerPos.getZ(), playerEntity.yRot, playerEntity.xRot)
                            ));
                        }
                    }

                    ClientHelper.shutTheFuckUp(null, SoundCategory.BLOCKS);
//                }
                }

                if (land) {
                    if (this.tardisEntity != null) {
                        this.destination = this.tardisEntity.blockPosition();
                    }

                    this.land();
                }
            }
        }
//        }
    }

    @Inject(method = "lambda$takeoff$7", at = @At(value = "INVOKE", target = "Lnet/tardis/mod/exterior/AbstractExterior;demat(Lnet/tardis/mod/tileentities/ConsoleTile;)V", shift = At.Shift.BEFORE), remap = false)
    public void Aseoha$TakeoffLambda7(ServerWorld otherWorld, ChunkPos chunkPos, CallbackInfo ci) {
        this.flightTicks = 0;
        if (!this.Aseoha$RealWorldFlight) {
            this.flightTicks = this.reachDestinationTick;
        }
    }

    @Inject(method = "tick()V", at = @At(value = "INVOKE", target = "Lnet/tardis/mod/tileentities/ConsoleTile;playAmbientNoises()V", shift = At.Shift.AFTER), remap = false)
    public void Aseoha$ConsoleTickAmbientNoises(CallbackInfo ci) {
//        setConsole(TardisHelper.getConsoleInWorld(this));
        if (this.Aseoha$GetTardisEntity() != null) {
//            this.setConsole(this.getTardisEntity().getConsole());
            aseoha.LOGGER.info("NOT NULL");
            assert this.tardisEntity.level != null;
            if (this.tardisEntity.level.isClientSide && this.getExteriorType().getExteriorTile(this.Aseoha$GetConsole()) == null && this.tardisEntity == null && !this.isInFlight()) {
                this.getExteriorType().place(this.Aseoha$GetConsole(), this.destinationDimension, this.getDestinationPosition());
            }
            aseoha.LOGGER.info("FINISHED");
        }
    }

    @Override
    public void Aseoha$CleanupRide() {
        this.Aseoha$RealWorldFlight = false;
        this.getControl(ThrottleControl.class).ifPresent(throt -> throt.setAmount(0.0F));
//        this.getControl(HandbrakeControl.class).ifPresent(brake -> brake.setFree(false));
    }

    @Inject(method = "crash(Lnet/tardis/mod/misc/CrashType;)V", at = @At("HEAD"), remap = false)
    private void Aseoha$Crash(CrashType type, CallbackInfo ci) {
        this.Aseoha$StopRide(false);
    }

    @Override
    public TardisEntity Aseoha$GetTardisEntity() {
        return tardisEntity;
    }

    @Override
    public World Aseoha$GetInteriorDimension() {
//        return interiorDimension;
        return this.level;
    }

    @Override
    public void Aseoha$SetInteriorDimension(World interiorDimension) {
        this.Aseoha$InteriorDimension = interiorDimension;
    }

    @Override
    public boolean Aseoha$IsRealWorldFlight() {
        return Aseoha$RealWorldFlight;
    }

    @Override
    public void Aseoha$SetRealWorldFlight(boolean rwf) {
        this.Aseoha$RealWorldFlight = rwf;
    }

//    private void setConsole(ConsoleTile console){
//        this.Aseoha$ConsoleTile = console;
//    }

    @Override
    public ConsoleTile Aseoha$GetConsole() {
        assert this.Aseoha$GetInteriorDimension() != null;
        return TardisHelper.getConsoleInWorld(this.Aseoha$GetInteriorDimension()).get();
    }
}
