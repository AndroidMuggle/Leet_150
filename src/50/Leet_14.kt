package `50`

class Leet_14 {

    fun canCompleteCircuit(gas: IntArray, cost: IntArray): Int {

        var startIndex = 0


        while (startIndex < gas.size) {

            val startGas = IntArray(gas.size) {
                gas[it]
            }.apply {
                reverse()
                reverse(0, startIndex)
                reverse(startIndex, this.size)
            }

            val costGas = IntArray(gas.size) {
                cost[it]
            }.apply {
                reverse()
                reverse(0, startIndex)
                reverse(startIndex, this.size)
            }

            var remain = startGas[0]
            var i = 0
            var canComplete = true
            while (i < startGas.size - 1) {

                remain = if (remain < costGas[i] || remain < 0) {
                    canComplete = false
                    break
                } else {
                    remain - costGas[i] + startGas[i + 1]
                }

                i++
            }

            if (remain - costGas[costGas.size - 1] < 0) {
                canComplete = false
            }

            if (canComplete) {
                return gas.size - startIndex
            }

            startIndex++
        }
        return -1
    }
}

fun main() {
    val leet14 = Leet_14()
    print("retcode = ${leet14.canCompleteCircuit(intArrayOf(1, 2, 3, 4, 5), intArrayOf(3, 4, 5, 1, 2))}")
}