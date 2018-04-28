package me.eftelist.ParkBase.Commands.Builders

import me.eftelist.ParkBase.Commands.Interfaces.SubCommand

class SubCommandBuilder {

    private var name: String? = null
    private var action: Action? = null

    fun name(name: String): SubCommandBuilder {
        this.name = name
        return this
    }

    fun action(action: Action): SubCommandBuilder {
        this.action = action
        return this
    }

    fun build(): SubCommand {
        return SubCommandImpl(name!!, action!!)
    }
}
