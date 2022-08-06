package net.benjamin.ideag.potion;

import net.benjamin.ideag.IdeagMod;
import net.benjamin.ideag.config.IdeagCommonConfigs;
import net.benjamin.ideag.effect.ModEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModPotions {
    public static final DeferredRegister<Potion> POTIONS
            = DeferredRegister.create(ForgeRegistries.POTIONS, IdeagMod.MOD_ID);

    public static RegistryObject<Potion> ELECTROCUTE_POTION = POTIONS.register("electrocute_potion",
            () -> new Potion(new MobEffectInstance(ModEffects.ELECTROCUTE.get(), IdeagCommonConfigs.ELECTROCUTE_TIME.get(), 1)));

    public static void register(IEventBus eventBus) {
        POTIONS.register(eventBus);
    }
}