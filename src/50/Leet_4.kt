package `50`

class Leet_4 {

    fun removeDuplicates(nums: IntArray): Int {
        if (nums.size <= 2) {
            return nums.size
        }
        var index = 0
        var count = 0
        var curNum = nums[0]
        var dupCount = 0
        while (index < nums.size) {
            if (curNum == nums[index]) {
                if (dupCount < 2) {
                    nums[count] = nums[index]
                    count++
                    dupCount++
                }
            } else {
                nums[count] = nums[index]
                curNum = nums[index]
                count++
                dupCount = 1
            }
            index++
        }
        return count
    }
}

fun main() {
    val leet4 = Leet_4()
    leet4.removeDuplicates(intArrayOf(1, 1, 1, 2, 2, 3))
}