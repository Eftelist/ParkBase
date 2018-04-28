package me.eftelist.ParkBase.Commands.Builders

import me.eftelist.ParkBase.Commands.Interfaces.SubCommand
import org.bukkit.entity.Player

import java.util.ArrayList

class SubCommandImpl(private val name: String, private val action: Action) : SubCommand {

    override fun name(): String {
        return this.name
    }

    override fun execute(player: Player, arrayList: ArrayList<String>) {
        action.execute(player)
    }
}
