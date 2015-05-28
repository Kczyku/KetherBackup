package com.KMOD.Models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class ModelBird extends ModelBase
{
  //fields
    ModelRenderer Noga1;
    ModelRenderer Noga2;
    ModelRenderer Klata;
    ModelRenderer Wing1;
    ModelRenderer Wing2;
    ModelRenderer Glowa;
    ModelRenderer Oko1;
    ModelRenderer Oko2;
    ModelRenderer Dziobek;
  
  public ModelBird()
  {
    textureWidth = 64;
    textureHeight = 64;
    
      Noga1 = new ModelRenderer(this, 50, 50);
      Noga1.addBox(0F, 0F, 0F, 1, 1, 1);
      Noga1.setRotationPoint(0F, 23F, -1F);
      Noga1.setTextureSize(64, 64);
      Noga1.mirror = true;
      setRotation(Noga1, 0F, 0F, 0F);
      Noga2 = new ModelRenderer(this, 50, 50);
      Noga2.addBox(0F, 0F, 0F, 1, 1, 1);
      Noga2.setRotationPoint(-2F, 23F, -1F);
      Noga2.setTextureSize(64, 64);
      Noga2.mirror = true;
      setRotation(Noga2, 0F, 0F, 0F);
      Klata = new ModelRenderer(this, 0, 0);
      Klata.addBox(0F, 0F, 0F, 3, 3, 4);
      Klata.setRotationPoint(-2F, 20F, -2F);
      Klata.setTextureSize(64, 64);
      Klata.mirror = true;
      setRotation(Klata, 0F, 0F, 0F);
      Wing1 = new ModelRenderer(this, 50, 0);
      Wing1.addBox(0F, 0F, 0F, 1, 2, 2);
      Wing1.setRotationPoint(1F, 20F, -1F);
      Wing1.setTextureSize(64, 64);
      Wing1.mirror = true;
      setRotation(Wing1, 0F, 0F, 0F);
      Wing2 = new ModelRenderer(this, 50, 0);
      Wing2.addBox(0F, 0F, 0F, 1, 2, 2);
      Wing2.setRotationPoint(-3F, 20F, -1F);
      Wing2.setTextureSize(64, 64);
      Wing2.mirror = true;
      setRotation(Wing2, 0F, 0F, 0F);
      Glowa = new ModelRenderer(this, 20, 20);
      Glowa.addBox(0F, 0F, 0F, 3, 4, 3);
      Glowa.setRotationPoint(-2F, 18F, -4F);
      Glowa.setTextureSize(64, 64);
      Glowa.mirror = true;
      setRotation(Glowa, 0F, 0F, 0F);
      Oko1 = new ModelRenderer(this, 40, 40);
      Oko1.addBox(0F, 0F, 0F, 1, 1, 1);
      Oko1.setRotationPoint(0.3F, 19F, -3.7F);
      Oko1.setTextureSize(64, 64);
      Oko1.mirror = true;
      setRotation(Oko1, 0F, 0F, 0F);
      Oko2 = new ModelRenderer(this, 40, 40);
      Oko2.addBox(0F, 0F, 0F, 1, 1, 1);
      Oko2.setRotationPoint(-2.3F, 19F, -3.7F);
      Oko2.setTextureSize(64, 64);
      Oko2.mirror = true;
      setRotation(Oko2, 0F, 0F, 0F);
      Dziobek = new ModelRenderer(this, 20, 0);
      Dziobek.addBox(0F, 0F, 0F, 1, 1, 1);
      Dziobek.setRotationPoint(-1F, 19F, -4F);
      Dziobek.setTextureSize(64, 64);
      Dziobek.mirror = true;
      setRotation(Dziobek, -0.7853982F, 0F, 0F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    Noga1.render(f5);
    Noga2.render(f5);
    Klata.render(f5);
    Wing1.render(f5);
    Wing2.render(f5);
    Glowa.render(f5);
    Oko1.render(f5);
    Oko2.render(f5);
    Dziobek.render(f5);
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
    if(en.isCollidedVertically)
    {
    	this.Noga1.rotateAngleX = MathHelper.cos(f * 0.6662F) * 1.4F * f1;
    	this.Noga2.rotateAngleX = MathHelper.cos(f * 0.6662F + (float)Math.PI) * 1.4F * f1;
    }
    
    this.Wing1.rotateAngleZ = MathHelper.cos(f * 0.6662F) * 1.4F * f1;
    this.Wing2.rotateAngleZ = MathHelper.cos(f * 0.6662F + (float)Math.PI) * 1.4F * f1;
  }

}
