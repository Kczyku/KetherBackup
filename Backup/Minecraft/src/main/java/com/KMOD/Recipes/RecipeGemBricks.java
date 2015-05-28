package com.KMOD.Recipes;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

import com.KMOD.Core.KCore;

public class RecipeGemBricks
{
    private Object[][] recipeItems;

    public RecipeGemBricks()
    {
        this.recipeItems = new Object[][] {{KCore.SapphireBrick, new ItemStack(KCore.Sapphire, 3)}, 
        {KCore.TopazBrick, new ItemStack(KCore.Topaz, 3)}, {KCore.RubyBrick, new ItemStack(KCore.Ruby, 3)},
        {KCore.TitaniumBrick, new ItemStack(KCore.TitaniumIngot, 3)}, {KCore.GravitionalBrick, new ItemStack(KCore.GravitionalGem, 3)}};
    }

    public void addRecipes()
    {
        for (int i = 0; i < this.recipeItems.length; ++i)
        {
            Block block = (Block)this.recipeItems[i][0];
            ItemStack itemstack = (ItemStack)this.recipeItems[i][1];
            GameRegistry.addRecipe(new ItemStack(block), new Object[] {"XXX", "###", "XXX", '#', itemstack, 'X', Blocks.brick_block});
            GameRegistry.addRecipe(itemstack, new Object[] {"#", '#', block});
        }
    }
}