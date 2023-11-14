package `50`

class Leet_2 {

    fun removeElement(nums: IntArray, `val`: Int): Int {
        var index = 0
        var count = 0
        while (index < nums.size) {
            if (`val` != nums[index]) {
                nums[count] = nums[index]
                count++
            }
            index++
        }
        return count
    }

    fun removeElement1(nums: IntArray, `val`: Int): Int {
        var start = 0
        var end = nums.size
        while (start < end) {
            if (nums[start] == `val`) {
                nums[start] = nums[end-1]
                end--
            } else {
                start++
            }
        }
        return start
    }
}

fun main() {
    val leet2 = Leet_2()
    leet2.removeElement1(intArrayOf(0, 1, 2, 2, 3, 0, 4, 2), 2)
}