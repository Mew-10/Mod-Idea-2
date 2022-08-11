package net.benjamin.ideag.config;

import net.minecraftforge.common.ForgeConfigSpec;

public class IdeagCommonConfigs {

    public static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
    public static final ForgeConfigSpec SPEC;

    public static final ForgeConfigSpec.ConfigValue<Integer> ELECTROCUTE_TIME;

    static {
        BUILDER.push("Configs for Ideag");

        ELECTROCUTE_TIME = BUILDER.comment("How many ticks does the electrocute effect last")
                .define("Electrocute Time", 400);

        BUILDER.pop();
        SPEC = BUILDER.build();
    }
}
