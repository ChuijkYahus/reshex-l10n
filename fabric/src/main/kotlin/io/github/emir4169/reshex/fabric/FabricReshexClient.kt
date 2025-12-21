package io.github.emir4169.reshex.fabric

import io.github.emir4169.reshex.ReshexClient
import net.fabricmc.api.ClientModInitializer

object FabricReshexClient : ClientModInitializer {
    override fun onInitializeClient() {
        ReshexClient.init()
    }
}
