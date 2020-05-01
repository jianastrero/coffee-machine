import java.util.*

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)

    val x = scanner.nextInt()..scanner.nextInt()
    val y = scanner.nextInt()..scanner.nextInt()
    val z = scanner.nextInt()

    println(z in x && z in y)
}