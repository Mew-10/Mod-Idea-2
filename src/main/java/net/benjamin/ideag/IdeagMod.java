package net.benjamin.ideag;

import com.mojang.logging.LogUtils;
import net.benjamin.ideag.block.ModBlocks;
import net.benjamin.ideag.block.entity.ModBlockEntities;
import net.benjamin.ideag.config.IdeagCommonConfigs;
import net.benjamin.ideag.effect.ModEffects;
import net.benjamin.ideag.enchantment.ModEnchantments;
import net.benjamin.ideag.fluid.ModFluids;
import net.benjamin.ideag.item.ModItems;
import net.benjamin.ideag.potion.BetterBrewingRecipe;
import net.benjamin.ideag.potion.ModPotions;
import net.benjamin.ideag.recipe.ModRecipes;
import net.benjamin.ideag.screen.HephaestusForgeScreen;
import net.benjamin.ideag.screen.ModMenuTypes;
import net.benjamin.ideag.util.ModItemProperties;
import net.benjamin.ideag.villager.ModVillagers;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.brewing.BrewingRecipeRegistry;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(IdeagMod.MOD_ID)
public class IdeagMod
{
    // Directly reference a slf4j logger
    private static final Logger LOGGER = LogUtils.getLogger();
    public static final String MOD_ID = "ideag";

    public IdeagMod()
    {
        // Register the setup method for modloading
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModItems.register(eventBus);
        ModBlocks.register(eventBus);
        ModPotions.register(eventBus);
        ModEffects.register(eventBus);
        ModVillagers.register(eventBus);
        ModFluids.register(eventBus);
        ModBlockEntities.register(eventBus);
        ModEnchantments.register(eventBus);
        ModMenuTypes.register(eventBus);
        ModRecipes.register(eventBus);
        ModBlockEntities.register(eventBus);

        eventBus.addListener(this::setup);
        eventBus.addListener(this::clientSetup);

        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, IdeagCommonConfigs.SPEC, "ideag-common.toml");

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
    }
    private void clientSetup(final FMLClientSetupEvent event) {
        ModItemProperties.addCustomItemProperties();
        MenuScreens.register(ModMenuTypes.HEPHAESTUS_FORGE_MENU.get(), HephaestusForgeScreen::new);
    }

    private void setup(final FMLCommonSetupEvent event)
    {
        BrewingRecipeRegistry.addRecipe(new BetterBrewingRecipe(Potions.AWKWARD,
                Items.REDSTONE, ModPotions.ELECTROCUTE_POTION.get()));

        ModVillagers.registerPOIs();
    }
}
