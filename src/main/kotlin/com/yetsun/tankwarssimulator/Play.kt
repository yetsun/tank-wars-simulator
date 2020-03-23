package com.yetsun.tankwarssimulator

import java.text.NumberFormat
import java.util.*

class Play {

    val panther1: Tank = Tank("Panther", 7, 1272, 3, 155)

    //    val tiger1: Tank = Tank("Tiger", 1550, 4, 170)
    val tiger1: Tank = Tank("Tiger", 7, 1400, 4, 187)

    //    val sturmtiger: Tank = Tank("Sturmtiger", 7, 1550, 5, 275)
    val sturmtiger: Tank = Tank("Sturmtiger", 7, 1450, 5, 307)

    val jagdtiger: Tank = Tank("Jagdtiger", 8, 1499, 3, 201)
    val kingtiger: Tank = Tank("King Tiger", 8, 1610, 4, 265)

    val stug3Early: Tank = Tank("Stug III early", 4, 500, 5, 115)
    val hetzer: Tank = Tank("Hetzer", 4, 440, 4, 80)


    fun simulate() {
//        simulate(tiger1, sturmtiger)
//        simulate(panther1, sturmtiger)
//        simulate(tiger1, panther1)

//        simulate(stug3Early, hetzer)
//        simulate(sturmtiger, tiger1)

//        simulate(sturmtiger, jagdtiger)


        simulate(panther1, tiger1)
    }

    private fun simulate(tank1: Tank, tank2: Tank) {
        val result: MutableMap<Tank, Int> = mutableMapOf(tank1 to 0, tank2 to 0)
        val game = Game(tank1, tank2)

        val repeatCount = 3000000
//        val repeatCount = 3
        repeat(repeatCount) {

            tank1.getReadyForGame()
            tank2.getReadyForGame()

            val winner = game.startAndWinnerIs()

            if (winner != null) {
                val count = result.get(winner)!! + 1
                result[winner] = count
            }
        }

        showResult(result)
    }


    private fun showResult(result: Map<Tank, Int>) {
        val numberFormat: NumberFormat = NumberFormat.getNumberInstance(Locale.US)

        val tank1 = result.keys.elementAt(0)
        val tank2 = result.keys.elementAt(1)

        logger.info("${tank1.name} vs ${tank2.name}")
        result.forEach { tank, winCount ->
            val displayName = tank.name.padStart(20)
            logger.info("${displayName} wins ${numberFormat.format(winCount)}")
        }

        if (isImbalanceWithPValue(result.values.toList())) {
            logger.info("imbalance")
        } else {
            logger.info("balanced")
        }
    }
}