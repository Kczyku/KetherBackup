package com.KMOD.Core;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.Achievement;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeDictionary.Type;
import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.common.registry.LanguageRegistry;
import net.minecraftforge.fml.relauncher.Side;

import com.KMOD.Blocks.BaseBlock;
import com.KMOD.Blocks.BaseBlockStairs;
import com.KMOD.Blocks.BlockBaseOre;
import com.KMOD.Blocks.BlockEnchanter;
import com.KMOD.Blocks.BlockForbiddenCreatureSpawner;
import com.KMOD.Blocks.BlockForbiddenTrap;
import com.KMOD.Blocks.BlockGemBlock;
import com.KMOD.Blocks.BlockGildedSand;
import com.KMOD.Blocks.BlockHeavenlyBush;
import com.KMOD.Blocks.BlockHeavenlyCloud;
import com.KMOD.Blocks.BlockHeavenlyCrop;
import com.KMOD.Blocks.BlockHeavenlyDirt;
import com.KMOD.Blocks.BlockHeavenlyGrass;
import com.KMOD.Blocks.BlockHeavenlyLeavesNew;
import com.KMOD.Blocks.BlockHeavenlyLog;
import com.KMOD.Blocks.BlockHeavenlyPlant;
import com.KMOD.Blocks.BlockHeavenlyPortal;
import com.KMOD.Blocks.BlockHeavenlySapling;
import com.KMOD.Blocks.BlockHeavenlyStone;
import com.KMOD.Blocks.BlockPoisonousCactus;
import com.KMOD.Blocks.BlockRottenLog;
import com.KMOD.Blocks.BlockRunesPutter;
import com.KMOD.Blocks.BlockVolcanicRock;
import com.KMOD.Blocks.FireElementalSpawner;
import com.KMOD.DimBase.WorldProviderHeaven;
import com.KMOD.Events.GuiHandler;
import com.KMOD.Items.BaseItem;
import com.KMOD.Items.EnergyCrystal;
import com.KMOD.Items.ItemHeavenlyFood;
import com.KMOD.Items.ItemMOArmor;
import com.KMOD.Items.ItemMOAxe;
import com.KMOD.Items.ItemMOFood;
import com.KMOD.Items.ItemMOHoe;
import com.KMOD.Items.ItemMOPickaxe;
import com.KMOD.Items.ItemMOSeedFood;
import com.KMOD.Items.ItemMOShovel;
import com.KMOD.Items.ItemMOSword;
import com.KMOD.Items.ItemMOTool;
import com.KMOD.Items.ItemPortalPlacer;
import com.KMOD.Items.ItemThorsPickaxe;
import com.KMOD.Items.ItemWand;
import com.KMOD.Recipes.RecipeArmors;
import com.KMOD.Recipes.RecipeGemBlocks;
import com.KMOD.Recipes.RecipeGemBricks;
import com.KMOD.Recipes.RecipeMOTools;
import com.KMOD.Recipes.RecipeMOWeapons;
import com.KMOD.Recipes.RecipeMetalStickTools;
import com.KMOD.Recipes.RecipeMetalStickWeapons;

@Mod(modid = KCore.MODID, version = KCore.VERSION, name = KCore.Name)
public class KCore
{
	public static final String Name = "Kether Final";
    public static final String MODID = "kmo";
    public static final String VERSION = "1.0";
    
    public static final int HDimId = DimensionManager.getNextFreeDimId();
    
	@Mod.Instance
	public static KCore instance;
    
	@SidedProxy(clientSide="com.KMOD.Core.ClientProxyClass", serverSide="com.KMOD.Core.CommonProxyClass")
	public static CommonProxyClass proxy;
        
    public static BaseBlock SapphireOre, TopazOre, RubyOre, TitaniumOre, HeavenlyGrass, HeavenlyDirt, HeavenlyStone, 
    HeavenlyCobblestone, HeavenlyPortal, HeavenlyLog, HeavenlyPlanks, HeavenlyLeaves, HeavenlySapling, HeavenlyCloud, 
    FrostyPeanuts, GlowingFungus, HeavenlyTallGrass, FourLeafClover, HeavenlyGoldenLeaves, SaintLily, CrystalOre, 
    HeavenlyBlackRose, HeavenlyBlueRose, HeavenlyPurpleRose, HeavenlyBlueMyth, HeavenlyRedMyth, HeavenlyYellowMyth,
    HeavenlyBlueLeaves, CandyCottonPlant, StonedBrick, GildedSand, VolcanicRock, VolcanicBrick, FireElementalSpawner,
    Rhyolite, ProcessedRhyolite, RhyoliteBrick, Basalt, ProcessedBasalt, BasaltBrick, GoldenStone, MossyGoldenStone, GoldenEssence,
    RottenBush, PoisonousCactus, ForbiddenRock, ForbiddenBrick, ForbiddenLightBrick, ForbiddenBrick2, ForbiddenPanel,
    ForbiddenRockStairs, ForbiddenBrickStairs, ForbiddenTrap, ForbiddenCreatureSpawner;
	public static BlockRottenLog RottenLog;
    
    public static BlockEnchanter Enchanter;
    
    public static BlockRunesPutter RunesPutter;
    
    public static BlockGemBlock SapphireBlock, TopazBlock, RubyBlock, TitaniumBlock, GravitionalBlock,
    							SapphireBrick, TopazBrick, RubyBrick, TitaniumBrick, GravitionalBrick;

	
    public static BaseItem Sapphire, Topaz, Ruby, TitaniumIngot,
    BitOfLuck, EnergyCrystal, Crystal, Shell, CrystalSword, CrystalHoe
    ,SapphireSword, SapphireHoe, TopazSword, TopazHoe, RubySword, RubyHoe, TitaniumSword, TitaniumHoe,
    ThorsMetalPiece, RuneBase, FireRune,
    CrystalSlotSword, CrystalFireSword,
    DarkEssence, LightEssence, FireElement, PortalPlacer, 
    GravitionalGem, GravitionalSword, GravitionalHoe, 
    MagicShoot, FireWand, 
    ForbiddenGem, ForbiddenSword, ForbiddenHoe,
    KetherStatue;
	public static ItemMOFood HoneyJar;

    
    public static ItemMOTool CrystalPickaxe, CrystalAxe, CrystalShovel,
    SapphirePickaxe, SapphireAxe, SapphireShovel,
    TopazPickaxe, TopazAxe, TopazShovel,
    RubyPickaxe, RubyAxe, RubyShovel,
    TitaniumPickaxe, TitaniumAxe, TitaniumShovel, 
    ThorsPickaxe,
    GravitionalPickaxe, GravitionalAxe, GravitionalShovel,
    ForbiddenPickaxe, ForbiddenAxe, ForbiddenShovel;

