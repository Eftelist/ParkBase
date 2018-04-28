package me.eftelist.ParkBase.Base.Actions

import me.eftelist.ParkBase.Commands.Builders.Action
import me.eftelist.ParkBase.Objects.Enums.State
import me.eftelist.ParkBase.Objects.Ride
import me.eftelist.ParkBase.Realms.Realm
import org.bukkit.entity.Player

class BaseActionDebug : Action {

    override fun execute(p: Player) {
        val ride = Ride("Spinningcoaster 1", Realm.ATLANTIS, State.CLOSED)
        p.sendMessage(ride.toJSONString())
    }
}
