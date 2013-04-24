package com.cyntain.Fm.core;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

import com.cyntain.Fm.Gui.GuiMultiSmelter;
import com.cyntain.Fm.core.proxy.CommonProxy;

import com.cyntain.Fm.tileEntity.TileEntityMultiSmelterCore;

public class ClientProxy extends CommonProxy{

    @Override
    public void registerRenders() {}
    
    @Override
    public Object getClientGuiElement(int id, EntityPlayer player, World world, int x, int y, int z)
    {
        TileEntityMultiSmelterCore tileEntity = (TileEntityMultiSmelterCore)world.getBlockTileEntity(x, y, z);
        
        if(tileEntity != null)
            return new GuiMultiSmelter(player.inventory, tileEntity);
        
        return null;
    }
    
}
