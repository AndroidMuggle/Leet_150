package `50`

class Leet_9 {
    fun canJump(nums: IntArray): Boolean {
        val flags = BooleanArray(nums.size)
        flags[0] = true
        nums.forEachIndexed { index, i ->
            var loopCount = 1
            while (loopCount <= i && index < flags.size - 1 && flags[index]) {
                if (loopCount + index >= flags.size - 1) {
                    return true
                }
                flags[loopCount + index] = true
                loopCount++
            }
        }
        return flags[flags.size - 1]
    }
}

fun main() {
    val leet9 = Leet_9()
    leet9.canJump(intArrayOf(3, 2, 1, 0, 4))
}