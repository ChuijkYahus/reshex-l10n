package io.github.emir4169.reshex.fabric

import io.github.emir4169.reshex.Reshex
import net.fabricmc.api.ModInitializer

object FabricReshex : ModInitializer {
    override fun onInitialize() {
        Reshex.init()
    }
}
