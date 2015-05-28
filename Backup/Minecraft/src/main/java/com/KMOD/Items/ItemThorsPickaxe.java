package com.KMOD.Items;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

import com.KMOD.Core.KCore;

public class ItemThorsPickaxe extends ItemMOPickaxe
{
	Random random = new Random();

    public ItemThorsPickaxe(String Name, ToolMaterial material)
    {
        super(Name, material);
    }
    private int mode = 0;

    public boolean canHarvestBlock(Block blockIn)
    {
        return blockIn == Blocks.obsidian ? this.toolMaterial.getHarvestLevel() == 3 : (blockIn != Blocks.diamond_block && blockIn != Blocks.diamond_ore ? (blockIn != Blocks.emerald_ore && blockIn != Blocks.emerald_block ? (blockIn != Blocks.gold_block && blockIn != Blocks.gold_ore ? (blockIn != Blocks.iron_block && blockIn != Blocks.iron_ore ? (blockIn != Blocks.lapis_block && blockIn != Blocks.lapis_ore ? (blockIn != Blocks.redstone_ore && blockIn != Blocks.lit_redstone_ore ? (blockIn.getMaterial() == Material.rock ? true : (blockIn.getMaterial() == Material.iron ? true : blockIn.getMaterial() == Material.anvil)) : this.toolMaterial.getHarvestLevel() >= 2) : this.toolMaterial.getHarvestLevel() >= 1) : this.toolMaterial.getHarvestLevel() >= 1) : this.toolMaterial.getHarvestLevel() >= 2) : this.toolMaterial.getHarvestLevel() >= 2) : this.toolMaterial.getHarvestLevel() >= 2);
    }

    public float getStrVsBlock(ItemStack stack, Block block)
    {
        return block.getMaterial() != Material.iron && block.getMaterial() != Material.anvil && block.getMaterial() != Material.rock ? super.getStrVsBlock(stack, block) : this.efficiencyOnProperMaterial;
    }
    
