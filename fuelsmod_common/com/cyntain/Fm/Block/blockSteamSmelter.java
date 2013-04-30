package com.cyntain.Fm.Block;

import com.cyntain.Fm.lib.Strings;

import net.minecraft.block.material.Material;

public class blockSteamSmelter extends BlockFm {

    public blockSteamSmelter(int id, Material material) {

        super(id, material);
        setUnlocalizedName(Strings.STEAM_SMELTER_BLOCK);
        setHardness(5F);
    }
 
}


