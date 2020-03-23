package com.yetsun.tankwarssimulator.company

class CompanyGame(private val companyOne: Company, private val companyTwo: Company) {

    fun startAndWinnerIs(): Company? {

        while (companyOne.isActive() && companyTwo.isActive()) {
            val companyOneAliveTanks = companyOne.getAliveTanks()
            val companyTwoAliveTanks = companyTwo.getAliveTanks()

            val companyOneTarget = companyTwoAliveTanks[0]
            val companyTwoTarget = companyOneAliveTanks[0]

            companyOneAliveTanks.forEach { t ->
                t.hit(companyOneTarget)
            }

            companyTwoAliveTanks.forEach { t ->
                t.hit(companyTwoTarget)
            }
        }

        return if (!companyOne.isActive() && !companyTwo.isActive()) {
            null
        } else {
            if (companyOne.isActive()) companyOne else companyTwo
        }
    }
}