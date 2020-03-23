package com.yetsun.tankwarssimulator

import java.util.*
import kotlin.random.Random

class Dice() {
    private val random: Random = Random(Date().time)

    fun roll(): Int {
        val face = random.nextInt(1, 7)
//        logger.debug("roll a dice $face")
        return face
    }
}