package com.KMOD.Particle;

import net.minecraft.client.Minecraft;
import net.minecraft.client.particle.EntityFX;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.WorldRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import com.KMOD.Core.KCore;

@SideOnly(Side.CLIENT)
public class GildedSandParticle extends EntityFX {
    private static ResourceLocation loc = new ResourceLocation(KCore.MODID, "textures/particles/gilded.png");
    
    public GildedSandParticle(World w, double x, double y, double z, double offsetX, double offsetY, double offsetZ) 
    {
        super(w, x, y, z, offsetX, offsetY, offsetZ);
        this.particleTextureIndexX = ((int)(Math.random() * 8.0D));
        this.particleTextureIndexY = 0;
        this.noClip = false;
        this.particleAge = 0;
        this.particleMaxAge = 200;
    }

    @Override
    public void func_180434_a(WorldRenderer worldRenderer, Entity e, float f1, float f2, float f3, float f4, float f5, float f6) {
        Minecraft.getMinecraft().getTextureManager().bindTexture(loc);
        super.func_180434_a(worldRenderer, e, f1, f2, f3, f4, f5, f6);
    }

    
    public void onUpdate()
    {
    	this.motionY = +0.03;
        this.prevPosX = this.posX;
        this.prevPosY = this.posY;
        this.prevPosZ = this.posZ;
        this.posY = this.posY + this.motionY;
    	this.particleAge++;
    	this.particleAge++;
    	this.particleAge++;
    	this.particleAge++;
    	if(this.particleAge >= this.particleMaxAge)
    	{
    		this.setDead();
    	}
    	
    	
    	if(this.particleAge <= 25)
    	{
    		this.particleTextureIndexX = 0 % 16;
    	}	
    	else if(this.particleAge >= 26 && this.particleAge <= 50)
    	{
    		this.particleTextureIndexX = 1 % 16;
    	}
    	else if(this.particleAge >= 51 && this.particleAge <= 75)
    	{
    		this.particleTextureIndexX = 2 % 16;
    	}
    	else if(this.particleAge >= 76 && this.particleAge <= 100)
    	{
    		this.particleTextureIndexX = 3 % 16;
    	}
    	else if(this.particleAge >= 101 && this.particleAge <= 125)
    	{
    		this.particleTextureIndexX = 4 % 16;
    	}
    	else if(this.particleAge >= 126 && this.particleAge <= 150)
    	{
    		this.particleTextureIndexX = 5 % 16;
    	}
    	else if(this.particleAge >= 151 && this.particleAge <= 175)
    	{
    		this.particleTextureIndexX = 6 % 16;
    	}
    	else if(this.particleAge >= 176 && this.particleAge <= 200)
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