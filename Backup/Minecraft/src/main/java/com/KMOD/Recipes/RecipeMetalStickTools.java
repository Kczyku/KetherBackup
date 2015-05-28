package com.KMOD.Recipes;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

import com.KMOD.Core.KCore;

public class RecipeMetalStickTools
{
    private String[][] recipePatterns = new String[][] {{"XXX", " # ", " # "}, {"X", "#", "#"}, {"XX", "X#", " #"}, {"XX", " #", " #"}};
    private Object[][] recipeItems;

    public RecipeMetalStickTools()
    {
        this.recipeItems = new Object[][] {{KCore.Crystal, KCore.GravitionalGem, KCore.ForbiddenGem},
        		{KCore.CrystalPickaxe, KCore.GravitionalPickaxe, KCore.ForbiddenPickaxe},
        		{KCore.CrystalShovel, KCore.GravitionalShovel, KCore.ForbiddenShovel}, 
        		{KCore.CrystalAxe, KCore.GravitionalAxe, KCore.ForbiddenAxe}, 
        		{KCore.CrystalHoe, KCore.GravitionalHoe, KCore.ForbiddenHoe}
        };
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
        GameRegistry.addRecipe(new ItemStack(KCore.ThorsPickaxe), "XXX", " Y ", " Y ", Character.valueOf('X'), KCore.ThorsMetalPiece, Character.valueOf('Y'), KCore.TitaniumIngot);

    }
}