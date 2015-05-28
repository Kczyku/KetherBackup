package com.KMOD.Blocks;

import com.KMOD.Core.KCore;

import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.BlockPos;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

public class BlockForbiddenTrap extends BaseBlock
{

	public BlockForbiddenTrap(String name, float Hardness, float Resistance) 
	{
		super(name, Hardness, Resistance);
		this.setTickRandomly(true);
	}
    public void onEntityCollidedWithBlock(World worldIn, BlockPos pos, IBlockState state, Entity entity)
    {	
    	if(entity instanceof EntityPlayer)
    	{
    		EntityPlayer ep = (EntityPlayer) entity;
     	   ep.addPotionEffect(new PotionEffect(Potion.confusion.id, 250, 3));
           ep.attackEntityFrom(DamageSource.cactus, 10.0F);
           
           worldIn.setBlockState(pos, KCore.ForbiddenBrick.getDefaultState());

    	}
    }
}
