package com.KMOD.Rendering;

import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.WorldRenderer;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import com.KMOD.Core.KCore;
import com.KMOD.Entities.EntityMagicShoot;

public class RenderMagicShootNew extends Render
{
	public RenderMagicShootNew(RenderManager renderManager) 
	{
		super(renderManager);
	}

	private static final ResourceLocation stoneRockTexture = new ResourceLocation(KCore.MODID, "textures/entities/magicshoot/Magic Shoot.png");
	
	protected ResourceLocation getEntityTexture(EntityMagicShoot rock)
	{
		return stoneRockTexture;
	}
	
	protected ResourceLocation getEntityTexture(Entity entity) 
	{
		return this.getEntityTexture((EntityMagicShoot)entity);	
	}
	
	public void doRender(Entity entity, double transX, double transY, double transZ, float param5, float dir)
	{
		this.doRender((EntityMagicShoot)entity, transX, transY, transZ, param5, dir);
	}
	
	public void doRender(EntityMagicShoot rock, double transX, double transY, double transZ, float param5, float dir)
	{
		this.bindEntityTexture(rock);
		GlStateManager.color(1.0F, 1.0F, 1.0F);
		GlStateManager.pushMatrix();
		GlStateManager.translate((float)transX, (float)transY, (float)transZ);
		GlStateManager.rotate(rock.prevRotationYaw + (rock.rotationYaw - rock.prevRotationYaw) * dir - 90.0F, 0.0F, 1.0F, 0.0F);
		Tessellator tessellator = Tessellator.getInstance();
		WorldRenderer worldRenderer = tessellator.getWorldRenderer();
		GlStateManager.enableRescaleNormal();
		float scale = 0.5F;
		GlStateManager.scale(scale, scale, scale);
		GL11.glNormal3f(0.0F, 0.0F, scale);
		
		worldRenderer.startDrawingQuads();
		worldRenderer.addVertexWithUV(-2.0D, -2.0D, 0.0D, 0, 0);
		worldRenderer.addVertexWithUV(2.0D, -2.0D, 0.0D, 1, 0);
		worldRenderer.addVertexWithUV(2.0D, 2.0D, 0.0D, 1, 1);
		worldRenderer.addVertexWithUV(-2.0D, 2.0D, 0.0D, 0, 1);
		tessellator.draw();
		
		GlStateManager.rotate(180.0F, 1.0F, 0.0F, 0.0F);
		
		worldRenderer.startDrawingQuads();
		worldRenderer.addVertexWithUV(-2.0D, -2.0D, 0.0D, 0, 0);
		worldRenderer.addVertexWithUV(2.0D, -2.0D, 0.0D, 1, 0);
		worldRenderer.addVertexWithUV(2.0D, 2.0D, 0.0D, 1, 1);
		worldRenderer.addVertexWithUV(-2.0D, 2.0D, 0.0D, 0, 1);
		tessellator.draw();
		
		GlStateManager.disableRescaleNormal();
		GlStateManager.popMatrix();
		
		super.doRender(rock, transX, transY, transZ, param5, dir);
	}
}