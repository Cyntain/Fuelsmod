package com.cyntain.Fm.core.proxy;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

import com.cyntain.Fm.tileEntity.ContainerMultiSmelter;
import com.cyntain.Fm.tileEntity.TileEntityMultiSmelterCore;
import com.cyntain.Fm.tileEntity.TileEntityMultiSmelterDummy;

import cpw.mods.fml.common.network.IGuiHandler;
import cpw.mods.fml.common.registry.GameRegistry;

public class CommonProxy implements IGuiHandler
{
    public void registerTileEntities()
    {
        GameRegistry.registerTileEntity(TileEntityMultiSmelterCore.class, "tileEntityMultiSmelterCore");
        GameRegistry.registerTileEntity(TileEntityMultiSmelterDummy.class, "tileEntityMultiSmelterDummy");
    }
    
    @Override
    public Object getServerGuiElement(int guiID, EntityPlayer player, World world, int x, int y, int z)
    {
        TileEntityMultiSmelterCore tileEntity = (TileEntityMultiSmelterCore)world.getBlockTileEntity(x, y, z);
        if(tileEntity != null)
            return new ContainerMultiSmelter(player.inventory, tileEntity);
        
        return null;
    }
    
    @Override
    public Object getClientGuiElement(int guiID, EntityPlayer player, World world, int x, int y, int z)
    {
        return null;
    }
    
  public void registerRenders() {}
  
}
