package machine

import java.util.Scanner


fun main() {
    val scanner = Scanner(System.`in`)
    val coffeeMachine = CoffeeMachine()

    while (true) {
        println()
        print("Write action (buy, fill, take, remaining, exit): ")
        val action = scanner.nextLine()

        when (CoffeeMachine.State.getState(action)) {
            CoffeeMachine.State.ACTION -> {

            }
            CoffeeMachine.State.BUY -> {
                print("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu: ")
                coffeeMachine.buy(scanner.nextLine())
            }
            CoffeeMachine.State.FILL -> {
                print("Write how many ml of water do you want to add: ")
                val water = scanner.nextLine().toInt()

                print("Write how many ml of milk do you want to add: ")
                val milk = scanner.nextLine().toInt()

                print("Write how many grams of coffee beans do you want to add: ")
                val beans = scanner.nextLine().toInt()

                print("Write how many disposable cups of coffee do you want to add: ")
                val cups = scanner.nextLine().toInt()
                coffeeMachine.fill(water, milk, beans, cups)
            }
            CoffeeMachine.State.TAKE -> {
                coffeeMachine.take()
            }
            CoffeeMachine.State.REMAINING -> {
                println(coffeeMachine.status())
            }
            CoffeeMachine.State.EXIT -> {
                return
            }
        }
    }
}

class CoffeeMachine {

    private var water = 400
    private var milk = 540
    private var beans = 120
    private var cups = 9
    private var money = 550

    enum class State {
        ACTION, BUY, FILL, TAKE, REMAINING, EXIT;

        companion object {
            fun getState(string: String) =
                values().first { it.name.toLowerCase() == string.toLowerCase() }
        }
    }

    fun status() =
        """
            The coffee machine has:
            $water of water
            $milk of milk
            $beans of coffee beans
            $cups of disposable cups
            $money of money
        """.trimIndent()

    fun buy(action: String) {
        if (action != "back") {
            val cup = Cup.values()[action.toInt() - 1]

            val x = when (val unavailable = cup.canBuy(water, milk, beans, cups)) {
                Supply.NONE -> {
                    water -= cup.water
                    milk -= cup.milk
                    beans -= cup.beans
                    --cups
                    money += cup.price
                    "I have enough resources, making you a coffee!"
                }
                else -> "Sorry, not enough ${unavailable.name.toLowerCase()}!"
            }
            println(x)
        }
    }

    fun fill(additionalWater: Int, additionalMilk: Int, additionalBeans: Int, additionalCups: Int) {
        water += additionalWater
        milk += additionalMilk
        beans += additionalBeans
        cups += additionalCups
    }

    fun take() {
        println("I gave you \$$money")
        money = 0
    }

    enum class Cup(
        val water: Int,
        val milk: Int,
        val beans: Int,
        val price: Int
    ) {
        Espresso(250, 0, 16, 4),
        Latte(350, 75, 20, 7),
        Cappuccino(200, 100, 12, 6);

        fun canBuy(
            remainingWater: Int,
            remainingMilk: Int,
            remainingBeans: Int,
            remainingCups: Int
        ) =
            when {
                remainingWater < water -> Supply.WATER
                remainingMilk < milk -> Supply.MILK
                remainingBeans < beans -> Supply.BEANS
                remainingCups < 1 -> Supply.CUPS
                else -> Supply.NONE
            }
    }

    enum class Supply {
        NONE, WATER, MILK, BEANS, CUPS
    }
}