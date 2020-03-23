package com.yetsun.tankwarssimulator.duel

import com.yetsun.tankwarssimulator.tank.Tank

class DuelGame(private val tankOne: Tank, private val tankTwo: Tank) {
    /**
     * return the winner
     */
    fun startAndWinnerIs(): Tank? {
        while (tankOne.isAlive() && tankTwo.isAlive()) {
//           logger.debug("New round")
            tankOne.hit(tankTwo)
            tankTwo.hit(tankOne)
        }

        return if (!tankOne.isAlive() && !tankTwo.isAlive()) {
            null
        } else {
            if (tankOne.isAlive()) tankOne else tankTwo
        }
    }
}