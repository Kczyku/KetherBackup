package com.KMOD.HeavenGens;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockTallGrass;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

import com.KMOD.Blocks.BlockHeavenlyBush;
import com.KMOD.Core.KCore;

public class GenTallGrass extends WorldGenerator
{
    private final BlockHeavenlyBush Grass;

    public GenTallGrass(BlockHeavenlyBush Grass)
    {
        this.Grass = Grass;
    }

    public boolean generate(World worldIn, Random p_180709_2_, BlockPos p_180709_3_)
    {
        Block block;

        do
        {
            block = worldIn.getBlockState(p_180709_3_).getBlock();
            if (!block.isAir(worldIn, p_180709_3_) && !block.isLeaves(worldIn, p_180709_3_)) break;
            p_180709_3_ = p_180709_3_.down();
        } while (p_180709_3_.getY() > 0);

        for (int i = 0; i < 128; ++i)
        {
            BlockPos blockpos1 = p_180709_3_.add(p_180709_2_.nextInt(8) - p_180709_2_.nextInt(8), p_180709_2_.nextInt(4) - p_180709_2_.nextInt(4), p_180709_2_.nextInt(8) - p_180709_2_.nextInt(8));

            if (worldIn.isAirBlock(blockpos1) && Grass.canBlockStay(worldIn, blockpos1, Grass.getDefaultState()))
            {
                worldIn.setBlockState(blockpos1, Grass.getDefaultState(), 2);
            }
        }

        return true;
    }
}