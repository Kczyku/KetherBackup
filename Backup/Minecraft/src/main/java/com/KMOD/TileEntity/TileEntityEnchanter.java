package com.KMOD.TileEntity;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.inventory.SlotFurnaceFuel;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemHoe;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.item.ItemTool;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.server.gui.IUpdatePlayerListBox;
import net.minecraft.tileentity.TileEntityLockable;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.MathHelper;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import com.KMOD.Core.KCore;
import com.KMOD.inventory.ContainerEnchanter;

public class TileEntityEnchanter extends TileEntityLockable implements IUpdatePlayerListBox, ISidedInventory
{
    private static final int[] slotsTop = new int[] {0};
    private static final int[] slotsBottom = new int[] {2, 1};
    private static final int[] slotsSides = new int[] {1};
    /** The ItemStacks that hold the items currently being used in the furnace */
    private ItemStack[] furnaceItemStacks = new ItemStack[4];
    /** The number of ticks that the furnace will keep burning */
    private int furnaceBurnTime;
    /** The number of ticks that a fresh copy of the currently-burning item would keep the furnace burning for */
    private int currentItemBurnTime;
    private int cookTime;
    private int totalCookTime;
    private String furnaceCustomName;

    /**
     * Returns the number of slots in the inventory.
     */
    public int getSizeInventory()
    {
        return this.furnaceItemStacks.length;
    }

    /**
     * Returns the stack in slot i
     */
    public ItemStack getStackInSlot(int index)
    {
        return this.furnaceItemStacks[index];
    }

    /**
     * Removes from an inventory slot (first arg) up to a specified number (second arg) of items and returns them in a
     * new stack.
     */
    public ItemStack decrStackSize(int index, int count)
    {
        if (this.furnaceItemStacks[index] != null)
        {
            ItemStack itemstack;

            if (this.furnaceItemStacks[index].stackSize <= count)
            {
                itemstack = this.furnaceItemStacks[index];
                this.furnaceItemStacks[index] = null;
                return itemstack;
            }
            else
            {
                itemstack = this.furnaceItemStacks[index].splitStack(count);

                if (this.furnaceItemStacks[index].stackSize == 0)
                {
                    this.furnaceItemStacks[index] = null;
                }

                return itemstack;
            }
        }
        else
        {
            return null;
        }
    }

    /**
     * When some containers are closed they call this on each slot, then drop whatever it returns as an EntityItem -
     * like when you close a workbench GUI.
     */
    public ItemStack getStackInSlotOnClosing(int index)
    {
        if (this.furnaceItemStacks[index] != null)
        {
            ItemStack itemstack = this.furnaceItemStacks[index];
            this.furnaceItemStacks[index] = null;
            return itemstack;
        }
        else
        {
            return null;
        }
    }

    /**
     * Sets the given item stack to the specified slot in the inventory (can be crafting or armor sections).
     */
    public void setInventorySlotContents(int index, ItemStack stack)
    {
        boolean flag = stack != null && stack.isItemEqual(this.furnaceItemStacks[index]) && ItemStack.areItemStackTagsEqual(stack, this.furnaceItemStacks[index]);
        this.furnaceItemStacks[index] = stack;

        if (stack != null && stack.stackSize > this.getInventoryStackLimit())
        {
            stack.stackSize = this.getInventoryStackLimit();
        }

        if (index == 0 && !flag)
        {
            this.totalCookTime = this.func_174904_a(stack);
            this.cookTime = 0;
            this.markDirty();
        }
    }

    /**
     * Gets the name of this command sender (usually username, but possibly "Rcon")
     */
    public String getName()
    {
        return this.hasCustomName() ? this.furnaceCustomName : "Enchanter";
    }

    /**
     * Returns true if this thing is named
     */
    public boolean hasCustomName()
    {
        return this.furnaceCustomName != null && this.furnaceCustomName.length() > 0;
    }

