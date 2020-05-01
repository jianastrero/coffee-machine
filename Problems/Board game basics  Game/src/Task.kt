import kotlin.math.max

object PlayingField {
    object Size {

        var width = 0
        var height = 0

        fun changeSize(width: Int, height: Int) {
            Size.width = max(0, width)
            Size.height = max(0, height)
        }
    }
}