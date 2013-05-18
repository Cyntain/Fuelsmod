package com.cyntain.Fm.item;

import com.cyntain.Fm.creativetab.CreativeTabFm;
import com.cyntain.Fm.lib.Strings;


public class ItemClusterBeryllium extends ItemFm {

    public ItemClusterBeryllium(int id) {

        super(id);
        this.setUnlocalizedName(Strings.BERYLLIUM_CLUSTER_NAME);
        setCreativeTab(CreativeTabFm.tabsFuelMod);
    }
}
