package me.eftelist.ParkBase.Commands.Builders

import me.eftelist.ParkBase.Commands.Interfaces.Command
import me.eftelist.ParkBase.Commands.Interfaces.SubCommand
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player

import java.util.ArrayList

class CommandImpl(override val name: String, override val subCommands: ArrayList<SubCommand>) : Command {

    override fun onCommand(commandSender: CommandSender, command: org.bukkit.command.Command, s: String, strings: Array<String>): Boolean {
        doCommand(commandSender as Player, strings.toList())
        return false
    }
}
