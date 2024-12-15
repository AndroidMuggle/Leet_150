package `100`

class Leet_99 {

    fun findWords(board: Array<CharArray>, words: Array<String>): List<String> {

        val hashSet = hashSetOf<String>()
        val visitArray = Array(board.size) {
            BooleanArray(board[0].size)
        }
        board.forEachIndexed { outIndex, chars ->
            chars.forEachIndexed { innerIndex, c ->
                val queue = ArrayDeque<Char>()
                var curStr = ""
                queue.add(c)
                while (queue.isNotEmpty() && curStr.length < 10) {
                    // fixme 使用层序遍历做这题
                    val firChar = queue.removeFirst()
                    if (!curStr.contains(firChar)) {
                        curStr += firChar
                    }

                    if (outIndex - 1 >= 0 && !curStr.contains(board[outIndex - 1][innerIndex]) && !visitArray[outIndex - 1][innerIndex]) {
                        queue.add(board[outIndex - 1][innerIndex])
                        visitArray[outIndex - 1][innerIndex] = true
                    }
                    if (outIndex + 1 < board.size && !curStr.contains(board[outIndex + 1][innerIndex]) && !visitArray[outIndex + 1][innerIndex]) {
                        queue.add(board[outIndex + 1][innerIndex])
                        visitArray[outIndex + 1][innerIndex] = true
                    }

                    if (innerIndex - 1 >= 0 && !curStr.contains(board[outIndex][innerIndex - 1]) && !visitArray[outIndex][innerIndex - 1]) {
                        queue.add(board[outIndex][innerIndex - 1])
                        visitArray[outIndex][innerIndex - 1] = true
                    }
                    if (innerIndex + 1 < board[0].size && !curStr.contains(board[outIndex][innerIndex + 1]) && !visitArray[outIndex][innerIndex + 1]) {
                        queue.add(board[outIndex][innerIndex + 1])
                        visitArray[outIndex][innerIndex + 1] = true
                    }
                }
                hashSet.add(curStr)
                visitArray.forEachIndexed { i, booleans ->
                    booleans.forEachIndexed { j, b ->
                        visitArray[i][j] = false
                    }
                }
            }
        }

        val trie = Trie()
        hashSet.forEach {
            trie.insert(it)
        }

        val result = arrayListOf<String>()
        words.forEach {
            if (trie.startsWith(it)) {
                result.add(it)
            }
        }

        return result
    }
}

fun main() {
    val leet99 = Leet_99()
    leet99.findWords(
        arrayOf(
            charArrayOf('o', 'a', 'a', 'n'),
            charArrayOf('e', 't', 'a', 'e'),
            charArrayOf('i', 'h', 'k', 'r'),
            charArrayOf('i', 'f', 'l', 'v')
        ), arrayOf("oath", "pea", "eat", "rain")
    )
}