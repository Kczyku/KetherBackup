package com.KMOD.Blocks;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.client.FMLClientHandler;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import com.KMOD.Core.KCore;
import com.KMOD.Particle.GildedSandParticle;

public class BlockGildedSand extends BaseBlock
{


    public BlockGildedSand(String name, float Hardness, float Resistance)
    {
    	super(name, Hardness, Resistance);
        this.setCreativeTab(KCore.OHTab);
        setHardness(Hardness);
        setResistance(Resistance);
        setStepSound(Block.soundTypeSand);
        this.setTickRandomly(false);
        
    }
    
    
    @SideOnly(Side.CLIENT)
    public void randomDisplayTick(World world, BlockPos pos, IBlockState state, Random rand)
    {
    }


    
    public Item getItemDropped(IBlockState state, Random rand, int fortune)
    {
    		return Item.getItemFromBlock(this);
    }
    
    public int quantityDropped(Random random)
    {
    	return 1;
    }
    
    
}
