class City(val name: String) {
    var degrees: Int = 0
        set(value) {
            field =
                if (value !in -92..57)
                    when (name) {
                        "Moscow" -> 5
                        "Hanoi" -> 20
                        "Dubai" -> 30
                        else -> 0
                    }
                else
                    value
        }
}

fun main() {
    val first = readLine()!!.toInt()
    val second = readLine()!!.toInt()
    val third = readLine()!!.toInt()
    val firstCity = City("Dubai")
    firstCity.degrees = first
    val secondCity = City("Moscow")
    secondCity.degrees = second
    val thirdCity = City("Hanoi")
    thirdCity.degrees = third

    val cities = arrayOf(firstCity, secondCity, thirdCity).sortedBy { it.degrees }

    //implement comparing here
    print(
        if (setOf(first, second, third).size != cities.size)
            "neither"
        else
            cities.first().name
    )
}