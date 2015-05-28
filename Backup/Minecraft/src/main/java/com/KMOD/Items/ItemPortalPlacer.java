package com.KMOD.Items;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import com.KMOD.Core.KCore;
import com.KMOD.DimBase.TeleporterHeaven;

public class ItemPortalPlacer extends BaseItem
{

    public ItemPortalPlacer(String Name)
    {
    	super(Name);
        this.maxStackSize = 1;
        this.setCreativeTab(KCore.OHTab);
        }

    public boolean onItemUse(ItemStack stack, EntityPlayer playerIn, World worldIn, BlockPos pos, EnumFacing side, float hitX, float hitY, float hitZ)
    {
        if (!playerIn.canPlayerEdit(pos.offset(side), side, stack))
        {
            return false;
        }
        else
        {
            int hook = net.minecraftforge.event.ForgeEventFactory.onHoeUse(stack, playerIn, worldIn, pos);
            if (hook != 0) return hook > 0;

            IBlockState iblockstate = worldIn.getBlockState(pos);
            Block block = iblockstate.getBlock();

            if (worldIn.isAirBlock(pos.up()))
            {
            	worldIn.setBlockState(pos.up(1), Blocks.end_stone.getDefaultState());
            	worldIn.setBlockState(pos.up(1).west(1), Blocks.end_stone.getDefaultState());

            	worldIn.setBlockState(pos.up(1).west(2), Blocks.end_stone.getDefaultState());
            	worldIn.setBlockState(pos.up(2).west(2), Blocks.end_stone.getDefaultState());
            	worldIn.setBlockState(pos.up(3).west(2), Blocks.end_stone.getDefaultState());
            	worldIn.setBlockState(pos.up(4).west(2), Blocks.end_stone.getDefaultState());
            	worldIn.setBlockState(pos.up(5).west(2), Blocks.end_stone.getDefaultState());

            	worldIn.setBlockState(pos.up(1).east(1), Blocks.end_stone.getDefaultState());
            	worldIn.setBlockState(pos.up(2).east(1), Blocks.end_stone.getDefaultState());
            	worldIn.setBlockState(pos.up(3).east(1), Blocks.end_stone.getDefaultState());
            	worldIn.setBlockState(pos.up(4).east(1), Blocks.end_stone.getDefaultState());
            	worldIn.setBlockState(pos.up(5).east(1), Blocks.end_stone.getDefaultState());

            	worldIn.setBlockState(pos.up(5), Blocks.end_stone.getDefaultState());
            	worldIn.setBlockState(pos.up(5).west(1), Blocks.end_stone.getDefaultState());
            	
            	worldIn.setBlockState(pos.up(2), KCore.HeavenlyPortal.getDefaultState());
            	worldIn.setBlockState(pos.up(2).west(1), KCore.HeavenlyPortal.getDefaultState());
            	worldIn.setBlockState(pos.up(3), KCore.HeavenlyPortal.getDefaultState());
            	worldIn.setBlockState(pos.up(3).west(1), KCore.HeavenlyPortal.getDefaultState());
            	worldIn.setBlockState(pos.up(4), KCore.HeavenlyPortal.getDefaultState());
            	worldIn.setBlockState(pos.up(4).west(1), KCore.HeavenlyPortal.getDefaultState());
            	playerIn.inventory.consumeInventoryItem(this);
            }

            return false;
        }
    }

    protected boolean useHoe(ItemStack stack, EntityPlayer player, World worldIn, BlockPos target, IBlockState newState)
    {

        if (worldIn.isRemote)
        {
            return true;
        }
        else
        {
            worldIn.setBlockState(target, newState);
            stack.damageItem(1, player);
            return true;
        }
    }

    @SideOnly(Side.CLIENT)
    public boolean isFull3D()
    {
        return true;
    }
}