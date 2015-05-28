package com.KMOD.Blocks;

import java.util.Random;

import com.KMOD.Core.KCore;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumWorldBlockLayer;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockHeavenlyBush extends BaseBlock implements net.minecraftforge.common.IPlantable
{

    protected BlockHeavenlyBush(String Name, Material materialIn)
    {
        super(Name, 0F, 0F);
        this.setMaterial(materialIn);
        float f = 0.2F;
        this.setBlockBounds(0.5F - f, 0.0F, 0.5F - f, 0.5F + f, f * 3.0F, 0.5F + f);
        this.setCreativeTab(KCore.OHTab);
    }


    public boolean canPlaceBlockAt(World worldIn, BlockPos pos)
    {
    	return this.canPlaceBlockOn(worldIn.getBlockState(new BlockPos(pos.getX(), pos.getY() - 1, pos.getZ())).getBlock());
    }

    public boolean canPlaceBlockOn(Block ground)
    {
    	if(this == KCore.PoisonousCactus)
    	{
    		return ground == Blocks.grass || ground == Blocks.dirt || ground == Blocks.farmland || ground == KCore.HeavenlyGrass|| ground == KCore.HeavenlyDirt || ground == KCore.GildedSand || ground == KCore.PoisonousCactus;
    	}
    	else
    	{
    		return ground == Blocks.grass || ground == Blocks.dirt || ground == Blocks.farmland || ground == KCore.HeavenlyGrass|| ground == KCore.HeavenlyDirt || ground == KCore.GildedSand;
    	}
    }

    public void onNeighborBlockChange(World worldIn, BlockPos pos, IBlockState state, Block neighborBlock)
    {
        super.onNeighborBlockChange(worldIn, pos, state, neighborBlock);
        this.checkAndDropBlock(worldIn, pos, state);
    }

    public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand)
    {
        this.checkAndDropBlock(worldIn, pos, state);
    }

    protected void checkAndDropBlock(World worldIn, BlockPos pos, IBlockState state)
    {
        if (!this.canBlockStay(worldIn, pos, state))
        {
            this.dropBlockAsItem(worldIn, pos, state, 0);
            worldIn.setBlockState(pos, Blocks.air.getDefaultState(), 3);
        }
    }

    public boolean canBlockStay(World worldIn, BlockPos pos, IBlockState state)
    {
        return this.canPlaceBlockOn(worldIn.getBlockState(pos.down()).getBlock());
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

    @SideOnly(Side.CLIENT)
    public EnumWorldBlockLayer getBlockLayer()
    {
        return EnumWorldBlockLayer.CUTOUT;
    }

    @Override
    public net.minecraftforge.common.EnumPlantType getPlantType(net.minecraft.world.IBlockAccess world, BlockPos pos)
    {
        return null;
    }

    @Override
    public IBlockState getPlant(net.minecraft.world.IBlockAccess world, BlockPos pos)
    {
        IBlockState state = world.getBlockState(pos);
        if (state.getBlock() != this) return getDefaultState();
        return state;
    }
}
