package me.alekseinovikov.katas

fun orderWeight(string: String): String = string
    .split(" ")
    .asSequence()
    .filter { it.isNotEmpty() }
    .sortedWith(compareBy({ it.toIntSum() }, { it }))
    .joinToString(" ")

private fun String.toIntSum(): Int =
    this.split("")
        .filter { it.isNotEmpty() }
        .map { it.toInt() }
        .sum()
