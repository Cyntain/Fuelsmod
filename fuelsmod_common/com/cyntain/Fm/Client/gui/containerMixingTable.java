package com.cyntain.Fm.Client.gui;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.ContainerWorkbench;
import net.minecraft.world.World;

public class containerMixingTable extends ContainerWorkbench  {

    public containerMixingTable(InventoryPlayer player,World world, int x, int y, int z) {

        super(player, world, x, y, z);
       
    }
@Override
public boolean canInteractWith(EntityPlayer var1){
    return true;
    
}

@Override
public void onCraftGuiClosed(EntityPlayer player) {

    super.onCraftGuiClosed(player);
  
}
}
