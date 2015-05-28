package com.KMOD.Models;

import java.util.HashMap;

import net.minecraft.client.model.ModelBase;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;
import MCAClientLibrary.MCAModelRenderer;
import MCACommonLibrary.MCAVersionChecker;
import MCACommonLibrary.animation.AnimationHandler;
import MCACommonLibrary.math.Matrix4f;
import MCACommonLibrary.math.Quaternion;

import com.KMOD.Entities.EntityJellyFish;

public class ModelJellyFish extends ModelBase {
public final int MCA_MIN_REQUESTED_VERSION = 3;
public HashMap<String, MCAModelRenderer> parts = new HashMap<String, MCAModelRenderer>();

MCAModelRenderer wnetrzeGlowy;
MCAModelRenderer glowa;
MCAModelRenderer noga2;
MCAModelRenderer noga3;
MCAModelRenderer noga4;
MCAModelRenderer noga1;
MCAModelRenderer noga8;
MCAModelRenderer noga7;
MCAModelRenderer noga6;
MCAModelRenderer noga5;

public ModelJellyFish()
{
MCAVersionChecker.checkForLibraryVersion(getClass(), MCA_MIN_REQUESTED_VERSION);

textureWidth = 64;
textureHeight = 64;

wnetrzeGlowy = new MCAModelRenderer(this, "WnetrzeGlowy", 14, 0);
wnetrzeGlowy.mirror = false;
wnetrzeGlowy.addBox(0.0F, -5.0F, -5.0F, 5, 5, 5);
wnetrzeGlowy.setInitialRotationPoint(-5.0F, -14.0F, 5.0F);
wnetrzeGlowy.setInitialRotationMatrix(new Matrix4f().set(new Quaternion(0.0F, 0.0F, 0.0F, 1.0F)).transpose());
wnetrzeGlowy.setTextureSize(64, 64);
parts.put(wnetrzeGlowy.boxName, wnetrzeGlowy);

glowa = new MCAModelRenderer(this, "Glowa", 36, 0);
glowa.mirror = false;
glowa.addBox(0.0F, -7.0F, -7.0F, 7, 7, 7);
glowa.setInitialRotationPoint(-6.0F, -13.0F, 6.0F);
glowa.setInitialRotationMatrix(new Matrix4f().set(new Quaternion(0.0F, 0.0F, 0.0F, 1.0F)).transpose());
glowa.setTextureSize(64, 64);
parts.put(glowa.boxName, glowa);

noga2 = new MCAModelRenderer(this, "Noga2", 0, 0);
noga2.mirror = false;
noga2.addBox(0.0F, -1.0F, -1.0F, 5, 1, 1);
noga2.setInitialRotationPoint(1.0F, -19.0F, 6.0F);
noga2.setInitialRotationMatrix(new Matrix4f().set(new Quaternion(0.0F, 0.0F, 0.0F, 1.0F)).transpose());
noga2.setTextureSize(64, 64);
parts.put(noga2.boxName, noga2);

noga3 = new MCAModelRenderer(this, "Noga3", 0, 0);
noga3.mirror = false;
noga3.addBox(0.0F, -1.0F, -1.0F, 5, 1, 1);
noga3.setInitialRotationPoint(1.0F, -19.0F, 0.0F);
noga3.setInitialRotationMatrix(new Matrix4f().set(new Quaternion(0.0F, 0.0F, 0.0F, 1.0F)).transpose());
noga3.setTextureSize(64, 64);
parts.put(noga3.boxName, noga3);

noga4 = new MCAModelRenderer(this, "Noga4", 0, 0);
noga4.mirror = false;
noga4.addBox(0.0F, -1.0F, -1.0F, 5, 1, 1);
noga4.setInitialRotationPoint(1.0F, -13.0F, 0.0F);
noga4.setInitialRotationMatrix(new Matrix4f().set(new Quaternion(0.0F, 0.0F, 0.0F, 1.0F)).transpose());
noga4.setTextureSize(64, 64);
parts.put(noga4.boxName, noga4);

noga1 = new MCAModelRenderer(this, "Noga1", 0, 0);
noga1.mirror = false;
noga1.addBox(0.0F, -1.0F, -1.0F, 5, 1, 1);
noga1.setInitialRotationPoint(1.0F, -13.0F, 6.0F);
noga1.setInitialRotationMatrix(new Matrix4f().set(new Quaternion(0.0F, 0.0F, 0.0F, 1.0F)).transpose());
noga1.setTextureSize(64, 64);
parts.put(noga1.boxName, noga1);

noga8 = new MCAModelRenderer(this, "Noga8", 0, 0);
noga8.mirror = false;
noga8.addBox(0.0F, -1.0F, -1.0F, 5, 1, 1);
noga8.setInitialRotationPoint(5.0F, 0.0F, 0.0F);
noga8.setInitialRotationMatrix(new Matrix4f().set(new Quaternion(0.0F, 0.0F, 0.0F, 1.0F)).transpose());
noga8.setTextureSize(64, 64);
parts.put(noga8.boxName, noga8);
noga2.addChild(noga8);

noga7 = new MCAModelRenderer(this, "Noga7", 0, 0);
noga7.mirror = false;
noga7.addBox(0.0F, -1.0F, -1.0F, 5, 1, 1);
noga7.setInitialRotationPoint(5.0F, 0.0F, 0.0F);
noga7.setInitialRotationMatrix(new Matrix4f().set(new Quaternion(0.0F, 0.0F, 0.0F, 1.0F)).transpose());
noga7.setTextureSize(64, 64);
parts.put(noga7.boxName, noga7);
noga3.addChild(noga7);

noga6 = new MCAModelRenderer(this, "Noga6", 0, 0);
noga6.mirror = false;
noga6.addBox(0.0F, -1.0F, -1.0F, 5, 1, 1);
noga6.setInitialRotationPoint(5.0F, 0.0F, 0.0F);
noga6.setInitialRotationMatrix(new Matrix4f().set(new Quaternion(0.0F, 0.0F, 0.0F, 1.0F)).transpose());
noga6.setTextureSize(64, 64);
parts.put(noga6.boxName, noga6);
noga4.addChild(noga6);

noga5 = new MCAModelRenderer(this, "Noga5", 0, 0);
noga5.mirror = false;
noga5.addBox(0.0F, -1.0F, -1.0F, 5, 1, 1);
noga5.setInitialRotationPoint(5.0F, 0.0F, 0.0F);
noga5.setInitialRotationMatrix(new Matrix4f().set(new Quaternion(0.0F, 0.0F, 0.0F, 1.0F)).transpose());
noga5.setTextureSize(64, 64);
parts.put(noga5.boxName, noga5);
noga1.addChild(noga5);

}

@Override
public void render(Entity par1Entity, float par2, float par3, float par4, float par5, float par6, float par7) 
{
EntityJellyFish entity = (EntityJellyFish)par1Entity;

AnimationHandler.performAnimationInModel(parts, entity);

//Render every non-child part
wnetrzeGlowy.render(par7);
glowa.render(par7);
noga2.render(par7);
noga3.render(par7);
noga4.render(par7);
noga1.render(par7);
}
@Override
public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity en)
{

}

public MCAModelRenderer getModelRendererFromName(String name)
{
return parts.get(name);
}
}