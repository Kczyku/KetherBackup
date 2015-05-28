package com.KMOD.Blocks;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumWorldBlockLayer;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import com.KMOD.Core.KCore;

public class BlockPoisonousCactus extends BlockHeavenlyBush implements net.minecraftforge.common.IPlantable
{

    public BlockPoisonousCactus(String Name)
    {
        super(Name, Material.cactus);
        this.setTickRandomly(true);
        this.setCreativeTab(CreativeTabs.tabDecorations);
        this.setMaterial(Material.cactus);
    }
    int counter = 0;
    public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand)
    {
    	counter++;
        BlockPos blockpos1 = pos.up();

        if(worldIn.isAirBlock(blockpos1))
        {
        	if(counter >= 10000)
        	{
        		counter = 0;
        		worldIn.setBlockState(blockpos1, KCore.PoisonousCactus.getDefaultState());
        	}
        }
    }

    public AxisAlignedBB getCollisionBoundingBox(World worldIn, BlockPos pos, IBlockState state)
    {
        float f = 0.0625F;
        return new AxisAlignedBB((double)((float)pos.getX() + f), (double)pos.getY(), (double)((float)pos.getZ() + f), (double)((float)(pos.getX() + 1) - f), (double)((float)(pos.getY() + 1) - f), (double)((float)(pos.getZ() + 1) - f));
    }

    @SideOnly(Side.CLIENT)
    public AxisAlignedBB getSelectedBoundingBox(World worldIn, BlockPos pos)
    {
        float f = 0.0625F;
        return new AxisAlignedBB((double)((float)pos.getX() + f), (double)pos.getY(), (double)((float)pos.getZ() + f), (double)((float)(pos.getX() + 1) - f), (double)(pos.getY() + 1), (double)((float)(pos.getZ() + 1) - f));
    }

    public boolean isFullCube()
    {
        return false;
    }

    public boolean isOpaqueCube()
    {
        return false;
    }

    public boolean canPlaceBlockAt(World worldIn, BlockPos pos)
    {
        return super.canPlaceBlockAt(worldIn, pos) ? this.canBlockStay(worldIn, pos) : false;
    }

    /**
     * Called when a neighboring block changes.
     */
    public void onNeighborBlockChange(World worldIn, BlockPos pos, IBlockState state, Block neighborBlock)
    {
        if (!this.canBlockStay(worldIn, pos))
        {
            worldIn.destroyBlock(pos, true);
        }
    }

    public boolean canBlockStay(World worldIn, BlockPos pos)
    {
    	if(worldIn.isAirBlock(pos.up()))
    	{
    		if(worldIn.isAirBlock(pos.east()))
    		{
    			if(worldIn.isAirBlock(pos.west()))
    			{
    				if(worldIn.isAirBlock(pos.south()))
    				{
    					if(worldIn.isAirBlock(pos.north()))
    					{
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
    	else
    	{
    		return false;
    	}
    }

    /**
     * Called When an Entity Collided with the Block
     */
    public void onEntityCollidedWithBlock(World worldIn, BlockPos pos, IBlockState state, Entity entityIn)
    {
        entityIn.attackEntityFrom(DamageSource.cactus, 1.0F);
       if(entityIn instanceof EntityPlayer)
       {
    	   EntityPlayer ep = (EntityPlayer) entityIn;
    	   ep.addPotionEffect(new PotionEffect(Potion.confusion.id, 250, 3));
    	   ep.addPotionEffect(new PotionEffect(Potion.poison.id, 250, 3));

       }
    }

    @SideOnly(Side.CLIENT)
    public EnumWorldBlockLayer getBlockLayer()
    {
        return EnumWorldBlockLayer.CUTOUT;
    }

    @Override
    public net.minecraftforge.common.EnumPlantType getPlantType(net.minecraft.world.IBlockAccess world, BlockPos pos)
    {
        return net.minecraftforge.common.EnumPlantType.Desert;
    }

    @Override
    public IBlockState getPlant(net.minecraft.world.IBlockAccess world, BlockPos pos)
    {
        return getDefaultState();
    }
}