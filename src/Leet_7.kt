import kotlin.math.max
import kotlin.math.min

class Leet_7 {

    fun maxProfit(prices: IntArray): Int {
        var maxProfit = 0
        prices.forEachIndexed { index, i ->
            val startIndex = index
            var endIndex = startIndex + 1
            while (endIndex < prices.size) {
                if (prices[endIndex] - prices[startIndex] > maxProfit) {
                    maxProfit = prices[endIndex] - prices[startIndex]
                }
                endIndex++
            }
        }
        return maxProfit
    }

    fun maxProfit1(prices: IntArray): Int {
        var maxProfit = 0
        val dp = IntArray(prices.size)
        dp[0] = prices[0]
        prices.forEachIndexed { index, i ->
            if (index > 0) {
                dp[index] = min(dp[index - 1], i)
                maxProfit = max(i - dp[index], maxProfit)
            }
        }
        return maxProfit
    }
}

fun main() {
    val leet8 = Leet_7()
    val prices = intArrayOf(7,1,5,3,6,4)
    print("${leet8.maxProfit1(prices)}")
}