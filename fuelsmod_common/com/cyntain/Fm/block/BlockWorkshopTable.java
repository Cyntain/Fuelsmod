
package com.cyntain.Fm.block;


import java.util.List;

import com.cyntain.Fm.lib.Strings;

import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;




public class BlockWorkshopTable extends BlockFm {

    public BlockWorkshopTable(int id, Material material) {

        super(id, material);
        setUnlocalizedName(Strings.WORKSHOPTABLE_BLOCK);
        setHardness(5F);

    }
    
    @SuppressWarnings({ "unchecked" , "rawtypes" })
    public void addInformation(ItemStack itemStack, EntityPlayer player, List list, boolean par4) {

        list.add("All the benefits of a workshop, in a table.");
    }

}
