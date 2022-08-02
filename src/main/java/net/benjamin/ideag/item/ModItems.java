package net.benjamin.ideag.item;

import net.benjamin.ideag.IdeagMod;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.*;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

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
            () -> new SwordItem(ModTiers.HADES, 24, 1f,
                    new Item.Properties().tab(CreativeModeTab.TAB_COMBAT)));

    public static final RegistryObject<Item> THE_BLADE_OF_ARES = ITEMS.register("the_blade_of_ares",
            () -> new SwordItem(ModTiers.HADES, 50, 0.3f,
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
            () -> new HoeItem(ModTiers.HADES, 68, 0.5f,
                    new Item.Properties().tab(CreativeModeTab.TAB_COMBAT)));

    public static final RegistryObject<Item> THE_BOW_OF_ARTEMIS = ITEMS.register("the_bow_of_artemis",
            () -> new BowItem(new Item.Properties().tab(CreativeModeTab.TAB_COMBAT).durability(500)));
    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}