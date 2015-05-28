package com.KMOD.Rendering;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import com.KMOD.Core.KCore;
import com.KMOD.Entities.EntityForbiddenGuardian;
import com.KMOD.Models.ModelForbiddenGuardian;

@SideOnly(Side.CLIENT)
public class RenderForbiddenGuardian extends RenderLiving
{
    private static final ResourceLocation cowTextures = new ResourceLocation(KCore.MODID, "textures/mobs/forbidden/guardian.png");

    private static final ModelBase Model1 = new ModelForbiddenGuardian();
    
    public RenderForbiddenGuardian(RenderManager p_i46187_1_)
    {
        super(p_i46187_1_, Model1, 0.8F);
    }
    public void func_177_a(EntityForbiddenGuardian entityMasso, double d, double d1,
    		double d2, float f, float f1)
    {
    		super.doRender(entityMasso, d, d1, d2, f, f1);
    	}

    		public void doRenderLiving(EntityLivingBase entityliving, double d, double d1,
    		double d2, float f, float f1) 
    		{
    		func_177_a((EntityForbiddenGuardian) entityliving, d, d1, d2, f, f1);
    		}

    		    @Override
    		public void doRender(Entity entity, double d, double d1, double d2,
    		float f, float f1) 
    		    {
    		func_177_a((EntityForbiddenGuardian) entity, d, d1, d2, f, f1);
    }

    /**
     * Returns the location of an entity's texture. Doesn't seem to be called unless you call Render.bindEntityTexture.
     */
    protected ResourceLocation getEntityTexture(EntityForbiddenGuardian e)
    {
    		return cowTextures;
    }
    
    
    /**
     * Returns the location of an entity's texture. Doesn't seem to be called unless you call Render.bindEntityTexture.
     */
    protected ResourceLocation getEntityTexture(Entity p_110775_1_)
    {
        return this.getEntityTexture((EntityForbiddenGuardian)p_110775_1_);
    }
}