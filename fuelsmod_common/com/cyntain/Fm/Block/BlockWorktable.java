package com.cyntain.Fm.Block;

import com.cyntain.Fm.lib.Strings;

import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public class BlockWorktable extends BlockFm {

    public BlockWorktable(int id, Material material) {
        
        super(id, material);
        setUnlocalizedName(Strings.WORKTABLE_BLOCK);
        setHardness(5F);
        
    }
    
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int par6, float par7, float par8, float par9)
    {
        if(player.isSneaking() == false){
       
            player.displayGUIWorkbench(x, y, z);
            return true;
            
        }else{
            player.displayGUIWorkbench(x, y, z);
            return false;
            
        }
            
    }
    
}
    
