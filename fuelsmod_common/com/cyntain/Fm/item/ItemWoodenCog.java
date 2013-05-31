package com.cyntain.Fm.item;

import com.cyntain.Fm.creativetab.CreativeTabFm;
import com.cyntain.Fm.lib.Strings;

import net.minecraft.item.Item;

public class ItemWoodenCog extends ItemFm {

    public ItemWoodenCog(int id) {
        
        super(id);
        this.setUnlocalizedName(Strings.WOODEN_COG_NAME);
        setCreativeTab(CreativeTabFm.tabsFuelMod);

    }

}
