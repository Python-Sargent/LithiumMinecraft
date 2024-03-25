package org.altiusgames.lithium.item;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;
import net.minecraftforge.common.TierSortingRegistry;
import org.altiusgames.lithium.Lithium;
import org.altiusgames.lithium.util.ModTags;

import java.util.List;

public class ModToolTiers {
    public static final Tier LITHIUM = TierSortingRegistry.registerTier(
            new ForgeTier(3, 1500, 13f, 5f, 25,
                    ModTags.Blocks.NEEDS_LITHIUM_TOOL, () -> Ingredient.of(ModItems.LITHIUM_INGOT.get())),
            new ResourceLocation(Lithium.MOD_ID, "lithium"), List.of(Tiers.DIAMOND), List.of(Tiers.NETHERITE));
}
