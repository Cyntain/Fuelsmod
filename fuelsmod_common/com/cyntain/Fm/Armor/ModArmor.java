package com.cyntain.Fm.Armor;

import com.cyntain.Fm.lib.ItemIDs;

import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.Item;

public class ModArmor {
    
    //Mod armour instances
    public static Item miningHelmet;

    public static void init(){
        
        //Initialize each mod item individually
        
        //miningHelmet
        miningHelmet = new armorMiningHelmet(ItemIDs.MINING_HELMET_DEFAULT, EnumArmorMaterial.IRON, 0 );
        
    }
    
}
