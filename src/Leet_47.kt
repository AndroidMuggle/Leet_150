import kotlin.math.max

class Leet_47 {

    /**
     * 解法不满足题意，时间复杂度未满足需求
     */
    fun longestConsecutive(nums: IntArray): Int {
        if (nums.isEmpty()) {
            return 0
        }
        val set = linkedSetOf<Int>()
        nums.forEach {
            set.add(it)
        }
        val list = set.sorted()


        var left = 0
        var right = 1
        var curMaxVal = list[left]
        var result = -1

        while (left < list.size && right < list.size) {
            if (curMaxVal - list[right] == -1) {
                curMaxVal = list[right++]
            } else {
                result = max(result, right - left)
                curMaxVal = list[right]
                left++
                right = left + 1
            }
        }
        return max(result, right - left)
    }
}

fun main() {
    val leet47 = Leet_47()
    print("${leet47.longestConsecutive(intArrayOf(1, 2, 0, 1))}")
}