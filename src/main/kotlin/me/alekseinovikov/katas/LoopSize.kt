package me.alekseinovikov.katas

data class Node(val next: Node?)

private val stepSizeMap = mutableMapOf<Node, Int>()
fun loopSize(n: Node): Int {
    var counter = 1
    var next: Node? = n
    while (next != null) {
        if (stepSizeMap.containsKey(next)) {
            return counter - (stepSizeMap[next] ?: 0)
        }

        stepSizeMap[next] = counter
        next = next.next
        counter++
    }

    return 0
}
