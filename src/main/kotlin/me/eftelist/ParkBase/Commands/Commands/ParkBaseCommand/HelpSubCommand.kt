package me.eftelist.ParkBase.Commands.Commands.ParkBaseCommand

import me.eftelist.ParkBase.Commands.Interfaces.SubCommand
import org.bukkit.entity.Player
import java.util.ArrayList

class HelpSubCommand : SubCommand {

    override fun execute(player: Player, arrayList: ArrayList<String>) {
        player.sendMessage(arrayList.toString())
    }

    override fun name(): String {
        return "help"
    }


}
