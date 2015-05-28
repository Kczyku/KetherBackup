package com.KMOD.Entities;

import net.minecraft.block.Block;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIFollowParent;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIMate;
import net.minecraft.entity.ai.EntityAIPanic;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAITempt;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;

import com.KMOD.Core.KCore;

public class EntityStoneEater extends EntityAnimal
{
	int counter = 0;
    public EntityStoneEater(World p_i1689_1_)
    {
        super(p_i1689_1_);
        this.setSize(0.9F, 0.9F);
        this.tasks.addTask(0, new EntityAISwimming(this));
        this.tasks.addTask(1, new EntityAIPanic(this, 1.25D));
        this.tasks.addTask(2, new EntityAIMate(this, 1.0D));
        this.tasks.addTask(3, new EntityAIFollowParent(this, 1.1D));
        this.tasks.addTask(4, new EntityAIWander(this, 1.0D));
        this.tasks.addTask(5, new EntityAIWatchClosest(this, EntityPlayer.class, 6.0F));
        this.tasks.addTask(6, new EntityAILookIdle(this));
        this.tasks.addTask(7, new EntityAITempt(this, 1.2D, KCore.Ruby, false));
        this.tasks.addTask(8, new EntityAITempt(this, 1.2D, KCore.Topaz, false));
        this.tasks.addTask(9, new EntityAITempt(this, 1.2D, KCore.Sapphire, false));
        this.experienceValue = 15;
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
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(10.0D);
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.25D);
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
        return "mob.pig.say";
    }

    /**
     * Returns the sound this mob makes when it is hurt.
     */
    protected String getHurtSound()
    {
        return "mob.pig.say";
    }

    /**
     * Returns the sound this mob makes on death.
     */
    protected String getDeathSound()
    {
        return "mob.pig.death";
    }
    
    
    public void onUpdate()
    {
        super.onUpdate();

        if (!this.worldObj.isRemote)
        {
            this.updateLeashedState();
        }
        this.NewOnUpdate();
    }
    
    public void NewOnUpdate()
    {
    	counter++;
    	if(this.counter >= 5000)
    	{
    		if(worldObj.getBlockState(new BlockPos((int)posX, (int)posY - 1, (int)posZ)) == KCore.HeavenlyStone);
    		{
    			if(this.worldObj.isAirBlock(new BlockPos((int)this.posX, (int)this.posY, (int)this.posZ)))
    			{
    				this.worldObj.setBlockState(new BlockPos((int)this.posX, (int)this.posY - 1, (int)this.posZ), KCore.CrystalOre.getDefaultState());
    			}
    		}
    		counter = 1;

    	}
    	
    }

    protected void func_145780_a(int p_145780_1_, int p_145780_2_, int p_145780_3_, Block p_145780_4_)
    {
        this.playSound("mob.pig.step", 0.15F, 1.0F);
    }
    
    protected Item getDropItem()
    {
    	return Item.getItemFromBlock(KCore.HeavenlyStone);
    }


    public EntityStoneEater createChild(EntityAgeable p_90011_1_)
    {
        return new EntityStoneEater(this.worldObj);
    }

    /**
     * Checks if the parameter is an item which this animal can be fed to breed it (wheat, carrots or seeds depending on
     * the animal type)
     */
    public boolean isBreedingItem(ItemStack p_70877_1_)
    {
    	if(p_70877_1_ != null)
    	{
    		if(p_70877_1_.getItem() == KCore.Topaz || p_70877_1_.getItem() == KCore.Ruby || p_70877_1_.getItem() == KCore.Sapphire)
    		{
    			return true;
    		}
    		else
    		{
    			return false;
    		}
    	}
    	else
    	{
    		return false;
    	}	
    }

}