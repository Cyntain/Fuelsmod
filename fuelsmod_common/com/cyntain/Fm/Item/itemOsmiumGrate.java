
package com.cyntain.Fm.Item;


import com.cyntain.Fm.CreativeTab.CreativeTabFm;
import com.cyntain.Fm.lib.Strings;




public class itemOsmiumGrate extends ItemFm {
    public itemOsmiumGrate(int id) {

        super(id);
        this.setUnlocalizedName(Strings.OSMIUM_GRATE_NAME);
        setCreativeTab(CreativeTabFm.tabsFuelMod);

    }
}