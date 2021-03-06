package com.cyntain.Fm.client.gui;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

import com.cyntain.Fm.item.ItemCompounds;
import com.cyntain.Fm.tileentity.TileMixingTable;


/* DO NOT SHIFT CLICK*/

public class ContainerMixingTable extends Container {

    public ContainerMixingTable(InventoryPlayer inventoryPlayer, TileMixingTable mixingTable) {

        this.addSlotToContainer(new Slot(mixingTable, 0, 44, 16) {

            @Override
            public boolean isItemValid(ItemStack itemstack) {

                if (itemstack.getItem() instanceof ItemCompounds) {
                    return true;
                } else {
                    return false;
                }
            }

        }

        );

        this.addSlotToContainer(new Slot(mixingTable, 1, 116, 16) {

            @Override
            public boolean isItemValid(ItemStack itemstack) {

                if (itemstack.getItem() instanceof ItemCompounds) {
                    return true;
                } else {
                    return false;
                }
            }
        });
        this.addSlotToContainer(new Slot(mixingTable, 2, 80, 57) {

            @Override
            public boolean isItemValid(ItemStack itemstack) {

                return false;

            }
        });

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
    public boolean canInteractWith(EntityPlayer player) {

        return true;

    }
// TODO Get Shift clicking working, so it knows what kind of item to put into the slots.
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
