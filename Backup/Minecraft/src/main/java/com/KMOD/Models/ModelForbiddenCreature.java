package com.KMOD.Models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class ModelForbiddenCreature extends ModelBase
{
  //fields
    ModelRenderer Body;
    ModelRenderer Shape2;
    ModelRenderer Shape3;
    ModelRenderer Shape4;
    ModelRenderer Shape5;
    ModelRenderer Shape6;
  
  public ModelForbiddenCreature()
  {
    textureWidth = 128;
    textureHeight = 128;
    
      Body = new ModelRenderer(this, 0, 0);
      Body.addBox(0F, 0F, 0F, 10, 10, 10);
      Body.setRotationPoint(-5F, 0F, -5F);
      Body.setTextureSize(128, 128);
      Body.mirror = true;
      setRotation(Body, 0F, 0F, 0F);
      Shape2 = new ModelRenderer(this, 50, 0);
      Shape2.addBox(0F, 0F, 0F, 1, 1, 1);
      Shape2.setRotationPoint(-10F, 0F, 0F);
      Shape2.setTextureSize(128, 128);
      Shape2.mirror = true;
      setRotation(Shape2, 0F, 0F, 0F);
      Shape3 = new ModelRenderer(this, 50, 0);
      Shape3.addBox(0F, 0F, 0F, 1, 1, 1);
      Shape3.setRotationPoint(-10F, 4F, 0F);
      Shape3.setTextureSize(128, 128);
      Shape3.mirror = true;
      setRotation(Shape3, 0F, 0F, 0F);
      Shape4 = new ModelRenderer(this, 50, 0);
      Shape4.addBox(0F, 0F, 0F, 1, 1, 1);
      Shape4.setRotationPoint(-10F, 2F, 0F);
      Shape4.setTextureSize(128, 128);
      Shape4.mirror = true;
      setRotation(Shape4, 0F, 0F, 0F);
      Shape5 = new ModelRenderer(this, 50, 0);
      Shape5.addBox(0F, 0F, 0F, 1, 1, 1);
      Shape5.setRotationPoint(-10F, 6F, 0F);
      Shape5.setTextureSize(128, 128);
      Shape5.mirror = true;
      setRotation(Shape5, 0F, 0F, 0F);
      Shape6 = new ModelRenderer(this, 50, 0);
      Shape6.addBox(0F, 0F, 0F, 1, 1, 1);
      Shape6.setRotationPoint(-10F, 8F, 0F);
      Shape6.setTextureSize(128, 128);
      Shape6.mirror = true;
      setRotation(Shape6, 0F, 0F, 0F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    Body.render(f5);
    Shape2.render(f5);
    Shape3.render(f5);
    Shape4.render(f5);
    Shape5.render(f5);
    Shape6.render(f5);
  }
  
  private void setRotation(ModelRenderer model, float x, float y, float z)
  {
    model.rotateAngleX = x;
    model.rotateAngleY = y;
    model.rotateAngleZ = z;
  }
  
  public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity e)
  {
    super.setRotationAngles(f, f1, f2, f3, f4, f5, e);
    int i = 3;

    float f6 = f2 * (float)Math.PI * -0.1F;

    this.Shape2.rotationPointY = -2.0F + MathHelper.cos(((float)(i * 2) + f2) * 0.25F);
    this.Shape2.rotationPointX = MathHelper.cos(f6) * 9.0F;
    this.Shape2.rotationPointZ = MathHelper.sin(f6) * 9.0F;
    
    this.Shape3.rotationPointY = -4.0F + MathHelper.cos(((float)(i * 2) + f2) * 0.25F);
    this.Shape3.rotationPointX = MathHelper.cos(f6) * 9.0F;
    this.Shape3.rotationPointZ = MathHelper.sin(f6) * 9.0F;
    
    this.Shape4.rotationPointY = -6.0F + MathHelper.cos(((float)(i * 2) + f2) * 0.25F);
    this.Shape4.rotationPointX = MathHelper.cos(f6) * 9.0F;
    this.Shape4.rotationPointZ = MathHelper.sin(f6) * 9.0F;
    
    this.Shape5.rotationPointY = -8.0F + MathHelper.cos(((float)(i * 2) + f2) * 0.25F);
    this.Shape5.rotationPointX = MathHelper.cos(f6) * 9.0F;
    this.Shape5.rotationPointZ = MathHelper.sin(f6) * 9.0F;
    
    this.Shape6.rotationPointY = -10.0F + MathHelper.cos(((float)(i * 2) + f2) * 0.25F);
    this.Shape6.rotationPointX = MathHelper.cos(f6) * 9.0F;
    this.Shape6.rotationPointZ = MathHelper.sin(f6) * 9.0F;
  }

}
