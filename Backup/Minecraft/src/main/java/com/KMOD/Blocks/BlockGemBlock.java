package com.KMOD.Blocks;

import java.util.Random;

import com.KMOD.Core.KCore;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class BlockGemBlock extends BaseBlock
{
	private String Name;
	private static Material material = Material.rock;
	
    public BlockGemBlock(String name, float Hardness, float Resistance)
    {
        super(name, Hardness, Resistance);
        this.setCreativeTab(KCore.OHTab);
        setHardness(Hardness);
        setResistance(Resistance);
        setStepSound(Block.soundTypeStone);
        this.Name = name;     
    }
    
    public Item getItemDropped(IBlockState state, Random rand, int fortune)
    {
    		return Item.getItemFromBlock(this);
    }
    
    public String getName()
    {
    	return this.Name;
    }
}
