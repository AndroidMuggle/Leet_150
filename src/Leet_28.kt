import kotlin.math.abs
import kotlin.math.max
import kotlin.math.min

class Leet_28 {

    fun maxArea(height: IntArray): Int {
        var left = 0
        var right = height.size - 1
        var ret = abs(left - right) * min(height[left], height[right])

        while (left < right) {

            if (height[left] < height[right]) {
                ret = max(height[left] * (right - left), ret)
                left++
            } else {
                ret = max(height[right] * (right - left), ret)
                right--
            }
        }
        return ret
    }
}