package com.cyntain.Fm.Item;

import com.cyntain.Fm.CreativeTab.CreativeTabFm;
import com.cyntain.Fm.lib.Strings;

public class itemEmptyVial extends ItemFm {
   public itemEmptyVial(int id){
       super(id);
       setUnlocalizedName(Strings.EMPTY_VIAL_NAME);
       setCreativeTab(CreativeTabFm.tabsFuelMod);
   }
}
