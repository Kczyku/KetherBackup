package com.KMOD.Models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class ModelGrittyMonstrosity extends ModelBase
{
  //fields
    ModelRenderer Body;
    ModelRenderer Leg1;
    ModelRenderer Leg2;
    ModelRenderer Rog;
    ModelRenderer Rog2;
    ModelRenderer Arm1;
    ModelRenderer Arm2;
    ModelRenderer Geba;
  
  public ModelGrittyMonstrosity()
  {
    textureWidth = 64;
    textureHeight = 64;
    
      Body = new ModelRenderer(this, 0, 0);
      Body.addBox(0F, 0F, 0F, 9, 10, 10);
      Body.setRotationPoint(-5F, 9F, -5F);
      Body.setTextureSize(64, 64);
      Body.mirror = true;
      setRotation(Body, 0F, 0F, 0F);
      Leg1 = new ModelRenderer(this, 50, 0);
      Leg1.addBox(0F, 0F, 0F, 3, 6, 3);
      Leg1.setRotationPoint(0F, 18F, -2F);
      Leg1.setTextureSize(64, 64);
      Leg1.mirror = true;
      setRotation(Leg1, 0F, 0F, 0F);
      Leg2 = new ModelRenderer(this, 50, 0);
      Leg2.addBox(0F, 0F, 0F, 3, 6, 3);
      Leg2.setRotationPoint(-4F, 18F, -2F);
      Leg2.setTextureSize(64, 64);
      Leg2.mirror = true;
      setRotation(Leg2, 0F, 0F, 0F);
      Rog = new ModelRenderer(this, 0, 25);
      Rog.addBox(0F, 0F, 0F, 2, 3, 2);
      Rog.setRotationPoint(0F, 6F, -2F);
      Rog.setTextureSize(64, 64);
      Rog.mirror = true;
      setRotation(Rog, 0F, 0F, 0F);
      Rog2 = new ModelRenderer(this, 0, 25);
      Rog2.addBox(0F, 0F, 0F, 2, 3, 2);
      Rog2.setRotationPoint(-3F, 6F, -2F);
      Rog2.setTextureSize(64, 64);
      Rog2.mirror = true;
      setRotation(Rog2, 0F, 0F, 0F);
      Arm1 = new ModelRenderer(this, 0, 50);
      Arm1.addBox(0F, 0F, 0F, 3, 7, 3);
      Arm1.setRotationPoint(3F, 11F, -2F);
      Arm1.setTextureSize(64, 64);
      Arm1.mirror = true;
      setRotation(Arm1, 0F, 0F, -0.1745329F);
      Arm2 = new ModelRenderer(this, 0, 50);
      Arm2.addBox(0F, 0F, 0F, 3, 7, 3);
      Arm2.setRotationPoint(-7F, 11F, -2F);
      Arm2.setTextureSize(64, 64);
      Arm2.mirror = true;
      setRotation(Arm2, 0F, 0F, 0.1745329F);
      Geba = new ModelRenderer(this, 47, 50);
      Geba.addBox(0F, 0F, 0F, 7, 7, 1);
      Geba.setRotationPoint(-4F, 11F, -6F);
      Geba.setTextureSize(64, 64);
      Geba.mirror = true;
      setRotation(Geba, 0F, 0F, 0F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    Body.render(f5);
    Leg1.render(f5);
    Leg2.render(f5);
    Rog.render(f5);
    Rog2.render(f5);
    Arm1.render(f5);
    Arm2.render(f5);
    Geba.render(f5);
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
    
    this.Leg1.rotateAngleX = MathHelper.cos(f * 0.6662F) * 1.4F * f1;
    this.Leg2.rotateAngleX = MathHelper.cos(f * 0.6662F + (float)Math.PI) * 1.4F * f1;
    this.Arm1.rotateAngleX = MathHelper.cos(f * 0.6662F + (float)Math.PI) * 1.4F * f1;
    this.Arm2.rotateAngleX = MathHelper.cos(f * 0.6662F) * 1.4F * f1;
  }

}
