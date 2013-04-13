package com.cyntain.Fm.Item;

import com.cyntain.Fm.lib.Reference;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;



public class ItemFm extends Item {
   
    public ItemFm(int id){
        
        super(id - Reference.SHIFTED_ID_RANGE_CORRECTION);
           maxStackSize = 64;
               setCreativeTab(CreativeTabs.tabMisc);
    }
    
}