    public static ItemMOArmor SapphireHelmet, SapphireChestplate, SapphireLeggins, SapphireBoots,
    TopazHelmet, TopazChestplate, TopazLeggins, TopazBoots,
    RubyHelmet, RubyChestplate, RubyLeggins, RubyBoots,
    TitaniumHelmet, TitaniumChestplate, TitaniumLeggins, TitaniumBoots,
    CrystalHelmet, CrystalChestplate, CrystalLeggins, CrystalBoots,
    CrystalSlotHelmet, CrystalSlotChestplate, CrystalSlotLeggins, CrystalSlotBoots,
    CrystalFireHelmet, CrystalFireChestplate, CrystalFireLeggins, CrystalFireBoots,
    TurtleArmor,
    GravitionalHelmet, GravitionalChestplate, GravitionalLeggins, GravitionalBoots,
    ForbiddenHelmet, ForbiddenChestplate, ForbiddenLeggins, ForbiddenBoots;
    public static ItemMOSeedFood FrostyPeanut, CandyCotton;
    public static ItemHeavenlyFood Venison, KetherusMeat, MagicFruit;
    
    public static final CreativeTabs OHTab = new CreativeTabs(MODID + "Kether")
    {
        public Item getTabIconItem()
        {
            return KCore.Sapphire; 
        }

        public String getTranslatedTabLabel() 
        {
            return "Kether"; 
        }
    };
    
    public static BiomeGenBase Heaven, HeavenForest, HeavenDesert, HeavenMountains, HeavenPlains;
    static ArmorMaterial ArmorSapphire = EnumHelper.addArmorMaterial("Sapphire", "Sapphire", 20, new int[]{3, 6, 5, 3}, 12);
    static ArmorMaterial ArmorTopaz = EnumHelper.addArmorMaterial("Topaz", "Topaz", 20, new int[]{3, 6, 5, 3}, 12);
    static ArmorMaterial ArmorRuby = EnumHelper.addArmorMaterial("Ruby", "Ruby", 20, new int[]{3, 6, 5, 3}, 12);
    static ArmorMaterial ArmorTitanium = EnumHelper.addArmorMaterial("Titanium", "Titanium", 25, new int[]{3, 8, 5, 2}, 15);
    static ArmorMaterial ArmorCrystal = EnumHelper.addArmorMaterial("Crystal", "Crystal", 35, new int[]{4, 10, 6, 4}, 20);
    static ArmorMaterial ArmorTurtle = EnumHelper.addArmorMaterial("Turtle", "Turtle", 45, new int[]{6, 12, 8, 6}, 28);
    static ArmorMaterial ArmorGravitional = EnumHelper.addArmorMaterial("Gravitional", "Gravitional", 50, new int[]{7, 13, 9, 7}, 34);
    static ArmorMaterial ArmorForbidden = EnumHelper.addArmorMaterial("Forbidden", "Forbidden", 60, new int[]{8, 14, 10, 9}, 40);

    static net.minecraft.item.Item.ToolMaterial SAPPHIRE = EnumHelper.addToolMaterial("SapphireTool", 2, 350, 7.0F, 3.0F, 16);
    static net.minecraft.item.Item.ToolMaterial TOPAZ = EnumHelper.addToolMaterial("TOPAZ", 2, 350, 7.0F, 3.0F, 16);
    static net.minecraft.item.Item.ToolMaterial RUBY = EnumHelper.addToolMaterial("RUBY",2, 350, 7.0F, 3.0F, 16);
    static net.minecraft.item.Item.ToolMaterial TITANIUM = EnumHelper.addToolMaterial("TITANIUM", 3, 1000, 8.0F, 4.0F, 8);
    static net.minecraft.item.Item.ToolMaterial CRYSTAL = EnumHelper.addToolMaterial("CRYSTAL", 3, 3000, 14F, 5F, 10);
    static net.minecraft.item.Item.ToolMaterial THORS = EnumHelper.addToolMaterial("THORS", 3, 1000, 1.0F, 1F, 8);
    static net.minecraft.item.Item.ToolMaterial GRAVITIONAL = EnumHelper.addToolMaterial("GRAVITIONAL", 3, 3500, 16F, 7F, 12);
    static net.minecraft.item.Item.ToolMaterial FORBIDDEN = EnumHelper.addToolMaterial("FORBIDDEN", 3, 6000, 20F, 9F, 15);

    


    
    
