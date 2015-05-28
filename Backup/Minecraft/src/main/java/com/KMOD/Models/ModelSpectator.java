package com.KMOD.Models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelSpectator extends ModelBase
{
  //fields
    ModelRenderer Body;
    ModelRenderer Oko1;
    ModelRenderer Oko2;
    ModelRenderer Oko3;
    ModelRenderer Oko4;
  
  public ModelSpectator()
  {
    textureWidth = 64;
    textureHeight = 64;
    
      Body = new ModelRenderer(this, 0, 0);
      Body.addBox(0F, 0F, 0F, 16, 16, 16);
      Body.setRotationPoint(-8F, -5F, -8F);
      Body.setTextureSize(64, 64);
      Body.mirror = true;
      setRotation(Body, 0F, 0F, 0F);
      Oko1 = new ModelRenderer(this, 0, 32);
      Oko1.addBox(0F, 0F, 0F, 8, 8, 6);
      Oko1.setRotationPoint(-15F, -1F, -4F);
      Oko1.setTextureSize(64, 64);
      Oko1.mirror = true;
      setRotation(Oko1, 0F, 0F, 0F);
      Oko2 = new ModelRenderer(this, 36, 32);
      Oko2.addBox(0F, 0F, 0F, 8, 8, 6);
      Oko2.setRotationPoint(7F, -1F, -4F);
      Oko2.setTextureSize(64, 64);
      Oko2.mirror = true;
      setRotation(Oko2, 0F, 0F, 0F);
      Oko3 = new ModelRenderer(this, 0, 48);
      Oko3.addBox(0F, 0F, 0F, 8, 8, 6);
      Oko3.setRotationPoint(-4F, -12F, -4F);
      Oko3.setTextureSize(64, 64);
      Oko3.mirror = true;
      setRotation(Oko3, 0F, 0F, 0F);
      Oko4 = new ModelRenderer(this, 36, 48);
      Oko4.addBox(0F, 0F, 0F, 8, 8, 6);
      Oko4.setRotationPoint(-4F, 10F, -4F);
      Oko4.setTextureSize(64, 64);
      Oko4.mirror = true;
      setRotation(Oko4, 0F, 0F, 0F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    Body.render(f5);
    Oko1.render(f5);
    Oko2.render(f5);
    Oko3.render(f5);
    Oko4.render(f5);
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
