package com.yetsun.tankwarssimulator.tank

interface BattleUnit {
    fun getDisplayName(): String

    fun getReadyForGame()

    fun isActive(): Boolean
}