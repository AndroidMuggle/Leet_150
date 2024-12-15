package `150`

class Leet_103 {

    fun combinationSum(candidates: IntArray, target: Int): List<List<Int>> {
        val ans = arrayListOf<List<Int>>()
        candidates.sort()
        getCombinationSum(candidates, target, 0, arrayListOf(), ans)
        return ans
    }

    private fun getCombinationSum(
        candidates: IntArray,
        target: Int,
        start: Int,
        list: ArrayList<Int>,
        ans: ArrayList<List<Int>>
    ) {
        var index = start
        while (index < candidates.size) {
            if (target == 0) {
                val item = arrayListOf<Int>()
                item.addAll(list)
                // fixme 去重操作(排序后不需要去重操作)
                if (!isDuplicateAns(ans, list)) {
                    ans.add(item)
                }
                return
            }

            if (target - candidates[index] >= 0) {
                list.add(candidates[index])
                getCombinationSum(candidates, target - candidates[index], index, list, ans)
                list.removeLast()
            }
            index++
        }
    }

    private fun isDuplicateAns(ans: ArrayList<List<Int>>, list: List<Int>): Boolean {
        ans.forEach {
            if (it.size == list.size) {
                return list.containsAll(it)
            }
        }
        return false
    }

}

fun main() {
    val leet103 = Leet_103()
    leet103.combinationSum(intArrayOf(8, 7, 4, 3), 11)
}