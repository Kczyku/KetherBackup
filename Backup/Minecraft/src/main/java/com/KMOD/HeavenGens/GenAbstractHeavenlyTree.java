package com.KMOD.HeavenGens;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;

import com.KMOD.Core.KCore;

public abstract class GenAbstractHeavenlyTree extends WorldGenAbstractTree
{

    public GenAbstractHeavenlyTree(boolean p_i45448_1_)
    {
        super(p_i45448_1_);
    }

    protected boolean func_150523_a(Block p_150523_1_)
    {
        return p_150523_1_.getMaterial() == Material.air || p_150523_1_.getMaterial() == Material.leaves || p_150523_1_ == KCore.HeavenlyGrass || p_150523_1_ == KCore.HeavenlyDirt || p_150523_1_ == KCore.HeavenlyLog || p_150523_1_ == Blocks.log2 || p_150523_1_ == Blocks.sapling || p_150523_1_ == Blocks.vine;
    }

    protected void func_175921_a(World worldIn, BlockPos p_175921_2_)
    {
        if (worldIn.getBlockState(p_175921_2_).getBlock() != KCore.HeavenlyDirt)
        {
            this.func_175903_a(worldIn, p_175921_2_, KCore.HeavenlyDirt.getDefaultState());
        }
    }

}