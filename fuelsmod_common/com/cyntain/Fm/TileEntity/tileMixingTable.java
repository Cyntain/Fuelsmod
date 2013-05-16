
package com.cyntain.Fm.TileEntity;


import com.cyntain.Fm.Item.ModItem;
import com.cyntain.Fm.lib.Strings;

import cpw.mods.fml.common.network.PacketDispatcher;

import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.network.INetworkManager;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.Packet132TileEntityData;




/*    Thank you PaleoCrafter for the crash course in doing all of this!
 * TODO get the delay on the output working.
 * TODO get the decease on the items in slots 0 and 1 working
 * TODO get the increase on the items in slots 2 working
 * */

public class tileMixingTable extends TileFm implements IInventory {

    private ItemStack[] inventory;
    private final int   INVENTORY_SIZE = 3;
    private int         tickCount;
    private int         progress;
    public int          changeSlot2;
    public ItemStack    changeSlot1;
    public ItemStack    changeSlot0;
    public ItemStack    result;
   

    public tileMixingTable() {

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
                if (itemStack.stackSize == 0) {
                    setInventorySlotContents(slot, null);
                }
            }
        }

        return itemStack;
    }

    @Override
    public void updateEntity() {

        ++tickCount;

        if (!worldObj.isRemote) {

            boolean hasToUpdate = false;

            if (inventory[0] != null && inventory[1] != null) {

                hasToUpdate = true;

/* TODO Need to rewrite this quick fix, as it is messy and bad also does not fully work. */
                
/* Logic to decrease the number of items in slots 0 and 1 */

                ItemStack itemStackSlot1 = getStackInSlot(1);
// counting the number of items in slot 1
                ItemStack itemStackSlot0 = getStackInSlot(0); 
// counting the number of items in slot 0

                int stacksizeslot1 = itemStackSlot1.stackSize; 
// making the number of items in slot 1 be stored in stacksize
                int stacksizeslot0 = itemStackSlot0.stackSize;
// making the number of items in slot 0 be stored in stacksizeslot0

                if (itemStackSlot1.stackSize == 1
                        || itemStackSlot0.stackSize == 1) {
                    if (itemStackSlot1.stackSize == 1) {
                        changeSlot1 = null;
                    } else if (itemStackSlot0.stackSize == 1) {
                        changeSlot0 = null;
                    }

                } else if (itemStackSlot1.stackSize > 1
                        && itemStackSlot0.stackSize > 1) {
// If in slot 0 or 1 there is a item and the number of items is greater then 1 then decrease the stacksize
                    if (itemStackSlot1.stackSize >= 1) {
                        --stacksizeslot1;
                    }
                    if (itemStackSlot0.stackSize >= 1) {
                        --stacksizeslot0;
                    }

                    changeSlot1 = decrStackSize(1, stacksizeslot1);
                    changeSlot0 = decrStackSize(0, stacksizeslot0);
                }
                
                
/* Set the slots to contain something*/
                inventory[2] = inventory[1]; // output
                inventory[1] = changeSlot1; // input
                inventory[0] = changeSlot0; // input

                
                
                
                /* Logic to test what should be outputted */

                if (inventory[0] == new ItemStack(ModItem.compounds, 1, 0)
                        && inventory[1] == new ItemStack(ModItem.compounds, 1,
                                2)
                        || inventory[0] == new ItemStack(ModItem.compounds, 1,
                                2)
                        && inventory[1] == new ItemStack(ModItem.compounds, 1,
                                0)) {

                    result = new ItemStack(ModItem.zeoliteDustDyed, 1, 0);

                } else if (inventory[0] == new ItemStack(ModItem.compounds, 1,
                        2)
                        && inventory[1] == new ItemStack(ModItem.compounds, 1,
                                3)
                        || inventory[0] == new ItemStack(ModItem.compounds, 1,
                                3)
                        && inventory[1] == new ItemStack(ModItem.compounds, 1,
                                2)) {

                    result = new ItemStack(ModItem.zeoliteDustDyed, 1, 1);

                } else if (inventory[0] == new ItemStack(ModItem.compounds, 1,
                        3)
                        && inventory[1] == new ItemStack(ModItem.compounds, 1,
                                1)
                        || inventory[0] == new ItemStack(ModItem.compounds, 1,
                                1)
                        && inventory[1] == new ItemStack(ModItem.compounds, 1,
                                3)) {

                    result = new ItemStack(ModItem.zeoliteDustDyed,
                            changeSlot2, 2);

                } else if (inventory[0] == new ItemStack(ModItem.compounds, 1,
                        1)
                        && inventory[1] == new ItemStack(ModItem.compounds, 1,
                                0)
                        || inventory[0] == new ItemStack(ModItem.compounds, 1,
                                0)
                        && inventory[1] == new ItemStack(ModItem.compounds, 1,
                                1)) {

                    result = new ItemStack(ModItem.zeoliteDustDyed, 1, 3);

                } else {

                    result = new ItemStack(ModItem.zeoliteDust);
                }

                inventory[2] = result; // setting the output to the result

                hasToUpdate = true;

                if (hasToUpdate) {
                    PacketDispatcher.sendPacketToAllAround(xCoord, yCoord,
                            zCoord, 8, this.worldObj.provider.dimensionId,
                            getDescriptionPacket());

                }

                if (tickCount >= 20) {
                    tickCount = 0;
                }
            }
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
        return new Packet132TileEntityData(this.xCoord, this.yCoord,
                this.zCoord, 1, nbtTag);
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

        return this.hasCustomName() ? this.getCustomName()
                : Strings.CONTAINER_MIXINGTABLE;
    }

    @Override
    public boolean isInvNameLocalized() {

        return this.hasCustomName();
    }

    @Override
    public int getInventoryStackLimit() {

        return 64;
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
