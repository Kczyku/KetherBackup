package com.KMOD.Models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class ModelBoar extends ModelBase
{
  //fields
    ModelRenderer Body;
    ModelRenderer Leg1;
    ModelRenderer Leg2;
    ModelRenderer Leg3;
    ModelRenderer Leg4;
    ModelRenderer Tail;
    ModelRenderer Morda;
    ModelRenderer Zab1;
    ModelRenderer Zab2;
    ModelRenderer Zab3;
    ModelRenderer Zab4;
    ModelRenderer Zab5;
    ModelRenderer Zab6;
    ModelRenderer Zab7;
    ModelRenderer Zab8;
    ModelRenderer Grzbiet1;
    ModelRenderer Grzbiet2;
    ModelRenderer Grzbiet3;
    ModelRenderer Grzbiet4;
    ModelRenderer Grzbiet5;
  
  public ModelBoar()
  {
    textureWidth = 128;
    textureHeight = 128;
    
      Body = new ModelRenderer(this, 0, 19);
      Body.addBox(0F, 0F, 0F, 14, 14, 19);
      Body.setRotationPoint(-7F, 7F, -8F);
      Body.setTextureSize(128, 128);
      Body.mirror = true;
      setRotation(Body, 0F, 0F, 0F);
      Leg1 = new ModelRenderer(this, 20, 0);
      Leg1.addBox(0F, 0F, 0F, 2, 3, 2);
      Leg1.setRotationPoint(-7F, 21F, -8F);
      Leg1.setTextureSize(128, 128);
      Leg1.mirror = true;
      setRotation(Leg1, 0F, 0F, 0F);
      Leg2 = new ModelRenderer(this, 20, 0);
      Leg2.addBox(0F, 0F, 0F, 2, 3, 2);
      Leg2.setRotationPoint(5F, 21F, 9F);
      Leg2.setTextureSize(128, 128);
      Leg2.mirror = true;
      setRotation(Leg2, 0F, 0F, 0F);
      Leg3 = new ModelRenderer(this, 20, 0);
      Leg3.addBox(0F, 0F, 0F, 2, 3, 2);
      Leg3.setRotationPoint(5F, 21F, -8F);
      Leg3.setTextureSize(128, 128);
      Leg3.mirror = true;
      setRotation(Leg3, 0F, 0F, 0F);
      Leg4 = new ModelRenderer(this, 20, 0);
      Leg4.addBox(0F, 0F, 0F, 2, 3, 2);
      Leg4.setRotationPoint(-7F, 21F, 9F);
      Leg4.setTextureSize(128, 128);
      Leg4.mirror = true;
      setRotation(Leg4, 0F, 0F, 0F);
      Tail = new ModelRenderer(this, 50, 0);
      Tail.addBox(0F, 0F, 0F, 2, 2, 4);
      Tail.setRotationPoint(-1F, 10F, 11F);
      Tail.setTextureSize(128, 128);
      Tail.mirror = true;
      setRotation(Tail, -0.5205006F, 0F, 0F);
      Morda = new ModelRenderer(this, 0, 58);
      Morda.addBox(0F, 0F, 0F, 14, 8, 1);
      Morda.setRotationPoint(-7F, 13F, -9F);
      Morda.setTextureSize(128, 128);
      Morda.mirror = true;
      setRotation(Morda, 0F, 0F, 0F);
      Zab1 = new ModelRenderer(this, 0, 0);
      Zab1.addBox(0F, 0F, 0F, 1, 1, 1);
      Zab1.setRotationPoint(6F, 12F, -9F);
      Zab1.setTextureSize(128, 128);
      Zab1.mirror = true;
      setRotation(Zab1, 0F, 0F, 0F);
      Zab2 = new ModelRenderer(this, 0, 0);
      Zab2.addBox(0F, 0F, 0F, 1, 1, 1);
      Zab2.setRotationPoint(-7F, 12F, -9F);
      Zab2.setTextureSize(128, 128);
      Zab2.mirror = true;
      setRotation(Zab2, 0F, 0F, 0F);
      Zab3 = new ModelRenderer(this, 0, 0);
      Zab3.addBox(0F, 0F, 0F, 1, 1, 1);
      Zab3.setRotationPoint(2F, 12F, -9F);
      Zab3.setTextureSize(128, 128);
      Zab3.mirror = true;
      setRotation(Zab3, 0F, 0F, 0F);
      Zab4 = new ModelRenderer(this, 0, 0);
      Zab4.addBox(0F, 0F, 0F, 1, 1, 1);
      Zab4.setRotationPoint(-5F, 12F, -9F);
      Zab4.setTextureSize(128, 128);
      Zab4.mirror = true;
      setRotation(Zab4, 0F, 0F, 0F);
      Zab5 = new ModelRenderer(this, 0, 0);
      Zab5.addBox(0F, 0F, 0F, 1, 1, 1);
      Zab5.setRotationPoint(4F, 12F, -9F);
      Zab5.setTextureSize(128, 128);
      Zab5.mirror = true;
      setRotation(Zab5, 0F, 0F, 0F);
      Zab6 = new ModelRenderer(this, 0, 0);
      Zab6.addBox(0F, 0F, 0F, 1, 1, 1);
      Zab6.setRotationPoint(-3F, 12F, -9F);
      Zab6.setTextureSize(128, 128);
      Zab6.mirror = true;
      setRotation(Zab6, 0F, 0F, 0F);
      Zab7 = new ModelRenderer(this, 0, 0);
      Zab7.addBox(0F, 0F, 0F, 1, 1, 1);
      Zab7.setRotationPoint(0F, 12F, -9F);
      Zab7.setTextureSize(128, 128);
      Zab7.mirror = true;
      setRotation(Zab7, 0F, 0F, 0F);
      Zab8 = new ModelRenderer(this, 0, 0);
      Zab8.addBox(0F, 0F, 0F, 1, 1, 1);
      Zab8.setRotationPoint(-1F, 12F, -9F);
      Zab8.setTextureSize(128, 128);
      Zab8.mirror = true;
      setRotation(Zab8, 0F, 0F, 0F);
      Grzbiet1 = new ModelRenderer(this, 74, 0);
      Grzbiet1.addBox(0F, 0F, 0F, 0, 5, 2);
      Grzbiet1.setRotationPoint(0F, 3F, -6F);
      Grzbiet1.setTextureSize(128, 128);
      Grzbiet1.mirror = true;
      setRotation(Grzbiet1, 0.2974289F, 0F, 0F);
      Grzbiet2 = new ModelRenderer(this, 74, 0);
      Grzbiet2.addBox(0F, 0F, 0F, 0, 5, 2);
      Grzbiet2.setRotationPoint(0F, 4F, -3F);
      Grzbiet2.setTextureSize(128, 128);
      Grzbiet2.mirror = true;
      setRotation(Grzbiet2, 0.2974289F, 0F, 0F);
      Grzbiet3 = new ModelRenderer(this, 74, 0);
      Grzbiet3.addBox(0F, 0F, 0F, 0, 5, 2);
      Grzbiet3.setRotationPoint(0F, 5F, 0F);
      Grzbiet3.setTextureSize(128, 128);
      Grzbiet3.mirror = true;
      setRotation(Grzbiet3, 0.2974289F, 0F, 0F);
      Grzbiet4 = new ModelRenderer(this, 74, 0);
      Grzbiet4.addBox(0F, 0F, 0F, 0, 5, 2);
      Grzbiet4.setRotationPoint(0F, 6F, 3F);
      Grzbiet4.setTextureSize(128, 128);
      Grzbiet4.mirror = true;
      setRotation(Grzbiet4, 0.2974289F, 0F, 0F);
      Grzbiet5 = new ModelRenderer(this, 74, 0);
      Grzbiet5.addBox(0F, 0F, 0F, 0, 5, 2);
      Grzbiet5.setRotationPoint(0F, 7F, 6F);
      Grzbiet5.setTextureSize(128, 128);
      Grzbiet5.mirror = true;
      setRotation(Grzbiet5, 0.2974289F, 0F, 0F);
  }
  
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    Body.render(f5);
    Leg1.render(f5);
    Leg2.render(f5);
    Leg3.render(f5);
    Leg4.render(f5);
    Tail.render(f5);
    Morda.render(f5);
    Zab1.render(f5);
    Zab2.render(f5);
    Zab3.render(f5);
    Zab4.render(f5);
    Zab5.render(f5);
    Zab6.render(f5);
    Zab7.render(f5);
    Zab8.render(f5);
    Grzbiet1.render(f5);
    Grzbiet2.render(f5);
    Grzbiet3.render(f5);
    Grzbiet4.render(f5);
    Grzbiet5.render(f5);
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
    this.Leg3.rotateAngleX = MathHelper.cos(f * 0.6662F + (float)Math.PI) * 1.4F * f1;
    this.Leg4.rotateAngleX = MathHelper.cos(f * 0.6662F) * 1.4F * f1;
  }

}
