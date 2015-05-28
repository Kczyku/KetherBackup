package com.KMOD.Items;

import java.util.List;

import net.minecraft.block.BlockDispenser;
import net.minecraft.command.IEntitySelector;
import net.minecraft.dispenser.BehaviorDefaultDispenseItem;
import net.minecraft.dispenser.IBehaviorDispenseItem;
import net.minecraft.dispenser.IBlockSource;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;

import com.KMOD.Core.KCore;
import com.google.common.base.Predicates;

public class ItemMOArmor extends ItemArmor
{
	private String Name;
    private static final int[] maxDamageArray = new int[] {11, 16, 15, 13};
    public static final String[] EMPTY_SLOT_NAMES = new String[] {"minecraft:items/empty_armor_slot_helmet", "minecraft:items/empty_armor_slot_chestplate", "minecraft:items/empty_armor_slot_leggings", "minecraft:items/empty_armor_slot_boots"};
    private static final IBehaviorDispenseItem dispenserBehavior = new BehaviorDefaultDispenseItem()
    {
        protected ItemStack dispenseStack(IBlockSource source, ItemStack stack)
        {
            BlockPos blockpos = source.getBlockPos().offset(BlockDispenser.getFacing(source.getBlockMetadata()));
            int i = blockpos.getX();
            int j = blockpos.getY();
            int k = blockpos.getZ();
            AxisAlignedBB axisalignedbb = new AxisAlignedBB((double)i, (double)j, (double)k, (double)(i + 1), (double)(j + 1), (double)(k + 1));
            List list = source.getWorld().getEntitiesWithinAABB(EntityLivingBase.class, axisalignedbb, Predicates.and(IEntitySelector.NOT_SPECTATING, new IEntitySelector.ArmoredMob(stack)));

            if (list.size() > 0)
            {
                EntityLivingBase entitylivingbase = (EntityLivingBase)list.get(0);
                int l = 0;// Forge: We fix the indexes. Mojang Stop hard coding this!
                int i1 = EntityLiving.getArmorPosition(stack);
                ItemStack itemstack1 = stack.copy();
                itemstack1.stackSize = 1;
                entitylivingbase.setCurrentItemOrArmor(i1 - l, itemstack1);

                if (entitylivingbase instanceof EntityLiving)
                {
                    ((EntityLiving)entitylivingbase).setEquipmentDropChance(i1, 2.0F);
                }

                --stack.stackSize;
                return stack;
            }
            else
            {
                return super.dispenseStack(source, stack);
            }
        }
    };
    public final int armorType;
    public final int damageReduceAmount;
    public final int renderIndex;
    private final net.minecraft.item.ItemArmor.ArmorMaterial material;

    public ItemMOArmor(String Name, net.minecraft.item.ItemArmor.ArmorMaterial material, int renderIndex, int armorType)
    {
    	super(material, renderIndex, armorType);
    	this.Name = Name;
        this.material = material;
        this.armorType = armorType;
        this.renderIndex = renderIndex;
        this.damageReduceAmount = material.getDamageReductionAmount(armorType);
        this.setMaxDamage(material.getDurability(armorType));
        this.maxStackSize = 1;
        this.setCreativeTab(KCore.OHTab);
        BlockDispenser.dispenseBehaviorRegistry.putObject(this, dispenserBehavior);
    }
    
