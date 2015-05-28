package com.KMOD.gui;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import com.KMOD.Core.KCore;
import com.KMOD.TileEntity.TileEntityRottenLog;
import com.KMOD.inventory.ContainerRottenLog;

@SideOnly(Side.CLIENT)
public class GuiRottenLog extends GuiContainer
{
    private static final ResourceLocation furnaceGuiTextures = new ResourceLocation(KCore.MODID, "textures/gui/rottenlog.png");
    /** The player inventory bound to this GUI. */
    private final InventoryPlayer playerInventory;
    private IInventory tileFurnace;

    public GuiRottenLog(InventoryPlayer playerInv, IInventory furnaceInv)
    {
        super(new ContainerRottenLog(playerInv, furnaceInv));
        this.playerInventory = playerInv;
        this.tileFurnace = furnaceInv;
    }

    /**
     * Draw the foreground layer for the GuiContainer (everything in front of the items). Args : mouseX, mouseY
     */
    protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY)
    {
        String s = this.tileFurnace.getDisplayName().getUnformattedText();
        this.fontRendererObj.drawString(s, this.xSize / 2 - this.fontRendererObj.getStringWidth(s) / 2, 6, 4210752);
        this.fontRendererObj.drawString(this.playerInventory.getDisplayName().getUnformattedText(), 8, this.ySize - 96 + 2, 4210752);
    }

    /**
     * Args : renderPartialTicks, mouseX, mouseY
     */
    protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY)
    {
        GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
        this.mc.getTextureManager().bindTexture(furnaceGuiTextures);
        int k = (this.width - this.xSize) / 2;
        int l = (this.height - this.ySize) / 2;
        this.drawTexturedModalRect(k, l, 0, 0, this.xSize, this.ySize);
        int i1;

        i1 = this.func_175381_h(56);
        this.drawTexturedModalRect(k + 59, l + 4, 0, 166, i1, 9);
    }

    private int func_175381_h(int p_175381_1_)
    {
        int j = this.tileFurnace.getField(2);
        int k = this.tileFurnace.getField(3);
        return k != 0 && j != 0 ? j * p_175381_1_ / k : 0;
    }

    private int func_175382_i(int p_175382_1_)
    {
        int j = this.tileFurnace.getField(1);

        if (j == 0)
        {
            j = 200;
        }

        return this.tileFurnace.getField(0) * p_175382_1_ / j;
    }
}