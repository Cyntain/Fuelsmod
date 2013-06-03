
package com.cyntain.Fm.block;


import java.util.List;

import com.cyntain.Fm.lib.Strings;

import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;




public class BlockWorktable extends BlockFm {

    public BlockWorktable(int id, Material material) {

        super(id, material);
        setUnlocalizedName(Strings.WORKTABLE_BLOCK);
        setHardness(5F);

    }

    public boolean onBlockActivated(World world, int x, int y, int z,
            EntityPlayer player, int par6, float par7, float par8, float par9) {

        if (player.isSneaking() == false) {

            player.displayGUIWorkbench(x, y, z);
            return true;

        } else {
            player.displayGUIWorkbench(x, y, z);
            return false;

        }

    }
    
    @SuppressWarnings({ "unchecked" , "rawtypes" })
    public void addInformation(ItemStack itemStack, EntityPlayer player, List list, boolean par4) {

        list.add("Crafting benches are so last year!");
    }

}
