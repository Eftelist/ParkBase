package me.eftelist.ParkBase.Commands.Interfaces

import me.eftelist.ParkBase.BaseImpl
import org.bukkit.ChatColor
import org.bukkit.command.CommandExecutor
import org.bukkit.entity.Player
import java.util.*


interface Command : CommandExecutor {

    val name: String
    val subCommands: ArrayList<SubCommand>

    fun register(){
        BaseImpl.instance!!.getCommand(name).executor = this
    }

    fun doCommand(player: Player, args: List<String>){
        if(args.size == 0){
            // send help
        } else {
            val target = getSubCommand(args[0])
            if(target == null){
                player.sendMessage(""+ ChatColor.RED + "Invalid subcommand! Type /" + this.name + " help")
            } else {
                val arrayList = ArrayList<String>()
                arrayList.addAll(args)
                arrayList.removeAt(0)
                target.execute(player, arrayList)
            }
        }
    }

    fun getSubCommand(name: String): SubCommand? {
        val subcommands = this.subCommands.iterator()
        while (subcommands.hasNext()) {
            val sc = subcommands.next()
            if (sc.name().equals(name, true)) {
                return sc
            }
        }
        return null
    }

}

interface SubCommand {
    fun name(): String
    fun execute(player: Player, arrayList: ArrayList<String>)
}
