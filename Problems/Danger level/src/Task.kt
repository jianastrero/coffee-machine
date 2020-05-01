enum class DangerLevel {
    LOW,
    MEDIUM,
    HIGH;

    fun getLevel() = ordinal + 1
}