    public void setCustomInventoryName(String p_145951_1_)
    {
        this.furnaceCustomName = p_145951_1_;
    }

    public void readFromNBT(NBTTagCompound compound)
    {
        super.readFromNBT(compound);
        NBTTagList nbttaglist = compound.getTagList("Items", 10);
        this.furnaceItemStacks = new ItemStack[this.getSizeInventory()];

        for (int i = 0; i < nbttaglist.tagCount(); ++i)
        {
            NBTTagCompound nbttagcompound1 = nbttaglist.getCompoundTagAt(i);
            byte b0 = nbttagcompound1.getByte("Slot");

            if (b0 >= 0 && b0 < this.furnaceItemStacks.length)
            {
                this.furnaceItemStacks[b0] = ItemStack.loadItemStackFromNBT(nbttagcompound1);
            }
        }

        this.furnaceBurnTime = compound.getShort("BurnTime");
        this.cookTime = compound.getShort("CookTime");
        this.totalCookTime = compound.getShort("CookTimeTotal");
        this.currentItemBurnTime = getItemBurnTime(this.furnaceItemStacks[1]);

        if (compound.hasKey("CustomName", 8))
        {
            this.furnaceCustomName = compound.getString("CustomName");
        }
    }

    public void writeToNBT(NBTTagCompound compound)
    {
        super.writeToNBT(compound);
        compound.setShort("BurnTime", (short)this.furnaceBurnTime);
        compound.setShort("CookTime", (short)this.cookTime);
        compound.setShort("CookTimeTotal", (short)this.totalCookTime);
        NBTTagList nbttaglist = new NBTTagList();

        for (int i = 0; i < this.furnaceItemStacks.length; ++i)
        {
            if (this.furnaceItemStacks[i] != null)
            {
                NBTTagCompound nbttagcompound1 = new NBTTagCompound();
                nbttagcompound1.setByte("Slot", (byte)i);
                this.furnaceItemStacks[i].writeToNBT(nbttagcompound1);
                nbttaglist.appendTag(nbttagcompound1);
            }
        }

        compound.setTag("Items", nbttaglist);

        if (this.hasCustomName())
        {
            compound.setString("CustomName", this.furnaceCustomName);
        }
    }

    /**
     * Returns the maximum stack size for a inventory slot. Seems to always be 64, possibly will be extended. *Isn't
     * this more of a set than a get?*
     */
    public int getInventoryStackLimit()
    {
        return 64;
    }

    /**
     * Furnace isBurning
     */
    public boolean isBurning()
    {
        return this.furnaceBurnTime > 0;
    }

    @SideOnly(Side.CLIENT)
    public static boolean isBurning(IInventory p_174903_0_)
    {
        return p_174903_0_.getField(0) > 0;
    }

    /**
     * Updates the JList with a new model.
     */
    public void update()
    {
        boolean flag = this.isBurning();
        boolean flag1 = false;

        if (this.isBurning())
        {
            --this.furnaceBurnTime;
        }

        if (!this.worldObj.isRemote)
        {
            if (!this.isBurning() && (this.furnaceItemStacks[1] == null || this.furnaceItemStacks[0] == null))
            {
                if (!this.isBurning() && this.cookTime > 0)
                {
                    this.cookTime = MathHelper.clamp_int(this.cookTime - 2, 0, this.totalCookTime);
                }
            }
            else
            {
                if (!this.isBurning() && this.canSmelt())
                {
                    this.currentItemBurnTime = this.furnaceBurnTime = getItemBurnTime(this.furnaceItemStacks[1]);

                    if (this.isBurning())
                    {
                        flag1 = true;

                        if (this.furnaceItemStacks[1] != null)
                        {
                            --this.furnaceItemStacks[1].stackSize;

                            if (this.furnaceItemStacks[1].stackSize == 0)
                            {
                                this.furnaceItemStacks[1] = furnaceItemStacks[1].getItem().getContainerItem(furnaceItemStacks[1]);
                            }
                        }
                    }
                }

                if (this.isBurning() && this.canSmelt())
                {
                    ++this.cookTime;

                    if (this.cookTime == this.totalCookTime)
                    {
                        this.cookTime = 0;
                        this.totalCookTime = this.func_174904_a(this.furnaceItemStacks[0]);
                        this.smeltItem();
                        flag1 = true;
                    }
                }
                else
                {
                    this.cookTime = 0;
                }
            }

            if (flag != this.isBurning())
            {
                flag1 = true;
            }
        }

        if (flag1)
        {
            this.markDirty();
        }
    }

