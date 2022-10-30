package net.benjamin.ideag.event;

import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import net.benjamin.ideag.IdeagMod;
import net.benjamin.ideag.block.ModBlocks;
import net.benjamin.ideag.entity.ModEntityTypes;
import net.benjamin.ideag.entity.custom.MedusaEntity;
import net.benjamin.ideag.item.ModItems;
import net.benjamin.ideag.villager.ModVillagers;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.item.trading.MerchantOffer;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.event.village.VillagerTradesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.List;

@Mod.EventBusSubscriber(modid = IdeagMod.MOD_ID)
public class ModEvents {

    @SubscribeEvent
    public static void addCustomTrades(VillagerTradesEvent event) {
        if (event.getType() == ModVillagers.RALLENMASTER.get()) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
            ItemStack stack = new ItemStack(ModItems.RALLEN.get(), 1);
            int villagerLevel = 1;

            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 12),
                    stack, 4, 5, 0.09F));
            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 27),
                    stack, 4, 5, 0.09F));
            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 35),
                    stack, 4, 5, 0.09F));

            trades.get(2).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 5),
                    stack, 4, 5, 0.09F));
            trades.get(2).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 6),
                    stack, 4, 5, 0.09F));
            {
                if (event.getType() == ModVillagers.RALLENMASTER.get()) {
                    Int2ObjectMap<List<VillagerTrades.ItemListing>> trades2 = event.getTrades();
                    ItemStack stack2 = new ItemStack(ModBlocks.THE_RALLEN.get(), 3);
                    int villagerLevel2 = 1;

                    trades2.get(villagerLevel2).add((trader, rand) -> new MerchantOffer(
                            new ItemStack(Items.DIAMOND, 12),
                            stack2, 4, 5, 0.09F));
                    trades2.get(villagerLevel2).add((trader, rand) -> new MerchantOffer(
                            new ItemStack(Items.DIAMOND, 27),
                            stack2, 4, 5, 0.09F));
                    trades2.get(villagerLevel2).add((trader, rand) -> new MerchantOffer(
                            new ItemStack(Items.DIAMOND, 35),
                            stack2, 4, 5, 0.09F));

                    trades2.get(2).add((trader, rand) -> new MerchantOffer(
                            new ItemStack(Items.EMERALD, 5),
                            stack2, 4, 5, 0.09F));
                    trades2.get(2).add((trader, rand) -> new MerchantOffer(
                            new ItemStack(Items.EMERALD, 6),
                            stack2, 4, 5, 0.09F));

                }
            }
        }
    }


    @SubscribeEvent
    public static void entityAttributeEvent(EntityAttributeCreationEvent event) {
        event.put(ModEntityTypes.MEDUSA.get(), MedusaEntity.setAttributes());
    }
}
