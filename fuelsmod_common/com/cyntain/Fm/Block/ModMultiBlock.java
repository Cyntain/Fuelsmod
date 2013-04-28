package com.cyntain.Fm.Block;

import com.cyntain.Fm.lib.BlockIDs;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

import net.minecraft.block.Block;

public class ModMultiBlock {

   public static Block multiSmelterCore;
   public static Block multiSmelterDummy;
    
    public static void Init()
    {
        
       
        multiSmelterCore = new blockMultiSmelterCore(BlockIDs.MULTIBLOCK_SMELTER_CORE_DEFAULT);
        multiSmelterDummy = new blockMultiSmelterCore(BlockIDs.MULTIBLOCK_SMELTER_DUMMY_DEFAULT);
        
        GameRegistry.registerBlock(multiSmelterCore, "blockMultiSmelterCore");
        GameRegistry.registerBlock(multiSmelterDummy, "blockMultiSmelterDummy");
        
        LanguageRegistry.addName(multiSmelterCore, "Multi-Furnace Core");
        LanguageRegistry.addName(multiSmelterDummy, "Multi-Furnace Dummy");
    }
    
    
}
