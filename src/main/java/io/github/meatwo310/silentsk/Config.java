package io.github.meatwo310.silentsk;

import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Silentsk.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class Config {
    private static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();

    public static final ForgeConfigSpec.BooleanValue ENABLED = BUILDER
            .comment("Whether the mod is enabled")
            .define("enabled", true);

    public static final ForgeConfigSpec.BooleanValue PREVENT_ON_GIVE = BUILDER
            .comment("Whether to prevent message when giving kit")
            .define("preventOnGive", true);

    public static final ForgeConfigSpec.BooleanValue PREVENT_ON_GIVE_COMMAND = BUILDER
            .comment("Whether to prevent message when giving kit via command")
            .define("preventOnGiveCommand", true);

    public static final ForgeConfigSpec.BooleanValue DEBUG_LOGGING = BUILDER
            .comment("Whether to enable debug logging")
            .define("debugLogging", false);

    static final ForgeConfigSpec SPEC = BUILDER.build();
}
