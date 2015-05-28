package com.KMOD.Items;

import java.util.Set;

import net.minecraft.block.Block;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;

import com.KMOD.Core.KCore;
import com.KMOD.Entities.EntityFloatingBlock;
import com.google.common.collect.Sets;

public class ItemMOShovel extends ItemMOTool
{
    static Set EFFECTIVE_ON1 = Sets.newHashSet(new Block[] {Blocks.clay, Blocks.dirt, Blocks.farmland, 
    Blocks.grass, Blocks.gravel, Blocks.mycelium, Blocks.sand, Blocks.snow, Blocks.snow_layer, Blocks.soul_sand, KCore.HeavenlyDirt,
    KCore.HeavenlyGrass, KCore.GildedSand});

    public ItemMOShovel(String Name, ToolMaterial material)
    {
        super(Name, 1.0F, material, EFFECTIVE_ON1);
    }

    public boolean canHarvestBlock(Block blockIn)
    {
    	
        return blockIn == Blocks.snow_layer ? true : blockIn == Blocks.snow;
    }
    
    public boolean onBlockDestroyed(ItemStack stack, World worldIn, Block blockIn, BlockPos pos, EntityLivingBase playerIn)
    {
    	super.onBlockDestroyed(stack, worldIn, blockIn, pos, playerIn);
    	
    	if(this == KCore.GravitionalShovel)
    	{
    		EntityFloatingBlock efb = new EntityFloatingBlock(worldIn, pos.getX() + 0.5, pos.getY(), pos.getZ() + 0.5, blockIn.getDefaultState(), false, playerIn);
    		playerIn.worldObj.spawnEntityInWorld(efb);
    	}
    	
        return true;
    }
    
}