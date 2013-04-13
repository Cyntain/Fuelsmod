package com.cyntain.Fm.Item;

import net.minecraft.item.Item;

import com.cyntain.Fm.lib.ItemID;




public class ModItem {
    
    /* Mod item instances */
    public static Item COPPER_INGOT;
     
    
 public static void init() {
      /* Initialise each mod item individually */
      COPPER_INGOT = new ItemCopperIngot(ItemID.COPPER_INGOT);
      
        
    }
    
    
    
    
}
