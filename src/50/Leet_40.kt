package `50`

class Leet_40 {

    fun isIsomorphic(s: String, t: String): Boolean {
        val smap = hashMapOf<Char, Char>()

        s.forEachIndexed { index, c ->
            if (!smap.containsKey(c)&&!smap.containsValue(t[index]) ) {
                smap[c] = t[index]
            }
        }

        var temp = ""
        s.forEach {
            if (smap.containsKey(it)) {
                temp += smap[it]
            } else if (smap.containsValue(it)) {
                smap.forEach { entry ->
                    if (entry.value == it) {
                        temp += entry.key
                    }
                }
            }
        }

        return temp == t
    }
}

fun main() {
    val leet40 = Leet_40()

    print("${leet40.isIsomorphic("badc", "baba")}")
//    print("${leet40.isIsomorphic("foo", "bar")}")
}