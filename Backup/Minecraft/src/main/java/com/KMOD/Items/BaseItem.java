package com.KMOD.Items;

import java.util.List;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import com.KMOD.Core.KCore;
import com.KMOD.Entities.EntityDarkenig;

public class BaseItem extends Item 
{
	private String Name;
	public BaseItem(String name)
	{
		this.Name = name;
		setFull3D();
        this.setCreativeTab(KCore.OHTab);
        this.maxStackSize = 64;
	}
	
    public String getName()
    {
    	return this.Name;
    }
    
    public boolean onItemUse(ItemStack stack, EntityPlayer playerIn, World worldIn, BlockPos pos, EnumFacing side, float hitX, float hitY, float hitZ)
    {
    	if(this == KCore.DarkEssence)
    	{
    		if(playerIn.inventory.hasItem(KCore.DarkEssence))
    		{
	    			EntityDarkenig ED = new EntityDarkenig(worldIn);
	    			ED.setLocationAndAngles(pos.getX(), pos.getY(), pos.getZ(), playerIn.rotationYawHead, playerIn.rotationPitch);
	    			worldIn.spawnEntityInWorld(ED);
	    			ED.setLocationAndAngles(pos.getX(), pos.getY(), pos.getZ(), playerIn.rotationYawHead, playerIn.rotationPitch);
	    			playerIn.inventory.consumeInventoryItem(KCore.DarkEssence);
	    			return true;
    		}
    		else
    		{
    			return false;
    		}
    	}
    	else
    	{
    		return true;
    	}
    }
    
    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack stack, EntityPlayer playerIn, List tooltip, boolean advanced) {
    	if(this == KCore.KetherStatue)	tooltip.add("\u00A79Really Unique Item.");
    	if(this == KCore.FireWand) tooltip.add("\u00A74Fire, Fire, Fire!");
    	if(this == KCore.FireElement) tooltip.add("\u00A7cUse It Reasonable.");
    	if(this == KCore.ForbiddenGem) tooltip.add("\u00A71Use It Reasonable.");
    	

    }
}
