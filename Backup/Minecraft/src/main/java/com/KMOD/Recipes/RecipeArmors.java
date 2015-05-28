package com.KMOD.Recipes;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

import com.KMOD.Core.KCore;

public class RecipeArmors
{
    private String[][] recipePatterns = new String[][] {{"XXX", "X X"}, {"X X", "XXX", "XXX"}, {"XXX", "X X", "X X"}, {"X X", "X X"}};
    private Item[][] recipeItems;

    public RecipeArmors()
    {
        this.recipeItems = new Item[][] 
        {{KCore.Sapphire, KCore.Topaz, KCore.Ruby, KCore.TitaniumIngot, KCore.Crystal, KCore.GravitionalGem, KCore.ForbiddenGem}, 
        {KCore.SapphireHelmet, KCore.TopazHelmet, KCore.RubyHelmet, KCore.TitaniumHelmet, KCore.CrystalHelmet, KCore.GravitionalHelmet, KCore.ForbiddenHelmet}, 
        {KCore.SapphireChestplate, KCore.TopazChestplate, KCore.RubyChestplate, KCore.TitaniumChestplate, KCore.CrystalChestplate, KCore.GravitionalChestplate, KCore.ForbiddenChestplate}, 
        {KCore.SapphireLeggins, KCore.TopazLeggins, KCore.RubyLeggins, KCore.TitaniumLeggins, KCore.CrystalLeggins, KCore.GravitionalLeggins, KCore.ForbiddenLeggins}, 
        {KCore.SapphireBoots, KCore.TopazBoots, KCore.RubyBoots, KCore.TitaniumBoots, KCore.CrystalBoots, KCore.GravitionalBoots, KCore.ForbiddenBoots}};
    }

    public void addRecipes()
    {
        for (int i = 0; i < this.recipeItems[0].length; ++i)
        {
            Item item = this.recipeItems[0][i];

            for (int j = 0; j < this.recipeItems.length - 1; ++j)
            {
                Item item1 = this.recipeItems[j + 1][i];
                GameRegistry.addRecipe(new ItemStack(item1), new Object[] {this.recipePatterns[j], 'X', item});
            }
        }
    }
}