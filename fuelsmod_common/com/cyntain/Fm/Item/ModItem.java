package com.cyntain.Fm.Item;

import com.cyntain.Fm.lib.ItemIDs;

import cpw.mods.fml.common.registry.GameRegistry;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

/*Fuels Mod
 * 
 * @Authors: Cyntain and Paronamixxe
 * 
 * FuelsMod
 * 
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 * 
 * @credit: Visual_Argonian, Pahimar and Plenty_of_Fish
 * */


public class ModItem {
 
  /* Mod item instances */
    public static Item copperIngot;
    public static Item ChunkCopper;  
    public static Item ClusterCopper;
    public static Item osmiumIngot;
    public static Item ChunkOsmium;
    public static Item osmiumGrate;
    public static Item berylliumIngot;
    public static Item ChunkBeryllium;
    public static Item clusterBeryllium;
    public static Item zeoliteDust;
    public static Item zeoliteDustVial;
    public static Item zeoliteDustDyed;
    public static Item emptyVial;
    public static Item compounds;
    
    public static void init(){
      
  /* Initialise each mod item individually */
        
        // COPPER ITEMs
      copperIngot = new itemCopperIngot(ItemIDs.COPPER_INGOT); 
      ChunkCopper = new itemCopperOreChunk(ItemIDs.COPPER_CHUNK); 
      ClusterCopper = new itemClusterCopper(ItemIDs.COPPER_CLUSTER);
     
      // OSMIUM ITEMs
      osmiumIngot = new itemOsmiumIngot(ItemIDs.OSMIUM_INGOT);
      ChunkOsmium = new itemOsmiumChunk(ItemIDs.OSMIUM_CHUNK);
      osmiumGrate = new itemOsmiumGrate(ItemIDs.OSMIUM_GRATE);
      
      // BERYLLIUM ITEMs
      berylliumIngot = new itemBerylliumIngot(ItemIDs.BERYLLIUM_INGOT);
      ChunkBeryllium = new itemChunkBeryllium(ItemIDs.BERYLLIUM_CHUNK);
      clusterBeryllium = new itemClusterBeryllium(ItemIDs.BERYLLIUM_CLUSTER);

      // ZEOLITE ITEMs
      zeoliteDust = new itemZeoliteDust(ItemIDs.ZEOLITE_DUST);
      zeoliteDustVial = new itemZeoliteVial(ItemIDs.ZEOLITE_DUST_VIAL);
      zeoliteDustDyed = new itemZeoliteDyed(ItemIDs.ZEOLITE_DYED_DEFAULT); // need to add to config
      
      // OTHER ITEMs
      emptyVial = new itemEmptyVial(ItemIDs.EMPTY_VIAL);
      compounds = new itemCompounds(ItemIDs.COMPOUND_DEFAULT); // need to add to config
      
      /* Register + Initialise Smelting Recipes */
      GameRegistry.addSmelting(ModItem.ChunkCopper.itemID, new ItemStack(copperIngot), 5.0f);
      GameRegistry.addSmelting(ModItem.ChunkOsmium.itemID, new ItemStack(osmiumIngot), 5.0f);
      GameRegistry.addSmelting(ModItem.ChunkBeryllium.itemID, new ItemStack(berylliumIngot), 5.0f);
      GameRegistry.addSmelting(ModItem.ClusterCopper.itemID, new ItemStack(copperIngot, 9), 10.0f);
      GameRegistry.addSmelting(ModItem.clusterBeryllium.itemID, new ItemStack(berylliumIngot, 9), 10.0f);
    
      /* Shaped Crafting Recipe*/
      GameRegistry.addRecipe(new ItemStack(ModItem.ClusterCopper, 1), "XXX", "XXX", "XXX", Character.valueOf('X'), ModItem.ChunkCopper);
      GameRegistry.addRecipe(new ItemStack(ModItem.clusterBeryllium, 1), "XXX", "XXX", "XXX", Character.valueOf('X'), ModItem.ChunkBeryllium);
      GameRegistry.addRecipe(new ItemStack(ModItem.osmiumGrate, 4), "WXW", "XXX", "WXW", Character.valueOf('W'), Item.ingotIron, Character.valueOf('X'), ModItem.osmiumIngot);
      GameRegistry.addRecipe(new ItemStack(ModItem.emptyVial, 1), "X X", "X X", " X ", Character.valueOf('X'), Block.glass);
      GameRegistry.addRecipe(new ItemStack(ModItem.zeoliteDustVial, 1), "XXX", "XYX", "XXX", Character.valueOf('X'), ModItem.zeoliteDust, Character.valueOf('Y'), ModItem.emptyVial);
      GameRegistry.addRecipe(new ItemStack(ModItem.zeoliteDust, 8) , "X", Character.valueOf('X'), ModItem.zeoliteDustVial);
      
      /* Compound recipes*/
   
   }
}