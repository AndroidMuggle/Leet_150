package `50`

class Leet_41 {

    fun wordPattern(pattern: String, s: String): Boolean {
        val splitArr = s.split(' ')
        if (pattern.length != splitArr.size) {
            return false
        }

        val map = hashMapOf<Char, String>()

        pattern.forEachIndexed { index, c ->
            if (!map.containsKey(c) && !map.containsValue(splitArr[index])) {
                map[c] = splitArr[index]
            }
        }

        val temp = arrayListOf<String>()
        pattern.forEach {
            temp.add(map.getOrDefault(it, ""))
        }

        return temp.joinToString(" ") == s
    }
}

fun main(){
    val leet41 = Leet_41()
    print("${leet41.wordPattern("abba","dog cat cat dog")}")
}