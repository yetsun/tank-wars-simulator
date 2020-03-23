package com.yetsun.tankwarssimulator.company

import com.yetsun.tankwarssimulator.tank.Component
import com.yetsun.tankwarssimulator.tank.Tank
import kotlin.streams.toList

class Company(private val tanks: List<Tank>) : Component {

    fun isActive(): Boolean {
        return tanks.stream().anyMatch { t -> t.isAlive() }
    }

    fun getAliveTanks(): List<Tank> {
        return tanks.stream().filter { t -> t.isAlive() }.toList()
    }

    fun getReadyForGame() {
        tanks.forEach { t -> t.getReadyForGame() }
    }

    override fun getDisplayName(): String {
        return this.tanks.stream().map { t -> t.getDisplayName() }.toArray().joinToString(", ")
    }
}