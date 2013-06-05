package com.cyntain.Fm.client.gui;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

import com.cyntain.Fm.tileentity.TileMixingTable;
import com.cyntain.Fm.tileentity.TileWorkTable;

//TODO Add slot locations
public class ContainerWorkTable extends Container {

    public ContainerWorkTable(InventoryPlayer inventoryPlayer, TileWorkTable workTable) {

        for (int inventoryRowIndex = 0; inventoryRowIndex < 3; ++inventoryRowIndex) {
            for (int inventoryColumnIndex = 0; inventoryColumnIndex < 9; ++inventoryColumnIndex) {
                this.addSlotToContainer(new Slot(inventoryPlayer, inventoryColumnIndex
                        + inventoryRowIndex * 9 + 9, 8 + inventoryColumnIndex * 18,
                        84 + inventoryRowIndex * 18));
            }
        }
        for (int actionBarSlotIndex = 0; actionBarSlotIndex < 9; ++actionBarSlotIndex) {
            this.addSlotToContainer(new Slot(inventoryPlayer, actionBarSlotIndex,
                    8 + actionBarSlotIndex * 18, 142));
        }

    }

    @Override
    public boolean canInteractWith(EntityPlayer entityplayer) {

        return true;
    }

    @Override
    public ItemStack transferStackInSlot(EntityPlayer player, int slotIndex) {

        ItemStack itemstack = null;
        Slot slot = (Slot) this.inventorySlots.get(slotIndex);

        if (slot != null && slot.getHasStack()) {
            ItemStack itemstack1 = slot.getStack();
            itemstack = itemstack1.copy();

            if (slotIndex < TileMixingTable.INVENTORY_SIZE) {

                if (!this.mergeItemStack(itemstack1, TileMixingTable.INVENTORY_SIZE,
                        inventorySlots.size(), false)) {
                    return null;
                }
            } else if (!this.mergeItemStack(itemstack1, 0, 2, false)
                    || !this.mergeItemStack(itemstack1, 1, 2, false)) {
                return null;
            }

            if (itemstack1.stackSize == 0) {
                slot.putStack((ItemStack) null);
            } else {
                slot.onSlotChanged();
            }

        }
        return itemstack;
    }

}
