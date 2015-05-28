package com.KMOD.Recipes;

import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

import com.KMOD.Core.KCore;

public class RecipeMOTools
{
    private String[][] recipePatterns = new String[][] {{"XXX", " # ", " # "}, {"X", "#", "#"}, {"XX", "X#", " #"}, {"XX", " #", " #"}};
    private Object[][] recipeItems;

    public RecipeMOTools()
    {
        this.recipeItems = new Object[][] {{KCore.Sapphire, KCore.Topaz, KCore.Ruby, KCore.TitaniumIngot}, 
        {KCore.SapphirePickaxe, KCore.TopazPickaxe, KCore.RubyPickaxe, KCore.TitaniumPickaxe}, 
        {KCore.SapphireShovel, KCore.TopazShovel, KCore.RubyShovel, KCore.TitaniumShovel}, 
        {KCore.SapphireAxe, KCore.TopazAxe, KCore.RubyAxe, KCore.TitaniumAxe}, 
        {KCore.SapphireHoe, KCore.TopazHoe, KCore.RubyHoe, KCore.TitaniumHoe}};
    }

    public void addRecipes()
    {
        for (int i = 0; i < this.recipeItems[0].length; ++i)
        {
            Object object = this.recipeItems[0][i];

            for (int j = 0; j < this.recipeItems.length - 1; ++j)
            {
                Item item = (Item)this.recipeItems[j + 1][i];
                GameRegistry.addRecipe(new ItemStack(item), new Object[] {this.recipePatterns[j], '#', Items.stick, 'X', object});
            }
        }

    }
}