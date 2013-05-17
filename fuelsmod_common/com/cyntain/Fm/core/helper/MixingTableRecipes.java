package com.cyntain.Fm.core.helper;

import java.util.HashMap;
import java.util.Map;

import com.cyntain.Fm.item.ModItem;

import net.minecraft.item.ItemStack;


public class MixingTableRecipes {

    private static final Map<Recipe, ItemStack> recipes = new HashMap<Recipe, ItemStack>();

    public static class Recipe {

        final ItemStack one, two;

        Recipe(ItemStack one, ItemStack two) {

            this.one = one;
            this.two = two;
        }

        @Override
        public int hashCode() {

            return 0;
        }

        @Override
        public boolean equals(Object obj) {

            if (!(obj instanceof Recipe))
                return false; 

            Recipe other = (Recipe) obj;

            return compareRecipes(other.one, other.two) || compareRecipes(other.two, other.one);
        }

        boolean compareRecipes(ItemStack one, ItemStack two) {

            if (one.isItemEqual(this.one) || two.isItemEqual(this.two)) {
                return true;
            }
            return false;
        }
    }

    public static void initRecipes() {

        addRecipe(new ItemStack(ModItem.compounds, 1, 0), new ItemStack(ModItem.compounds, 1, 2),
                new ItemStack(ModItem.zeoliteDustDyed, 1, 0));

        addRecipe(new ItemStack(ModItem.compounds, 1, 3), new ItemStack(ModItem.compounds, 1, 1),
                new ItemStack(ModItem.zeoliteDustDyed, 1, 1));

        addRecipe(new ItemStack(ModItem.compounds, 1, 2), new ItemStack(ModItem.compounds, 1, 3),
                new ItemStack(ModItem.zeoliteDustDyed, 1, 2));

        addRecipe(new ItemStack(ModItem.compounds, 1, 1), new ItemStack(ModItem.compounds, 1, 0),
                new ItemStack(ModItem.zeoliteDustDyed, 1, 3));

    }

    public static void addRecipe(ItemStack input1, ItemStack input2, ItemStack output) { 


        recipes.put(new Recipe(input1, input2), output);
    }

    public static ItemStack getResult(ItemStack input1, ItemStack input2) {

        return recipes.get(new Recipe(input1, input2));
    }

    public static boolean canSmelt(ItemStack input1, ItemStack input2) {

        return getResult(input1, input2) != null;
    }
}
