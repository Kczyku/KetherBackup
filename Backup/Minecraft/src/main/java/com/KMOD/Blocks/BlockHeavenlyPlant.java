package com.KMOD.Blocks;

import java.util.ArrayList;
import java.util.Random;

import com.KMOD.Core.KCore;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumWorldBlockLayer;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockHeavenlyPlant extends BlockHeavenlyBush
{	
	public BlockHeavenlyPlant(String Name, float LightValue)
	{
		super(Name, Material.plants);
		this.setStepSound(soundTypeGrass);
        this.setCreativeTab(KCore.OHTab);
        if(LightValue > 0)
        {
        	this.setLightLevel(LightValue);
        }
	}
	
    
    
    
    public AxisAlignedBB getCollisionBoundingBox(World worldIn, BlockPos pos, IBlockState state)
    {
        return null;
    }

    public boolean isOpaqueCube()
    {
        return false;
    }

    public boolean isFullCube()
    {
        return false;
    }
    
    public Item getItemDropped(IBlockState state, Random rand, int fortune)
    {
    	if(this == KCore.RottenBush)
    	{
    		return KCore.MagicFruit;
    	}
    	else
    	{
    		return Item.getItemFromBlock(this);
    	}
    	
    }

    @SideOnly(Side.CLIENT)
    public EnumWorldBlockLayer getBlockLayer()
    {
        return EnumWorldBlockLayer.CUTOUT;
    }

}
