package zxskelobrine.riders.riders;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.src.ModLoader;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.common.EnumHelper;
import zxskelobrine.riders.biome.fire.BiomeGenFireRiders;
import zxskelobrine.riders.biome.fire.WorldProviderFire;
import zxskelobrine.riders.biome.ice.BiomeGenIceRiders;
import zxskelobrine.riders.blocks.BlockFireCobble;
import zxskelobrine.riders.blocks.BlockFireDirt;
import zxskelobrine.riders.blocks.BlockFireGrass;
import zxskelobrine.riders.blocks.BlockFireRide;
import zxskelobrine.riders.blocks.BlockFireStone;
import zxskelobrine.riders.blocks.BlockGrassRide;
import zxskelobrine.riders.blocks.BlockPortalRide;
import zxskelobrine.riders.blocks.BlockWaterOre;
import zxskelobrine.riders.blocks.ice.BlockIceCobble;
import zxskelobrine.riders.blocks.ice.BlockIceDirt;
import zxskelobrine.riders.blocks.ice.BlockIceStone;
import zxskelobrine.riders.enums.RidersToolMat;
import zxskelobrine.riders.generators.ROreGen;
import zxskelobrine.riders.items.Armour;
import zxskelobrine.riders.items.ItemAirShard;
import zxskelobrine.riders.items.ItemAxeRiders;
import zxskelobrine.riders.items.ItemEarthShard;
import zxskelobrine.riders.items.ItemEnergyShard;
import zxskelobrine.riders.items.ItemFireShard;
import zxskelobrine.riders.items.ItemHoeRiders;
import zxskelobrine.riders.items.ItemIceShard;
import zxskelobrine.riders.items.ItemLightingShard;
import zxskelobrine.riders.items.ItemMagmaShard;
import zxskelobrine.riders.items.ItemMetalShard;
import zxskelobrine.riders.items.ItemPickaxeRiders;
import zxskelobrine.riders.items.ItemPortalPlacer;
import zxskelobrine.riders.items.ItemShovelRiders;
import zxskelobrine.riders.items.ItemSteelAndFlint;
import zxskelobrine.riders.items.ItemSwordRiders;
import zxskelobrine.riders.items.ItemWaterShard;
import zxskelobrine.riders.proxy.CommonProxy;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

@Mod(modid="mod_riders", name="The Riders Mod", version="1.2.13")//Version Increment Guide - x.y.z x-Increase Each MC Version | y-Increase Each Major Update/Addition | z-Increase Each Minor Change/Addition
@NetworkMod(clientSideRequired=true, serverSideRequired=false)
public class Riders {
	
	
	public static int DimID = 2;
	public static int DimIceID = 3;
	
	static Random Drop = new Random();
	int Drops = Drop.nextInt(2);
	
	
	int airHelmetID = 3070;
	int airChestID = 3071;
	int airLegsID = 3072;
	int airBootsID = 3073;
	
	int earthHelmetID = 3074;
	int earthChestID = 3075;
	int earthLegsID = 3076;
	int earthBootsID = 3105;
	
	int energyHelmetID = 3077;
	int energyChestID = 3078;
	int energyLegsID = 3079;
	int energyBootsID = 3080;
	
	int fireHelmetID = 3081;
	int fireChestID = 3082;
	int fireLegsID = 3083;
	int fireBootsID = 3084;
	
	int iceHelmetID = 3085;
	int iceChestID = 3086;
	int iceLegsID = 3087;
	int iceBootsID = 3088;
	
	int lightningHelmetID = 3089;
	int lightningChestID = 3090;
	int lightningLegsID = 3091;
	int lightningBootsID = 3092;
	
	int magmaHelmetID = 3093;
	int magmaChestID = 3094;
	int magmaLegsID = 3095;
	int magmaBootsID = 3096;

	int metalHelmetID = 3097;
	int metalChestID = 3098;
	int metalLegsID = 3099;
	int metalBootsID = 3100;
	
	int waterHelmetID = 3101;
	int waterChestID = 3102;
	int waterLegsID = 3103;
	int waterBootsID = 3104;
	
	
	
    public static EnumArmorMaterial ridersArmour = EnumHelper.addArmorMaterial("ridersArmour", 26, new int[]{4, 11, 7, 4}, 7);
	
	public static Item airHelmet;
	public static Item airChest;
	public static Item airLegs;
	public static Item airBoots;
	
	public static Item earthHelmet;
	public static Item earthChest;
	public static Item earthLegs;
	public static Item earthBoots;
	
	public static Item energyHelmet;
	public static Item energyChest;
	public static Item energyLegs;
	public static Item energyBoots;
	
	public static Item fireHelmet;
	public static Item fireChest;
	public static Item fireLegs;
	public static Item fireBoots;
	
	public static Item iceHelmet;
	public static Item iceChest;
	public static Item iceLegs;
	public static Item iceBoots;
	
	public static Item lightningHelmet;
	public static Item lightningChest;
	public static Item lightningLegs;
	public static Item lightningBoots;
	
	public static Item magmaHelmet;
	public static Item magmaChest;
	public static Item magmaLegs;
	public static Item magmaBoots;

	public static Item metalHelmet;
	public static Item metalChest;
	public static Item metalLegs;
	public static Item metalBoots;
	
	public static Item waterHelmet;
	public static Item waterChest;
	public static Item waterLegs;
	public static Item waterBoots;
	

        // The instance of your mod that Forge uses.
        @Instance("mod_riders")
        public static Riders instance;
        
        // Says where the client and server 'proxy' code is loaded.
        @SidedProxy(clientSide="zxskelobrine.riders.proxy.ClientProxy", serverSide="zxskelobrine.riders.proxy.CommonProxy")
        public static CommonProxy proxy;
        
        @EventHandler
        public void preInit(FMLPreInitializationEvent event) {
                // Stub Method
        	this.InitializeAssests();
        	this.DimesionCrap();
        	this.GRCraftingShovel();
        	this.GRCraftingPickaxe();
        	this.GRCraftingHoe();
        	this.GRCraftingSword();
        	this.GRCraftingAxe();
        	this.Shards();
        	this.Generators();
        	this.OresImp();
        	this.StoneImp();
        	this.PickaxeImp();
        	this.AxeImp();
        	this.SwordImp();
        	this.HoeImp();
        	this.ShovelImp();
        	this.AirArmour();
        	this.EarthArmour();
        	this.EnergyArmour();
        	this.FireArmour();
        	this.IceArmour();
        	this.LightningArmour();
        	this.MagmaArmour();
        	this.MetalArmour();
        	this.WaterArmour();
        }
        
        
        public static ROreGen worldGen = new ROreGen();
        @EventHandler
        public void load(FMLInitializationEvent event) {
                proxy.registerRenderers();
                DimensionManager.registerProviderType(DimID, WorldProviderFire.class, true);
                DimensionManager.registerDimension(DimID, DimID);
        }

