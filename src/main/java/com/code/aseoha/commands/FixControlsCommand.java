package com.code.aseoha.commands;

import com.mojang.brigadier.Command;
import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.builder.ArgumentBuilder;

import net.minecraft.command.CommandSource;
import net.minecraft.command.Commands;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.server.ServerWorld;
import net.tardis.mod.ars.ConsoleRoom;
import net.tardis.mod.commands.argument.ExteriorArgument;
import net.tardis.mod.commands.subcommands.TCommand;
import net.tardis.mod.exterior.AbstractExterior;
import net.tardis.mod.helper.TardisHelper;
import net.tardis.mod.misc.Console;
import net.tardis.mod.tileentities.ConsoleTile;

public class FixControlsCommand extends TCommand {

    private static int fixControls(CommandSource source) {
//            ServerWorld tardisInteriorWorld = TardisHelper.setupTardisDim(sWorld.getServer(), console.getState(), room);
            TardisHelper.getConsoleInWorld(source.getLevel()).ifPresent((consoleTile) -> {
                consoleTile.updateClient();
                consoleTile.removeControls();
                consoleTile.getOrCreateControls();
                consoleTile.updateClient();
            });
            source.sendSuccess(new TranslationTextComponent("command.aseoha.controls.fixed"), true);
        return Command.SINGLE_SUCCESS;
    }

    public static ArgumentBuilder<CommandSource, ?> register(CommandDispatcher<CommandSource> dispatcher){
        return Commands.literal("fix_controls").requires(context -> context.hasPermission(2))
//                .then(Commands.argument("", FixControlsArgument.getFixControlsArgument()).executes(FixControlsCommand.)
//                );//End exterior argument
                .executes((commandSource) -> {return FixControlsCommand.fixControls(commandSource.getSource());});
    }
}
