class Leet_13 {
    fun productExceptSelf(nums: IntArray): IntArray {
        val answer = IntArray(nums.size)

        val left = IntArray(nums.size)
        val right = IntArray(nums.size)

        left[0] = 1

        nums.forEachIndexed { index, i ->
            if (index > 0) {
                left[index] = nums[index - 1] * left[index - 1]
            }
        }

        right[nums.size - 1] = 1

        var index = nums.size - 2

        while (index >= 0) {
            right[index] = right[index + 1] * nums[index + 1]
            index--
        }

        answer.forEachIndexed { index, i ->
            answer[index] = left[index] * right[index]
        }
        return answer
    }
}