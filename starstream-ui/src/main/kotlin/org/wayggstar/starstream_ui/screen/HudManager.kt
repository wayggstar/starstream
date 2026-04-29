package org.wayggstar.starstream_ui.screen

import org.wayggstar.starstream_api.StarstreamAPI

object HudManager {

    private var currentData: CachedPlayerData? = null

    fun register() {
        StarstreamAPI.onSync { data, fullSync ->
            currentData = CachedPlayerData(data)
            // TODO: ModernUI HUD 갱신 트리거
        }

        StarstreamAPI.getPlayerData()?.let {
            currentData = CachedPlayerData(it)
        }
    }

    private data class CachedPlayerData(
        val playerName: String,
        val level: Int,
        val hp: Float,
        val maxHp: Float,
        val mp: Float,
        val maxMp: Float,
        val str: Int,
        val agi: Int,
        val intel: Int,
        val vit: Int,
        val coins: Long
    ) {
        constructor(playerData: org.wayggstar.starstream_api.data.IPlayerData) : this(
            playerName = playerData.playerName,
            level = playerData.level,
            hp = playerData.hp,
            maxHp = playerData.maxHp,
            mp = playerData.mp,
            maxMp = playerData.maxMp,
            str = playerData.strength,
            agi = playerData.agility,
            intel = playerData.intelligence,
            vit = playerData.vitality,
            coins = playerData.coins
        )
    }
}
