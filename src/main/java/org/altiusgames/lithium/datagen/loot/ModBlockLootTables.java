package org.altiusgames.lithium.datagen.loot;

import net.minecraft.advancements.critereon.StatePropertiesPredicate;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.providers.number.NumberProviders;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.minecraftforge.registries.RegistryObject;
import org.altiusgames.lithium.block.ModBlocks;
import org.altiusgames.lithium.block.custom.LithoriumCropBlock;
import org.altiusgames.lithium.item.ModItems;
import org.jetbrains.annotations.NotNull;

import java.util.Set;

public class ModBlockLootTables extends BlockLootSubProvider {
    public ModBlockLootTables() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {
        this.dropSelf(ModBlocks.LITHIUM_BLOCK.get());
        this.dropSelf(ModBlocks.RAW_LITHIUM_BLOCK.get());
        this.dropSelf(ModBlocks.LITHIUM_RADIATOR.get());

        this.add(ModBlocks.DEEPSLATE_LITHIUM_ORE.get(),
                block -> createOreDrops(ModBlocks.DEEPSLATE_LITHIUM_ORE.get(), ModItems.LITHIUM.get()));
        this.add(ModBlocks.LITHIUM_ORE.get(),
                block -> createOreDrops(ModBlocks.LITHIUM_ORE.get(), ModItems.LITHIUM.get()));

        this.dropSelf(ModBlocks.LITHIUM_STAIRS.get());
        this.dropSelf(ModBlocks.LITHIUM_BUTTON.get());
        this.dropSelf(ModBlocks.LITHIUM_PRESSURE_PLATE.get());
        this.dropSelf(ModBlocks.LITHIUM_TRAPDOOR.get());
        this.dropSelf(ModBlocks.LITHIUM_FENCE.get());
        this.dropSelf(ModBlocks.LITHIUM_FENCE_GATE.get());
        this.dropSelf(ModBlocks.LITHIUM_WALL.get());

        this.add(ModBlocks.LITHIUM_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.LITHIUM_SLAB.get()));
        this.add(ModBlocks.LITHIUM_DOOR.get(),
                block -> createDoorTable(ModBlocks.LITHIUM_DOOR.get()));

        LootItemCondition.Builder lootitemcondition$builder = LootItemBlockStatePropertyCondition
                .hasBlockStateProperties(ModBlocks.LITHORIUM_PLANT.get())
                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(LithoriumCropBlock.AGE, 5));

        this.add(ModBlocks.LITHORIUM_PLANT.get(), createCropDrops(ModBlocks.LITHORIUM_PLANT.get(), ModItems.LITHORIUM.get(),
                ModItems.LITHORIUM_SEEDS.get(), lootitemcondition$builder));

        this.dropSelf(ModBlocks.LITHMUS.get());
        this.add(ModBlocks.POTTED_LITHMUS.get(), createPotFlowerItemTable(ModBlocks.LITHMUS.get()));
    }

    private LootTable.Builder createOreDrops(Block block, Item item) {
        return createSilkTouchDispatchTable(block,
                this.applyExplosionDecay(block,
                        LootItem.lootTableItem(item)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 1)))
                                .apply(ApplyBonusCount.addOreBonusCount((Enchantments.BLOCK_FORTUNE)))));
    }

    @Override
    protected @NotNull Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
