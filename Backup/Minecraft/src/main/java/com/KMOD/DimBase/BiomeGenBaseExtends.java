package com.KMOD.DimBase;

import java.awt.Color;
import java.util.Random;

import net.minecraft.block.BlockSand;
import net.minecraft.block.BlockTallGrass;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.monster.EntityEnderman;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.entity.monster.EntitySlime;
import net.minecraft.entity.monster.EntitySpider;
import net.minecraft.entity.monster.EntityWitch;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.passive.EntityBat;
import net.minecraft.entity.passive.EntityChicken;
import net.minecraft.entity.passive.EntityCow;
import net.minecraft.entity.passive.EntityPig;
import net.minecraft.entity.passive.EntityRabbit;
import net.minecraft.entity.passive.EntitySheep;
import net.minecraft.entity.passive.EntitySquid;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.chunk.ChunkPrimer;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import net.minecraft.world.gen.feature.WorldGenBigTree;
import net.minecraft.world.gen.feature.WorldGenSwamp;
import net.minecraft.world.gen.feature.WorldGenTallGrass;
import net.minecraft.world.gen.feature.WorldGenTrees;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import com.KMOD.Blocks.BlockHeavenlyBush;
import com.KMOD.Core.KCore;
import com.KMOD.Entities.EntityBird;
import com.KMOD.Entities.EntityBoar;
import com.KMOD.Entities.EntityFloatingStone;
import com.KMOD.Entities.EntityFlyingTurtle;
import com.KMOD.Entities.EntityGravitionalOre;
import com.KMOD.Entities.EntityKetherus;
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
import com.KMOD.HeavenGens.GenMinableHeaven;
import com.KMOD.HeavenGens.GenTallGrass;

public abstract class BiomeGenBaseExtends extends BiomeGenBase
{
	
	private WorldGenerator OreGen, DungeonGen1, TempleGen, DungeonGen2, theWorldGenerator1, theWorldGenerator2;

    public BiomeGenBaseExtends(int p_i1971_1_)
    {
        this(p_i1971_1_, true);
    }
    
    protected static final BiomeGenBase.Height HeavenH = new BiomeGenBase.Height(-0.5F, 0.6F);

    public BiomeGenBaseExtends(int p_i1971_1_, boolean register)
    {
    	super(p_i1971_1_, register);
        this.topBlock = KCore.HeavenlyGrass.getDefaultState();
        this.fillerBlock = KCore.HeavenlyDirt.getDefaultState();
        this.minHeight = height_Default.rootHeight;
        this.maxHeight = height_Default.variation;
        this.setHeight(HeavenH);
        this.setTemperatureRainfall(0.95F, 0.9F);
        this.enableRain = true;
        
        this.spawnableCaveCreatureList.clear();
        this.spawnableCreatureList.clear();
        this.spawnableMonsterList.clear();
        this.spawnableWaterCreatureList.clear();
        
        this.spawnableCreatureList.add(new BiomeGenBase.SpawnListEntry(EntityBoar.class, 12, 1, 6));
        this.spawnableCreatureList.add(new BiomeGenBase.SpawnListEntry(EntityFlyingTurtle.class, 10, 1, 3));
        this.spawnableCreatureList.add(new BiomeGenBase.SpawnListEntry(EntityStoneEater.class, 10, 1, 4));
        this.spawnableCreatureList.add(new BiomeGenBase.SpawnListEntry(EntityFloatingStone.class, 10, 1, 3));
        this.spawnableCreatureList.add(new BiomeGenBase.SpawnListEntry(EntityKetherus.class, 8, 1, 1));
        this.spawnableCreatureList.add(new BiomeGenBase.SpawnListEntry(EntityBird.class, 15, 3, 6));
        this.spawnableCreatureList.add(new BiomeGenBase.SpawnListEntry(EntityGravitionalOre.class, 1, 1, 1));
        this.spawnableCreatureList.add(new BiomeGenBase.SpawnListEntry(EntitySpectator.class, 5, 1, 1));


        this.spawnableMonsterList.add(new BiomeGenBase.SpawnListEntry(EntitySmalloverPlant.class, 10, 1, 1));
        this.spawnableMonsterList.add(new BiomeGenBase.SpawnListEntry(EntityNightmare.class, 100, 1, 1));
        
        
        
        this.DungeonGen1 = new GenFireDungeon();
        this.TempleGen = new GenGoldenTemple();
        this.DungeonGen2 = new GenForbiddenDungeonMain();
        this.theWorldGenerator1 = new GenFloatingMiniIslands();
        this.theWorldGenerator2 = new GenBigCloud();
    }
    
    
    Random random = new Random();
    public WorldGenAbstractTree getRandomTree()
    {
    	int k = random.nextInt(8);
    	if(k == 0 || k == 1 || k == 2)
    	{
    		return new GenBasicHeavenlyTree(false, 10, false);
    	}
    	else if(k == 3 || k == 4)
    	{
    		return new GenAccaciaHeavenlyTree(true);
    	}
    	else if(k == 5 || k == 6)
    	{
    		return new GenBasicBlueHeavenlyTree(false, 10, false);
    	}
    	else
    	{
    		return new GenBasicHeavenlyTree(false, 10, false);
    	}
    }
    
