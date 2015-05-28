package com.KMOD.Items;

import java.util.Set;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

import com.KMOD.Core.KCore;
import com.KMOD.Entities.EntityFloatingBlock;
import com.KMOD.Entities.EntityGravitionalOre;
import com.google.common.collect.Sets;

public class ItemMOPickaxe extends ItemMOTool
{
    private static final Set EFFECTIVE_ON = Sets.newHashSet(new Block[] {Blocks.activator_rail, Blocks.coal_ore, Blocks.cobblestone,
    Blocks.detector_rail, Blocks.diamond_block, Blocks.diamond_ore, Blocks.double_stone_slab, Blocks.golden_rail, Blocks.gold_block,
    Blocks.gold_ore, Blocks.ice, Blocks.iron_block, Blocks.iron_ore, Blocks.lapis_block, Blocks.lapis_ore, Blocks.lit_redstone_ore,
    Blocks.mossy_cobblestone, Blocks.netherrack, Blocks.packed_ice, Blocks.rail, Blocks.redstone_ore, Blocks.sandstone,
    Blocks.red_sandstone, Blocks.stone, Blocks.stone_slab, KCore.SapphireOre, KCore.TopazOre, KCore.RubyOre, KCore.TitaniumOre,
    KCore.SapphireBlock, KCore.TopazBlock, KCore.RubyBlock, KCore.TitaniumBlock, KCore.SapphireBrick, KCore.TopazBrick,
    KCore.TitaniumBrick, KCore.CrystalOre, KCore.HeavenlyStone, KCore.HeavenlyCobblestone, KCore.GravitionalBlock, KCore.GravitionalBrick,
    KCore.VolcanicRock, KCore.VolcanicBrick, KCore.Rhyolite, KCore.ProcessedRhyolite, KCore.Basalt, KCore.ProcessedBasalt,
    KCore.RhyoliteBrick, KCore.BasaltBrick, KCore.Enchanter, KCore.RunesPutter, KCore.FireElementalSpawner});

    public ItemMOPickaxe(String Name, ToolMaterial material)
    {
        super(Name, 2.0F, material, EFFECTIVE_ON);
    }

    public boolean canHarvestBlock(Block blockIn)
    {
        return true;
    }

    public float getStrVsBlock(ItemStack stack, Block block)
    {
        return block.getMaterial() != Material.iron && block.getMaterial() != Material.anvil && block.getMaterial() != Material.rock ? super.getStrVsBlock(stack, block) : this.efficiencyOnProperMaterial;
    }
    
    public boolean onBlockDestroyed(ItemStack stack, World worldIn, Block blockIn, BlockPos pos, EntityLivingBase playerIn)
    {
    	super.onBlockDestroyed(stack, worldIn, blockIn, pos, playerIn);
    	
    	if(this == KCore.GravitionalPickaxe)
    	{
    		EntityFloatingBlock efb = new EntityFloatingBlock(worldIn, pos.getX() + 0.5, pos.getY(), pos.getZ() + 0.5, blockIn.getDefaultState(), false, playerIn);
    		playerIn.worldObj.spawnEntityInWorld(efb);
    	}
    	
        return true;
    }
    
    public boolean hitEntity(ItemStack stack, EntityLivingBase target, EntityLivingBase attacker)
    {
    	if(target instanceof EntityGravitionalOre)
    	{
    		EntityGravitionalOre gravitionalore = (EntityGravitionalOre) target;
    		target.attackEntityFrom(DamageSource.causePlayerDamage((EntityPlayer) attacker), 100);
    	}
        stack.damageItem(1, attacker);
        return true;
    }
}