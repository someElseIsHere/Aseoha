package com.code.aseoha.entities;//package com.code.aseoha.entities;
//
//import net.minecraft.entity.Entity;
//import net.minecraft.entity.EntityType;
//import net.minecraft.entity.MobEntity;
//import net.minecraft.entity.player.PlayerEntity;
//import net.minecraft.item.ItemTier;
//import net.minecraft.item.ToolItem;
//import net.minecraft.util.DamageSource;
//import net.minecraft.world.World;
//import net.tardis.api.space.entities.ISpaceImmuneEntity;
//
//public class k9 extends MobEntity implements ISpaceImmuneEntity {
//    public k9(EntityType<? extends MobEntity> type, World worldIn) {super(type, worldIn);}
//    public void tick() {
//        super.tick();
//    }
//
//    public boolean canBreatheUnderwater() {return true;}
//
//    public boolean doHurtTarget(Entity attacker) {return super.doHurtTarget(attacker);}
//
//    public boolean hurt(DamageSource source, float amount) {
//        if (source.getDirectEntity() instanceof PlayerEntity) {
//            PlayerEntity player = (PlayerEntity)source.getDirectEntity();
//            if (player.getMainHandItem().getItem() instanceof ToolItem && ((ToolItem)player.getMainHandItem().getItem()).getTier() == ItemTier.IRON) {
//                amount *= 1.5F;
//            }
//        }
//
//        return super.hurt(source, amount);
//    }
//
//    public boolean shouldTakeSpaceDamage() {
//        return false;
//    }
//}

import net.minecraft.block.BlockState;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.merchant.villager.AbstractVillagerEntity;
import net.minecraft.entity.monster.CreeperEntity;
import net.minecraft.entity.monster.EndermanEntity;
import net.minecraft.entity.monster.ZombifiedPiglinEntity;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.IronGolemEntity;
import net.minecraft.entity.passive.TurtleEntity;
import net.minecraft.entity.passive.WolfEntity;
import net.minecraft.entity.passive.horse.LlamaEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.World;
import net.minecraftforge.event.ForgeEventFactory;
import net.tardis.api.space.entities.ISpaceImmuneEntity;
import net.tardis.mod.damagesources.TDamageSources;
import net.tardis.mod.datagen.objects.SoundEventBuilder;
import net.tardis.mod.entity.TEntities;
import net.tardis.mod.entity.projectiles.LaserEntity;
import net.tardis.mod.sounds.SoundSchemeMaster;
import net.tardis.mod.sounds.TSounds;

public class k9 extends WolfEntity implements ISpaceImmuneEntity, IRangedAttackMob {
    private World world;

    public k9(EntityType<? extends WolfEntity> type, World worldIn) {
        super(type, worldIn);
    }

    public static AttributeModifierMap.MutableAttribute setCustomAttributes() {
        return CreatureEntity.createMobAttributes()
                .add(Attributes.MAX_HEALTH, 60.0D)
                .add(Attributes.MOVEMENT_SPEED, 0.30D)
                .add(Attributes.ATTACK_DAMAGE, 13.0D)
                .add(Attributes.FOLLOW_RANGE, 50.0D);
    }

    @Override
    protected void registerGoals() {
        super.registerGoals();
        this.goalSelector.removeGoal(new SwimGoal(this));
        this.goalSelector.removeGoal(new LeapAtTargetGoal(this, 0.4F));
        this.goalSelector.removeGoal(new MeleeAttackGoal(this, 1.0, true));
        this.goalSelector.removeGoal(new BreedGoal(this, 1.0));
        this.goalSelector.removeGoal(new AvoidEntityGoal<>(this, LlamaEntity.class, 24.0F, 1.5, 1.5));

        this.goalSelector.addGoal(0, new SwimGoal(this));
        this.goalSelector.addGoal(1, new RangedAttackGoal(this, 1.5, 40, 6.0F));
        this.goalSelector.removeGoal(new NearestAttackableTargetGoal<>( this, PlayerEntity.class, true) );
//        this.goalSelector.addGoal(2, new ZombieAttackGoal(this, 1.0D, false));
        this.goalSelector.addGoal(7, new WaterAvoidingRandomWalkingGoal(this, 1.0D));
        this.targetSelector.addGoal(1, (new HurtByTargetGoal(this)).setAlertOthers(WolfEntity.class));
//        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, PlayerEntity.class, true));
//        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, AbstractVillagerEntity.class, false));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, CreeperEntity.class, true));
//        this.targetSelector.addGoal(5, new NearestAttackableTargetGoal<>(this, TurtleEntity.class, 10, true, false, TurtleEntity.TARGET_DRY_BABY));
    }



