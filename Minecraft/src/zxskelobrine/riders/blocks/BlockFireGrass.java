package zxskelobrine.riders.blocks;

import java.util.Random;

import zxskelobrine.riders.riders.Riders;
import net.minecraft.block.Block;
import net.minecraft.block.BlockGrass;
import net.minecraft.block.material.Material;

public class BlockFireGrass extends Block{
	Random Drop = new Random();
	public BlockFireGrass(int par1) {
		super(par1, Material.grass);
		// TODO Auto-generated constructor stub
	}
    public int idDropped(int par1, Random par2Random, int par3)
    {
        return Riders.fireDirt.idDropped(par1, par2Random, par3);
    }
}
