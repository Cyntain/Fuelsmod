package de.paleocrafter.pmfw.network.data;

import com.google.common.io.ByteArrayDataInput;
import com.google.common.io.ByteArrayDataOutput;

import net.minecraft.nbt.NBTTagInt;
import net.minecraft.nbt.NBTTagList;
import net.minecraftforge.common.ForgeDirection;

/**
 * 
 * Fuels Mod
 * 
 * DataForgeDirection
 * 
 * @author PaleoCrafter
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 * 
 */
public class DataForgeDirection implements IDataObject {
    private ForgeDirection internal;
    
    public DataForgeDirection() {
        
    }

    public DataForgeDirection(ForgeDirection direction) {
        internal = direction;
    }

    public ForgeDirection getDirection() {
        return internal;
    }

    @Override
    public void writeToNBT(NBTTagList nbtTag) {
        nbtTag.appendTag(new NBTTagInt("Direction", internal.ordinal()));
    }

    @Override
    public void readFromNBT(NBTTagList nbtTag) {
        internal = ForgeDirection
                .getOrientation(((NBTTagInt) nbtTag.tagAt(0)).data);
    }

    @Override
    public void writeToPacket(ByteArrayDataOutput out) {
        out.writeInt(internal.ordinal());
    }

    @Override
    public void readFromPacket(ByteArrayDataInput in) {
        internal = ForgeDirection.getOrientation(in.readInt());
    }
}
