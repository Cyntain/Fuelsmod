package com.cyntain.Fm.Item;

import com.cyntain.Fm.lib.Reference;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.Item;
import net.minecraft.util.Icon;



public class ItemFm extends Item {
   
    public ItemFm(int id){
        
        super(id- Reference.SHIFTED_ID_RANGE_CORRECTION);
        maxStackSize = 64;
    }

    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister iconRegister, Icon itemIcon) {

        itemIcon = iconRegister.registerIcon(Reference.MOD_ID.toLowerCase() + ":" + this.getUnlocalizedName().substring(this.getUnlocalizedName().indexOf(".") + 1));
    }
}
