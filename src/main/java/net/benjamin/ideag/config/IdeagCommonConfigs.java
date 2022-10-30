package net.benjamin.ideag.config;

import net.minecraftforge.common.ForgeConfigSpec;

public class IdeagCommonConfigs {

    public static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
    public static final ForgeConfigSpec SPEC;

    public static final ForgeConfigSpec.ConfigValue<Integer> ELECTROCUTE_TIME;
    public static final ForgeConfigSpec.ConfigValue<Integer> AMBROSIA_TIME;

    public static final ForgeConfigSpec.ConfigValue<Integer> RALLEN_ORE_VEIN_SIZE;
    public static final ForgeConfigSpec.ConfigValue<Integer> RALLEN_ORE_VEINS_PER_CHUNK;

    static {
        BUILDER.push("Configs for Ideag");

        ELECTROCUTE_TIME = BUILDER.comment("How many ticks does the electrocute effect last")
                .define("Electrocute Time", 400);

        AMBROSIA_TIME = BUILDER.comment("How many ticks does the ambrosia effect last")
                .define("Ambrosia Time", 2000);

        RALLEN_ORE_VEIN_SIZE = BUILDER.comment("How many Rallen Ore Blocks spawn in one Vein!")
                .defineInRange("Rallen Ore Vein Size",9, 1, 20);
        RALLEN_ORE_VEINS_PER_CHUNK = BUILDER.comment("How many Rallen Ore Veins spawn per chunk!")
                .define("Rallen Ore Veins Per Chunk", 7);

        BUILDER.pop();
        SPEC = BUILDER.build();
    }
}
