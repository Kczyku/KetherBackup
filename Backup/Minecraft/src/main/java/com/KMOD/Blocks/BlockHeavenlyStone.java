package com.KMOD.Blocks;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.util.BlockPos;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import com.KMOD.Core.KCore;

public class BlockHeavenlyStone extends BaseBlock
{
	private String Name;
	
    public BlockHeavenlyStone(String name)
    {
        super(name, 2F, 15F);
        this.setCreativeTab(KCore.OHTab);
        setStepSound(Block.soundTypeStone);
        this.Name = name;     
    }
    
   
    

    public Item getItemDropped(IBlockState state, Random rand, int fortune)
    {
    		return Item.getItemFromBlock(KCore.HeavenlyCobblestone);
    }
    
    
    
    public int quantityDropped(Random random)
    {
    	return 1;
    }
    
    public String getName()
    {
    	return this.Name;
    }
    
}