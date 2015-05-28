package com.KMOD.HeavenGens;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.fml.common.IWorldGenerator;

import com.KMOD.Core.KCore;

public class GenGoldenTemple extends WorldGenerator implements IWorldGenerator
{


	public boolean locationIsValidSpawn(World world, int i, int j, int k)
	{
		if((world.getBlockState(new BlockPos(i, j - 1, k)) == KCore.HeavenlyGrass.getDefaultState() || world.getBlockState(new BlockPos(i, j - 2, k)) == KCore.HeavenlyDirt)
				&& (world.isAirBlock(new BlockPos(i, j, k)) || world.getBlockState(new BlockPos(i, j, k)) == KCore.HeavenlyGrass))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	public GenGoldenTemple() { }

	@Override
	public boolean generate(World worldIn, Random p_180709_2_, BlockPos pos) 
	{
		this.generate(worldIn, p_180709_2_, pos.getX(), pos.getY(), pos.getZ());
		return false;
	}
	
	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider){}

	public void setBlock(World world, int x, int y, int z, Block block, int metadata)
	{
			world.setBlockState(new BlockPos(x, y, z), block.getDefaultState(), metadata);
	}

	public boolean generate(World world, Random rand, int i, int j, int k)
	{
		//check that each corner is one of the valid spawn blocks
		if(!locationIsValidSpawn(world, i, j, k) || !locationIsValidSpawn(world, i + 10, j, k) || !locationIsValidSpawn(world, i + 10, j, k + 11) || !locationIsValidSpawn(world, i, j, k + 11))
		{
			return false;
		}

		k = k - 10;
		i = i - 10;

		this.setBlock(world, i + 0, j + 0, k + 4, KCore.GoldenStone, 0);
		this.setBlock(world, i + 0, j + 0, k + 5, KCore.GoldenStone, 0);
		this.setBlock(world, i + 0, j + 0, k + 6, KCore.GoldenStone, 0);
		this.setBlock(world, i + 1, j + 0, k + 3, KCore.MossyGoldenStone, 0);
		this.setBlock(world, i + 1, j + 0, k + 4, KCore.GoldenStone, 0);
		this.setBlock(world, i + 1, j + 0, k + 5, KCore.GoldenStone, 0);
		this.setBlock(world, i + 1, j + 0, k + 6, KCore.GoldenStone, 0);
		this.setBlock(world, i + 1, j + 0, k + 7, KCore.MossyGoldenStone, 0);
		this.setBlock(world, i + 1, j + 1, k + 3, KCore.MossyGoldenStone, 0);
		this.setBlock(world, i + 1, j + 1, k + 7, KCore.MossyGoldenStone, 0);
		this.setBlock(world, i + 1, j + 2, k + 3, KCore.MossyGoldenStone, 0);
		this.setBlock(world, i + 1, j + 2, k + 7, KCore.MossyGoldenStone, 0);
		this.setBlock(world, i + 1, j + 3, k + 3, KCore.MossyGoldenStone, 0);
		this.setBlock(world, i + 1, j + 3, k + 4, KCore.MossyGoldenStone, 0);
		this.setBlock(world, i + 1, j + 3, k + 6, KCore.MossyGoldenStone, 0);
		this.setBlock(world, i + 1, j + 3, k + 7, KCore.MossyGoldenStone, 0);
		this.setBlock(world, i + 1, j + 4, k + 4, KCore.MossyGoldenStone, 0);
		this.setBlock(world, i + 1, j + 4, k + 5, KCore.MossyGoldenStone, 0);
		this.setBlock(world, i + 1, j + 4, k + 6, KCore.MossyGoldenStone, 0);
		this.setBlock(world, i + 2, j + 0, k + 2, KCore.MossyGoldenStone, 0);
		this.setBlock(world, i + 2, j + 0, k + 3, KCore.GoldenStone, 0);
		this.setBlock(world, i + 2, j + 0, k + 4, KCore.GoldenStone, 0);
		this.setBlock(world, i + 2, j + 0, k + 5, KCore.GoldenStone, 0);
		this.setBlock(world, i + 2, j + 0, k + 6, KCore.GoldenStone, 0);
		this.setBlock(world, i + 2, j + 0, k + 7, KCore.GoldenStone, 0);
		this.setBlock(world, i + 2, j + 0, k + 8, KCore.MossyGoldenStone, 0);
		this.setBlock(world, i + 2, j + 1, k + 2, KCore.MossyGoldenStone, 0);
		this.setBlock(world, i + 2, j + 1, k + 5, KCore.HeavenlyStone, 0);
		this.setBlock(world, i + 2, j + 1, k + 8, KCore.MossyGoldenStone, 0);
		this.setBlock(world, i + 2, j + 2, k + 2, KCore.MossyGoldenStone, 0);
		this.setBlock(world, i + 2, j + 2, k + 8, KCore.MossyGoldenStone, 0);
		this.setBlock(world, i + 2, j + 3, k + 2, KCore.MossyGoldenStone, 0);
		this.setBlock(world, i + 2, j + 3, k + 8, KCore.MossyGoldenStone, 0);
		this.setBlock(world, i + 2, j + 4, k + 3, KCore.MossyGoldenStone, 0);
		this.setBlock(world, i + 2, j + 4, k + 7, KCore.MossyGoldenStone, 0);
		this.setBlock(world, i + 2, j + 5, k + 4, KCore.MossyGoldenStone, 0);
		this.setBlock(world, i + 2, j + 5, k + 5, KCore.MossyGoldenStone, 0);
		this.setBlock(world, i + 2, j + 5, k + 6, KCore.MossyGoldenStone, 0);
		this.setBlock(world, i + 3, j + 0, k + 1, KCore.MossyGoldenStone, 0);
		this.setBlock(world, i + 3, j + 0, k + 2, KCore.GoldenStone, 0);
		this.setBlock(world, i + 3, j + 0, k + 3, KCore.GoldenStone, 0);
		this.setBlock(world, i + 3, j + 0, k + 4, KCore.GoldenStone, 0);
		this.setBlock(world, i + 3, j + 0, k + 5, KCore.GoldenStone, 0);
		this.setBlock(world, i + 3, j + 0, k + 6, KCore.GoldenStone, 0);
		this.setBlock(world, i + 3, j + 0, k + 7, KCore.GoldenStone, 0);
		this.setBlock(world, i + 3, j + 0, k + 8, KCore.GoldenStone, 0);
		this.setBlock(world, i + 3, j + 0, k + 9, KCore.MossyGoldenStone, 0);
		this.setBlock(world, i + 3, j + 1, k + 1, KCore.MossyGoldenStone, 0);
		this.setBlock(world, i + 3, j + 1, k + 4, KCore.HeavenlyStone, 0);
		this.setBlock(world, i + 3, j + 1, k + 6, KCore.HeavenlyStone, 0);
		this.setBlock(world, i + 3, j + 1, k + 9, KCore.MossyGoldenStone, 0);
		this.setBlock(world, i + 3, j + 2, k + 1, KCore.MossyGoldenStone, 0);
		this.setBlock(world, i + 3, j + 2, k + 9, KCore.MossyGoldenStone, 0);
		this.setBlock(world, i + 3, j + 3, k + 1, KCore.MossyGoldenStone, 0);
		this.setBlock(world, i + 3, j + 3, k + 9, KCore.MossyGoldenStone, 0);
		this.setBlock(world, i + 3, j + 4, k + 2, KCore.MossyGoldenStone, 0);
		this.setBlock(world, i + 3, j + 4, k + 8, KCore.MossyGoldenStone, 0);
		this.setBlock(world, i + 3, j + 5, k + 3, KCore.MossyGoldenStone, 0);
		this.setBlock(world, i + 3, j + 5, k + 7, KCore.MossyGoldenStone, 0);
		this.setBlock(world, i + 3, j + 6, k + 4, KCore.MossyGoldenStone, 0);
		this.setBlock(world, i + 3, j + 6, k + 5, KCore.MossyGoldenStone, 0);
		this.setBlock(world, i + 3, j + 6, k + 6, KCore.MossyGoldenStone, 0);
		this.setBlock(world, i + 4, j + 0, k + 0, KCore.GoldenStone, 0);
		this.setBlock(world, i + 4, j + 0, k + 1, KCore.GoldenStone, 0);
		this.setBlock(world, i + 4, j + 0, k + 2, KCore.GoldenStone, 0);
		this.setBlock(world, i + 4, j + 0, k + 3, KCore.GoldenStone, 0);
		this.setBlock(world, i + 4, j + 0, k + 4, KCore.GoldenStone, 0);
		this.setBlock(world, i + 4, j + 0, k + 5, KCore.GoldenStone, 0);
		this.setBlock(world, i + 4, j + 0, k + 6, KCore.GoldenStone, 0);
		this.setBlock(world, i + 4, j + 0, k + 7, KCore.GoldenStone, 0);
		this.setBlock(world, i + 4, j + 0, k + 8, KCore.GoldenStone, 0);
		this.setBlock(world, i + 4, j + 0, k + 9, KCore.GoldenStone, 0);
		this.setBlock(world, i + 4, j + 0, k + 10, KCore.GoldenStone, 0);
		this.setBlock(world, i + 4, j + 1, k + 3, KCore.HeavenlyStone, 0);
		this.setBlock(world, i + 4, j + 1, k + 7, KCore.HeavenlyStone, 0);
		this.setBlock(world, i + 4, j + 3, k + 1, KCore.MossyGoldenStone, 0);
		this.setBlock(world, i + 4, j + 3, k + 9, KCore.MossyGoldenStone, 0);
		this.setBlock(world, i + 4, j + 4, k + 1, KCore.MossyGoldenStone, 0);
		this.setBlock(world, i + 4, j + 4, k + 9, KCore.MossyGoldenStone, 0);
		this.setBlock(world, i + 4, j + 5, k + 2, KCore.MossyGoldenStone, 0);
		this.setBlock(world, i + 4, j + 5, k + 8, KCore.MossyGoldenStone, 0);
		this.setBlock(world, i + 4, j + 6, k + 3, KCore.MossyGoldenStone, 0);
		this.setBlock(world, i + 4, j + 6, k + 7, KCore.MossyGoldenStone, 0);
		this.setBlock(world, i + 4, j + 7, k + 4, KCore.MossyGoldenStone, 0);
		this.setBlock(world, i + 4, j + 7, k + 5, KCore.MossyGoldenStone, 0);
		this.setBlock(world, i + 4, j + 7, k + 6, KCore.MossyGoldenStone, 0);
		this.setBlock(world, i + 5, j + 0, k + 0, KCore.GoldenStone, 0);
		this.setBlock(world, i + 5, j + 0, k + 1, KCore.GoldenStone, 0);
		this.setBlock(world, i + 5, j + 0, k + 2, KCore.GoldenStone, 0);
		this.setBlock(world, i + 5, j + 0, k + 3, KCore.GoldenStone, 0);
		this.setBlock(world, i + 5, j + 0, k + 4, KCore.GoldenStone, 0);
		this.setBlock(world, i + 5, j + 0, k + 5, KCore.GoldenStone, 0);
		this.setBlock(world, i + 5, j + 0, k + 6, KCore.GoldenStone, 0);
		this.setBlock(world, i + 5, j + 0, k + 7, KCore.GoldenStone, 0);
		this.setBlock(world, i + 5, j + 0, k + 8, KCore.GoldenStone, 0);
		this.setBlock(world, i + 5, j + 0, k + 9, KCore.GoldenStone, 0);
		this.setBlock(world, i + 5, j + 0, k + 10, KCore.GoldenStone, 0);
		this.setBlock(world, i + 5, j + 1, k + 2, KCore.HeavenlyStone, 0);
		this.setBlock(world, i + 5, j + 1, k + 5, KCore.HeavenlyStone, 0);
		this.setBlock(world, i + 5, j + 1, k + 8, KCore.HeavenlyStone, 0);
		this.setBlock(world, i + 5, j + 2, k + 5, KCore.HeavenlyStone, 0);
		this.setBlock(world, i + 5, j + 3, k + 5, KCore.HeavenlyStone, 0);
		this.setBlock(world, i + 5, j + 4, k + 1, KCore.MossyGoldenStone, 0);
		this.setBlock(world, i + 5, j + 4, k + 5, KCore.GoldenEssence, 0);
		this.setBlock(world, i + 5, j + 4, k + 9, KCore.MossyGoldenStone, 0);
		this.setBlock(world, i + 5, j + 5, k + 2, KCore.MossyGoldenStone, 0);
		this.setBlock(world, i + 5, j + 5, k + 8, KCore.MossyGoldenStone, 0);
		this.setBlock(world, i + 5, j + 6, k + 3, KCore.MossyGoldenStone, 0);
		this.setBlock(world, i + 5, j + 6, k + 7, KCore.MossyGoldenStone, 0);
		this.setBlock(world, i + 5, j + 7, k + 4, KCore.MossyGoldenStone, 0);
		this.setBlock(world, i + 5, j + 7, k + 6, KCore.MossyGoldenStone, 0);
		this.setBlock(world, i + 5, j + 8, k + 5, KCore.MossyGoldenStone, 0);
		this.setBlock(world, i + 6, j + 0, k + 0, KCore.GoldenStone, 0);
		this.setBlock(world, i + 6, j + 0, k + 1, KCore.GoldenStone, 0);
		this.setBlock(world, i + 6, j + 0, k + 2, KCore.GoldenStone, 0);
		this.setBlock(world, i + 6, j + 0, k + 3, KCore.GoldenStone, 0);
		this.setBlock(world, i + 6, j + 0, k + 4, KCore.GoldenStone, 0);
		this.setBlock(world, i + 6, j + 0, k + 5, KCore.GoldenStone, 0);
		this.setBlock(world, i + 6, j + 0, k + 6, KCore.GoldenStone, 0);
		this.setBlock(world, i + 6, j + 0, k + 7, KCore.GoldenStone, 0);
		this.setBlock(world, i + 6, j + 0, k + 8, KCore.GoldenStone, 0);
		this.setBlock(world, i + 6, j + 0, k + 9, KCore.GoldenStone, 0);
		this.setBlock(world, i + 6, j + 0, k + 10, KCore.GoldenStone, 0);
		this.setBlock(world, i + 6, j + 1, k + 3, KCore.HeavenlyStone, 0);
		this.setBlock(world, i + 6, j + 1, k + 7, KCore.HeavenlyStone, 0);
		this.setBlock(world, i + 6, j + 3, k + 1, KCore.MossyGoldenStone, 0);
		this.setBlock(world, i + 6, j + 3, k + 9, KCore.MossyGoldenStone, 0);
		this.setBlock(world, i + 6, j + 4, k + 1, KCore.MossyGoldenStone, 0);
		this.setBlock(world, i + 6, j + 4, k + 9, KCore.MossyGoldenStone, 0);
		this.setBlock(world, i + 6, j + 5, k + 2, KCore.MossyGoldenStone, 0);
		this.setBlock(world, i + 6, j + 5, k + 8, KCore.MossyGoldenStone, 0);
		this.setBlock(world, i + 6, j + 6, k + 3, KCore.MossyGoldenStone, 0);
		this.setBlock(world, i + 6, j + 6, k + 7, KCore.MossyGoldenStone, 0);
		this.setBlock(world, i + 6, j + 7, k + 4, KCore.MossyGoldenStone, 0);
		this.setBlock(world, i + 6, j + 7, k + 5, KCore.MossyGoldenStone, 0);
		this.setBlock(world, i + 6, j + 7, k + 6, KCore.MossyGoldenStone, 0);
		this.setBlock(world, i + 7, j + 0, k + 1, KCore.MossyGoldenStone, 0);
		this.setBlock(world, i + 7, j + 0, k + 2, KCore.GoldenStone, 0);
		this.setBlock(world, i + 7, j + 0, k + 3, KCore.GoldenStone, 0);
		this.setBlock(world, i + 7, j + 0, k + 4, KCore.GoldenStone, 0);
		this.setBlock(world, i + 7, j + 0, k + 5, KCore.GoldenStone, 0);
		this.setBlock(world, i + 7, j + 0, k + 6, KCore.GoldenStone, 0);
		this.setBlock(world, i + 7, j + 0, k + 7, KCore.GoldenStone, 0);
		this.setBlock(world, i + 7, j + 0, k + 8, KCore.GoldenStone, 0);
		this.setBlock(world, i + 7, j + 0, k + 9, KCore.MossyGoldenStone, 0);
		this.setBlock(world, i + 7, j + 1, k + 1, KCore.MossyGoldenStone, 0);
		this.setBlock(world, i + 7, j + 1, k + 4, KCore.HeavenlyStone, 0);
		this.setBlock(world, i + 7, j + 1, k + 6, KCore.HeavenlyStone, 0);
		this.setBlock(world, i + 7, j + 1, k + 9, KCore.MossyGoldenStone, 0);
		this.setBlock(world, i + 7, j + 2, k + 1, KCore.MossyGoldenStone, 0);
		this.setBlock(world, i + 7, j + 2, k + 9, KCore.MossyGoldenStone, 0);
		this.setBlock(world, i + 7, j + 3, k + 1, KCore.MossyGoldenStone, 0);
		this.setBlock(world, i + 7, j + 3, k + 9, KCore.MossyGoldenStone, 0);
		this.setBlock(world, i + 7, j + 4, k + 2, KCore.MossyGoldenStone, 0);
		this.setBlock(world, i + 7, j + 4, k + 8, KCore.MossyGoldenStone, 0);
		this.setBlock(world, i + 7, j + 5, k + 3, KCore.MossyGoldenStone, 0);
		this.setBlock(world, i + 7, j + 5, k + 7, KCore.MossyGoldenStone, 0);
		this.setBlock(world, i + 7, j + 6, k + 4, KCore.MossyGoldenStone, 0);
		this.setBlock(world, i + 7, j + 6, k + 5, KCore.MossyGoldenStone, 0);
		this.setBlock(world, i + 7, j + 6, k + 6, KCore.MossyGoldenStone, 0);
		this.setBlock(world, i + 8, j + 0, k + 2, KCore.MossyGoldenStone, 0);
		this.setBlock(world, i + 8, j + 0, k + 3, KCore.GoldenStone, 0);
		this.setBlock(world, i + 8, j + 0, k + 4, KCore.GoldenStone, 0);
		this.setBlock(world, i + 8, j + 0, k + 5, KCore.GoldenStone, 0);
		this.setBlock(world, i + 8, j + 0, k + 6, KCore.GoldenStone, 0);
		this.setBlock(world, i + 8, j + 0, k + 7, KCore.GoldenStone, 0);
		this.setBlock(world, i + 8, j + 0, k + 8, KCore.MossyGoldenStone, 0);
		this.setBlock(world, i + 8, j + 1, k + 2, KCore.MossyGoldenStone, 0);
		this.setBlock(world, i + 8, j + 1, k + 5, KCore.HeavenlyStone, 0);
		this.setBlock(world, i + 8, j + 1, k + 8, KCore.MossyGoldenStone, 0);
		this.setBlock(world, i + 8, j + 2, k + 2, KCore.MossyGoldenStone, 0);
		this.setBlock(world, i + 8, j + 2, k + 8, KCore.MossyGoldenStone, 0);
		this.setBlock(world, i + 8, j + 3, k + 2, KCore.MossyGoldenStone, 0);
		this.setBlock(world, i + 8, j + 3, k + 8, KCore.MossyGoldenStone, 0);
		this.setBlock(world, i + 8, j + 4, k + 3, KCore.MossyGoldenStone, 0);
		this.setBlock(world, i + 8, j + 4, k + 7, KCore.MossyGoldenStone, 0);
		this.setBlock(world, i + 8, j + 5, k + 4, KCore.MossyGoldenStone, 0);
		this.setBlock(world, i + 8, j + 5, k + 5, KCore.MossyGoldenStone, 0);
		this.setBlock(world, i + 8, j + 5, k + 6, KCore.MossyGoldenStone, 0);
		this.setBlock(world, i + 9, j + 0, k + 3, KCore.MossyGoldenStone, 0);
		this.setBlock(world, i + 9, j + 0, k + 4, KCore.GoldenStone, 0);
		this.setBlock(world, i + 9, j + 0, k + 5, KCore.GoldenStone, 0);
		this.setBlock(world, i + 9, j + 0, k + 6, KCore.GoldenStone, 0);
		this.setBlock(world, i + 9, j + 0, k + 7, KCore.MossyGoldenStone, 0);
		this.setBlock(world, i + 9, j + 1, k + 3, KCore.MossyGoldenStone, 0);
		this.setBlock(world, i + 9, j + 1, k + 7, KCore.MossyGoldenStone, 0);
		this.setBlock(world, i + 9, j + 2, k + 3, KCore.MossyGoldenStone, 0);
		this.setBlock(world, i + 9, j + 2, k + 7, KCore.MossyGoldenStone, 0);
		this.setBlock(world, i + 9, j + 3, k + 3, KCore.MossyGoldenStone, 0);
		this.setBlock(world, i + 9, j + 3, k + 4, KCore.MossyGoldenStone, 0);
		this.setBlock(world, i + 9, j + 3, k + 6, KCore.MossyGoldenStone, 0);
		this.setBlock(world, i + 9, j + 3, k + 7, KCore.MossyGoldenStone, 0);
		this.setBlock(world, i + 9, j + 4, k + 4, KCore.MossyGoldenStone, 0);
		this.setBlock(world, i + 9, j + 4, k + 5, KCore.MossyGoldenStone, 0);
		this.setBlock(world, i + 9, j + 4, k + 6, KCore.MossyGoldenStone, 0);
		this.setBlock(world, i + 10, j + 0, k + 4, KCore.GoldenStone, 0);
		this.setBlock(world, i + 10, j + 0, k + 5, KCore.GoldenStone, 0);
		this.setBlock(world, i + 10, j + 0, k + 6, KCore.GoldenStone, 0);

		return true;
	}


}