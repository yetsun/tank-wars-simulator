package com.yetsun.tankwarssimulator

import org.apache.commons.math3.distribution.ChiSquaredDistribution
import kotlin.math.pow

class Play {

    val panther1: Tank = Tank("Panther", 1250, 3, 155)
    val tiger1: Tank = Tank("Tiger", 1550, 4, 170)
    val sturmtiger: Tank = Tank("Sturmtiger", 1550, 5, 275)
    val jagdtiger: Tank = Tank("Jagdtiger", 1500, 3, 260)

    fun simulate() {
        simulate(tiger1, sturmtiger)
        simulate(panther1, sturmtiger)
        simulate(tiger1, panther1)
    }

    private fun simulate(tank1: Tank, tank2: Tank) {
        val result: MutableMap<Tank, Int> = mutableMapOf(tank1 to 0, tank2 to 0)
        val game = Game(tank1, tank2)

        repeat(3000000) {

            tank1.getReadyForGame()
            tank2.getReadyForGame()

            val winner = game.startAndWinnerIs()

            if (winner != null) {
                val count = result.get(winner)!! + 1
                result.put(winner, count)
            }
        }

        println()
        println("${tank1.name} vs ${tank2.name}")
        result.forEach { tank, winCount ->
            println("${tank.name} win $winCount")
        }

        if (isImbalance(result.values.toList())) {
            println("balanced")
        } else {
            println("imbalance")
        }
        println()
    }


    fun isImbalance(result: List<Int>): Boolean {
        val total = result.reduce { a, b -> a + b }
        val expected = total / 2;

        //Sum(Chisqr-stat)
        val sumOfChiSqrMinusStat = result.map { value -> (expected - value).toDouble().pow(2) / expected }.reduce { a, b -> a + b }

        val pValue = 1 - ChiSquaredDistribution(1.0).cumulativeProbability(sumOfChiSqrMinusStat)

        println("pValue $pValue")
        return pValue < 0.05
    }
}