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
import com.KMOD.Entities.EntityFlyingTurtle;
import com.KMOD.Models.ModelFlyingTurtle;

@SideOnly(Side.CLIENT)
public class RenderFlyingTurtle extends RenderLiving
{
    private static final ResourceLocation cowTextures = new ResourceLocation(KCore.MODID, "textures/mobs/flying_turtle/flying_turtle.png");

    private static final ModelBase Model1 = new ModelFlyingTurtle();
    
    public RenderFlyingTurtle(RenderManager p_i46187_1_)
    {
        super(p_i46187_1_, Model1, 0.7F);
    }
    public void func_177_a(EntityFlyingTurtle entityMasso, double d, double d1,
    		double d2, float f, float f1)
    {
    		super.doRender(entityMasso, d, d1, d2, f, f1);
    	}

    		public void doRenderLiving(EntityLivingBase entityliving, double d, double d1,
    		double d2, float f, float f1) {
    		func_177_a((EntityFlyingTurtle) entityliving, d, d1, d2, f, f1);
    		}

    		    @Override
    		public void doRender(Entity entity, double d, double d1, double d2,
    		float f, float f1) {
    		func_177_a((EntityFlyingTurtle) entity, d, d1, d2, f, f1);
    		}

    /**
     * Returns the location of an entity's texture. Doesn't seem to be called unless you call Render.bindEntityTexture.
     */
    protected ResourceLocation getEntityTexture(EntityFlyingTurtle e)
    {
    		return cowTextures;
    }
    
    
    /**
     * Returns the location of an entity's texture. Doesn't seem to be called unless you call Render.bindEntityTexture.
     */
    protected ResourceLocation getEntityTexture(Entity p_110775_1_)
    {
        return this.getEntityTexture((EntityFlyingTurtle)p_110775_1_);
    }
}