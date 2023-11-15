package `50`

import java.util.*
import kotlin.math.max

class Leet_49 {

    /**
     * 暴力解法，考虑双指针
     */
    fun merge(intervals: Array<IntArray>): Array<IntArray> {
        if (intervals.size == 1) {
            return intervals
        }


        Arrays.sort(intervals) { o1, o2 ->
            o1[0] - o2[0]
        }
        val list = arrayListOf<IntRange>()
        val map = HashMap<Int, IntRange>()
        intervals.forEachIndexed { index, ints ->
            list.add(IntRange(ints[0], ints[1]))
            map[index] = IntRange(ints[0], ints[1])
        }


        var index = 0

        while (index < intervals.size) {
            if (!map.containsKey(index)) {
                index++
                continue
            }
            var curInterval = list[index]

            list.forEachIndexed { innerIndex, intRange ->
                if (curInterval.overlap(intRange)) {
                    curInterval = curInterval.merge(intRange)
                    map.remove(index)
                    map.remove(innerIndex)
                    if (!map.containsValue(curInterval)) {
                        map[index] = curInterval
                    }
                }
            }
            index++
        }
        val result = arrayListOf<IntArray>()
        map.forEach {
            result.add(intArrayOf(it.value.first, it.value.last))
        }

        return result.toTypedArray()
    }

    private fun IntRange.overlap(other: IntRange): Boolean {
        return this.contains(other.first) ||
                this.contains(other.last) ||
                other.contains(first) ||
                other.contains(last)
    }

    private fun IntRange.merge(other: IntRange): IntRange {
        return IntRange(kotlin.math.min(first, other.first), kotlin.math.max(last, other.last))
    }

    fun merge1(intervals: Array<IntArray>): Array<IntArray> {
        val result = arrayListOf<IntArray>()
        result.add(intervals[0])
        Arrays.sort(intervals) { o1, o2 ->
            o1[0] - o2[0]
        }
        intervals.forEachIndexed { index, ints ->
            val curStart = ints[0]
            val curEnd = ints[1]

            if (result[result.size - 1][1] < curStart) {
                result.add(ints)
            } else {
                result[result.size - 1][1] = max(curEnd, result[result.size - 1][1])
            }
        }
        return result.toTypedArray()
    }
}

fun main() {
    val leet49 = Leet_49()

    print(
        "${
            leet49.merge1(
                arrayOf(
                    intArrayOf(1, 3),
                    intArrayOf(2, 6),
                    intArrayOf(8, 10),
                    intArrayOf(15, 18),
                    intArrayOf(7, 17),
                )
            )
        }"
    )
}