    public int func_174904_a(ItemStack p_174904_1_)
    {
        return 20000;
    }

    /**
     * Returns true if the furnace can smelt an item, i.e. has a source item, destination stack isn't full, etc.
     */
    private boolean canSmelt()
    {


        if (this.furnaceItemStacks[0] == null || this.furnaceItemStacks[3] == null || this.furnaceItemStacks[1] == null || this.furnaceItemStacks[2] != null)
        {
            return false;
        }
        else
        {
        	if((this.furnaceItemStacks[0].getItem() == KCore.Crystal && this.furnaceItemStacks[3].getItem() == KCore.TitaniumIngot) ||
        			(this.furnaceItemStacks[0].getItem() == KCore.TitaniumIngot && this.furnaceItemStacks[3].getItem() == KCore.Crystal))
        	{
        		return true;
        	}
        	else if((this.furnaceItemStacks[0].getItem() == Item.getItemFromBlock(KCore.Enchanter) && this.furnaceItemStacks[3].getItem() == KCore.Crystal) ||
        			(this.furnaceItemStacks[0].getItem() == KCore.Crystal && this.furnaceItemStacks[3].getItem() == Item.getItemFromBlock(KCore.Enchanter)))
        	{
        		return true;
        	}
        	else if((this.furnaceItemStacks[0].getItem() == Item.getItemFromBlock(Blocks.coal_block) && this.furnaceItemStacks[3].getItem() == KCore.Crystal) ||
        			(this.furnaceItemStacks[0].getItem() == KCore.Crystal && this.furnaceItemStacks[3].getItem() == Item.getItemFromBlock(Blocks.coal_block)))
        	{
        		return true;
        	}
        	else if((this.furnaceItemStacks[0].getItem() == KCore.CrystalHelmet && this.furnaceItemStacks[3].getItem() == KCore.RuneBase) ||
        			(this.furnaceItemStacks[0].getItem() == KCore.RuneBase && this.furnaceItemStacks[3].getItem() == KCore.CrystalHelmet))
        	{
        		return true;
        	}
        	else if((this.furnaceItemStacks[0].getItem() == KCore.CrystalChestplate && this.furnaceItemStacks[3].getItem() == KCore.RuneBase) ||
        			(this.furnaceItemStacks[0].getItem() == KCore.RuneBase && this.furnaceItemStacks[3].getItem() == KCore.CrystalChestplate))
        	{
        		return true;
        	}
        	else if((this.furnaceItemStacks[0].getItem() == KCore.CrystalLeggins && this.furnaceItemStacks[3].getItem() == KCore.RuneBase) ||
        			(this.furnaceItemStacks[0].getItem() == KCore.RuneBase && this.furnaceItemStacks[3].getItem() == KCore.CrystalLeggins))
        	{
        		return true;
        	}
        	else if((this.furnaceItemStacks[0].getItem() == KCore.CrystalBoots && this.furnaceItemStacks[3].getItem() == KCore.RuneBase) ||
        			(this.furnaceItemStacks[0].getItem() == KCore.RuneBase && this.furnaceItemStacks[3].getItem() == KCore.CrystalBoots))
        	{
        		return true;
        	}
        	else if((this.furnaceItemStacks[0].getItem() == KCore.CrystalSword && this.furnaceItemStacks[3].getItem() == KCore.RuneBase) ||
        			(this.furnaceItemStacks[0].getItem() == KCore.RuneBase && this.furnaceItemStacks[3].getItem() == KCore.CrystalSword))
        	{
        		return true;
        	}
        	else if((this.furnaceItemStacks[0] == new ItemStack(KCore.Shell, 4) && this.furnaceItemStacks[3].getItem() == KCore.CrystalChestplate) ||
        			(this.furnaceItemStacks[0].getItem() == KCore.CrystalChestplate && this.furnaceItemStacks[3] == new ItemStack(KCore.Shell, 4)))
        	{
        		return true;
        	}
        	else if((this.furnaceItemStacks[0] == new ItemStack(KCore.FireElement, 3) && this.furnaceItemStacks[3] == new ItemStack(Items.stick, 2)) ||
        			(this.furnaceItemStacks[0] == new ItemStack(Items.stick, 2) && this.furnaceItemStacks[3] == new ItemStack(KCore.FireElement, 3)))
        	{
        		return true;
        	}
        	else
        	{
        		return false;
        	}
        }
        
    }