    public String getName()
    {
    	return Name;
    }
    
    
    @Override //This is pretty self explanatory
    public String getArmorTexture(ItemStack armor, Entity entity, int slot, String type) 
    {
    	
     if(armor.getItem() == KCore.SapphireLeggins)
     {
     return KCore.MODID + ":" + "/textures/armor/sapphire_2.png";
     } 
     else if(armor.getItem() == KCore.SapphireHelmet || armor.getItem() == KCore.SapphireChestplate || armor.getItem() == KCore.SapphireBoots)
     {
         return KCore.MODID + ":" + "/textures/armor/sapphire_1.png";
     }
     else if(armor.getItem() == KCore.TopazLeggins)
     {
         return KCore.MODID + ":" + "/textures/armor/topaz_2.png";
     }
     else if(armor.getItem() == KCore.TopazHelmet || armor.getItem() == KCore.TopazChestplate || armor.getItem() == KCore.TopazBoots)
     {
         return KCore.MODID + ":" + "/textures/armor/topaz_1.png";
     }
     else if(armor.getItem() == KCore.RubyLeggins)
     {
         return KCore.MODID + ":" + "/textures/armor/ruby_2.png";
     }
     else if(armor.getItem() == KCore.RubyHelmet || armor.getItem() == KCore.RubyChestplate || armor.getItem() == KCore.RubyBoots)
     {
         return KCore.MODID + ":" + "/textures/armor/ruby_1.png";
     }
     else if(armor.getItem() == KCore.TitaniumLeggins)
     {
         return KCore.MODID + ":" + "/textures/armor/titanium_2.png";
     }
     else if(armor.getItem() == KCore.TitaniumHelmet || armor.getItem() == KCore.TitaniumChestplate || armor.getItem() == KCore.TitaniumBoots)
     {
         return KCore.MODID + ":" + "/textures/armor/titanium_1.png";
     }
     else if(armor.getItem() == KCore.CrystalLeggins)
     {
         return KCore.MODID + ":" + "/textures/armor/crystal_2.png";
     }
     else if(armor.getItem() == KCore.CrystalHelmet || armor.getItem() == KCore.CrystalChestplate || armor.getItem() == KCore.CrystalBoots)
     {
         return KCore.MODID + ":" + "/textures/armor/crystal_1.png";
     }
     else if(armor.getItem() == KCore.CrystalSlotLeggins)
     {
         return KCore.MODID + ":" + "/textures/armor/crystal_2Slot.png";
     }
     else if(armor.getItem() == KCore.CrystalSlotHelmet || armor.getItem() == KCore.CrystalSlotChestplate || armor.getItem() == KCore.CrystalSlotBoots)
     {
         return KCore.MODID + ":" + "/textures/armor/crystal_1Slot.png";
     }
     else if(armor.getItem() == KCore.CrystalFireLeggins)
     {
         return KCore.MODID + ":" + "/textures/armor/crystal_2Fire.png";
     }
     else if(armor.getItem() == KCore.CrystalFireHelmet || armor.getItem() == KCore.CrystalFireChestplate || armor.getItem() == KCore.CrystalFireBoots)
     {
         return KCore.MODID + ":" + "/textures/armor/crystal_1Fire.png";
     }
     else if(armor.getItem() == KCore.TurtleArmor)
     {
         return KCore.MODID + ":" + "/textures/armor/Turtle.png";
     }
     else if(armor.getItem() == KCore.GravitionalLeggins)
     {
         return KCore.MODID + ":" + "/textures/armor/gravitional_2.png";
     }
     else if(armor.getItem() == KCore.GravitionalHelmet || armor.getItem() == KCore.GravitionalChestplate || armor.getItem() == KCore.GravitionalBoots)
     {
         return KCore.MODID + ":" + "/textures/armor/gravitional_1.png";
     }
     else if(armor.getItem() == KCore.ForbiddenLeggins)
     {
         return KCore.MODID + ":" + "/textures/armor/forbidden_2.png";
     }
     else if(armor.getItem() == KCore.ForbiddenHelmet || armor.getItem() == KCore.ForbiddenChestplate || armor.getItem() == KCore.ForbiddenBoots)
     {
         return KCore.MODID + ":" + "/textures/armor/forbidden_1.png";
     }
     
     
     
     else
     {
    	 return null;
     }
     
    }
    
    public void onArmorTick(World world, EntityPlayer player, ItemStack itemStack)
    {
    	if(this == KCore.CrystalFireHelmet || this == KCore.CrystalFireChestplate || this == KCore.CrystalFireLeggins || this
    			== KCore.CrystalFireBoots)
    	{
    		player.addPotionEffect(new PotionEffect(Potion.fireResistance.id, 5, 5));
    		
    		if(player.isBurning())
    		{
    			player.setFire(0);
    		}
    	}
    	else if(this == KCore.GravitionalBoots)
    	{
    		player.addPotionEffect(new PotionEffect(Potion.jump.id, 5, 5));
    		if(!itemStack.isItemEnchanted())
    		{
    			itemStack.addEnchantment(Enchantment.featherFalling, 100);	
    		}
    	}
    	

    }
    
    public int getItemEnchantability()
    {
        return this.material.getEnchantability();
    }

    public net.minecraft.item.ItemArmor.ArmorMaterial getArmorMaterial()
    {
        return this.material;
    }

    public boolean getIsRepairable(ItemStack toRepair, ItemStack repair)
    {
        return this.material.getRepairItem() == repair.getItem() ? true : super.getIsRepairable(toRepair, repair);
    }

    public ItemStack onItemRightClick(ItemStack itemStackIn, World worldIn, EntityPlayer playerIn)
    {
        int i = EntityLiving.getArmorPosition(itemStackIn) - 1;
        ItemStack itemstack1 = playerIn.getCurrentArmor(i);

        if (itemstack1 == null)
        {
            playerIn.setCurrentItemOrArmor(i + 1, itemStackIn.copy()); //Forge: Vanilla bug fix associated with fixed setCurrentItemOrArmor indexs for players.
            itemStackIn.stackSize = 0;
        }

        return itemStackIn;
    }
}