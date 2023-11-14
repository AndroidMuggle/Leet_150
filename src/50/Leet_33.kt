package `50`

class Leet_33 {

    fun minWindow(s: String, t: String): String {
        var minStr = ""
        val map = hashMapOf<Char, Int>()
        t.forEachIndexed { index, c ->
            if (map.containsKey(c)) {
                map[c] = (map[c] ?: 0) + 1
            } else {
                map[c] = 1
            }
        }


        var left = 0
        var right = left + t.length
        var curStr = ""
        while (left < s.length && right <= s.length) {
            curStr = s.substring(left, right)

            val tempMap = map.toMutableMap()

            curStr.forEachIndexed { index, c ->
                if (tempMap.containsKey(c)) {
                    tempMap[c] = (tempMap[c] ?: 0) - 1
                }
            }

            var isFind = true

            tempMap.forEach {
                if (it.value > 0) {
                    isFind = false
                }
            }

            if (isFind) {
                minStr = when {
                    minStr.isEmpty() -> {
                        curStr
                    }
                    minStr.length > curStr.length -> {
                        curStr
                    }
                    else -> {
                        minStr
                    }
                }
                left++
            } else {
                right++
            }
        }

        return minStr
    }
}

fun main() {
    val leet33 = Leet_33()
    print("${leet33.minWindow("ADOBECODEBANC", "ABC")}")
}