package org.wayggstar.starstream_api.data

interface ITrait {
    val id: String
    val name: String
    val description: String
    val tier: TraitTier

    val statBonuses: Map<StatType, Float>
    val exclusiveWith: List<String>

    enum class TraitTier {
        COMMON, UNCOMMON, RARE, EPIC, LEGENDARY, TRANSCENDENT
    }

    enum class StatType {
        STRENGTH, AGILITY, INTELLIGENCE, VITALITY,
        MAX_HP, MAX_MP, CRIT_RATE, CRIT_DAMAGE,
        ATTACK_SPEED, MOVE_SPEED
    }
}
