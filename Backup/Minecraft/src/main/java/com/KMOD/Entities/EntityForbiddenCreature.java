package com.KMOD.Entities;

import java.util.List;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIMoveTowardsRestriction;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.boss.IBossDisplayData;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.passive.EntityTameable;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.pathfinding.PathNavigateGround;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import scala.util.Random;

import com.KMOD.Core.KCore;

public class EntityForbiddenCreature extends EntityMob implements IBossDisplayData
{

	protected boolean asked;
	protected boolean isAngry;
	protected boolean odrzucil;
	protected EntityPlayer AngriedBy;
	protected float certainHealth;
	List<Entity> entities;
    public EntityForbiddenCreature(World worldIn)
    {
        super(worldIn);
        ((PathNavigateGround)this.getNavigator()).func_179688_b(true);
        this.tasks.addTask(0, new EntityAISwimming(this));
        this.tasks.addTask(2, new EntityAIAttackOnCollide(this, EntityPlayer.class, 1.0D, false));
        this.tasks.addTask(2, this.field_175455_a);
        this.tasks.addTask(5, new EntityAIMoveTowardsRestriction(this, 1.0D));
        this.tasks.addTask(7, new EntityAIWander(this, 1.0D));
        this.tasks.addTask(8, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
        this.tasks.addTask(8, new EntityAILookIdle(this));
        this.applyEntityAI();
        this.setSize(1.0F, 2.0F);
        this.experienceValue = 15000;
        asked = false;
        isAngry = false;
        odrzucil = false;
        certainHealth = 500F;
        
    }

    protected void applyEntityAI()
    {
        this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityPlayer.class, true));
    }

    protected void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(35.0D);
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.0D);
        this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(6.0D);
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(500.0D);

    }

    protected void entityInit()
    {
        super.entityInit();
        this.getDataWatcher().addObject(12, Byte.valueOf((byte)0));
        this.getDataWatcher().addObject(13, Byte.valueOf((byte)0));
        this.getDataWatcher().addObject(14, Byte.valueOf((byte)0));
    }


    /**
     * Called frequently so the entity can update its state every tick as required. For example, zombies and skeletons
     * use this to react to sunlight and start to burn.
     */
    int counter1, counter2, counter3 = 0;
    Random random = new Random();
    public void onLivingUpdate()
    {
    	super.onLivingUpdate();
    	if(this.getHealth() != this.certainHealth)
    	{
    		this.setHealth(500);
    	}
    	EntityPlayer el = this.worldObj.getClosestPlayer(this.posX, this.posY, this.posZ, 20F);
    	if(el == null && counter3 >= 1000 && this.isAngry)
    	{
    		this.isAngry = false;
    		this.asked = false;
    		this.certainHealth = 500;
    		this.setHealth(500);
    		counter3 = 0;
    	}
    	if(AngriedBy != null)
    	{
    		counter1++;counter2++;counter3++;
    	}
    	if(isAngry && !odrzucil)
    	{
    		if(AngriedBy != null)
    		{
    			AngriedBy.motionY+=2D;
    			AngriedBy.motionZ+=2D;
    			odrzucil = true;
    		}
    	}
    	if(counter1 >= 1400)
    	{
    		odrzucil = false;
    		counter1 = 0;
    	}
    	if(counter2 >= 700)
    	{
			counter2 = 0;

    		if(this.worldObj.isRemote)
    		{
    			if(AngriedBy != null)
    			{
    				AngriedBy.addChatMessage(new ChatComponentText("Here you are."));
    			}	
    		}

    			for(int i = 0; i < 20; i++)
    			{
    		    	if(AngriedBy != null)
    		    	{
    		    		if(!this.worldObj.isRemote)
    		    		{
			    			EntityForbiddenGuardian EFG = new EntityForbiddenGuardian(this.worldObj);
			    			EFG.setLocationAndAngles(AngriedBy.posX + random.nextInt(10) - random.nextInt(10), AngriedBy.posY, AngriedBy.posZ + random.nextInt(10) - random.nextInt(10), this.rotationYawHead, this.rotationPitch);
			    			this.worldObj.spawnEntityInWorld(EFG);
    		    		}
    		    	}
    			}
    			if(AngriedBy != null && this.certainHealth == 500)
    			{
    				this.certainHealth = 400;
    				this.setHealth(400);
    			}
    			else if(AngriedBy != null && this.certainHealth == 400)
    			{
    				this.certainHealth = 300;
    				this.setHealth(300);
    			}
    			else if(AngriedBy != null && this.certainHealth == 300)
    			{
    				this.certainHealth = 200;
    				this.setHealth(200);
    			}
    			else if(AngriedBy != null && this.certainHealth == 200)
    			{
    				this.certainHealth = 100;
    				this.setHealth(100);
    			}
    			else if(AngriedBy != null && this.certainHealth == 100)
    			{
    				this.certainHealth = 0;
    				this.setHealth(0);
    				this.giveAwards(AngriedBy, new BlockPos(this.posX, posY, posZ));
    				this.setDead();			
    			}
    		
    	}
        
    	if(AngriedBy != null)
    	{
    		if(this.posY < AngriedBy.posY)
    		{
    			motionY += 0.1;
    		}
    		if(this.posY > AngriedBy.posY)
    		{
    			motionY -= 0.1;
    		}
    	}
    	
    	
    	
    	
    }
    
    protected void giveAwards(EntityPlayer winner, BlockPos pos)
    {
    	winner.triggerAchievement(KCore.ForbiddenWhat);
    	winner.worldObj.setBlockState(pos, Blocks.chest.getDefaultState());
    	TileEntity tet = winner.worldObj.getTileEntity(pos);
    	if(tet instanceof TileEntityChest)
    	{
    		TileEntityChest tec = (TileEntityChest) tet;
			int count1 = MathHelper.getRandomIntegerInRange(rand, 1, 20);
			int count2 = MathHelper.getRandomIntegerInRange(rand, 1, 20);
			int count3 = MathHelper.getRandomIntegerInRange(rand, 1, 20);
			int count4 = MathHelper.getRandomIntegerInRange(rand, 1, 20);
			int count5 = MathHelper.getRandomIntegerInRange(rand, 1, 20);
			int count6 = MathHelper.getRandomIntegerInRange(rand, 1, 20);
			int count7 = MathHelper.getRandomIntegerInRange(rand, 1, 20);
			int count8 = MathHelper.getRandomIntegerInRange(rand, 1, 7);
			int count9 = MathHelper.getRandomIntegerInRange(rand, 1, 7);
			int count10 = MathHelper.getRandomIntegerInRange(rand, 1, 10);
			int count11 = MathHelper.getRandomIntegerInRange(rand, 1, 10);
			int count12 = MathHelper.getRandomIntegerInRange(rand, 1, 10);
			int count13 = MathHelper.getRandomIntegerInRange(rand, 1, 30);
			int count14 = MathHelper.getRandomIntegerInRange(rand, 1, 15);

			if(random.nextInt(2) == 1) tec.setInventorySlotContents(0, new ItemStack(KCore.Ruby, count1));
			if(random.nextInt(2) == 1) tec.setInventorySlotContents(1, new ItemStack(KCore.Topaz, count2));
			if(random.nextInt(2) == 1) tec.setInventorySlotContents(2, new ItemStack(KCore.Sapphire, count3));
			if(random.nextInt(2) == 1) tec.setInventorySlotContents(3, new ItemStack(KCore.TitaniumIngot, count4));
			if(random.nextInt(2) == 1) tec.setInventorySlotContents(4, new ItemStack(KCore.BitOfLuck, count5));
			if(random.nextInt(2) == 1) tec.setInventorySlotContents(5, new ItemStack(KCore.LightEssence, count6));
			if(random.nextInt(2) == 1) tec.setInventorySlotContents(6, new ItemStack(KCore.DarkEssence, count7));
			if(random.nextInt(2) == 1) tec.setInventorySlotContents(7, new ItemStack(KCore.RuneBase, count8));
			if(random.nextInt(2) == 1) tec.setInventorySlotContents(8, new ItemStack(KCore.FireRune, count9));
			if(random.nextInt(2) == 1) tec.setInventorySlotContents(9, new ItemStack(KCore.GoldenEssence, count10));
			if(random.nextInt(2) == 1) tec.setInventorySlotContents(10, new ItemStack(KCore.ThorsMetalPiece, count11));
			if(random.nextInt(2) == 1) tec.setInventorySlotContents(11, new ItemStack(KCore.FireElement, count12));
			if(random.nextInt(2) == 1) tec.setInventorySlotContents(12, new ItemStack(KCore.Crystal, count13));
			if(random.nextInt(2) == 1) tec.setInventorySlotContents(13, new ItemStack(KCore.ForbiddenGem, count14));
			if(random.nextInt(2) == 1) tec.setInventorySlotContents(14, new ItemStack(KCore.TurtleArmor, 1));
			tec.setInventorySlotContents(15, new ItemStack(KCore.KetherStatue, 1));

    	}
    	
    }
    
    public boolean interact(EntityPlayer player)
    {
    	if(!asked && !isAngry)
    	{
    		if(this.worldObj.isRemote)
    		{
    			player.addChatMessage(new ChatComponentText("Are you sure? You must have Darkenig"));

    		}
            entities = worldObj.getEntitiesWithinAABB(EntityDarkenig.class, new AxisAlignedBB(posX - 16.0D, posY - 4.0D, posZ - 16.0D, posX + 17.0D, posY + 5.0D, posZ + 17.0D));
            if(entities.isEmpty())
            {
            	entities = worldObj.getEntitiesWithinAABB(EntityDarkenig.class, new AxisAlignedBB(posX - 16.0D, posY - 12.0D, posZ - 16.0D, posX + 17.0D, posY - 4.0D, posZ + 17.0D));
                if(entities.isEmpty())
                {
                	entities = worldObj.getEntitiesWithinAABB(EntityDarkenig.class, new AxisAlignedBB(posX - 16.0D, posY - 20.0D, posZ - 16.0D, posX + 17.0D, posY - 12.0D, posZ + 17.0D));             
                }
            }
            if(!entities.isEmpty())
            {
            	asked = true;
            }
    		return true;
    	}
    	else if(asked && !isAngry)
    	{
    		if(this.worldObj.isRemote)
    		{
    			player.addChatMessage(new ChatComponentText("Okkk so prepare to dead!"));
    			counter2 = 900;
    		}
			isAngry = true;
			AngriedBy = player;
    		return true;
    	}
    	return true;
    }

    /**
     * Called to update the entity's position/logic.
     */
    public void onUpdate()
    {
    	super.onUpdate();
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
        return Item.getItemFromBlock(KCore.GlowingFungus);
    }

    /**
     * Get this Entity's EnumCreatureAttribute
     */
    public EnumCreatureAttribute getCreatureAttribute()
    {
        return EnumCreatureAttribute.UNDEAD;
    }

    /**
     * (abstract) Protected helper method to write subclass entity data to NBT.
     */
    public void writeEntityToNBT(NBTTagCompound tagCompound)
    {
        super.writeEntityToNBT(tagCompound);
        tagCompound.setBoolean("asked", asked);
        tagCompound.setBoolean("isAngry", isAngry);
        tagCompound.setBoolean("odrzucil", odrzucil);
        tagCompound.setFloat("certainHealth", certainHealth);
    }

    /**
     * (abstract) Protected helper method to read subclass entity data from NBT.
     */
    public void readEntityFromNBT(NBTTagCompound tagCompund)
    {
        super.readEntityFromNBT(tagCompund);
        asked = tagCompund.getBoolean("asked");
        isAngry = tagCompund.getBoolean("isAngry");
        odrzucil = tagCompund.getBoolean("odrzucil");
        certainHealth = tagCompund.getFloat("certainHealth");

    }


    /**
     * Called when a player interacts with a mob. e.g. gets milk from a cow, gets into the saddle on a pig.
     */

}