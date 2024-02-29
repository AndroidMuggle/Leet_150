package `100`

class Leet_95 {
    fun minMutation(startGene: String, endGene: String, bank: Array<String>): Int {
        if (startGene == endGene) {
            return 0
        }
        var count = 0
        val queue = ArrayDeque<String>()
        bank.forEach {
            var charCount = 0

            it.forEachIndexed { index, c ->
                if (c != startGene[index]) {
                    charCount++
                }
            }

            if (charCount == 1) {
                queue.add(it)
            }
        }

        while (queue.isNotEmpty()) {
            var size = queue.size

            while (size != 0) {
                val curStr = queue.removeFirst()
                if (curStr == endGene) {
                    return count + 1
                }

                bank.forEach {
                    var charCount = 0

                    it.forEachIndexed { index, c ->
                        if (c != curStr[index]) {
                            charCount++
                        }
                    }
                    if (charCount == 1) {
                        queue.add(it)
                    }
                }
                size--
            }
            count++
            if (count > 8) {
                return -1
            }
        }
        return -1
    }
}

fun main() {
    val leet95 = Leet_95()
    leet95.minMutation(
        "AAAAAAAA",
        "CCCCCCCC",
        arrayOf(
            "AAAAAAAA",
            "AAAAAAAC",
            "AAAAAACC",
            "AAAAACCC",
            "AAAACCCC",
            "AACACCCC",
            "ACCACCCC",
            "ACCCCCCC",
            "CCCCCCCA"
        )
    )
}