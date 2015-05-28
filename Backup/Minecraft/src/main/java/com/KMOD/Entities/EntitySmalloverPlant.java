package com.KMOD.Entities;

import java.util.Random;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIMoveThroughVillage;
import net.minecraft.entity.ai.EntityAIMoveTowardsRestriction;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.passive.EntityChicken;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import MCACommonLibrary.IMCAnimatedEntity;
import MCACommonLibrary.animation.AnimationHandler;
import animations.SmallOverPlant.AnimationHandlerSmallOverPlant;

import com.KMOD.Core.KCore;

public class EntitySmalloverPlant extends EntityMob
{
    private boolean field_146076_bu = false;
    private float field_146074_bv = -1.0F;
    private float field_146073_bw;
    
	
	
	EntityAIBase eAI1 = new EntityAIAttackOnCollide(this, EntityPlayer.class, 1.0D, false);
	EntityAIBase eAI2 = new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F);
	EntityAIBase eTAI3 = new EntityAINearestAttackableTarget(this, EntityPlayer.class, true);

    public EntitySmalloverPlant(World p_i1745_1_)
    {
        super(p_i1745_1_);
        this.tasks.addTask(0, new EntityAISwimming(this));
        this.tasks.addTask(2, eAI1);
        this.tasks.addTask(4, new EntityAIAttackOnCollide(this, EntityVillager.class, 1.0D, true));
        this.tasks.addTask(5, new EntityAIMoveTowardsRestriction(this, 1.0D));
        this.tasks.addTask(6, new EntityAIMoveThroughVillage(this, 1.0D, false));
        this.tasks.addTask(7, new EntityAIWander(this, 1.0D));
        this.tasks.addTask(8, eAI2);
        this.tasks.addTask(8, new EntityAILookIdle(this));
        this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, true));
        this.targetTasks.addTask(2, eTAI3);
        this.setSize(1F, 1F);
        this.experienceValue = 50;

    }
    

	


    protected void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(10.0D);
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(15.0D);
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0D);
        this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(3.0D);
    }

    protected void entityInit()
    {
        super.entityInit();
        this.getDataWatcher().addObject(12, Byte.valueOf((byte)0));
        this.getDataWatcher().addObject(13, Byte.valueOf((byte)0));
        this.getDataWatcher().addObject(14, Byte.valueOf((byte)0));
    }

    /**
     * Returns true if the newer Entity AI code should be run
     */
    protected boolean isAIEnabled()
    {
        return true;
    }

    Random r = new Random();

    public void onLivingUpdate()
    {
        super.onLivingUpdate();
    }

    /**
     * Called to update the entity's position/logic.
     */
    
    int counter = 0;
    
    public void onUpdate()
    {
        super.onUpdate();
        this.motionX = 0;
        this.motionZ = 0;
        this.posX = this.posX;
        this.posZ = this.posZ;
        this.rotationPitch = 0;
        this.rotationYaw = 0;
        this.rotationYawHead = 0;
        
        if(counter >= 80)
        {
        	counter = 0;
        }



        
    }
    
    
    
    
    @Override
    public boolean interact(EntityPlayer player)
    {
        ItemStack itemstack = player.inventory.getCurrentItem();

        
	        if (itemstack != null && itemstack.getItem() == Items.water_bucket)
	        {
	        	if(!this.worldObj.isRemote)
	        	{
                EntityFriendlySmalloverPlant entitychicken = new EntityFriendlySmalloverPlant(this.worldObj);
                entitychicken.setLocationAndAngles(this.posX, this.posY, this.posZ, this.rotationYaw, 0.0F);
                this.worldObj.spawnEntityInWorld(entitychicken);
                
	        	this.setDead();
	        	}

	            
	            if (itemstack.stackSize-- == 1)
	            {
	                player.inventory.setInventorySlotContents(player.inventory.currentItem, new ItemStack(Items.bucket));
	            }
	            else if (!player.inventory.addItemStackToInventory(new ItemStack(Items.bucket)))
	            {
	                player.dropPlayerItemWithRandomChoice(new ItemStack(Items.bucket, 1, 0), false);
	            }
	
	            return true;
	        }
        return true;
    }
    
     

    public boolean attackEntityAsMob(Entity p_70652_1_)
    {
        boolean flag = super.attackEntityAsMob(p_70652_1_);
        return flag;
    }


    protected Item getDropItem()
    {
        return KCore.BitOfLuck;
    }

    /**
     * Get this Entity's EnumCreatureAttribute
     */
    public EnumCreatureAttribute getCreatureAttribute()
    {
        return EnumCreatureAttribute.UNDEFINED;
    }

    protected void dropRareDrop(int p_70600_1_)
    {
        switch (this.rand.nextInt(3))
        {
            case 0:
                this.dropItem(KCore.Crystal, 1);
                break;
            case 1:
                this.dropItem(KCore.FrostyPeanut, 1);
                break;
            case 2:
                this.dropItem(KCore.Crystal, 2);
        }
    }

    /**
     * (abstract) Protected helper method to write subclass entity data to NBT.
     */
    public void writeEntityToNBT(NBTTagCompound nbt)
    {
        super.writeEntityToNBT(nbt);
    }

    /**
     * (abstract) Protected helper method to read subclass entity data from NBT.
     */
    public void readEntityFromNBT(NBTTagCompound nbt)
    {
        super.readEntityFromNBT(nbt);
    }

    
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
}