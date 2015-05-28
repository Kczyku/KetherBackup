package com.KMOD.Core;

import net.minecraft.client.Minecraft;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.common.registry.LanguageRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import com.KMOD.Entities.EntityBird;
import com.KMOD.Entities.EntityBoar;
import com.KMOD.Entities.EntityDarkenig;
import com.KMOD.Entities.EntityFireElemental;
import com.KMOD.Entities.EntityFloatingBlock;
import com.KMOD.Entities.EntityFloatingStone;
import com.KMOD.Entities.EntityFlyingTurtle;
import com.KMOD.Entities.EntityForbiddenCreature;
import com.KMOD.Entities.EntityForbiddenGuardian;
import com.KMOD.Entities.EntityFriendlySmalloverPlant;
import com.KMOD.Entities.EntityGravitionalOre;
import com.KMOD.Entities.EntityGrittyMonstrosity;
import com.KMOD.Entities.EntityJellyFish;
import com.KMOD.Entities.EntityKetherus;
import com.KMOD.Entities.EntityMagicShoot;
import com.KMOD.Entities.EntityMushroomSprite;
import com.KMOD.Entities.EntityNightmare;
import com.KMOD.Entities.EntitySmalloverPlant;
import com.KMOD.Entities.EntitySpectator;
import com.KMOD.Entities.EntityStoneEater;
import com.KMOD.Rendering.RenderBird;
import com.KMOD.Rendering.RenderBoar;
import com.KMOD.Rendering.RenderDarkenig;
import com.KMOD.Rendering.RenderFireElemental;
import com.KMOD.Rendering.RenderFloatingBlock;
import com.KMOD.Rendering.RenderFloatingStone;
import com.KMOD.Rendering.RenderFlyingTurtle;
import com.KMOD.Rendering.RenderForbiddenCreature;
import com.KMOD.Rendering.RenderForbiddenGuardian;
import com.KMOD.Rendering.RenderFriendlySmalloverPlant;
import com.KMOD.Rendering.RenderGravitionalOre;
import com.KMOD.Rendering.RenderGrittyMonstrosity;
import com.KMOD.Rendering.RenderJellyFish;
import com.KMOD.Rendering.RenderKetherus;
import com.KMOD.Rendering.RenderMagicShootNew;
import com.KMOD.Rendering.RenderMushroomSprite;
import com.KMOD.Rendering.RenderNighmare;
import com.KMOD.Rendering.RenderSmalloverPlant;
import com.KMOD.Rendering.RenderSpectator;
import com.KMOD.Rendering.RenderStoneEater;
import com.KMOD.TileEntity.TileEntityEnchanter;
import com.KMOD.TileEntity.TileEntityRottenLog;
import com.KMOD.TileEntity.TileEntityRunesPutter;
public class EntityInitializator 
{

