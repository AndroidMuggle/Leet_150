package `50`

class Leet_15 {
    fun candy(ratings: IntArray): Int {
        var index = 1
        var count = 0
        while (index < ratings.size) {
            if (ratings[index - 1] != ratings[index]) {
                count++
            }
            index++
        }
        return ratings.size + count
    }
}

fun main() {
    val leet15 = Leet_15()
    print(leet15.candy(intArrayOf(1,3,2,2,1)))
}