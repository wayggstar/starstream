package org.wayggstar.starstream_api.event

import org.wayggstar.starstream_api.data.IPlayerData

data class PlayerDataSyncEvent(
    val playerData: IPlayerData,
    val isFullSync: Boolean = false
)
