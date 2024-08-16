package com.code.aseoha.misc;

import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.container.ChestContainer;
import net.minecraft.inventory.container.ContainerType;

public class K9InventoryContainer extends ChestContainer {
    public K9InventoryContainer(int i, PlayerInventory playerInventory, IInventory inventory) {
        super(ContainerType.GENERIC_9x4, i, playerInventory, inventory, 4);
    }
}
