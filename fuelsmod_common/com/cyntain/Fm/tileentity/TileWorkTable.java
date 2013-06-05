package com.cyntain.Fm.tileentity;

import com.cyntain.Fm.lib.Strings;

import cpw.mods.fml.common.network.PacketDispatcher;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.network.INetworkManager;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.Packet132TileEntityData;


public class TileWorkTable extends TileFm implements IInventory {

    private ItemStack[]     workTableInv;
    public final static int INVENTORY_SIZE = 8;

    public TileWorkTable() {

        workTableInv = new ItemStack[INVENTORY_SIZE];
    }

    @Override
    public int getSizeInventory() {

        return this.workTableInv.length;
    }

    @Override
    public ItemStack getStackInSlot(int slot) {

        return workTableInv[slot];
    }

    @Override
    public ItemStack decrStackSize(int slot, int amount) {

        if (this.workTableInv[slot] != null) {
            ItemStack itemStack;
            if (this.workTableInv[slot].stackSize >= amount) {
                itemStack = this.workTableInv[slot];
                this.workTableInv[slot] = null;
                return itemStack;
            } else {
                itemStack = this.workTableInv[slot].splitStack(amount);
                if (this.workTableInv[slot].stackSize == 0) {
                    this.workTableInv[slot] = null;
                }
                return itemStack;
            }
        } else {
            return null;
        }
    }

    @Override
    public void updateEntity() {
        boolean hasToUpdate = false;

        //TODO 
        
        if (hasToUpdate) {

            PacketDispatcher.sendPacketToAllAround(xCoord, yCoord, zCoord, 8,
                    this.worldObj.provider.dimensionId, getDescriptionPacket());

        }

    }

    public void onDataPacket(INetworkManager net, Packet132TileEntityData pkt) {

    }

    @Override
    public Packet getDescriptionPacket() {

        NBTTagCompound nbtTag = new NBTTagCompound();

        return new Packet132TileEntityData(this.xCoord, this.yCoord, this.zCoord, 1, nbtTag);
    }

    @Override
    public void readFromNBT(NBTTagCompound nbtTagCompound) {

        super.readFromNBT(nbtTagCompound);

        // Read in the ItemStacks in the inventory from NBT
        NBTTagList tagList = nbtTagCompound.getTagList("Items");
        workTableInv = new ItemStack[this.getSizeInventory()];
        for (int i = 0; i < tagList.tagCount(); ++i) {
            NBTTagCompound tagCompound = (NBTTagCompound) tagList.tagAt(i);
            byte slot = tagCompound.getByte("Slot");
            if (slot >= 0 && slot < workTableInv.length) {
                workTableInv[slot] = ItemStack.loadItemStackFromNBT(tagCompound);
            }
        }

    }

    @Override
    public void writeToNBT(NBTTagCompound nbtTagCompound) {

        super.writeToNBT(nbtTagCompound);

        // Write the ItemStacks in the inventory to NBT
        NBTTagList tagList = new NBTTagList();
        for (int currentIndex = 0; currentIndex < workTableInv.length; ++currentIndex) {
            if (workTableInv[currentIndex] != null) {
                NBTTagCompound tagCompound = new NBTTagCompound();
                tagCompound.setByte("Slot", (byte) currentIndex);
                workTableInv[currentIndex].writeToNBT(tagCompound);
                tagList.appendTag(tagCompound);
            }
        }
        nbtTagCompound.setTag("Items", tagList);
    }

    @Override
    public ItemStack getStackInSlotOnClosing(int slot) {

        ItemStack itemStack = getStackInSlot(slot);
        if (itemStack != null) {
            setInventorySlotContents(slot, null);
        }
        return itemStack;
    }

    @Override
    public void setInventorySlotContents(int slot, ItemStack itemStack) {

        workTableInv[slot] = itemStack;

        if (itemStack != null && itemStack.stackSize > getInventoryStackLimit()) {
            itemStack.stackSize = getInventoryStackLimit();
        }
    }

    @Override
    public String getInvName() {

        return this.hasCustomName() ? this.getCustomName() : Strings.CONTAINER_WORKSHOPTABLE;
    }

    @Override
    public boolean isInvNameLocalized() {

        return this.hasCustomName();
    }

    @Override
    public int getInventoryStackLimit() {

        return 1;
    }

    @Override
    public void openChest() {

    }

    @Override
    public void closeChest() {

    }

    @Override
    public boolean isStackValidForSlot(int i, ItemStack itemstack) {

        return false;
    }

}