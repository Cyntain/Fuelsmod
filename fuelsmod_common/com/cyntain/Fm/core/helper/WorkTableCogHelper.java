package com.cyntain.Fm.core.helper;

import net.minecraft.item.ItemStack;
import de.paleocrafter.pmfw.recipes.MultiIORecipes;
import de.paleocrafter.pmfw.recipes.data.MultiOutput;


public class WorkTableCogHelper {
    private static MultiIORecipes instance;

    public static MultiIORecipes instance() {
        if (instance == null)
            instance = new MultiIORecipes(9, 2,false);
        return instance;
    }
    
    /**
     * Add recipes to the handler here.
     * 
     *  recipe & outputs
     * */
    public static void initRecipes() {
         
        
        
    }
    
    /**
     * To add the worktable cog recipes to the list
     * @param input1
     * @param input2
     * @param output
     */
    public static void addRecipe(ItemStack input1, ItemStack input2, ItemStack input3, ItemStack input4, ItemStack input5, ItemStack input6, ItemStack input7,
            ItemStack output1, ItemStack output2) {
        instance().addRecipe(new ItemStack[] { input1, input2, input3, input4, input5, input6, input7 }, new ItemStack[] { output1, output2 });
    }

    /**
     * Gets the recipes from the list and output them.
     * 
     * @param input1
     * @param input2
     * @return recipes
     */
    public static MultiOutput getResult(ItemStack input1, ItemStack input2, ItemStack input3, ItemStack input4, ItemStack input5, ItemStack input6, ItemStack input7) {
        return instance().getResult(input1, input2, input3, input4, input5, input6, input7);
    }

    /**
     * Checks if it can use the inputs to get a output.
     * 
     * @param input1
     * @param input2
     * @return
     */
    public static boolean canSmelt(ItemStack input1, ItemStack input2, ItemStack input3, ItemStack input4, ItemStack input5, ItemStack input6, ItemStack input7) {
        return instance().isRecipeValid(input1, input2, input3, input4, input5, input6, input7);
    }
}





