package io.github.meatwo310.silentsk.mixin;

import com.mojang.logging.LogUtils;
import com.natamus.starterkit_common_forge.functions.StarterGearFunctions;
import io.github.meatwo310.silentsk.Config;
import net.minecraft.commands.CommandSourceStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

@Mixin(value = StarterGearFunctions.class, remap = false)
public class StarterGearFunctionsMixin {
    @ModifyVariable(method = "giveStarterKit(" +
            "Lnet/minecraft/world/entity/player/Player;" +
            "Lnet/minecraft/commands/CommandSourceStack;" +
            "Ljava/lang/String;" +
            ")Ljava/lang/String;",
            at = @At("HEAD"),
            argsOnly = true)
    private static CommandSourceStack modifyCommandSource(CommandSourceStack commandSource) {
        if (!Config.ENABLED.get() || !Config.PREVENT_ON_GIVE.get()) return commandSource;
        if (Config.DEBUG_LOGGING.get()) LogUtils.getLogger().info("prevented message on give");
        return null;
    }
}
