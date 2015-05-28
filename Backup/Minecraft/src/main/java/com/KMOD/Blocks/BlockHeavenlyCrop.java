package com.KMOD.Blocks;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;

import com.KMOD.Core.KCore;

public class BlockHeavenlyCrop extends BlockMOCrop
{

	private Block BlockToPlantOn;
	private Item Seed;
	private Item ParentCrop;
	private Block Crop;
	
    public BlockHeavenlyCrop(String Name, Block BlockToP, Item Sed, Item ParentC, Block Crop) 
    {
		super(Name, Crop, Sed);
		this.BlockToPlantOn = BlockToP;
		this.Seed = Sed;
		this.ParentCrop = ParentC;
        this.setCreativeTab(null);
	}
    
    private int Statej;

    public Item getItemDropped(IBlockState state, Random rand, int fortune)
    {
    	int age = (Integer)state.getValue(AGE);
    	Statej = age;
    	if(this == KCore.FrostyPeanuts)
    	{
    		return KCore.FrostyPeanut;
    	}
    	else if(this == KCore.CandyCottonPlant)
    	{
    		return KCore.CandyCotton;
    	}
    	else
    	{
    		return KCore.BitOfLuck;
    	}
    }
    
    public int quantityDropped(Random random)
    {

    	if(Statej == 7)
    	{
    		int j = random.nextInt(4);
    		if(j == 0)
    		{
    			j = 1;
    		}
    		return j;
    	}
    	else
    	{
    		return 1;
    	}
    }
    
    public boolean canPlaceBlockOn(Block ground)
    {
        return ground == BlockToPlantOn;
    }

	protected Item getSeed()
    {
        return Seed;
    }

    protected Item getCrop()
    {
        return ParentCrop;
    }
}