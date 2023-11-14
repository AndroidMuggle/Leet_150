package `50`

class Leet_17 {

    fun romanToInt(s: String): Int {
        val num = arrayListOf<Int>()
        s.forEachIndexed { index, c ->
            when (c) {
                'I' -> {
                    num.add(1)
                }
                'V' -> {
                    num.add(5)
                }
                'X' -> {
                    num.add(10)
                }
                'L' -> {
                    num.add(50)
                }
                'C' -> {
                    num.add(100)
                }
                'D' -> {
                    num.add(500)
                }
                'M' -> {
                    num.add(1000)
                }
            }
        }

        var ret = 0
        var index = 0
        var flag = true
        while (index < num.size - 1) {
            if (num[index] < num[index + 1]) {
                ret += num[index + 1] - num[index]
                index += 2
                if (index == num.size) {
                    flag = false
                }
                continue
            } else {
                ret += num[index]
                index++
                if (index == num.size) {
                    flag = true
                }
            }
        }
        return ret + if (flag) num[num.size - 1] else 0
    }
}

fun main() {
    val leet17 = Leet_17()
    print("${leet17.romanToInt("MDCXCV")}")
//    print("${leet17.romanToInt("LVIII")}")
}