    public static Achievement GravitionalGemA, TravelToKether, FlyingATurtle, NightmareEnslaved, ElementKilled, FireWandA, ForbiddenWhat;
    @EventHandler
    public void preinit(FMLPreInitializationEvent event)
    {  	
    	DimensionManager.registerProviderType(HDimId, WorldProviderHeaven.class, true);
    	DimensionManager.registerDimension(HDimId, HDimId);
 

 
    }
    

    
    @EventHandler
    public void init(FMLInitializationEvent e)
    {

    	
    	
    	
    	SapphireOre = new BlockBaseOre("Sapphire Ore", 2F, 15F, 1, 5);
    	TopazOre = new BlockBaseOre("Topaz Ore", 2F, 15F, 1, 5);
    	RubyOre = new BlockBaseOre("Ruby Ore", 2F, 15F, 1, 5);
    	TitaniumOre = new BlockBaseOre("Titanium Ore", 3F, 20F, 4, 8);
    	SapphireBlock = new BlockGemBlock("Sapphire Block", 3F, 20F);
    	TopazBlock = new BlockGemBlock("Topaz Block", 3F, 20F);
    	RubyBlock = new BlockGemBlock("Ruby Block", 3F, 20F);
    	TitaniumBlock = new BlockGemBlock("Titanium Block", 4F, 25F);
    	SapphireBrick = new BlockGemBlock("Sapphire Brick", 2F, 20F);
    	TopazBrick = new BlockGemBlock("Topaz Brick", 2F, 20F);
    	RubyBrick = new BlockGemBlock("Ruby Brick", 2F, 20F);
    	TitaniumBrick = new BlockGemBlock("Titanium Brick", 3F, 25F);
    	CrystalOre = new BlockBaseOre("Crystal Ore", 4F, 30F, 5, 12);
    	HeavenlyBlueLeaves = new BlockHeavenlyLeavesNew("Heavenly Blue Leaves");
    	
    	GravitionalBlock = new BlockGemBlock("Gravitional Block", 3F, 25F);
    	GravitionalBrick = new BlockGemBlock("Gravitional Brick", 3F, 25F);
    	
    	HeavenlyDirt = (BaseBlock) new BlockHeavenlyDirt("Heavenly Dirt").setMaterial(Material.ground).setHardness(0.5F);
    	HeavenlyGrass = (BaseBlock) new BlockHeavenlyGrass("Heavenly Grass").setMaterial(Material.grass).setHardness(0.5F);
    	HeavenlyStone = new BlockHeavenlyStone("Heavenly Stone");
    	HeavenlyCobblestone = new BaseBlock("Heavenly Cobblestone", 1.5F, 15F);
    	HeavenlyPortal = new BlockHeavenlyPortal("Heavenly Portal");
    	HeavenlyLog = (BaseBlock) new BlockHeavenlyLog("Heavenly Log").setMaterial(Material.wood).setStepSound(Block.soundTypeWood).setHardness(2F);
    	HeavenlyPlanks = (BaseBlock) ((BaseBlock) new BaseBlock("Heavenly Planks", 2F, 5F).setStepSound(Block.soundTypeWood)).setMaterial(Material.wood).setHardness(1.5F);
    	HeavenlyLeaves = new BlockHeavenlyLeavesNew("Heavenly Leaves");
    	HeavenlySapling = new BlockHeavenlySapling("Heavenly Sapling");
    	HeavenlyCloud = new BlockHeavenlyCloud("Heavenly Cloud");
    	FrostyPeanuts = new BlockHeavenlyCrop("Frosty Peanuts", KCore.HeavenlyCloud, FrostyPeanut, FrostyPeanut, FrostyPeanuts);
    	GlowingFungus = (BlockHeavenlyBush)new BlockHeavenlyPlant("Glowing Fungus", 0.7F);
    	HeavenlyTallGrass = new BlockHeavenlyPlant("Heavenly Tall Grass", 0.0F);
    	FourLeafClover = (BlockHeavenlyBush)new BlockHeavenlyPlant("Four-Leaf Clover", 0.0F);
    	HeavenlyGoldenLeaves = new BlockHeavenlyLeavesNew("Heavenly Golden Leaves");
    	SaintLily = (BlockHeavenlyBush)new BlockHeavenlyPlant("Saint Lily", 0.5F);
    	
    	HeavenlyBlackRose = (BlockHeavenlyBush)new BlockHeavenlyPlant("Heavenly Black Rose", 0.1F);
    	HeavenlyBlueRose = (BlockHeavenlyBush)new BlockHeavenlyPlant("Heavenly Blue Rose", 0.1F);
    	HeavenlyPurpleRose = (BlockHeavenlyBush)new BlockHeavenlyPlant("Heavenly Purple Rose", 0.1F);

    	HeavenlyRedMyth = (BlockHeavenlyBush)new BlockHeavenlyPlant("Heavenly Red Myth", 0.2F);
    	HeavenlyBlueMyth = (BlockHeavenlyBush)new BlockHeavenlyPlant("Heavenly Blue Myth", 0.2F);
    	HeavenlyYellowMyth = (BlockHeavenlyBush)new BlockHeavenlyPlant("Heavenly Yellow Myth", 0.2F);
    	
    	Enchanter = (BlockEnchanter)(new BlockEnchanter("Enchanter")).setHardness(3.5F).setStepSound(Block.soundTypePiston).setCreativeTab(OHTab);
    	CandyCottonPlant = new BlockHeavenlyCrop("Candy Cotton Plant", KCore.HeavenlyCloud, CandyCotton, CandyCotton, CandyCottonPlant);
    	RottenLog = (BlockRottenLog)new BlockRottenLog("Rotten Log").setHardness(3.5F).setStepSound(Block.soundTypeWood).setCreativeTab(OHTab);
    	RunesPutter = (BlockRunesPutter)new BlockRunesPutter("Runes Putter").setHardness(3.5F).setStepSound(Block.soundTypeWood).setCreativeTab(OHTab);
    	StonedBrick = new BaseBlock("Stoned Brick", 2.5F, 30F);
    	GildedSand = (BaseBlock)new BlockGildedSand("Gilded Sand", 1.0F, 5F).setMaterial(Material.sand).setLightLevel(0.2F);
    	VolcanicRock = (BaseBlock) new BlockVolcanicRock("Volcanic Rock", 4F, 50F).setLightLevel(0.3F);
    	VolcanicBrick = (BaseBlock) new BlockVolcanicRock("Volcanic Brick", 4F, 50F).setLightLevel(0.3F);
    	FireElementalSpawner = (BaseBlock) new FireElementalSpawner("Fire Elemental Spawner", 5F, 50F);
    	Rhyolite = new BaseBlock("Rhyolite", 3F, 30F);
    	ProcessedRhyolite = new BaseBlock("Processed Rhyolite", 3F, 30F);
    	RhyoliteBrick = new BaseBlock("Rhyolite Brick", 3F, 30F);
    	
    	Basalt = new BaseBlock("Basalt", 4F, 30F);
    	ProcessedBasalt = new BaseBlock("Processed Basalt", 4F, 30F);
    	BasaltBrick = new BaseBlock("Basalt Brick", 4F, 30F);
    	GoldenStone = new BaseBlock("Golden Stone", 5F, 40F);
    	MossyGoldenStone = new BaseBlock("Mossy Golden Stone", 3F, 20F);
    	GoldenEssence = (BaseBlock) new BaseBlock("Golden Essence", 15F, 150F).setLightLevel(1F);
    	RottenBush = new BlockHeavenlyPlant("Rotten Bush", 0);
    	PoisonousCactus = (BaseBlock) new BlockPoisonousCactus("Poisonous Cactus").setCreativeTab(KCore.OHTab);
    	ForbiddenRock = new BaseBlock("Forbidden Rock", 5F, 50F);
    	ForbiddenBrick = new BaseBlock("Forbidden Brick", 5F, 50F);
    	ForbiddenLightBrick = (BaseBlock) new BaseBlock("Forbidden Light Brick", 5F, 50F).setLightLevel(1.0F);
    	ForbiddenBrick2 = new BaseBlock("Forbidden Brick 2", 5F, 50F);
    	ForbiddenPanel = new BaseBlock("Forbidden Panel", 5F, 50F);
    	ForbiddenRockStairs = new BaseBlockStairs("Forbidden Rock Stairs", KCore.ForbiddenRock.getDefaultState(), 5F, 50F);
    	ForbiddenBrickStairs = new BaseBlockStairs("Forbidden Brick Stairs", KCore.ForbiddenBrick.getDefaultState(), 5F, 50F);
    	ForbiddenTrap = new BlockForbiddenTrap("Forbidden Trap", 5F, 50F);
    	ForbiddenCreatureSpawner = new BlockForbiddenCreatureSpawner("F Spawner", 5F, 50F);
    	

    	
       	Sapphire = new BaseItem("Sapphire");
    	Topaz = new BaseItem("Topaz");
    	Ruby = new BaseItem("Ruby");
    	TitaniumIngot = new BaseItem("Titanium Ingot");
    	BitOfLuck = new BaseItem("Bit Of Luck");
    	Crystal = new BaseItem("Crystal");
    	ThorsMetalPiece = new BaseItem("Thor's Metal Piece");
    	ForbiddenGem = new BaseItem("Forbidden Gem");

    	SapphireSword = new ItemMOSword("Sapphire Sword", this.SAPPHIRE);
    	SapphireHoe = new ItemMOHoe("Sapphire Hoe", this.SAPPHIRE);
    	SapphirePickaxe = new ItemMOPickaxe("Sapphire Pickaxe", this.SAPPHIRE);
    	SapphireAxe = new ItemMOAxe("Sapphire Axe", this.SAPPHIRE);
    	SapphireShovel = new ItemMOShovel("Sapphire Shovel", this.SAPPHIRE);
    	
    	TopazSword = new ItemMOSword("Topaz Sword", TOPAZ);
    	TopazHoe = new ItemMOHoe("Topaz Hoe", TOPAZ);
    	TopazPickaxe = new ItemMOPickaxe("Topaz Pickaxe", TOPAZ);
    	TopazAxe = new ItemMOAxe("Topaz Axe", TOPAZ);
    	TopazShovel = new ItemMOShovel("Topaz Shovel", TOPAZ);
    	
    	RubySword = new ItemMOSword("Ruby Sword", RUBY);
    	RubyHoe = new ItemMOHoe("Ruby Hoe", RUBY);
    	RubyPickaxe = new ItemMOPickaxe("Ruby Pickaxe", RUBY);
    	RubyAxe = new ItemMOAxe("Ruby Axe", RUBY);
    	RubyShovel = new ItemMOShovel("Ruby Shovel", RUBY);
    	
    	TitaniumSword = new ItemMOSword("Titanium Sword", TITANIUM);
    	TitaniumHoe = new ItemMOHoe("Titanium Hoe", TITANIUM);
    	TitaniumPickaxe = new ItemMOPickaxe("Titanium Pickaxe", TITANIUM);
    	TitaniumAxe = new ItemMOAxe("Titanium Axe", TITANIUM);
    	TitaniumShovel = new ItemMOShovel("Titanium Shovel", TITANIUM);
    	
    	SapphireHelmet = new ItemMOArmor("Sapphire Helmet", this.ArmorSapphire, 5, 0);
    	SapphireChestplate = new ItemMOArmor("Sapphire Chestplate", this.ArmorSapphire, 5, 1);
    	SapphireLeggins = new ItemMOArmor("Sapphire Leggins", this.ArmorSapphire, 5, 2);
    	SapphireBoots = new ItemMOArmor("Sapphire Boots", this.ArmorSapphire, 5, 3);
    	
    	TopazHelmet = new ItemMOArmor("Topaz Helmet", this.ArmorTopaz, 6, 0);
    	TopazChestplate = new ItemMOArmor("Topaz Chestplate", this.ArmorTopaz, 6, 1);
    	TopazLeggins = new ItemMOArmor("Topaz Leggins", this.ArmorTopaz, 6, 2);
    	TopazBoots = new ItemMOArmor("Topaz Boots", this.ArmorTopaz, 6, 3);

    	RubyHelmet = new ItemMOArmor("Ruby Helmet", this.ArmorRuby, 7, 0);
    	RubyChestplate = new ItemMOArmor("Ruby Chestplate", this.ArmorRuby, 7, 1);
    	RubyLeggins = new ItemMOArmor("Ruby Leggins", this.ArmorRuby, 7, 2);
    	RubyBoots = new ItemMOArmor("Ruby Boots", this.ArmorRuby, 7, 3);
    	
    	TitaniumHelmet = new ItemMOArmor("Titanium Helmet", this.ArmorTitanium, 8, 0);
    	TitaniumChestplate = new ItemMOArmor("Titanium Chestplate", this.ArmorTitanium, 8, 1);
    	TitaniumLeggins = new ItemMOArmor("Titanium Leggins", this.ArmorTitanium, 8, 2);
    	TitaniumBoots = new ItemMOArmor("Titanium Boots", this.ArmorTitanium, 8, 3);
    	
    	CrystalSword = new ItemMOSword("Crystal Sword", CRYSTAL);
    	CrystalHoe = new ItemMOHoe("Crystal Hoe", CRYSTAL);
    	CrystalPickaxe = new ItemMOPickaxe("Crystal Pickaxe", CRYSTAL);
    	CrystalAxe = new ItemMOAxe("Crystal Axe", CRYSTAL);
    	CrystalShovel = new ItemMOShovel("Crystal Shovel", CRYSTAL);
    	CrystalHelmet = new ItemMOArmor("Crystal Helmet", this.ArmorCrystal, 9, 0);
    	CrystalChestplate = new ItemMOArmor("Crystal Chestplate", this.ArmorCrystal, 9, 1);
    	CrystalLeggins = new ItemMOArmor("Crystal Leggins", this.ArmorCrystal, 9, 2);
    	CrystalBoots = new ItemMOArmor("Crystal Boots", this.ArmorCrystal, 9, 3);
    	
    	CrystalSlotHelmet = new ItemMOArmor("Crystal Helmet With Slot", this.ArmorCrystal, 10, 0);
    	CrystalSlotChestplate = new ItemMOArmor("Crystal Chestplate With Slot", this.ArmorCrystal, 10, 1);
    	CrystalSlotLeggins = new ItemMOArmor("Crystal Leggins With Slot", this.ArmorCrystal, 10, 2);
    	CrystalSlotBoots = new ItemMOArmor("Crystal Boots With Slot", this.ArmorCrystal, 10, 3);
    	CrystalSlotSword = new ItemMOSword("Crystal Sword With Slot", CRYSTAL);
    
    	CrystalFireHelmet = new ItemMOArmor("Crystal Fire Helmet", this.ArmorCrystal, 11, 0);
    	CrystalFireChestplate = new ItemMOArmor("Crystal Fire Chestplate", this.ArmorCrystal, 11, 1);
    	CrystalFireLeggins = new ItemMOArmor("Crystal Fire Leggins", this.ArmorCrystal, 11, 2);
    	CrystalFireBoots = new ItemMOArmor("Crystal Fire Boots", this.ArmorCrystal, 11, 3);
    	CrystalFireSword = new ItemMOSword("Crystal Fire Sword", CRYSTAL);
    	TurtleArmor = new ItemMOArmor("Turtle Armor", this.ArmorTurtle, 12, 1);
    	
    	


    	
    	EnergyCrystal = new EnergyCrystal("Energy Crystal");
    	ThorsPickaxe = new ItemThorsPickaxe("Thors Pickaxe", THORS);
    	
    	Venison = new ItemHeavenlyFood("Venison", 5, 0.6F, false);
    	Shell = new BaseItem("Shell");
    	FrostyPeanut = new ItemMOSeedFood("Frosty Peanut", 3, 0.6F, KCore.FrostyPeanuts, KCore.HeavenlyCloud);
    	CandyCotton = new ItemMOSeedFood("Candy Cotton", 2, 0.3F, KCore.CandyCottonPlant, KCore.HeavenlyCloud);
    	HoneyJar = new ItemMOFood("Honey Jar", 2, 1F, false);
    	RuneBase = new BaseItem("Rune Base");
    	FireRune = new BaseItem("Fire Rune");
    	KetherusMeat = new ItemHeavenlyFood("Ketherus Meat", 5, 1.0F, false);
    	DarkEssence = new BaseItem("Dark Essence");

    	LightEssence = new BaseItem("Light Essence");
    	FireElement = new BaseItem("Fire Element");
    	PortalPlacer = new ItemPortalPlacer("Portal Placer");
    	GravitionalGem = new BaseItem("Gravitional Gem");
    	
    	GravitionalSword = new ItemMOSword("Gravitional Sword", GRAVITIONAL);
    	GravitionalPickaxe = new ItemMOPickaxe("Gravitional Pickaxe", GRAVITIONAL);
    	GravitionalAxe = new ItemMOAxe("Gravitional Axe", GRAVITIONAL);
    	GravitionalShovel = new ItemMOShovel("Gravitional Shovel", GRAVITIONAL);
    	GravitionalHoe = new ItemMOHoe("Gravitional Hoe", GRAVITIONAL);
    	GravitionalHelmet = new ItemMOArmor("Gravitional Helmet", this.ArmorGravitional, 13, 0);
    	GravitionalChestplate = new ItemMOArmor("Gravitional Chestplate", this.ArmorGravitional, 13, 1);
    	GravitionalLeggins = new ItemMOArmor("Gravitional Leggins", this.ArmorGravitional, 13, 2);
    	GravitionalBoots = new ItemMOArmor("Gravitional Boots", this.ArmorGravitional, 13, 3);
    	
    	MagicShoot = (BaseItem)new BaseItem("Magic Shoot").setCreativeTab(null);
    	FireWand = new ItemWand("Fire Wand", 50);
    	MagicFruit = new ItemHeavenlyFood("Magic Fruit", 4, 1F, false);
    	
    	ForbiddenSword = new ItemMOSword("Forbidden Sword", FORBIDDEN);
    	ForbiddenHoe = new ItemMOHoe("Forbidden Hoe", FORBIDDEN);
    	ForbiddenPickaxe = new ItemMOPickaxe("Forbidden Pickaxe", FORBIDDEN);
    	ForbiddenAxe = new ItemMOAxe("Forbidden Axe", FORBIDDEN);
    	ForbiddenShovel = new ItemMOShovel("Forbidden Shovel", FORBIDDEN);
    	ForbiddenHelmet = new ItemMOArmor("Forbidden Helmet", this.ArmorForbidden, 14, 0);
    	ForbiddenChestplate = new ItemMOArmor("Forbidden Chestplate", this.ArmorForbidden, 14, 1);
    	ForbiddenLeggins = new ItemMOArmor("Forbidden Leggins", this.ArmorForbidden, 14, 2);
    	ForbiddenBoots = new ItemMOArmor("Forbidden Boots", this.ArmorForbidden, 14, 3);
    	
    	KetherStatue = new BaseItem("Kether Statue");
    	
    	
    	

    	
    	


    	
    	new EntityInitializator().initialize();

    	this.regBlock(SapphireOre, e);
    	this.regBlock(TopazOre, e);
    	this.regBlock(RubyOre, e);
    	this.regBlock(TitaniumOre, e);
    	this.regBlock(SapphireBlock, e);
    	this.regBlock(TopazBlock, e);
    	this.regBlock(RubyBlock, e);
    	this.regBlock(TitaniumBlock, e);
    	this.regBlock(SapphireBrick, e);
    	this.regBlock(TopazBrick, e);
    	this.regBlock(RubyBrick, e);
    	this.regBlock(TitaniumBrick, e);
    	this.regBlock(HeavenlyDirt, e);
    	this.regBlock(HeavenlyGrass, e);
    	this.regBlock(HeavenlyStone, e);
    	this.regBlock(HeavenlyCobblestone, e);
    	this.regBlock(HeavenlyPortal, e);
    	this.regBlock(HeavenlyLog, e);
    	this.regBlock(HeavenlyPlanks, e);
    	this.regBlock(HeavenlyLeaves, e);
    	this.regBlock(HeavenlySapling, e);
    	this.regBlock(HeavenlyCloud, e);
    	this.regBlock(FrostyPeanuts, e);
    	this.regBlock(GlowingFungus, e);
    	this.regBlock(HeavenlyTallGrass, e);
    	this.regBlock(FourLeafClover, e);
    	this.regBlock(HeavenlyGoldenLeaves, e);
    	this.regBlock(SaintLily, e);
    	this.regBlock(CrystalOre, e);
    	this.regBlock(HeavenlyBlackRose, e);
    	this.regBlock(HeavenlyBlueRose, e);
    	this.regBlock(HeavenlyPurpleRose, e);
    	this.regBlock(HeavenlyRedMyth, e);
    	this.regBlock(HeavenlyBlueMyth, e);
    	this.regBlock(HeavenlyYellowMyth, e);
    	this.regBlock(RottenLog, e);
    	this.regBlock(HeavenlyBlueLeaves, e);
    	this.regBlock(Enchanter, e);
    	this.regBlock(CandyCottonPlant, e);
    	this.regBlock(RunesPutter, e);
    	this.regBlock(StonedBrick, e);
    	this.regBlock(GildedSand, e);
    	this.regBlock(VolcanicRock, e);
    	this.regBlock(VolcanicBrick, e);
    	this.regBlock(FireElementalSpawner, e);
    	this.regBlock(GravitionalBlock, e);
    	this.regBlock(GravitionalBrick, e);
    	this.regBlock(Rhyolite, e);
    	this.regBlock(ProcessedRhyolite, e);
    	this.regBlock(RhyoliteBrick, e);
    	this.regBlock(Basalt, e);
    	this.regBlock(ProcessedBasalt, e);
    	this.regBlock(BasaltBrick, e);
    	this.regBlock(GoldenStone, e);
    	this.regBlock(MossyGoldenStone, e);
    	this.regBlock(GoldenEssence, e);
    	this.regBlock(RottenBush, e);
    	this.regBlock(PoisonousCactus, e);
    	this.regBlock(ForbiddenRock, e);
    	this.regBlock(ForbiddenBrick, e);
    	this.regBlock(ForbiddenLightBrick, e);
    	this.regBlock(ForbiddenBrick2, e);
    	this.regBlock(ForbiddenPanel, e);
    	this.regBlock(ForbiddenRockStairs, e);
    	this.regBlock(ForbiddenBrickStairs, e);
    	this.regBlock(ForbiddenTrap, e);
    	this.regBlock(ForbiddenCreatureSpawner, e);

    	
    	this.regItem(Sapphire, e);
    	this.regItem(Topaz, e);
    	this.regItem(Ruby, e);
    	this.regItem(TitaniumIngot, e);
    	this.regItem(SapphireSword, e);
    	this.regItem(SapphireHoe, e);
    	this.regItem(SapphirePickaxe, e);
    	this.regItem(SapphireAxe, e);
    	this.regItem(SapphireShovel, e);
    	this.regItem(TopazSword, e);
    	this.regItem(TopazHoe, e);
    	this.regItem(TopazPickaxe, e);
    	this.regItem(TopazAxe, e);
    	this.regItem(TopazShovel, e);
    	this.regItem(RubySword, e);
    	this.regItem(RubyHoe, e);
    	this.regItem(RubyPickaxe, e);
    	this.regItem(RubyAxe, e);
    	this.regItem(RubyShovel, e);
    	this.regItem(TitaniumSword, e);
    	this.regItem(TitaniumHoe, e);
    	this.regItem(TitaniumPickaxe, e);
    	this.regItem(TitaniumAxe, e);
    	this.regItem(TitaniumShovel, e);
    	this.regItem(SapphireHelmet, e);
    	this.regItem(SapphireChestplate, e);
    	this.regItem(SapphireLeggins, e);
    	this.regItem(SapphireBoots, e);
		this.regItem(TopazHelmet, e);
    	this.regItem(TopazChestplate, e);
    	this.regItem(TopazLeggins, e);
    	this.regItem(TopazBoots, e);
		this.regItem(RubyHelmet, e);
    	this.regItem(RubyChestplate, e);
    	this.regItem(RubyLeggins, e);
    	this.regItem(RubyBoots, e);
		this.regItem(TitaniumHelmet, e);
    	this.regItem(TitaniumChestplate, e);
    	this.regItem(TitaniumLeggins, e);
    	this.regItem(TitaniumBoots, e);
    	this.regItem(BitOfLuck, e);
    	this.regItem(EnergyCrystal, e);
    	this.regItem(ThorsPickaxe, e);
    	this.regItem(Crystal, e);
    	this.regItem(Venison, e);
    	this.regItem(Shell, e);
    	this.regItem(CrystalSword, e);
    	this.regItem(CrystalHoe, e);
    	this.regItem(CrystalPickaxe, e);
    	this.regItem(CrystalAxe, e);
    	this.regItem(CrystalShovel, e);
		this.regItem(CrystalHelmet, e);
    	this.regItem(CrystalChestplate, e);
    	this.regItem(CrystalLeggins, e);
    	this.regItem(CrystalBoots, e);
    	this.regItem(ThorsMetalPiece, e);
    	this.regItem(CandyCotton, e);
    	this.regItem(FrostyPeanut, e);
    	this.regItem(HoneyJar, e);
    	this.regItem(RuneBase, e);
    	this.regItem(FireRune, e);
    	this.regItem(CrystalSlotSword, e);
		this.regItem(CrystalSlotHelmet, e);
    	this.regItem(CrystalSlotChestplate, e);
    	this.regItem(CrystalSlotLeggins, e);
    	this.regItem(CrystalSlotBoots, e);
    	this.regItem(CrystalFireSword, e);
		this.regItem(CrystalFireHelmet, e);
    	this.regItem(CrystalFireChestplate, e);
    	this.regItem(CrystalFireLeggins, e);
    	this.regItem(CrystalFireBoots, e);
    	this.regItem(TurtleArmor, e);
    	this.regItem(KetherusMeat, e);
    	this.regItem(DarkEssence, e);
    	this.regItem(LightEssence, e);
    	this.regItem(FireElement, e);
    	this.regItem(PortalPlacer, e);	
    	this.regItem(GravitionalSword, e);
    	this.regItem(GravitionalPickaxe, e);
    	this.regItem(GravitionalAxe, e);
    	this.regItem(GravitionalShovel, e);
		this.regItem(GravitionalHelmet, e);
    	this.regItem(GravitionalChestplate, e);
    	this.regItem(GravitionalLeggins, e);
    	this.regItem(GravitionalBoots, e);
    	this.regItem(GravitionalGem, e);
    	this.regItem(GravitionalHoe, e);
    	this.regItem(FireWand, e);
    	this.regItem(MagicFruit, e);
    	this.regItem(ForbiddenGem, e);
    	this.regItem(ForbiddenSword, e);
    	this.regItem(ForbiddenPickaxe, e);
    	this.regItem(ForbiddenAxe, e);
    	this.regItem(ForbiddenShovel, e);
		this.regItem(ForbiddenHelmet, e);
    	this.regItem(ForbiddenChestplate, e);
    	this.regItem(ForbiddenLeggins, e);
    	this.regItem(ForbiddenBoots, e);
    	this.regItem(ForbiddenHoe, e);
    	this.regItem(KetherStatue, e);
    	
    	
    	TravelToKether  = new Achievement("Travel To Kether", "Travel To Kether", 8, 3, KCore.PortalPlacer, null);
    	GravitionalGemA = new Achievement("Gravitional Set", "Gravitional Set", 11, 3, KCore.GravitionalGem, this.TravelToKether);
    	FlyingATurtle = new Achievement("Flying A Turtle", "Flying A Turtle", 11, 4, KCore.Shell, this.TravelToKether);
    	NightmareEnslaved = new Achievement("Nightmare Enslaved", "Nightmare Enslaved", 11, 2, KCore.DarkEssence, this.TravelToKether);
    	ElementKilled = new Achievement("Element Killed", "Element Killed", 11, 1, KCore.FireElement, this.TravelToKether);
    	FireWandA = new Achievement("Fire Wand", "Fire Wand", 13, 1, KCore.FireWand, this.ElementKilled);
    	ForbiddenWhat = new Achievement("Forbidden What", "Forbidden What", 13, 2, KCore.KetherStatue, this.NightmareEnslaved);
    	this.registerAchievement(TravelToKether, "Travel To Kether", "Travel To Kether", "Welcome to the Kether!");
    	this.registerAchievement(GravitionalGemA, "Gravitional Set", "Gravitional Set", "You got an gravitional gem!");
    	this.registerAchievement(FlyingATurtle, "Flying A Turtle", "Flying A Turtle", "Is this your first flight?");
    	this.registerAchievement(NightmareEnslaved, "Nightmare Enslaved", "Nightmare Enslaved", "Be carefull!");
    	this.registerAchievement(ElementKilled, "Element Killed", "Element Killed", "You killed an fire elemental!");
    	this.registerAchievement(FireWandA, "Fire Wand", "Fire Wand", "Fire... Congratz!");
    	this.registerAchievement(ForbiddenWhat, "Forbidden What", "Forbidden What", "What? Forbidden? I have heared somewhere about it...");


    	Heaven = new com.KMOD.DimBase.Heaven(100);
    	HeavenForest = new com.KMOD.DimBase.HeavenForest(101);
    	HeavenDesert = new com.KMOD.DimBase.HeavenDesert(102);
    	HeavenMountains = new com.KMOD.DimBase.HeavenMountains(103);
    	HeavenPlains = new com.KMOD.DimBase.HeavenPlains(104);

    	BiomeDictionary.registerBiomeType(Heaven, Type.MAGICAL);
    	BiomeDictionary.registerBiomeType(HeavenForest, Type.MAGICAL);
    	BiomeDictionary.registerBiomeType(HeavenDesert, Type.MAGICAL);
    	BiomeDictionary.registerBiomeType(HeavenMountains, Type.MAGICAL);
    	BiomeDictionary.registerBiomeType(HeavenPlains, Type.MAGICAL);

    	addRecipes();
    	addSpecialNames();
    	
		NetworkRegistry.INSTANCE.registerGuiHandler(KCore.instance, new GuiHandler());
    }
    
    
    
