package com.yetsun.tankwarssimulator.duel

import com.yetsun.tankwarssimulator.tank.*
import com.yetsun.tankwarssimulator.utils.showPlayResult

class DuelPlay {

    fun simulate() {
        simulate(tiger1, sturmtiger)
        simulate(panther1, sturmtiger)
        simulate(tiger1, panther1)

        simulate(stug3Early, hetzer)
        simulate(sturmtiger, tiger1)

        simulate(sturmtiger, jagdtiger)

        simulate(panther1, tiger1)
    }

    private fun simulate(tank1: Tank, tank2: Tank) {
        val result: MutableMap<BattleUnit, Int> = mutableMapOf(tank1 to 0, tank2 to 0)
        val game = DuelGame(tank1, tank2)

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

        showPlayResult(result)
    }
}