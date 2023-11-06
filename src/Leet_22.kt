class Leet_22 {

    fun convert(s: String, numRows: Int): String {

        if (numRows == 1) {
            return s
        }
        val retStrArr = arrayListOf<String>()
        var strIndex = 0
        var flag = false
        while (strIndex < s.length) {
            var curColStr: String
            if (retStrArr.size % (numRows - 1) == 0) {
                val start = if (flag) strIndex + 1 else strIndex
                curColStr = s.substring(
                    start,
                    if (start + numRows < s.length) start + numRows else s.length
                )
                strIndex += (numRows + if (flag) 0 else -1)
            } else {
                ++strIndex
                val arr = Array(numRows) {
                    if (it == (numRows - 1 - retStrArr.size % (numRows - 1)) && strIndex < s.length) {
                        s[strIndex]
                    } else {
                        ' '
                    }
                }
                curColStr = arr.joinToString("")
            }
            retStrArr.add(curColStr)
            if (retStrArr.size % (numRows - 1) == 0) {
                flag = true
            }
        }
        var retStr = ""
        var index = 0
        while (index < numRows) {
            retStrArr.forEachIndexed { i, itemS ->
                if (itemS.length > index && !itemS[index].isWhitespace()) {
                    retStr += itemS[index]
                }
            }
            index++
        }

        return retStr
    }
}

fun main() {
    val leet22 = Leet_22()
    print("${leet22.convert("PAYPALISHIRING", 3)}")
}