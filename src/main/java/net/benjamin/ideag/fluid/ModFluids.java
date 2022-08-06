package net.benjamin.ideag.fluid;

import net.benjamin.ideag.IdeagMod;
import net.benjamin.ideag.block.ModBlocks;
import net.benjamin.ideag.item.ModItems;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.fluids.FluidAttributes;
import net.minecraftforge.fluids.ForgeFlowingFluid;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModFluids {
    public static final ResourceLocation WATER_STILL_RL = new ResourceLocation("block/water_still");
    public static final ResourceLocation WATER_FLOWING_RL = new ResourceLocation("block/water_flow");
    public static final ResourceLocation WATER_OVERLAY_RL = new ResourceLocation("block/water_overlay");

    public static final DeferredRegister<Fluid> FLUIDS
            = DeferredRegister.create(ForgeRegistries.FLUIDS, IdeagMod.MOD_ID);


    public static final RegistryObject<FlowingFluid> NECTOR_FLUID
            = FLUIDS.register("nector_fluid", () -> new ForgeFlowingFluid.Source(ModFluids.NECTOR_PROPERTIES));

    public static final RegistryObject<FlowingFluid> NECTOR_FLOWING
            = FLUIDS.register("nector_flowing", () -> new ForgeFlowingFluid.Flowing(ModFluids.NECTOR_PROPERTIES));


    public static final ForgeFlowingFluid.Properties NECTOR_PROPERTIES = new ForgeFlowingFluid.Properties(
            () -> NECTOR_FLUID.get(), () -> NECTOR_FLOWING.get(), FluidAttributes.builder(WATER_STILL_RL, WATER_FLOWING_RL)
            .density(15).luminosity(2).viscosity(5).sound(SoundEvents.HONEY_DRINK).overlay(WATER_OVERLAY_RL)
            .color(16774738)).slopeFindDistance(2).levelDecreasePerBlock(2)
            .block(() -> ModFluids.NECTOR_BLOCK.get()).bucket(() -> ModItems.NECTOR_BOTTLE.get());

    public static final RegistryObject<LiquidBlock> NECTOR_BLOCK = ModBlocks.BLOCKS.register("nector",
            () -> new LiquidBlock(() -> ModFluids.NECTOR_FLUID.get(), BlockBehaviour.Properties.of(Material.WATER)
                    .noCollission().strength(100f).noDrops()));
}