    public IBlockState getRandomOre()
    {
    	int k = random.nextInt(23);
    	if(k == 0 || k == 1 || k == 2)
    	{
    		return KCore.SapphireOre.getDefaultState();
    	}
    	else if(k == 3 || k == 4 || k == 5)
    	{
    		return KCore.TopazOre.getDefaultState();
    	}
    	else if(k == 6 || k == 7 || k == 8)
    	{
    		return KCore.RubyOre.getDefaultState();
    	}
    	else if(k == 9 || k == 10 || k == 11 || k == 12)
    	{
    		return KCore.Rhyolite.getDefaultState();
    	}
    	else if(k == 13 || k == 14 || k == 15 || k == 16)
    	{
    		return KCore.GildedSand.getDefaultState();
    	}
    	else if(k == 17 || k == 18 || k == 19 || k == 20)
    	{
    		return KCore.Basalt.getDefaultState();
    	}
    	else if(k == 21 || k == 22)
    	{
    		return KCore.TitaniumOre.getDefaultState();
    	}
    	else
    	{
    		return KCore.Basalt.getDefaultState();
    	}
    }
    public int getRandomOreSize()
    {
    	int k = random.nextInt(13);
    	if(k <= 3)
    	{
    		k = 3;
    	}
    	return k;
    }


    public WorldGenerator getRandomWorldGenForGrass(Random p_76730_1_)
    {
        return new GenTallGrass((BlockHeavenlyBush)KCore.HeavenlyTallGrass);
    }
    
    @Override
    public WorldGenAbstractTree genBigTreeChance(Random random)
    {
    	 return this.getRandomTree();
    }

    @SideOnly(Side.CLIENT)
    public int getSkyColorByTemp(float p_76731_1_)
    {
        p_76731_1_ /= 3.0F;
        p_76731_1_ = MathHelper.clamp_float(p_76731_1_, -1.0F, 1.0F);
        return Color.getHSBColor(0.62222224F - p_76731_1_ * 0.05F, 0.5F + p_76731_1_ * 0.1F, 1.0F).getRGB();
    }



    /**
     * returns the chance a creature has to spawn.
     */
    public float getSpawningChance()
    {
        return 0.1F;
    }


    public void decorate(World worldIn, Random p_180624_2_, BlockPos p_180624_3_)
    {
        this.theBiomeDecorator.decorate(worldIn, p_180624_2_, this, p_180624_3_);
        int i = 3 + p_180624_2_.nextInt(6);
        int j;
        int k;
        int l;
        
        for (i = 0; i < 15; ++i)
        {
        	OreGen = new GenMinableHeaven(this.getRandomOre(), this.getRandomOreSize());
            j = p_180624_2_.nextInt(16);
            k = MathHelper.getRandomIntegerInRange(p_180624_2_, 61, 160);
            l = p_180624_2_.nextInt(16);
            this.OreGen.generate(worldIn, p_180624_2_, p_180624_3_.add(j, k, l));
        }
        
        
        if(p_180624_2_.nextInt(1000) == 3)
        {
            j = p_180624_2_.nextInt(16);
            k = p_180624_2_.nextInt(MathHelper.getRandomIntegerInRange(p_180624_2_, 20, 150));
            l = p_180624_2_.nextInt(16);
            this.DungeonGen1.generate(worldIn, p_180624_2_, p_180624_3_.add(j, k, l));
        }
        
        if(p_180624_2_.nextInt(2000) == 3)
        {
            j = p_180624_2_.nextInt(16);
            k = p_180624_2_.nextInt(MathHelper.getRandomIntegerInRange(p_180624_2_, 20, 175));
            l = p_180624_2_.nextInt(16);
            this.DungeonGen2.generate(worldIn, p_180624_2_, p_180624_3_.add(j, k, l));
        }
        
        if(p_180624_2_.nextInt(200) == 3)
        {
            j = p_180624_2_.nextInt(16);
            k = p_180624_2_.nextInt(MathHelper.getRandomIntegerInRange(p_180624_2_, 61, 120));
            l = p_180624_2_.nextInt(16);
            this.TempleGen.generate(worldIn, p_180624_2_, p_180624_3_.add(j, k, l));
        }
        
        if(p_180624_2_.nextInt(12) == 1)
        {
            j = p_180624_2_.nextInt(16);
            k = MathHelper.getRandomIntegerInRange(p_180624_2_, 40, 64);
            l = p_180624_2_.nextInt(16);
            this.theWorldGenerator1.generate(worldIn, p_180624_2_, p_180624_3_.add(j, k, l));
            
        }
        
        if(p_180624_2_.nextInt(7) == 1)
        {
            j = p_180624_2_.nextInt(16);
            k = MathHelper.getRandomIntegerInRange(p_180624_2_, 71, 130);
            l = p_180624_2_.nextInt(16);
            this.theWorldGenerator2.generate(worldIn, p_180624_2_, p_180624_3_.add(j, k, l));
        }
        
        
        
        
    }
    


