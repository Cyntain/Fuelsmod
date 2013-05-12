
package com.cyntain.Fm.Item;


import com.cyntain.Fm.CreativeTab.CreativeTabFm;
import com.cyntain.Fm.lib.Strings;




public class itemOsmiumChunk extends ItemFm {
    public itemOsmiumChunk(int id) {

        super(id);
        this.setUnlocalizedName(Strings.OSMIUM_CHUNK_NAME);
        setCreativeTab(CreativeTabFm.tabsFuelMod);
    }
}
