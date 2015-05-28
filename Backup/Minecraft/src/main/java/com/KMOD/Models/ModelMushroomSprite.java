package com.KMOD.Models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class ModelMushroomSprite extends ModelBase
{
  //fields
    ModelRenderer Noga1;
    ModelRenderer Noga2;
    ModelRenderer Trzon;
    ModelRenderer Kapelutek;
  
  public ModelMushroomSprite()
  {
    textureWidth = 64;
    textureHeight = 64;
    
      Noga1 = new ModelRenderer(this, 50, 50);
      Noga1.addBox(0F, 0F, 0F, 2, 2, 2);
      Noga1.setRotationPoint(-4F, 22F, -1F);
      Noga1.setTextureSize(64, 64);
      Noga1.mirror = true;
      setRotation(Noga1, 0F, 0F, 0F);
      Noga2 = new ModelRenderer(this, 50, 50);
      Noga2.addBox(0F, 0F, 0F, 2, 2, 2);
      Noga2.setRotationPoint(2F, 22F, -1F);
      Noga2.setTextureSize(64, 64);
      Noga2.mirror = true;
      setRotation(Noga2, 0F, 0F, 0F);
      Trzon = new ModelRenderer(this, 0, 0);
      Trzon.addBox(0F, 0F, 0F, 6, 6, 4);
      Trzon.setRotationPoint(-3F, 17F, -2F);
      Trzon.setTextureSize(64, 64);
      Trzon.mirror = true;
      setRotation(Trzon, 0F, 0F, 0F);
      Kapelutek = new ModelRenderer(this, 0, 50);
      Kapelutek.addBox(0F, 0F, 0F, 8, 2, 6);
      Kapelutek.setRotationPoint(-4F, 15F, -3F);
      Kapelutek.setTextureSize(64, 64);
      Kapelutek.mirror = true;
      setRotation(Kapelutek, 0F, 0F, 0F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    Noga1.render(f5);
    Noga2.render(f5);
    Trzon.render(f5);
    Kapelutek.render(f5);
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
    this.Noga1.rotateAngleX = MathHelper.cos(f * 0.6662F) * 1.4F * f1;
    this.Noga2.rotateAngleX = MathHelper.cos(f * 0.6662F + (float)Math.PI) * 1.4F * f1;
  }

}
