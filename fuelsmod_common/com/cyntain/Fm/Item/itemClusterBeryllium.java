
package com.cyntain.Fm.Item;


import com.cyntain.Fm.CreativeTab.CreativeTabFm;
import com.cyntain.Fm.lib.Strings;




public class itemClusterBeryllium extends ItemFm {
    public itemClusterBeryllium(int id) {

        super(id);
        this.setUnlocalizedName(Strings.BERYLLIUM_CLUSTER_NAME);
        setCreativeTab(CreativeTabFm.tabsFuelMod);
    }
}