	public void initialize()
	{
	    EntityRegistry.registerGlobalEntityID(EntityBoar.class, "Boar", EntityRegistry.findGlobalUniqueEntityId(), 100, 10);
	    LanguageRegistry.instance().addStringLocalization("entity.Boar.name", "Boar"); 

	    EntityRegistry.registerGlobalEntityID(EntityStoneEater.class, "Stone Eater", EntityRegistry.findGlobalUniqueEntityId(), 100, 10);
	    LanguageRegistry.instance().addStringLocalization("entity.Stone Eater.name", "Stone Eater"); 
	
	    EntityRegistry.registerGlobalEntityID(EntityFlyingTurtle.class, "Flying Turtle", EntityRegistry.findGlobalUniqueEntityId(), 100, 10);
	    LanguageRegistry.instance().addStringLocalization("entity.Flying Turtle.name", "Flying Turtle"); 
	    
	    EntityRegistry.registerGlobalEntityID(EntitySmalloverPlant.class, "Smallover Plant", EntityRegistry.findGlobalUniqueEntityId(), 100, 10);
	    LanguageRegistry.instance().addStringLocalization("entity.Smallover Plant.name", "Smallover Plant"); 
	    
	    EntityRegistry.registerGlobalEntityID(EntityFriendlySmalloverPlant.class, "Friendly Smallover Plant", EntityRegistry.findGlobalUniqueEntityId(), 100, 10);
	    LanguageRegistry.instance().addStringLocalization("entity.Friendly Smallover Plant.name", "Friendly Smallover Plant"); 
	    
	    EntityRegistry.registerGlobalEntityID(EntityJellyFish.class, "Jelly Fish", EntityRegistry.findGlobalUniqueEntityId(), 100, 10);
	    LanguageRegistry.instance().addStringLocalization("entity.Jelly Fish.name", "Jelly Fish"); 
	    
	    EntityRegistry.registerModEntity(EntityFloatingStone.class, "Floating Stone", EntityRegistry.findGlobalUniqueEntityId(), KCore.instance, 10, 3, true);
	    LanguageRegistry.instance().addStringLocalization("entity.Floating Stone.name", "Floating Stone");
	    
	    EntityRegistry.registerGlobalEntityID(EntityKetherus.class, "Ketherus", EntityRegistry.findGlobalUniqueEntityId(), 100, 10);
	    LanguageRegistry.instance().addStringLocalization("entity.Ketherus.name", "Ketherus"); 
	   
	    EntityRegistry.registerGlobalEntityID(EntityBird.class, "Bird", EntityRegistry.findGlobalUniqueEntityId(), 100, 10);
	    LanguageRegistry.instance().addStringLocalization("entity.Bird.name", "Bird"); 
	    
	    EntityRegistry.registerGlobalEntityID(EntityNightmare.class, "Nightmare", EntityRegistry.findGlobalUniqueEntityId(), 100, 10);
	    LanguageRegistry.instance().addStringLocalization("entity.Nightmare.name", "Nightmare"); 
	    
	    EntityRegistry.registerGlobalEntityID(EntityFireElemental.class, "Fire Elemental", EntityRegistry.findGlobalUniqueEntityId(), 100, 10);
	    LanguageRegistry.instance().addStringLocalization("entity.Fire Elemental.name", "Fire Elemental"); 
	    
	    EntityRegistry.registerGlobalEntityID(EntityGravitionalOre.class, "Gravitional Ore", EntityRegistry.findGlobalUniqueEntityId(), 100, 10);
	    LanguageRegistry.instance().addStringLocalization("entity.Gravitional Ore.name", "Gravitional Ore"); 
	    
	    EntityRegistry.registerGlobalEntityID(EntityMushroomSprite.class, "Mushroom Sprite", EntityRegistry.findGlobalUniqueEntityId(), 100, 10);
	    LanguageRegistry.instance().addStringLocalization("entity.Mushroom Sprite.name", "Mushroom Sprite"); 
	    
	    EntityRegistry.registerModEntity(EntityMagicShoot.class, "Magic Shoot", EntityRegistry.findGlobalUniqueEntityId(), KCore.instance, 100, 10, true);
	    LanguageRegistry.instance().addStringLocalization("entity.Magic Shoot.name", "Magic Shoot"); 
	    
	    EntityRegistry.registerGlobalEntityID(EntitySpectator.class, "Spectator", EntityRegistry.findGlobalUniqueEntityId(), 100, 10);
	    LanguageRegistry.instance().addStringLocalization("entity.Spectator.name", "Spectator"); 
	   
	    EntityRegistry.registerModEntity(EntityFloatingBlock.class, "Floating Block", EntityRegistry.findGlobalUniqueEntityId(), KCore.instance, 100, 10, true);
	    LanguageRegistry.instance().addStringLocalization("entity.Floating Block.name", "Floating Block"); 
	    
	    EntityRegistry.registerGlobalEntityID(EntityDarkenig.class, "Darkenig", EntityRegistry.findGlobalUniqueEntityId(),  100, 10);
	    LanguageRegistry.instance().addStringLocalization("entity.Darkenig.name", "Darkenig"); 
	    
	    EntityRegistry.registerGlobalEntityID(EntityGrittyMonstrosity.class, "Gritty Monstrosity", EntityRegistry.findGlobalUniqueEntityId(),  100, 10);
	    LanguageRegistry.instance().addStringLocalization("entity.Gritty Monstrosity.name", "Gritty Monstrosity"); 
	    
	    EntityRegistry.registerGlobalEntityID(EntityForbiddenCreature.class, "Forbidden Creature", EntityRegistry.findGlobalUniqueEntityId(),  100, 10);
	    LanguageRegistry.instance().addStringLocalization("entity.Forbidden Creature.name", "Forbidden Creature"); 
	    
	    EntityRegistry.registerGlobalEntityID(EntityForbiddenGuardian.class, "Forbidden Guardian", EntityRegistry.findGlobalUniqueEntityId(),  100, 10);
	    LanguageRegistry.instance().addStringLocalization("entity.Forbidden Guardian.name", "Forbidden Guardian"); 
	    
	    GameRegistry.registerTileEntity(TileEntityEnchanter.class, "TileEntityEnchanter"); 
	    GameRegistry.registerTileEntity(TileEntityRottenLog.class, "TileEntityRottenLog"); 
	    GameRegistry.registerTileEntity(TileEntityRunesPutter.class, "TileEntityRunesPutter"); 

		addRenderers();
	}
	
