
package com.cyntain.Fm.Client.gui;


import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

import com.cyntain.Fm.Item.itemCompounds;
import com.cyntain.Fm.TileEntity.tileMixingTable;


/* DO NOT SHIFT CLICK*/

public class containerMixingTable extends Container {

    public containerMixingTable(InventoryPlayer inventoryPlayer,
            tileMixingTable mixingTable) {

        this.addSlotToContainer(new Slot(mixingTable, 0, 44, 16) {
            @Override
            public boolean isItemValid(ItemStack itemstack) {

                if (itemstack.getItem() instanceof itemCompounds) {
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

                if (itemstack.getItem() instanceof itemCompounds) {
                    return true;
                } else {
                    return false;
                }
            }
        });
        this.addSlotToContainer(new Slot(mixingTable, 2, 80, 57) 
            );

        for (int inventoryRowIndex = 0; inventoryRowIndex < 3; ++inventoryRowIndex) {
            for (int inventoryColumnIndex = 0; inventoryColumnIndex < 9; ++inventoryColumnIndex) {
                this.addSlotToContainer(new Slot(inventoryPlayer,
                        inventoryColumnIndex + inventoryRowIndex * 9 + 9,
                        8 + inventoryColumnIndex * 18,
                        84 + inventoryRowIndex * 18));
            }
        }
        for (int actionBarSlotIndex = 0; actionBarSlotIndex < 9; ++actionBarSlotIndex) {
            this.addSlotToContainer(new Slot(inventoryPlayer,
                    actionBarSlotIndex, 8 + actionBarSlotIndex * 18, 142));
        }

    }

    @Override
    public boolean canInteractWith(EntityPlayer player) {

        return true;

    }

    public ItemStack transferStackInSlot(EntityPlayer par1EntityPlayer, int par2) {

        Slot slot = (Slot) this.inventorySlots.get(par2);
        return slot != null ? slot.getStack() : null;
    }
}