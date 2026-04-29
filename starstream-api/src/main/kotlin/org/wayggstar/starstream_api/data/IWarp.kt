package org.wayggstar.starstream_api.data

interface IWarp {
    val id: String
    val name: String
    val description: String

    val worldName: String
    val x: Double
    val y: Double
    val z: Double
    val yaw: Float
    val pitch: Float

    val requiredLevel: Int
    val isLocked: Boolean
    val unlockCost: Int

    fun canUse(playerData: IPlayerData): Boolean
}
