package com.yetsun.tankwarssimulator.utils

import com.yetsun.tankwarssimulator.tank.Component
import mu.KotlinLogging
import org.apache.commons.math3.distribution.ChiSquaredDistribution
import java.text.NumberFormat
import java.util.*
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

fun showPlayResult(result: Map<Component, Int>) {
    val numberFormat: NumberFormat = NumberFormat.getNumberInstance(Locale.US)

    val component1 = result.keys.elementAt(0)
    val component2 = result.keys.elementAt(1)

    logger.info("${component1.getDisplayName()} vs ${component2.getDisplayName()}")
    result.forEach { comppoent, winCount ->
        logger.info("${comppoent.getDisplayName()} wins ${numberFormat.format(winCount)}")
    }

    if (isImbalanceWithPValue(result.values.toList())) {
        logger.info("imbalance")
    } else {
        logger.info("balanced")
    }
}