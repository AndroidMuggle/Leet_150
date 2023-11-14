class Leet_44 {

    fun twoSum(nums: IntArray, target: Int): IntArray {
        val map = hashMapOf<Int, Int>()

        nums.forEachIndexed { index, i ->
            map[index] = i
        }

        nums.forEachIndexed { index, i ->
            if (map.containsValue(target - i)) {
                map.forEach {
                    if (it.value == target - i && it.key != index) {
                        return intArrayOf(index, it.key)
                    }
                }
            }
        }
        return intArrayOf()
    }
}