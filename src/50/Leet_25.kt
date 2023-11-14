package `50`

class Leet_25 {

    fun isPalindrome(s: String): Boolean {
        var convertStr = ""
        s.forEachIndexed { index, c ->
            if (c.isLetter() || c.isDigit()) {
                convertStr += c.lowercase()
            }
        }
        if (convertStr.isEmpty()) {
            return true
        }
//        var left = 0
//        var right = convertStr.length - 1
//        while (left <= right) {
//            if (convertStr[left] == convertStr[right]) {
//                left++
//                right--
//            } else {
//                return false
//            }
//        }

        return convertStr.equals(convertStr.reversed())
    }
}

fun main() {
    val leet25 = Leet_25()
    print("${leet25.isPalindrome("0P")}")
}