        public void InitializeAssests()
        {
        	airHelmet = new Armour(airHelmetID, ridersArmour, 0, 0, "air");
        	airChest = new Armour(airChestID, ridersArmour, 0, 1, "air");
        	airLegs = new Armour(airLegsID, ridersArmour, 0, 2, "air");
        	airBoots = new Armour(airBootsID, ridersArmour, 0, 3, "air");
        	
        	earthHelmet = new Armour(earthHelmetID, ridersArmour, 0, 0, "earth");
        	earthChest = new Armour(earthChestID, ridersArmour, 0, 1, "earth");
        	earthLegs = new Armour(earthLegsID, ridersArmour, 0, 2, "earth");
        	earthBoots = new Armour(earthBootsID, ridersArmour, 0, 3, "earth");
        	
        	energyHelmet = new Armour(energyHelmetID, ridersArmour, 0, 0, "energy");
        	energyChest = new Armour(energyChestID, ridersArmour, 0, 1, "energy");
        	energyLegs = new Armour(energyLegsID, ridersArmour, 0, 2, "energy");
        	energyBoots = new Armour(energyBootsID, ridersArmour, 0, 3, "energy");
        	
        	fireHelmet = new Armour(fireHelmetID, ridersArmour, 0, 0, "fire");
        	fireChest = new Armour(fireChestID, ridersArmour, 0, 1, "fire");
        	fireLegs = new Armour(fireLegsID, ridersArmour, 0, 2, "fire");
        	fireBoots = new Armour(fireBootsID, ridersArmour, 0, 3, "fire");
        	
        	iceHelmet = new Armour(iceHelmetID, ridersArmour, 0, 0, "ice");
        	iceChest = new Armour(iceChestID, ridersArmour, 0, 1, "ice");
        	iceLegs = new Armour(iceLegsID, ridersArmour, 0, 2, "ice");
        	iceBoots = new Armour(iceBootsID, ridersArmour, 0, 3, "ice");
        	
        	lightningHelmet = new Armour(lightningHelmetID, ridersArmour, 0, 0, "lightning");
        	lightningChest = new Armour(lightningChestID, ridersArmour, 0, 1, "lightning");
        	lightningLegs = new Armour(lightningLegsID, ridersArmour, 0, 2, "lightning");
        	lightningBoots = new Armour(lightningBootsID, ridersArmour, 0, 3, "lightning");
        	
        	magmaHelmet = new Armour(magmaHelmetID, ridersArmour, 0, 0, "magma");
        	magmaChest = new Armour(magmaChestID, ridersArmour, 0, 1, "magma");
        	magmaLegs = new Armour(magmaLegsID, ridersArmour, 0, 2, "magma");
        	magmaBoots = new Armour(magmaBootsID, ridersArmour, 0, 3, "magma");
        	
        	metalHelmet = new Armour(metalHelmetID, ridersArmour, 0, 0, "metal");
        	metalChest = new Armour(metalChestID, ridersArmour, 0, 1, "metal");
        	metalLegs = new Armour(metalLegsID, ridersArmour, 0, 2, "metal");
        	metalBoots = new Armour(metalBootsID, ridersArmour, 0, 3, "metal");
        	
        	waterHelmet = new Armour(waterHelmetID, ridersArmour, 0, 0, "water");
        	waterChest = new Armour(waterChestID, ridersArmour, 0, 1, "water");
        	waterLegs = new Armour(waterLegsID, ridersArmour, 0, 2, "water");
        	waterBoots = new Armour(waterBootsID, ridersArmour, 0, 3, "water");
        }
        
        public void GRCraftingShovel()
        {
            GameRegistry.addRecipe(new ItemStack(Riders.airShovel),
            		" X ", " Y ", " Y ", Character.valueOf('X'), new ItemStack(Riders.airShard), Character.valueOf('Y'), new ItemStack(Item.stick));
            GameRegistry.addRecipe(new ItemStack(Riders.earthShovel),
            		" X ", " Y ", " Y ", Character.valueOf('X'), new ItemStack(Riders.earthShard), Character.valueOf('Y'), new ItemStack(Item.stick));
            GameRegistry.addRecipe(new ItemStack(Riders.energyShovel),
            		" X ", " Y ", " Y ", Character.valueOf('X'), new ItemStack(Riders.energyShard), Character.valueOf('Y'), new ItemStack(Item.stick));
            GameRegistry.addRecipe(new ItemStack(Riders.fireShovel),
            		" X ", " Y ", " Y ", Character.valueOf('X'), new ItemStack(Riders.fireShard), Character.valueOf('Y'), new ItemStack(Item.stick));
            GameRegistry.addRecipe(new ItemStack(Riders.iceShovel),
            		" X ", " Y ", " Y ", Character.valueOf('X'), new ItemStack(Riders.iceShard), Character.valueOf('Y'), new ItemStack(Item.stick));
            GameRegistry.addRecipe(new ItemStack(Riders.lightningShovel),
            		" X ", " Y ", " Y ", Character.valueOf('X'), new ItemStack(Riders.lightningShard), Character.valueOf('Y'), new ItemStack(Item.stick));
            GameRegistry.addRecipe(new ItemStack(Riders.magmaShovel),
            		" X ", " Y ", " Y ", Character.valueOf('X'), new ItemStack(Riders.magmaShard), Character.valueOf('Y'), new ItemStack(Item.stick));
            GameRegistry.addRecipe(new ItemStack(Riders.metalShovel),
            		" X ", " Y ", " Y ", Character.valueOf('X'), new ItemStack(Riders.metalShard), Character.valueOf('Y'), new ItemStack(Item.stick));
            GameRegistry.addRecipe(new ItemStack(Riders.waterShovel),
            		" X ", " Y ", " Y ", Character.valueOf('X'), new ItemStack(Riders.waterShard), Character.valueOf('Y'), new ItemStack(Item.stick));
        }
        
        public void GRCraftingPickaxe()
        {
            GameRegistry.addRecipe(new ItemStack(Riders.airPickaxe),
            		"XXX", " Y ", " Y ", Character.valueOf('X'), new ItemStack(Riders.airShard), Character.valueOf('Y'), new ItemStack(Item.stick));
            GameRegistry.addRecipe(new ItemStack(Riders.earthPickaxe),
            		"XXX", " Y ", " Y ", Character.valueOf('X'), new ItemStack(Riders.earthShard), Character.valueOf('Y'), new ItemStack(Item.stick));
            GameRegistry.addRecipe(new ItemStack(Riders.energyPickaxe),
            		"XXX", " Y ", " Y ", Character.valueOf('X'), new ItemStack(Riders.energyShard), Character.valueOf('Y'), new ItemStack(Item.stick));
            GameRegistry.addRecipe(new ItemStack(Riders.firePickaxe),
            		"XXX", " Y ", " Y ", Character.valueOf('X'), new ItemStack(Riders.fireShard), Character.valueOf('Y'), new ItemStack(Item.stick));
            GameRegistry.addRecipe(new ItemStack(Riders.icePickaxe),
            		"XXX", " Y ", " Y ", Character.valueOf('X'), new ItemStack(Riders.iceShard), Character.valueOf('Y'), new ItemStack(Item.stick));
            GameRegistry.addRecipe(new ItemStack(Riders.lightningPickaxe),
            		"XXX", " Y ", " Y ", Character.valueOf('X'), new ItemStack(Riders.lightningShard), Character.valueOf('Y'), new ItemStack(Item.stick));
            GameRegistry.addRecipe(new ItemStack(Riders.magmaPickaxe),
            		"XXX", " Y ", " Y ", Character.valueOf('X'), new ItemStack(Riders.magmaShard), Character.valueOf('Y'), new ItemStack(Item.stick));
            GameRegistry.addRecipe(new ItemStack(Riders.metalPickaxe),
            		"XXX", " Y ", " Y ", Character.valueOf('X'), new ItemStack(Riders.metalShard), Character.valueOf('Y'), new ItemStack(Item.stick));
            GameRegistry.addRecipe(new ItemStack(Riders.waterPickaxe),
            		"XXX", " Y ", " Y ", Character.valueOf('X'), new ItemStack(Riders.waterShard), Character.valueOf('Y'), new ItemStack(Item.stick));
        }
        
