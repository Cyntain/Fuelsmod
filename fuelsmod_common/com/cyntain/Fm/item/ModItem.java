package com.cyntain.Fm.item;

import com.cyntain.Fm.lib.ItemIDs;

import cpw.mods.fml.common.registry.GameRegistry;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;


public class ModItem {

    /* Mod item instances */
    public static Item oreChunks;
    public static Item cluster;
    public static Item rawIngot;
    public static Item osmiumGrate;
    public static Item zeoliteDust;
    public static Item zeoliteDustVial;
    public static Item zeoliteDustDyed;
    public static Item emptyVial;
    public static Item compounds;
    public static Item boiler;
    public static Item cog;

    public static void init() {

        /* Initialise each mod item individually */

        rawIngot = new ItemIngot(ItemIDs.RAW_INGOT);
        cluster = new ItemCluster(ItemIDs.CLUSTER);
        zeoliteDust = new ItemZeoliteDust(ItemIDs.ZEOLITE_DUST);
        zeoliteDustVial = new ItemZeoliteVial(ItemIDs.ZEOLITE_DUST_VIAL);
        zeoliteDustDyed = new ItemZeoliteDyed(ItemIDs.ZEOLITE_DYED);
        emptyVial = new ItemEmptyVial(ItemIDs.EMPTY_VIAL);
        compounds = new ItemCompounds(ItemIDs.COMPOUND);
        boiler = new ItemBoiler(ItemIDs.BOILER_DEFAULT);
        oreChunks = new ItemOreChunks(ItemIDs.ORE_CHUNK);
        osmiumGrate = new ItemOsmiumGrate(ItemIDs.OSMIUM_GRATE);
        cog = new ItemCog(ItemIDs.COG);

        /* Register + Initialize Smelting + Crafting Recipes */

        GameRegistry.addRecipe(new ItemStack(ModItem.osmiumGrate, 4), "WXW", "XXX", "WXW",
                Character.valueOf('W'), Item.ingotIron, Character.valueOf('X'), new ItemStack(
                        ModItem.rawIngot, 1, 3));

        // /////////////////////
        // ALCHEMY RECIPES /////
        // /////////////////////

        GameRegistry.addRecipe(new ItemStack(ModItem.emptyVial, 1), "X X", "X X", " X ",
                Character.valueOf('X'), Block.glass);
        GameRegistry.addRecipe(new ItemStack(ModItem.zeoliteDustVial, 1), "XXX", "XYX", "XXX",
                Character.valueOf('X'), ModItem.zeoliteDust, Character.valueOf('Y'),
                ModItem.emptyVial);
        GameRegistry.addRecipe(new ItemStack(ModItem.zeoliteDust, 8), "X", Character.valueOf('X'),
                ModItem.zeoliteDustVial);

        /* Compound recipes */
        GameRegistry.addRecipe(new ItemStack(ModItem.compounds, 1, 0), "RRR", "RZR", "GGG",
                Character.valueOf('R'), Item.redstone, Character.valueOf('Z'), ModItem.zeoliteDust,
                Character.valueOf('G'), Item.lightStoneDust);
        GameRegistry.addRecipe(new ItemStack(ModItem.compounds, 1, 1), "XXX", "XZX", "GGG",
                Character.valueOf('X'), Item.emerald, Character.valueOf('Z'), ModItem.zeoliteDust,
                Character.valueOf('G'), Item.lightStoneDust);
        GameRegistry.addRecipe(new ItemStack(ModItem.compounds, 1, 2), "YYY", "YZY", "GGG",
                Character.valueOf('Y'), new ItemStack(Item.dyePowder, 1, 11),
                Character.valueOf('Z'), ModItem.zeoliteDust, Character.valueOf('G'),
                Item.lightStoneDust);
        GameRegistry.addRecipe(new ItemStack(ModItem.compounds, 1, 3), "LLL", "LZL", "GGG",
                Character.valueOf('L'), new ItemStack(Item.dyePowder, 1, 4),
                Character.valueOf('Z'), ModItem.zeoliteDust, Character.valueOf('G'),
                Item.lightStoneDust);

        /* Dyed Zeolite dust recipes, Shapeless recipes */
        GameRegistry.addShapelessRecipe(new ItemStack(ModItem.zeoliteDustDyed, 1, 0),
                ModItem.zeoliteDust, new ItemStack(ModItem.compounds, 1, 0));
        GameRegistry.addShapelessRecipe(new ItemStack(ModItem.zeoliteDustDyed, 1, 1),
                ModItem.zeoliteDust, new ItemStack(ModItem.compounds, 1, 1));
        GameRegistry.addShapelessRecipe(new ItemStack(ModItem.zeoliteDustDyed, 1, 2),
                ModItem.zeoliteDust, new ItemStack(ModItem.compounds, 1, 2));
        GameRegistry.addShapelessRecipe(new ItemStack(ModItem.zeoliteDustDyed, 1, 3),
                ModItem.zeoliteDust, new ItemStack(ModItem.compounds, 1, 3));
    }
}