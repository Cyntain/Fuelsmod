package com.cyntain.Fm.Item;
import com.cyntain.Fm.lib.ItemIDs;


import cpw.mods.fml.common.registry.LanguageRegistry;
import net.minecraft.item.Item;



public class ModItem {
    
  /* Mod item instances */
    public static Item copperIngot;
    public static Item ChunkCopper;  
    public static Item osmiumIngot;
    public static Item osmiumChunk;
    public static Item berylliumIngot;
    public static Item berylliumChunk;
    
    
    
    public static void init(){
      
  /* Initialise each mod item individually */
      copperIngot = new itemCopperIngot(ItemIDs.COPPER_INGOT_DEFAULT); 
      LanguageRegistry.addName(copperIngot, "Copper Ingot");
      ChunkCopper = new itemCopperOreChunk(ItemIDs.COPPER_CHUNK_DEFAULT); 
      LanguageRegistry.addName(ChunkCopper, "Copper Ore Chunk");
      osmiumIngot = new itemOsmiumIngot(ItemIDs.OSMIUM_CHUNK_DEFAULT);
      LanguageRegistry.addName(osmiumIngot, "Osmium Ingot");
      
      
      
      
     
      
      
    }
   }
