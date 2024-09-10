package com.code.aseoha.mixin;

import com.code.aseoha.aseoha;
import com.code.aseoha.misc.IHelpWithKeys;
import net.minecraft.item.Item;
import net.minecraft.nbt.CompoundNBT;
import net.tardis.mod.items.KeyItem;
import net.tardis.mod.items.misc.ConsoleBoundWithTooltipItem;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;

@Mixin(KeyItem.class)
public abstract class KeyMixin extends ConsoleBoundWithTooltipItem implements IHelpWithKeys {
    public KeyMixin(Properties properties) {
        super(properties);
    }

    //    @Inject(method = "")
    @Override
    public void Aseoha$putNBTForDisguise(CompoundNBT NBT, Item item) {
        aseoha.LOGGER.info(item.toString());
        NBT.putString("item", item.toString());
    }

    public String Aseoha$getNBTForDisguise(CompoundNBT NBT){
        return NBT.getString("item");
    }
}
