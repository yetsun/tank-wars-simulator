package com.yetsun.tankwarssimulator

import mu.KotlinLogging
import org.apache.commons.math3.distribution.ChiSquaredDistribution
import kotlin.math.pow

val logger = KotlinLogging.logger {}

fun isImbalanceWithPValue(result: List<Int>): Boolean {
    val total = result.reduce { a, b -> a + b }
    val expected = total / 2;

    //Sum(Chisqr-stat)
    val sumOfChiSqrMinusStat = result.map { value -> (expected - value).toDouble().pow(2) / expected }.reduce { a, b -> a + b }

    val pValue = 1 - ChiSquaredDistribution(1.0).cumulativeProbability(sumOfChiSqrMinusStat)

//    logger.debug("pValue $pValue")
    return pValue < 0.05
}