    public void genTerrainBlocks(World worldIn, Random p_180622_2_, ChunkPrimer p_180622_3_, int p_180622_4_, int p_180622_5_, double p_180622_6_)
    {
        this.generateBiomeTerrainHeaven(worldIn, p_180622_2_, p_180622_3_, p_180622_4_, p_180622_5_, p_180622_6_);
    }

    public final void generateBiomeTerrainHeaven(World worldIn, Random random, ChunkPrimer p_180628_3_, int p_180628_4_, int p_180628_5_, double p_180628_6_)
    {
        boolean flag = true;
        IBlockState iblockstate = this.topBlock;
        IBlockState iblockstate1 = this.fillerBlock;
        int k = -1;
        int l = (int)(p_180628_6_ / 3.0D + 3.0D + random.nextDouble() * 0.25D);
        int i1 = p_180628_4_ & 15;
        int j1 = p_180628_5_ & 15;

        for (int k1 = 255; k1 >= 0; --k1)
        {
            if (k1 <= 64)
            {
                p_180628_3_.setBlockState(j1, k1, i1, Blocks.air.getDefaultState());
            }
            else if(k1 > 64)
            {
                IBlockState iblockstate2 = p_180628_3_.getBlockState(j1, k1, i1);

                if (iblockstate2.getBlock().getMaterial() == Material.air)
                {
                    k = -1;
                }
                else if (iblockstate2.getBlock() == KCore.HeavenlyStone)
                {
                    if (k == -1)
                    {
                        if (l <= 0)
                        {
                            iblockstate = null;
                            iblockstate1 = KCore.HeavenlyStone.getDefaultState();
                        }
                        else if (k1 >= 59 && k1 <= 64)
                        {
                            iblockstate = this.topBlock;
                            iblockstate1 = this.fillerBlock;
                        }

                        if (k1 < 63 && (iblockstate == null || iblockstate.getBlock().getMaterial() == Material.air))
                        {
                            if (this.getFloatTemperature(new BlockPos(p_180628_4_, k1, p_180628_5_)) < 0.15F)
                            {
                                iblockstate = Blocks.ice.getDefaultState();
                            }
                            else
                            {
                                iblockstate = Blocks.water.getDefaultState();
                            }
                        }

                        k = l;

                        if (k1 >= 62)
                        {
                            p_180628_3_.setBlockState(j1, k1, i1, iblockstate);
                        }
                        else if (k1 < 56 - l)
                        {
                            iblockstate = null;
                            iblockstate1 = KCore.HeavenlyStone.getDefaultState();
                            p_180628_3_.setBlockState(j1, k1, i1, Blocks.gravel.getDefaultState());
                        }
                        else
                        {
                            p_180628_3_.setBlockState(j1, k1, i1, iblockstate1);
                        }
                    }
                    else if (k > 0)
                    {
                        --k;
                        p_180628_3_.setBlockState(j1, k1, i1, iblockstate1);

                        if (k == 0 && iblockstate1.getBlock() == Blocks.sand)
                        {
                            k = random.nextInt(4) + Math.max(0, k1 - 63);
                            iblockstate1 = iblockstate1.getValue(BlockSand.VARIANT) == BlockSand.EnumType.RED_SAND ? Blocks.red_sandstone.getDefaultState() : Blocks.sandstone.getDefaultState();
                        }
                    }
                }
                
            }
        }
    }

 
}