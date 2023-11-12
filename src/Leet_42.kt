class Leet_42 {

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