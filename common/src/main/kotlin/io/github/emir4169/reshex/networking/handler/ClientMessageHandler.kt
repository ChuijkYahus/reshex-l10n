package io.github.emir4169.reshex.networking.handler

import dev.architectury.networking.NetworkManager.PacketContext
import io.github.emir4169.reshex.config.ReshexServerConfig
import io.github.emir4169.reshex.networking.msg.*

fun ReshexMessageS2C.applyOnClient(ctx: PacketContext) = ctx.queue {
    when (this) {
        is MsgSyncConfigS2C -> {
            ReshexServerConfig.onSyncConfig(serverConfig)
        }

        // add more client-side message handlers here
    }
}
