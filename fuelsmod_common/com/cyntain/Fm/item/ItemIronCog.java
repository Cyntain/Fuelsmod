package com.cyntain.Fm.item;

import com.cyntain.Fm.creativetab.CreativeTabFm;
import com.cyntain.Fm.lib.Strings;

import net.minecraft.item.Item;

public class ItemIronCog extends ItemFm {

    public ItemIronCog(int id) {
        
        super(id);
        this.setUnlocalizedName(Strings.IRON_COG_NAME);
        setCreativeTab(CreativeTabFm.tabsFuelMod);
        
    }

}
