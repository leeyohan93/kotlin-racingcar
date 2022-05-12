package racingcar.domain

class Cars(
    private val cars: List<Car>
) {
    fun move(movingStrategy: MovingStrategy) {
        cars.forEach { it.move(movingStrategy) }
    }

    fun nameWithLocation(): List<CarNameWithLocation> {
        return cars.map {
            CarNameWithLocation(it.carName, it.location)
        }
    }

    fun size(): Int {
        return cars.size
    }

    companion object {
        fun of(carNames: List<CarName>): Cars {
            return Cars(carNames.map(::Car))
        }
    }
}
