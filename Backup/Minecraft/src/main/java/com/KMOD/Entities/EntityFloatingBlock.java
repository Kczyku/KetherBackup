package com.KMOD.Entities;

import scala.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.crash.CrashReportCategory;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.Blocks;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.BlockPos;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class EntityFloatingBlock extends Entity
{
    private IBlockState fallTile;
    public int fallTime;
    public boolean shouldDropItem = true;
    private boolean field_145808_f;
    private boolean hurtEntities;
    private int fallHurtMax = 40;
    private float fallHurtAmount = 2.0F;
    public NBTTagCompound tileEntityData;
    private boolean WBok;
    private EntityLivingBase player;

    public EntityFloatingBlock(World worldIn)
    {
        super(worldIn);
    }

    public EntityFloatingBlock(World worldIn, double x, double y, double z, IBlockState fallingBlockState, boolean wbok, EntityLivingBase player1)
    {
        super(worldIn);
        this.fallTile = fallingBlockState;
        this.preventEntitySpawning = true;
        this.setSize(0.98F, 0.98F);
        this.setPosition(x, y, z);
        this.motionX = 0.0D;
        this.motionY = 0.0D;
        this.motionZ = 0.0D;
        this.prevPosX = x;
        this.prevPosY = y;
        this.prevPosZ = z;
        WBok = wbok;
        player = player1;
    }

    /**
     * returns if this entity triggers Block.onEntityWalking on the blocks they walk on. used for spiders and wolves to
     * prevent them from trampling crops
     */
    protected boolean canTriggerWalking()
    {
        return false;
    }

    protected void entityInit() {}

    /**
     * Returns true if other Entities should be prevented from moving through this Entity.
     */
    public boolean canBeCollidedWith()
    {
        return !this.isDead;
    }

    /**
     * Called to update the entity's position/logic.
     */
	Random random = new Random();
	int k = random.nextInt(4);
    int counter = 0;
    public void onUpdate()
    {
    	if(this.posY >= 254)
    	{
    		this.setDead();
    	}
    	BlockPos blockpos1 = new BlockPos(this.posX, this.posY, this.posZ);
        if (!this.worldObj.isAirBlock(blockpos1.up()) && !WBok)
        {
        	this.setDead();
        }
        
        if(WBok)
        {
        	counter++;
        	if(counter >= 60)
        	{
        		this.setDead();
        	}
        }

    
        Block block = this.fallTile.getBlock();

        if (block.getMaterial() == Material.air)
        {
            this.setDead();
        }
        else
        {
            this.prevPosX = this.posX;
            this.prevPosY = this.posY;
            this.prevPosZ = this.posZ;
            BlockPos blockpos;

            if (this.fallTime++ == 0)
            {
                blockpos = new BlockPos(this);

                if (this.worldObj.getBlockState(blockpos).getBlock() == block)
                {
                    this.worldObj.setBlockToAir(blockpos);
                }
                else if (!this.worldObj.isRemote)
                {
                    this.setDead();
                    return;
                }
            }
            
            if(!WBok)
            {
                this.motionY = 0.23999999910593033D;
                this.motionY *= 1.4900000190734863D;

            }
            else
            {
            	if((!this.worldObj.isAirBlock(blockpos1.south()) || !this.worldObj.isAirBlock(blockpos1.west()) ||
            			!this.worldObj.isAirBlock(blockpos1.north()) || !this.worldObj.isAirBlock(blockpos1.east())) && counter >= 10)
            	{
            		this.setDead();
            	}

            	if(k == 0)
            	{
                this.motionZ = 0.23999999910593033D;
                this.motionZ *= 1.4900000190734863D;
            	}
            	else if(k == 1)
            	{
                    this.motionZ = -0.23999999910593033D;
                    this.motionZ *= -1.4900000190734863D;
            	}
            	else if(k == 2)
            	{
                    this.motionX = 0.23999999910593033D;
                    this.motionX *= 1.4900000190734863D;
            	}
            	else if(k == 3)
            	{
                    this.motionX = -0.23999999910593033D;
                    this.motionX *= -1.4900000190734863D;
            	}
	        }

            this.moveEntity(this.motionX, this.motionY, this.motionZ);
            this.motionX *= 0.9800000190734863D;
            this.motionZ *= 0.9800000190734863D;

            if (!this.worldObj.isRemote)
            {
                blockpos = new BlockPos(this);

                if (!this.worldObj.isAirBlock(blockpos.up()))
                {
                	this.setDead();

                }
            }
        }
    }


    /**
     * (abstract) Protected helper method to write subclass entity data to NBT.
     */
    protected void writeEntityToNBT(NBTTagCompound tagCompound)
    {
        Block block = this.fallTile != null ? this.fallTile.getBlock() : Blocks.air;
        ResourceLocation resourcelocation = (ResourceLocation)Block.blockRegistry.getNameForObject(block);
        tagCompound.setString("Block", resourcelocation == null ? "" : resourcelocation.toString());
        tagCompound.setByte("Data", (byte)block.getMetaFromState(this.fallTile));
        tagCompound.setByte("Time", (byte)this.fallTime);
        tagCompound.setBoolean("DropItem", this.shouldDropItem);
        tagCompound.setBoolean("HurtEntities", this.hurtEntities);
        tagCompound.setFloat("FallHurtAmount", this.fallHurtAmount);
        tagCompound.setInteger("FallHurtMax", this.fallHurtMax);
        tagCompound.setBoolean("WBok", this.WBok);

        if (this.tileEntityData != null)
        {
            tagCompound.setTag("TileEntityData", this.tileEntityData);
        }
    }

    /**
     * (abstract) Protected helper method to read subclass entity data from NBT.
     */
    protected void readEntityFromNBT(NBTTagCompound tagCompund)
    {
        int i = tagCompund.getByte("Data") & 255;

        if (tagCompund.hasKey("Block", 8))
        {
            this.fallTile = Block.getBlockFromName(tagCompund.getString("Block")).getStateFromMeta(i);
        }
        else if (tagCompund.hasKey("TileID", 99))
        {
            this.fallTile = Block.getBlockById(tagCompund.getInteger("TileID")).getStateFromMeta(i);
        }
        else
        {
            this.fallTile = Block.getBlockById(tagCompund.getByte("Tile") & 255).getStateFromMeta(i);
        }
        this.WBok = tagCompund.getBoolean("WBok");

        this.fallTime = tagCompund.getByte("Time") & 255;
        Block block = this.fallTile.getBlock();

        if (tagCompund.hasKey("HurtEntities", 99))
        {
            this.hurtEntities = tagCompund.getBoolean("HurtEntities");
            this.fallHurtAmount = tagCompund.getFloat("FallHurtAmount");
            this.fallHurtMax = tagCompund.getInteger("FallHurtMax");
        }
        else if (block == Blocks.anvil)
        {
            this.hurtEntities = true;
        }

        if (tagCompund.hasKey("DropItem", 99))
        {
            this.shouldDropItem = tagCompund.getBoolean("DropItem");
        }

        if (tagCompund.hasKey("TileEntityData", 10))
        {
            this.tileEntityData = tagCompund.getCompoundTag("TileEntityData");
        }

        if (block == null || block.getMaterial() == Material.air)
        {
            this.fallTile = Blocks.sand.getDefaultState();
        }
    }

    public void setHurtEntities(boolean p_145806_1_)
    {
        this.hurtEntities = p_145806_1_;
    }

    public void addEntityCrashInfo(CrashReportCategory category)
    {
        super.addEntityCrashInfo(category);

        if (this.fallTile != null)
        {
            Block block = this.fallTile.getBlock();
            category.addCrashSection("Immitating block ID", Integer.valueOf(Block.getIdFromBlock(block)));
            category.addCrashSection("Immitating block data", Integer.valueOf(block.getMetaFromState(this.fallTile)));
        }
    }

    @SideOnly(Side.CLIENT)
    public World getWorldObj()
    {
        return this.worldObj;
    }

    /**
     * Return whether this entity should be rendered as on fire.
     */
    @SideOnly(Side.CLIENT)
    public boolean canRenderOnFire()
    {
        return false;
    }

    public IBlockState getBlock()
    {
        return this.fallTile;
    }
}
