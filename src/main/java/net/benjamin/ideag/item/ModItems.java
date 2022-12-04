package net.benjamin.ideag.item;

import net.benjamin.ideag.IdeagMod;
import net.benjamin.ideag.entity.ModEntityTypes;
import net.benjamin.ideag.fluid.ModFluids;
import net.benjamin.ideag.item.custom.*;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.*;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.Objects;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, IdeagMod.MOD_ID);

    public static final RegistryObject<Item> HADES_HELMET = ITEMS.register("hades_helmet",
            () -> new ModArmorItem(ModArmorMaterials.HADES, EquipmentSlot.HEAD,
                    new Item.Properties().tab(CreativeModeTab.TAB_COMBAT)));

    public static final RegistryObject<Item> HADES_CHESTPLATE = ITEMS.register("hades_chestplate",
            () -> new ArmorItem(ModArmorMaterials.HADES, EquipmentSlot.CHEST,
                    new Item.Properties().tab(CreativeModeTab.TAB_COMBAT)));

    public static final RegistryObject<Item> HADES_LEGGINGS = ITEMS.register("hades_leggings",
            () -> new ArmorItem(ModArmorMaterials.HADES, EquipmentSlot.LEGS,
                    new Item.Properties().tab(CreativeModeTab.TAB_COMBAT)));

    public static final RegistryObject<Item> HADES_BOOTS = ITEMS.register("hades_boots",
            () -> new ArmorItem(ModArmorMaterials.HADES, EquipmentSlot.FEET,
                    new Item.Properties().tab(CreativeModeTab.TAB_COMBAT)));

    public static final RegistryObject<Item> HADES_STAFF = ITEMS.register("hades_staff",
            () -> new ElectrocuteSwordItem(ModTiers.HADES, 65, 1f,
                    new Item.Properties().tab(CreativeModeTab.TAB_COMBAT)));

    public static final RegistryObject<Item> THE_BLADE_OF_ARES = ITEMS.register("the_blade_of_ares",
            () -> new SwordItem(ModTiers.ARES, 50, 0.3f,
                    new Item.Properties().tab(CreativeModeTab.TAB_COMBAT)));

    public static final RegistryObject<Item> ARES_HELMET = ITEMS.register("ares_helmet",
            () -> new ModArmorItem_A(ModArmorMaterials.ARES, EquipmentSlot.HEAD,
                    new Item.Properties().tab(CreativeModeTab.TAB_COMBAT)));

    public static final RegistryObject<Item> ARES_CHESTPLATE = ITEMS.register("ares_chestplate",
            () -> new ArmorItem(ModArmorMaterials.ARES, EquipmentSlot.CHEST,
                    new Item.Properties().tab(CreativeModeTab.TAB_COMBAT)));

    public static final RegistryObject<Item> ARES_LEGGINGS = ITEMS.register("ares_leggings",
            () -> new ArmorItem(ModArmorMaterials.ARES, EquipmentSlot.LEGS,
                    new Item.Properties().tab(CreativeModeTab.TAB_COMBAT)));

    public static final RegistryObject<Item> ARES_BOOTS = ITEMS.register("ares_boots",
            () -> new ArmorItem(ModArmorMaterials.ARES, EquipmentSlot.FEET,
                    new Item.Properties().tab(CreativeModeTab.TAB_COMBAT)));

    public static final RegistryObject<Item> THANATOS_SCYTHE = ITEMS.register("thanatos_scythe",
            () -> new HoeItem(ModTiers.HADES, 40, 0.5f,
                    new Item.Properties().tab(CreativeModeTab.TAB_COMBAT)));

    public static final RegistryObject<Item> THE_BOW_OF_ARTEMIS = ITEMS.register("the_bow_of_artemis",
            () -> new BowItem(new Item.Properties().tab(CreativeModeTab.TAB_COMBAT).durability(500)));

    public static final RegistryObject<Item> DIAMOND_AND_STEEL = ITEMS.register("diamond_and_steel",
            () -> new FlintAndSteelItem(new Item.Properties().tab(CreativeModeTab.TAB_MISC).durability(500)));

    public static final RegistryObject<Item> AMBROSIA = ITEMS.register("ambrosia",
            () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_MISC).food(ModFoods.AMBROSIA)));

    public static final RegistryObject<Item> RALLEN = ITEMS.register("rallen",
            () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_MISC)));

    public static final RegistryObject<Item> RALLEN_MACE = ITEMS.register("rallen_mace",
            () -> new MaceItem(ModTiers.RALLEN, 16, 0.6f,
                    new Item.Properties().tab(CreativeModeTab.TAB_COMBAT)));

    public static final RegistryObject<Item> RALLEN_SHARD = ITEMS.register("rallen_shard",
            () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_MISC)));

    public static final RegistryObject<Item> NECTOR_BUCKET = ITEMS.register("nector_bucket",
            () -> new BucketItem(ModFluids.NECTOR_FLUID,
                    new Item.Properties().tab(CreativeModeTab.TAB_MISC)));

    public static final RegistryObject<Item> THE_BLADE_OF_EREBUS = ITEMS.register("the_blade_of_erebus",
            () -> new DarknessSwordItem(ModTiers.EREBUS, 750, 0.6f,
                    new Item.Properties().tab(CreativeModeTab.TAB_COMBAT)));

    public static final RegistryObject<Item> GODLEY_STAFF_OF_POWER = ITEMS.register("godley_staff_of_power",
            () -> new GodleyStaffOfPowerItem(new Item.Properties().tab(CreativeModeTab.TAB_MISC).stacksTo(1)));

    public static final RegistryObject<Item> THE_SWORD_OF_THANATOS = ITEMS.register("the_sword_of_thanatos",
            () -> new DarknessSwordItem(ModTiers.THANATOS, 500, 0.6f,
                    new Item.Properties().tab(CreativeModeTab.TAB_COMBAT)));

    public static final RegistryObject<Item> SICKEL_OF_THE_COSMOS = ITEMS.register("sickel_of_the_cosmos",
            () -> new DarknessSwordItem(ModTiers.COSMOS, 1000, 0.6f,
                    new Item.Properties().tab(CreativeModeTab.TAB_COMBAT)));

    public static final RegistryObject<Item> HARPE = ITEMS.register("harpe",
            () -> new SwordItem(ModTiers.HERO, 18, 0.6f,
                    new Item.Properties().tab(CreativeModeTab.TAB_COMBAT)));

    public static final RegistryObject<ForgeSpawnEggItem> MEDUSA_SPAWN_EGG = ITEMS.register("tiger_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntityTypes.MEDUSA,0xfcb603, 0x242321,
                    new Item.Properties().tab(CreativeModeTab.TAB_MISC)));

    public static void register (IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}