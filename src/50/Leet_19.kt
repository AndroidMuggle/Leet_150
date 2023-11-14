package `50`

class Leet_19 {

    fun lengthOfLastWord(s: String): Int {
        val trim = s.trim()
        val splitArr = trim.split(' ')
        return splitArr[splitArr.size - 1].length
    }
}

fun main(){
    val a = Leet_19()
    print("${a.lengthOfLastWord("   fly me   to   the moon  ")}")
}