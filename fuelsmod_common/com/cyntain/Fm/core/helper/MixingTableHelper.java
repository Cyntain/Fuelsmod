package com.cyntain.Fm.core.helper;

import com.cyntain.Fm.item.ModItem;
import com.cyntain.Fm.multiio.MultiInputRecipes;

import net.minecraft.item.ItemStack;

public class MixingTableHelper {

    private static MultiInputRecipes instance;

    public static MultiInputRecipes instance() {
        if (instance == null)
            instance = new MultiInputRecipes(2, true);
        return instance;
    }

    public static void initRecipes() {
        // redscar + yellowale = reden
        addRecipe(new ItemStack(ModItem.compounds, 1, 0), new ItemStack(
                ModItem.compounds, 1, 2), new ItemStack(
                ModItem.zeoliteDustDyed, 1, 0));
        // greenite + yellowale = greue
        addRecipe(new ItemStack(ModItem.compounds, 1, 1), new ItemStack(
                ModItem.compounds, 1, 2), new ItemStack(
                ModItem.zeoliteDustDyed, 1, 1));

        // bluetomium + greenite = Yellen
        addRecipe(new ItemStack(ModItem.compounds, 1, 3), new ItemStack(
                ModItem.compounds, 1, 1), new ItemStack(
                ModItem.zeoliteDustDyed, 1, 2));

        // yellowale + bluetomium = lueel
        addRecipe(new ItemStack(ModItem.compounds, 1, 2), new ItemStack(
                ModItem.compounds, 1, 3), new ItemStack(
                ModItem.zeoliteDustDyed, 1, 3));

    }

    /**
     * To add the mixingTable recipes to the list
     * 
     * @param input1
     * @param input2
     * @param output
     */
    public static void addRecipe(ItemStack input1, ItemStack input2,
            ItemStack output) {
        instance().addRecipe(new ItemStack[] {input1, input2}, output);
    }

    /**
     * Gets the recipes from the list and output them.
     * 
     * @param input1
     * @param input2
     * @return recipes
     */
    public static ItemStack getResult(ItemStack input1, ItemStack input2) {
        return instance().getResult(input1, input2);
    }

    /**
     * Checks if it can use the inputs to get a output.
     * 
     * @param input1
     * @param input2
     * @return
     */
    public static boolean canSmelt(ItemStack input1, ItemStack input2) {
        return instance().isRecipeValid(input1, input2);
    }
}
