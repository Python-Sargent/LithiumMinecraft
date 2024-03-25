package org.altiusgames.lithium.sound;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.altiusgames.lithium.Lithium;

public class ModSounds {
    public static final DeferredRegister<SoundEvent> SOUND_EVENTS =
            DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, Lithium.MOD_ID);

    public static final RegistryObject<SoundEvent> LITHIUM_POWER_ORB_USE =
            registerSoundEvents("lithium_power_orb_use");

    public static final RegistryObject<SoundEvent> LITHIUM_RADIATOR_DIFFUSE =
            registerSoundEvents("lithium_radiator_diffuse");

    public static final RegistryObject<SoundEvent> DISC_84 = registerSoundEvents("disc_84");

    /**public static final RegistryObject<SoundEvent> LITHIUM_RADIATOR_BREAK =
            registerSoundEvents("lithium_radiator_break");
    public static final RegistryObject<SoundEvent> LITHIUM_RADIATOR_STEP =
            registerSoundEvents("lithium_radiator_step");
    public static final RegistryObject<SoundEvent> LITHIUM_RADIATOR_FALL =
            registerSoundEvents("lithium_radiator_fall");
    public static final RegistryObject<SoundEvent> LITHIUM_RADIATOR_PLACE =
            registerSoundEvents("lithium_radiator_place");
    public static final RegistryObject<SoundEvent> LITHIUM_RADIATOR_HIT =
            registerSoundEvents("lithium_radiator_hit");

    public static final ForgeSoundType LITHIUM_RADIATOR_SOUNDS = new ForgeSoundType(1f, 1f,
            ModSounds.LITHIUM_RADIATOR_BREAK, ModSounds.LITHIUM_RADIATOR_STEP, ModSounds.LITHIUM_RADIATOR_PLACE,
            ModSounds.LITHIUM_RADIATOR_HIT, ModSounds.LITHIUM_RADIATOR_FALL);**/

    private static RegistryObject<SoundEvent> registerSoundEvents(String name) {
        return SOUND_EVENTS.register(name, () -> SoundEvent.createVariableRangeEvent(
                new ResourceLocation(Lithium.MOD_ID, name)));
    }

    public static void register(IEventBus eventBus) {
        SOUND_EVENTS.register(eventBus);
    }
}
