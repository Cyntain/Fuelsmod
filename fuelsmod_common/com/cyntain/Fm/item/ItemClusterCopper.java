package com.cyntain.Fm.item;

import com.cyntain.Fm.creativetab.CreativeTabFm;
import com.cyntain.Fm.lib.Strings;


public class ItemClusterCopper extends ItemFm {

    public ItemClusterCopper(int id) {

        super(id);
        this.setUnlocalizedName(Strings.COPPER_CLUSTER_NAME);
        setCreativeTab(CreativeTabFm.tabsFuelMod);
    }
}
