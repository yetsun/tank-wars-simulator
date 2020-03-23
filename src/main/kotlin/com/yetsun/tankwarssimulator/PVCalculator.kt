package com.yetsun.tankwarssimulator

import org.apache.commons.math3.distribution.ChiSquaredDistribution
import kotlin.math.pow

fun isImbalance(result: List<Int>): Boolean {
    val total = result.reduce { a, b -> a + b }
    val expected = total / 2;

    //Sum(Chisqr-stat)
    val sumOfChiSqrMinusStat = result.map { value -> (expected - value).toDouble().pow(2) / expected }.reduce { a, b -> a + b }

    val pValue = 1 - ChiSquaredDistribution(1.0).cumulativeProbability(sumOfChiSqrMinusStat)

    println("pValue $pValue")
    return pValue < 0.05
}