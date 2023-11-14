package `50`

class Leet_11 {

    fun hIndex(citations: IntArray): Int {
        val sorted = citations.sorted()

        var count = 0
        sorted.forEachIndexed { index, i ->
            if (i < sorted.size - index) {
                count++
            }
        }
        return sorted.size - count
    }
}

fun main() {
    val leet11 = Leet_11()
    print("maxH = ${leet11.hIndex(intArrayOf(100))}")
}