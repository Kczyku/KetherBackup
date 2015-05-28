package com.KMOD.DimBase;

import net.minecraft.world.WorldProvider;
import net.minecraft.world.biome.WorldChunkManagerHell;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import com.KMOD.Core.KCore;

public class WorldProviderHeaven extends WorldProvider
{
	


    protected void registerWorldChunkManager()
    {
        this.worldChunkMgr = new WorldChunkManagerHell(KCore.Heaven, 1.0F);
        this.worldChunkMgr = new HeavenChunkManager(worldObj);
    }



    public IChunkProvider createChunkGenerator()
    {
        return new ChunkProviderHeaven(worldObj, worldObj.getSeed(), true, "");
    }

    public boolean isSurfaceWorld()
    {
        return false;
    }

    public boolean canCoordinateBeSpawn(int x, int z)
    {
        return false;
    }



    public boolean canRespawnHere()
    {
        return false;
    }

    @SideOnly(Side.CLIENT)
    public boolean doesXZShowFog(int x, int z)
    {
        return false;
    }

    public String getDimensionName()
    {
        return "Heaven";
    }

    public String getInternalNameSuffix()
    {
        return "_Heaven";
    }
}