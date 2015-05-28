package com.KMOD.Entities;

import java.util.List;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityFlying;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.ai.EntityAIControlledByPlayer;
import net.minecraft.entity.ai.EntityAIFindEntityNearestPlayer;
import net.minecraft.entity.ai.EntityMoveHelper;
import net.minecraft.entity.item.EntityBoat;
import net.minecraft.entity.monster.IMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.stats.AchievementList;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.MathHelper;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import com.KMOD.Core.KCore;

public class EntityFlyingTurtle extends EntityFlying implements IMob
{
    private final EntityAIControlledByPlayer aiControlledByPlayer;
    public boolean isMounted = false;

    public EntityFlyingTurtle(World worldIn)
    {
        super(worldIn);
        this.setSize(0.3F, 0.3F);
        this.isImmuneToFire = false;
        this.experienceValue = 50;
        this.moveHelper = new EntityFlyingTurtle.GhastMoveHelper();
        this.tasks.addTask(5, new EntityFlyingTurtle.AIRandomFly());
        this.tasks.addTask(7, new EntityFlyingTurtle.AILookAround());
        this.tasks.addTask(7, new EntityFlyingTurtle.AIFireballAttack());
        this.targetTasks.addTask(1, new EntityAIFindEntityNearestPlayer(this));
        this.tasks.addTask(8, this.aiControlledByPlayer = new EntityAIControlledByPlayer(this, 0.3F));


    }
    