        public void GRCraftingHoe()
        {
            GameRegistry.addRecipe(new ItemStack(Riders.airHoe),
            		" XX", " Y ", " Y ", Character.valueOf('X'), new ItemStack(Riders.airShard), Character.valueOf('Y'), new ItemStack(Item.stick));
            GameRegistry.addRecipe(new ItemStack(Riders.earthHoe),
            		" XX", " Y ", " Y ", Character.valueOf('X'), new ItemStack(Riders.earthShard), Character.valueOf('Y'), new ItemStack(Item.stick));
            GameRegistry.addRecipe(new ItemStack(Riders.energyHoe),
            		" XX", " Y ", " Y ", Character.valueOf('X'), new ItemStack(Riders.energyShard), Character.valueOf('Y'), new ItemStack(Item.stick));
            GameRegistry.addRecipe(new ItemStack(Riders.fireHoe),
            		" XX", " Y ", " Y ", Character.valueOf('X'), new ItemStack(Riders.fireShard), Character.valueOf('Y'), new ItemStack(Item.stick));
            GameRegistry.addRecipe(new ItemStack(Riders.iceHoe),
            		" XX", " Y ", " Y ", Character.valueOf('X'), new ItemStack(Riders.iceShard), Character.valueOf('Y'), new ItemStack(Item.stick));
            GameRegistry.addRecipe(new ItemStack(Riders.lightningHoe),
            		" XX", " Y ", " Y ", Character.valueOf('X'), new ItemStack(Riders.lightningShard), Character.valueOf('Y'), new ItemStack(Item.stick));
            GameRegistry.addRecipe(new ItemStack(Riders.magmaHoe),
            		" XX", " Y ", " Y ", Character.valueOf('X'), new ItemStack(Riders.magmaShard), Character.valueOf('Y'), new ItemStack(Item.stick));
            GameRegistry.addRecipe(new ItemStack(Riders.metalHoe),
            		" XX", " Y ", " Y ", Character.valueOf('X'), new ItemStack(Riders.metalShard), Character.valueOf('Y'), new ItemStack(Item.stick));
            GameRegistry.addRecipe(new ItemStack(Riders.waterHoe),
            		" XX", " Y ", " Y ", Character.valueOf('X'), new ItemStack(Riders.waterShard), Character.valueOf('Y'), new ItemStack(Item.stick));
        }
        
        public void GRCraftingSword()
        {
            GameRegistry.addRecipe(new ItemStack(Riders.airSword),
            		" X ", " X ", " Y ", Character.valueOf('X'), new ItemStack(Riders.airShard), Character.valueOf('Y'), new ItemStack(Item.stick));
            GameRegistry.addRecipe(new ItemStack(Riders.earthSword),
            		" X ", " X ", " Y ", Character.valueOf('X'), new ItemStack(Riders.earthShard), Character.valueOf('Y'), new ItemStack(Item.stick));
            GameRegistry.addRecipe(new ItemStack(Riders.energySword),
            		" X ", " X ", " Y ", Character.valueOf('X'), new ItemStack(Riders.energyShard), Character.valueOf('Y'), new ItemStack(Item.stick));
            GameRegistry.addRecipe(new ItemStack(Riders.fireSword),
            		" X ", " X ", " Y ", Character.valueOf('X'), new ItemStack(Riders.fireShard), Character.valueOf('Y'), new ItemStack(Item.stick));
            GameRegistry.addRecipe(new ItemStack(Riders.iceSword),
            		" X ", " X ", " Y ", Character.valueOf('X'), new ItemStack(Riders.iceShard), Character.valueOf('Y'), new ItemStack(Item.stick));
            GameRegistry.addRecipe(new ItemStack(Riders.lightningSword),
            		" X ", " X ", " Y ", Character.valueOf('X'), new ItemStack(Riders.lightningShard), Character.valueOf('Y'), new ItemStack(Item.stick));
            GameRegistry.addRecipe(new ItemStack(Riders.magmaSword),
            		" X ", " X ", " Y ", Character.valueOf('X'), new ItemStack(Riders.magmaShard), Character.valueOf('Y'), new ItemStack(Item.stick));
            GameRegistry.addRecipe(new ItemStack(Riders.metalSword),
            		" X ", " X ", " Y ", Character.valueOf('X'), new ItemStack(Riders.metalShard), Character.valueOf('Y'), new ItemStack(Item.stick));
            GameRegistry.addRecipe(new ItemStack(Riders.waterSword),
            		" X ", " X ", " Y ", Character.valueOf('X'), new ItemStack(Riders.waterShard), Character.valueOf('Y'), new ItemStack(Item.stick));
        }
        
        public void GRCraftingAxe()
        {
            GameRegistry.addRecipe(new ItemStack(Riders.airAxe),
            		" XX", " YX", " Y", Character.valueOf('X'), new ItemStack(Riders.airShard), Character.valueOf('Y'), new ItemStack(Item.stick));
            GameRegistry.addRecipe(new ItemStack(Riders.earthAxe),
            		" XX", " YX", " Y", Character.valueOf('X'), new ItemStack(Riders.earthShard), Character.valueOf('Y'), new ItemStack(Item.stick));
            GameRegistry.addRecipe(new ItemStack(Riders.energyAxe),
            		" XX", " YX", " Y", Character.valueOf('X'), new ItemStack(Riders.energyShard), Character.valueOf('Y'), new ItemStack(Item.stick));
            GameRegistry.addRecipe(new ItemStack(Riders.fireAxe),
            		" XX", " YX", " Y", Character.valueOf('X'), new ItemStack(Riders.fireShard), Character.valueOf('Y'), new ItemStack(Item.stick));
            GameRegistry.addRecipe(new ItemStack(Riders.iceAxe),
            		" XX", " YX", " Y", Character.valueOf('X'), new ItemStack(Riders.iceShard), Character.valueOf('Y'), new ItemStack(Item.stick));
            GameRegistry.addRecipe(new ItemStack(Riders.lightningAxe),
            		" XX", " YX", " Y", Character.valueOf('X'), new ItemStack(Riders.lightningShard), Character.valueOf('Y'), new ItemStack(Item.stick));
            GameRegistry.addRecipe(new ItemStack(Riders.magmaAxe),
            		" XX", " YX", " Y", Character.valueOf('X'), new ItemStack(Riders.magmaShard), Character.valueOf('Y'), new ItemStack(Item.stick));
            GameRegistry.addRecipe(new ItemStack(Riders.metalAxe),
            		" XX", " YX", " Y", Character.valueOf('X'), new ItemStack(Riders.metalShard), Character.valueOf('Y'), new ItemStack(Item.stick));
            GameRegistry.addRecipe(new ItemStack(Riders.waterAxe),
            		" XX", " YX", " Y", Character.valueOf('X'), new ItemStack(Riders.waterShard), Character.valueOf('Y'), new ItemStack(Item.stick));
        }
        
