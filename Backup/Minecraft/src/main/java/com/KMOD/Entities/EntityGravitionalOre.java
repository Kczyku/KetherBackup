package com.KMOD.Entities;

import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;

import com.KMOD.Core.KCore;
import com.KMOD.Items.ItemMOPickaxe;

public class EntityGravitionalOre extends EntityAnimal
{
    public EntityGravitionalOre(World p_i1689_1_)
    {
        super(p_i1689_1_);
        this.setSize(1.0F, 1.0F);
        this.tasks.addTask(0, new EntityAILookIdle(this));
        this.experienceValue = 150;
        this.NewOnUpdate();
    }
    
    /**
     * Returns true if the newer Entity AI code should be run
     */
    public boolean isAIEnabled()
    {
        return true;
    }

    protected void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(400.0D);
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.0D);
    }

    protected void updateAITasks()
    {
        super.updateAITasks();
    }

    
    protected void entityInit()
    {
        super.entityInit();
        this.dataWatcher.addObject(16, Byte.valueOf((byte)0));
    }

    /**
     * (abstract) Protected helper method to write subclass entity data to NBT.
     */
    public void writeEntityToNBT(NBTTagCompound p_70014_1_)
    {
        super.writeEntityToNBT(p_70014_1_);
    }

    /**
     * (abstract) Protected helper method to read subclass entity data from NBT.
     */
    public void readEntityFromNBT(NBTTagCompound p_70037_1_)
    {
        super.readEntityFromNBT(p_70037_1_);
    }

    /**
     * Returns the sound this mob makes while it's alive.
     */
    protected String getLivingSound()
    {
        return null;
    }

    /**
     * Returns the sound this mob makes when it is hurt.
     */
    protected String getHurtSound()
    {
        return null;
    }

    /**
     * Returns the sound this mob makes on death.
     */
    protected String getDeathSound()
    {
        return null;
    }
    
    
    public void onUpdate()
    {    	
    	super.onUpdate();
    	this.motionX = 0;
    	this.motionZ = 0;
    	this.rotationYaw = 0;
    	this.rotationPitch = 0;
    	this.rotationYawHead = 0;
        this.NewOnUpdate();
    }
    
    public void NewOnUpdate()
    {
    	EntityPlayer el = this.worldObj.getClosestPlayer(this.posX, this.posY, this.posZ, 7F);
    	if(el != null)
    	{
            ItemStack itemstack = el.inventory.getCurrentItem();
	        if (itemstack != null && (itemstack.getItem() instanceof ItemMOPickaxe))
	        {

	        }

    	}
    	if(el == null)
    	{
    		this.setHealth(this.getMaxHealth());
    	}
    	if(this.getHealth() <= 0)
    	{
    		this.setDead();
    		el.triggerAchievement(KCore.GravitionalGemA);
    	}
    	
    	BlockPos pos = this.worldObj.getTopSolidOrLiquidBlock(new BlockPos((int)this.posX, (int)posY, (int)posZ));
    	
    	if(pos != null)
    	{
    		int DesirableY = pos.getY() + 2;
    		
    		if(this.posY > DesirableY)
    		{
    			motionY -=0.1;
    		}
    		else if(this.posY < DesirableY)
    		{
    			motionY += 0.1;
    		}
    	}
    	else
    	{
    		this.setDead();
    	}
    }
    
    @Override
    public boolean interact(EntityPlayer player)
    {
    	return false;
    }

    protected Item getDropItem()
    {
    	return KCore.GravitionalGem;
    }

	@Override
	public EntityAgeable createChild(EntityAgeable ageable)
	{
		return null;
	}



}