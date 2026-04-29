package org.wayggstar.starstream_api.data

interface IPlayerData {
    var playerName: String
    var level: Int
    var exp: Long

    var hp: Float
    var maxHp: Float
    var mp: Float
    var maxMp: Float

    var strength: Int
    var agility: Int
    var intelligence: Int
    var vitality: Int

    var coins: Long

    val equippedTraits: List<ITrait>
    val unlockedSkills: List<ISkill>
    val activeWarps: List<IWarp>
    val completedStories: List<IStory>

    fun addExp(amount: Long)
    fun takeDamage(amount: Float)
    fun heal(amount: Float)
    fun addCoins(amount: Long)
    fun removeCoins(amount: Long): Boolean
}
