package com.KMOD.Rendering;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import com.KMOD.Core.KCore;
import com.KMOD.Entities.EntityFriendlySmalloverPlant;
import com.KMOD.Entities.EntitySmalloverPlant;
import com.KMOD.Models.ModelSmalloverPlant;

@SideOnly(Side.CLIENT)
public class RenderFriendlySmalloverPlant extends RenderLiving
{
    private static ResourceLocation Textures2 = new ResourceLocation(KCore.MODID, "textures/mobs/smallover_plant/oswojony.png");

    private static ModelBase Model1 = new ModelSmalloverPlant();
    
    public RenderFriendlySmalloverPlant(RenderManager p_i46187_1_)
    {
        super(p_i46187_1_, Model1, 0.5F);
    }
    
    protected ResourceLocation getEntityTexture(EntityFriendlySmalloverPlant en)
    {
    	return Textures2;
    }

    /**
     * Returns the location of an entity's texture. Doesn't seem to be called unless you call Render.bindEntityTexture.
     */
    protected ResourceLocation getEntityTexture(Entity p_110775_1_)
    {
        return this.getEntityTexture((EntityFriendlySmalloverPlant)p_110775_1_);
    }
}