    /**
     * Turn one item from the furnace source stack into the appropriate smelted item in the furnace result stack
     */
    public void smeltItem()
    {
        if (this.canSmelt())
        {
        	if((this.furnaceItemStacks[0].getItem() == KCore.Crystal && this.furnaceItemStacks[3].getItem() == KCore.TitaniumIngot) ||
        			(this.furnaceItemStacks[0].getItem() == KCore.TitaniumIngot && this.furnaceItemStacks[3].getItem() == KCore.Crystal))
            {

            			this.furnaceItemStacks[2] = new ItemStack(KCore.ThorsMetalPiece, 1);
            }
        	else if((this.furnaceItemStacks[0].getItem() == Item.getItemFromBlock(KCore.Enchanter) && this.furnaceItemStacks[3].getItem() == KCore.Crystal) ||
        			(this.furnaceItemStacks[0].getItem() == KCore.Crystal && this.furnaceItemStacks[3].getItem() == Item.getItemFromBlock(KCore.Enchanter)))
        	{
        		this.furnaceItemStacks[2] = new ItemStack(KCore.RunesPutter, 1);
        	}
        	else if((this.furnaceItemStacks[0].getItem() == Item.getItemFromBlock(Blocks.coal_block) && this.furnaceItemStacks[3].getItem() == KCore.Crystal) ||
        			(this.furnaceItemStacks[0].getItem() == KCore.Crystal && this.furnaceItemStacks[3].getItem() == Item.getItemFromBlock(Blocks.coal_block)))
        	{
        		this.furnaceItemStacks[2] = new ItemStack(KCore.RuneBase, 1);
        	}
        	else if((this.furnaceItemStacks[0].getItem() == KCore.CrystalHelmet && this.furnaceItemStacks[3].getItem() == KCore.RuneBase) ||
        			(this.furnaceItemStacks[0].getItem() == KCore.RuneBase && this.furnaceItemStacks[3].getItem() == KCore.CrystalHelmet))
        	{
        		this.furnaceItemStacks[2] = new ItemStack(KCore.CrystalSlotHelmet, 1);
        	}
        	else if((this.furnaceItemStacks[0].getItem() == KCore.CrystalChestplate && this.furnaceItemStacks[3].getItem() == KCore.RuneBase) ||
        			(this.furnaceItemStacks[0].getItem() == KCore.RuneBase && this.furnaceItemStacks[3].getItem() == KCore.CrystalChestplate))
        	{
        		this.furnaceItemStacks[2] = new ItemStack(KCore.CrystalSlotChestplate, 1);
        	}
        	else if((this.furnaceItemStacks[0].getItem() == KCore.CrystalLeggins && this.furnaceItemStacks[3].getItem() == KCore.RuneBase) ||
        			(this.furnaceItemStacks[0].getItem() == KCore.RuneBase && this.furnaceItemStacks[3].getItem() == KCore.CrystalLeggins))
        	{
        		this.furnaceItemStacks[2] = new ItemStack(KCore.CrystalSlotLeggins, 1);
        	}
        	else if((this.furnaceItemStacks[0].getItem() == KCore.CrystalBoots && this.furnaceItemStacks[3].getItem() == KCore.RuneBase) ||
        			(this.furnaceItemStacks[0].getItem() == KCore.RuneBase && this.furnaceItemStacks[3].getItem() == KCore.CrystalBoots))
        	{
        		this.furnaceItemStacks[2] = new ItemStack(KCore.CrystalSlotBoots, 1);
        	}
        	else if((this.furnaceItemStacks[0].getItem() == KCore.CrystalSword && this.furnaceItemStacks[3].getItem() == KCore.RuneBase) ||
        			(this.furnaceItemStacks[0].getItem() == KCore.RuneBase && this.furnaceItemStacks[3].getItem() == KCore.CrystalSword))
        	{
        		this.furnaceItemStacks[2] = new ItemStack(KCore.CrystalSlotSword, 1);
        	}
        	else if((this.furnaceItemStacks[0] == new ItemStack(KCore.Shell, 4) && this.furnaceItemStacks[3].getItem() == KCore.CrystalChestplate) ||
        			(this.furnaceItemStacks[0].getItem() == KCore.CrystalChestplate && this.furnaceItemStacks[3] == new ItemStack(KCore.Shell, 4)))
        	{
        		this.furnaceItemStacks[2] = new ItemStack(KCore.TurtleArmor, 1);
        		
        		if(this.furnaceItemStacks[0].getItem() == KCore.Shell)
        		{
        			this.furnaceItemStacks[0].stackSize--;
        			this.furnaceItemStacks[0].stackSize--;
        			this.furnaceItemStacks[0].stackSize--;

        		}
        		else if(this.furnaceItemStacks[3].getItem() == KCore.Shell)
        		{
        			this.furnaceItemStacks[0].stackSize--;
        			this.furnaceItemStacks[0].stackSize--;
        			this.furnaceItemStacks[0].stackSize--;
        		}
        	}
        	else if((this.furnaceItemStacks[0] == new ItemStack(KCore.FireElement, 3) && this.furnaceItemStacks[3] == new ItemStack(Items.stick, 2)) ||
        			(this.furnaceItemStacks[0] == new ItemStack(Items.stick, 2) && this.furnaceItemStacks[3] == new ItemStack(KCore.FireElement, 3)))
        	{
        		this.furnaceItemStacks[2] = new ItemStack(KCore.FireWand, 1);
        		
        	}
        	
        	this.furnaceItemStacks[0].stackSize--;
        	if(this.furnaceItemStacks[0].stackSize <= 1)
        	{
        		this.furnaceItemStacks[0] = null;
        	}
        	this.furnaceItemStacks[3].stackSize--;
        	if(this.furnaceItemStacks[3].stackSize <= 1)
        	{
        		this.furnaceItemStacks[3] = null;
        	}

        }
    }

