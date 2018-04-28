package me.eftelist.ParkBase.Listeners

import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.block.BlockPlaceEvent

class BaseListener : Listener {

    @EventHandler
    fun handleTest(blockPlaceEvent: BlockPlaceEvent){
        blockPlaceEvent.player.sendMessage("Block placed type: " + blockPlaceEvent.block.type.name)
    }
}