    public void performRangedAttack(LivingEntity target, float distanceFactor) {
        if (!this.level.isClientSide && this.canSee(target)) {
            LaserEntity lazer = new LaserEntity((EntityType) TEntities.LASER.get(), this, this.getCommandSenderWorld(), 4.0F, TDamageSources.causeTardisMobDamage("laser", this));
            lazer.setColor(new Vector3d(1.0, 0.0, 0.0));
            lazer.setDamage((float)this.getAttribute(Attributes.ATTACK_DAMAGE).getBaseValue());
            lazer.setRayLength(1F);
            lazer.shootFromRotation(lazer, this.xRot, this.yHeadRot, 0.0F, 1.5F, 0.0F);
            this.level.addFreshEntity(lazer);
            this.level.playSound((PlayerEntity)null, this.blockPosition(), (SoundEvent) TSounds.LASER_GUN_FIRE.get(), SoundCategory.HOSTILE, 1.0F, 1.0F);
        }

    }

//    @Override
//    protected int addExperiencePoints(PlayerEntity player)
//    {
//        return 3 + this.world.random.nextInt(5);
//    }

    @Override
    protected SoundEvent getAmbientSound(){return SoundEvents.ARMOR_EQUIP_IRON;}

    @Override
    protected SoundEvent getDeathSound(){return SoundEvents.IRON_GOLEM_DEATH;}

    @Override
    protected SoundEvent getHurtSound(DamageSource damageSourceIn){return SoundEvents.IRON_GOLEM_HURT;}

    @Override
    protected void playStepSound(BlockPos pos, BlockState blockIn){this.playSound(SoundEvents.METAL_STEP, 0.20F, 0.5F);}

//    @Override
//    public boolean attackEntityAsMob(Entity entityIn) {
//        if (!super.attackEntityAsMob(entityIn)) {
//            return false;
//        } else {
//            if (entityIn instanceof LivingEntity) {
//                ((LivingEntity)entityIn).addEffect(new EffectInstance(Effects.MOVEMENT_SLOWDOWN, 200,3));
//                ((LivingEntity)entityIn).addEffect(new EffectInstance(Effects.WEAKNESS, 200));
//                ((LivingEntity)entityIn).addEffect(new EffectInstance(Effects.CONFUSION, 200));
//            }
//            return true;
//        }
//    }
@Override
public ActionResultType mobInteract(PlayerEntity player, Hand hand) {
    ItemStack itemstack = player.getItemInHand(hand);
    Item item = itemstack.getItem();
    if (this.level.isClientSide) {
        boolean flag = this.isOwnedBy(player) || this.isTame() || item == Items.IRON_BARS && !this.isTame() && !this.isAngry();
        return flag ? ActionResultType.CONSUME : ActionResultType.PASS;
    } else {
        if (this.isTame()) {
            if (this.isFood(itemstack) && this.getHealth() < this.getMaxHealth()) {
                if (!player.abilities.instabuild) {
                    itemstack.shrink(1);
                }

                this.heal((float)item.getFoodProperties().getNutrition());
                return ActionResultType.SUCCESS;
            }

            if (!(item instanceof DyeItem)) {
                ActionResultType actionresulttype = super.mobInteract(player, hand);
                if ((!actionresulttype.consumesAction()) && this.isOwnedBy(player)) {
                    this.setOrderedToSit(!this.isOrderedToSit());
                    this.jumping = false;
                    this.navigation.stop();
                    this.setTarget((LivingEntity)null);
                    return ActionResultType.SUCCESS;
                }

                return actionresulttype;
            }
        } else if (item == Items.IRON_BARS && !this.isAngry()) {
            if (!player.abilities.instabuild) {
                itemstack.shrink(1);
            }

            if (this.random.nextInt(3) == 0 && !ForgeEventFactory.onAnimalTame(this, player)) {
                this.tame(player);
                this.navigation.stop();
                this.setTarget((LivingEntity)null);
                this.setOrderedToSit(true);
                this.level.broadcastEntityEvent(this, (byte)7);
            } else {
                this.level.broadcastEntityEvent(this, (byte)6);
            }

            return ActionResultType.SUCCESS;
        }

        return super.mobInteract(player, hand);
    }
}
public boolean shouldTakeSpaceDamage() {
        return false;
    }

@Override
public boolean canMate(AnimalEntity p_70878_1_){return false;}

public boolean isSensitiveToWater() {
        return true;
    }
}