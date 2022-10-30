package net.benjamin.ideag.enchantment;

import net.benjamin.ideag.IdeagMod;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModEnchantments {
    public static final DeferredRegister<Enchantment> ENCHANTMENTS
            = DeferredRegister.create(ForgeRegistries.ENCHANTMENTS, IdeagMod.MOD_ID);

    private static final EquipmentSlot[] ARMOR_SLOTS = new EquipmentSlot[]{EquipmentSlot.HEAD, EquipmentSlot.CHEST, EquipmentSlot.LEGS, EquipmentSlot.FEET};

    public static RegistryObject<Enchantment> SUMMON_GOLEM =
            ENCHANTMENTS.register("summon_golem",
                    () -> new SummonGolemEnchantment(Enchantment.Rarity.UNCOMMON,
                            EnchantmentCategory.WEAPON, EquipmentSlot.MAINHAND));

    public static RegistryObject<Enchantment> BETTER_THORNS =
            ENCHANTMENTS.register("better_thorns",
                    () -> new BetterThornsEnchantment(Enchantment.Rarity.VERY_RARE, ARMOR_SLOTS));


    public static void register(IEventBus eventBus) {
        ENCHANTMENTS.register(eventBus);
    }
}