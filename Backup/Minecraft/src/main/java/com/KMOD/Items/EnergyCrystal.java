package com.KMOD.Items;

import java.util.List;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;

import com.KMOD.Core.KCore;

public class EnergyCrystal extends BaseItem
{
	private float EnergyPoints;
	public EnergyCrystal(String name)
	{
		super(name);
		setFull3D();
        this.setCreativeTab(KCore.OHTab);
        this.maxStackSize = 1;
        EnergyPoints = 0;
	}
	
	public void setEnergyPoints(int i)
	{
		this.EnergyPoints = i;
	}
	
	public void clearEnergyPoints()
	{
		this.EnergyPoints = 0;
	}
	
	public void substractEnergyPoints(int i)
	{
		this.EnergyPoints -= i;
	}
	
	public float getEnergyPoints()
	{
		return this.EnergyPoints;
	}
}
