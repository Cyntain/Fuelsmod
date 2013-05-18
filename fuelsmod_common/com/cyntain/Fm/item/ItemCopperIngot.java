package com.cyntain.Fm.item;

import com.cyntain.Fm.creativetab.CreativeTabFm;
import com.cyntain.Fm.lib.Strings;


public class ItemCopperIngot extends ItemFm {

    public ItemCopperIngot(int id) {

        super(id);
        this.setUnlocalizedName(Strings.COPPER_INGOT_NAME);
        setCreativeTab(CreativeTabFm.tabsFuelMod);
    }

}
