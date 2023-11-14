package `50`

class Leet_48 {

    fun summaryRanges(nums: IntArray): List<String> {
        if (nums.isEmpty()) {
            return emptyList()
        }
        if (nums.size == 1) {
            return listOf(nums[0].toString())
        }
        val rangeList = arrayListOf<Pair<Int, Int>>()

        var left = 0
        var right = 1

        var curNum = nums[left]

        while (left < nums.size && right < nums.size) {
            if (nums[right] - curNum == 1) {
                curNum = nums[right]
                right++
                if (right == nums.size) {
                    rangeList.add(nums[left] to nums[right - 1])
                }
            } else {
                rangeList.add(nums[left] to nums[right - 1])
                left = right
                curNum = nums[left]
                right = left + 1
                if (left + 1 == nums.size) {
                    rangeList.add(nums[left] to nums[left])
                }
            }
        }

        val result = arrayListOf<String>()
        rangeList.forEach {
            if (it.first == it.second) {
                result.add(it.first.toString())
            } else {
                result.add("${it.first}->${it.second}")
            }
        }
        return result
    }
}

fun main() {
    val leet48 = Leet_48()
    print("${leet48.summaryRanges(intArrayOf(0, 2, 3, 4, 6, 8, 9))}")
}