
package com.cyntain.Fm.item;


import com.cyntain.Fm.creativetab.CreativeTabFm;
import com.cyntain.Fm.lib.Strings;




public class ItemBerylliumIngot extends ItemFm {
    public ItemBerylliumIngot(int id) {

        super(id);
        this.setUnlocalizedName(Strings.BERYLLIUM_INGOT_NAME);
        setCreativeTab(CreativeTabFm.tabsFuelMod);
    }
}
