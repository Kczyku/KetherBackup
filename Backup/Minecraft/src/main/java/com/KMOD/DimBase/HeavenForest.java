package com.KMOD.DimBase;

import java.util.Random;

import net.minecraft.block.BlockSand;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.passive.EntityBat;
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
import com.KMOD.Entities.EntityBoar;
import com.KMOD.Entities.EntityFloatingStone;
import com.KMOD.Entities.EntityFlyingTurtle;
import com.KMOD.Entities.EntityGravitionalOre;
import com.KMOD.Entities.EntityKetherus;
import com.KMOD.Entities.EntityMushroomSprite;
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
import com.KMOD.HeavenGens.GenRottenTrunk;
import com.KMOD.HeavenGens.GenTallGrass;

public class HeavenForest extends BiomeGenBaseExtends
{
    private WorldGenerator FlowerGen, WorldGen1;
    
    

    public HeavenForest(int p_i45377_1_)
    {
        super(p_i45377_1_);
        this.theBiomeDecorator.treesPerChunk = 4;
        this.theBiomeDecorator.grassPerChunk = 2;
        setBiomeName("Heaven Forest");

        this.WorldGen1 = new GenRottenTrunk(KCore.RottenLog);
        this.spawnableCreatureList.add(new BiomeGenBase.SpawnListEntry(EntityBat.class, 5, 3, 6));
        this.spawnableMonsterList.add(new BiomeGenBase.SpawnListEntry(EntityMushroomSprite.class, 5, 1, 1));

    }
    

    
    Random random = new Random();
    @Override
    public WorldGenAbstractTree getRandomTree()
    {
    	int k = random.nextInt(8);
    	if(k == 0 || k == 1 || k == 2)
    	{
    		return new GenBasicHeavenlyTree(true, 10, true);
    	}
    	else if(k == 3 || k == 4)
    	{
    		return new GenAccaciaHeavenlyTree(true);
    	}
    	else if(k == 5 || k == 6)
    	{
    		return new GenBasicBlueHeavenlyTree(true, 10, true);
    	}
    	else if(k == 7 || k == 8)
    	{
    		return new GenHeavenlyMegaPineTree(true, true);
    	}
    	else
    	{
    		return new GenBasicHeavenlyTree(true, 10, true);
    	}
    }
    
    
   


    

    
    
    public void decorate(World worldIn, Random p_180624_2_, BlockPos p_180624_3_)
    {
    	super.decorate(worldIn, p_180624_2_, p_180624_3_);
        int i = 3 + p_180624_2_.nextInt(6);
        int j;
        int k;
        int l;
        
        
        if(p_180624_2_.nextInt(4) == 1)
        {
            this.FlowerGen = new GenPlants(this);
            j = p_180624_2_.nextInt(16);
            k = MathHelper.getRandomIntegerInRange(p_180624_2_, 62, 130);
            l = p_180624_2_.nextInt(16);
            this.FlowerGen.generate(worldIn, p_180624_2_, p_180624_3_.add(j, k, l));
        }
        
        if(p_180624_2_.nextInt(3) == 1)
        {
            this.FlowerGen = new GenPlants((BlockHeavenlyBush)KCore.GlowingFungus);
            j = p_180624_2_.nextInt(16);
            k = MathHelper.getRandomIntegerInRange(p_180624_2_, 62, 130);
            l = p_180624_2_.nextInt(16);
            this.FlowerGen.generate(worldIn, p_180624_2_, p_180624_3_.add(j, k, l));
        }
        
        if(p_180624_2_.nextInt(40) == 3)
        {
            j = p_180624_2_.nextInt(16);
            k = p_180624_2_.nextInt(MathHelper.getRandomIntegerInRange(p_180624_2_, 63, 120));
            l = p_180624_2_.nextInt(16);
            this.WorldGen1.generate(worldIn, p_180624_2_, p_180624_3_.add(j, k, l));
        }  

            
    }
    
    
}