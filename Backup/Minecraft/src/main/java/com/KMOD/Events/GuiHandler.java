package com.KMOD.Events;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

import com.KMOD.TileEntity.TileEntityEnchanter;
import com.KMOD.TileEntity.TileEntityRottenLog;
import com.KMOD.TileEntity.TileEntityRunesPutter;
import com.KMOD.gui.GuiEnchanter;
import com.KMOD.gui.GuiRottenLog;
import com.KMOD.gui.GuiRunesPutter;
import com.KMOD.inventory.ContainerEnchanter;
import com.KMOD.inventory.ContainerRottenLog;
import com.KMOD.inventory.ContainerRunesPutter;

public class GuiHandler implements IGuiHandler
{
	@Override
	public Object getServerGuiElement(int id, EntityPlayer player, World world, int x, int y, int z)
	{
		TileEntity tile_entity = world.getTileEntity(new BlockPos(x,y,z));
		switch(id)
		{
		case 1: return new ContainerEnchanter(player.inventory, (TileEntityEnchanter) tile_entity);
		case 2: return new ContainerRottenLog(player.inventory, (TileEntityRottenLog) tile_entity);
		case 3: return new ContainerRunesPutter(player.inventory, (TileEntityRunesPutter) tile_entity);
		}
		return null;
	}
	
	@Override
	public Object getClientGuiElement(int id, EntityPlayer player, World world, int x, int y, int z)
	{
		TileEntity tile_entity = world.getTileEntity(new BlockPos(x,y,z));
		switch(id)
		{
		case 1: return new GuiEnchanter(player.inventory, (TileEntityEnchanter) tile_entity);
		case 2: return new GuiRottenLog(player.inventory, (TileEntityRottenLog) tile_entity);
		case 3: return new GuiRunesPutter(player.inventory, (TileEntityRunesPutter) tile_entity);
		}
		return null;
	}
}