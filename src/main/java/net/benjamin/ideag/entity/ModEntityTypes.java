package net.benjamin.ideag.entity;

import net.benjamin.ideag.IdeagMod;
import net.benjamin.ideag.entity.custom.MedusaEntity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModEntityTypes {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(ForgeRegistries.ENTITIES, IdeagMod.MOD_ID);

    public static final RegistryObject<EntityType<MedusaEntity>> MEDUSA =
            ENTITY_TYPES.register("medusa",
                    () -> EntityType.Builder.of(MedusaEntity::new, MobCategory.CREATURE)
                            .sized(0.25F, 0.25F)
                            .build(new ResourceLocation(IdeagMod.MOD_ID, "medusa").toString()));


    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }
}
