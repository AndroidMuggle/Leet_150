package `50`

import kotlin.math.max
import kotlin.math.min

class Leet_50 {
    fun insert(intervals: Array<IntArray>, newInterval: IntArray): Array<IntArray> {

        val result = arrayListOf<IntArray>()
        var newStart = newInterval[0]
        var newEnd = newInterval[1]

        var isInsert = false

        intervals.forEachIndexed { index, ints ->
            val curStart = ints[0]
            val curEnd = ints[1]

            if (newEnd < curStart) {
                if (!isInsert) {
                    result.add(intArrayOf(newStart, newEnd))
                    isInsert = true
                }
                result.add(ints)
            } else if (newStart > curEnd) {
                result.add(ints)
            } else {
                newStart = min(curStart, newStart)
                newEnd = max(curEnd, newEnd)
            }
        }

        if (!isInsert) {
            result.add(intArrayOf(newStart, newEnd))
        }
        return result.toTypedArray()
    }
}

fun main() {
    val leet50 = Leet_50()
    print(
        "${
            leet50.insert(
                arrayOf(
                    intArrayOf(1, 2),
                    intArrayOf(3, 5),
                    intArrayOf(6, 7),
                    intArrayOf(8, 10),
                    intArrayOf(12, 16)
                ), intArrayOf(4, 8)
            )
        }"
    )
}