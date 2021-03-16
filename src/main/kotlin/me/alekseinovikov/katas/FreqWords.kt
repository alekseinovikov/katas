package me.alekseinovikov.katas

fun top3(s: String): List<String> {
    val re = Regex("[^A-Za-z ']")
    return s.replace(re, " ")
        .toLowerCase()
        .split(" ")
        .filter { it.isNotEmpty() && it.replace("'", "").isNotEmpty() }
        .groupingBy { it }
        .eachCount()
        .entries
        .asSequence()
        .sortedByDescending { it.value }
        .map { it.key }
        .take(3)
        .toList()
}
