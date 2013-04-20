package com.cyntain.Fm.Block;

//import cpw.mods.fml.common.Mod;
import net.minecraft.block.Block;
import com.cyntain.Fm.lib.BlockID;
import com.cyntain.Fm.lib.Reference;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

    public class ModBlock {

        /* Mod block instances */
        public static Block copperOre ;
        public static Block berylliumOre ;
        public static Block osmiumOre ;
        public static Block zeoliteOre ;
        
        
    
    
    
    
    
    
    public static void init() {
        
        /* Initialise each mod block individually */
        
            //Copper Ore
                copperOre = new BlockCopperOre(BlockID.COPPER_ORE_DEFAULT);
                GameRegistry.registerBlock(copperOre, Reference.MOD_ID + copperOre.getUnlocalizedName2());
                LanguageRegistry.addName(copperOre, "Copper Ore");
        
        
  
    
   }
    }
