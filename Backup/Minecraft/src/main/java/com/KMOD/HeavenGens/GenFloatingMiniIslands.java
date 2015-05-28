package com.KMOD.HeavenGens;

import java.util.Random;

import com.KMOD.Core.KCore;

import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class GenFloatingMiniIslands extends WorldGenerator
{
	
	public boolean generate(World world, Random random, BlockPos pos)
    {
    	int X = pos.getX();
    	int Y = pos.getY();
    	int Z = pos.getZ();
    	int firstj = MathHelper.getRandomIntegerInRange(random, 6, 10);
    	int secondj = MathHelper.getRandomIntegerInRange(random, 4, 8);
    	int thirdj = MathHelper.getRandomIntegerInRange(random, 2, 6);
    	
    	if(world.isAirBlock(pos) && world.isAirBlock(new BlockPos(X, Y - 5, Z)) && world.isAirBlock(new BlockPos(X, Y + 5, Z)) && world.isAirBlock(new BlockPos(X + 5, Y, Z)) && world.isAirBlock(new BlockPos(X - 5, Y, Z)) && world.isAirBlock(new BlockPos(X, Y, Z + 5)) && world.isAirBlock(new BlockPos(X, Y, Z - 5)))
    	{
    		for(int i = 0; i < firstj; i++)
    		{
    			world.setBlockState(new BlockPos(X, Y - i, Z),  KCore.HeavenlyStone.getDefaultState());
    		}
    		for(int i = 0; i < secondj; i++)
    		{
    			world.setBlockState(new BlockPos(X + 1, Y - i, Z),  KCore.HeavenlyStone.getDefaultState());
    			world.setBlockState(new BlockPos(X - 1, Y - i, Z),  KCore.HeavenlyStone.getDefaultState());
    			world.setBlockState(new BlockPos(X, Y - i, Z + 1),  KCore.HeavenlyStone.getDefaultState());
    			world.setBlockState(new BlockPos(X, Y - i, Z - 1),  KCore.HeavenlyStone.getDefaultState());

    		}
    		for(int i = 0; i < thirdj; i++)
    		{
    			world.setBlockState(new BlockPos(X + 1, Y - i, Z - 1),  KCore.HeavenlyStone.getDefaultState());
    			world.setBlockState(new BlockPos(X + 1, Y - i, Z + 1),  KCore.HeavenlyStone.getDefaultState());
    			world.setBlockState(new BlockPos(X - 1, Y - i, Z - 1),  KCore.HeavenlyStone.getDefaultState());
    			world.setBlockState(new BlockPos(X - 1, Y - i, Z + 1),  KCore.HeavenlyStone.getDefaultState());
    			world.setBlockState(new BlockPos(X, Y - i, Z - 2),  KCore.HeavenlyStone.getDefaultState());
    			world.setBlockState(new BlockPos(X, Y - i, Z + 2),  KCore.HeavenlyStone.getDefaultState());
    			world.setBlockState(new BlockPos(X + 2, Y - i, Z),  KCore.HeavenlyStone.getDefaultState());
    			world.setBlockState(new BlockPos(X - 2, Y - i, Z),  KCore.HeavenlyStone.getDefaultState());
    		}
    	
		world.setBlockState(new BlockPos(X, Y, Z),  KCore.HeavenlyGrass.getDefaultState());
		world.setBlockState(new BlockPos(X + 1, Y, Z),  KCore.HeavenlyGrass.getDefaultState());
		world.setBlockState(new BlockPos(X -1, Y, Z),  KCore.HeavenlyGrass.getDefaultState());
		world.setBlockState(new BlockPos(X, Y, Z + 1),  KCore.HeavenlyGrass.getDefaultState());
		world.setBlockState(new BlockPos(X, Y, Z - 1),  KCore.HeavenlyGrass.getDefaultState());
		world.setBlockState(new BlockPos(X + 2, Y, Z),  KCore.HeavenlyGrass.getDefaultState());
		world.setBlockState(new BlockPos(X - 2, Y, Z),  KCore.HeavenlyGrass.getDefaultState());
		world.setBlockState(new BlockPos(X, Y, Z + 2),  KCore.HeavenlyGrass.getDefaultState());
		world.setBlockState(new BlockPos(X, Y, Z - 2),  KCore.HeavenlyGrass.getDefaultState());
		world.setBlockState(new BlockPos(X + 1, Y, Z - 1),  KCore.HeavenlyGrass.getDefaultState());
		world.setBlockState(new BlockPos(X + 1, Y, Z + 1),  KCore.HeavenlyGrass.getDefaultState());
		world.setBlockState(new BlockPos(X - 1, Y, Z - 1),  KCore.HeavenlyGrass.getDefaultState());
		world.setBlockState(new BlockPos(X - 1, Y, Z + 1),  KCore.HeavenlyGrass.getDefaultState());
		
		
		return true;
		
		
    	}

        return true;
    }
}