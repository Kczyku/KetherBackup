package com.KMOD.Models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class ModelFloatingStone extends ModelBase
{
  //fields
    ModelRenderer Stone;
    ModelRenderer Grass;
    ModelRenderer Grass2;
    ModelRenderer Grass3;
    ModelRenderer Grass4;
    ModelRenderer Grass5;
  
  public ModelFloatingStone()
  {
    textureWidth = 128;
    textureHeight = 128;
    
      Stone = new ModelRenderer(this, 0, 41);
      Stone.addBox(0F, 0F, 0F, 16, 16, 16);
      Stone.setRotationPoint(-8F, -8F, -8F);
      Stone.setTextureSize(128, 128);
      Stone.mirror = true;
      setRotation(Stone, 0F, 0F, 0F);
      Grass = new ModelRenderer(this, 0, 0);
      Grass.addBox(0F, 0F, 0F, 16, 16, 16);
      Grass.setRotationPoint(-8F, -24F, -8F);
      Grass.setTextureSize(128, 128);
      Grass.mirror = true;
      setRotation(Grass, 0F, 0F, 0F);
      Grass2 = new ModelRenderer(this, 0, 0);
      Grass2.addBox(0F, 0F, 0F, 16, 16, 16);
      Grass2.setRotationPoint(-24F, -24F, -8F);
      Grass2.setTextureSize(128, 128);
      Grass2.mirror = true;
      setRotation(Grass2, 0F, 0F, 0F);
      Grass3 = new ModelRenderer(this, 0, 0);
      Grass3.addBox(0F, 0F, 0F, 16, 16, 16);
      Grass3.setRotationPoint(8F, -24F, -8F);
      Grass3.setTextureSize(128, 128);
      Grass3.mirror = true;
      setRotation(Grass3, 0F, 0F, 0F);
      Grass4 = new ModelRenderer(this, 0, 0);
      Grass4.addBox(0F, 0F, 0F, 16, 16, 16);
      Grass4.setRotationPoint(-8F, -24F, -24F);
      Grass4.setTextureSize(128, 128);
      Grass4.mirror = true;
      setRotation(Grass4, 0F, 0F, 0F);
      Grass5 = new ModelRenderer(this, 0, 0);
      Grass5.addBox(0F, 0F, 0F, 16, 16, 16);
      Grass5.setRotationPoint(-8F, -24F, 8F);
      Grass5.setTextureSize(128, 128);
      Grass5.mirror = true;
      setRotation(Grass5, 0F, 0F, 0F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    Stone.render(f5);
    Grass.render(f5);
    Grass2.render(f5);
    Grass3.render(f5);
    Grass4.render(f5);
    Grass5.render(f5);
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
