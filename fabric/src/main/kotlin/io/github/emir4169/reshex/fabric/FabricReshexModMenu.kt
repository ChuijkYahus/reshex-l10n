package io.github.emir4169.reshex.fabric

import com.terraformersmc.modmenu.api.ConfigScreenFactory
import com.terraformersmc.modmenu.api.ModMenuApi
import io.github.emir4169.reshex.ReshexClient

object FabricReshexModMenu : ModMenuApi {
    override fun getModConfigScreenFactory() = ConfigScreenFactory(ReshexClient::getConfigScreen)
}
