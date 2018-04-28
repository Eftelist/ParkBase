package me.eftelist.ParkBase.Commands.Manager

import me.eftelist.ParkBase.Commands.Interfaces.Command
import me.eftelist.ParkBase.Commands.Interfaces.SubCommand
import me.eftelist.ParkBase.Commands.Commands.ParkBaseCommand.HelpSubCommand
import me.eftelist.ParkBase.Commands.Commands.ParkBaseCommand.PBCommand

class CommandManager {

    private val commands: ArrayList<Command> = ArrayList<Command>();

    init {
        val list = ArrayList<SubCommand>()
        list.add(HelpSubCommand())
        this.commands.add(PBCommand("parkbase",list))
        for(Command in commands){
            Command.register()
        }
    }
}