        public void AirArmourCrafting()
        {
            GameRegistry.addRecipe(new ItemStack(Riders.airHelmet),
            		"XXX", "X X", "   ", Character.valueOf('X'), new ItemStack(Riders.airShard));
            GameRegistry.addRecipe(new ItemStack(Riders.airChest),
            		"X X", "XXX", "XXX", Character.valueOf('X'), new ItemStack(Riders.airShard));
            GameRegistry.addRecipe(new ItemStack(Riders.airLegs),
            		"XXX", "X X", "X X", Character.valueOf('X'), new ItemStack(Riders.airShard));
            GameRegistry.addRecipe(new ItemStack(Riders.airBoots),
            		"   ", "X X", "X X", Character.valueOf('X'), new ItemStack(Riders.airShard));
        }
        
        public void Shards()
        {
            GameRegistry.registerItem(airShard, "airShard");
            LanguageRegistry.addName(airShard, "Air Shard");
            GameRegistry.registerItem(earthShard, "earthShard");
            LanguageRegistry.addName(earthShard, "Earth Shard");
            GameRegistry.registerItem(energyShard, "energyShard");
            LanguageRegistry.addName(energyShard, "Energy Shard");
            GameRegistry.registerItem(fireShard, "fireShard");
            LanguageRegistry.addName(fireShard, "Fire Shard");
            GameRegistry.registerItem(iceShard, "iceShard");
            LanguageRegistry.addName(iceShard, "Ice Shard");
            GameRegistry.registerItem(lightningShard, "lightingShard");
            LanguageRegistry.addName(lightningShard, "Lightning Shard");
            GameRegistry.registerItem(magmaShard, "magmaShard");
            LanguageRegistry.addName(magmaShard, "Magma Shard");
            GameRegistry.registerItem(metalShard, "metalShard");
            LanguageRegistry.addName(metalShard, "Metal Shard");
            GameRegistry.registerItem(waterShard, "waterShard");
            LanguageRegistry.addName(waterShard, "Water Shard");
        }
        
        public void Generators()
        {
            GameRegistry.registerWorldGenerator(worldGen);
        }

        public void OresImp()
        {
        	GameRegistry.registerBlock(airOre, "airOre");
            LanguageRegistry.addName(airOre, "Air Ore");
            GameRegistry.registerBlock(earthOre, "earthOre");
            LanguageRegistry.addName(earthOre, "Earth Ore");
            GameRegistry.registerBlock(energyOre, "energyOre");
            LanguageRegistry.addName(energyOre, "Energy Ore");
            GameRegistry.registerBlock(fireOre, "fireOre");
            LanguageRegistry.addName(fireOre, "Fire Ore");
            GameRegistry.registerBlock(iceOre, "iceOre");
            LanguageRegistry.addName(iceOre, "Ice Ore");
            GameRegistry.registerBlock(lightningOre, "lightingOre");
            LanguageRegistry.addName(lightningOre, "Lightning Ore");
            GameRegistry.registerBlock(magmaOre, "magmaOre");
            LanguageRegistry.addName(magmaOre, "Magma Ore");
            GameRegistry.registerBlock(metalOre, "metalOre");
            LanguageRegistry.addName(metalOre, "Metal Ore");
            GameRegistry.registerBlock(waterOre, "waterOre");
            LanguageRegistry.addName(waterOre, "Water Ore");
        }
        
        public void StoneImp()
        {
        	GameRegistry.registerBlock(fireStone, "fireStone");
        	LanguageRegistry.addName(fireStone, "Fire Stone");
        	GameRegistry.registerBlock(fireCobble, "fireCobble");
        	LanguageRegistry.addName(fireCobble, "Fire Cobblestone");
        	GameRegistry.registerBlock(fireDirt, "fireDirt");
        	LanguageRegistry.addName(fireDirt, "Fire Dirt");
        	GameRegistry.registerBlock(fireGrass, "fireGrass");
        	LanguageRegistry.addName(fireGrass, "Fire Grass");
        	
        }
        
        public void PickaxeImp()
        {
            GameRegistry.registerItem(airPickaxe, "airPickaxe");
            LanguageRegistry.addName(airPickaxe, "Air Pickaxe");
            GameRegistry.registerItem(earthPickaxe, "earthPickaxe");
            LanguageRegistry.addName(earthPickaxe, "Earth Pickaxe");
            GameRegistry.registerItem(energyPickaxe, "energyPickaxe");
            LanguageRegistry.addName(energyPickaxe, "Energy Pickaxe");
            GameRegistry.registerItem(firePickaxe, "firePickaxe");
            LanguageRegistry.addName(firePickaxe, "Fire Pickaxe");
            GameRegistry.registerItem(icePickaxe, "icePickaxe");
            LanguageRegistry.addName(icePickaxe, "Ice Pickaxe");
            GameRegistry.registerItem(lightningPickaxe, "lightingPickaxe");
            LanguageRegistry.addName(lightningPickaxe, "Lightning Pickaxe");
            GameRegistry.registerItem(magmaPickaxe, "magmaPickaxe");
            LanguageRegistry.addName(magmaPickaxe, "Magma Pickaxe");
            GameRegistry.registerItem(metalPickaxe, "metalPickaxe");
            LanguageRegistry.addName(metalPickaxe, "Metal Pickaxe");
            GameRegistry.registerItem(waterPickaxe, "waterPickaxe");
            LanguageRegistry.addName(waterPickaxe, "Water Pickaxe");
        }
        
