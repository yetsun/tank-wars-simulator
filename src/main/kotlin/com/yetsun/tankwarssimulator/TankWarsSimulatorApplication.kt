package com.yetsun.tankwarssimulator

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class TankWarsSimulatorApplication

fun main(args: Array<String>) {
	runApplication<TankWarsSimulatorApplication>(*args)

	Play().simulate()
}
