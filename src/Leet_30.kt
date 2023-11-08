import kotlin.math.max
import kotlin.math.min

class Leet_30 {

    /**
     * 暴力搜索解法超时
     */
    fun minSubArrayLen(target: Int, nums: IntArray): Int {
        var maxLength = -1
        var startIndex = 0
        var winSize = 1

        while (winSize <= nums.size && startIndex + winSize <= nums.size) {
            val subArray = nums.sliceArray(IntRange(startIndex, startIndex + winSize - 1))

            var sum = 0
            subArray.forEach { i ->
                sum += i
            }
            if (sum >= target) {
                maxLength = if (maxLength < 0) {
                    max(maxLength, subArray.size)
                } else {
                    min(maxLength, subArray.size)
                }
            }

            if (startIndex + winSize == nums.size) {
                startIndex = 0
                winSize++
            } else {
                startIndex++
            }
        }

        return if (maxLength == -1) 0 else maxLength
    }

    fun minSubArrayLen1(target: Int, nums: IntArray): Int {
        var minLength = -1

        var left = 0
        var right = 0
        var sum = 0

        while (right < nums.size) {
            sum += nums[right++]
            while (sum >= target) {
                minLength = if (minLength > 0) {
                    min(minLength, right - left)
                } else {
                    right - left
                }
                sum -= nums[left++]
            }

        }
        return if (minLength == -1) 0 else minLength
    }
}

fun main() {
    val leet30 = Leet_30()
    print("${leet30.minSubArrayLen(15, intArrayOf(5, 1, 3, 5, 10, 7, 4, 9, 2, 8))}")
}