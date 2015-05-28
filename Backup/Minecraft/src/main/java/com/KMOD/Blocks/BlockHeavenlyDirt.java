package com.KMOD.Blocks;

import java.util.List;
import java.util.Random;

import com.KMOD.Core.KCore;

import net.minecraft.block.Block;
import net.minecraft.block.BlockDirt;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.IStringSerializable;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockHeavenlyDirt extends BaseBlock
{

    public BlockHeavenlyDirt(String Name)
    {
        super(Name, 0.5F, 0F);
        this.setCreativeTab(KCore.OHTab);
        setStepSound(soundTypeGravel);
    }
    
    public Item getItemDropped(IBlockState state, Random rand, int fortune)
    {
    		return Item.getItemFromBlock(this);
    }
}