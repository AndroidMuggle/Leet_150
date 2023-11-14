package `50`

class Leet_29 {

    /**
     * 暴力解法超时了
     */
    fun threeSum(nums: IntArray): List<List<Int>> {
        val ret = arrayListOf<ArrayList<Int>>()
        val map = hashMapOf<Int, Int>()

        val mapForRepeat = hashMapOf<String, String>()
        nums.sort()
        nums.forEachIndexed { index, i ->
            map[index] = i
        }

        var left = 0
        var right = 1

        while (left < nums.size - 1) {
            if (nums[left] > 0) {
                left++
                right = left + 1
                continue
            }
            while (right < nums.size) {
                if (map.containsValue(-(nums[left] + nums[right]))) {
                    val index = nums.lastIndexOf(-(nums[left] + nums[right]))
                    val sortArray = arrayListOf<Int>().apply {
                        add(nums[left])
                        add(nums[right])
                        add(nums[index])
                        sort()
                    }
                    if (index > 0 && index > right && !mapForRepeat.containsValue(sortArray.joinToString("-"))) {
                        ret.add(sortArray)
                        mapForRepeat[sortArray.joinToString("-")] = sortArray.joinToString("-")
                    }
                }
                right++
            }
            left++
            right = left + 1
        }

        return ret
    }
}

fun main() {
    val leet29 = Leet_29()

    print("${leet29.threeSum(intArrayOf(3, 0, -2, -1, 1, 2))}")
}