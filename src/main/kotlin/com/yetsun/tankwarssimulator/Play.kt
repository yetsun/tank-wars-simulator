package com.yetsun.tankwarssimulator

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
        val result = mutableMapOf<Tank, Int>(tank1 to 0, tank2 to 0)
        val game = Game(tank1, tank2)

        repeat(1000000) {

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
    }
}