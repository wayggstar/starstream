package org.wayggstar.starstream_api.data

interface IStory {
    val id: String
    val title: String
    val description: String

    val chapterCount: Int
    val requiredLevel: Int
    val requiredTraits: List<String>

    val rewards: List<StoryReward>

    fun isUnlocked(playerData: IPlayerData): Boolean
    fun isCompleted(playerData: IPlayerData): Boolean

    data class StoryReward(
        val type: RewardType,
        val amount: Int,
        val itemId: String? = null
    )

    enum class RewardType {
        EXP, COINS, SKILL_UNLOCK, TRAIT_UNLOCK, ITEM
    }
}