    public EntityAIControlledByPlayer getAIControlledByPlayer()
    {
        return this.aiControlledByPlayer;
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
        super.onUpdate();
    	this.newUpdate();
    }
    
    
    public void newUpdate()
    {

    	if(this.riddenByEntity != null)
    	{
    		this.isMounted = true;
    	}
    	if(this.riddenByEntity == null)
    	{
    		this.isMounted = false;
    	}
        if(motionY < 0D)
        {
            this.motionY = -0.00000000000000000000001D;
        }
        
        if(motionY < 0)
        {
        	this.motionY *= -0.0001D;
        }
    	this.fallDistance = 0;
    	
    	if(!this.worldObj.isRemote)
    	{

	        if (riddenByEntity != null) //check if there is a rider
	        {
	        	int facing = MathHelper.floor_double((double)(riddenByEntity.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;

	        	if(Minecraft.getMinecraft().gameSettings.keyBindForward.isKeyDown())
	        	{
	        	float yaw = riddenByEntity.rotationYaw;
	        	float pitch = riddenByEntity.rotationPitch;
	        	float f = 1.0F;
	        	double motionX = (double)(-MathHelper.sin(yaw / 180.0F * (float)Math.PI) * MathHelper.cos(pitch / 180.0F * (float)Math.PI) * f);
	        	double motionZ = (double)(MathHelper.cos(yaw / 180.0F * (float)Math.PI) * MathHelper.cos(pitch / 180.0F * (float)Math.PI) * f);
	        	double motionY = (double)(-MathHelper.sin((pitch) / 180.0F * (float)Math.PI) * f);
	        	this.setVelocity(motionX, motionY, motionZ);
	        	
	        	}
	        }
    	}
    }
    

    
    
    
    public boolean interact(EntityPlayer ep)
    {
    	if(!this.worldObj.isRemote)
    	{
    		ep.mountEntity(this);
    		this.isMounted = true;
    		ep.triggerAchievement(KCore.FlyingATurtle);
    	}

    	return true;
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
        return KCore.Shell;
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
            this.dropItem(KCore.Shell, 1);
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

    class AIFireballAttack extends EntityAIBase
    {
        private EntityFlyingTurtle field_179470_b = EntityFlyingTurtle.this;
        public int field_179471_a;

        /**
         * Returns whether the EntityAIBase should begin execution.
         */
        public boolean shouldExecute()
        {
            return this.field_179470_b.getAttackTarget() != null;
        }

        /**
         * Execute a one shot task or start executing a continuous task
         */
        public void startExecuting()
        {
            this.field_179471_a = 0;
        }

        /**
         * Resets the task
         */
        public void resetTask()
        {
            this.field_179470_b.func_175454_a(false);
        }

        /**
         * Updates the task
         */
        public void updateTask()
        {
       
        }
    }

    class AILookAround extends EntityAIBase
    {
        private EntityFlyingTurtle field_179472_a = EntityFlyingTurtle.this;

        public AILookAround()
        {
            this.setMutexBits(2);
        }

        /**
         * Returns whether the EntityAIBase should begin execution.
         */
        public boolean shouldExecute()
        {
        	if(this.field_179472_a.isMounted)
        	{
        		return false;
        	}
        	else
        	{
            return true;
        	}
        }

        /**
         * Updates the task
         */
        public void updateTask()
        {
            if (this.field_179472_a.getAttackTarget() == null)
            {
                this.field_179472_a.renderYawOffset = this.field_179472_a.rotationYaw = -((float)Math.atan2(this.field_179472_a.motionX, this.field_179472_a.motionZ)) * 180.0F / (float)Math.PI;
            }
            else
            {
                EntityLivingBase entitylivingbase = this.field_179472_a.getAttackTarget();
                double d0 = 64.0D;

                if (entitylivingbase.getDistanceSqToEntity(this.field_179472_a) < d0 * d0)
                {
                    double d1 = entitylivingbase.posX - this.field_179472_a.posX;
                    double d2 = entitylivingbase.posZ - this.field_179472_a.posZ;
                    this.field_179472_a.renderYawOffset = this.field_179472_a.rotationYaw = -((float)Math.atan2(d1, d2)) * 180.0F / (float)Math.PI;
                }
            }
        }
    }

    class AIRandomFly extends EntityAIBase
    {
        private EntityFlyingTurtle field_179454_a = EntityFlyingTurtle.this;

        public AIRandomFly()
        {
            this.setMutexBits(1);
        }

        /**
         * Returns whether the EntityAIBase should begin execution.
         */
        public boolean shouldExecute()
        {
            EntityMoveHelper entitymovehelper = this.field_179454_a.getMoveHelper();

            if (!entitymovehelper.isUpdating())
            {
            	if(!this.field_179454_a.isMounted)
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
                double d0 = entitymovehelper.func_179917_d() - this.field_179454_a.posX;
                double d1 = entitymovehelper.func_179919_e() - this.field_179454_a.posY;
                double d2 = entitymovehelper.func_179918_f() - this.field_179454_a.posZ;
                double d3 = d0 * d0 + d1 * d1 + d2 * d2;
                return d3 < 1.0D || d3 > 3600.0D;
            }
        }

        /**
         * Returns whether an in-progress EntityAIBase should continue executing
         */
        public boolean continueExecuting()
        {
            return false;
        }

        /**
         * Execute a one shot task or start executing a continuous task
         */
        public void startExecuting()
        {
            Random random = this.field_179454_a.getRNG();
            double d0 = this.field_179454_a.posX + (double)((random.nextFloat() * 2.0F - 1.0F) * 16.0F);
            double d1 = this.field_179454_a.posY + (double)((random.nextFloat() * 2.0F - 1.0F) * 16.0F);
            double d2 = this.field_179454_a.posZ + (double)((random.nextFloat() * 2.0F - 1.0F) * 16.0F);
            this.field_179454_a.getMoveHelper().setMoveTo(d0, d1, d2, 1.0D);
        }
    }

    class GhastMoveHelper extends EntityMoveHelper
    {
        private EntityFlyingTurtle field_179927_g = EntityFlyingTurtle.this;
        private int field_179928_h;
        private static final String __OBFID = "CL_00002216";

        public GhastMoveHelper()
        {
            super(EntityFlyingTurtle.this);
        }

        public void onUpdateMoveHelper()
        {
        	if(!this.field_179927_g.isMounted)
        	{
            if (this.update)
            {
                double d0 = this.posX - this.field_179927_g.posX;
                double d1 = this.posY - this.field_179927_g.posY;
                double d2 = this.posZ - this.field_179927_g.posZ;
                double d3 = d0 * d0 + d1 * d1 + d2 * d2;

                if (this.field_179928_h-- <= 0)
                {
                    this.field_179928_h += this.field_179927_g.getRNG().nextInt(5) + 2;
                    d3 = (double)MathHelper.sqrt_double(d3);

                    if (this.func_179926_b(this.posX, this.posY, this.posZ, d3))
                    {
                        this.field_179927_g.motionX += d0 / d3 * 0.1D;
                        this.field_179927_g.motionY += d1 / d3 * 0.1D;
                        this.field_179927_g.motionZ += d2 / d3 * 0.1D;
                    }
                    else
                    {
                        this.update = false;
                    }
                }
            }
        	}
        	else
        	{
        		
        	}
        }

        private boolean func_179926_b(double p_179926_1_, double p_179926_3_, double p_179926_5_, double p_179926_7_)
        {
            double d4 = (p_179926_1_ - this.field_179927_g.posX) / p_179926_7_;
            double d5 = (p_179926_3_ - this.field_179927_g.posY) / p_179926_7_;
            double d6 = (p_179926_5_ - this.field_179927_g.posZ) / p_179926_7_;
            AxisAlignedBB axisalignedbb = this.field_179927_g.getEntityBoundingBox();

            for (int i = 1; (double)i < p_179926_7_; ++i)
            {
                axisalignedbb = axisalignedbb.offset(d4, d5, d6);

                if (!this.field_179927_g.worldObj.getCollidingBoundingBoxes(this.field_179927_g, axisalignedbb).isEmpty())
                {
                    return false;
                }
            }

            return true;
        }
    }
}