    public void addSpecialNames()
    {
    	
    }
    
    public void addRecipes()
    {
    	GameRegistry.addSmelting(this.SapphireOre, new ItemStack(this.Sapphire, 1), 1F);
    	GameRegistry.addSmelting(this.TopazOre, new ItemStack(this.Topaz, 1), 1F);
    	GameRegistry.addSmelting(this.RubyOre, new ItemStack(this.Ruby, 1), 1F);
    	GameRegistry.addSmelting(this.TitaniumOre, new ItemStack(this.TitaniumIngot, 1), 2F);
    	GameRegistry.addSmelting(this.HeavenlyCobblestone, new ItemStack(this.HeavenlyStone, 1), 0.1F);
    	GameRegistry.addSmelting(this.FourLeafClover, new ItemStack(this.BitOfLuck, 1), 10F);
    	GameRegistry.addRecipe(new ItemStack(KCore.HeavenlyPlanks, 4), new Object [] {"X", Character.valueOf('X'), KCore.HeavenlyLog});
    	GameRegistry.addRecipe(new ItemStack(KCore.Enchanter, 1), new Object [] {"XXX", "XYX", "XXX", Character.valueOf('Y'), KCore.Crystal, Character.valueOf('X'), KCore.TitaniumIngot});
    	GameRegistry.addRecipe(new ItemStack(KCore.StonedBrick, 4), new Object [] {"   ", "XX ", "XX ", Character.valueOf('X'), KCore.HeavenlyStone});
    	GameRegistry.addRecipe(new ItemStack(KCore.PortalPlacer, 1), new Object [] {"X X", " Y ", " Y ", Character.valueOf('X'), Blocks.end_stone, Character.valueOf('Y'), Items.stick});
    	GameRegistry.addSmelting(this.Rhyolite, new ItemStack(this.ProcessedRhyolite, 1), 0.3F);
    	GameRegistry.addRecipe(new ItemStack(KCore.RhyoliteBrick, 4), new Object [] {"   ", "XX ", "XX ", Character.valueOf('X'), KCore.ProcessedRhyolite});
    	GameRegistry.addSmelting(this.Basalt, new ItemStack(this.ProcessedBasalt, 1), 0.3F);
    	GameRegistry.addRecipe(new ItemStack(KCore.BasaltBrick, 4), new Object [] {"   ", "XX ", "XX ", Character.valueOf('X'), KCore.ProcessedBasalt});
    	GameRegistry.addSmelting(this.BitOfLuck, new ItemStack(this.LightEssence, 1), 1F);
    	GameRegistry.addSmelting(this.ForbiddenRock, new ItemStack(this.ForbiddenBrick, 1), 1F);
    	GameRegistry.addRecipe(new ItemStack(KCore.ForbiddenBrick2, 4), new Object [] {"   ", "XX ", "XX ", Character.valueOf('X'), KCore.ForbiddenBrick});
    	GameRegistry.addRecipe(new ItemStack(KCore.ForbiddenLightBrick, 1), new Object [] {"X", "Y", Character.valueOf('X'), KCore.ForbiddenBrick2, Character.valueOf('Y'), KCore.LightEssence});
    	GameRegistry.addRecipe(new ItemStack(KCore.ForbiddenPanel, 4), new Object [] {"   ", "XX ", "XX ", Character.valueOf('X'), KCore.ForbiddenBrick2});
    	GameRegistry.addRecipe(new ItemStack(KCore.ForbiddenRockStairs, 6), new Object [] {"   X", " XX", "XXX", Character.valueOf('X'), KCore.ForbiddenRock});
    	GameRegistry.addRecipe(new ItemStack(KCore.ForbiddenBrickStairs, 6), new Object [] {"   X", " XX", "XXX", Character.valueOf('X'), KCore.ForbiddenBrick});

    	new RecipeGemBlocks().addRecipes();
    	new RecipeGemBricks().addRecipes();
    	new RecipeMOTools().addRecipes();
    	new RecipeMOWeapons().addRecipes();
    	new RecipeArmors().addRecipes();
    	new RecipeMetalStickTools().addRecipes();
    	new RecipeMetalStickWeapons().addRecipes();

    }
    
