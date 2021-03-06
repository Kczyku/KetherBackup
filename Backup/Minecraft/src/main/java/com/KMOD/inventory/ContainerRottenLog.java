package com.KMOD.inventory;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ICrafting;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.inventory.SlotFurnaceFuel;
import net.minecraft.inventory.SlotFurnaceOutput;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ContainerRottenLog extends Container
{
    private final IInventory tileFurnace;
    private int field_178152_f;
    private int field_178153_g;
    private int field_178154_h;
    private int field_178155_i;

    public ContainerRottenLog(InventoryPlayer p_i45794_1_, IInventory furnaceInventory)
    {
        this.tileFurnace = furnaceInventory;
        this.addSlotToContainer(new Slot(furnaceInventory, 0, 4, 4));
        this.addSlotToContainer(new Slot(furnaceInventory, 1, 22, 4));
        this.addSlotToContainer(new Slot(furnaceInventory, 2, 40, 4));
        this.addSlotToContainer(new Slot(furnaceInventory, 3, 4, 22));
        this.addSlotToContainer(new Slot(furnaceInventory, 4, 22, 22));
        this.addSlotToContainer(new Slot(furnaceInventory, 5, 40, 22));
        this.addSlotToContainer(new Slot(furnaceInventory, 6, 4, 40));
        this.addSlotToContainer(new Slot(furnaceInventory, 7, 22, 40));
        this.addSlotToContainer(new Slot(furnaceInventory, 8, 40, 40));
        this.addSlotToContainer(new Slot(furnaceInventory, 9, 4, 58));
        this.addSlotToContainer(new Slot(furnaceInventory, 10, 22, 58));
        this.addSlotToContainer(new Slot(furnaceInventory, 11, 40, 58));
        this.addSlotToContainer(new SlotFurnaceOutput(p_i45794_1_.player, furnaceInventory, 12, 120, 4));
        this.addSlotToContainer(new SlotFurnaceOutput(p_i45794_1_.player, furnaceInventory, 13, 138, 4));
        this.addSlotToContainer(new SlotFurnaceOutput(p_i45794_1_.player, furnaceInventory, 14, 156, 4));
        this.addSlotToContainer(new SlotFurnaceOutput(p_i45794_1_.player, furnaceInventory, 15, 120, 22));
        this.addSlotToContainer(new SlotFurnaceOutput(p_i45794_1_.player, furnaceInventory, 16, 138, 22));
        this.addSlotToContainer(new SlotFurnaceOutput(p_i45794_1_.player, furnaceInventory, 17, 156, 22));
        this.addSlotToContainer(new SlotFurnaceOutput(p_i45794_1_.player, furnaceInventory, 18, 120, 40));
        this.addSlotToContainer(new SlotFurnaceOutput(p_i45794_1_.player, furnaceInventory, 19, 138, 40));
        this.addSlotToContainer(new SlotFurnaceOutput(p_i45794_1_.player, furnaceInventory, 20, 156, 40));
        this.addSlotToContainer(new SlotFurnaceOutput(p_i45794_1_.player, furnaceInventory, 21, 120, 58));
        this.addSlotToContainer(new SlotFurnaceOutput(p_i45794_1_.player, furnaceInventory, 22, 138, 58));
        this.addSlotToContainer(new SlotFurnaceOutput(p_i45794_1_.player, furnaceInventory, 23, 156, 58));


        
        
        int i;

        for (i = 0; i < 3; ++i)
        {
            for (int j = 0; j < 9; ++j)
            {
                this.addSlotToContainer(new Slot(p_i45794_1_, j + i * 9 + 9, 8 + j * 18, 84 + i * 18));
            }
        }

        for (i = 0; i < 9; ++i)
        {
            this.addSlotToContainer(new Slot(p_i45794_1_, i, 8 + i * 18, 142));
        }
    }

    /**
     * Add the given Listener to the list of Listeners. Method name is for legacy.
     */
    public void addCraftingToCrafters(ICrafting listener)
    {
        super.addCraftingToCrafters(listener);
        listener.func_175173_a(this, this.tileFurnace);
    }

    /**
     * Looks for changes made in the container, sends them to every listener.
     */
    public void detectAndSendChanges()
    {
        super.detectAndSendChanges();

        for (int i = 0; i < this.crafters.size(); ++i)
        {
            ICrafting icrafting = (ICrafting)this.crafters.get(i);

            if (this.field_178152_f != this.tileFurnace.getField(2))
            {
                icrafting.sendProgressBarUpdate(this, 2, this.tileFurnace.getField(2));
            }

            if (this.field_178154_h != this.tileFurnace.getField(0))
            {
                icrafting.sendProgressBarUpdate(this, 0, this.tileFurnace.getField(0));
            }

            if (this.field_178155_i != this.tileFurnace.getField(1))
            {
                icrafting.sendProgressBarUpdate(this, 1, this.tileFurnace.getField(1));
            }

            if (this.field_178153_g != this.tileFurnace.getField(3))
            {
                icrafting.sendProgressBarUpdate(this, 3, this.tileFurnace.getField(3));
            }
        }

        this.field_178152_f = this.tileFurnace.getField(2);
        this.field_178154_h = this.tileFurnace.getField(0);
        this.field_178155_i = this.tileFurnace.getField(1);
        this.field_178153_g = this.tileFurnace.getField(3);
    }

    @SideOnly(Side.CLIENT)
    public void updateProgressBar(int id, int data)
    {
        this.tileFurnace.setField(id, data);
    }

    public boolean canInteractWith(EntityPlayer playerIn)
    {
        return this.tileFurnace.isUseableByPlayer(playerIn);
    }

    /**
     * Take a stack from the specified inventory slot.
     */
    public ItemStack transferStackInSlot(EntityPlayer playerIn, int index)
    {
        ItemStack itemstack = null;
        Slot slot = (Slot)this.inventorySlots.get(index);

        if (slot != null && slot.getHasStack())
        {
            ItemStack itemstack1 = slot.getStack();
            itemstack = itemstack1.copy();

            if (index == 2)
            {
                slot.onSlotChange(itemstack1, itemstack);
            }



            if (itemstack1.stackSize == 0)
            {
                slot.putStack((ItemStack)null);
            }
            else
            {
                slot.onSlotChanged();
            }

            if (itemstack1.stackSize == itemstack.stackSize)
            {
                return null;
            }

            slot.onPickupFromSlot(playerIn, itemstack1);
        }

        return itemstack;
    }
}