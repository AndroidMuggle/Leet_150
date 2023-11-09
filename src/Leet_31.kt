import kotlin.math.max

class Leet_31 {

    fun lengthOfLongestSubstring(s: String): Int {
        if (s.isEmpty() || s.length == 1) {
            return s.length
        }
        var result = 1

        var left = 0
        var right = 1

        val set = hashSetOf<Char>()
        set.add(s[left])
        while (left < s.length - 1 && right < s.length) {
            if (set.contains(s[right])) {
                set.remove(s[left])
                left++
            } else {
                set.add(s[right])
                result = max(result, set.size)
                right++
            }
        }

        return result
    }
}