package net.benjamin.ideag.block.entity;

import net.benjamin.ideag.IdeagMod;
import net.benjamin.ideag.block.ModBlocks;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(ForgeRegistries.BLOCK_ENTITIES, IdeagMod.MOD_ID);

    public static final RegistryObject<BlockEntityType<PedestalBlockEntity>> PEDESTAL =
            BLOCK_ENTITIES.register("pedestal", () ->
                    BlockEntityType.Builder.of(PedestalBlockEntity::new,
                            ModBlocks.PEDESTAL.get()).build(null));

    public static final RegistryObject<BlockEntityType<HephaestusForgeBlockEntity>> HEPHAESTUS_FORGE_BLOCK_ENTITY =
            BLOCK_ENTITIES.register("hephaestus_forge_block_entity", () ->
                    BlockEntityType.Builder.of(HephaestusForgeBlockEntity::new,
                            ModBlocks.PEDESTAL.get()).build(null));



    public static void register(IEventBus eventBus){
        BLOCK_ENTITIES.register(eventBus);
    }
}
