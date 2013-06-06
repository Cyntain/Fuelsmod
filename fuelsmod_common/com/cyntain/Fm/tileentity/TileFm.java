package com.cyntain.Fm.tileentity;

import de.paleocrafter.pmfw.network.data.DataForgeDirection;
import de.paleocrafter.pmfw.network.data.TileData;
import de.paleocrafter.pmfw.tileentity.TileEntityWithData;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.common.ForgeDirection;

public class TileFm extends TileEntityWithData {

    @TileData
    protected DataForgeDirection orientation;
    @TileData
    protected byte state;
    @TileData
    protected String customName;

    public TileFm() {
        orientation = new DataForgeDirection(ForgeDirection.SOUTH);
        state = 0;
        customName = "";
    }

    public ForgeDirection getOrientation() {

        return orientation.getDirection();
    }

    public void setOrientation(ForgeDirection orientation) {

        this.orientation = new DataForgeDirection(orientation);
    }

    public void setOrientation(int orientation) {

        this.orientation = new DataForgeDirection(
                ForgeDirection.getOrientation(orientation));
    }

    public short getState() {

        return state;
    }

    public void setState(byte state) {

        this.state = state;
    }

    public boolean hasCustomName() {

        return customName != null && customName.length() > 0;
    }

    public String getCustomName() {

        return customName;
    }

    public void setCustomName(String customName) {

        this.customName = customName;
    }

    public boolean isUseableByPlayer(EntityPlayer player) {

        return true;
    }
}