    private void registerAchievement(Achievement a, String unName, String newName, String Desc)
    {
    	a.registerStat();
        LanguageRegistry.instance().addStringLocalization("achievement." + unName, "en_US", newName);
        LanguageRegistry.instance().addStringLocalization("achievement." + unName + ".desc", "en_US", Desc);
    }
   
    
    public void regBlock(BaseBlock block, FMLInitializationEvent event)
    {
    	GameRegistry.registerBlock(block, block.getName());
    	block.setUnlocalizedName(this.MODID + "_" + block.getName());
    	LanguageRegistry.addName(block, block.getName());
        if(event.getSide() == Side.CLIENT)
        {
        RenderItem renderItem = Minecraft.getMinecraft().getRenderItem();
        renderItem.getItemModelMesher().register(Item.getItemFromBlock(block), 0, new ModelResourceLocation(KCore.MODID + ":" + block.getName(), "inventory"));
        }
    }
    
    public void regBlock(BlockRunesPutter block, FMLInitializationEvent event)
    {
    	GameRegistry.registerBlock(block, block.getName());
    	block.setUnlocalizedName(this.MODID + "_" + block.getName());
    	LanguageRegistry.addName(block, block.getName());
        if(event.getSide() == Side.CLIENT)
        {
        RenderItem renderItem = Minecraft.getMinecraft().getRenderItem();
        renderItem.getItemModelMesher().register(Item.getItemFromBlock(block), 0, new ModelResourceLocation(KCore.MODID + ":" + block.getName(), "inventory"));
        }
    }
    
