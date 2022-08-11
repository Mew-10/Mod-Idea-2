package net.benjamin.ideag.recipe;

import net.benjamin.ideag.IdeagMod;
import net.minecraft.core.Registry;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModRecipes {
    public static final DeferredRegister<RecipeSerializer<?>> SERIALIZERS =
            DeferredRegister.create(ForgeRegistries.RECIPE_SERIALIZERS, IdeagMod.MOD_ID);

    public static final RegistryObject<RecipeSerializer<HephaestusForgeRecipe>> HEPHAESTUS_FORGE_SERIALIZER =
            SERIALIZERS.register("hephaestus_forgeing", () -> HephaestusForgeRecipe.Serializer.INSTANCE);

    public static void register(IEventBus eventBus) {
        SERIALIZERS.register(eventBus);
        Registry.register(Registry.RECIPE_TYPE, HephaestusForgeRecipe.Type.ID, HephaestusForgeRecipe.Type.INSTANCE);
    }
}
