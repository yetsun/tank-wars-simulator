package com.yetsun.tankwarssimulator.company

import com.yetsun.tankwarssimulator.tank.BattleUnit
import com.yetsun.tankwarssimulator.tank.Tank
import kotlin.streams.toList

class Company(private val tanks: List<Tank>) : BattleUnit {

    override fun isActive(): Boolean {
        return tanks.stream().anyMatch { t -> t.isActive() }
    }

    fun getActiveTanks(): List<Tank> {
        return tanks.stream().filter { t -> t.isActive() }.toList()
    }

    override fun getReadyForGame() {
        tanks.forEach { t -> t.getReadyForGame() }
    }

    override fun getDisplayName(): String {
        return this.tanks.stream().map { t -> t.getDisplayName() }.toArray().joinToString(", ")
    }
}