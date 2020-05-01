import kotlin.math.max

class Car(val make: String, val year: Int) {

    var speed: Int = 0

    fun accelerate() {
        speed += 5
    }

    fun decelerate() {
        speed = max(speed - 5, 0)
    }
}