package com.cyntain.Fm.tileentity;

import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.network.INetworkManager;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.Packet132TileEntityData;

import com.cyntain.Fm.core.helper.MixingTableHelper;
import com.cyntain.Fm.item.ModItem;
//import com.cyntain.Fm.item.ModItem;
import com.cyntain.Fm.lib.Strings;
import cpw.mods.fml.common.network.PacketDispatcher;
import de.paleocrafter.pmfw.network.data.TileData;
import de.paleocrafter.pmfw.recipes.data.RecipeItemStack;


public class TileMixingTable extends TileFm implements IInventory {

    private ItemStack[]     mixingTableInv;
    public final static int INVENTORY_SIZE    = 3;
    public int              tickCount;
    @TileData
    private int             progress;
    private boolean         processing;
    private ItemStack       currentResult;
    public static int       input1_SLOT_INDEX = 0;
    public static int       input2_SLOT_INDEX = 1;
    public static int       OUTPUT_SLOT_INDEX = 2;
    public boolean          debug             = true;

    public TileMixingTable() {

        mixingTableInv = new ItemStack[INVENTORY_SIZE];

    }

    @Override
    public int getSizeInventory() {

        return this.mixingTableInv.length;
    }

    @Override
    public ItemStack getStackInSlot(int slot) {

        return mixingTableInv[slot];
    }

    @Override
    public ItemStack decrStackSize(int slot, int amount) {

        if (this.mixingTableInv[slot] != null) {
            ItemStack itemStack;
            if (this.mixingTableInv[slot].stackSize >= amount) {
                itemStack = this.mixingTableInv[slot];
                this.mixingTableInv[slot] = null;
                return itemStack;
            } else {
                itemStack = this.mixingTableInv[slot].splitStack(amount);
                if (this.mixingTableInv[slot].stackSize == 0) {
                    this.mixingTableInv[slot] = null;
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

        ++tickCount;

        if (worldObj.isRemote) {
            return;
        }

        if (!processing && (mixingTableInv[0] == null || mixingTableInv[1] == null))
            return;

        if (!processing) {
            currentResult = MixingTableHelper.getResult(mixingTableInv[0], mixingTableInv[1]);
            if (currentResult == null)
                currentResult = new ItemStack(ModItem.zeoliteDust, 1);
            processing = true;
        }
        if (currentResult == null) {
            return;
        } else {
            if (mixingTableInv[2] == null
                    || new RecipeItemStack(mixingTableInv[2]).equals(new RecipeItemStack(
                            currentResult))) {
                progress++;
                hasToUpdate = true;

                if (progress >= 100) {
                    boolean success = true;
                    if (mixingTableInv[2] != null) {
                        if (mixingTableInv[2].stackSize <= 63)
                            mixingTableInv[2].stackSize++;
                        else
                            success = false;
                    } else {
                        mixingTableInv[2] = currentResult;
                    }
                    if (success) {
                        if (mixingTableInv[0] != null) {
                            mixingTableInv[0].stackSize--;
                            if (mixingTableInv[0].stackSize <= 0)
                                mixingTableInv[0] = null;
                        }
                        if (mixingTableInv[1] != null) {
                            mixingTableInv[1].stackSize--;
                            if (mixingTableInv[1].stackSize <= 0)
                                mixingTableInv[1] = null;
                        }
                    }
                    hasToUpdate = true;
                    if (debug) {
                        System.out.println(mixingTableInv[1] + " and " + mixingTableInv[0] + " = "
                                + currentResult);
                    }
                    progress = 0;
                    processing = false;
                    currentResult = null;
                }
            }
        }
        if (hasToUpdate) {

            PacketDispatcher.sendPacketToAllAround(xCoord, yCoord, zCoord, 8,
                    this.worldObj.provider.dimensionId, getDescriptionPacket());

        }

        if (tickCount >= 20) {
            tickCount = 0;
        }
    }

    public int getProgress() {

        return progress;
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
        mixingTableInv = new ItemStack[this.getSizeInventory()];
        for (int i = 0; i < tagList.tagCount(); ++i) {
            NBTTagCompound tagCompound = (NBTTagCompound) tagList.tagAt(i);
            byte slot = tagCompound.getByte("Slot");
            if (slot >= 0 && slot < mixingTableInv.length) {
                mixingTableInv[slot] = ItemStack.loadItemStackFromNBT(tagCompound);
            }
        }
         progress = nbtTagCompound.getInteger("Progress");

    }

    @Override
    public void writeToNBT(NBTTagCompound nbtTagCompound) {

        super.writeToNBT(nbtTagCompound);

        // Write the ItemStacks in the inventory to NBT
        NBTTagList tagList = new NBTTagList();
        for (int currentIndex = 0; currentIndex < mixingTableInv.length; ++currentIndex) {
            if (mixingTableInv[currentIndex] != null) {
                NBTTagCompound tagCompound = new NBTTagCompound();
                tagCompound.setByte("Slot", (byte) currentIndex);
                mixingTableInv[currentIndex].writeToNBT(tagCompound);
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

        mixingTableInv[slot] = itemStack;

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
