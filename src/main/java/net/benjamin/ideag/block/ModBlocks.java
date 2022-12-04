package net.benjamin.ideag.block;

import net.benjamin.ideag.IdeagMod;
import net.benjamin.ideag.item.ModItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.MagmaBlock;
import net.minecraft.world.level.block.TntBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, IdeagMod.MOD_ID);

    public static final RegistryObject<Block> CRACKED_MAGMA = registerBlock("cracked_magma",
            () -> new MagmaBlock(BlockBehaviour.Properties.of(Material.AMETHYST).strength(5f)
                    .requiresCorrectToolForDrops()), CreativeModeTab.TAB_BUILDING_BLOCKS);

    public static final RegistryObject<Block> MAGMA_TNT = registerBlock("magma_tnt",
            () -> new MagmaTntBlock(BlockBehaviour.Properties.of(Material.EXPLOSIVE).strength(5f)
                    .requiresCorrectToolForDrops()), CreativeModeTab.TAB_BUILDING_BLOCKS);

    public static final RegistryObject<Block> THE_RALLEN = registerBlock("the_rallen",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE).strength(5f)
                    .requiresCorrectToolForDrops()), CreativeModeTab.TAB_BUILDING_BLOCKS);

    public static final RegistryObject<Block> RALLEN_ORE = registerBlock("rallen_ore",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(4f).requiresCorrectToolForDrops()), CreativeModeTab.TAB_BUILDING_BLOCKS);

    public static final RegistryObject<Block> DEEPSLATE_RALLEN_ORE = registerBlock("deepslate_rallen_ore",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(4f).requiresCorrectToolForDrops()), CreativeModeTab.TAB_BUILDING_BLOCKS);

    public static final RegistryObject<Block> PEDESTAL = registerBlock("pedestal",
            () -> new PedestalBlock(BlockBehaviour.Properties.of(Material.STONE)), CreativeModeTab.TAB_BUILDING_BLOCKS);

    public static final RegistryObject<Block> HEPHAESTUS_FORGE = registerBlock("hephaestus_forge",
            () -> new HephaestusForgeBlock(BlockBehaviour.Properties.of(Material.METAL).noOcclusion()), CreativeModeTab.TAB_BUILDING_BLOCKS);

    public static final RegistryObject<Block> THE_GRAND_TABLE = registerBlock("the_grand_table",
            () -> new TheGrandTableBlock(BlockBehaviour.Properties.of(Material.METAL).noOcclusion()), CreativeModeTab.TAB_BUILDING_BLOCKS);



    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block, CreativeModeTab tab) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn, tab);
        return toReturn;
    }


    private static <T extends Block>RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block, CreativeModeTab tab) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(),
                new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)));
    }

    public static void register(IEventBus eventBus){
        BLOCKS.register(eventBus);
    }

}
