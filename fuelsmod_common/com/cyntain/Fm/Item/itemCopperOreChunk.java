package com.cyntain.Fm.Item;

import com.cyntain.Fm.CreativeTab.CreativeTabFm;
import com.cyntain.Fm.lib.Strings;

    public class itemCopperOreChunk extends ItemFm {
        public itemCopperOreChunk(int id){
            super(id);
             this.setUnlocalizedName(Strings.COPPER_CHUNK_NAME);
             setCreativeTab(CreativeTabFm.tabsFuelMod);
    }

}
