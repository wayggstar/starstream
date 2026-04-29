package org.wayggstar.starstream_api.data

interface ISkill {
    val id: String
    val name: String
    val description: String
    val icon: String

    val manaCost: Int
    val cooldownTicks: Int
    val maxLevel: Int

    val damageMultiplier: Float
    val range: Double

    fun canUse(playerData: IPlayerData): Boolean
    fun execute(playerData: IPlayerData)
}