        public void AxeImp()
        {
            GameRegistry.registerItem(airAxe, "airAxe");
            LanguageRegistry.addName(airAxe, "Air Axe");
            GameRegistry.registerItem(earthAxe, "earthAxe");
            LanguageRegistry.addName(earthAxe, "Earth Axe");
            GameRegistry.registerItem(energyAxe, "energyAxe");
            LanguageRegistry.addName(energyAxe, "Energy Axe");
            GameRegistry.registerItem(fireAxe, "fireAxe");
            LanguageRegistry.addName(fireAxe, "Fire Axe");
            GameRegistry.registerItem(iceAxe, "iceAxe");
            LanguageRegistry.addName(iceAxe, "Ice Axe");
            GameRegistry.registerItem(lightningAxe, "lightingAxe");
            LanguageRegistry.addName(lightningAxe, "Lightning Axe");
            GameRegistry.registerItem(magmaAxe, "magmaAxe");
            LanguageRegistry.addName(magmaAxe, "Magma Axe");
            GameRegistry.registerItem(metalAxe, "metalAxe");
            LanguageRegistry.addName(metalAxe, "Metal Axe");
            GameRegistry.registerItem(waterAxe, "waterAxe");
            LanguageRegistry.addName(waterAxe, "Water Axe");
        }
        
        public void SwordImp()
        {
            GameRegistry.registerItem(airSword, "airSword");
            LanguageRegistry.addName(airSword, "Air Sword");
            GameRegistry.registerItem(earthSword, "earthSword");
            LanguageRegistry.addName(earthSword, "Earth Sword");
            GameRegistry.registerItem(energySword, "energySword");
            LanguageRegistry.addName(energySword, "Energy Sword");
            GameRegistry.registerItem(fireSword, "fireSword");
            LanguageRegistry.addName(fireSword, "Fire Sword");
            GameRegistry.registerItem(iceSword, "iceSword");
            LanguageRegistry.addName(iceSword, "Ice Sword");
            GameRegistry.registerItem(lightningSword, "lightingSword");
            LanguageRegistry.addName(lightningSword, "Lightning Sword");
            GameRegistry.registerItem(magmaSword, "magmaSword");
            LanguageRegistry.addName(magmaSword, "Magma Sword");
            GameRegistry.registerItem(metalSword, "metalSword");
            LanguageRegistry.addName(metalSword, "Metal Sword");
            GameRegistry.registerItem(waterSword, "waterSword");
            LanguageRegistry.addName(waterSword, "Water Sword");
        }
        
        public void HoeImp()
        {
            GameRegistry.registerItem(airHoe, "airHoe");
            LanguageRegistry.addName(airHoe, "Air Hoe");
            GameRegistry.registerItem(earthHoe, "earthHoe");
            LanguageRegistry.addName(earthHoe, "Earth Hoe");
            GameRegistry.registerItem(energyHoe, "energyHoe");
            LanguageRegistry.addName(energyHoe, "Energy Hoe");
            GameRegistry.registerItem(fireHoe, "fireHoe");
            LanguageRegistry.addName(fireHoe, "Fire Hoe");
            GameRegistry.registerItem(iceHoe, "iceHoe");
            LanguageRegistry.addName(iceHoe, "Ice Hoe");
            GameRegistry.registerItem(lightningHoe, "lightingHoe");
            LanguageRegistry.addName(lightningHoe, "Lightning Hoe");
            GameRegistry.registerItem(magmaHoe, "magmaHoe");
            LanguageRegistry.addName(magmaHoe, "Magma Hoe");
            GameRegistry.registerItem(metalHoe, "metalHoe");
            LanguageRegistry.addName(metalHoe, "Metal Hoe");
            GameRegistry.registerItem(waterHoe, "waterHoe");
            LanguageRegistry.addName(waterHoe, "Water Hoe");
        }
        
        public void ShovelImp()
        {
            GameRegistry.registerItem(airShovel, "airShovel");
            LanguageRegistry.addName(airShovel, "Air Shovel");
            GameRegistry.registerItem(earthShovel, "earthShovel");
            LanguageRegistry.addName(earthShovel, "Earth Shovel");
            GameRegistry.registerItem(energyShovel, "energyShovel");
            LanguageRegistry.addName(energyShovel, "Energy Shovel");
            GameRegistry.registerItem(fireShovel, "fireShovel");
            LanguageRegistry.addName(fireShovel, "Fire Shovel");
            GameRegistry.registerItem(iceShovel, "iceShovel");
            LanguageRegistry.addName(iceShovel, "Ice Shovel");
            GameRegistry.registerItem(lightningShovel, "lightingShovel");
            LanguageRegistry.addName(lightningShovel, "Lightning Shovel");
            GameRegistry.registerItem(magmaShovel, "magmaShovel");
            LanguageRegistry.addName(magmaShovel, "Magma Shovel");
            GameRegistry.registerItem(metalShovel, "metalShovel");
            LanguageRegistry.addName(metalShovel, "Metal Shovel");
            GameRegistry.registerItem(waterShovel, "waterShovel");
            LanguageRegistry.addName(waterShovel, "Water Shovel");
        }

        public void AirArmour()
        {
            GameRegistry.registerItem(airHelmet, "airHelmet");
            LanguageRegistry.addName(airHelmet, "Air Helmet");
            GameRegistry.registerItem(airChest, "airChest");
            LanguageRegistry.addName(airChest, "Air Chestplate");
            GameRegistry.registerItem(airLegs, "airLegs");
            LanguageRegistry.addName(airLegs, "Air Leggings");
            GameRegistry.registerItem(airBoots, "airBoots");
            LanguageRegistry.addName(airBoots, "Air Boots");
        }
        
        public void EarthArmour()
        {
        	 GameRegistry.registerItem(earthHelmet, "earthHelmet");
             LanguageRegistry.addName(earthHelmet, "Earth Helmet");
             GameRegistry.registerItem(earthChest, "earthChest");
             LanguageRegistry.addName(earthChest, "Earth Chestplate");
             GameRegistry.registerItem(earthLegs, "earthLegs");
             LanguageRegistry.addName(earthLegs, "Earth Leggings");
             GameRegistry.registerItem(earthBoots, "earthBoots");
             LanguageRegistry.addName(earthBoots, "Earth Boots");
        }
        
        public void EnergyArmour()
        {
        	GameRegistry.registerItem(energyHelmet, "energyHelmet");
            LanguageRegistry.addName(energyHelmet, "Energy Helmet");
            GameRegistry.registerItem(energyChest, "energyChest");
            LanguageRegistry.addName(energyChest, "Energy Chestplate");
            GameRegistry.registerItem(energyLegs, "energyLegs");
            LanguageRegistry.addName(energyLegs, "Energy Leggings");
            GameRegistry.registerItem(energyBoots, "energyBoots");
            LanguageRegistry.addName(energyBoots, "Energy Boots");
        }
        
        public void FireArmour()
        {
        	 GameRegistry.registerItem(fireHelmet, "fireHelmet");
             LanguageRegistry.addName(fireHelmet, "Fire Helmet");
             GameRegistry.registerItem(fireChest, "fireChest");
             LanguageRegistry.addName(fireChest, "Fire Chestplate");
             GameRegistry.registerItem(fireLegs, "fireLegs");
             LanguageRegistry.addName(fireLegs, "Fire Leggings");
             GameRegistry.registerItem(fireBoots, "fireBoots");
             LanguageRegistry.addName(fireBoots, "Fire Boots");
        }
        