    public boolean onBlockDestroyed(ItemStack stack, World worldIn, Block blockIn, BlockPos pos, EntityLivingBase playerIn)
    {
    	
        if ((double)blockIn.getBlockHardness(worldIn, pos) != 0.0D)
        {
	        	int var6 = MathHelper.floor_double((double)(playerIn.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;
	        	if(mode == 0 || mode == 2)
	        	{
		        	if(var6 == 1 || var6 == 3)
		        	{
		        		if(!worldIn.isRemote)
		        		{
		        		worldIn.spawnEntityInWorld(new EntityItem(worldIn, pos.getX(), pos.getY(), pos.getZ(), new ItemStack(worldIn.getBlockState(new BlockPos(pos.getX(), pos.getY(), pos.getZ() + 1)).getBlock().getItemDropped(worldIn.getBlockState(new BlockPos(pos.getX(), pos.getY(), pos.getZ() + 1)), random, 0))));
		        		worldIn.spawnEntityInWorld(new EntityItem(worldIn, pos.getX(), pos.getY(), pos.getZ(), new ItemStack(worldIn.getBlockState(new BlockPos(pos.getX(), pos.getY(), pos.getZ() - 1)).getBlock().getItemDropped(worldIn.getBlockState(new BlockPos(pos.getX(), pos.getY(), pos.getZ() - 1)), random, 0))));
		        		worldIn.spawnEntityInWorld(new EntityItem(worldIn, pos.getX(), pos.getY(), pos.getZ(), new ItemStack(worldIn.getBlockState(new BlockPos(pos.getX(), pos.getY() + 1, pos.getZ() - 1)).getBlock().getItemDropped(worldIn.getBlockState(new BlockPos(pos.getX(), pos.getY() + 1, pos.getZ() - 1)), random, 0))));
		        		worldIn.spawnEntityInWorld(new EntityItem(worldIn, pos.getX(), pos.getY(), pos.getZ(), new ItemStack(worldIn.getBlockState(new BlockPos(pos.getX(), pos.getY() + 1, pos.getZ() + 1)).getBlock().getItemDropped(worldIn.getBlockState(new BlockPos(pos.getX(), pos.getY() + 1, pos.getZ() + 1)), random, 0))));
		        		worldIn.spawnEntityInWorld(new EntityItem(worldIn, pos.getX(), pos.getY(), pos.getZ(), new ItemStack(worldIn.getBlockState(new BlockPos(pos.getX(), pos.getY() + 1, pos.getZ())).getBlock().getItemDropped(worldIn.getBlockState(new BlockPos(pos.getX(), pos.getY() + 1, pos.getZ())), random, 0))));
		        		worldIn.spawnEntityInWorld(new EntityItem(worldIn, pos.getX(), pos.getY(), pos.getZ(), new ItemStack(worldIn.getBlockState(new BlockPos(pos.getX(), pos.getY() - 1, pos.getZ())).getBlock().getItemDropped(worldIn.getBlockState(new BlockPos(pos.getX(), pos.getY() - 1, pos.getZ())), random, 0))));
		        		worldIn.spawnEntityInWorld(new EntityItem(worldIn, pos.getX(), pos.getY(), pos.getZ(), new ItemStack(worldIn.getBlockState(new BlockPos(pos.getX(), pos.getY() - 1, pos.getZ() - 1)).getBlock().getItemDropped(worldIn.getBlockState(new BlockPos(pos.getX(), pos.getY() - 1, pos.getZ() - 1)), random, 0))));
		        		worldIn.spawnEntityInWorld(new EntityItem(worldIn, pos.getX(), pos.getY(), pos.getZ(), new ItemStack(worldIn.getBlockState(new BlockPos(pos.getX(), pos.getY() - 1, pos.getZ() + 1)).getBlock().getItemDropped(worldIn.getBlockState(new BlockPos(pos.getX(), pos.getY() - 1, pos.getZ() + 1)), random, 0))));
		        		worldIn.spawnEntityInWorld(new EntityItem(worldIn, pos.getX(), pos.getY(), pos.getZ(), new ItemStack(worldIn.getBlockState(new BlockPos(pos.getX(), pos.getY(), pos.getZ())).getBlock().getItemDropped(worldIn.getBlockState(new BlockPos(pos.getX(), pos.getY(), pos.getZ())), random, 0))));
		        		}
		        		
		        		worldIn.setBlockToAir(new BlockPos(pos.getX(), pos.getY(), pos.getZ()));
		        		worldIn.setBlockToAir(new BlockPos(pos.getX(), pos.getY(), pos.getZ() + 1));
		        		worldIn.setBlockToAir(new BlockPos(pos.getX(), pos.getY(), pos.getZ() - 1));
		        		worldIn.setBlockToAir(new BlockPos(pos.getX(), pos.getY() + 1, pos.getZ() - 1));
		        		worldIn.setBlockToAir(new BlockPos(pos.getX(), pos.getY() + 1, pos.getZ() + 1));
		        		worldIn.setBlockToAir(new BlockPos(pos.getX(), pos.getY() + 1, pos.getZ()));
		        		worldIn.setBlockToAir(new BlockPos(pos.getX(), pos.getY() - 1, pos.getZ()));
		        		worldIn.setBlockToAir(new BlockPos(pos.getX(), pos.getY() - 1, pos.getZ() - 1));
		        		worldIn.setBlockToAir(new BlockPos(pos.getX(), pos.getY() - 1, pos.getZ() + 1));
		        		
		        	}
		        	else if(var6 == 0 || var6 == 2)
		        	{
		        		if(!worldIn.isRemote)
		        		{
		        		worldIn.spawnEntityInWorld(new EntityItem(worldIn, pos.getX(), pos.getY(), pos.getZ(), new ItemStack(worldIn.getBlockState(new BlockPos(pos.getX() + 1, pos.getY(), pos.getZ())).getBlock().getItemDropped(worldIn.getBlockState(new BlockPos(pos.getX() + 1, pos.getY(), pos.getZ())), random, 0))));
		        		worldIn.spawnEntityInWorld(new EntityItem(worldIn, pos.getX(), pos.getY(), pos.getZ(), new ItemStack(worldIn.getBlockState(new BlockPos(pos.getX() - 1, pos.getY(), pos.getZ())).getBlock().getItemDropped(worldIn.getBlockState(new BlockPos(pos.getX() - 1, pos.getY(), pos.getZ())), random, 0))));
		        		worldIn.spawnEntityInWorld(new EntityItem(worldIn, pos.getX(), pos.getY(), pos.getZ(), new ItemStack(worldIn.getBlockState(new BlockPos(pos.getX() - 1, pos.getY() + 1, pos.getZ())).getBlock().getItemDropped(worldIn.getBlockState(new BlockPos(pos.getX() - 1, pos.getY() + 1, pos.getZ())), random, 0))));
		        		worldIn.spawnEntityInWorld(new EntityItem(worldIn, pos.getX(), pos.getY(), pos.getZ(), new ItemStack(worldIn.getBlockState(new BlockPos(pos.getX() + 1, pos.getY()+1, pos.getZ())).getBlock().getItemDropped(worldIn.getBlockState(new BlockPos(pos.getX() + 1, pos.getY() + 1, pos.getZ())), random, 0))));
		        		worldIn.spawnEntityInWorld(new EntityItem(worldIn, pos.getX(), pos.getY(), pos.getZ(), new ItemStack(worldIn.getBlockState(new BlockPos(pos.getX(), pos.getY() + 1, pos.getZ())).getBlock().getItemDropped(worldIn.getBlockState(new BlockPos(pos.getX(), pos.getY() + 1, pos.getZ())), random, 0))));
		        		worldIn.spawnEntityInWorld(new EntityItem(worldIn, pos.getX(), pos.getY(), pos.getZ(), new ItemStack(worldIn.getBlockState(new BlockPos(pos.getX(), pos.getY() - 1, pos.getZ())).getBlock().getItemDropped(worldIn.getBlockState(new BlockPos(pos.getX(), pos.getY() - 1, pos.getZ())), random, 0))));
		        		worldIn.spawnEntityInWorld(new EntityItem(worldIn, pos.getX(), pos.getY(), pos.getZ(), new ItemStack(worldIn.getBlockState(new BlockPos(pos.getX() - 1, pos.getY() - 1, pos.getZ())).getBlock().getItemDropped(worldIn.getBlockState(new BlockPos(pos.getX() - 1, pos.getY() - 1, pos.getZ())), random, 0))));
		        		worldIn.spawnEntityInWorld(new EntityItem(worldIn, pos.getX(), pos.getY(), pos.getZ(), new ItemStack(worldIn.getBlockState(new BlockPos(pos.getX() + 1, pos.getY() - 1, pos.getZ())).getBlock().getItemDropped(worldIn.getBlockState(new BlockPos(pos.getX() + 1, pos.getY() - 1, pos.getZ())), random, 0))));
		        		worldIn.spawnEntityInWorld(new EntityItem(worldIn, pos.getX(), pos.getY(), pos.getZ(), new ItemStack(worldIn.getBlockState(new BlockPos(pos.getX(), pos.getY(), pos.getZ())).getBlock().getItemDropped(worldIn.getBlockState(new BlockPos(pos.getX(), pos.getY(), pos.getZ())), random, 0))));
		        		}
		        		
		        		worldIn.setBlockToAir(new BlockPos(pos.getX(), pos.getY(), pos.getZ()));
		        		worldIn.setBlockToAir(new BlockPos(pos.getX() + 1, pos.getY(), pos.getZ()));
		        		worldIn.setBlockToAir(new BlockPos(pos.getX() - 1, pos.getY(), pos.getZ()));
		        		worldIn.setBlockToAir(new BlockPos(pos.getX() - 1, pos.getY() + 1, pos.getZ()));
		        		worldIn.setBlockToAir(new BlockPos(pos.getX() + 1, pos.getY() + 1, pos.getZ()));
		        		worldIn.setBlockToAir(new BlockPos(pos.getX(), pos.getY() + 1, pos.getZ()));
		        		worldIn.setBlockToAir(new BlockPos(pos.getX(), pos.getY() - 1, pos.getZ()));
		        		worldIn.setBlockToAir(new BlockPos(pos.getX() - 1, pos.getY() - 1, pos.getZ()));
		        		worldIn.setBlockToAir(new BlockPos(pos.getX() + 1, pos.getY() - 1, pos.getZ()));

		        	}
	        	}
	        	else if(mode == 1)
	        	{
	        		if(!worldIn.isRemote)
	        		{
	        		worldIn.spawnEntityInWorld(new EntityItem(worldIn, pos.getX(), pos.getY(), pos.getZ(), new ItemStack(worldIn.getBlockState(new BlockPos(pos.getX() + 1, pos.getY(), pos.getZ())).getBlock().getItemDropped(worldIn.getBlockState(new BlockPos(pos.getX() + 1, pos.getY(), pos.getZ())), random, 0))));
	        		worldIn.spawnEntityInWorld(new EntityItem(worldIn, pos.getX(), pos.getY(), pos.getZ(), new ItemStack(worldIn.getBlockState(new BlockPos(pos.getX() - 1, pos.getY(), pos.getZ())).getBlock().getItemDropped(worldIn.getBlockState(new BlockPos(pos.getX() - 1, pos.getY(), pos.getZ())), random, 0))));
	        		worldIn.spawnEntityInWorld(new EntityItem(worldIn, pos.getX(), pos.getY(), pos.getZ(), new ItemStack(worldIn.getBlockState(new BlockPos(pos.getX(), pos.getY(), pos.getZ() + 1)).getBlock().getItemDropped(worldIn.getBlockState(new BlockPos(pos.getX(), pos.getY(), pos.getZ() + 1)), random, 0))));
	        		worldIn.spawnEntityInWorld(new EntityItem(worldIn, pos.getX(), pos.getY(), pos.getZ(), new ItemStack(worldIn.getBlockState(new BlockPos(pos.getX(), pos.getY(), pos.getZ() - 1)).getBlock().getItemDropped(worldIn.getBlockState(new BlockPos(pos.getX(), pos.getY(), pos.getZ() - 1)), random, 0))));
	        		worldIn.spawnEntityInWorld(new EntityItem(worldIn, pos.getX(), pos.getY(), pos.getZ(), new ItemStack(worldIn.getBlockState(new BlockPos(pos.getX() + 1, pos.getY(), pos.getZ() - 1)).getBlock().getItemDropped(worldIn.getBlockState(new BlockPos(pos.getX() + 1, pos.getY(), pos.getZ() - 1)), random, 0))));
	        		worldIn.spawnEntityInWorld(new EntityItem(worldIn, pos.getX(), pos.getY(), pos.getZ(), new ItemStack(worldIn.getBlockState(new BlockPos(pos.getX() + 1, pos.getY(), pos.getZ() + 1)).getBlock().getItemDropped(worldIn.getBlockState(new BlockPos(pos.getX() + 1, pos.getY(), pos.getZ() + 1)), random, 0))));
	        		worldIn.spawnEntityInWorld(new EntityItem(worldIn, pos.getX(), pos.getY(), pos.getZ(), new ItemStack(worldIn.getBlockState(new BlockPos(pos.getX() - 1, pos.getY(), pos.getZ() + 1)).getBlock().getItemDropped(worldIn.getBlockState(new BlockPos(pos.getX() - 1, pos.getY(), pos.getZ() + 1)), random, 0))));
	        		worldIn.spawnEntityInWorld(new EntityItem(worldIn, pos.getX(), pos.getY(), pos.getZ(), new ItemStack(worldIn.getBlockState(new BlockPos(pos.getX() - 1, pos.getY(), pos.getZ() - 1)).getBlock().getItemDropped(worldIn.getBlockState(new BlockPos(pos.getX() - 1, pos.getY(), pos.getZ() - 1)), random, 0))));
	        		worldIn.spawnEntityInWorld(new EntityItem(worldIn, pos.getX(), pos.getY(), pos.getZ(), new ItemStack(worldIn.getBlockState(new BlockPos(pos.getX(), pos.getY(), pos.getZ())).getBlock().getItemDropped(worldIn.getBlockState(new BlockPos(pos.getX(), pos.getY(), pos.getZ())), random, 0))));
	        		}
	        		
	        		worldIn.setBlockToAir(new BlockPos(pos.getX(), pos.getY(), pos.getZ()));
	        		worldIn.setBlockToAir(new BlockPos(pos.getX() + 1, pos.getY(), pos.getZ()));
	        		worldIn.setBlockToAir(new BlockPos(pos.getX() - 1, pos.getY(), pos.getZ()));
	        		worldIn.setBlockToAir(new BlockPos(pos.getX(), pos.getY(), pos.getZ() + 1));
	        		worldIn.setBlockToAir(new BlockPos(pos.getX(), pos.getY(), pos.getZ() - 1));
	        		worldIn.setBlockToAir(new BlockPos(pos.getX() + 1, pos.getY(), pos.getZ() - 1));
	        		worldIn.setBlockToAir(new BlockPos(pos.getX() + 1, pos.getY(), pos.getZ() + 1));
	        		worldIn.setBlockToAir(new BlockPos(pos.getX() - 1, pos.getY(), pos.getZ() + 1));
	        		worldIn.setBlockToAir(new BlockPos(pos.getX() - 1, pos.getY(), pos.getZ() - 1));

	        	}

        	
            stack.damageItem(1, playerIn);
        }
        
        

        return true;
    }
    
    public ItemStack onItemRightClick(ItemStack itemStackIn, World worldIn, EntityPlayer playerIn)
    {
    	if(!worldIn.isRemote)
    	{
    		mode++;
    	}
    	if(!worldIn.isRemote)
    	{
	    	if(mode == 0 || mode == 2)
	    	{
	    		if(!worldIn.isRemote)
	        	Minecraft.getMinecraft().thePlayer.sendChatMessage("Changed To Normal Mode");	
	    	}
	    	else if(mode == 1)
	    	{
	    		if(!worldIn.isRemote)
	        	Minecraft.getMinecraft().thePlayer.sendChatMessage("Changed To Up/Down Mode");	
	    	}
	    	else if(mode == 3)
			{
				mode = 1;
	        	Minecraft.getMinecraft().thePlayer.sendChatMessage("Changed To Up/Down Mode");	
			}
    	}
    	
        return itemStackIn;
    }
}
