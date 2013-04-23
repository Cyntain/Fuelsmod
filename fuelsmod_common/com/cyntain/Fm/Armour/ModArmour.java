package com.cyntain.Fm.Armour;

import com.cyntain.Fm.lib.ItemIDs;

import net.minecraft.item.Item;

public class ModArmour {
    
    //Mod armour instances
    public static Item miningHelmet;

    public static void init(){
        
        //Initialize each mod item individually
        
        //miningHelmet
        miningHelmet = new armourMiningHelmet(ItemIDs.MINING_HELMET_DEFAULT);
        
    }
    
}