    public void regBlock(BlockRottenLog block, FMLInitializationEvent event)
    {
    	GameRegistry.registerBlock(block, block.getName());
    	block.setUnlocalizedName(this.MODID + "_" + block.getName());
    	LanguageRegistry.addName(block, block.getName());
        if(event.getSide() == Side.CLIENT)
        {
        RenderItem renderItem = Minecraft.getMinecraft().getRenderItem();
        renderItem.getItemModelMesher().register(Item.getItemFromBlock(block), 0, new ModelResourceLocation(KCore.MODID + ":" + block.getName(), "inventory"));
        }
    }
    
    public void regBlock(BlockEnchanter block, FMLInitializationEvent event)
    {
    	GameRegistry.registerBlock(block, block.getName());
    	block.setUnlocalizedName(this.MODID + "_" + block.getName());
    	LanguageRegistry.addName(block, block.getName());
        if(event.getSide() == Side.CLIENT)
        {
        RenderItem renderItem = Minecraft.getMinecraft().getRenderItem();
        renderItem.getItemModelMesher().register(Item.getItemFromBlock(block), 0, new ModelResourceLocation(KCore.MODID + ":" + block.getName(), "inventory"));
        }
    }
    
    
    
    public void regItem(BaseItem item, FMLInitializationEvent event)
    {
    	GameRegistry.registerItem(item, item.getName());
    	item.setUnlocalizedName(this.MODID + "_" + item.getName());
    	LanguageRegistry.addName(item, item.getName());
        if(event.getSide() == Side.CLIENT)
        {
        RenderItem renderItem = Minecraft.getMinecraft().getRenderItem();
        renderItem.getItemModelMesher().register(item, 0, new ModelResourceLocation(KCore.MODID + ":" + item.getName(), "inventory"));
        }
    }
    
