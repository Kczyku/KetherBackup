package com.KMOD.Entities;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.entity.EntityFlying;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIFindEntityNearestPlayer;
import net.minecraft.entity.monster.IMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.stats.AchievementList;
import net.minecraft.util.DamageSource;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import com.KMOD.Core.KCore;

public class EntityFloatingStone extends EntityFlying implements IMob
{
	Random random = new Random();
    public EntityFloatingStone(World worldIn)
    {
        super(worldIn);
        this.setSize(2.0F, 2.0F);
        this.isImmuneToFire = true;
        this.experienceValue = 50;
        this.targetTasks.addTask(1, new EntityAIFindEntityNearestPlayer(this));


    }
    

    @SideOnly(Side.CLIENT)
    public boolean func_110182_bF()
    {
        return this.dataWatcher.getWatchableObjectByte(16) != 0;
    }

    public void func_175454_a(boolean p_175454_1_)
    {
        this.dataWatcher.updateObject(16, Byte.valueOf((byte)(p_175454_1_ ? 1 : 0)));
    }
    

    /**
     * Called to update the entity's position/logic.
     */
    public void onUpdate()
    {
    	this.newUpdate();
    }
    
    
    public void newUpdate()
    {
    	if(this.posY > 30 && this.posY < 120)
    	{
	    	if(random.nextInt(100) == 10)
	    	{
	    		if(random.nextInt(5) == 1)   this.motionX = 1.5D;
	    		else if(random.nextInt(5) == 2) 	this.motionY = 1.5D;
	    		else if(random.nextInt(5) == 3)		this.motionY = -1.5D;
	    		else if(random.nextInt(5) == 2)		this.motionX = -1.5D;
	    		else if(random.nextInt(5) == 1)		this.motionZ = 1.5D;
	    		else if(random.nextInt(5) == 2)		this.motionZ = -1.5D;
	    	}
    	}
    	if(this.posY >= 120)
    	{
    		this.motionY = -3.5D;
    	}
    	if(this.posY <= 30)
    	{
    		this.motionY = 3.5D;
    	}
    	this.posX = this.posX +  (motionX*.3D);
    	this.posY = this.posY +  (motionY*.3D);
    	this.posZ = this.posZ +  (motionZ*.3D);
    	
    	this.motionY*=0.9;
    	this.motionX*=0.9;
    	this.motionZ*=0.9;
    	
    	EntityPlayer el = this.worldObj.getClosestPlayer(this.posX, this.posY, this.posZ, 2F);
    	if(el != null)
    	{
	    		if(el.motionY < 0.00000000000000000000000000000000000000000D)
	    		{
	    			el.motionY = 0D;
	    		}

    	}

    }
    
    public boolean interact(EntityPlayer ep)
    {
    	return false;
    }

    /**
     * Called when the entity is attacked.
     */
    public boolean attackEntityFrom(DamageSource source, float amount)
    {
        if (this.isEntityInvulnerable(source))
        {
            return false;
        }
        else if ("fireball".equals(source.getDamageType()) && source.getEntity() instanceof EntityPlayer)
        {
            super.attackEntityFrom(source, 1000.0F);
            ((EntityPlayer)source.getEntity()).triggerAchievement(AchievementList.ghast);
            return true;
        }
        else
        {
            return super.attackEntityFrom(source, amount);
        }
    }

    protected void entityInit()
    {
        super.entityInit();
        this.dataWatcher.addObject(16, Byte.valueOf((byte)0));
    }

    protected void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(20.0D);
        this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(100.0D);
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

    protected Item getDropItem()
    {
        return KCore.BitOfLuck;
    }

    /**
     * Drop 0-2 items of this living's type
     */
    protected void dropFewItems(boolean p_70628_1_, int p_70628_2_)
    {
        int j = this.rand.nextInt(2) + this.rand.nextInt(1 + p_70628_2_);
        int k;

        for (k = 0; k < j; ++k)
        {
            this.dropItem(KCore.BitOfLuck, 1);
        }

        j = this.rand.nextInt(3) + this.rand.nextInt(1 + p_70628_2_);

        for (k = 0; k < j; ++k)
        {
            this.dropItem(KCore.BitOfLuck, 1);
        }
    }

    /**
     * Returns the volume for the sounds this mob makes.
     */
    protected float getSoundVolume()
    {
        return 10.0F;
    }

    /**
     * Checks if the entity's current position is a valid location to spawn this entity.
     */
    public boolean getCanSpawnHere()
    {
        return this.rand.nextInt(20) == 0 && super.getCanSpawnHere() && this.worldObj.getDifficulty() != EnumDifficulty.PEACEFUL;
    }

    /**
     * Will return how many at most can spawn in a chunk at once.
     */
    public int getMaxSpawnedInChunk()
    {
        return 1;
    }

    /**
     * (abstract) Protected helper method to write subclass entity data to NBT.
     */
    public void writeEntityToNBT(NBTTagCompound tagCompound)
    {
        super.writeEntityToNBT(tagCompound);
    }

    /**
     * (abstract) Protected helper method to read subclass entity data from NBT.
     */
    public void readEntityFromNBT(NBTTagCompound tagCompund)
    {
        super.readEntityFromNBT(tagCompund);
    }

    public float getEyeHeight()
    {
        return 2.6F;
    }



}