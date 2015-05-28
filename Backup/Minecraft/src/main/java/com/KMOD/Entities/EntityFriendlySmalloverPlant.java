package com.KMOD.Entities;

import java.util.Random;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIMoveThroughVillage;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraftforge.fml.client.FMLClientHandler;
import MCACommonLibrary.IMCAnimatedEntity;
import MCACommonLibrary.animation.AnimationHandler;
import animations.SmallOverPlant.AnimationHandlerSmallOverPlant;

import com.KMOD.Core.KCore;
import com.KMOD.Particle.SmalloverPlantHealingParticle;

public class EntityFriendlySmalloverPlant extends EntityMob implements IMCAnimatedEntity
{
    private boolean field_146076_bu = false;
    private float field_146074_bv = -1.0F;
    private float field_146073_bw;
	protected AnimationHandler animHandler = new AnimationHandlerSmallOverPlant(this);

    
	
	EntityAIBase eAI2 = new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F);
	EntityAIBase eTAI3 = new EntityAINearestAttackableTarget(this, EntityPlayer.class, true);

    public EntityFriendlySmalloverPlant(World p_i1745_1_)
    {
        super(p_i1745_1_);
        this.tasks.addTask(0, new EntityAISwimming(this));
        this.tasks.addTask(1, new EntityAIMoveThroughVillage(this, 1.0D, false));
        this.tasks.addTask(2, new EntityAIWander(this, 1.0D));
        this.tasks.addTask(4, new EntityAILookIdle(this));
        this.tasks.addTask(5, eAI2);

        this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, true));
        this.targetTasks.addTask(2, eTAI3);

        this.setSize(1.0F, 1.0F);
        this.experienceValue = 1;

    }
    
    protected void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(0D);
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(15.0D);
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0D);
        this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(0D);
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
        
        if(!this.getAnimationHandler().isAnimationActive("RuchJezykow"))
        {
        	this.getAnimationHandler().activateAnimation("RuchJezykow", 0);
        }

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

        	EntityPlayer el = this.worldObj.getClosestPlayer(this.posX, this.posY, this.posZ, 5F);
        	
        	if(el != null)
        	{
        		
                counter++;
                if(counter == 70)
                {
                    for (int i = 0; i < 4; ++i)
                    {
                        double d0 = (double)((float)el.posX + rand.nextFloat());
                        double d1 = (double)((float)el.posY + rand.nextFloat());
                        double d2 = (double)((float)el.posZ + rand.nextFloat());
                        double d3 = ((double)rand.nextFloat() - 0.5D) * 0.5D;
                        double d4 = ((double)rand.nextFloat() - 0.5D) * 0.5D;
                        double d5 = ((double)rand.nextFloat() - 0.5D) * 0.5D;
                        int j = rand.nextInt(2) * 2 - 1;
                        

                        d2 = (double)el.posZ + 0.5D + 0.25D * (double)j;
                        d5 = (double)(rand.nextFloat() * 2.0F * (float)j);
                        
                        double d6 = (double)((float)this.posX + rand.nextFloat());
                        double d7 = (double)((float)this.posY + rand.nextFloat());
                        double d8 = (double)((float)this.posZ + rand.nextFloat());
                        d8 = (double)this.posZ + 0.5D + 0.25D * (double)j;


                        if(this.worldObj.isRemote)
                        {
	                		SmalloverPlantHealingParticle flp = new SmalloverPlantHealingParticle(this.worldObj, d0, d1, d2, d3, d4, d5);
	                		SmalloverPlantHealingParticle flp2 = new SmalloverPlantHealingParticle(this.worldObj, d6, d7, d8, d3, d4, d5);
	
	                		FMLClientHandler.instance().getClient().effectRenderer.addEffect(flp);
	                		FMLClientHandler.instance().getClient().effectRenderer.addEffect(flp2);
                        }

                		el.setHealth(el.getHealth() + 0.5F);
                    }
                }
        	
        }



        
    }
    
    
    
    
    @Override
    public boolean interact(EntityPlayer player)
    {
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
                this.dropItem(KCore.CandyCotton, 1);
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

	@Override
	public AnimationHandler getAnimationHandler() 
	{
		return this.animHandler;
	}
}