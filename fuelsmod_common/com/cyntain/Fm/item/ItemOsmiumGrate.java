package com.cyntain.Fm.item;

import com.cyntain.Fm.creativetab.CreativeTabFm;
import com.cyntain.Fm.lib.Strings;


public class ItemOsmiumGrate extends ItemFm {

    public ItemOsmiumGrate(int id) {

        super(id);
        this.setUnlocalizedName(Strings.OSMIUM_GRATE_NAME);
        setCreativeTab(CreativeTabFm.tabsFuelMod);

    }
}