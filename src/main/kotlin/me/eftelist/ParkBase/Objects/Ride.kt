package me.eftelist.ParkBase.Objects

import com.google.gson.JsonObject
import com.google.gson.JsonParser
import me.eftelist.ParkBase.Objects.Enums.State
import me.eftelist.ParkBase.Realms.Realm
import org.bukkit.Material
import org.bukkit.inventory.ItemStack

data class Ride(val name: String, val realm: Realm, var state: State) {

    override fun toString(): String {
        return "ride(name= $name,realm= $realm,state= $state)"
    }

    fun toJSONObject(): JsonObject {
        var JsonParser = JsonParser()
        return JsonParser.parse(this.toJSONString()) as JsonObject
    }

    fun toJSONString(): String {
        return "{'id'='$name','realm'='$realm','state'='${state.name}'}"
    }

    fun getStateItemStack(): ItemStack {
        if(state == State.BUILDING || state == State.MAINTENANCE){
            return ItemStack(Material.STAINED_CLAY,1,1.toShort());
        } else if(state == State.OPEN){
            return ItemStack(Material.STAINED_CLAY,1,13.toShort());
        } else if(state == State.CLOSED){
            return ItemStack(Material.STAINED_CLAY,1,14.toShort());
        } else {
            return ItemStack(Material.STAINED_CLAY,1,14.toShort());
        }
    }

}