package com.KMOD.Models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class ModelKetherus extends ModelBase
{
  //fields
    ModelRenderer Leg1;
    ModelRenderer Leg2;
    ModelRenderer Leg3;
    ModelRenderer Leg4;
    ModelRenderer Body;
    ModelRenderer Neck1;
    ModelRenderer Neck2;
    ModelRenderer Head;
    ModelRenderer Rog;
  
  public ModelKetherus()
  {
    textureWidth = 64;
    textureHeight = 64;
    
      Leg1 = new ModelRenderer(this, 50, 50);
      Leg1.addBox(0F, 0F, 0F, 2, 3, 2);
      Leg1.setRotationPoint(3F, 21F, 5F);
      Leg1.setTextureSize(64, 64);
      Leg1.mirror = true;
      setRotation(Leg1, 0F, 0F, 0F);
      Leg2 = new ModelRenderer(this, 50, 50);
      Leg2.addBox(0F, 0F, 0F, 2, 3, 2);
      Leg2.setRotationPoint(-5F, 21F, 5F);
      Leg2.setTextureSize(64, 64);
      Leg2.mirror = true;
      setRotation(Leg2, 0F, 0F, 0F);
      Leg3 = new ModelRenderer(this, 50, 50);
      Leg3.addBox(0F, 0F, 0F, 2, 3, 2);
      Leg3.setRotationPoint(3F, 21F, -5F);
      Leg3.setTextureSize(64, 64);
      Leg3.mirror = true;
      setRotation(Leg3, 0F, 0F, 0F);
      Leg4 = new ModelRenderer(this, 50, 50);
      Leg4.addBox(0F, 0F, 0F, 2, 3, 2);
      Leg4.setRotationPoint(-5F, 21F, -5F);
      Leg4.setTextureSize(64, 64);
      Leg4.mirror = true;
      setRotation(Leg4, 0F, 0F, 0F);
      Body = new ModelRenderer(this, 0, 0);
      Body.addBox(0F, 0F, 0F, 10, 3, 12);
      Body.setRotationPoint(-5F, 18F, -5F);
      Body.setTextureSize(64, 64);
      Body.mirror = true;
      setRotation(Body, 0F, 0F, 0F);
      Neck1 = new ModelRenderer(this, 0, 30);
      Neck1.addBox(0F, 0F, 0F, 2, 3, 2);
      Neck1.setRotationPoint(-1F, 17F, -7F);
      Neck1.setTextureSize(64, 64);
      Neck1.mirror = true;
      setRotation(Neck1, 0.4833219F, 0F, 0F);
      Neck2 = new ModelRenderer(this, 0, 30);
      Neck2.addBox(0F, 0F, 0F, 2, 3, 2);
      Neck2.setRotationPoint(-1F, 14F, -7.7F);
      Neck2.setTextureSize(64, 64);
      Neck2.mirror = true;
      setRotation(Neck2, 0.2230717F, 0F, 0F);
      Head = new ModelRenderer(this, 0, 50);
      Head.addBox(0F, 0F, 0F, 4, 2, 3);
      Head.setRotationPoint(-2F, 12F, -9F);
      Head.setTextureSize(64, 64);
      Head.mirror = true;
      setRotation(Head, 0F, 0F, 0F);
      Rog = new ModelRenderer(this, 50, 0);
      Rog.addBox(0F, 0F, 0F, 2, 1, 1);
      Rog.setRotationPoint(-1F, 11F, -9F);
      Rog.setTextureSize(64, 64);
      Rog.mirror = true;
      setRotation(Rog, 0F, 0F, 0F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    Leg1.render(f5);
    Leg2.render(f5);
    Leg3.render(f5);
    Leg4.render(f5);
    Body.render(f5);
    Neck1.render(f5);
    Neck2.render(f5);
    Head.render(f5);
    Rog.render(f5);
  }
  
  private void setRotation(ModelRenderer model, float x, float y, float z)
  {
    model.rotateAngleX = x;
    model.rotateAngleY = y;
    model.rotateAngleZ = z;
  }
  
  public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity en)
  {
    super.setRotationAngles(f, f1, f2, f3, f4, f5, en);
    this.Leg1.rotateAngleX = MathHelper.cos(f * 0.6662F) * 1.4F * f1;
    this.Leg2.rotateAngleX = MathHelper.cos(f * 0.6662F + (float)Math.PI) * 1.4F * f1;
    this.Leg3.rotateAngleX = MathHelper.cos(f * 0.6662F + (float)Math.PI) * 1.4F * f1;
    this.Leg4.rotateAngleX = MathHelper.cos(f * 0.6662F) * 1.4F * f1;
  }

}