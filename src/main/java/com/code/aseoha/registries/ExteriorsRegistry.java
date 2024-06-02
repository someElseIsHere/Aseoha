package com.code.aseoha.registries;

import com.code.aseoha.aseoha;
import com.code.aseoha.block.ModBlocks;
import com.code.aseoha.enums.EnumDoorTypes;
import com.code.aseoha.texturevariants.TextureVariants;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.tardis.mod.exterior.AbstractExterior;
import net.tardis.mod.exterior.TwoBlockBasicExterior;
import net.tardis.mod.misc.DoorSounds;

public class ExteriorsRegistry {
    public static final DeferredRegister<AbstractExterior> EXTERIORS = DeferredRegister.create(AbstractExterior.class, aseoha.MODID);


    public static final RegistryObject<AbstractExterior> CORAL = EXTERIORS.register("coral",
            () -> new TwoBlockBasicExterior(() -> ModBlocks.EXTERIOR_CORAL.get().defaultBlockState(),
                    true, EnumDoorTypes.CORAL, DoorSounds.BASE,
                    new ResourceLocation(aseoha.MODID, "textures/gui/exteriors/coralexterior.png"), TextureVariants.CORAL));

}
