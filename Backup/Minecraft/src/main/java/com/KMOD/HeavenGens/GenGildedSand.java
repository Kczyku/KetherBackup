package com.KMOD.HeavenGens;

import java.util.Random;

import com.KMOD.Core.KCore;

import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class GenGildedSand extends WorldGenerator
{

    public boolean generate(World world, Random random, BlockPos pos)
    {
    	int posX = pos.getX();
    	int posY = pos.getY();
    	int posZ = pos.getZ();
    	int X = posX;
    	int Y = posY;
    	int Z = posZ;
    	
    	int x = X + random.nextInt(2) - random.nextInt(2);
    	int z = Z + random.nextInt(2) - random.nextInt(2);
    	int x1 = X + random.nextInt(3) - random.nextInt(3);
    	int z1 = X + random.nextInt(3) - random.nextInt(3);
    	
    	if(world.getBlockState(pos) == KCore.HeavenlyGrass.getDefaultState() && world.isAirBlock(pos.up()) && world.getBlockState(pos.west()) == KCore.HeavenlyGrass.getDefaultState() &&
    			world.getBlockState(pos.east()) == KCore.HeavenlyGrass.getDefaultState() && world.getBlockState(pos.south()) == KCore.HeavenlyGrass.getDefaultState() &&
    			world.getBlockState(pos.north()) == KCore.HeavenlyGrass.getDefaultState())
    	{
    		world.setBlockState(pos, KCore.GildedSand.getDefaultState());
    		world.setBlockState(new BlockPos(x, Y, z), KCore.GildedSand.getDefaultState());
    		world.setBlockState(new BlockPos(x1, Y, z1), KCore.GildedSand.getDefaultState());
    		z1 = X + random.nextInt(3) - random.nextInt(3);
    		x1 = X + random.nextInt(3) - random.nextInt(3);
    		z = Z + random.nextInt(2) - random.nextInt(2);
    		x = X + random.nextInt(2) - random.nextInt(2);
    		
    		world.setBlockState(new BlockPos(x, Y, z), KCore.GildedSand.getDefaultState());
    		world.setBlockState(new BlockPos(x1, Y, z1), KCore.GildedSand.getDefaultState());
    		
    		z1 = X + random.nextInt(3) - random.nextInt(3);
    		x1 = X + random.nextInt(3) - random.nextInt(3);
    		z = Z + random.nextInt(2) - random.nextInt(2);
    		x = X + random.nextInt(2) - random.nextInt(2);
    		
    		world.setBlockState(new BlockPos(x, Y, z), KCore.GildedSand.getDefaultState());
    		world.setBlockState(new BlockPos(x1, Y, z1), KCore.GildedSand.getDefaultState());


    	}
    	

    	
    	return true;
    }
}
