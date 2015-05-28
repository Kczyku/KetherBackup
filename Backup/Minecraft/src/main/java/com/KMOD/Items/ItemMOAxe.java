package com.KMOD.Items;

import java.util.Set;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;

import com.KMOD.Core.KCore;
import com.KMOD.Entities.EntityFloatingBlock;
import com.google.common.collect.Sets;

public class ItemMOAxe extends ItemMOTool
{
    private static final Set EFFECTIVE_ON = Sets.newHashSet(new Block[] {Blocks.planks, Blocks.bookshelf, Blocks.log, Blocks.log2, 
    Blocks.chest, Blocks.pumpkin, Blocks.lit_pumpkin, Blocks.melon_block, Blocks.ladder, KCore.HeavenlyLog, KCore.HeavenlyPlanks,
    KCore.RottenLog});

    public ItemMOAxe(String Name, ToolMaterial material)
    {
        super(Name, 3.0F, material, EFFECTIVE_ON);
    }

    public float getStrVsBlock(ItemStack stack, Block block)
    {
        return block.getMaterial() != Material.wood && block.getMaterial() != Material.plants && block.getMaterial() != Material.vine ? super.getStrVsBlock(stack, block) : this.efficiencyOnProperMaterial;
    }
    
    public boolean onBlockDestroyed(ItemStack stack, World worldIn, Block blockIn, BlockPos pos, EntityLivingBase playerIn)
    {
    	super.onBlockDestroyed(stack, worldIn, blockIn, pos, playerIn);
    	
    	if(this == KCore.GravitionalAxe)
    	{
    		EntityFloatingBlock efb = new EntityFloatingBlock(worldIn, pos.getX() + 0.5, pos.getY(), pos.getZ() + 0.5, blockIn.getDefaultState(), true, playerIn);
    		playerIn.worldObj.spawnEntityInWorld(efb);
    	}
    	
        return true;
    }
}