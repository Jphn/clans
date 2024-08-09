package com.jphn.clans.util;

import com.jphn.clans.command.CreateClanCommand;
import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;

public class ModRegistries {
    public static void registerModStuff() {

    }

    private static void registerCommands() {
        CommandRegistrationCallback.EVENT.register(CreateClanCommand::register);
    }
}
