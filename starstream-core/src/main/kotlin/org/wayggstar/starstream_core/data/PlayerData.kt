package org.wayggstar.starstream_core.data

import org.wayggstar.starstream_api.data.IPlayerData
import org.wayggstar.starstream_api.data.ISkill
import org.wayggstar.starstream_api.data.IStory
import org.wayggstar.starstream_api.data.ITrait
import org.wayggstar.starstream_api.data.IWarp

class PlayerData(
    override var playerName: String = "",
    override var level: Int = 1,
    override var exp: Long = 0,
    override var hp: Float = 100f,
    override var maxHp: Float = 100f,
    override var mp: Float = 50f,
    override var maxMp: Float = 50f,
    override var strength: Int = 10,
    override var agility: Int = 10,
    override var intelligence: Int = 10,
    override var vitality: Int = 10,
    override var coins: Long = 0,
    override val equippedTraits: MutableList<ITrait> = mutableListOf(),
    override val unlockedSkills: MutableList<ISkill> = mutableListOf(),
    override val activeWarps: MutableList<IWarp> = mutableListOf(),
    override val completedStories: MutableList<IStory> = mutableListOf()
) : IPlayerData {

    override fun addExp(amount: Long) {
        exp += amount
    }

    override fun takeDamage(amount: Float) {
        hp = maxOf(0f, hp - amount)
    }

    override fun heal(amount: Float) {
        hp = minOf(maxHp, hp + amount)
    }

    override fun addCoins(amount: Long) {
        coins += amount
    }

    override fun removeCoins(amount: Long): Boolean {
        if (coins < amount) return false
        coins -= amount
        return true
    }
}
