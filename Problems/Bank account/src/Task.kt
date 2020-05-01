import kotlin.math.abs

class BankAccount(
    val deposited: Long,
    val withdrawn: Long
) {

    val balance = abs(deposited - withdrawn)
}