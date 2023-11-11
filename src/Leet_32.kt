class Leet_32 {

    fun findSubstring(s: String, words: Array<String>): List<Int> {
        val result = listOf<Int>()

        val subStrLength = words.size * words[0].length
        val map = hashMapOf<Int, String>()
        words.forEachIndexed { index, s ->
            map[index] = s
        }

        var left = 0
        var right = left + subStrLength

        while (left < s.length && right < s.length) {
            val subStr = s.substring(left, right)
            val useArr = Array<Boolean>(words.size) {
                false
            }
            var startIndex = 0
            while (startIndex < subStr.length) {
                val str = subStr.substring(startIndex, startIndex + words[0].length)
                if (map.containsValue(str)) {

                }
            }

        }

        return result
    }

    fun findSubstring1(s: String, words: Array<String>): List<Int> {
        val result = arrayListOf<Int>()
        val subStrLength = words.size * words[0].length

        var left = 0
        var curStr = ""
        while (left < s.length) {
            curStr += s[left]
            if (curStr.length == subStrLength) {
                // 这个实现有问题，会导致输入为"ababaab", arrayOf("ab", "ba", "ba")时判断异常
                var temp = curStr.substring(0, subStrLength)
                words.forEachIndexed { index, word ->
                    val replaceIndex = temp.indexOf(word)
                    if (temp.contains(word) && replaceIndex % words[0].length == 0) {
                        temp = temp.replaceFirst(
                            word,
                            Array(words[0].length) { ' ' }.joinToString("")
                        )
                    }
                }


                var isFind = true
                temp.forEach {
                    if (it != ' ') {
                        isFind = false
                    }
                }
                if (isFind) {
                    result.add(left - subStrLength + 1)
                }
                curStr = curStr.substring(1, curStr.length)
            }
            left++
        }

        return result
    }
}

fun main() {
    val leet32 = Leet_32()
    print("${leet32.findSubstring1("ababaab", arrayOf("ab", "ba", "ba"))}")
}