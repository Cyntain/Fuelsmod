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
    
    public boolean onBlockActivated(World par1World, int par2, int par3, int par4, EntityPlayer par5EntityPlayer, int par6, float par7, float par8, float par9)
    {
            par5EntityPlayer.displayGUIWorkbench(par2, par3, par4);
            return true;
            //DOES NOT WORK... JUST FLASHES... NEEDS TO BE FIXED*
    }
    
}
    