        public void IceArmour()
        {
        	GameRegistry.registerItem(iceHelmet, "iceHelmet");
            LanguageRegistry.addName(iceHelmet, "Ice Helmet");
            GameRegistry.registerItem(iceChest, "iceChest");
            LanguageRegistry.addName(iceChest, "Ice Chestplate");
            GameRegistry.registerItem(iceLegs, "iceLegs");
            LanguageRegistry.addName(iceLegs, "Ice Leggings");
            GameRegistry.registerItem(iceBoots, "iceBoots");
            LanguageRegistry.addName(iceBoots, "Ice Boots");
        }
        
        public void LightningArmour()
        {
        	GameRegistry.registerItem(lightningHelmet, "lightningHelmet");
            LanguageRegistry.addName(lightningHelmet, "Lightning Helmet");
            GameRegistry.registerItem(lightningChest, "lightningChest");
            LanguageRegistry.addName(lightningChest, "Lightning Chestplate");
            GameRegistry.registerItem(lightningLegs, "lightningLegs");
            LanguageRegistry.addName(lightningLegs, "Lightning Leggings");
            GameRegistry.registerItem(lightningBoots, "lightningBoots");
            LanguageRegistry.addName(lightningBoots, "Lightning Boots");
        }
        
        public void MagmaArmour()
        {
        	GameRegistry.registerItem(magmaHelmet, "magmaHelmet");
            LanguageRegistry.addName(magmaHelmet, "Magma Helmet");
            GameRegistry.registerItem(magmaChest, "magmaChest");
            LanguageRegistry.addName(magmaChest, "Magma Chestplate");
            GameRegistry.registerItem(magmaLegs, "magmaLegs");
            LanguageRegistry.addName(magmaLegs, "Magma Leggings");
            GameRegistry.registerItem(magmaBoots, "magmaBoots");
            LanguageRegistry.addName(magmaBoots, "Magma Boots");
        }
        
        public void MetalArmour()
        {
        	GameRegistry.registerItem(metalHelmet, "metalHelmet");
            LanguageRegistry.addName(metalHelmet, "Metal Helmet");
            GameRegistry.registerItem(metalChest, "metalChest");
            LanguageRegistry.addName(metalChest, "Metal Chestplate");
            GameRegistry.registerItem(metalLegs, "metalLegs");
            LanguageRegistry.addName(metalLegs, "Metal Leggings");
            GameRegistry.registerItem(metalBoots, "metalBoots");
            LanguageRegistry.addName(metalBoots, "Metal Boots");
        }
        
        public void WaterArmour()
        {
        	GameRegistry.registerItem(waterHelmet, "waterHelmet");
            LanguageRegistry.addName(waterHelmet, "Water Helmet");
            GameRegistry.registerItem(waterChest, "waterChest");
            LanguageRegistry.addName(waterChest, "Water Chestplate");
            GameRegistry.registerItem(waterLegs, "waterLegs");
            LanguageRegistry.addName(waterLegs, "Water Leggings");
            GameRegistry.registerItem(waterBoots, "waterBoots");
            LanguageRegistry.addName(waterBoots, "Water Boots");
        }

        public void DimesionCrap()
        {
        	GameRegistry.registerBlock(fireRide, "fireRide");
        	LanguageRegistry.addName(fireRide, "Fire");
        	GameRegistry.registerBlock(portalRide, "portalRide");
        	LanguageRegistry.addName(portalRide, "Portal");
        	GameRegistry.registerItem(SteelAndFlint, "steelAndFlint");
        	LanguageRegistry.addName(SteelAndFlint, "Flints Of The Mighty Steel");
        }
        
        
        
        @EventHandler
        public void postInit(FMLPostInitializationEvent event) {
                // Stub Method
        }
        
        public static Item airShard = new ItemAirShard(3000).setMaxStackSize(5).setUnlocalizedName("airShard").setCreativeTab(CreativeTabs.tabMaterials).func_111206_d("riders:air_shard");
        public static Item earthShard = new ItemEarthShard(3001).setMaxStackSize(5).setUnlocalizedName("earthShard").setCreativeTab(CreativeTabs.tabMaterials).func_111206_d("riders:plant_shard");
        public static Item energyShard = new ItemEnergyShard(3002).setMaxStackSize(5).setUnlocalizedName("energyShard").setCreativeTab(CreativeTabs.tabMaterials).func_111206_d("riders:energy_shard");
        public static Item fireShard = new ItemFireShard(3003).setMaxStackSize(5).setUnlocalizedName("fireShard").setCreativeTab(CreativeTabs.tabMaterials).func_111206_d("riders:fire_shard");
        public static Item iceShard = new ItemIceShard(3004).setMaxStackSize(5).setUnlocalizedName("iceShard").setCreativeTab(CreativeTabs.tabMaterials).func_111206_d("riders:ice_shard");
        public static Item lightningShard = new ItemLightingShard(3005).setMaxStackSize(5).setUnlocalizedName("lightningShard").setCreativeTab(CreativeTabs.tabMaterials).func_111206_d("riders:lightning_shard");
        public static Item magmaShard = new ItemMagmaShard(3006).setMaxStackSize(5).setUnlocalizedName("magmaShard").setCreativeTab(CreativeTabs.tabMaterials).func_111206_d("riders:magma_shard");
        public static Item metalShard = new ItemMetalShard(3007).setMaxStackSize(5).setUnlocalizedName("metalShard").setCreativeTab(CreativeTabs.tabMaterials).func_111206_d("riders:metal_shard");
        public static Item waterShard = new ItemWaterShard(3008).setMaxStackSize(5).setUnlocalizedName("waterShard").setCreativeTab(CreativeTabs.tabMaterials).func_111206_d("riders:water_shard");
        
        public static Block airOre = new BlockWaterOre(3009).setUnlocalizedName("airOre").setCreativeTab(CreativeTabs.tabBlock).setHardness(3.0F).setResistance(5.0F).func_111022_d("riders:air_ore");
        public static Block earthOre = new BlockWaterOre(3010).setUnlocalizedName("earthOre").setCreativeTab(CreativeTabs.tabBlock).setHardness(3.0F).setResistance(5.0F).func_111022_d("riders:plant_ore");
        public static Block energyOre = new BlockWaterOre(3011).setUnlocalizedName("energyOre").setCreativeTab(CreativeTabs.tabBlock).setHardness(3.0F).setResistance(5.0F).func_111022_d("riders:energy_ore");
        public static Block fireOre = new BlockWaterOre(3012).setUnlocalizedName("fireOre").setCreativeTab(CreativeTabs.tabBlock).setHardness(3.0F).setResistance(5.0F).func_111022_d("riders:fire_ore");
        public static Block iceOre = new BlockWaterOre(3013).setUnlocalizedName("iceOre").setCreativeTab(CreativeTabs.tabBlock).setHardness(3.0F).setResistance(5.0F).func_111022_d("riders:ice_ore");
        public static Block lightningOre = new BlockWaterOre(3014).setUnlocalizedName("lightningOre").setCreativeTab(CreativeTabs.tabBlock).setHardness(3.0F).setResistance(5.0F).func_111022_d("riders:lightning_ore");
        public static Block magmaOre = new BlockWaterOre(3015).setUnlocalizedName("magmaOre").setCreativeTab(CreativeTabs.tabBlock).setHardness(3.0F).setResistance(5.0F).func_111022_d("riders:magma_ore");
        public static Block metalOre = new BlockWaterOre(3016).setUnlocalizedName("metalOre").setCreativeTab(CreativeTabs.tabBlock).setHardness(3.0F).setResistance(5.0F).func_111022_d("riders:metal_ore");
        public static Block waterOre = new BlockWaterOre(3017).setUnlocalizedName("waterOre").setCreativeTab(CreativeTabs.tabBlock).setHardness(3.0F).setResistance(5.0F).func_111022_d("riders:water_ore");
        
