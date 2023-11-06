class Leet_20 {

    fun longestCommonPrefix(strs: Array<String>): String {
        var retStr = strs.first() ?: ""

        strs.forEach {
            if (it.length < retStr.length) {
                retStr = it
            }
        }

        var index = 0
        while (retStr.isNotEmpty() && index < strs.size) {
            if (!strs[index].substring(0, retStr.length).contains(retStr)) {
                retStr = retStr.substring(0, retStr.length - 1)
                index = 0
            } else {
                index++
            }
        }

        return retStr
    }
}

fun main() {
    val leet20 = Leet_20()

    print("${leet20.longestCommonPrefix(arrayOf("flower", "flow", "flight"))}")
}