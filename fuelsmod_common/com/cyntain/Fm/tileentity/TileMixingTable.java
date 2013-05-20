package com.cyntain.Fm.tileentity;

import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.network.INetworkManager;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.Packet132TileEntityData;

import com.cyntain.Fm.core.helper.MixingTableHelper;
import com.cyntain.Fm.lib.Strings;

import cpw.mods.fml.common.network.PacketDispatcher;


/*TODO make it so if slots 0 and 1 have one item in it, it sets the slot to null*/

public class TileMixingTable extends TileFm implements IInventory {

    private ItemStack[]     inventory;
    public final static int INVENTORY_SIZE = 3;
    private int             tickCount;
    private int             progress;
    public ItemStack        changeSlot1;
    public ItemStack        changeSlot0;

    public TileMixingTable() {

        inventory = new ItemStack[INVENTORY_SIZE];

    }

    @Override
    public int getSizeInventory() {

        return this.inventory.length;
    }

    @Override
    public ItemStack getStackInSlot(int slot) {

        return inventory[slot];
    }

    @Override
    public ItemStack decrStackSize(int slot, int amount) {

        ItemStack itemStack = getStackInSlot(slot);
        if (itemStack != null) {
            if (itemStack.stackSize <= amount) {
                setInventorySlotContents(slot, null);
            } else {
                itemStack = itemStack.splitStack(amount);
                if (itemStack.stackSize == 1) {
                    setInventorySlotContents(slot, null);

                }
            }
        }

        return itemStack;
    }

    @Override
    public void updateEntity() {

        ++tickCount;

        if (worldObj.isRemote) {
            return;
        }

        if (inventory[0] == null || inventory[1] == null) {
            return;
        }

        if (MixingTableHelper.canSmelt(inventory[0], inventory[1]) == false && inventory[2] != null) {
            return;
        }
        ++progress;

        ItemStack result = MixingTableHelper.getResult(inventory[0], inventory[1]);

        if (progress >= 50) {

            inventory[2] = result;
            // System.out.println(inventory[1] + " and " + inventory[0] + " = "
// + result);
            progress = 0;
        }

    }

    {
        boolean hasToUpdate = false;

        if (hasToUpdate) {

            PacketDispatcher.sendPacketToAllAround(xCoord, yCoord, zCoord, 8,
                    this.worldObj.provider.dimensionId, getDescriptionPacket());

        }

        if (tickCount >= 20) {
            tickCount = 0;
        }
    }

    public void onDataPacket(INetworkManager net, Packet132TileEntityData pkt) {

        if (pkt.customParam1 != null) {
            progress = pkt.customParam1.getInteger("Progress");
        }
    }

    @Override
    public Packet getDescriptionPacket() {

        NBTTagCompound nbtTag = new NBTTagCompound();
        nbtTag.setInteger("Progress", progress);
        return new Packet132TileEntityData(this.xCoord, this.yCoord, this.zCoord, 1, nbtTag);
    }

    @Override
    public void readFromNBT(NBTTagCompound nbtTagCompound) {

        super.readFromNBT(nbtTagCompound);

        // Read in the ItemStacks in the inventory from NBT
        NBTTagList tagList = nbtTagCompound.getTagList("Items");
        inventory = new ItemStack[this.getSizeInventory()];
        for (int i = 0; i < tagList.tagCount(); ++i) {
            NBTTagCompound tagCompound = (NBTTagCompound) tagList.tagAt(i);
            byte slot = tagCompound.getByte("Slot");
            if (slot >= 0 && slot < inventory.length) {
                inventory[slot] = ItemStack.loadItemStackFromNBT(tagCompound);
            }
        }
        progress = nbtTagCompound.getInteger("Progress");

    }

    @Override
    public void writeToNBT(NBTTagCompound nbtTagCompound) {

        super.writeToNBT(nbtTagCompound);

        // Write the ItemStacks in the inventory to NBT
        NBTTagList tagList = new NBTTagList();
        for (int currentIndex = 0; currentIndex < inventory.length; ++currentIndex) {
            if (inventory[currentIndex] != null) {
                NBTTagCompound tagCompound = new NBTTagCompound();
                tagCompound.setByte("Slot", (byte) currentIndex);
                inventory[currentIndex].writeToNBT(tagCompound);
                tagList.appendTag(tagCompound);
            }
        }
        nbtTagCompound.setTag("Items", tagList);
        nbtTagCompound.setInteger("Progress", progress);
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

        inventory[slot] = itemStack;

        if (itemStack != null && itemStack.stackSize > getInventoryStackLimit()) {
            itemStack.stackSize = getInventoryStackLimit();
        }
    }

    @Override
    public String getInvName() {

        return this.hasCustomName() ? this.getCustomName() : Strings.CONTAINER_MIXINGTABLE;
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

        return true;
    }

}
