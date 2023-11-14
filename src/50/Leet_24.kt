package `50`

class Leet_24 {

    fun fullJustify(words: Array<String>, maxWidth: Int): List<String> {
        val ret = ArrayList<String>()
        val curStrArr = ArrayList<String>()
        var curLineLength = 0
        words.forEachIndexed { index, str ->
            if (curLineLength + curStrArr.size + str.length <= maxWidth) {
                curLineLength += str.length
                curStrArr.add(str)
            } else {
                if (curStrArr.size > 1) {
                    val space = (maxWidth - curLineLength) / (curStrArr.size - 1)
                    var spare = (maxWidth - curLineLength) % (curStrArr.size - 1)
                    var concatStr = ""
                    curStrArr.forEachIndexed { index, s ->
                        val spaceStr = Array(space + if (spare != 0) 1 else 0) {
                            ' '
                        }.joinToString("")
                        concatStr += s
                        if (index != curStrArr.size - 1) {
                            concatStr += spaceStr
                        }
                        if (spare != 0) {
                            spare--
                        }
                    }
                    ret.add(concatStr)
                } else {
                    val lastString = curStrArr.joinToString(" ")
                    val concatSpace = Array(maxWidth - lastString.length) {
                        ' '
                    }.joinToString("")
                    ret.add(lastString + concatSpace)
                }

                curStrArr.clear()
                curStrArr.add(str)
                curLineLength = str.length
            }
        }
        if (curStrArr.isNotEmpty()) {
            val lastString = curStrArr.joinToString(" ")
            val concatSpace = Array(maxWidth - lastString.length) {
                ' '
            }.joinToString("")
            ret.add(lastString + concatSpace)
        }
        return ret
    }
}

fun main() {
    val leet24 = Leet_24()
    print("${leet24.fullJustify(arrayOf("This", "is", "an", "example", "of", "text", "justification."), 16)}")
}