package com.KMOD.Particle;

import com.KMOD.Core.KCore;

import net.minecraft.client.Minecraft;
import net.minecraft.client.particle.EntityFX;
import net.minecraft.client.particle.IParticleFactory;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.WorldRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class SmalloverPlantHealingParticle extends EntityFX
{
    private float portalParticleScale;
    private double portalPosX;
    private double portalPosY;
    private double portalPosZ;
    private static ResourceLocation loc = new ResourceLocation(KCore.MODID, "textures/particles/particlesPortal.png");

    public SmalloverPlantHealingParticle(World worldIn, double p_i46351_2_, double p_i46351_4_, double p_i46351_6_, double p_i46351_8_, double p_i46351_10_, double p_i46351_12_)
    {
        super(worldIn, p_i46351_2_, p_i46351_4_, p_i46351_6_, p_i46351_8_, p_i46351_10_, p_i46351_12_);
        this.motionX = p_i46351_8_;
        this.motionY = p_i46351_10_;
        this.motionZ = p_i46351_12_;
        this.portalPosX = this.posX = p_i46351_2_;
        this.portalPosY = this.posY = p_i46351_4_;
        this.portalPosZ = this.posZ = p_i46351_6_;
        this.particleMaxAge = (int)(Math.random() * 10.0D) + 40;
        this.noClip = false;
        this.particleTextureIndexX = ((int)(Math.random() * 8.0D));
        float f = this.rand.nextFloat() * 0.6F + 0.4F;
        
    }
    
    
    public void func_180434_a(WorldRenderer worldRenderer, Entity e, float f1, float f2, float f3, float f4, float f5, float f6)
    {
        Minecraft.getMinecraft().getTextureManager().bindTexture(loc);
        super.func_180434_a(worldRenderer, e, f1, f2, f3, f4, f5, f6);
    }

    /**
     * Called to update the entity's position/logic.
     */
    public void onUpdate()
    {
        this.prevPosX = this.posX;
        this.prevPosY = this.posY;
        this.prevPosZ = this.posZ;
        float f = (float)this.particleAge / (float)this.particleMaxAge;
        float f1 = f;
        f = -f + f * f * 2.0F;
        f = 1.0F - f;
        this.posX = this.portalPosX + this.motionX * (double)f;
        this.posY = this.portalPosY + this.motionY * (double)f + (double)(1.0F - f1);
        this.posZ = this.portalPosZ + this.motionZ * (double)f;

        if (this.particleAge++ >= this.particleMaxAge)
        {
            this.setDead();
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