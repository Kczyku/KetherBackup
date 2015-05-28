package com.KMOD.Blocks;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.util.BlockPos;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import com.KMOD.Core.KCore;

public class BlockBaseOre extends BaseBlock
{
	private String Name;
	private int minExp, maxExp;
	
    public BlockBaseOre(String name, float Hardness, float Resistance, int minExp1, int maxExp1)
    {
        super(name, Hardness, Resistance);
        this.setCreativeTab(KCore.OHTab);
        setHardness(Hardness);
        setResistance(Resistance);
        setStepSound(Block.soundTypeStone);
        this.Name = name;     
        this.minExp = minExp1;
        this.maxExp = maxExp1;
    }
    
   
    

    public Item getItemDropped(IBlockState state, Random rand, int fortune)
    {
    	if(this == KCore.RubyOre)
    	{
    		return KCore.Ruby;
    	}
    	else if(this == KCore.SapphireOre)
    	{
    		return KCore.Sapphire;
    	}
    	else if(this == KCore.TopazOre)
    	{
    		return KCore.Topaz;
    	}
    	else if(this == KCore.TitaniumOre)
    	{
    		return Item.getItemFromBlock(KCore.TitaniumOre);
    	}
    	else if(this == KCore.CrystalOre)
    	{
    		return KCore.Crystal;
    	}
    	else
    	{
    		return Items.coal;
    	}
    }
    
    
    @Override
    public int getExpDrop(IBlockAccess world, BlockPos pos, int fortune)
    {
        IBlockState state = world.getBlockState(pos);
        Random rand = world instanceof World ? ((World)world).rand : new Random();
        if (this.getItemDropped(state, rand, fortune) != Item.getItemFromBlock(this))
        {                
            return MathHelper.getRandomIntegerInRange(rand, minExp, maxExp);
        }
        return 0;
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