    public void regItem(ItemMOFood item, FMLInitializationEvent event)
    {
    	GameRegistry.registerItem(item, item.getName());
    	item.setUnlocalizedName(this.MODID + "_" + item.getName());
    	LanguageRegistry.addName(item, item.getName());
        if(event.getSide() == Side.CLIENT)
        {
        RenderItem renderItem = Minecraft.getMinecraft().getRenderItem();
        renderItem.getItemModelMesher().register(item, 0, new ModelResourceLocation(KCore.MODID + ":" + item.getName(), "inventory"));
        }
    }
    
    public void regItem(ItemMOTool item, FMLInitializationEvent event)
    {
    	GameRegistry.registerItem(item, item.getName());
    	item.setUnlocalizedName(this.MODID + "_" + item.getName());
    	LanguageRegistry.addName(item, item.getName());
        if(event.getSide() == Side.CLIENT)
        {
        RenderItem renderItem = Minecraft.getMinecraft().getRenderItem();
        renderItem.getItemModelMesher().register(item, 0, new ModelResourceLocation(KCore.MODID + ":" + item.getName(), "inventory"));
        }
    }
    
    public void regItem(ItemHeavenlyFood item, FMLInitializationEvent event)
    {
    	GameRegistry.registerItem(item, item.getName());
    	item.setUnlocalizedName(this.MODID + "_" + item.getName());
    	LanguageRegistry.addName(item, item.getName());
        if(event.getSide() == Side.CLIENT)
        {
        RenderItem renderItem = Minecraft.getMinecraft().getRenderItem();
        renderItem.getItemModelMesher().register(item, 0, new ModelResourceLocation(KCore.MODID + ":" + item.getName(), "inventory"));
        }
    }
    
    public void regItem(ItemMOArmor item, FMLInitializationEvent event)
    {
    	GameRegistry.registerItem(item, item.getName());
    	item.setUnlocalizedName(this.MODID + "_" + item.getName());
    	LanguageRegistry.addName(item, item.getName());
        if(event.getSide() == Side.CLIENT)
        {
        RenderItem renderItem = Minecraft.getMinecraft().getRenderItem();
        renderItem.getItemModelMesher().register(item, 0, new ModelResourceLocation(KCore.MODID + ":" + item.getName(), "inventory"));
        }
    }
    
    public void regItem(ItemMOSeedFood item, FMLInitializationEvent event)
    {
    	GameRegistry.registerItem(item, item.getName());
    	item.setUnlocalizedName(this.MODID + "_" + item.getName());
    	LanguageRegistry.addName(item, item.getName());
        if(event.getSide() == Side.CLIENT)
        {
        RenderItem renderItem = Minecraft.getMinecraft().getRenderItem();
        renderItem.getItemModelMesher().register(item, 0, new ModelResourceLocation(KCore.MODID + ":" + item.getName(), "inventory"));
        }
    }
    
    
    
}
