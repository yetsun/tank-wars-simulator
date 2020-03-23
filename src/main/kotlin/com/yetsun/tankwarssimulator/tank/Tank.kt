package com.yetsun.tankwarssimulator.tank

import com.yetsun.tankwarssimulator.utils.Dice

class Tank(val name: String, val level: Int, var initialHitPoint: Int, val hitChance: Int, val baseDamage: Int) : BattleUnit {

    val dice: Dice = Dice()
    var hitPoint: Int = initialHitPoint

    override fun getDisplayName(): String {
        return "$name($level)"
    }

    override fun getReadyForGame() {
        hitPoint = initialHitPoint
    }

    override fun isActive(): Boolean {
        return hitPoint > 0;
    }

    fun hit(anotherTank: Tank) {
        if (hitOrMiss()) {
            val damage = calculateDamage()
            anotherTank.receiveDamage(damage)
//            logger.debug("$name hit ${anotherTank.name} damage $damage")
        } else {
//            logger.debug("$name miss ${anotherTank.name}")
        }
    }

    /**
     * return true if hit
     * return false if miss
     */
    private fun hitOrMiss(): Boolean {
        return dice.roll() >= hitChance
    }

    private fun calculateDamage(): Int {
        return dice.roll() * 10 + baseDamage
    }

    fun receiveDamage(damage: Int) {
        this.hitPoint = this.hitPoint - damage
    }

}


val panther1: Tank = Tank("Panther", 7, 1272, 3, 155)

//    val tiger1: Tank = Tank("Tiger", 1550, 4, 170)
val tiger1: Tank = Tank("Tiger", 7, 1400, 4, 187)

//    val sturmtiger: Tank = Tank("Sturmtiger", 7, 1550, 5, 275)
val sturmtiger: Tank = Tank("Sturmtiger", 7, 1450, 5, 307)

val jagdtiger: Tank = Tank("Jagdtiger", 8, 1499, 3, 201)
val kingtiger: Tank = Tank("King Tiger", 8, 1610, 4, 265)

val stug3Early: Tank = Tank("Stug III early", 4, 500, 5, 115)
val hetzer: Tank = Tank("Hetzer", 4, 440, 4, 80)

