package `150`

class Leet_101 {
    fun combine(n: Int, k: Int): List<List<Int>> {
        val ans = arrayListOf<List<Int>>()
        getCombine(n, k, 1, arrayListOf(), ans)
        return ans
    }

    fun getCombine(n: Int, k: Int, start: Int, list: ArrayList<Int>, ans: ArrayList<List<Int>>) {
        if (k == 0) {
            val item = arrayListOf<Int>()
            item.addAll(list)
            ans.add(item)
            return
        }
        var index = start
        while (index <= n) {
            list.add(index)
            getCombine(n, k - 1, index + 1, list, ans)
            list.removeLast()
            index++
        }
    }
}

fun main() {
    val leet101 = Leet_101()
    leet101.combine(4, 2)
}