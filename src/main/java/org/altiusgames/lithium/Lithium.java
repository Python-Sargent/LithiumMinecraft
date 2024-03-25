package org.altiusgames.lithium;

import com.mojang.logging.LogUtils;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.FlowerPotBlock;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.altiusgames.lithium.block.ModBlocks;
import org.altiusgames.lithium.item.ModItems;
import org.altiusgames.lithium.loot.ModLootModifiers;
import org.altiusgames.lithium.sound.ModSounds;
import org.altiusgames.lithium.villager.ModVillagers;
import org.slf4j.Logger;

@Mod(Lithium.MOD_ID)
public class Lithium
{
    public static final String MOD_ID = "lithium";
    private static final Logger LOGGER = LogUtils.getLogger();

    public Lithium()
    {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);

        ModLootModifiers.register(modEventBus);
        ModVillagers.register(modEventBus);

        ModSounds.register(modEventBus);

        modEventBus.addListener(this::commonSetup);

        MinecraftForge.EVENT_BUS.register(this);
        modEventBus.addListener(this::addCreative);
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }

    private void commonSetup(final FMLCommonSetupEvent event)
    {
        event.enqueueWork(() -> {
            ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(ModBlocks.LITHMUS.getId(), ModBlocks.POTTED_LITHMUS);
        });
    }

    private void addCreative(BuildCreativeModeTabContentsEvent event)
    {
        if(event.getTabKey() == CreativeModeTabs.INGREDIENTS) {
            event.accept(ModItems.LITHIUM);
            event.accept(ModItems.LITHIUM_INGOT);
            event.accept(ModItems.LITHORIUM_SEEDS);
            event.accept(ModItems.IONIZED_LITHIUM);
        }

        if(event.getTabKey() == CreativeModeTabs.FOOD_AND_DRINKS) {
            event.accept(ModItems.LITHORIUM);
            event.accept(ModItems.GILDED_LITHORIUM);
        }

        if(event.getTabKey() == CreativeModeTabs.COMBAT) {
            event.accept(ModItems.LITHIUM_SWORD);
            event.accept(ModItems.LITHIUM_HELMET);
            event.accept(ModItems.LITHIUM_CHESTPLATE);
            event.accept(ModItems.LITHIUM_LEGGINGS);
            event.accept(ModItems.LITHIUM_BOOTS);
            event.accept(ModItems.LITHIUM_POWER_ORB);
        }

        if(event.getTabKey() == CreativeModeTabs.BUILDING_BLOCKS) {
            event.accept(ModBlocks.LITHIUM_BLOCK);
            event.accept(ModBlocks.LITHIUM_STAIRS);
            event.accept(ModBlocks.LITHIUM_SLAB);
            event.accept(ModBlocks.LITHIUM_WALL);
            event.accept(ModBlocks.LITHIUM_FENCE);
            event.accept(ModBlocks.LITHIUM_FENCE_GATE);
        }

        if(event.getTabKey() == CreativeModeTabs.NATURAL_BLOCKS) {
            event.accept(ModBlocks.RAW_LITHIUM_BLOCK);
            event.accept(ModBlocks.LITHIUM_ORE);
            event.accept(ModBlocks.DEEPSLATE_LITHIUM_ORE);
            event.accept(ModBlocks.LITHMUS);
        }

        if(event.getTabKey() == CreativeModeTabs.FUNCTIONAL_BLOCKS) {
            event.accept(ModBlocks.LITHIUM_RADIATOR);
        }

        if(event.getTabKey() == CreativeModeTabs.REDSTONE_BLOCKS) {
            event.accept(ModBlocks.LITHIUM_BUTTON);
            event.accept(ModBlocks.LITHIUM_PRESSURE_PLATE);
            event.accept(ModBlocks.LITHIUM_DOOR);
            event.accept(ModBlocks.LITHIUM_TRAPDOOR);
        }

        if(event.getTabKey() == CreativeModeTabs.TOOLS_AND_UTILITIES) {
            event.accept(ModItems.LITHIUM_PICKAXE);
            event.accept(ModItems.LITHIUM_AXE);
            event.accept(ModItems.LITHIUM_SHOVEL);
            event.accept(ModItems.LITHIUM_HOE);
            event.accept(ModItems.DISC_84);
        }
    }

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event)
    {

    }

    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents
    {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event)
        {

        }
    }
}
