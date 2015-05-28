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
import com.KMOD.Entities.EntityGravitionalOre;
import com.KMOD.Models.ModelGravitionalOre;

@SideOnly(Side.CLIENT)
public class RenderGravitionalOre extends RenderLiving
{
    private static final ResourceLocation cowTextures = new ResourceLocation(KCore.MODID, "textures/mobs/blocks/gravitional_ore.png");
    private static final ResourceLocation cowTextures1 = new ResourceLocation(KCore.MODID, "textures/mobs/blocks/gravitional_ore1.png");
    private static final ResourceLocation cowTextures2 = new ResourceLocation(KCore.MODID, "textures/mobs/blocks/gravitional_ore2.png");
    private static final ResourceLocation cowTextures3 = new ResourceLocation(KCore.MODID, "textures/mobs/blocks/gravitional_ore3.png");
    private static final ResourceLocation cowTextures4 = new ResourceLocation(KCore.MODID, "textures/mobs/blocks/gravitional_ore4.png");

    private static final ModelBase Model1 = new ModelGravitionalOre();
    
    public RenderGravitionalOre(RenderManager p_i46187_1_)
    {
        super(p_i46187_1_, Model1, 1.0F);
    }
    public void func_177_a(EntityGravitionalOre entityMasso, double d, double d1,
    		double d2, float f, float f1)
    {
    		super.doRender(entityMasso, d, d1, d2, f, f1);
    	}

    		public void doRenderLiving(EntityLivingBase entityliving, double d, double d1,
    		double d2, float f, float f1) {
    		func_177_a((EntityGravitionalOre) entityliving, d, d1, d2, f, f1);
    		}

    		    @Override
    		public void doRender(Entity entity, double d, double d1, double d2,
    		float f, float f1) {
    		func_177_a((EntityGravitionalOre) entity, d, d1, d2, f, f1);
    		}

    /**
     * Returns the location of an entity's texture. Doesn't seem to be called unless you call Render.bindEntityTexture.
     */
    protected ResourceLocation getEntityTexture(EntityGravitionalOre e)
    {
    	if(e.getHealth() == 400)
    	{
    		return cowTextures;
    	}
    	else if(e.getHealth() >= 300 && e.getHealth() <= 399)
    	{
    		return cowTextures1;

    	}
    	else if(e.getHealth() >= 200 && e.getHealth() <= 299)
    	{
    		return cowTextures2;

    	}
    	else if(e.getHealth() >= 100 && e.getHealth() <= 199)
    	{
    		return cowTextures3;

    	}
    	else if(e.getHealth() >= 0 && e.getHealth() <= 99)
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
        return this.getEntityTexture((EntityGravitionalOre)p_110775_1_);
    }
}