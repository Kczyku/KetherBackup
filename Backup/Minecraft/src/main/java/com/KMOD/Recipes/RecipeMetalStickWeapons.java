package com.KMOD.Recipes;

import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

import com.KMOD.Core.KCore;

public class RecipeMetalStickWeapons
{
    private String[][] recipePatterns = new String[][] {{"X", "X", "#"}};
    private Object[][] recipeItems;

    public RecipeMetalStickWeapons()
    {
        this.recipeItems = new Object[][] {{KCore.Crystal, KCore.GravitionalGem, KCore.ForbiddenGem}, 
        		{KCore.CrystalSword, KCore.GravitionalSword, KCore.ForbiddenSword}};
    }

    public void addRecipes()
    {
        for (int i = 0; i < this.recipeItems[0].length; ++i)
        {
            Object object = this.recipeItems[0][i];

            for (int j = 0; j < this.recipeItems.length - 1; ++j)
            {
                Item item = (Item)this.recipeItems[j + 1][i];
                GameRegistry.addRecipe(new ItemStack(item), new Object[] {this.recipePatterns[j], '#', KCore.TitaniumIngot, 'X', object});
            }
        }
    }
}