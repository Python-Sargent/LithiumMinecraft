package org.altiusgames.lithium.item;

import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemNameBlockItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.altiusgames.lithium.Lithium;
import org.altiusgames.lithium.block.ModBlocks;
import org.altiusgames.lithium.item.custom.FuelItem;
import org.altiusgames.lithium.item.custom.LithiumPowerOrbItem;
import org.altiusgames.lithium.item.custom.ModFoods;

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

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
