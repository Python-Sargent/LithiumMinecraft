package org.altiusgames.lithium.item;

import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.*;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.altiusgames.lithium.Lithium;
import org.altiusgames.lithium.block.ModBlocks;
import org.altiusgames.lithium.item.custom.*;
import org.altiusgames.lithium.sound.ModSounds;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, Lithium.MOD_ID);

    public static final RegistryObject<Item> LITHIUM = ITEMS.register("lithium",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> LITHIUM_INGOT = ITEMS.register("lithium_ingot",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> LITHIUM_POWER_ORB = ITEMS.register("lithium_power_orb",
            () -> new LithiumPowerOrbItem(new Item.Properties().durability(50)));

    public static final RegistryObject<Item> LITHORIUM_SEEDS = ITEMS.register("lithorium_seeds",
            () -> new ItemNameBlockItem(ModBlocks.LITHORIUM_PLANT.get(),
                    new Item.Properties()));

    public static final RegistryObject<Item> LITHORIUM = ITEMS.register("lithorium",
            () -> new Item(new Item.Properties().food(new FoodProperties.Builder().nutrition(6).saturationMod(4f).build())));

    public static final RegistryObject<Item> GILDED_LITHORIUM = ITEMS.register("gilded_lithorium",
            () -> new Item(new Item.Properties().food(ModFoods.GILDED_LITHORIUM)));

    public static final RegistryObject<Item> IONIZED_LITHIUM = ITEMS.register("ionized_lithium",
            () -> new FuelItem(new Item.Properties().fireResistant(), 1800));

    public static final RegistryObject<Item> LITHIUM_SWORD = ITEMS.register("lithium_sword",
            () -> new SwordItem(ModToolTiers.LITHIUM, 4, 2,
                    new Item.Properties()));
    public static final RegistryObject<Item> LITHIUM_PICKAXE = ITEMS.register("lithium_pickaxe",
            () -> new PickaxeItem(ModToolTiers.LITHIUM, 3, 0,
                    new Item.Properties()));
    public static final RegistryObject<Item> LITHIUM_AXE = ITEMS.register("lithium_axe",
            () -> new AxeItem(ModToolTiers.LITHIUM, 5, 1,
                    new Item.Properties()));
    public static final RegistryObject<Item> LITHIUM_SHOVEL = ITEMS.register("lithium_shovel",
            () -> new ShovelItem(ModToolTiers.LITHIUM, 2, 1,
                    new Item.Properties()));
    public static final RegistryObject<Item> LITHIUM_HOE = ITEMS.register("lithium_hoe",
            () -> new HoeItem(ModToolTiers.LITHIUM, 2, 1,
                    new Item.Properties()));


    public static final RegistryObject<Item> LITHIUM_HELMET = ITEMS.register("lithium_helmet",
            () -> new ModArmorItem(ModArmorMaterials.LITHIUM, ArmorItem.Type.HELMET, new Item.Properties()));
    public static final RegistryObject<Item> LITHIUM_CHESTPLATE = ITEMS.register("lithium_chestplate",
            () -> new ModArmorItem(ModArmorMaterials.LITHIUM, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final RegistryObject<Item> LITHIUM_LEGGINGS = ITEMS.register("lithium_leggings",
            () -> new ModArmorItem(ModArmorMaterials.LITHIUM, ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final RegistryObject<Item> LITHIUM_BOOTS = ITEMS.register("lithium_boots",
            () -> new ModArmorItem(ModArmorMaterials.LITHIUM, ArmorItem.Type.BOOTS, new Item.Properties()));

    public static final  RegistryObject<Item> DISC_84 = ITEMS.register("disc_84",
            () -> new RecordItem(6, ModSounds.DISC_84, new Item.Properties().stacksTo(1), 18920));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
