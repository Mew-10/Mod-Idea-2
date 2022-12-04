package net.benjamin.ideag.event;

import net.benjamin.ideag.IdeagMod;
import net.benjamin.ideag.entity.ModEntityTypes;
import net.benjamin.ideag.entity.custom.MedusaEntity;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = IdeagMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEventBusEvents {

    @SubscribeEvent
    public static void entityAttributeEvent(EntityAttributeCreationEvent event) {
        event.put(ModEntityTypes.MEDUSA.get(), MedusaEntity.setAttributes());
    }
}
