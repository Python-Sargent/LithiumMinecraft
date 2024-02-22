package org.altiusgames.lithium.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;
import org.altiusgames.lithium.Lithium;
import org.altiusgames.lithium.item.ModItems;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, Lithium.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        simpleItem(ModItems.LITHIUM);
        simpleItem(ModItems.LITHIUM_INGOT);
        simpleItem(ModItems.LITHIUM_POWER_ORB);
        simpleItem(ModItems.GILDED_LITHORIUM);
        simpleItem(ModItems.LITHORIUM);
        simpleItem(ModItems.LITHORIUM_SEEDS);
        simpleItem(ModItems.IONIZED_LITHIUM);
    }

    private ItemModelBuilder simpleItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(Lithium.MOD_ID, "item/" + item.getId().getPath()));
    }
}
