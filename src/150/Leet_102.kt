package `150`

class Leet_102 {
    fun permute(nums: IntArray): List<List<Int>> {
        val ans = arrayListOf<List<Int>>()
        getPermute(nums, arrayListOf(), ans)
        return ans
    }

    fun getPermute(nums: IntArray, list: ArrayList<Int>, ans: ArrayList<List<Int>>) {
        var index = 0
        while (index < nums.size) {
            if (list.size == nums.size) {
                val item = arrayListOf<Int>()
                item.addAll(list)
                ans.add(item)
                return
            }
            if (!list.contains(nums[index])) {
                list.add(nums[index])
                getPermute(nums, list, ans)
                list.removeLast()
            }
            index++
        }
    }
}

fun main() {
    val leet102 = Leet_102()
    leet102.permute(intArrayOf(1, 2, 3))
}