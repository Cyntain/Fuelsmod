
package com.cyntain.Fm.block;


import java.util.Random;

import com.cyntain.Fm.creativetab.CreativeTabFm;
import com.cyntain.Fm.lib.ItemIDs;
import com.cyntain.Fm.lib.Reference;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;




public class BlockZeoliteOre extends Block {

    public BlockZeoliteOre(int id, Material par2Material) {

        super(id, par2Material);
        this.setCreativeTab(CreativeTabFm.tabsFuelMod);
        this.setHardness(4.5f);

    }

    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister iconRegister) {

        this.blockIcon = iconRegister.registerIcon(Reference.MOD_ID + ":"
                + this.getUnlocalizedName2());
    }

    public int idDropped(int par1, Random par2Random, int par3) {

        return ItemIDs.ZEOLITE_DUST_DEFAULT;
    }

    public int quantityDroppedWithBonus(int par1, Random par2Random) {

        return this.quantityDropped(par2Random) + par2Random.nextInt(par1 + 1);
    }

    public int quantityDropped(Random par1Random) {

        return 4 + par1Random.nextInt(2);
    }

}
