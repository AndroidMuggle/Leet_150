package `100`

import java.util.*
import kotlin.math.max

class Leet_51 {

    fun findMinArrowShots(points: Array<IntArray>): Int {
        Arrays.sort(points) { o1, o2 ->
            o1[0] - o2[0]
        }
        val result = arrayListOf<IntArray>()
        result.add(points[0])
        var isCurrentMerged = false

        points.forEachIndexed { index, ints ->
            if (index == 0) {
                return@forEachIndexed
            }
            val curStart = ints[0]
            val curEnd = ints[1]
            if (result[result.size - 1][1] < curStart) {
                result.add(ints)
                isCurrentMerged = false
            } else if (result[result.size - 1][0] < curEnd) {
                result.add(result.size - 1, ints)
                isCurrentMerged = false
            } else {
                if (isCurrentMerged) {
                    result.add(ints)
                    isCurrentMerged = false
                } else {
                    result[result.size - 1][1] = max(result[result.size - 1][1], curEnd)
                    isCurrentMerged = true
                }
            }
        }
        return result.size
    }

    fun findMinArrowShots1(points: Array<IntArray>): Int {

        Arrays.sort(points) { o1, o2 ->
            if (o1[1] < o2[1]) -1 else 1
        }
        var result = 1
        var pre = points[0][1]

        points.forEach {
            if (it[0] > pre) {
                result++
                pre = it[1]
            }
        }
        return result
    }
}

fun main() {
    val leet51 = Leet_51()
    print(
        "${
            leet51.findMinArrowShots(
                arrayOf(
                    intArrayOf(-2147483646, -2147483645),
                    intArrayOf(2147483646, 2147483647),
//                    intArrayOf(3, 4),
//                    intArrayOf(4, 5)
                )
            )
        }"
    )
}