package com.cyntain.Fm.Item;

import com.cyntain.Fm.CreativeTab.CreativeTabFm;
import com.cyntain.Fm.lib.Strings;

    public class itemOsmiumIngot extends ItemFm {
        public itemOsmiumIngot(int id){
            super(id);
             this.setUnlocalizedName(Strings.OSMIUM_INGOT_NAME);
             setCreativeTab(CreativeTabFm.tabsFuelMod);
        }
        
}
