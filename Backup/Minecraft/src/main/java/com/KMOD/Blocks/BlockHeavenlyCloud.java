package com.KMOD.Blocks;

import java.util.Random;

import com.KMOD.Core.KCore;

import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumWorldBlockLayer;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockHeavenlyCloud extends BaseBlock
{
    public BlockHeavenlyCloud(String Name) 
    {
            super(Name, 0.5F, 0.5F);
            this.setLightOpacity(0);
            this.setCreativeTab(KCore.OHTab);
            this.setMaterial(Material.cloth);
    }

    @SideOnly(Side.CLIENT)
    public EnumWorldBlockLayer getBlockLayer()
    {
        return EnumWorldBlockLayer.TRANSLUCENT;
    }
    public int getMobilityFlag()
    {
        return 0;
    }
    @Override
    public boolean isOpaqueCube() 
    {
            return false;
    }
    
    public boolean renderAsNormalBlock() 
    {
            return false;
    }
    
    public Item getItemDropped(int p_149650_1_, Random p_149650_2_, int p_149650_3_)
    {
    		return Item.getItemFromBlock(this);
    }



public void onEntityCollidedWithBlock(World worldIn, BlockPos pos, Entity entity)
{   
        entity.fallDistance = 0.0F;
}

@SideOnly(Side.CLIENT)
public int getRenderBlockPass()
{
    return 1;
}

public int getRenderColor(int i)
{
    if(i == 1)
    {
        return 0xccffff;
    }
    return i != 2 ? 0xffffff : 0xffff80;
}

@SideOnly(Side.CLIENT)
public int colorMultiplier(IBlockAccess worldIn, BlockPos pos, int renderPass)
{
    return 16777215;
}


@SideOnly(Side.CLIENT)
public boolean shouldSideBeRendered(IBlockAccess worldIn, BlockPos pos, EnumFacing side)
{
    return true;
}

public AxisAlignedBB getCollisionBoundingBox(World worldIn, BlockPos pos, IBlockState state)
{
    return new AxisAlignedBB((double)pos.getX() + this.minX, (double)pos.getY() + this.minY, (double)pos.getZ() + this.minZ, (double)pos.getX() + this.maxX, (double)pos.getY() + 0.2F, (double)pos.getZ() + this.maxZ);
}
}
