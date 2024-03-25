package org.altiusgames.lithium.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ConfiguredModel;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;
import org.altiusgames.lithium.Lithium;
import org.altiusgames.lithium.block.ModBlocks;
import org.altiusgames.lithium.block.custom.LithoriumCropBlock;

import java.util.function.Function;

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

        stairsBlock(((StairBlock) ModBlocks.LITHIUM_STAIRS.get()), blockTexture(ModBlocks.LITHIUM_BLOCK.get()));
        slabBlock(((SlabBlock) ModBlocks.LITHIUM_SLAB.get()), blockTexture(ModBlocks.LITHIUM_BLOCK.get()), blockTexture(ModBlocks.LITHIUM_BLOCK.get()));

        buttonBlock(((ButtonBlock) ModBlocks.LITHIUM_BUTTON.get()), blockTexture(ModBlocks.LITHIUM_BLOCK.get()));
        pressurePlateBlock(((PressurePlateBlock) ModBlocks.LITHIUM_PRESSURE_PLATE.get()), blockTexture(ModBlocks.LITHIUM_BLOCK.get()));

        fenceBlock(((FenceBlock) ModBlocks.LITHIUM_FENCE.get()), blockTexture(ModBlocks.LITHIUM_BLOCK.get()));
        fenceGateBlock(((FenceGateBlock) ModBlocks.LITHIUM_FENCE_GATE.get()), blockTexture(ModBlocks.LITHIUM_BLOCK.get()));
        wallBlock(((WallBlock) ModBlocks.LITHIUM_WALL.get()), blockTexture(ModBlocks.LITHIUM_BLOCK.get()));

        doorBlockWithRenderType(((DoorBlock) ModBlocks.LITHIUM_DOOR.get()), modLoc("block/lithium_door_bottom"), modLoc("block/lithium_door_top"), "cutout");
        trapdoorBlockWithRenderType(((TrapDoorBlock) ModBlocks.LITHIUM_TRAPDOOR.get()), modLoc("block/lithium_trapdoor"), true, "cutout");

        makeCrop((CropBlock) ModBlocks.LITHORIUM_PLANT.get(), "lithorium_", "lithorium_");

        simpleBlockWithItem(ModBlocks.LITHMUS.get(), models().cross(blockTexture(ModBlocks.LITHMUS.get()).getPath(),
                blockTexture(ModBlocks.LITHMUS.get())).renderType("cutout"));
        simpleBlockWithItem(ModBlocks.POTTED_LITHMUS.get(), models().singleTexture("potted_lithmus", new ResourceLocation("flower_pot_cross"), "plant",
                blockTexture(ModBlocks.LITHMUS.get())).renderType("cutout"));
    }

    public void makeCrop(CropBlock block, String modelName, String textureName) {
        Function<BlockState, ConfiguredModel[]> function = state -> lithoriumStates(state, block, modelName, textureName);

        getVariantBuilder(block).forAllStates(function);
    }

    private ConfiguredModel[] lithoriumStates(BlockState state, CropBlock block, String modelName, String textureName) {
        ConfiguredModel[] models = new ConfiguredModel[1];
        models[0] = new ConfiguredModel(models().crop(modelName + state.getValue(((LithoriumCropBlock) block).getAgeProperty()),
                new ResourceLocation(Lithium.MOD_ID, "block/" + textureName + state.getValue(((LithoriumCropBlock) block).getAgeProperty()))).renderType("cutout"));

        return models;
    }

    private void blockWithItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }
}
