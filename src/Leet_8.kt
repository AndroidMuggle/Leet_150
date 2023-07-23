class Leet_8 {
    fun maxProfit(prices: IntArray): Int {
        var maxProfit = 0

        var index = 1
        while (index <= prices.size - 1) {
            if (prices[index] > prices[index - 1]) {
                maxProfit += (prices[index] - prices[index - 1])
            }
            index++
        }

        return maxProfit
    }
}