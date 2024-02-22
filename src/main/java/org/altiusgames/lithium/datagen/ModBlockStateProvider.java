package org.altiusgames.lithium.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;
import org.altiusgames.lithium.Lithium;
import org.altiusgames.lithium.block.ModBlocks;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, Lithium.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        blockWithItem(ModBlocks.LITHIUM_BLOCK);
        blockWithItem(ModBlocks.RAW_LITHIUM_BLOCK);
        blockWithItem(ModBlocks.DEEPSLATE_LITHIUM_ORE);
        blockWithItem(ModBlocks.LITHIUM_ORE);
        blockWithItem(ModBlocks.LITHIUM_RADIATOR);
    }

    private void blockWithItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }
}
