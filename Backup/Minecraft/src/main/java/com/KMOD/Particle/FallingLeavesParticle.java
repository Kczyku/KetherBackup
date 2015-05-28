package com.KMOD.Particle;

import com.KMOD.Core.KCore;

import net.minecraft.client.Minecraft;
import net.minecraft.client.particle.EntityFX;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.WorldRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class FallingLeavesParticle extends EntityFX {
    private static ResourceLocation loc = new ResourceLocation(KCore.MODID, "textures/particles/particles.png");
    
    public FallingLeavesParticle(World w, double x, double y, double z, double offsetX, double offsetY, double offsetZ) 
    {
        super(w, x, y, z, offsetX, offsetY, offsetZ);
        this.particleTextureIndexX = ((int)(Math.random() * 8.0D));
        this.particleTextureIndexY = 0;
        this.noClip = false;
        this.particleAge = 0;
        this.particleMaxAge = 1000;
    }

    @Override
    public void func_180434_a(WorldRenderer worldRenderer, Entity e, float f1, float f2, float f3, float f4, float f5, float f6) {
        Minecraft.getMinecraft().getTextureManager().bindTexture(loc);
        super.func_180434_a(worldRenderer, e, f1, f2, f3, f4, f5, f6);

    }
    
    

    
    public void onUpdate()
    {
    	if(this.onGround)
    	{
    		this.motionY = 0;
    	}
    	else
    	{
    		this.motionY = 0.03;
    	}
        this.prevPosX = this.posX;
        this.prevPosY = this.posY;
        this.prevPosZ = this.posZ;
        this.posY = this.posY - this.motionY;
    	this.particleAge++;
    	this.particleAge++;
    	this.particleAge++;
    	this.particleAge++;
    	if(this.particleAge >= this.particleMaxAge)
    	{
    		this.setDead();
    	}
    	
    	
    	if(this.particleAge <= 125)
    	{
    		this.particleTextureIndexX = 0 % 16;
    	}	
    	else if(this.particleAge >= 126 && this.particleAge <= 250)
    	{
    		this.particleTextureIndexX = 1 % 16;
    	}
    	else if(this.particleAge >= 251 && this.particleAge <= 375)
    	{
    		this.particleTextureIndexX = 2 % 16;
    	}
    	else if(this.particleAge >= 376 && this.particleAge <= 500)
    	{
    		this.particleTextureIndexX = 3 % 16;
    	}
    	else if(this.particleAge >= 501 && this.particleAge <= 625)
    	{
    		this.particleTextureIndexX = 4 % 16;
    	}
    	else if(this.particleAge >= 626 && this.particleAge <= 750)
    	{
    		this.particleTextureIndexX = 5 % 16;
    	}
    	else if(this.particleAge >= 751 && this.particleAge <= 875)
    	{
    		this.particleTextureIndexX = 6 % 16;
    	}
    	else if(this.particleAge >= 876 && this.particleAge <= 1000)
    	{
    		this.particleTextureIndexX = 7 % 16;
    	}
    	
    }
    
    public int getBrightnessForRender(float p_70070_1_)
    {
        int i = super.getBrightnessForRender(p_70070_1_);
        float f1 = (float)this.particleAge / (float)this.particleMaxAge;
        f1 *= f1;
        f1 *= f1;
        int j = i & 255;
        int k = i >> 16 & 255;
        k += (int)(f1 * 15.0F * 16.0F);

        if (k > 240)
        {
            k = 240;
        }

        return j | k << 16;
    }

    /**
     * Gets how bright this entity is.
     */
    public float getBrightness(float p_70013_1_)
    {
        float f1 = super.getBrightness(p_70013_1_);
        float f2 = (float)this.particleAge / (float)this.particleMaxAge;
        f2 = f2 * f2 * f2 * f2;
        return f1 * (1.0F - f2) + f2;
    }
}