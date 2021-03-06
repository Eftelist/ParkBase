package me.eftelist.ParkBase.Base

import me.eftelist.ParkBase.Commands.Interfaces.Command
import org.bukkit.Bukkit
import org.bukkit.plugin.java.JavaPlugin
import java.util.*

abstract class ParkBase : JavaPlugin() {

    private var enabledMessage: String? = null
    private var disabledMessage: String? = null
    private var enabledd = false
    private var wasDisableRequest = false
    val dependencies = ArrayList<Dependency>()
    val commands = ArrayList<Command>()

    fun addDependency(dependency: Dependency) {
        if (!dependencies.contains(dependency)) {
            dependencies.add(dependency)
        }
    }

    fun addCommand(command: Command){
        if(!this.commands.contains(command)){
            commands.add(command)
        }
    }

    override fun onEnable() {
        this.loadDependencies()
        this.loadCommands()
        // Check dependencies
        for (dep in this.dependencies) {
            if (!Bukkit.getPluginManager().isPluginEnabled(dep.name)) {
                logger.warning("The dependency: " + dep.name + " must be loaded first!")
                Bukkit.getPluginManager().disablePlugin(this)
                return
            }
        }
        this.disabledMessage = this.name + " disabled!"
        try {
            this.wasDisableRequest = false
            this.enable()
            if (this.wasDisableRequest) {
                return
            }
            for(Command in commands){
                Command.register()
            }
            this.enabledd = true
        } catch (e: Exception) {
            e.printStackTrace()
            Bukkit.getPluginManager().disablePlugin(this)
        }

        logger.info(enabledMessage)
    }


    override fun onDisable() {
        this.wasDisableRequest = true
        if (this.enabledd) {
            // Try to disable the plugin
            try {
                this.disable()
            } catch (t: Throwable) {
                t.printStackTrace()
            }

        }
    }

    abstract fun loadCommands()

    abstract fun loadDependencies()

    abstract fun disable()

    abstract fun enable()

}
