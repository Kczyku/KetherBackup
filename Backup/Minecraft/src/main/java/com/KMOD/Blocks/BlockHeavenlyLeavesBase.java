package com.KMOD.Blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockHeavenlyLeavesBase extends BaseBlock
{
    protected boolean fancyGraphics;

    protected BlockHeavenlyLeavesBase(String Name, Material materialIn, boolean fancyGraphics)
    {
        super(Name, 0.2F, 0F);
        this.fancyGraphics = fancyGraphics;
    }

    public boolean isOpaqueCube()
    {
        return false;
    }

    @SideOnly(Side.CLIENT)
    public boolean shouldSideBeRendered(IBlockAccess worldIn, BlockPos pos, EnumFacing side)
    {
        return true;
    }
}