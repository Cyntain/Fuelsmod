package com.cyntain.Fm.core.helper;

import java.util.ArrayList;
import java.util.HashMap;

import com.cyntain.Fm.Item.ModItem;

import net.minecraft.item.ItemStack;
/*  @Credit Paleocrafter, for writing this work of art! */

public class MixingTableRecipes {
    public HashMap<ArrayList<ItemStack[]>, ItemStack> recipes;
    private static MixingTableRecipes instance;
 
    private MixingTableRecipes() {
        recipes = new HashMap<ArrayList<ItemStack[]>, ItemStack>();
        
        addRecipe(new ItemStack(ModItem.compounds, 1, 0), new ItemStack(ModItem.compounds, 1, 2), new ItemStack(ModItem.zeoliteDustDyed, 1, 0));
        addRecipe(new ItemStack(ModItem.compounds, 1, 2), new ItemStack(ModItem.compounds, 1, 0), new ItemStack(ModItem.zeoliteDustDyed, 1, 0));
        
        addRecipe(new ItemStack(ModItem.compounds, 1, 3), new ItemStack(ModItem.compounds, 1, 1), new ItemStack(ModItem.zeoliteDustDyed, 1, 1));
        addRecipe(new ItemStack(ModItem.compounds, 1, 1), new ItemStack(ModItem.compounds, 1, 3), new ItemStack(ModItem.zeoliteDustDyed, 1, 1));
        
        addRecipe(new ItemStack(ModItem.compounds, 1, 2), new ItemStack(ModItem.compounds, 1, 3), new ItemStack(ModItem.zeoliteDustDyed, 1, 2));
        addRecipe(new ItemStack(ModItem.compounds, 1, 3), new ItemStack(ModItem.compounds, 1, 2), new ItemStack(ModItem.zeoliteDustDyed, 1, 2));
        
        addRecipe(new ItemStack(ModItem.compounds, 1, 1), new ItemStack(ModItem.compounds, 1, 0), new ItemStack(ModItem.zeoliteDustDyed, 1, 3));
        addRecipe(new ItemStack(ModItem.compounds, 1, 0), new ItemStack(ModItem.compounds, 1, 1), new ItemStack(ModItem.zeoliteDustDyed, 1, 3));
    }
 
    public static MixingTableRecipes instance() {
        if (instance == null)
            instance = new MixingTableRecipes();
        return instance;
    }
 
    public static void addMapping(ItemStack input1, ItemStack input2,
            ItemStack output) {
        ArrayList<ItemStack[]> inputs = new ArrayList<ItemStack[]>();
        inputs.add(new ItemStack[] { input1, input2 });
        inputs.add(new ItemStack[] { input2, input1 });
        instance().recipes.put(inputs, output);
    }
 
    /**
     *
     * Adds a recipe to the Forge. Returns true if it overrides an existing one.
     *
     * @param input
     *            The ItemStack that get's processed
     * @param output
     *            The ItemStack resulting after processing
     * @return true, if it has overridden an existing recipe, otherwise false
     */
    public static boolean addRecipe(ItemStack input1, ItemStack input2,
            ItemStack output) {
        boolean returnValue = false;
        ArrayList<ItemStack[]> inputs = new ArrayList<ItemStack[]>();
        inputs.add(new ItemStack[] { input1, input2 });
        inputs.add(new ItemStack[] { input2, input1 });
        if (instance().recipes.containsKey(inputs))
            returnValue = true;
        instance().recipes.put(inputs, output);
        return returnValue;
    }
 
    /**
     * 
     * Get's the result for an given input.
     * 
     * @param input
     *            The ItemStack to get the result for
     * @return the resulting ItemStack for the given input, null if the recipe
     *         doesn't exist
     */
    public static ItemStack getResult(ItemStack input1, ItemStack input2) {
        ArrayList<ItemStack[]> inputs = new ArrayList<ItemStack[]>();
        inputs.add(new ItemStack[] { input1, input2 });
        inputs.add(new ItemStack[] { input2, input1 });
        if (instance().recipes.containsKey(inputs)) {
            return instance().recipes.get(inputs);
        }
        return null;
    }
 
    /**
     *
     * Checks the given input ItemStack for a result.
     *
     * @param input
     *            The input ItemStack to check
     * @return true if the input can be processed
     */
    public static boolean canSmelt(ItemStack input1, ItemStack input2) {
        if (getResult(input1, input2) != null)
            return true;
        return false;
    }

}
