package `50`

class Leet_43 {

    fun groupAnagrams(strs: Array<String>): List<List<String>> {
        val result = arrayListOf<ArrayList<String>>()
        val record = BooleanArray(strs.size) {
            false
        }

        strs.forEachIndexed { index, s ->
            val list = arrayListOf<String>()
            if (!record[index]) {
                list.add(s)
                record[index] = true
            }
            strs.forEachIndexed { innerIndex, innerStr ->
                if (index != innerIndex && !record[innerIndex] && isAnagram(s, innerStr)) {
                    list.add(innerStr)
                    record[innerIndex] = true
                }
            }
            if (list.isNotEmpty()){
                result.add(list)
            }
        }
        return result
    }

    fun isAnagram(s: String, t: String): Boolean {
        if (s.length != t.length) {
            return false
        }
        val smap = hashMapOf<Char, Int>()
        val tmap = hashMapOf<Char, Int>()

        s.forEach {
            smap[it] = smap.getOrDefault(it, 0) + 1
        }

        t.forEach {
            tmap[it] = tmap.getOrDefault(it, 0) + 1
        }

        smap.forEach {
            if (!tmap.containsKey(it.key) || tmap[it.key] != it.value) {
                return false
            }
        }
        return true
    }
}