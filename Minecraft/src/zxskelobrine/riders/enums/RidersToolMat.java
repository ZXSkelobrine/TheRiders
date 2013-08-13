package zxskelobrine.riders.enums;

import zxskelobrine.riders.riders.Riders;
import net.minecraft.block.Block;
import net.minecraft.item.Item;

public enum RidersToolMat
{
    Air(0, 59, 2.0F, 0.0F, 15),
    Earth(1, 131, 4.0F, 1.0F, 5),
    Energy(2, 250, 6.0F, 2.0F, 14),
    Fire(3, 1561, 8.0F, 3.0F, 10),
    Ice(3, 1561, 8.0F, 3.0F, 10),
    Lightning(3, 1561, 8.0F, 3.0F, 10),
    Magma(3, 1561, 8.0F, 3.0F, 10),
    Metal(3, 1561, 8.0F, 3.0F, 10),
    Water(0, 32, 12.0F, 0.0F, 22);

    /**
     * The level of material this tool can harvest (3 = DIAMOND, 2 = IRON, 1 = STONE, 0 = IRON/GOLD)
     */
    private final int harvestLevel;

    /**
     * The number of uses this material allows. (wood = 59, stone = 131, iron = 250, diamond = 1561, gold = 32)
     */
    private final int maxUses;

    /**
     * The strength of this tool material against blocks which it is effective against.
     */
    private final float efficiencyOnProperMaterial;

    /** Damage versus entities. */
    private final float damageVsEntity;

    /** Defines the natural enchantability factor of the material. */
    private final int enchantability;

    //Added by forge for custom Armor materials.
    public Item customCraftingMaterial = null;

    private RidersToolMat(int par3, int par4, float par5, float par6, int par7)
    {
        this.harvestLevel = par3;
        this.maxUses = par4;
        this.efficiencyOnProperMaterial = par5;
        this.damageVsEntity = par6;
        this.enchantability = par7;
    }

    /**
     * The number of uses this material allows. (wood = 59, stone = 131, iron = 250, diamond = 1561, gold = 32)
     */
    public int getMaxUses()
    {
        return this.maxUses;
    }

    /**
     * The strength of this tool material against blocks which it is effective against.
     */
    public float getEfficiencyOnProperMaterial()
    {
        return this.efficiencyOnProperMaterial;
    }

    /**
     * Damage versus entities.
     */
    public float getDamageVsEntity()
    {
        return this.damageVsEntity;
    }

    /**
     * The level of material this tool can harvest (3 = DIAMOND, 2 = IRON, 1 = STONE, 0 = IRON/GOLD)
     */
    public int getHarvestLevel()
    {
        return this.harvestLevel;
    }

    /**
     * Return the natural enchantability factor of the material.
     */
    public int getEnchantability()
    {
        return this.enchantability;
    }

    /**
     * Return the crafting material for this tool material, used to determine the item that can be used to repair a tool
     * with an anvil
     */
    public int getToolCraftingMaterial()
    {
        switch (this)
        {
            case Air:    return Riders.airShard.itemID;
            case Earth:   return Riders.earthShard.itemID;
            case Energy:    return Riders.energyShard.itemID;
            case Fire:    return Riders.fireShard.itemID;
            case Ice: return Riders.iceShard.itemID;
            case Lightning: return Riders.lightningShard.itemID;
            case Magma: return Riders.magmaShard.itemID;
            case Metal: return Riders.metalShard.itemID;
            case Water: return Riders.waterShard.itemID;
            default:      return (customCraftingMaterial == null ? 0 : customCraftingMaterial.itemID);
        }
    }
}