	@SideOnly(Side.CLIENT)
	public void addRenderers()
	{
	    RenderingRegistry.registerEntityRenderingHandler(EntityBoar.class, new RenderBoar(Minecraft.getMinecraft().getRenderManager()));
	    RenderingRegistry.registerEntityRenderingHandler(EntityStoneEater.class, new RenderStoneEater(Minecraft.getMinecraft().getRenderManager()));
	    RenderingRegistry.registerEntityRenderingHandler(EntityFlyingTurtle.class, new RenderFlyingTurtle(Minecraft.getMinecraft().getRenderManager()));
	    RenderingRegistry.registerEntityRenderingHandler(EntitySmalloverPlant.class, new RenderSmalloverPlant(Minecraft.getMinecraft().getRenderManager()));
	    RenderingRegistry.registerEntityRenderingHandler(EntityFriendlySmalloverPlant.class, new RenderFriendlySmalloverPlant(Minecraft.getMinecraft().getRenderManager()));
	    RenderingRegistry.registerEntityRenderingHandler(EntityJellyFish.class, new RenderJellyFish());
	    RenderingRegistry.registerEntityRenderingHandler(EntityFloatingStone.class, new RenderFloatingStone(Minecraft.getMinecraft().getRenderManager()));
	    RenderingRegistry.registerEntityRenderingHandler(EntityKetherus.class, new RenderKetherus(Minecraft.getMinecraft().getRenderManager()));
	    RenderingRegistry.registerEntityRenderingHandler(EntityBird.class, new RenderBird(Minecraft.getMinecraft().getRenderManager()));
	    RenderingRegistry.registerEntityRenderingHandler(EntityNightmare.class, new RenderNighmare(Minecraft.getMinecraft().getRenderManager()));
	    RenderingRegistry.registerEntityRenderingHandler(EntityFireElemental.class, new RenderFireElemental(Minecraft.getMinecraft().getRenderManager()));
	    RenderingRegistry.registerEntityRenderingHandler(EntityGravitionalOre.class, new RenderGravitionalOre(Minecraft.getMinecraft().getRenderManager()));
	    RenderingRegistry.registerEntityRenderingHandler(EntityMushroomSprite.class, new RenderMushroomSprite(Minecraft.getMinecraft().getRenderManager()));
	    RenderingRegistry.registerEntityRenderingHandler(EntitySpectator.class, new RenderSpectator(Minecraft.getMinecraft().getRenderManager()));
	    RenderingRegistry.registerEntityRenderingHandler(EntityMagicShoot.class, new RenderMagicShootNew(Minecraft.getMinecraft().getRenderManager()));
	    RenderingRegistry.registerEntityRenderingHandler(EntityFloatingBlock.class, new RenderFloatingBlock(Minecraft.getMinecraft().getRenderManager()));
	    RenderingRegistry.registerEntityRenderingHandler(EntityDarkenig.class, new RenderDarkenig(Minecraft.getMinecraft().getRenderManager()));
	    RenderingRegistry.registerEntityRenderingHandler(EntityGrittyMonstrosity.class, new RenderGrittyMonstrosity(Minecraft.getMinecraft().getRenderManager()));
	    RenderingRegistry.registerEntityRenderingHandler(EntityForbiddenCreature.class, new RenderForbiddenCreature(Minecraft.getMinecraft().getRenderManager()));
	    RenderingRegistry.registerEntityRenderingHandler(EntityForbiddenGuardian.class, new RenderForbiddenGuardian(Minecraft.getMinecraft().getRenderManager()));


	}
}
