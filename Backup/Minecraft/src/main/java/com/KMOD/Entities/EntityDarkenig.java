package com.KMOD.Entities;

import java.util.Calendar;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIFollowOwner;
import net.minecraft.entity.passive.EntityTameable;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.BlockPos;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

public class EntityDarkenig extends EntityTameable
{
	
	
    /** Coordinates of where the bat spawned. */
    private BlockPos spawnPosition;
    Random random = new Random();

    public EntityDarkenig(World worldIn)
    {
        super(worldIn);
        this.setSize(0.3F, 0.3F);  
        this.tasks.addTask(1, new EntityAIFollowOwner(this, 1.0D, 10.0F, 2.0F));
    }

    protected void entityInit()
    {
        super.entityInit();
    }

    /**
     * Returns the volume for the sounds this mob makes.
     */
    protected float getSoundVolume()
    {
        return 0;
    }

    /**
     * Gets the pitch of living sounds in living entities.
     */
    protected float getSoundPitch()
    {
        return 0;
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

    /**
     * Returns true if this entity should push and be pushed by other entities when colliding.
     */
    public boolean canBePushed()
    {
        return false;
    }

    protected void collideWithEntity(Entity p_82167_1_) {}

    protected void collideWithNearbyEntities() {}

    protected void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(20.0D);
    }


    /**
     * Called to update the entity's position/logic.
     */
    int counter = 0;
    public void onUpdate()
    {
        super.onUpdate();
        posY = this.worldObj.getTopSolidOrLiquidBlock(new BlockPos(this.posX, this.posY, this.posZ)).getY() + 1;
    	EntityPlayer el = this.worldObj.getClosestPlayer(this.posX, this.posY, this.posZ, 2F);
        if(!this.isTamed() && el!= null)
        {
            this.setTamed(true);
            this.navigator.clearPathEntity();
            this.setAttackTarget((EntityLivingBase)null);
            this.setHealth(20.0F);
            this.setOwnerId(el.getUniqueID().toString());
            this.playTameEffect(true);
            this.worldObj.setEntityState(this, (byte)7);
        }
        

        
    	EntityPlayer el2 = this.worldObj.getClosestPlayer(this.posX, this.posY, this.posZ, 30F);
    	if(el == null && el2 != null && this.isTamed())
    	{
    		if(el2 == this.getOwner())
    		{
    			this.setLocationAndAngles(el2.posX, el2.posY, el2.posZ, el2.rotationYawHead, el2.rotationPitch);
    			if(el2.getHealth() != el2.getMaxHealth())
    			{
    				this.attackEntityFrom(DamageSource.generic, 5);
    			}
    		}
    	}
    	counter++;
    	if(counter >= 500)
    	{
    		if(el != null)
    		{
    			el2.heal(1F);
    		}
    		counter = 0;
    	}

    }
    

    /**
     * returns if this entity triggers Block.onEntityWalking on the blocks they walk on. used for spiders and wolves to
     * prevent them from trampling crops
     */
    protected boolean canTriggerWalking()
    {
        return false;
    }

    public void fall(float distance, float damageMultiplier) {}

    protected void func_180433_a(double p_180433_1_, boolean p_180433_3_, Block p_180433_4_, BlockPos p_180433_5_) {}

    /**
     * Return whether this entity should NOT trigger a pressure plate or a tripwire.
     */
    public boolean doesEntityNotTriggerPressurePlate()
    {
        return true;
    }

    /**
     * Called when the entity is attacked.
     */
    public boolean attackEntityFrom(DamageSource source, float amount)
    {
            return super.attackEntityFrom(source, amount);
    }

    /**
     * (abstract) Protected helper method to read subclass entity data from NBT.
     */
    public void readEntityFromNBT(NBTTagCompound tagCompund)
    {
        super.readEntityFromNBT(tagCompund);
        
    }

    /**
     * (abstract) Protected helper method to write subclass entity data to NBT.
     */
    public void writeEntityToNBT(NBTTagCompound tagCompound)
    {
        super.writeEntityToNBT(tagCompound);
    }

    /**
     * Checks if the entity's current position is a valid location to spawn this entity.
     */
    public boolean getCanSpawnHere()
    {
    	return true;
    }

    private boolean func_175569_a(Calendar p_175569_1_)
    {
        return p_175569_1_.get(2) + 1 == 10 && p_175569_1_.get(5) >= 20 || p_175569_1_.get(2) + 1 == 11 && p_175569_1_.get(5) <= 3;
    }

    public float getEyeHeight()
    {
        return this.height / 2.0F;
    }

	@Override
	public EntityAgeable createChild(EntityAgeable ageable) 
	{
		return null;
	}
}