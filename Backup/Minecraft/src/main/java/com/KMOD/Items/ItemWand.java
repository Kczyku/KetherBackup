package com.KMOD.Items;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityLargeFireball;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.MathHelper;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import com.KMOD.Core.KCore;
import com.google.common.collect.Multimap;

public class ItemWand extends BaseItem
{
    private float damageVsEntity;
    private String Name;

    public ItemWand(String Name, int MaxDamage)
    {
    	super(Name);
    	this.Name = Name;
        this.maxStackSize = 1;
        this.setMaxDamage(MaxDamage);
        this.damageVsEntity = 3;
        this.setCreativeTab(KCore.OHTab);
    }
    
    public String getName()
    {
    	return this.Name;
    }
    
    public ItemStack onItemRightClick(ItemStack itemStackIn, World worldIn, EntityPlayer playerIn)
    {
    	if(this == KCore.FireWand)
    	{
	    	if(!worldIn.isRemote)
	    	{
	            double d1 = 4.0D;
	            Vec3 vec3 = playerIn.getLook(1.0F);
	            double d2 = -(playerIn.posX - (playerIn.posX + vec3.xCoord * d1));
	            double d3 = -(playerIn.posY - (playerIn.posY + vec3.yCoord * d1));
	            double d4 = -(playerIn.posZ - (playerIn.posZ + vec3.zCoord * d1));
	            worldIn.playAuxSFXAtEntity((EntityPlayer)null, 1008, new BlockPos(playerIn), 0);
	            EntityLargeFireball entitylargefireball = new EntityLargeFireball(worldIn, playerIn, d2, d3, d4);
	            entitylargefireball.explosionPower = 3;
	            entitylargefireball.posX = playerIn.posX + vec3.xCoord * d1;
	            entitylargefireball.posY = playerIn.posY + (double)(playerIn.height / 2.0F) + 0.5D;
	            entitylargefireball.posZ = playerIn.posZ + vec3.zCoord * d1;
	            worldIn.spawnEntityInWorld(entitylargefireball);
	            playerIn.triggerAchievement(KCore.FireWandA);
	
	    	}
    	}
    	
    	itemStackIn.damageItem(2, playerIn);
    	return itemStackIn;
    }

    public boolean hitEntity(ItemStack stack, EntityLivingBase target, EntityLivingBase attacker)
    {
        stack.damageItem(10, attacker);
        return true;
    }

    @SideOnly(Side.CLIENT)
    public boolean isFull3D()
    {
        return true;
    }


    public boolean getIsRepairable(ItemStack toRepair, ItemStack repair)
    {
    	return false;
    }

    public Multimap getItemAttributeModifiers()
    {
        Multimap multimap = super.getItemAttributeModifiers();
        multimap.put(SharedMonsterAttributes.attackDamage.getAttributeUnlocalizedName(), new AttributeModifier(itemModifierUUID, "Tool modifier", (double)this.damageVsEntity, 0));
        return multimap;
    }
}