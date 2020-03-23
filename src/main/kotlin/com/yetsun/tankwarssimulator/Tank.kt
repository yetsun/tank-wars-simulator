package com.yetsun.tankwarssimulator

class Tank(val name: String, val level: Int, var initialHitPoint: Int, val hitChance: Int, val baseDamage: Int) {

    val dice: Dice = Dice()
    var hitPoint: Int = initialHitPoint

    fun getReadyForGame() {
        hitPoint = initialHitPoint
    }

    fun isAlive(): Boolean {
        return hitPoint > 0;
    }

    fun hit(anotherTank: Tank) {
        if (hitOrMiss()) {
            val damage = calculateDamage()
            anotherTank.receiveDamage(damage)
//            println("$name hit ${anotherTank.name} damage $damage")
        }else{
//            println("$name miss ${anotherTank.name}")
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
