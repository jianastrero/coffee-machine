import java.util.*

fun getLastDigit(a: Int) = "$a".reversed()[0]

/* Do not change code below */
fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    val a = scanner.nextInt()
    println(getLastDigit(a))
}