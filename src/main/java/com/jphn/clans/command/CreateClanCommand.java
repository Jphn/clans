package com.jphn.clans.command;

import com.mojang.brigadier.Command;
import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.StringArgumentType;
import com.mojang.brigadier.context.CommandContext;
import net.minecraft.command.CommandRegistryAccess;
import net.minecraft.server.command.CommandManager;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.text.Text;

public class CreateClanCommand {
    public static void register(CommandDispatcher<ServerCommandSource> dispatcher, CommandRegistryAccess commandRegistryAccess, CommandManager.RegistrationEnvironment registrationEnvironment) {
        dispatcher
                .register(CommandManager
                        .literal("clan")
                        .then(CommandManager
                                .argument("name", StringArgumentType.word())
                                .executes(CreateClanCommand::run)));
    }

    private static int run(CommandContext<ServerCommandSource> context) {
        String name = StringArgumentType.getString(context, "name");

        context.getSource().sendFeedback(
                () -> Text.literal("Team: %s".formatted(name)),
                false
        );

        return 1;
    }
}
