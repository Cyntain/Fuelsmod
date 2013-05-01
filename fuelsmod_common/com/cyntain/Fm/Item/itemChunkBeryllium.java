package com.cyntain.Fm.Item;

import com.cyntain.Fm.CreativeTab.CreativeTabFm;
import com.cyntain.Fm.lib.Strings;


public class itemChunkBeryllium extends ItemFm {
    public itemChunkBeryllium(int id){
        super(id);
         this.setUnlocalizedName(Strings.BERYLLIUM_CHUNK_NAME);
         setCreativeTab(CreativeTabFm.tabsFuelMod);
    }
}
