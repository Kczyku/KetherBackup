package com.KMOD.Entities;

import java.util.Random;

import net.minecraft.block.Block;
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
import net.minecraft.entity.boss.IBossDisplayData;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntitySmallFireball;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.BlockPos;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

import com.KMOD.Core.KCore;
import com.KMOD.HeavenGens.GenFireDungeon;

public class EntityFireElemental extends EntityMob implements IBossDisplayData
{
    private boolean field_146076_bu = false;
    private float field_146074_bv = -1.0F;
    private float field_146073_bw;
    private boolean isAngry;
    private boolean asked;
    private boolean said;
    private boolean reallyAngry;
    private double shouldHaveHealth;
    
    
	
	
	EntityAIBase eAI1 = new EntityAIAttackOnCollide(this, EntityPlayer.class, 1.0D, false);
	EntityAIBase eAI2 = new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F);
	EntityAIBase eTAI3 = new EntityAINearestAttackableTarget(this, EntityPlayer.class, true);

    public EntityFireElemental(World p_i1745_1_)
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
        this.isImmuneToFire = true;
        isAngry = false;
        asked = false;
        said = false;
        this.experienceValue = 5000;
        reallyAngry = false;
        this.shouldHaveHealth = 100;
        this.setHealth(100);

    }
    

	


    protected void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(10.0D);
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(100.0D);
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0D);
        this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(7.0D);
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
        
    	EntityPlayer el = this.worldObj.getClosestPlayer(this.posX, this.posY, this.posZ, 20F);

    	if(el != null)
    	{
	        if(this.shouldHaveHealth != this.getHealth())
	        {
	        	el.attackEntityFrom(DamageSource.generic, 5);
	        	this.shouldHaveHealth = this.getHealth();
	        	el.motionX = 3D;
	        	el.motionY = 2D;
	        	el.motionZ = -3D;
	        	this.isAngry = true;
	        }
    	}
        
        if(isAngry)
        {
        	el = this.worldObj.getClosestPlayer(this.posX, this.posY, this.posZ, 20F);
	        counter++;
	        if(el != null)
	        {
		        if(counter >= 380 && counter <= 400)
		        {
                    if(!this.worldObj.isRemote)
                    {
			            double d0 = this.getDistanceSqToEntity(el);
	                    float f = MathHelper.sqrt_float(MathHelper.sqrt_double(d0)) * 0.5F;
		                double d1 = el.posX - this.posX;
		                double d2 = el.getEntityBoundingBox().minY + (double)(el.height / 2.0F) - (this.posY + (double)(this.height / 2.0F));
		                double d3 = el.posZ - this.posZ;
	                    EntitySmallFireball entitysmallfireball = new EntitySmallFireball(this.worldObj, this, d1 + this.getRNG().nextGaussian() * (double)f, d2, d3 + this.getRNG().nextGaussian() * (double)f);
	                    entitysmallfireball.posY = this.posY + (double)(this.height / 2.0F) + 0.5D;
	                    for(int i = 0; i < 5; i++)
	                    {
	                    	this.worldObj.spawnEntityInWorld(entitysmallfireball);
	                    }
                    }
	                
                    if(this.worldObj.isRemote && !said)
                    {
		    		el.addChatMessage(new ChatComponentText("Get Ready!"));
		    		said = true;
                    }
		        }
		        if(counter >= 420)
		        {
		        	
		        	counter = 0;
		        	said = false;
                    if(!this.worldObj.isRemote)
                    {
                    	SetChamberInFire();	
                    }
		        	el.attackEntityFrom(DamageSource.generic, 3);
		        }
	        }
        }
    }
    
    
	public void setBlock(World world, int x, int y, int z, Block block, int metadata)
	{
		world.setBlockState(new BlockPos(x, y, z),  block.getDefaultState());
	}
	
    private void SetChamberInFire()
    {
    	for(int i = 0; i < 8; i++)
    	{
    		this.worldObj.setBlockState(new BlockPos(this.posX + i, this.posY - 1, this.posZ), Blocks.fire.getDefaultState());
    		this.worldObj.setBlockState(new BlockPos(this.posX - i, this.posY - 1, this.posZ), Blocks.fire.getDefaultState());
    		this.worldObj.setBlockState(new BlockPos(this.posX, this.posY - 1, this.posZ + i), Blocks.fire.getDefaultState());
    		this.worldObj.setBlockState(new BlockPos(this.posX, this.posY - 1, this.posZ - i), Blocks.fire.getDefaultState());
    	}
    }
    
    
    
    
    @Override
    public boolean interact(EntityPlayer player)
    {
    	if(!asked)
    	{
    		if(this.worldObj.isRemote)
    		{
    			player.addChatMessage(new ChatComponentText("Do you want to make me really angry?"));
    		}
    		asked = true;
    	}
    	else
    	{
    		if(this.worldObj.isRemote)
    		{
    			player.addChatMessage(new ChatComponentText("Show me your power!"));
    		}
    		this.isAngry = true;
    	}
    	return true;
    }
    
    public void onDeath(DamageSource cause)
    {
    	EntityPlayer el = this.worldObj.getClosestPlayer(this.posX, this.posY, this.posZ, 20F);
    	el.triggerAchievement(KCore.ElementKilled);
    	super.onDeath(cause);
    
    }

    public boolean attackEntityAsMob(Entity p_70652_1_)
    {
        boolean flag = super.attackEntityAsMob(p_70652_1_);
        return flag;
    }
    Random random = new Random();

    protected Item getDropItem()
    {
    	
    	this.dropItem(KCore.Crystal, 5);
    	this.dropItem(KCore.RuneBase, 3);
        this.dropItem(KCore.FrostyPeanut, 4);
        this.dropItem(KCore.CandyCotton, 6);
        this.dropItem(KCore.BitOfLuck, 10);
        this.dropItem(KCore.LightEssence, 10);
        this.dropItem(KCore.ThorsMetalPiece, 1);
        this.dropItem(Item.getItemFromBlock(KCore.VolcanicBrick), 36);
        this.dropItem(KCore.FireElement, random.nextInt(5));
        return KCore.FireRune;
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
        nbt.setBoolean("isAngry", isAngry);
    }

    /**
     * (abstract) Protected helper method to read subclass entity data from NBT.
     */
    public void readEntityFromNBT(NBTTagCompound nbt)
    {
        super.readEntityFromNBT(nbt);
        isAngry = nbt.getBoolean("isAngry");
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