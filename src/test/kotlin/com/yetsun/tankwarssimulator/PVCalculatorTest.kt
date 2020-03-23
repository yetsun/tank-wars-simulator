package com.yetsun.tankwarssimulator

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class PVCalculatorTest {
    @Test
    fun test_isImbalance_not() {
        val result = listOf(100, 100)
        val actual = isImbalance(result)
        assertThat(actual).isFalse()
    }

    @Test
    fun test_isImbalance_yes() {
        val result = listOf(100, 150)
        val actual = isImbalance(result)
        assertThat(actual).isTrue()
    }
}