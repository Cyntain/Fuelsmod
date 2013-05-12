
package com.cyntain.Fm.Block;


/*
 * This will be tier one tech item. 
 * Need to make gui
 * 
 * */
import com.cyntain.Fm.lib.Strings;

import net.minecraft.block.material.Material;




public class BlockSteamSmelter extends BlockFm {

    public BlockSteamSmelter(int id, Material material) {

        super(id, material);
        setUnlocalizedName(Strings.STEAM_SMELTER_BLOCK);
        setHardness(5F);
    }

}