    /**
     * Returns the number of ticks that the supplied fuel item will keep the furnace burning, or 0 if the item isn't
     * fuel
     */
    public static int getItemBurnTime(ItemStack p_145952_0_)
    {
        if (p_145952_0_ == null)
        {
            return 0;
        }
        else
        {
            Item item = p_145952_0_.getItem();

            if (item instanceof ItemBlock && Block.getBlockFromItem(item) != Blocks.air)
            {
                Block block = Block.getBlockFromItem(item);

                if (block == Blocks.wooden_slab)
                {
                    return 150;
                }

                if (block.getMaterial() == Material.wood)
                {
                    return 300;
                }

                if (block == Blocks.coal_block)
                {
                    return 16000;
                }
            }

            if (item instanceof ItemTool && ((ItemTool)item).getToolMaterialName().equals("WOOD")) return 200;
            if (item instanceof ItemSword && ((ItemSword)item).getToolMaterialName().equals("WOOD")) return 200;
            if (item instanceof ItemHoe && ((ItemHoe)item).getMaterialName().equals("WOOD")) return 200;
            if (item == Items.stick) return 100;
            if (item == Items.coal) return 1600;
            if (item == Items.lava_bucket) return 20000;
            if (item == Item.getItemFromBlock(Blocks.sapling)) return 100;
            if (item == Items.blaze_rod) return 2400;
            return net.minecraftforge.fml.common.registry.GameRegistry.getFuelValue(p_145952_0_);
        }
    }

