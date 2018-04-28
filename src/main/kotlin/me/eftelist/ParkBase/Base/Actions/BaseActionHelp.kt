package me.eftelist.ParkBase.Base.Actions

import me.eftelist.ParkBase.Builders.Messages.MessageBuilder
import me.eftelist.ParkBase.Commands.Builders.Action
import org.bukkit.entity.Player

class BaseActionHelp : Action {

    override fun execute(p: Player) {
        MessageBuilder().addCentered("&6Helpmenu").addEnter().addCentered("&6Test").build(p)
    }

}
