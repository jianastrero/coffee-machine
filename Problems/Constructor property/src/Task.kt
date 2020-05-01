import kotlin.math.max
import kotlin.math.min

fun main() {
    val timerValue = readLine()!!.toInt()
    val timer = ByteTimer(timerValue)
    println(timer.time)
}

class ByteTimer(time: Int) {
    var time: Int = time
        get() = max(-128, min(127, field))
}