    public static boolean isItemFuel(ItemStack p_145954_0_)
    {
        /**
         * Returns the number of ticks that the supplied fuel item will keep the furnace burning, or 0 if the item isn't
         * fuel
         */
        return getItemBurnTime(p_145954_0_) > 0;
    }

    /**
     * Do not make give this method the name canInteractWith because it clashes with Container
     */
    public boolean isUseableByPlayer(EntityPlayer player)
    {
        return this.worldObj.getTileEntity(this.pos) != this ? false : player.getDistanceSq((double)this.pos.getX() + 0.5D, (double)this.pos.getY() + 0.5D, (double)this.pos.getZ() + 0.5D) <= 64.0D;
    }

    public void openInventory(EntityPlayer player) {}

    public void closeInventory(EntityPlayer player) {}

    /**
     * Returns true if automation is allowed to insert the given stack (ignoring stack size) into the given slot.
     */
    public boolean isItemValidForSlot(int index, ItemStack stack)
    {
        return index == 2 ? false : (index != 1 ? true : isItemFuel(stack) || SlotFurnaceFuel.isBucket(stack));
    }

    public int[] getSlotsForFace(EnumFacing side)
    {
        return side == EnumFacing.DOWN ? slotsBottom : (side == EnumFacing.UP ? slotsTop : slotsSides);
    }

    /**
     * Returns true if automation can insert the given item in the given slot from the given side. Args: slot, item,
     * side
     */
    public boolean canInsertItem(int index, ItemStack itemStackIn, EnumFacing direction)
    {
        return this.isItemValidForSlot(index, itemStackIn);
    }

    /**
     * Returns true if automation can extract the given item in the given slot from the given side. Args: slot, item,
     * side
     */
    public boolean canExtractItem(int index, ItemStack stack, EnumFacing direction)
    {
        if (direction == EnumFacing.DOWN && index == 1)
        {
            Item item = stack.getItem();

            if (item != Items.water_bucket && item != Items.bucket)
            {
                return false;
            }
        }

        return true;
    }

    public String getGuiID()
    {
        return "minecraft:enchanter";
    }

    public Container createContainer(InventoryPlayer playerInventory, EntityPlayer playerIn)
    {
        return new ContainerEnchanter(playerInventory, this);
    }

    public int getField(int id)
    {
        switch (id)
        {
            case 0:
                return this.furnaceBurnTime;
            case 1:
                return this.currentItemBurnTime;
            case 2:
                return this.cookTime;
            case 3:
                return this.totalCookTime;
            default:
                return 0;
        }
    }

    public void setField(int id, int value)
    {
        switch (id)
        {
            case 0:
                this.furnaceBurnTime = value;
                break;
            case 1:
                this.currentItemBurnTime = value;
                break;
            case 2:
                this.cookTime = value;
                break;
            case 3:
                this.totalCookTime = value;
        }
    }

    public int getFieldCount()
    {
        return 4;
    }

    public void clear()
    {
        for (int i = 0; i < this.furnaceItemStacks.length; ++i)
        {
            this.furnaceItemStacks[i] = null;
        }
    }
}