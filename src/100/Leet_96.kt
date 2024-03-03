package `100`

class Leet_96 {
    fun ladderLength(beginWord: String, endWord: String, wordList: List<String>): Int {
        if (!wordList.contains(endWord)) {
            return 0
        }
        var step = 1
        val queue = ArrayDeque<String>()
        val set = hashSetOf<String>()
        wordList.forEach {
            var count = 0
            it.forEachIndexed { index, c ->
                if (c != beginWord[index]) {
                    count++
                }
            }
            if (count == 1 && !set.contains(it)) {
                queue.add(it)
                set.add(it)
            }
        }
        while (queue.isNotEmpty()) {
            var queueSize = queue.size
            while (queueSize != 0) {
                val fir = queue.removeFirst()
                if (fir == endWord) {
                    return step + 1
                } else {
                    wordList.forEach {
                        var count = 0
                        it.forEachIndexed { index, c ->
                            if (c != fir[index]) {
                                count++
                            }
                        }
                        if (count == 1 && !set.contains(it)) {
                            queue.add(it)
                            set.add(it)
                        }
                    }
                }
                queueSize--
            }
            step++
        }
        return 0
    }
}

fun main() {
    val leet96 = Leet_96()
    leet96.ladderLength("hit", "cog", arrayListOf("hot", "dot", "tog", "cog"))
}