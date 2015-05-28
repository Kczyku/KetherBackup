package com.KMOD.Items;

import net.minecraft.block.Block;
import net.minecraft.block.BlockLiquid;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import com.KMOD.Blocks.BlockHeavenlyBush;
import com.KMOD.Core.KCore;

public class ItemMOSeedFood extends ItemHeavenlyFood implements net.minecraftforge.common.IPlantable
{
    private Block crops;
    private Block soilId;

    public ItemMOSeedFood(String Name, int healAmount, float saturation, Block crops, Block soil)
    {
        super(Name, healAmount, saturation, false);
        this.crops = crops;
        this.soilId = soil;
        this.setCreativeTab(KCore.OHTab);
    }
    
    
    public boolean canSustainPlant(IBlockAccess world, BlockPos pos, EnumFacing direction, net.minecraftforge.common.IPlantable plantable)
    {
    	return true;
    }

    public boolean onItemUse(ItemStack stack, EntityPlayer playerIn, World worldIn, BlockPos pos, EnumFacing side, float hitX, float hitY, float hitZ)
    {
    	if(this == KCore.FrostyPeanut || this == KCore.CandyCotton)
    	{
	        if (side != EnumFacing.UP)
	        {
	            return false;
	        }
	        else if (!playerIn.canPlayerEdit(pos.offset(side), side, stack))
	        {
	            return false;
	        }
	        else if (worldIn.getBlockState(pos).getBlock() == KCore.HeavenlyCloud && worldIn.isAirBlock(pos.up()))
	        {
	            worldIn.setBlockState(pos.up(), this.crops.getDefaultState());
	            --stack.stackSize;
	            return true;
	        }
	        else
	        {
	            return false;
	        }
    	}
    	else
    	{
    		return false;
    	}
    }

    @Override
    public net.minecraftforge.common.EnumPlantType getPlantType(net.minecraft.world.IBlockAccess world, BlockPos pos)
    {
        return net.minecraftforge.common.EnumPlantType.Crop;
    }

    @Override
    public net.minecraft.block.state.IBlockState getPlant(net.minecraft.world.IBlockAccess world, BlockPos pos)
    {
        return this.crops.getDefaultState();
    }
}