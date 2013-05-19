package com.cyntain.Fm.item;

import com.cyntain.Fm.lib.Reference;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import net.minecraft.client.renderer.texture.IconRegister;

import net.minecraft.item.Item;


public class ItemFm extends Item {

    public ItemFm(int id) {

        super(id - Reference.SHIFTED_ID_RANGE_CORRECTION);
        maxStackSize = 64;
        setNoRepair();
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void registerIcons(IconRegister iconregister) {

        this.itemIcon = iconregister.registerIcon(Reference.MOD_ID + ":"
                + this.getUnlocalizedName().substring(this.getUnlocalizedName().indexOf(".") + 1));
    }
}
