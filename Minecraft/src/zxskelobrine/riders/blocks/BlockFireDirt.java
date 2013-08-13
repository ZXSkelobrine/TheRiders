package zxskelobrine.riders.blocks;

import java.util.Random;

import zxskelobrine.riders.riders.Riders;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.util.MathHelper;

public class BlockFireDirt extends Block
{
    public BlockFireDirt(int par1, Material par2Material)
    {
        super(par1, par2Material);
        this.setCreativeTab(CreativeTabs.tabBlock);
    }

    /**
     * Returns the usual quantity dropped by the block plus a bonus of 1 to 'i' (inclusive).
     */

    /**
     * Returns the quantity of items to drop on block destruction.
     */
    public int quantityDropped(Random par1Random)
    {
        return 1;
    }

    /**
     * Returns the ID of the items to drop on destruction.
     */
    public int idDropped(int par1, Random par2Random, int par3)
    {
        return Riders.fireDirt.blockID;
    }
}