        public static Item airSword = new ItemSwordRiders(3018, RidersToolMat.Air).setUnlocalizedName("airSword").setCreativeTab(CreativeTabs.tabCombat).func_111206_d("riders:air_sword");
        public static Item earthSword = new ItemSwordRiders(3019, RidersToolMat.Earth).setUnlocalizedName("earthSword").setCreativeTab(CreativeTabs.tabCombat).func_111206_d("riders:plant_sword");
        public static Item energySword = new ItemSwordRiders(3020, RidersToolMat.Energy).setUnlocalizedName("energySword").setCreativeTab(CreativeTabs.tabCombat).func_111206_d("riders:energy_sword");
        public static Item fireSword = new ItemSwordRiders(3021, RidersToolMat.Fire).setUnlocalizedName("fireSword").setCreativeTab(CreativeTabs.tabCombat).func_111206_d("riders:fire_sword");
        public static Item iceSword = new ItemSwordRiders(3022, RidersToolMat.Ice).setUnlocalizedName("iceSword").setCreativeTab(CreativeTabs.tabCombat).func_111206_d("riders:ice_sword");
        public static Item lightningSword = new ItemSwordRiders(3023, RidersToolMat.Lightning).setUnlocalizedName("lightningSword").setCreativeTab(CreativeTabs.tabCombat).func_111206_d("riders:lightning_sword");
        public static Item magmaSword = new ItemSwordRiders(3024, RidersToolMat.Magma).setUnlocalizedName("magmaSword").setCreativeTab(CreativeTabs.tabCombat).func_111206_d("riders:magma_sword");
        public static Item metalSword = new ItemSwordRiders(3025, RidersToolMat.Metal).setUnlocalizedName("metalSword").setCreativeTab(CreativeTabs.tabCombat).func_111206_d("riders:metal_sword");
        public static Item waterSword = new ItemSwordRiders(3026, RidersToolMat.Water).setUnlocalizedName("waterSword").setCreativeTab(CreativeTabs.tabCombat).func_111206_d("riders:water_sword");
        
        public static Item airAxe = new ItemAxeRiders(3027, RidersToolMat.Air).setUnlocalizedName("airAxe").setCreativeTab(CreativeTabs.tabTools).func_111206_d("riders:air_axe");
        public static Item earthAxe = new ItemAxeRiders(3028, RidersToolMat.Earth).setUnlocalizedName("earthAxe").setCreativeTab(CreativeTabs.tabTools).func_111206_d("riders:plant_axe");
        public static Item energyAxe = new ItemAxeRiders(3029, RidersToolMat.Energy).setUnlocalizedName("energyAxe").setCreativeTab(CreativeTabs.tabTools).func_111206_d("riders:energy_axe");
        public static Item fireAxe = new ItemAxeRiders(3030, RidersToolMat.Fire).setUnlocalizedName("fireAxe").setCreativeTab(CreativeTabs.tabTools).func_111206_d("riders:fire_axe");
        public static Item iceAxe = new ItemAxeRiders(3031, RidersToolMat.Ice).setUnlocalizedName("iceAxe").setCreativeTab(CreativeTabs.tabTools).func_111206_d("riders:ice_axe");
        public static Item lightningAxe = new ItemAxeRiders(3032, RidersToolMat.Lightning).setUnlocalizedName("lightningAxe").setCreativeTab(CreativeTabs.tabTools).func_111206_d("riders:lightning_axe");
        public static Item magmaAxe = new ItemAxeRiders(3033, RidersToolMat.Magma).setUnlocalizedName("magmaAxe").setCreativeTab(CreativeTabs.tabTools).func_111206_d("riders:magma_axe");
        public static Item metalAxe = new ItemAxeRiders(3034, RidersToolMat.Metal).setUnlocalizedName("metalAxe").setCreativeTab(CreativeTabs.tabTools).func_111206_d("riders:metal_axe");
        public static Item waterAxe = new ItemAxeRiders(3035, RidersToolMat.Water).setUnlocalizedName("waterAxe").setCreativeTab(CreativeTabs.tabTools).func_111206_d("riders:water_axe");
        
        public static Item airPickaxe = new ItemPickaxeRiders(3036, RidersToolMat.Air).setUnlocalizedName("airPickaxe").setCreativeTab(CreativeTabs.tabTools).func_111206_d("riders:air_pickaxe");
        public static Item earthPickaxe = new ItemPickaxeRiders(3037, RidersToolMat.Earth).setUnlocalizedName("earthPickaxe").setCreativeTab(CreativeTabs.tabTools).func_111206_d("riders:plant_pickaxe");
        public static Item energyPickaxe = new ItemPickaxeRiders(3038, RidersToolMat.Energy).setUnlocalizedName("energyPickaxe").setCreativeTab(CreativeTabs.tabTools).func_111206_d("riders:energy_pickaxe");
        public static Item firePickaxe = new ItemPickaxeRiders(3039, RidersToolMat.Fire).setUnlocalizedName("firePickaxe").setCreativeTab(CreativeTabs.tabTools).func_111206_d("riders:fire_pickaxe");
        public static Item icePickaxe = new ItemPickaxeRiders(3040, RidersToolMat.Ice).setUnlocalizedName("icePickaxe").setCreativeTab(CreativeTabs.tabTools).func_111206_d("riders:ice_pickaxe");
        public static Item lightningPickaxe = new ItemPickaxeRiders(3041, RidersToolMat.Lightning).setUnlocalizedName("lightningPickaxe").setCreativeTab(CreativeTabs.tabTools).func_111206_d("riders:lightning_pickaxe");
        public static Item magmaPickaxe = new ItemPickaxeRiders(3042, RidersToolMat.Magma).setUnlocalizedName("magmaPickaxe").setCreativeTab(CreativeTabs.tabTools).func_111206_d("riders:magma_pickaxe");
        public static Item metalPickaxe = new ItemPickaxeRiders(3043, RidersToolMat.Metal).setUnlocalizedName("metalPickaxe").setCreativeTab(CreativeTabs.tabTools).func_111206_d("riders:metal_pickaxe");
        public static Item waterPickaxe = new ItemPickaxeRiders(3044, RidersToolMat.Water).setUnlocalizedName("waterPickaxe").setCreativeTab(CreativeTabs.tabTools).func_111206_d("riders:water_pickaxe");
        
