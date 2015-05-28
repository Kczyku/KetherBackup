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
import com.KMOD.Entities.EntityFireElemental;
import com.KMOD.Particle.GildedSandParticle;

public class FireElementalSpawner extends BaseBlock
{


    public FireElementalSpawner(String name, float Hardness, float Resistance)
    {
    	super(name, Hardness, Resistance);
        this.setCreativeTab(KCore.OHTab);
        setHardness(Hardness);
        setResistance(Resistance);
        setStepSound(Block.soundTypePiston);
        this.setTickRandomly(false);
        
    }

    
    public Item getItemDropped(IBlockState state, Random rand, int fortune)
    {
    		return null;
    }
    
    public int quantityDropped(Random random)
    {
    	return 0;
    }
    
    public void onBlockDestroyedByPlayer(World worldIn, BlockPos pos, IBlockState state)
    {
    	EntityFireElemental efe = new EntityFireElemental(worldIn);
    	efe.setLocationAndAngles(pos.getX(), pos.getY(), pos.getZ(), 0, 0);
    	if(!worldIn.isRemote)
    	{
    		worldIn.spawnEntityInWorld(efe);
    	}    	efe.setLocationAndAngles(pos.getX(), pos.getY(), pos.getZ(), 0, 0);
    	worldIn.setBlockToAir(pos);
    }

}
