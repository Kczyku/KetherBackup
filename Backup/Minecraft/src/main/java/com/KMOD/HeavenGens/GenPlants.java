package com.KMOD.HeavenGens;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.feature.WorldGenerator;

import com.KMOD.Blocks.BlockHeavenlyBush;
import com.KMOD.Core.KCore;
import com.KMOD.DimBase.HeavenDesert;
import com.KMOD.DimBase.HeavenForest;

public class GenPlants extends WorldGenerator
{
    private final BlockHeavenlyBush field_175907_a;
    BiomeGenBase ActualBiome;
    public GenPlants(BiomeGenBase b)
    {
    	ActualBiome = b;
    	field_175907_a = this.getRandomFlower();
    }
    
    public GenPlants(BlockHeavenlyBush bush)
    {
    	field_175907_a = bush;
    }
    Random random = new Random();
    public BlockHeavenlyBush getRandomFlower()
    { 
        int i = random.nextInt(12);
        		if(i == 0 && !(ActualBiome instanceof HeavenDesert)) 		return (BlockHeavenlyBush) KCore.GlowingFungus;		
        		if(i == 1 && !(ActualBiome instanceof HeavenDesert))	return (BlockHeavenlyBush) KCore.FourLeafClover;
        		if(i == 2 && !(ActualBiome instanceof HeavenDesert)) 	return (BlockHeavenlyBush) KCore.SaintLily;
        		if(i == 3 && !(ActualBiome instanceof HeavenDesert)) 	return (BlockHeavenlyBush) KCore.HeavenlyBlackRose;
        		if(i == 4 && !(ActualBiome instanceof HeavenDesert))	return (BlockHeavenlyBush) KCore.HeavenlyBlueRose;
        		if(i == 5 && !(ActualBiome instanceof HeavenDesert))	return (BlockHeavenlyBush) KCore.HeavenlyPurpleRose;
        		if(i == 6 && !(ActualBiome instanceof HeavenDesert))	return (BlockHeavenlyBush) KCore.HeavenlyRedMyth;
        		if(i == 7 && !(ActualBiome instanceof HeavenDesert))	return (BlockHeavenlyBush) KCore.HeavenlyBlueMyth;
        		if(i == 8 && !(ActualBiome instanceof HeavenDesert))	return (BlockHeavenlyBush) KCore.HeavenlyYellowMyth;
        		if(i == 9 && ActualBiome instanceof HeavenDesert) 		return (BlockHeavenlyBush) KCore.RottenBush;
        		if(i == 10 && ActualBiome instanceof HeavenDesert) 		return (BlockHeavenlyBush) KCore.PoisonousCactus;
        		else		return (BlockHeavenlyBush) KCore.GlowingFungus;
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

            if (worldIn.isAirBlock(blockpos1) && (worldIn.getBlockState(blockpos1.down()) == KCore.HeavenlyGrass.getDefaultState() || worldIn.getBlockState(blockpos1.down()) == KCore.HeavenlyCloud.getDefaultState() || worldIn.getBlockState(blockpos1.down()) == KCore.GildedSand.getDefaultState()))
            {
                worldIn.setBlockState(blockpos1, this.field_175907_a.getDefaultState(), 2);
            }
        }

        return true;
    }
}