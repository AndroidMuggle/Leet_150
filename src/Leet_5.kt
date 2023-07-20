class Leet_5 {
    fun majorityElement(nums: IntArray): Int {
        val map = hashMapOf<Int, Int>()

        nums.forEach {
            map[it] = (map[it] ?: 0) + 1
        }

        var maxCount = 0
        var ret = 0
        map.forEach { (t, u) ->
            if (u >= maxCount) {
                maxCount = u
                ret = t
            }
        }
        return ret
    }

    fun majorityElement1(nums: IntArray): Int {
        nums.sort()
        return nums[nums.size / 2]
    }

    fun majorityElement2(nums: IntArray): Int {
        var candNum = nums[0]
        var count = 1
        nums.forEach {
            if (candNum == it) {
                count++
            } else {
                count--
                if (count == 0) {
                    candNum = it
                    count = 1
                }
            }
        }
        return candNum
    }
}