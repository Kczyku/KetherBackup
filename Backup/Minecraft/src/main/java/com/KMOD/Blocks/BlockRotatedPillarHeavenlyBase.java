package com.KMOD.Blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.util.EnumFacing;

public abstract class BlockRotatedPillarHeavenlyBase extends BaseBlock
{
    public static final PropertyEnum AXIS = PropertyEnum.create("axis", EnumFacing.Axis.class);

    protected BlockRotatedPillarHeavenlyBase(String Name, Material materialIn)
    {
        super(Name, 0F, 0F);
        this.setMaterial(materialIn);
    }
}