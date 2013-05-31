package com.cyntain.Fm.item;

import com.cyntain.Fm.creativetab.CreativeTabFm;
import com.cyntain.Fm.lib.Strings;

import net.minecraft.item.Item;

public class ItemStoneCog extends ItemFm {

    public ItemStoneCog(int id) {
        
        super(id);
        this.setUnlocalizedName(Strings.STONE_COG_NAME);
        setCreativeTab(CreativeTabFm.tabsFuelMod);
    }

}
