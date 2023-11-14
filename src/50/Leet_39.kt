package `50`

class Leet_39 {

    fun canConstruct(ransomNote: String, magazine: String): Boolean {
        val map = hashMapOf<Char, Int>()
        magazine.forEach {
            map[it] = map.getOrDefault(it, 0) + 1
        }

        ransomNote.forEach {
            if (map.containsKey(it)) {
                map[it] = map.getOrDefault(it, 0) - 1
            } else {
                return false
            }
        }

        var ret = true
        map.forEach {
            if (it.value < 0) {
                ret = false
            }
        }
        return ret
    }
}