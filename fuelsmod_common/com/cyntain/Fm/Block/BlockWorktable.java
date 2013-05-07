package com.cyntain.Fm.Block;

import com.cyntain.Fm.lib.Strings;

import net.minecraft.block.material.Material;

public class BlockWorktable extends BlockFm {

    public BlockWorktable(int id, Material material) {
        
        super(id, material);
        setUnlocalizedName(Strings.WORKTABLE_BLOCK);
        setHardness(5F);
        
    }

    
}
