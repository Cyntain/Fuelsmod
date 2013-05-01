package com.cyntain.Fm.Item;

import com.cyntain.Fm.CreativeTab.CreativeTabFm;
import com.cyntain.Fm.lib.Strings;

    public class itemCopperIngot extends ItemFm {
        public itemCopperIngot(int id){
            super(id);
             this.setUnlocalizedName(Strings.COPPER_INGOT_NAME);
             setCreativeTab(CreativeTabFm.tabsFuelMod);
        }
        
}
