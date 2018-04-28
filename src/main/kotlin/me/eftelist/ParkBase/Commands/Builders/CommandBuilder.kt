package me.eftelist.ParkBase.Commands.Builders

import me.eftelist.ParkBase.Commands.Interfaces.Command
import me.eftelist.ParkBase.Commands.Interfaces.SubCommand

import java.util.ArrayList

class CommandBuilder {

    private val subCommands: ArrayList<SubCommand>? = ArrayList<SubCommand>()
    private var cmd_name = ""

    fun addSubCommand(subCommand: SubCommand): CommandBuilder {
        addSub(subCommand)
        return this
    }

    private fun addSub(subCommand: SubCommand) {
        if (!subCommands!!.contains(subCommand)) {
            subCommands.add(subCommand)
        }
    }

    fun setCommand(cmd_name: String): CommandBuilder {
        this.cmd_name = cmd_name
        return this
    }

    fun build(): Command {
        return CommandImpl(cmd_name, subCommands!!)
    }
}
