import kotlin.math.max
import kotlin.math.min

class City(val name: String) {
    var population: Int = 0
        set(value) {
            field = max(0, min(50000000, value))
        }
}