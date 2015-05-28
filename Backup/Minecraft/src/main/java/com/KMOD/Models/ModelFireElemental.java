package com.KMOD.Models;

import java.util.Random;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.MathHelper;

public class ModelFireElemental extends ModelBase
{
  //fields
    ModelRenderer Shape1;
    ModelRenderer Shape2;
    ModelRenderer Shape3;
    ModelRenderer Shape4;
    ModelRenderer Shape5;
    ModelRenderer Shape6;
    ModelRenderer Shape7;
    ModelRenderer Shape8;
    ModelRenderer Shape9;
    ModelRenderer Shape10;
    ModelRenderer Shape11;
    ModelRenderer Shape12;
  
  public ModelFireElemental()
  {
    textureWidth = 64;
    textureHeight = 64;
    
      Shape1 = new ModelRenderer(this, 0, 0);
      Shape1.addBox(0F, 0F, 0F, 1, 1, 1);
      Shape1.setRotationPoint(-4F, 23F, 0F);
      Shape1.setTextureSize(64, 64);
      Shape1.mirror = true;
      setRotation(Shape1, 0F, 0F, 0F);
      Shape2 = new ModelRenderer(this, 0, 0);
      Shape2.addBox(0F, 0F, 0F, 1, 1, 1);
      Shape2.setRotationPoint(0F, 21F, 4F);
      Shape2.setTextureSize(64, 64);
      Shape2.mirror = true;
      setRotation(Shape2, 0F, 0F, 0F);
      Shape3 = new ModelRenderer(this, 0, 0);
      Shape3.addBox(0F, 0F, 0F, 1, 1, 1);
      Shape3.setRotationPoint(4F, 19F, 0F);
      Shape3.setTextureSize(64, 64);
      Shape3.mirror = true;
      setRotation(Shape3, 0F, 0F, 0F);
      Shape4 = new ModelRenderer(this, 0, 0);
      Shape4.addBox(0F, 0F, 0F, 1, 1, 1);
      Shape4.setRotationPoint(0F, 17F, -5F);
      Shape4.setTextureSize(64, 64);
      Shape4.mirror = true;
      setRotation(Shape4, 0F, 0F, 0F);
      Shape5 = new ModelRenderer(this, 0, 0);
      Shape5.addBox(0F, 0F, 0F, 1, 1, 1);
      Shape5.setRotationPoint(-4F, 15F, 0F);
      Shape5.setTextureSize(64, 64);
      Shape5.mirror = true;
      setRotation(Shape5, 0F, 0F, 0F);
      Shape6 = new ModelRenderer(this, 0, 0);
      Shape6.addBox(0F, 0F, 0F, 1, 1, 1);
      Shape6.setRotationPoint(0F, 13F, 2F);
      Shape6.setTextureSize(64, 64);
      Shape6.mirror = true;
      setRotation(Shape6, 0F, 0F, 0F);
      Shape7 = new ModelRenderer(this, 0, 0);
      Shape7.addBox(0F, 0F, 0F, 1, 1, 1);
      Shape7.setRotationPoint(4F, 11F, 0F);
      Shape7.setTextureSize(64, 64);
      Shape7.mirror = true;
      setRotation(Shape7, 0F, 0F, 0F);
      Shape8 = new ModelRenderer(this, 0, 0);
      Shape8.addBox(0F, 0F, 0F, 1, 1, 1);
      Shape8.setRotationPoint(0F, 9F, -5F);
      Shape8.setTextureSize(64, 64);
      Shape8.mirror = true;
      setRotation(Shape8, 0F, 0F, 0F);
      Shape9 = new ModelRenderer(this, 0, 0);
      Shape9.addBox(0F, 0F, 0F, 1, 1, 1);
      Shape9.setRotationPoint(-4F, 7F, 0F);
      Shape9.setTextureSize(64, 64);
      Shape9.mirror = true;
      setRotation(Shape9, 0F, 0F, 0F);
      Shape10 = new ModelRenderer(this, 0, 0);
      Shape10.addBox(0F, 0F, 0F, 1, 1, 1);
      Shape10.setRotationPoint(0F, 5F, 2F);
      Shape10.setTextureSize(64, 64);
      Shape10.mirror = true;
      setRotation(Shape10, 0F, 0F, 0F);
      Shape11 = new ModelRenderer(this, 0, 0);
      Shape11.addBox(0F, 0F, 0F, 1, 1, 1);
      Shape11.setRotationPoint(-1F, 3F, -4F);
      Shape11.setTextureSize(64, 64);
      Shape11.mirror = true;
      setRotation(Shape11, 0F, 0F, 0F);
      Shape12 = new ModelRenderer(this, 0, 0);
      Shape12.addBox(0F, 0F, 0F, 1, 1, 1);
      Shape12.setRotationPoint(0F, 1F, 0F);
      Shape12.setTextureSize(64, 64);
      Shape12.mirror = true;
      setRotation(Shape12, 0F, 0F, 0F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    Shape1.render(f5);
    Shape2.render(f5);
    Shape3.render(f5);
    Shape4.render(f5);
    Shape5.render(f5);
    Shape6.render(f5);
    Shape7.render(f5);
    Shape8.render(f5);
    Shape9.render(f5);
    Shape10.render(f5);
    Shape11.render(f5);
    Shape12.render(f5);
  }
  
  private void setRotation(ModelRenderer model, float x, float y, float z)
  {
    model.rotateAngleX = x;
    model.rotateAngleY = y;
    model.rotateAngleZ = z;
  }
  Random random = new Random();
  public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity en)
  {
    super.setRotationAngles(f, f1, f2, f3, f4, f5, en);
    
    float f6 = f2 * (float)Math.PI * -0.1F;
    int i;

    for (i = 0; i < 4; ++i)
    {
        this.Shape1.rotationPointY = -2.0F + MathHelper.cos(((float)(i * 2) + f2) * 0.25F);
        this.Shape2.rotationPointX = MathHelper.cos(f6) * 9.0F;
        this.Shape3.rotationPointZ = MathHelper.sin(f6) * 9.0F;
        this.Shape4.rotationPointY = -4.5F + MathHelper.cos(((float)(i * 2) + f2) * 0.25F);
        this.Shape5.rotationPointX = MathHelper.cos(f6) * 6.0F;
        this.Shape6.rotationPointZ = MathHelper.sin(f6) * 6.0F;
        this.Shape7.rotationPointY = -6.0F + MathHelper.cos(((float)(i * 2) + f2) * 0.25F);
        this.Shape8.rotationPointX = MathHelper.cos(f6) * 12.0F;
        this.Shape9.rotationPointZ = MathHelper.sin(f6) * 12.0F;
        this.Shape10.rotationPointY = -8.5F + MathHelper.cos(((float)(i * 2) + f2) * 0.25F);
        this.Shape11.rotationPointX = MathHelper.cos(f6) * 2.0F;
        this.Shape12.rotationPointZ = MathHelper.sin(f6) * 2.0F;
        ++f6;
    }

    f6 = ((float)Math.PI / 4F) + f2 * (float)Math.PI * 0.03F;

    for (i = 4; i < 8; ++i)
    {
        this.Shape1.rotationPointY = 2.0F + MathHelper.cos(((float)(i * 2) + f2) * 0.25F);
        this.Shape2.rotationPointX = MathHelper.cos(f6) * 7.0F;
        this.Shape3.rotationPointZ = MathHelper.sin(f6) * 7.0F;
        this.Shape4.rotationPointY = 4.5F + MathHelper.cos(((float)(i * 2) + f2) * 0.25F);
        this.Shape5.rotationPointX = MathHelper.cos(f6) * 9.0F;
        this.Shape6.rotationPointZ = MathHelper.sin(f6) * 9.0F;
        this.Shape7.rotationPointY = 6.0F + MathHelper.cos(((float)(i * 2) + f2) * 0.25F);
        this.Shape8.rotationPointX = MathHelper.cos(f6) * 10.0F;
        this.Shape9.rotationPointZ = MathHelper.sin(f6) * 10.0F;
        this.Shape10.rotationPointY = 8.5F + MathHelper.cos(((float)(i * 2) + f2) * 0.25F);
        this.Shape11.rotationPointX = MathHelper.cos(f6) * 5.0F;
        this.Shape12.rotationPointZ = MathHelper.sin(f6) * 5.0F;
        ++f6;
    }

    f6 = 0.47123894F + f2 * (float)Math.PI * -0.05F;

    for (i = 8; i < 12; ++i)
    {
    	Shape1.rotationPointY = 11.0F + MathHelper.cos(((float)i * 1.5F + f2) * 0.5F);
    	Shape2.rotationPointX = MathHelper.cos(f6) * 8.0F;
    	Shape3.rotationPointZ = MathHelper.sin(f6) * 8.0F;
    	Shape4.rotationPointY = 13.5F + MathHelper.cos(((float)i * 1.5F + f2) * 0.5F);
    	Shape5.rotationPointX = MathHelper.cos(f6) * 10.0F;
    	Shape6.rotationPointZ = MathHelper.sin(f6) * 10.0F;
    	Shape7.rotationPointY = 14.0F + MathHelper.cos(((float)i * 1.5F + f2) * 0.5F);
    	Shape8.rotationPointX = MathHelper.cos(f6) * 6.0F;
    	Shape9.rotationPointZ = MathHelper.sin(f6) * 6.0F;
    	Shape10.rotationPointY = 16.5F + MathHelper.cos(((float)i * 1.5F + f2) * 0.5F);
    	Shape11.rotationPointX = MathHelper.cos(f6) * 3.0F;
    	Shape12.rotationPointZ = MathHelper.sin(f6) * 3.0F;
        ++f6;
    }
    if(random.nextInt(40) == 5)
    {
	    en.worldObj.spawnParticle(EnumParticleTypes.FLAME, en.posX + random.nextDouble() - random.nextDouble(), en.posY + random.nextDouble() - random.nextDouble(), en.posZ + random.nextDouble() - random.nextDouble(), 0, 0, 0, new int[0]);
	    en.worldObj.spawnParticle(EnumParticleTypes.FLAME, en.posX + random.nextDouble() - random.nextDouble(), en.posY + random.nextDouble() - random.nextDouble(), en.posZ + random.nextDouble() - random.nextDouble(), 0, 0, 0, new int[0]);
	
	    en.worldObj.spawnParticle(EnumParticleTypes.FLAME, en.posX + random.nextDouble() - random.nextDouble(), en.posY + random.nextDouble(), en.posZ + random.nextDouble() - random.nextDouble(), 0, 0, 0, new int[0]);
	    en.worldObj.spawnParticle(EnumParticleTypes.FLAME, en.posX + random.nextDouble() - random.nextDouble(), en.posY + random.nextDouble(), en.posZ + random.nextDouble() - random.nextDouble(), 0, 0, 0, new int[0]);
	
	    en.worldObj.spawnParticle(EnumParticleTypes.FLAME, en.posX + random.nextDouble() - random.nextDouble(), en.posY + random.nextDouble() + random.nextDouble(), en.posZ + random.nextDouble() - random.nextDouble(), 0, 0, 0, new int[0]);
	    en.worldObj.spawnParticle(EnumParticleTypes.FLAME, en.posX + random.nextDouble() - random.nextDouble(), en.posY + random.nextDouble() + random.nextDouble(), en.posZ + random.nextDouble() - random.nextDouble(), 0, 0, 0, new int[0]);
	
	    en.worldObj.spawnParticle(EnumParticleTypes.FLAME, en.posX + random.nextDouble() - random.nextDouble(), en.posY + random.nextDouble() + random.nextDouble() + random.nextDouble(), en.posZ + random.nextDouble() - random.nextDouble(), 0, 0, 0, new int[0]);
	    en.worldObj.spawnParticle(EnumParticleTypes.FLAME, en.posX + random.nextDouble() - random.nextDouble(), en.posY + random.nextDouble() + random.nextDouble() + random.nextDouble(), en.posZ + random.nextDouble() - random.nextDouble(), 0, 0, 0, new int[0]);
    }
  }

}
