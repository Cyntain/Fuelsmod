package com.cyntain.Fm.Item;

import com.cyntain.Fm.CreativeTab.CreativeTabFm;
import com.cyntain.Fm.lib.Strings;



public class itemClusterCopper extends ItemFm {
     public itemClusterCopper(int id){
         super(id);
         this.setUnlocalizedName(Strings.COPPER_CLUSTER_NAME);
         setCreativeTab(CreativeTabFm.tabsFuelMod);
     }
}
