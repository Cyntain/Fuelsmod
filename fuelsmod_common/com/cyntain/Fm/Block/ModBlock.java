package com.cyntain.Fm.Block;

import com.cyntain.Fm.Item.ModItem;
import com.cyntain.Fm.lib.BlockIDs;
import com.cyntain.Fm.lib.Reference;
import com.cyntain.Fm.lib.Strings;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.ItemStack;


public class ModBlock{
    
        /* Block statements */         
        public static Block copperOre;
        public static Block osmiumOre;
        public static Block berylliumOre;
        public static Block zeoliteOre;
        public static Block copperBlock;
        public static Block osmiumBlock;
        public static Block berylliumBlock;
        public static Block heatproofBrickBlock;
    
    public static void init() {
        
        /* Block statements: Copper Blocks */  
        copperOre = new BlockCopperOre(BlockIDs.COPPER_ORE_DEFAULT, Material.rock).setUnlocalizedName(Strings.COPPER_ORE);
        GameRegistry.registerBlock(copperOre, Reference.MOD_ID + copperOre.getUnlocalizedName2());
        copperBlock = new BlockCopper(BlockIDs.COPPER_BLOCK_DEFAULT, Material.rock).setUnlocalizedName(Strings.COPPER_BLOCK);
        GameRegistry.registerBlock(copperBlock, Reference.MOD_ID + copperBlock.getUnlocalizedName2());
        
        /* Block statements: Osmium Blocks */
        osmiumOre = new BlockOsmiumOre(BlockIDs.OSMIUM_ORE_DEFAULT, Material.rock).setUnlocalizedName(Strings.OSMIUM_ORE);
        GameRegistry.registerBlock(osmiumOre, Reference.MOD_ID + osmiumOre.getUnlocalizedName2());
        osmiumBlock = new BlockOsmium(BlockIDs.OSMIUM_BLOCK_DEFAULT, Material.rock).setUnlocalizedName(Strings.OSMIUM_BLOCK);
        GameRegistry.registerBlock(osmiumBlock, Reference.MOD_ID + osmiumBlock.getUnlocalizedName2());
        
        /* Block statements: Beryllium Blocks */
        berylliumOre = new BlockBerylliumOre(BlockIDs.BERYLLIUM_ORE_DEFAULT, Material.rock).setUnlocalizedName(Strings.BERYLLIUM_ORE);
        GameRegistry.registerBlock(berylliumOre, Reference.MOD_ID + berylliumOre.getUnlocalizedName2());
        berylliumBlock = new BlockBeryllium(BlockIDs.BERYLLIUM_BLOCK_DEFAULT, Material.rock).setUnlocalizedName(Strings.BERYLLIUM_BLOCK);
        GameRegistry.registerBlock(berylliumBlock, Reference.MOD_ID + berylliumBlock.getUnlocalizedName2());
        
        /* Block statements: Zeolite Blocks */
        zeoliteOre = new BlockZeoliteOre(BlockIDs.ZEOLITE_ORE_DEFAULT, Material.rock).setUnlocalizedName(Strings.ZEOLITE_ORE);
        GameRegistry.registerBlock(zeoliteOre, Reference.MOD_ID + zeoliteOre.getUnlocalizedName2());
        
        /* Block statements: HeatProofBrick Blocks */
        heatproofBrickBlock = new Blockheatproofbrick(BlockIDs.HEATPROOFBRICK_BLOCK_DEFAULT, Material.rock).setUnlocalizedName(Strings.HEATPROOFBRICK_BLOCK);
        GameRegistry.registerBlock(heatproofBrickBlock, Reference.MOD_ID + heatproofBrickBlock.getUnlocalizedName2());
        
        //Recipes
        GameRegistry.addRecipe(new ItemStack(copperBlock, 1), "XXX", "XXX", "XXX", Character.valueOf('X'), ModItem.copperIngot);
        GameRegistry.addRecipe(new ItemStack(osmiumBlock, 1), "XXX", "XXX", "XXX", Character.valueOf('X'), ModItem.osmiumIngot);
        GameRegistry.addRecipe(new ItemStack(berylliumBlock, 1), "XXX", "XXX", "XXX", Character.valueOf('X'), ModItem.berylliumIngot);
        
    }
    
    }
