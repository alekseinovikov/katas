package me.alekseinovikov.katas

object TimeFormatter {

    private val second = 1
    private val minute = second * 60
    private val hour = minute * 60
    private val day = hour * 24
    private val year = day * 365

    fun formatDuration(seconds: Int): String {
        if (seconds <= 0) return "now"

        val years = getPeriod(seconds, "year", year)
        val days = getPeriod(years.second, "day", day)
        val hours = getPeriod(days.second, "hour", hour)
        val minutes = getPeriod(hours.second, "minute", minute)
        val seconds = getPeriod(minutes.second, "second", second)

        val list = listOf(years, days, hours, minutes, seconds)
        val lastValue = list.mapNotNull { it.first }.last()

        val firstPart = list
            .mapNotNull { it.first }
            .takeWhile { it != lastValue }
            .joinToString(", ")

        if (firstPart.isEmpty()) return lastValue

        return "$firstPart and $lastValue"
    }

    private fun getPeriod(seconds: Int, name: String, period: Int): Pair<String?, Int> {
        if (seconds < period) return Pair(null, seconds)
        if (seconds == period) return Pair("1 $name", 0)

        val part: Int = seconds / period
        val reminder: Int = seconds % period

        val suffix = if (part == 1) name else name + "s"
        val answer = "$part $suffix"

        return Pair(answer, reminder)
    }
}
