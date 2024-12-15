package `100`

class Leet_100 {
    fun letterCombinations(digits: String): List<String> {
        if (digits.isNullOrEmpty()) {
            return emptyList()
        }
        val map = hashMapOf<Char, String>().apply {
            put('2', "abc")
            put('3', "def")
            put('4', "ghi")
            put('5', "jkl")
            put('6', "mno")
            put('7', "pqrs")
            put('8', "tuv")
            put('9', "wxyz")
        }

        val queue = ArrayDeque<Char>()
        queue.add(digits[0])
        val list = arrayListOf<String>()
        var index = 0
        while (queue.isNotEmpty() && index < digits.length) {
            val fir = queue.removeFirst()
            if (list.isEmpty()) {
                map[fir]?.forEach {
                    list.add(it.toString())
                }
            } else {
                val temp = arrayListOf<String>()
                temp.addAll(list)
                list.clear()
                map[fir]?.forEach {
                    temp.forEachIndexed { index, s ->
                        list.add(s + it)
                    }
                }
            }
            index++
            if (index<digits.length){
                queue.add(digits[index])
            }
        }
        return list
    }
}

fun main() {
    val leet100 = Leet_100()
    leet100.letterCombinations("23")
}