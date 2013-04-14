package com.cyntain.Fm.Item;
import com.cyntain.Fm.lib.ItemIDs;


import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;



public class ModItem {
    
  /* Mod item instances */
    public static Item copperIngot;
    public static Item ChunkCopper;  
    public static Item osmiumIngot;
    public static Item ChunkOsmium;
    public static Item berylliumIngot;
    public static Item ChunkBeryllium;
    
    
    
    public static void init(){
      
  /* Initialise each mod item individually */
      copperIngot = new itemCopperIngot(ItemIDs.COPPER_INGOT_DEFAULT); 
      LanguageRegistry.addName(copperIngot, "Copper Ingot");
      ChunkCopper = new itemCopperOreChunk(ItemIDs.COPPER_CHUNK_DEFAULT); 
      LanguageRegistry.addName(ChunkCopper, "Copper Ore Chunk");
      osmiumIngot = new itemOsmiumIngot(ItemIDs.OSMIUM_INGOT_DEFAULT);
      LanguageRegistry.addName(osmiumIngot, "Osmium Ingot");
      ChunkOsmium = new itemOsmiumChunk(ItemIDs.OSMIUM_CHUNK_DEFAULT);
      LanguageRegistry.addName(ChunkOsmium, "Osmium Ore Chunk");
      berylliumIngot = new itemBerylliumIngot(ItemIDs.BERYLLIUM_INGOT_DEFAULT);
      LanguageRegistry.addName(berylliumIngot, "Beryllium Ingot");
      ChunkBeryllium = new itemChunkBeryllium(ItemIDs.BERYLLIUM_CHUNK_DEFAULT);
      LanguageRegistry.addName(ChunkBeryllium, "Beryllium Ore Chunk");
      
      /* Register + Initialise Smelting Recipes */
      GameRegistry.addSmelting(ModItem.ChunkCopper.itemID, new ItemStack(copperIngot), 5.0f);
      GameRegistry.addSmelting(ModItem.ChunkOsmium.itemID, new ItemStack(osmiumIngot), 5.0f);
      GameRegistry.addSmelting(ModItem.ChunkBeryllium.itemID, new ItemStack(berylliumIngot), 5.0f);
     
      
      
   }
}