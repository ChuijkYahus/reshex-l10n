package io.github.emir4169.reshex.fabric

import io.github.emir4169.reshex.Reshex
import net.fabricmc.api.DedicatedServerModInitializer

object FabricReshexServer : DedicatedServerModInitializer {
    override fun onInitializeServer() {
        Reshex.initServer()
    }
}
