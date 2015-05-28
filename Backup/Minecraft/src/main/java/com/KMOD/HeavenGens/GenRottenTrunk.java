package com.KMOD.HeavenGens;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

import com.KMOD.Blocks.BlockRottenLog;
import com.KMOD.Core.KCore;

public class GenRottenTrunk extends WorldGenerator
{
    private final BlockRottenLog field_175907_a;

    public GenRottenTrunk(BlockRottenLog rottenLog)
    {
        this.field_175907_a = rottenLog;
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

            if (worldIn.isAirBlock(blockpos1) && (worldIn.getBlockState(blockpos1.down()) == KCore.HeavenlyGrass.getDefaultState()))
            {
                worldIn.setBlockState(blockpos1, this.field_175907_a.getDefaultState(), 2);
            }
        }

        return true;
    }
}