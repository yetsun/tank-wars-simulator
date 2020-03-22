package com.yetsun.tankwarssimulator

class Game(private val tankOne: Tank, private val tankTwo: Tank) {
    /**
     * return the winner
     */
    fun startAndWinnerIs(): Tank? {



        while (tankOne.isAlive() && tankTwo.isAlive()) {
//            println("******** new round *********")
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