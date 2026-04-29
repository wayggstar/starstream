package org.wayggstar.starstream_api

import org.wayggstar.starstream_api.data.IPlayerData
import org.wayggstar.starstream_api.data.ISkill
import org.wayggstar.starstream_api.data.IStory
import org.wayggstar.starstream_api.data.ITrait
import org.wayggstar.starstream_api.data.IWarp

object StarstreamAPI {

    private var playerDataProvider: (() -> IPlayerData?)? = null
    private val syncListeners = mutableListOf<(IPlayerData, Boolean) -> Unit>()

    // ── 플레이어 데이터 ──

    fun getPlayerData(): IPlayerData? = playerDataProvider?.invoke()


    fun setPlayerDataProvider(provider: () -> IPlayerData) {
        playerDataProvider = provider
    }

    // ── 데이터 동기화 이벤트 (pure listener pattern) ──

    fun onSync(listener: (data: IPlayerData, fullSync: Boolean) -> Unit) {
        syncListeners.add(listener)
    }

    fun notifySync(fullSync: Boolean = false) {
        val data = getPlayerData() ?: return
        syncListeners.forEach { it(data, fullSync) }
    }
}
