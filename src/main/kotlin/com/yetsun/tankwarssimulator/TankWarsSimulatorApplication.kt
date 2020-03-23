package com.yetsun.tankwarssimulator

import com.yetsun.tankwarssimulator.duel.DuelPlay
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class TankWarsSimulatorApplication

fun main(args: Array<String>) {
    runApplication<TankWarsSimulatorApplication>(*args)

    DuelPlay().simulate()
}
