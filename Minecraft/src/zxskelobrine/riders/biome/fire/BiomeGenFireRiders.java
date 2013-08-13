package zxskelobrine.riders.biome.fire;

import java.util.Random;

import zxskelobrine.riders.riders.Riders;
import net.minecraft.block.Block;
import net.minecraft.entity.passive.EntityPig;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.biome.SpawnListEntry;
import net.minecraft.world.gen.feature.WorldGenDesertWells;

public class BiomeGenFireRiders extends BiomeGenBase
{
    public BiomeGenFireRiders(int par1)
    {
        super(par1);
        this.spawnableCreatureList.clear();
        this.spawnableCreatureList.add(new SpawnListEntry(EntityPig.class, 5, 2, 6));
        this.topBlock = (byte)Riders.fireGrass.blockID;
        this.fillerBlock = (byte)Riders.fireStone.blockID;
        this.theBiomeDecorator.treesPerChunk = 3;
        this.theBiomeDecorator.flowersPerChunk =1;
        this.theBiomeDecorator.deadBushPerChunk = -999;
        this.theBiomeDecorator.reedsPerChunk = -999;
        this.theBiomeDecorator.cactiPerChunk = -999;
    }

    public void decorate(World par1World, Random par2Random, int par3, int par4)
    {
        super.decorate(par1World, par2Random, par3, par4);

        if (par2Random.nextInt(1000) == 0)
        {
            int k = par3 + par2Random.nextInt(16) + 8;
            int l = par4 + par2Random.nextInt(16) + 8;
            WorldGenDesertWells worldgendesertwells = new WorldGenDesertWells();
            worldgendesertwells.generate(par1World, par2Random, k, par1World.getHeightValue(k, l) + 1, l);
        }
    }
}
