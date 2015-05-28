package com.KMOD.Blocks;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockPortal;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemMonsterPlacer;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.EnumWorldBlockLayer;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import com.KMOD.Core.KCore;
import com.KMOD.DimBase.TeleporterHeaven;

public class BlockHeavenlyPortal extends BaseBlock
{
	private EntityPlayer ep;
	public BlockHeavenlyPortal(String Name)
	{
		super(Name, -1.0F, -1.0F);
        this.setTickRandomly(true);
        this.setCreativeTab(CreativeTabs.tabAllSearch);
	}
    public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand)
    {
        super.updateTick(worldIn, pos, state, rand);

        if (worldIn.provider.isSurfaceWorld() && worldIn.getGameRules().getGameRuleBooleanValue("doMobSpawning") && rand.nextInt(2000) < worldIn.getDifficulty().getDifficultyId())
        {
            int i = pos.getY();
            BlockPos blockpos1;

            for (blockpos1 = pos; !World.doesBlockHaveSolidTopSurface(worldIn, blockpos1) && blockpos1.getY() > 0; blockpos1 = blockpos1.down())
            {
                ;
            }

            if (i > 0 && !worldIn.getBlockState(blockpos1.up()).getBlock().isNormalCube())
            {
                Entity entity = ItemMonsterPlacer.spawnCreature(worldIn, 57, (double)blockpos1.getX() + 0.5D, (double)blockpos1.getY() + 1.1D, (double)blockpos1.getZ() + 0.5D);

                if (entity != null)
                {
                    entity.timeUntilPortal = entity.getPortalCooldown();
                }
            }
        }
    }
    
    public boolean isOpaqueCube()
    {
        return false;
    }



    public AxisAlignedBB getCollisionBoundingBox(World worldIn, BlockPos pos, IBlockState state)
    {
        return null;
    }

    public void setBlockBoundsBasedOnState(IBlockAccess worldIn, BlockPos pos)
    {
        float f = 0.125F;
        float f1 = 0.125F;

        this.setBlockBounds(0.5F - f, 0.0F, 0.5F - f1, 0.5F + f, 1.0F, 0.5F + f1);
    }

    public static int getMetaForAxis(EnumFacing.Axis axis)
    {
        return axis == EnumFacing.Axis.X ? 1 : (axis == EnumFacing.Axis.Z ? 2 : 0);
    }

    public boolean isFullCube()
    {
        return false;
    }


    @SideOnly(Side.CLIENT)
    public boolean shouldSideBeRendered(IBlockAccess worldIn, BlockPos pos, EnumFacing side)
    {
    	return true;
    }

    public int quantityDropped(Random random)
    {
        return 0;
    }

    public void onEntityCollidedWithBlock(World worldIn, BlockPos pos, IBlockState state, Entity entity)
    {	
        if ((entity.ridingEntity == null) && (entity.riddenByEntity == null) && ((entity instanceof EntityPlayerMP)))
        {
            EntityPlayerMP player = (EntityPlayerMP) entity;
 
            MinecraftServer mServer = MinecraftServer.getServer();
 
            if (player.timeUntilPortal > 0)
            {
                player.timeUntilPortal = 10;
            }
            else if (player.dimension != KCore.HDimId)
            {
                player.timeUntilPortal = 10;
 
                player.mcServer.getConfigurationManager().transferPlayerToDimension(player, KCore.HDimId, new TeleporterHeaven(mServer.worldServerForDimension(KCore.HDimId)));
                player.triggerAchievement(KCore.TravelToKether);
            }
            else
            {
                player.timeUntilPortal = 10;
                player.mcServer.getConfigurationManager().transferPlayerToDimension(player, 0, new TeleporterHeaven(mServer.worldServerForDimension(1)));
                player.posX = pos.getX();
                player.posY = pos.getY();
                player.posZ = pos.getZ();
            }
        }
        if(entity instanceof EntityPlayerMP)
        {
            EntityPlayerMP player = (EntityPlayerMP) entity;
            player.addPotionEffect(new PotionEffect(Potion.resistance.id, 100, 10));
            player.addPotionEffect(new PotionEffect(Potion.heal.id, 100, 10));
            player.addPotionEffect(new PotionEffect(Potion.regeneration.id, 100, 10));
            player.addPotionEffect(new PotionEffect(Potion.confusion.id, 50, 100));

        }
    }
 
    @SideOnly(Side.CLIENT)
    public EnumWorldBlockLayer getBlockLayer()
    {
        return EnumWorldBlockLayer.TRANSLUCENT;
    }

    @SideOnly(Side.CLIENT)
    public void randomDisplayTick(World worldIn, BlockPos pos, IBlockState state, Random rand)
    {
        if (rand.nextInt(100) == 0)
        {
            worldIn.playSound((double)pos.getX() + 0.5D, (double)pos.getY() + 0.5D, (double)pos.getZ() + 0.5D, "portal.portal", 0.5F, rand.nextFloat() * 0.4F + 0.8F, false);
        }

        for (int i = 0; i < 4; ++i)
        {
            double d0 = (double)((float)pos.getX() + rand.nextFloat());
            double d1 = (double)((float)pos.getY() + rand.nextFloat());
            double d2 = (double)((float)pos.getZ() + rand.nextFloat());
            double d3 = ((double)rand.nextFloat() - 0.5D) * 0.5D;
            double d4 = ((double)rand.nextFloat() - 0.5D) * 0.5D;
            double d5 = ((double)rand.nextFloat() - 0.5D) * 0.5D;
            int j = rand.nextInt(2) * 2 - 1;

            if (worldIn.getBlockState(pos.west()).getBlock() != this && worldIn.getBlockState(pos.east()).getBlock() != this)
            {
                d0 = (double)pos.getX() + 0.5D + 0.25D * (double)j;
                d3 = (double)(rand.nextFloat() * 2.0F * (float)j);
            }
            else
            {
                d2 = (double)pos.getZ() + 0.5D + 0.25D * (double)j;
                d5 = (double)(rand.nextFloat() * 2.0F * (float)j);
            }

            worldIn.spawnParticle(EnumParticleTypes.PORTAL, d0, d1, d2, d3, d4, d5, new int[0]);
        }
    }


    @SideOnly(Side.CLIENT)
    public Item getItem(World worldIn, BlockPos pos)
    {
        return null;
    }


    public static class Size
        {
            private final World world;
            private final EnumFacing.Axis axis;
            private final EnumFacing field_150866_c;
            private final EnumFacing field_150863_d;
            private int field_150864_e = 0;
            private BlockPos field_150861_f;
            private int field_150862_g;
            private int field_150868_h;

            public Size(World worldIn, BlockPos p_i45694_2_, EnumFacing.Axis p_i45694_3_)
            {
                this.world = worldIn;
                this.axis = p_i45694_3_;

                if (p_i45694_3_ == EnumFacing.Axis.X)
                {
                    this.field_150863_d = EnumFacing.EAST;
                    this.field_150866_c = EnumFacing.WEST;
                }
                else
                {
                    this.field_150863_d = EnumFacing.NORTH;
                    this.field_150866_c = EnumFacing.SOUTH;
                }

                for (BlockPos blockpos1 = p_i45694_2_; p_i45694_2_.getY() > blockpos1.getY() - 21 && p_i45694_2_.getY() > 0 && this.func_150857_a(worldIn.getBlockState(p_i45694_2_.down()).getBlock()); p_i45694_2_ = p_i45694_2_.down())
                {
                    ;
                }

                int i = this.func_180120_a(p_i45694_2_, this.field_150863_d) - 1;

                if (i >= 0)
                {
                    this.field_150861_f = p_i45694_2_.offset(this.field_150863_d, i);
                    this.field_150868_h = this.func_180120_a(this.field_150861_f, this.field_150866_c);

                    if (this.field_150868_h < 2 || this.field_150868_h > 21)
                    {
                        this.field_150861_f = null;
                        this.field_150868_h = 0;
                    }
                }

                if (this.field_150861_f != null)
                {
                    this.field_150862_g = this.func_150858_a();
                }
            }

            protected int func_180120_a(BlockPos p_180120_1_, EnumFacing p_180120_2_)
            {
                int i;

                for (i = 0; i < 22; ++i)
                {
                    BlockPos blockpos1 = p_180120_1_.offset(p_180120_2_, i);

                    if (!this.func_150857_a(this.world.getBlockState(blockpos1).getBlock()) || this.world.getBlockState(blockpos1.down()).getBlock() != Blocks.end_stone)
                    {
                        break;
                    }
                }

                Block block = this.world.getBlockState(p_180120_1_.offset(p_180120_2_, i)).getBlock();
                return block == Blocks.end_stone ? i : 0;
            }

            protected int func_150858_a()
            {
                int i;
                label56:

                for (this.field_150862_g = 0; this.field_150862_g < 21; ++this.field_150862_g)
                {
                    for (i = 0; i < this.field_150868_h; ++i)
                    {
                        BlockPos blockpos = this.field_150861_f.offset(this.field_150866_c, i).up(this.field_150862_g);
                        Block block = this.world.getBlockState(blockpos).getBlock();

                        if (!this.func_150857_a(block))
                        {
                            break label56;
                        }

                        if (block == KCore.HeavenlyPortal)
                        {
                            ++this.field_150864_e;
                        }

                        if (i == 0)
                        {
                            block = this.world.getBlockState(blockpos.offset(this.field_150863_d)).getBlock();

                            if (block != Blocks.end_stone)
                            {
                                break label56;
                            }
                        }
                        else if (i == this.field_150868_h - 1)
                        {
                            block = this.world.getBlockState(blockpos.offset(this.field_150866_c)).getBlock();

                            if (block != Blocks.end_stone)
                            {
                                break label56;
                            }
                        }
                    }
                }

                for (i = 0; i < this.field_150868_h; ++i)
                {
                    if (this.world.getBlockState(this.field_150861_f.offset(this.field_150866_c, i).up(this.field_150862_g)).getBlock() != Blocks.end_stone)
                    {
                        this.field_150862_g = 0;
                        break;
                    }
                }

                if (this.field_150862_g <= 21 && this.field_150862_g >= 3)
                {
                    return this.field_150862_g;
                }
                else
                {
                    this.field_150861_f = null;
                    this.field_150868_h = 0;
                    this.field_150862_g = 0;
                    return 0;
                }
            }

            protected boolean func_150857_a(Block p_150857_1_)
            {
                return p_150857_1_.getMaterial() == Material.air || p_150857_1_ == Blocks.fire || p_150857_1_ == KCore.HeavenlyPortal;
            }

            public boolean func_150860_b()
            {
                return this.field_150861_f != null && this.field_150868_h >= 2 && this.field_150868_h <= 21 && this.field_150862_g >= 3 && this.field_150862_g <= 21;
            }
            


        }
}

