package com.KMOD.DimBase;

import java.util.Random;

import net.minecraft.block.BlockSand;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.chunk.ChunkPrimer;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import net.minecraft.world.gen.feature.WorldGenerator;

import com.KMOD.Blocks.BlockHeavenlyBush;
import com.KMOD.Core.KCore;
import com.KMOD.Entities.EntityBird;
import com.KMOD.Entities.EntityFloatingStone;
import com.KMOD.Entities.EntityFlyingTurtle;
import com.KMOD.Entities.EntityGravitionalOre;
import com.KMOD.Entities.EntityGrittyMonstrosity;
import com.KMOD.Entities.EntityNightmare;
import com.KMOD.Entities.EntitySmalloverPlant;
import com.KMOD.Entities.EntitySpectator;
import com.KMOD.Entities.EntityStoneEater;
import com.KMOD.HeavenGens.GenAccaciaHeavenlyTree;
import com.KMOD.HeavenGens.GenBasicBlueHeavenlyTree;
import com.KMOD.HeavenGens.GenBasicHeavenlyTree;
import com.KMOD.HeavenGens.GenBigCloud;
import com.KMOD.HeavenGens.GenFireDungeon;
import com.KMOD.HeavenGens.GenFloatingMiniIslands;
import com.KMOD.HeavenGens.GenForbiddenDungeonMain;
import com.KMOD.HeavenGens.GenGoldenTemple;
import com.KMOD.HeavenGens.GenHeavenlyMegaPineTree;
import com.KMOD.HeavenGens.GenMinableHeaven;
import com.KMOD.HeavenGens.GenPlants;
import com.KMOD.HeavenGens.GenTallGrass;

public class HeavenDesert extends BiomeGenBaseExtends
{
    private WorldGenerator FlowerGen;
    
    

    public HeavenDesert(int p_i45377_1_)
    {
        super(p_i45377_1_);
        this.topBlock = KCore.GildedSand.getDefaultState();
        this.fillerBlock = KCore.Rhyolite.getDefaultState();
        this.theBiomeDecorator.treesPerChunk = 0;
        this.theBiomeDecorator.grassPerChunk = 0;
        setBiomeName("Heaven Desert");
        this.spawnableCreatureList.add(new BiomeGenBase.SpawnListEntry(EntityGrittyMonstrosity.class, 15, 1, 1));

    }
    
    
    
   


    

    
    
    public void decorate(World worldIn, Random p_180624_2_, BlockPos p_180624_3_)
    {
    	super.decorate(worldIn, p_180624_2_, p_180624_3_);
        int i = 3 + p_180624_2_.nextInt(6);
        int j;
        int k;
        int l;
        

            
            
            if(p_180624_2_.nextInt(2) == 1)
            {
            	this.FlowerGen = new GenPlants(this);
                j = p_180624_2_.nextInt(16);
                k = MathHelper.getRandomIntegerInRange(p_180624_2_, 62, 130);
                l = p_180624_2_.nextInt(16);
                this.FlowerGen.generate(worldIn, p_180624_2_, p_180624_3_.add(j, k, l));
            }
    }
    
     
    
    
}