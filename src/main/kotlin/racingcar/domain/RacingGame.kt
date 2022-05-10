package racingcar.domain

class RacingGame(
    private val cars: Cars,
    private var laps: Int,
    private val movingStrategy: MovingStrategy = DefaultStrategy()
) {
    private val _lapReports: MutableList<List<Int>> = mutableListOf()
    val lapReports: List<List<Int>>
        get() = _lapReports

    fun start() {
        if (!isNotEnd()) throw IllegalStateException("이미 종료된 레이스입니다.")
        cars.move(movingStrategy)
        writeReport()
        laps--
    }

    private fun writeReport() {
        _lapReports.add(cars.location().map { it.value })
    }

    fun isNotEnd(): Boolean {
        return laps > END_GAME_LAPS
    }

    companion object {
        private const val END_GAME_LAPS = 0
    }
}
