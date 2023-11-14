class Leet_45 {

    fun isHappy(n: Int): Boolean {
        val set = hashSetOf<Int>()
        var temp = n
        while (temp != 1) {
            temp = getSum(temp)
            if (!set.add(temp)) {
                return false
            }
        }
        return true
    }

    fun getSum(n: Int): Int {
        var temp = n
        var sum = 0
        while (temp > 0) {
            val bit = temp % 10
            sum += bit * bit
            temp /= 10
        }
        return sum
    }
}