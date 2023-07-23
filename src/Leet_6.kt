class Leet_6 {

    fun rotate(nums: IntArray, k: Int): Unit {
        val time = k % nums.size
        val subArray = IntArray(time)
        var tailIndex = 0
        nums.forEachIndexed { index, i ->
            if (index >= nums.size - time) {
                subArray[tailIndex] = i
                tailIndex++
            }
        }
        var index = nums.size - 1
        while (index > time - 1) {
            nums[index] = nums[index - time]
            index--
        }

        var headIndex = 0
        while (headIndex < time) {
            nums[headIndex] = subArray[headIndex]
            headIndex++
        }
    }
}

fun main() {
    val leet7 = Leet_6()
    val nums = intArrayOf(-1, -100, 3, 99)
    leet7.rotate(nums, 2)
    nums.forEach {
        print("$it\n")
    }
}
