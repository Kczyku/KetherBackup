package com.KMOD.HeavenGens;

import java.util.Random;

import net.minecraft.util.BlockPos;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

import com.KMOD.Core.KCore;

public class GenBigCloud extends WorldGenerator
{

    public boolean generate(World world, Random random, BlockPos pos)
    {
    	int posX = pos.getX();
    	int posY = pos.getY();
    	int posZ = pos.getZ();
    	int X = posX;
    	int Y = posY;
    	int Z = posZ;
    	
    	if(world.isAirBlock(pos) && world.isAirBlock(new BlockPos(X, Y - 5, Z)) && world.isAirBlock(new BlockPos(X, Y + 5, Z)) && world.isAirBlock(new BlockPos(X + 5, Y, Z)) && world.isAirBlock(new BlockPos(X - 5, Y, Z)) && world.isAirBlock(new BlockPos(X, Y, Z + 5)) && world.isAirBlock(new BlockPos(X, Y, Z - 5)))
    	{
    		if(posY > 70)
    		{

    	    	
    	    	int length1 = MathHelper.getRandomIntegerInRange(random, 6, 8);
    	    	int length2 = MathHelper.getRandomIntegerInRange(random, 4, 6);
    	    	int length3 = MathHelper.getRandomIntegerInRange(random, 2, 4);
    	    	int length4 = MathHelper.getRandomIntegerInRange(random, 0, 2);
    	    	
    	    	int length11 = MathHelper.getRandomIntegerInRange(random, 1, length1 - 1);
    	    	int length22 = MathHelper.getRandomIntegerInRange(random, 1, length2 - 1);
    	    	int length33 = MathHelper.getRandomIntegerInRange(random, 1, length3 - 1);
    	    	int length44 = MathHelper.getRandomIntegerInRange(random, 1, length4 - 1);
    	    	if(length44 <= 0)
    	    	{
    	    		length44 = 1;
    	    	}
    	    	
    	    	
    			for(int i = 0; i < length1; i++)
    			{
    				BlockPos xyz = new BlockPos(posX + i, posY, posZ);
    				BlockPos xyz1 = new BlockPos(posX + i, posY, posZ + 1);
    				world.setBlockState(xyz, KCore.HeavenlyCloud.getDefaultState());
    				world.setBlockState(xyz1, KCore.HeavenlyCloud.getDefaultState());
    			}
    			
    			for(int i = 0; i < length2; i++)
    			{
    				BlockPos xyz = new BlockPos(posX + i, posY, posZ - 1);
    				BlockPos xyz1 = new BlockPos(posX + i, posY, posZ + 2);
    				world.setBlockState(xyz, KCore.HeavenlyCloud.getDefaultState());
    				world.setBlockState(xyz1, KCore.HeavenlyCloud.getDefaultState());
    			}
    			
    			for(int i = 0; i < length3; i++)
    			{
    				BlockPos xyz = new BlockPos(posX + i, posY, posZ - 2);
    				BlockPos xyz1 = new BlockPos(posX + i, posY, posZ + 3);
    				world.setBlockState(xyz, KCore.HeavenlyCloud.getDefaultState());
    				world.setBlockState(xyz1, KCore.HeavenlyCloud.getDefaultState());
    			}
    			
    			for(int i = 0; i < length4; i++)
    			{
    				BlockPos xyz = new BlockPos(posX + i, posY, posZ - 3);
    				BlockPos xyz1 = new BlockPos(posX + i, posY, posZ + 4);
    				world.setBlockState(xyz, KCore.HeavenlyCloud.getDefaultState());
    				world.setBlockState(xyz1, KCore.HeavenlyCloud.getDefaultState());
    			}
    			
    			for(int i = 0; i < length11; i++)
    			{
    				BlockPos xyz = new BlockPos(posX + i, posY + 1, posZ);
    				BlockPos xyz1 = new BlockPos(posX + i, posY + 1, posZ + 1);
    				BlockPos xyz2 = new BlockPos(posX + i, posY - 1, posZ);
    				BlockPos xyz3 = new BlockPos(posX + i, posY - 1, posZ + 1);
    				world.setBlockState(xyz, KCore.HeavenlyCloud.getDefaultState());
    				world.setBlockState(xyz1, KCore.HeavenlyCloud.getDefaultState());
    				world.setBlockState(xyz2, KCore.HeavenlyCloud.getDefaultState());
    				world.setBlockState(xyz3, KCore.HeavenlyCloud.getDefaultState());
    			}
    			
    			for(int i = 0; i < length22; i++)
    			{
    				BlockPos xyz = new BlockPos(posX + i, posY + 1, posZ - 1);
    				BlockPos xyz1 = new BlockPos(posX + i, posY + 1, posZ + 2);
    				BlockPos xyz2 = new BlockPos(posX + i, posY - 1, posZ - 1);
    				BlockPos xyz3 = new BlockPos(posX + i, posY - 1, posZ + 2);
    				world.setBlockState(xyz, KCore.HeavenlyCloud.getDefaultState());
    				world.setBlockState(xyz1, KCore.HeavenlyCloud.getDefaultState());
    				world.setBlockState(xyz2, KCore.HeavenlyCloud.getDefaultState());
    				world.setBlockState(xyz3, KCore.HeavenlyCloud.getDefaultState());
    			}
    			
    			for(int i = 0; i < length33; i++)
    			{
    				BlockPos xyz = new BlockPos(posX + i, posY + 1, posZ - 2);
    				BlockPos xyz1 = new BlockPos(posX + i, posY + 1, posZ + 3);
    				BlockPos xyz2 = new BlockPos(posX + i, posY - 1, posZ - 2);
    				BlockPos xyz3 = new BlockPos(posX + i, posY - 1, posZ + 3);
    				world.setBlockState(xyz, KCore.HeavenlyCloud.getDefaultState());
    				world.setBlockState(xyz1, KCore.HeavenlyCloud.getDefaultState());
    				world.setBlockState(xyz2, KCore.HeavenlyCloud.getDefaultState());
    				world.setBlockState(xyz3, KCore.HeavenlyCloud.getDefaultState());
    			}
    			
    			for(int i = 0; i < length44; i++)
    			{
    				BlockPos xyz = new BlockPos(posX + i, posY + 1, posZ - 3);
    				BlockPos xyz1 = new BlockPos(posX + i, posY + 1, posZ + 4);
    				BlockPos xyz2 = new BlockPos(posX + i, posY - 1, posZ - 3);
    				BlockPos xyz3 = new BlockPos(posX + i, posY - 1, posZ + 4);
    				world.setBlockState(xyz, KCore.HeavenlyCloud.getDefaultState());
    				world.setBlockState(xyz1, KCore.HeavenlyCloud.getDefaultState());
    				world.setBlockState(xyz2, KCore.HeavenlyCloud.getDefaultState());
    				world.setBlockState(xyz3, KCore.HeavenlyCloud.getDefaultState());
    			}
    			
    			
    			
    			
    			
    			
    			
    			for(int i = 0; i < length1; i++)
    			{
    				BlockPos xyz = new BlockPos(posX - i, posY, posZ);
    				BlockPos xyz1 = new BlockPos(posX - i, posY, posZ + 1);
    				world.setBlockState(xyz, KCore.HeavenlyCloud.getDefaultState());
    				world.setBlockState(xyz1, KCore.HeavenlyCloud.getDefaultState());
    			}
    			
    			for(int i = 0; i < length2; i++)
    			{
    				BlockPos xyz = new BlockPos(posX - i, posY, posZ - 1);
    				BlockPos xyz1 = new BlockPos(posX - i, posY, posZ + 2);
    				world.setBlockState(xyz, KCore.HeavenlyCloud.getDefaultState());
    				world.setBlockState(xyz1, KCore.HeavenlyCloud.getDefaultState());
    			}
    			
    			for(int i = 0; i < length3; i++)
    			{
    				BlockPos xyz = new BlockPos(posX - i, posY, posZ - 2);
    				BlockPos xyz1 = new BlockPos(posX - i, posY, posZ + 3);
    				world.setBlockState(xyz, KCore.HeavenlyCloud.getDefaultState());
    				world.setBlockState(xyz1, KCore.HeavenlyCloud.getDefaultState());
    			}
    			
    			for(int i = 0; i < length4; i++)
    			{
    				BlockPos xyz = new BlockPos(posX - i, posY, posZ - 3);
    				BlockPos xyz1 = new BlockPos(posX - i, posY, posZ + 4);
    				world.setBlockState(xyz, KCore.HeavenlyCloud.getDefaultState());
    				world.setBlockState(xyz1, KCore.HeavenlyCloud.getDefaultState());
    			}
    			
    			for(int i = 0; i < length11; i++)
    			{
    				BlockPos xyz = new BlockPos(posX - i, posY + 1, posZ);
    				BlockPos xyz1 = new BlockPos(posX - i, posY + 1, posZ + 1);
    				BlockPos xyz2 = new BlockPos(posX - i, posY - 1, posZ);
    				BlockPos xyz3 = new BlockPos(posX - i, posY - 1, posZ + 1);
    				world.setBlockState(xyz, KCore.HeavenlyCloud.getDefaultState());
    				world.setBlockState(xyz1, KCore.HeavenlyCloud.getDefaultState());
    				world.setBlockState(xyz2, KCore.HeavenlyCloud.getDefaultState());
    				world.setBlockState(xyz3, KCore.HeavenlyCloud.getDefaultState());
    			}
    			
    			for(int i = 0; i < length22; i++)
    			{
    				BlockPos xyz = new BlockPos(posX - i, posY + 1, posZ - 1);
    				BlockPos xyz1 = new BlockPos(posX - i, posY + 1, posZ + 2);
    				BlockPos xyz2 = new BlockPos(posX - i, posY - 1, posZ - 1);
    				BlockPos xyz3 = new BlockPos(posX - i, posY - 1, posZ + 2);
    				world.setBlockState(xyz, KCore.HeavenlyCloud.getDefaultState());
    				world.setBlockState(xyz1, KCore.HeavenlyCloud.getDefaultState());
    				world.setBlockState(xyz2, KCore.HeavenlyCloud.getDefaultState());
    				world.setBlockState(xyz3, KCore.HeavenlyCloud.getDefaultState());
    			}
    			
    			for(int i = 0; i < length33; i++)
    			{
    				BlockPos xyz = new BlockPos(posX - i, posY + 1, posZ - 2);
    				BlockPos xyz1 = new BlockPos(posX - i, posY + 1, posZ + 3);
    				BlockPos xyz2 = new BlockPos(posX - i, posY - 1, posZ - 2);
    				BlockPos xyz3 = new BlockPos(posX - i, posY - 1, posZ + 3);
    				world.setBlockState(xyz, KCore.HeavenlyCloud.getDefaultState());
    				world.setBlockState(xyz1, KCore.HeavenlyCloud.getDefaultState());
    				world.setBlockState(xyz2, KCore.HeavenlyCloud.getDefaultState());
    				world.setBlockState(xyz3, KCore.HeavenlyCloud.getDefaultState());
    			}
    			
    			for(int i = 0; i < length44; i++)
    			{
    				BlockPos xyz = new BlockPos(posX - i, posY + 1, posZ - 3);
    				BlockPos xyz1 = new BlockPos(posX - i, posY + 1, posZ + 4);
    				BlockPos xyz2 = new BlockPos(posX - i, posY - 1, posZ - 3);
    				BlockPos xyz3 = new BlockPos(posX - i, posY - 1, posZ + 4);
    				world.setBlockState(xyz, KCore.HeavenlyCloud.getDefaultState());
    				world.setBlockState(xyz1, KCore.HeavenlyCloud.getDefaultState());
    				world.setBlockState(xyz2, KCore.HeavenlyCloud.getDefaultState());
    				world.setBlockState(xyz3, KCore.HeavenlyCloud.getDefaultState());
    			}
    		
    		}
    	
    	}
    	return true;
    }
}