package com.cyntain.Fm.block;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;

import com.cyntain.Fm.creativetab.CreativeTabFm;
import com.cyntain.Fm.item.ModItem;
import com.cyntain.Fm.lib.Reference;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;


public class BlockOsmium extends Block {

    public BlockOsmium(int id, Material par2Material) {

        super(id, par2Material);
        this.setCreativeTab(CreativeTabFm.tabsFuelMod);
        this.setHardness(5f);

    }

    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister iconRegister) {

        this.blockIcon = iconRegister.registerIcon(Reference.MOD_ID + ":"
                + this.getUnlocalizedName2());
    }

    @Override
    public int damageDropped(int metadata) {

        return 2;

    }

    public int idDropped(int meta, Random random, int fortune) {

        return ModItem.rawIngot.itemID;
    }

    public int quantityDropped(Random par1Random) {

        return 9;
    }

}
