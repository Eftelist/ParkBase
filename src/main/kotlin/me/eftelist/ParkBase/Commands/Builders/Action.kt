package me.eftelist.ParkBase.Commands.Builders

import org.bukkit.entity.Player

interface Action {

    fun execute(p: Player)
}
