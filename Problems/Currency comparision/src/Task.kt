import java.util.Scanner

enum class Countries(val currency: String) {

    GERMANY("Euro"),
    MALI("CFA franc"),
    DOMINICA("Eastern Caribbean dollar"),
    CANADA("Canadian dollar"),
    SPAIN("Euro"),
    AUSTRALIA("Australian dollar"),
    BRAZIL("Brazilian dollar"),
    SENEGAL("CFA franc"),
    FRANCE("Euro"),
    GRENADA("Eastern Caribbean dollar"),
    KIRIBATI("Australian dollar");

    companion object {

        fun get(name: String) =
            values().firstOrNull { it.name.toLowerCase() == name.toLowerCase() }
    }
}

fun main(args: Array<String>) {
    val input = Scanner(System.`in`)
    val (a, b) = Pair(Countries.get(input.next()), Countries.get(input.next()))

    println(a != null && a.currency == b?.currency)
}