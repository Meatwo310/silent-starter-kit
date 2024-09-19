package io.github.meatwo310.silentsk.mixin;

import com.mojang.brigadier.context.CommandContext;
import com.mojang.logging.LogUtils;
import com.natamus.starterkit_common_forge.cmds.CommandStarterkit;
import io.github.meatwo310.silentsk.Config;
import net.minecraft.commands.CommandSourceStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value = CommandStarterkit.class, remap = false)
public class CommandStarterkitMixin {
    @Inject(method = "lambda$register$11(Lcom/mojang/brigadier/context/CommandContext;)I",
            at = @At(value = "INVOKE",
                    shift = At.Shift.AFTER,
                    target = "Lcom/natamus/starterkit_common_forge/functions/StarterGearFunctions;initStarterKitHandle(" +
                            "Lnet/minecraft/world/level/Level;" +
                            "Lnet/minecraft/world/entity/player/Player;" +
                            "Lnet/minecraft/commands/CommandSourceStack;" +
                            ")V"),
            cancellable = true
    )
    private static void preventMessage(CommandContext<CommandSourceStack> context, CallbackInfoReturnable<Integer> cir) {
        if (!Config.ENABLED.get() || !Config.PREVENT_ON_GIVE_COMMAND.get()) return;
        if (Config.DEBUG_LOGGING.get()) LogUtils.getLogger().info("prevented message on give command");
        cir.setReturnValue(1);
    }

    @Inject(method = "lambda$register$12(Lcom/mojang/brigadier/context/CommandContext;)I",
            at = @At(value = "INVOKE",
                    shift = At.Shift.AFTER,
                    target = "Lcom/natamus/starterkit_common_forge/functions/StarterGearFunctions;initStarterKitHandle(" +
                            "Lnet/minecraft/world/level/Level;" +
                            "Lnet/minecraft/world/entity/player/Player;" +
                            "Lnet/minecraft/commands/CommandSourceStack;" +
                            "Ljava/lang/String;" +
                            ")V"),
            cancellable = true
    )
    private static void preventMessageWithKitName(CommandContext<CommandSourceStack> context, CallbackInfoReturnable<Integer> cir) {
        if (!Config.ENABLED.get() || !Config.PREVENT_ON_GIVE_COMMAND.get()) return;
        if (Config.DEBUG_LOGGING.get()) LogUtils.getLogger().info("prevented message on give command with kit name");
        cir.setReturnValue(1);
    }
}
