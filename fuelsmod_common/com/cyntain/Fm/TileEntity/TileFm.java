package com.cyntain.Fm.TileEntity;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.ForgeDirection;

public class TileFm extends TileEntity{

    protected ForgeDirection orientation;
    protected byte state;
    protected String customName;
    public TileFm(){
        orientation = ForgeDirection.SOUTH;
        state = 0;
        customName = "";
    }
    public ForgeDirection getOrientation(){
        return orientation;
    }
    public void setOrientation(ForgeDirection orientation){
        this.orientation = orientation;
    }
    public void setOrientation(int orientation){
        this.orientation = ForgeDirection.getOrientation(orientation);
    }
    public short getState(){
        return state;
    }
    public void setState(byte state){
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
