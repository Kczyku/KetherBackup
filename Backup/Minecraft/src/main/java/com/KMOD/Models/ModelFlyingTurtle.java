package com.KMOD.Models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class ModelFlyingTurtle extends ModelBase
{
  //fields
    ModelRenderer Shape1;
    ModelRenderer Shape2;
    ModelRenderer Noga1;
    ModelRenderer Noga2;
    ModelRenderer Noga3;
    ModelRenderer Noga4;
  
  public ModelFlyingTurtle()
  {
    textureWidth = 128;
    textureHeight = 128;
    
      Shape1 = new ModelRenderer(this, 0, 20);
      Shape1.addBox(0F, 0F, 0F, 6, 3, 11);
      Shape1.setRotationPoint(-3F, 21F, -6F);
      Shape1.setTextureSize(128, 128);
      Shape1.mirror = true;
      setRotation(Shape1, 0F, 0F, 0F);
      Shape2 = new ModelRenderer(this, 51, 0);
      Shape2.addBox(0F, 0F, 0F, 4, 4, 3);
      Shape2.setRotationPoint(-2F, 20F, -9F);
      Shape2.setTextureSize(128, 128);
      Shape2.mirror = true;
      setRotation(Shape2, 0F, 0F, 0F);
      Noga1 = new ModelRenderer(this, 0, 0);
      Noga1.addBox(0F, 0F, 0F, 2, 2, 4);
      Noga1.setRotationPoint(2F, 22F, -4F);
      Noga1.setTextureSize(128, 128);
      Noga1.mirror = true;
      setRotation(Noga1, 0F, 0.5948578F, 0F);
      Noga2 = new ModelRenderer(this, 0, 0);
      Noga2.addBox(0F, 0F, 0F, 2, 2, 4);
      Noga2.setRotationPoint(-4F, 22F, -5F);
      Noga2.setTextureSize(128, 128);
      Noga2.mirror = true;
      setRotation(Noga2, 0F, -0.5948578F, 0F);
      Noga3 = new ModelRenderer(this, 80, 0);
      Noga3.addBox(0F, 0F, 0F, 2, 2, 3);
      Noga3.setRotationPoint(-4F, 22F, 2F);
      Noga3.setTextureSize(128, 128);
      Noga3.mirror = true;
      setRotation(Noga3, 0F, -0.5934119F, 0F);
      Noga4 = new ModelRenderer(this, 80, 0);
      Noga4.addBox(0F, 0F, 0F, 2, 2, 3);
      Noga4.setRotationPoint(2F, 22F, 3F);
      Noga4.setTextureSize(128, 128);
      Noga4.mirror = true;
      setRotation(Noga4, 0F, 0.5934119F, 0F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    Shape1.render(f5);
    Shape2.render(f5);
    Noga1.render(f5);
    Noga2.render(f5);
    Noga3.render(f5);
    Noga4.render(f5);
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
    this.Noga1.rotateAngleY = MathHelper.cos(f * 0.6662F) * 1.4F * f1;
    this.Noga2.rotateAngleY = MathHelper.cos(f * 0.6662F + (float)Math.PI) * 1.4F * f1;
    this.Noga3.rotateAngleY = MathHelper.cos(f * 0.6662F + (float)Math.PI) * 1.4F * f1;
    this.Noga4.rotateAngleY = MathHelper.cos(f * 0.6662F) * 1.4F * f1;
  }

}
