package com.yetsun.tankwarssimulator.company

import com.yetsun.tankwarssimulator.tank.BattleUnit
import com.yetsun.tankwarssimulator.tank.jagdtiger
import com.yetsun.tankwarssimulator.tank.panther1
import com.yetsun.tankwarssimulator.tank.stug3Early
import com.yetsun.tankwarssimulator.utils.showPlayResult

class CompanyPlay {

    fun simulate() {
        simulate(Company(listOf(panther1, stug3Early)), Company(listOf(jagdtiger)))
    }

    private fun simulate(company1: Company, company2: Company) {

        val result: MutableMap<BattleUnit, Int> = mutableMapOf(company1 to 0, company2 to 0)

        val game = CompanyGame(company1, company2)

        val repeatCount = 3000000
//        val repeatCount = 3
        repeat(repeatCount) {

            company1.getReadyForGame()
            company2.getReadyForGame()

            val winner = game.startAndWinnerIs()

            if (winner != null) {
                val count = result.get(winner)!! + 1
                result[winner] = count
            }
        }

        showPlayResult(result)
    }
}