        public static Item airHoe = new ItemHoeRiders(3045, RidersToolMat.Air).setUnlocalizedName("airHoe").setCreativeTab(CreativeTabs.tabTools).func_111206_d("riders:air_hoe");
        public static Item earthHoe = new ItemHoeRiders(3046, RidersToolMat.Earth).setUnlocalizedName("earthHoe").setCreativeTab(CreativeTabs.tabTools).func_111206_d("riders:plant_hoe");
        public static Item energyHoe = new ItemHoeRiders(3047, RidersToolMat.Energy).setUnlocalizedName("energyHoe").setCreativeTab(CreativeTabs.tabTools).func_111206_d("riders:energy_hoe");
        public static Item fireHoe = new ItemHoeRiders(3048, RidersToolMat.Fire).setUnlocalizedName("fireHoe").setCreativeTab(CreativeTabs.tabTools).func_111206_d("riders:fire_hoe");
        public static Item iceHoe = new ItemHoeRiders(3049, RidersToolMat.Ice).setUnlocalizedName("iceHoe").setCreativeTab(CreativeTabs.tabTools).func_111206_d("riders:ice_hoe");
        public static Item lightningHoe = new ItemHoeRiders(3050, RidersToolMat.Lightning).setUnlocalizedName("lightningHoe").setCreativeTab(CreativeTabs.tabTools).func_111206_d("riders:lightning_hoe");
        public static Item magmaHoe = new ItemHoeRiders(3051, RidersToolMat.Magma).setUnlocalizedName("magmaHoe").setCreativeTab(CreativeTabs.tabTools).func_111206_d("riders:magma_hoe");
        public static Item metalHoe = new ItemHoeRiders(3052, RidersToolMat.Metal).setUnlocalizedName("metalHoe").setCreativeTab(CreativeTabs.tabTools).func_111206_d("riders:metal_hoe");
        public static Item waterHoe = new ItemHoeRiders(3053, RidersToolMat.Water).setUnlocalizedName("waterHoe").setCreativeTab(CreativeTabs.tabTools).func_111206_d("riders:water_hoe");
        
        public static Item airShovel = new ItemShovelRiders(3054, RidersToolMat.Air).setUnlocalizedName("airShovel").setCreativeTab(CreativeTabs.tabTools).func_111206_d("riders:air_shovel");
        public static Item earthShovel = new ItemShovelRiders(3055, RidersToolMat.Earth).setUnlocalizedName("earthShovel").setCreativeTab(CreativeTabs.tabTools).func_111206_d("riders:plant_shovel");
        public static Item energyShovel = new ItemShovelRiders(3056, RidersToolMat.Energy).setUnlocalizedName("energyShovel").setCreativeTab(CreativeTabs.tabTools).func_111206_d("riders:energy_shovel");
        public static Item fireShovel = new ItemShovelRiders(3057, RidersToolMat.Fire).setUnlocalizedName("fireShovel").setCreativeTab(CreativeTabs.tabTools).func_111206_d("riders:fire_shovel");
        public static Item iceShovel = new ItemShovelRiders(3058, RidersToolMat.Ice).setUnlocalizedName("iceShovel").setCreativeTab(CreativeTabs.tabTools).func_111206_d("riders:ice_shovel");
        public static Item lightningShovel = new ItemShovelRiders(3059, RidersToolMat.Lightning).setUnlocalizedName("lightningShovel").setCreativeTab(CreativeTabs.tabTools).func_111206_d("riders:lightning_shovel");
        public static Item magmaShovel = new ItemShovelRiders(3060, RidersToolMat.Magma).setUnlocalizedName("magmaShovel").setCreativeTab(CreativeTabs.tabTools).func_111206_d("riders:magma_shovel");
        public static Item metalShovel = new ItemShovelRiders(3061, RidersToolMat.Metal).setUnlocalizedName("metalShovel").setCreativeTab(CreativeTabs.tabTools).func_111206_d("riders:metal_shovel");
        public static Item waterShovel = new ItemShovelRiders(3062, RidersToolMat.Water).setUnlocalizedName("waterShovel").setCreativeTab(CreativeTabs.tabTools).func_111206_d("riders:water_shovel");
        
        public static Item SteelAndFlint = new ItemSteelAndFlint(3205).setUnlocalizedName("steelAndFlint").func_111206_d("riders:steelaflint");
        public static Item portalPlacer = new ItemPortalPlacer(3206).setUnlocalizedName("portalPlacer");
        
        public static Block fireStone = new BlockFireStone(164, Material.rock).setStepSound(Block.soundStoneFootstep).setHardness(4.0F).setUnlocalizedName("fireStone").func_111022_d("riders:firestone").setLightValue(0.7F);
        public static Block fireCobble = new BlockFireCobble(165, Material.rock).setStepSound(Block.soundStoneFootstep).setHardness(4.5F).setUnlocalizedName("fireCobble").func_111022_d("riders:firecobble").setLightValue(0.4F);
        public static Block fireDirt = new BlockFireDirt(166, Material.ground).setStepSound(Block.soundGrassFootstep).setHardness(2.0F).setUnlocalizedName("fireDirt").func_111022_d("riders:firedirt").setLightValue(0.2F).setResistance(1.0F);
        
        public static Block iceStone = new BlockIceStone(163, Material.rock).setStepSound(Block.soundStoneFootstep).setHardness(4.0F).setUnlocalizedName("fireStone").func_111022_d("riders:firestone").setLightValue(0.7F);
        public static Block iceCobble = new BlockIceCobble(162, Material.rock).setStepSound(Block.soundStoneFootstep).setHardness(4.5F).setUnlocalizedName("fireCobble").func_111022_d("riders:firecobble").setLightValue(0.4F);
        public static Block iceDirt = new BlockIceDirt(161, Material.ground).setStepSound(Block.soundGrassFootstep).setHardness(2.0F).setUnlocalizedName("fireDirt").func_111022_d("riders:firedirt").setLightValue(0.2F).setResistance(1.0F);
        
        public static Block fireRide = new BlockFireRide(3203).setUnlocalizedName("fireRide").func_111022_d("riders:fire");
        public static Block portalRide = new BlockPortalRide(3204).setUnlocalizedName("portalRide").func_111022_d("riders:portal");
        public static Block fireGrass = new BlockFireGrass(168).setResistance(1F).setUnlocalizedName("fireGrass").func_111022_d("riders:grass").setCreativeTab(CreativeTabs.tabBlock);
        
        

        
        public static final BiomeGenBase[] biomeList = new BiomeGenBase[256];
    	public static final BiomeGenBase TutorialBiome = new BiomeGenFireRiders(25);
    	public static final BiomeGenBase IceBiome = new BiomeGenIceRiders(26);
        
        
}