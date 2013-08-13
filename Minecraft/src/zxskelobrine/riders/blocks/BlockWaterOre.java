package zxskelobrine.riders.blocks;

import java.util.Random;

import zxskelobrine.riders.riders.Riders;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class BlockWaterOre extends Block
{
    public BlockWaterOre(int par1)
    {
        super(par1, Material.rock);
        this.setCreativeTab(CreativeTabs.tabBlock);
    }

    /**
     * Returns the ID of the items to drop on destruction.
     */
    public int idDropped(int par1, Random par2Random, int par3)
    {
        return this.blockID == Riders.airOre.blockID ? Riders.airShard.itemID : (this.blockID == Riders.earthOre.blockID ? Riders.earthShard.itemID : (this.blockID == Riders.energyOre.blockID ? Riders.energyShard.itemID : (this.blockID == Riders.fireOre.blockID ? Riders.fireShard.itemID : (this.blockID == Riders.iceOre.blockID ? Riders.iceShard.itemID : (this.blockID == Riders.lightningOre.blockID ? Riders.lightningShard.itemID : (this.blockID == Riders.magmaOre.blockID ? Riders.magmaShard.itemID : (this.blockID == Riders.metalOre.blockID ? Riders.metalShard.itemID : (this.blockID == Riders.waterOre.blockID ? Riders.waterShard.itemID : this.blockID))))))));
    }

    /**
     * Returns the quantity of items to drop on block destruction.
     */

    /**
     * Returns the usual quantity dropped by the block plus a bonus of 1 to 'i' (inclusive).
     */
    public int quantityDroppedWithBonus(int par1, Random par2Random)
    {
        if (par1 > 0 && this.blockID != this.idDropped(0, par2Random, par1))
        {
            int j = par2Random.nextInt(par1 + 2) - 1;

            if (j < 0)
            {
                j = 0;
            }

            return this.quantityDropped(par2Random) * (j + 1);
        }
        else
        {
            return this.quantityDropped(par2Random);
        }
    }

    /**
     * Drops the block items with a specified chance of dropping the specified items
     */
    public void dropBlockAsItemWithChance(World par1World, int par2, int par3, int par4, int par5, float par6, int par7)
    {
        super.dropBlockAsItemWithChance(par1World, par2, par3, par4, par5, par6, par7);

        if (this.idDropped(par5, par1World.rand, par7) != this.blockID)
        {
            int j1 = 0;

            if (this.blockID == Riders.airOre.blockID)
            {
                j1 = MathHelper.getRandomIntegerInRange(par1World.rand, 0, 2);
            }
            else if (this.blockID == Riders.earthOre.blockID)
            {
                j1 = MathHelper.getRandomIntegerInRange(par1World.rand, 3, 7);
            }
            else if (this.blockID == Riders.energyOre.blockID)
            {
                j1 = MathHelper.getRandomIntegerInRange(par1World.rand, 3, 7);
            }
            else if (this.blockID == Riders.fireOre.blockID)
            {
                j1 = MathHelper.getRandomIntegerInRange(par1World.rand, 2, 5);
            }
            else if (this.blockID == Riders.iceOre.blockID)
            {
                j1 = MathHelper.getRandomIntegerInRange(par1World.rand, 2, 5);
            }
            else if (this.blockID == Riders.lightningOre.blockID)
            {
                j1 = MathHelper.getRandomIntegerInRange(par1World.rand, 2, 5);
            }
            else if (this.blockID == Riders.magmaOre.blockID)
            {
                j1 = MathHelper.getRandomIntegerInRange(par1World.rand, 2, 5);
            }
            else if (this.blockID == Riders.metalOre.blockID)
            {
                j1 = MathHelper.getRandomIntegerInRange(par1World.rand, 2, 5);
            }
            else if (this.blockID == Riders.waterOre.blockID)
            {
                j1 = MathHelper.getRandomIntegerInRange(par1World.rand, 2, 5);
            }

            this.dropXpOnBlockBreak(par1World, par2, par3, par4, j1);
        }
    }

    /**
     * Determines the damage on the item the block drops. Used in cloth and wood.
     */
}
