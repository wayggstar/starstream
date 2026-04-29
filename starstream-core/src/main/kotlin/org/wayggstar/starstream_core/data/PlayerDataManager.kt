package org.wayggstar.starstream_core.data

import org.wayggstar.starstream_api.StarstreamAPI

object PlayerDataManager {

    val currentPlayerData = PlayerData()

    fun sync(fullSync: Boolean = false) {
        StarstreamAPI.notifySync(fullSync = fullSync)
    }

    fun onExpGained(amount: Long) {
        currentPlayerData.addExp(amount)
        sync()
    }

    fun onDamageTaken(amount: Float) {
        currentPlayerData.takeDamage(amount)
        sync()
    }

    fun onHealed(amount: Float) {
        currentPlayerData.heal(amount)
        sync()
    }

    fun onCoinsChanged(amount: Long, isGain: Boolean) {
        if (isGain) {
            currentPlayerData.addCoins(amount)
        } else {
            currentPlayerData.removeCoins(amount)
        }
        sync()
    }
}
