package com.cyntain.Fm.item;

import com.cyntain.Fm.creativetab.CreativeTabFm;
import com.cyntain.Fm.lib.Strings;

import net.minecraft.item.Item;

public class ItemCopperCog extends ItemFm {

    public ItemCopperCog(int id) {
        
        super(id);
        this.setUnlocalizedName(Strings.COPPER_COG_NAME);
        setCreativeTab(CreativeTabFm.tabsFuelMod);
        
    }

}
