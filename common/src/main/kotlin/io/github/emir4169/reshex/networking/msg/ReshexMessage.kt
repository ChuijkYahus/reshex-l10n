package io.github.emir4169.reshex.networking.msg

import dev.architectury.networking.NetworkChannel
import dev.architectury.networking.NetworkManager.PacketContext
import io.github.emir4169.reshex.Reshex
import io.github.emir4169.reshex.networking.ReshexNetworking
import io.github.emir4169.reshex.networking.handler.applyOnClient
import io.github.emir4169.reshex.networking.handler.applyOnServer
import net.fabricmc.api.EnvType
import net.minecraft.network.FriendlyByteBuf
import net.minecraft.server.level.ServerPlayer
import java.util.function.Supplier

sealed interface ReshexMessage

sealed interface ReshexMessageC2S : ReshexMessage {
    fun sendToServer() {
        ReshexNetworking.CHANNEL.sendToServer(this)
    }
}

sealed interface ReshexMessageS2C : ReshexMessage {
    fun sendToPlayer(player: ServerPlayer) {
        ReshexNetworking.CHANNEL.sendToPlayer(player, this)
    }

    fun sendToPlayers(players: Iterable<ServerPlayer>) {
        ReshexNetworking.CHANNEL.sendToPlayers(players, this)
    }
}

sealed interface ReshexMessageCompanion<T : ReshexMessage> {
    val type: Class<T>

    fun decode(buf: FriendlyByteBuf): T

    fun T.encode(buf: FriendlyByteBuf)

    fun apply(msg: T, supplier: Supplier<PacketContext>) {
        val ctx = supplier.get()
        when (ctx.env) {
            EnvType.SERVER, null -> {
                Reshex.LOGGER.debug("Server received packet from {}: {}", ctx.player.name.string, this)
                when (msg) {
                    is ReshexMessageC2S -> msg.applyOnServer(ctx)
                    else -> Reshex.LOGGER.warn("Message not handled on server: {}", msg::class)
                }
            }
            EnvType.CLIENT -> {
                Reshex.LOGGER.debug("Client received packet: {}", this)
                when (msg) {
                    is ReshexMessageS2C -> msg.applyOnClient(ctx)
                    else -> Reshex.LOGGER.warn("Message not handled on client: {}", msg::class)
                }
            }
        }
    }

    fun register(channel: NetworkChannel) {
        channel.register(type, { msg, buf -> msg.encode(buf) }, ::decode, ::apply)
    }
}
