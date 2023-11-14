package `50`

class Leet_3 {

    fun removeDuplicates(nums: IntArray): Int {
        if (nums.isEmpty()) {
            return 0
        }
        var index = 0
        var count = 1
        var curNum = nums[0]
        while (index < nums.size) {
            if (curNum != nums[index]) {
                nums[count] = nums[index]
                curNum = nums[index]
                count++
            }
            index++
        }
        return count
    }
}