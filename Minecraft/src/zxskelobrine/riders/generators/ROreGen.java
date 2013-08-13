package zxskelobrine.riders.generators;

import java.util.Random;

import zxskelobrine.riders.riders.Riders;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.World;
import cpw.mods.fml.common.IWorldGenerator;

public class ROreGen implements IWorldGenerator { 

	Random RGen = new Random();
	int RInt = RGen.nextInt(16) * 16 + 1;
	int RInt2 = RInt - 1;
	
        @Override
        public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
        	world.setBlock(chunkX*16 + random.nextInt(16), random.nextInt(34) + 1, chunkZ*16 + random.nextInt(16), Riders.airOre.blockID);
        	world.setBlock(chunkX*16 + random.nextInt(16), random.nextInt(34) + 1, chunkZ*16 + random.nextInt(16), Riders.earthOre.blockID);
        	world.setBlock(chunkX*16 + random.nextInt(16), random.nextInt(34) + 1, chunkZ*16 + random.nextInt(16), Riders.energyOre.blockID);
        	world.setBlock(chunkX*16 + random.nextInt(16), random.nextInt(34) + 1, chunkZ*16 + random.nextInt(16), Riders.fireOre.blockID);
        	world.setBlock(chunkX*16 + random.nextInt(16), random.nextInt(34) + 1, chunkZ*16 + random.nextInt(16), Riders.iceOre.blockID);
        	world.setBlock(chunkX*16 + random.nextInt(16), random.nextInt(34) + 1, chunkZ*16 + random.nextInt(16), Riders.lightningOre.blockID);
        	world.setBlock(chunkX*16 + random.nextInt(16), random.nextInt(34) + 1, chunkZ*16 + random.nextInt(16), Riders.magmaOre.blockID);
        	world.setBlock(chunkX*16 + random.nextInt(16), random.nextInt(34) + 1, chunkZ*16 + random.nextInt(16), Riders.metalOre.blockID);
        	world.setBlock(chunkX*16 + random.nextInt(16), random.nextInt(34) + 1, chunkZ*16 + random.nextInt(16), Riders.waterOre.blockID);
        	
        	world.setBlock(RInt, random.nextInt(34) + 1,RInt, Riders.airOre.blockID);
        	world.setBlock(RInt2, random.nextInt(34) + 1,RInt2, Riders.airOre.blockID);
        	
        }

}