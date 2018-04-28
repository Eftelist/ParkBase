package me.eftelist.ParkBase

class BaseImpl: ParkBase(){

    override fun loadDependencies() {
        addDependency(Dependency("WorldGuard"))
        addDependency(Dependency("WorldEdit"))
        addDependency(Dependency("PermissionsEx"))
        addDependency(Dependency("Vault"))
        addDependency(Dependency("ProtocolLib"))
    }

    override fun enable() {
    }

    override fun disable() {
    }

}