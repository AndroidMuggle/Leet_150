package `50`

class Leet_27 {

    fun twoSum(numbers: IntArray, target: Int): IntArray {
        val map = hashMapOf<Int, Int>()
        numbers.forEachIndexed { index, i ->
            map[index] = i
        }

        numbers.forEachIndexed { index, i ->
            if (map.containsValue(target - i)) {
                return intArrayOf(index + 1, numbers.lastIndexOf(target - i) + 1)
            }
        }
        return intArrayOf()
    }

    fun twoSum1(numbers: IntArray, target: Int): IntArray {
        var left = 0
        var right = numbers.size - 1

        while (left < right) {
            val sum = numbers[left] + numbers[right]
            if (sum < target) {
                left++
            } else if (sum > target) {
                right--
            } else {
                return intArrayOf(left + 1, right + 1)
            }
        }

        return intArrayOf()
    }
}