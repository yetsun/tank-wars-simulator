package com.yetsun.tankwarssimulator.duel

import com.yetsun.tankwarssimulator.tank.Tank

class DuelGame(private val tankOne: Tank, private val tankTwo: Tank) {
    /**
     * return the winner
     */
    fun startAndWinnerIs(): Tank? {
        while (tankOne.isActive() && tankTwo.isActive()) {
//           logger.debug("New round")
            tankOne.hit(tankTwo)
            tankTwo.hit(tankOne)
        }

        return if (!tankOne.isActive() && !tankTwo.isActive()) {
            null
        } else {
            if (tankOne.isActive()) tankOne else tankTwo
        }
    }
}