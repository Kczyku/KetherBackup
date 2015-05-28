package com.KMOD.Blocks;

import com.KMOD.Core.KCore;

import net.minecraft.block.properties.IProperty;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class BlockHeavenlyLog extends BlockHeavenlyLogBase
{

    public BlockHeavenlyLog(String name)
    {
    	super(name);
        this.setDefaultState(this.blockState.getBaseState().withProperty(LOG_AXIS, BlockHeavenlyLog.EnumAxis.Y));
        this.setCreativeTab(KCore.OHTab);
    }

    public IBlockState getStateFromMeta(int meta)
    {
        IBlockState iblockstate = this.getDefaultState();

        switch (meta & 12)
        {
            case 0:
                iblockstate = iblockstate.withProperty(LOG_AXIS, BlockHeavenlyLog.EnumAxis.Y);
                break;
            case 4:
                iblockstate = iblockstate.withProperty(LOG_AXIS, BlockHeavenlyLog.EnumAxis.X);
                break;
            case 8:
                iblockstate = iblockstate.withProperty(LOG_AXIS, BlockHeavenlyLog.EnumAxis.Z);
                break;
            default:
                iblockstate = iblockstate.withProperty(LOG_AXIS, BlockHeavenlyLog.EnumAxis.NONE);
        }

        return iblockstate;
    }

    public int getMetaFromState(IBlockState state)
    {
        byte b0 = 0;
        int i = b0;

        switch (BlockHeavenlyLog.SwitchEnumAxis.AXIS_LOOKUP[((BlockHeavenlyLog.EnumAxis)state.getValue(LOG_AXIS)).ordinal()])
        {
            case 1:
                i |= 4;
                break;
            case 2:
                i |= 8;
                break;
            case 3:
                i |= 12;
        }

        return i;
    }

    protected BlockState createBlockState()
    {
        return new BlockState(this, new IProperty[] {LOG_AXIS});
    }

    protected ItemStack createStackedBlock(IBlockState state)
    {
        return new ItemStack(Item.getItemFromBlock(this), 1);
    }


    static final class SwitchEnumAxis
        {
            static final int[] AXIS_LOOKUP = new int[BlockHeavenlyLog.EnumAxis.values().length];

            static
            {
                try
                {
                    AXIS_LOOKUP[BlockHeavenlyLog.EnumAxis.X.ordinal()] = 1;
                }
                catch (NoSuchFieldError var3)
                {
                    ;
                }

                try
                {
                    AXIS_LOOKUP[BlockHeavenlyLog.EnumAxis.Z.ordinal()] = 2;
                }
                catch (NoSuchFieldError var2)
                {
                    ;
                }

                try
                {
                    AXIS_LOOKUP[BlockHeavenlyLog.EnumAxis.NONE.ordinal()] = 3;
                }
                catch (NoSuchFieldError var1)
                {
                    ;
                }
            }
        }
}