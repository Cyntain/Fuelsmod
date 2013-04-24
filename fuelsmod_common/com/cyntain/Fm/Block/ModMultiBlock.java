package com.cyntain.Fm.Block;

import com.cyntain.Fm.lib.BlockIDs;

import cpw.mods.fml.common.registry.GameRegistry;

import net.minecraft.block.Block;

public class ModMultiBlock {

   public static Block multiSmelterCore = null;
   public static Block multiSmelterDummy = null;
    
    public static void Init()
    {
        /* Block statements */  
        multiSmelterCore = new blockMultiSmelterCore(BlockIDs.MULTIBLOCK_SMELTER_CORE_DEFAULT);
        multiSmelterDummy = new blockMultiSmelterCore(BlockIDs.MULTIBLOCK_SMELTER_DUMMY_DEFAULT);
        GameRegistry.registerBlock(multiSmelterCore, "blockMultiSmelterCore");
        GameRegistry.registerBlock(multiSmelterDummy, "blockMultiSmelterDummy");
        
    }
    
    
}
