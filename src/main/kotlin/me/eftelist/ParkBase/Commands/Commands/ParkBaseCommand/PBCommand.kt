package me.eftelist.ParkBase.Commands.Commands.ParkBaseCommand

import me.eftelist.ParkBase.Commands.Interfaces.Command
import me.eftelist.ParkBase.Commands.Interfaces.SubCommand
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player
import java.util.ArrayList

class PBCommand(override var name: String, override val subCommands: ArrayList<SubCommand>) : Command {

    override fun onCommand(p0: CommandSender?, p1: org.bukkit.command.Command?, p2: String?, p3: Array<out String>?): Boolean {
        doCommand(p0 as Player, p3!!.toList());
        return false;
    }

}