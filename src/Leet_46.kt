import kotlin.math.abs

class Leet_46 {

    /**
     * 写法超时
     */
    fun containsNearbyDuplicate(nums: IntArray, k: Int): Boolean {
        val map = hashMapOf<Int, Int>()

        nums.forEachIndexed { index, i ->
            if (map.containsValue(i)) {
                map[index] = i
                map.forEach {
                    if (i == it.value && index != it.key && abs(it.key - index) <= k) {
                        return true
                    }
                }
            } else {
                map[index] = i
            }
        }
        return false
    }

    /**
     *
     */
    fun containsNearbyDuplicate1(nums: IntArray, k: Int): Boolean {
        val map = hashMapOf<Int, Int>()
        nums.forEachIndexed { index, i ->
            if (map.containsKey(i) && abs(index - map[i]!!) < k) {
                return true
            }
            map[i] = index
        }
        return false
    }
}

fun main() {
    val leet46 = Leet_46()
    print("${leet46.containsNearbyDuplicate(intArrayOf(1, 2, 3, 1, 2, 3), 2)}")
}