package org.altiusgames.lithium.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemRandomChanceCondition;
import net.minecraftforge.common.data.GlobalLootModifierProvider;
import net.minecraftforge.common.loot.LootTableIdCondition;
import org.altiusgames.lithium.Lithium;
import org.altiusgames.lithium.item.ModItems;
import org.altiusgames.lithium.loot.AddItemModifier;
import org.altiusgames.lithium.loot.AddSuspiciousSandItemModifier;

public class ModGlobalLootModifiersProvider extends GlobalLootModifierProvider {
    public ModGlobalLootModifiersProvider(PackOutput output) {
        super(output, Lithium.MOD_ID);
    }

    @Override
    protected void start() {
        add("lithium_from_nether_fortress_chest", new AddItemModifier(new LootItemCondition[]{
                LootTableIdCondition.builder(new ResourceLocation("chests/nether_bridge")).build(),
                LootItemRandomChanceCondition.randomChance(0.5f).build()
        }, ModItems.LITHIUM_INGOT.get()));
        add("lithium_from_ruined_portal_chest", new AddItemModifier(new LootItemCondition[]{
                LootTableIdCondition.builder(new ResourceLocation("chests/ruined_portal")).build(),
                LootItemRandomChanceCondition.randomChance(0.45f).build()
        }, ModItems.LITHIUM_INGOT.get()));
        add("lithium_from_piglin_bartering", new AddItemModifier(new LootItemCondition[]{
                LootTableIdCondition.builder(new ResourceLocation("gameplay/piglin_bartering")).build(),
                LootItemRandomChanceCondition.randomChance(0.25f).build()
        }, ModItems.LITHIUM_INGOT.get()));

        add("lithium_power_orb_from_desert_pyramid_sus_sand", new AddSuspiciousSandItemModifier(new LootItemCondition[]{
                LootTableIdCondition.builder(new ResourceLocation("archaeology/desert_pyramid")).build()
        }, ModItems.LITHIUM_POWER_ORB.get()));
        add("lithium_power_orb_from_desert_well_sus_sand", new AddSuspiciousSandItemModifier(new LootItemCondition[]{
                LootTableIdCondition.builder(new ResourceLocation("archaeology/desert_well")).build()
        }, ModItems.LITHIUM_POWER_ORB.get()));
        add("lithium_power_orb_from_trail_ruins_rare_sus_sand", new AddSuspiciousSandItemModifier(new LootItemCondition[]{
                LootTableIdCondition.builder(new ResourceLocation("archaeology/trail_ruins_rare")).build()
        }, ModItems.LITHIUM_POWER_ORB.get()));

        add("disc_84_from_nether_fortress_chest", new AddItemModifier(new LootItemCondition[]{
                LootTableIdCondition.builder(new ResourceLocation("chests/nether_bridge")).build(),
                LootItemRandomChanceCondition.randomChance(0.25f).build()
        }, ModItems.DISC_84.get()));
        add("disc_84_from_ruined_portal_chest", new AddItemModifier(new LootItemCondition[]{
                LootTableIdCondition.builder(new ResourceLocation("chests/ruined_portal")).build(),
                LootItemRandomChanceCondition.randomChance(0.15f).build()
        }, ModItems.DISC_84.get()));
    }
}
