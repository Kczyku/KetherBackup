package com.KMOD.Rendering;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.passive.EntityBat;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import com.KMOD.Core.KCore;
import com.KMOD.Entities.EntityBird;
import com.KMOD.Models.ModelBird;

@SideOnly(Side.CLIENT)
public class RenderBird extends RenderLiving
{
    private static final ResourceLocation cowTextures = new ResourceLocation(KCore.MODID, "textures/mobs/bird/bird_red.png");
    private static final ResourceLocation cowTextures1 = new ResourceLocation(KCore.MODID, "textures/mobs/bird/bird_yellow.png");
    private static final ResourceLocation cowTextures2 = new ResourceLocation(KCore.MODID, "textures/mobs/bird/bird_blue.png");
    private static final ResourceLocation cowTextures3 = new ResourceLocation(KCore.MODID, "textures/mobs/bird/bird_green.png");
    private static final ResourceLocation cowTextures4 = new ResourceLocation(KCore.MODID, "textures/mobs/bird/bird_purple.png");

    private static final ModelBase Model1 = new ModelBird();
    
    public RenderBird(RenderManager p_i46187_1_)
    {
        super(p_i46187_1_, Model1, 0.3F);
    }
    public void func_177_a(EntityBird entityMasso, double d, double d1,
    		double d2, float f, float f1)
    {
    		super.doRender(entityMasso, d, d1, d2, f, f1);
    	}

    		public void doRenderLiving(EntityLivingBase entityliving, double d, double d1,
    		double d2, float f, float f1) {
    		func_177_a((EntityBird) entityliving, d, d1, d2, f, f1);
    		}

    		    @Override
    		public void doRender(Entity entity, double d, double d1, double d2,
    		float f, float f1) {
    		func_177_a((EntityBird) entity, d, d1, d2, f, f1);
    		}

    /**
     * Returns the location of an entity's texture. Doesn't seem to be called unless you call Render.bindEntityTexture.
     */
    protected ResourceLocation getEntityTexture(EntityBird e)
    {
    	if(e.Color == "red")
    	{
    		return cowTextures;
    	}
    	else if(e.Color == "yellow")
    	{
    		return cowTextures1;
    	}
    	else if(e.Color == "blue")
    	{
    		return cowTextures2;
    	}
    	else if(e.Color == "green")
    	{
    		return cowTextures3;
    	}
    	else if(e.Color == "purple")
    	{
    		return cowTextures4;
    	}
    	else
    	{
    		return cowTextures;
    	}
    		
    }
    
    
    /**
     * Returns the location of an entity's texture. Doesn't seem to be called unless you call Render.bindEntityTexture.
     */
    protected ResourceLocation getEntityTexture(Entity p_110775_1_)
    {
        return this.getEntityTexture((EntityBird)p_110775_1_);
    }
    



    /**
     * Returns the location of an entity's texture. Doesn't seem to be called unless you call Render.bindEntityTexture.
     */

}