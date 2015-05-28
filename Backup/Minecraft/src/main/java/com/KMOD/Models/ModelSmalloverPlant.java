package com.KMOD.Models;

import java.util.Random;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class ModelSmalloverPlant extends ModelBase
{
  //fields
    ModelRenderer Podstawa;
    ModelRenderer Scianka1;
    ModelRenderer Scianka2;
    ModelRenderer Scianka3;
    ModelRenderer Scianka4;
    ModelRenderer Gardlo;
    ModelRenderer Jezyk1;
    ModelRenderer Jezyk2;
    ModelRenderer Jezyk3;
    ModelRenderer Jezyk4;
  
  public ModelSmalloverPlant()
  {
    textureWidth = 128;
    textureHeight = 128;
    
      Podstawa = new ModelRenderer(this, 0, 0);
      Podstawa.addBox(0F, 0F, 0F, 20, 0, 20);
      Podstawa.setRotationPoint(-10F, 24F, -10F);
      Podstawa.setTextureSize(128, 128);
      Podstawa.mirror = true;
      setRotation(Podstawa, 0F, 0F, 0F);
      Scianka1 = new ModelRenderer(this, 0, 100);
      Scianka1.addBox(0F, 0F, 0F, 6, 3, 1);
      Scianka1.setRotationPoint(-3F, 21F, -3F);
      Scianka1.setTextureSize(128, 128);
      Scianka1.mirror = true;
      setRotation(Scianka1, 0F, 0F, 0F);
      Scianka2 = new ModelRenderer(this, 0, 100);
      Scianka2.addBox(0F, 0F, 0F, 6, 3, 1);
      Scianka2.setRotationPoint(-3F, 21F, 2F);
      Scianka2.setTextureSize(128, 128);
      Scianka2.mirror = true;
      setRotation(Scianka2, 0F, 0F, 0F);
      Scianka3 = new ModelRenderer(this, 20, 100);
      Scianka3.addBox(0F, 0F, 0F, 1, 3, 4);
      Scianka3.setRotationPoint(-3F, 21F, -2F);
      Scianka3.setTextureSize(128, 128);
      Scianka3.mirror = true;
      setRotation(Scianka3, 0F, 0F, 0F);
      Scianka4 = new ModelRenderer(this, 20, 100);
      Scianka4.addBox(0F, 0F, 0F, 1, 3, 4);
      Scianka4.setRotationPoint(2F, 21F, -2F);
      Scianka4.setTextureSize(128, 128);
      Scianka4.mirror = true;
      setRotation(Scianka4, 0F, 0F, 0F);
      Gardlo = new ModelRenderer(this, 50, 100);
      Gardlo.addBox(0F, 0F, 0F, 4, 1, 4);
      Gardlo.setRotationPoint(-2F, 23F, -2F);
      Gardlo.setTextureSize(128, 128);
      Gardlo.mirror = true;
      setRotation(Gardlo, 0F, 0F, 0F);
      Jezyk1 = new ModelRenderer(this, 100, 50);
      Jezyk1.addBox(0F, 0F, 0F, 9, 1, 4);
      Jezyk1.setRotationPoint(2F, 22F, -2F);
      Jezyk1.setTextureSize(128, 128);
      Jezyk1.mirror = true;
      setRotation(Jezyk1, 0F, 0F, 0.1570796F);
      Jezyk2 = new ModelRenderer(this, 0, 50);
      Jezyk2.addBox(0F, 0F, 0F, 4, 1, 9);
      Jezyk2.setRotationPoint(-2F, 22F, 2F);
      Jezyk2.setTextureSize(128, 128);
      Jezyk2.mirror = true;
      setRotation(Jezyk2, -0.1570796F, 0F, 0F);
      Jezyk3 = new ModelRenderer(this, 100, 50);
      Jezyk3.addBox(0F, 0F, 0F, 9, 1, 4);
      Jezyk3.setRotationPoint(-2F, 23F, -2F);
      Jezyk3.setTextureSize(128, 128);
      Jezyk3.mirror = true;
      setRotation(Jezyk3, 0F, 0F, 2.984513F);
      Jezyk4 = new ModelRenderer(this, 0, 50);
      Jezyk4.addBox(0F, 0F, 0F, 4, 1, 9);
      Jezyk4.setRotationPoint(2F, 22F, -2F);
      Jezyk4.setTextureSize(128, 128);
      Jezyk4.mirror = true;
      setRotation(Jezyk4, -0.1570796F, 3.141593F, 0F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    Podstawa.render(f5);
    Scianka1.render(f5);
    Scianka2.render(f5);
    Scianka3.render(f5);
    Scianka4.render(f5);
    Gardlo.render(f5);
    Jezyk1.render(f5);
    Jezyk2.render(f5);
    Jezyk3.render(f5);
    Jezyk4.render(f5);
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

	  

  }

}
	