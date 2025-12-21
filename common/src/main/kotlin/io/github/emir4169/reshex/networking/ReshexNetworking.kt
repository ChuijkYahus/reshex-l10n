package io.github.emir4169.reshex.networking

import dev.architectury.networking.NetworkChannel
import io.github.emir4169.reshex.Reshex
import io.github.emir4169.reshex.networking.msg.ReshexMessageCompanion

object ReshexNetworking {
    val CHANNEL: NetworkChannel = NetworkChannel.create(Reshex.id("networking_channel"))

    fun init() {
        for (subclass in ReshexMessageCompanion::class.sealedSubclasses) {
            subclass.objectInstance?.register(CHANNEL)
        }
    }
}
