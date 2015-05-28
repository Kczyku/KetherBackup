package com.KMOD.Recipes;

import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

import com.KMOD.Core.KCore;

public class RecipeGemBlocks
{
    private Object[][] recipeItems;

    public RecipeGemBlocks()
    {
        this.recipeItems = new Object[][] {{KCore.SapphireBlock, new ItemStack(KCore.Sapphire, 9)}, 
        {KCore.TopazBlock, new ItemStack(KCore.Topaz, 9)}, {KCore.RubyBlock, new ItemStack(KCore.Ruby, 9)}, 
        {KCore.TitaniumBlock, new ItemStack(KCore.TitaniumIngot, 9)}, {KCore.GravitionalBlock, new ItemStack(KCore.GravitionalGem, 9)}};
    }

    public void addRecipes()
    {
        for (int i = 0; i < this.recipeItems.length; ++i)
        {
            Block block = (Block)this.recipeItems[i][0];
            ItemStack itemstack = (ItemStack)this.recipeItems[i][1];
            GameRegistry.addRecipe(new ItemStack(block), new Object[] {"###", "###", "###", '#', itemstack});
            GameRegistry.addRecipe(itemstack, new Object[] {"#", '#', block});
        }
    }
}