
package com.cyntain.Fm.block;


/*
 * This will be tier one tech item. 
 * Need to make gui
 * 
 * */
import java.util.List;

import com.cyntain.Fm.lib.Strings;

import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;




public class BlockSteamSmelter extends BlockFm {

    public BlockSteamSmelter(int id, Material material) {

        super(id, material);
        setUnlocalizedName(Strings.STEAM_SMELTER_BLOCK);
        setHardness(5F);
    }
    
    @SuppressWarnings({ "unchecked" , "rawtypes" })
    public void addInformation(ItemStack itemStack, EntityPlayer player, List list, boolean par4) {

        list.add("Smelting since 1863");
    }

}
