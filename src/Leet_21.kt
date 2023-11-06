class Leet_21 {

    fun reverseWords(s: String): String {
        val trimmedStr = s.trim()
        val splitArr = trimmedStr.split(" ")
        val reverseArr = splitArr.filter {
            it.isNotBlank()
        }.reversed()
        return reverseArr.joinToString(" ")
    }
}