package `50`

class Leet_16 {

    fun trap(height: IntArray): Int {
        var start = height.find {
            it != 0
        } ?: 0

        var startIndex = height.indexOf(start)

        var last = height.findLast {
            it != 0
        } ?: height.size

        var lastIndex = height.lastIndexOf(last)

        val maxHeight = height.maxOf {
            it
        }

        var startHeight = 1
        var count = 0
        while (startHeight < maxHeight + 1) {
            height.forEachIndexed { index, i ->
                if (i < startHeight && index in startIndex..lastIndex) {
                    count++
                }
            }

            startHeight++

            start = height.find { it >= startHeight } ?: -1
            startIndex = height.indexOf(start)

            last = height.findLast { it >= startHeight } ?: -1
            lastIndex = height.lastIndexOf(last)
        }
        return count
    }

//    fun trap1(height: IntArray): Int {
//
//    }
}

fun main() {
    val leet16 = Leet_16()
    print(leet16.trap(intArrayOf(2, 0, 2)))
}