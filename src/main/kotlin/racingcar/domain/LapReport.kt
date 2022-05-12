package racingcar.domain

class LapReport(
    private val lapReport: List<CarNameWithLocation>
) {
    fun winner(): List<CarName> {
        val topLocation = lapReport.maxOf { it.location }
        return lapReport.asSequence()
            .filter { it.location == topLocation }
            .map { it.carName }
            .toList()
    }

    fun toPairs(): List<Pair<String, Int>> {
        return lapReport.map { it.carName.value to it.location.value }
    }
}
