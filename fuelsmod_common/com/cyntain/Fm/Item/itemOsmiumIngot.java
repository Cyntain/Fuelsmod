package com.cyntain.Fm.item;

import com.cyntain.Fm.creativetab.CreativeTabFm;
import com.cyntain.Fm.lib.Strings;


public class ItemOsmiumIngot extends ItemFm {

    public ItemOsmiumIngot(int id) {

        super(id);
        this.setUnlocalizedName(Strings.OSMIUM_INGOT_NAME);
        setCreativeTab(CreativeTabFm.tabsFuelMod);
    }

}
