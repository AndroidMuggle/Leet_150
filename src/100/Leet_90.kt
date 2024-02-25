package `100`

class Leet_90 {

    fun solve(board: Array<CharArray>): Unit {

        val flagArr = Array(board.size) {
            BooleanArray(board[0].size)
        }

        val changePair = arrayListOf<Pair<Int, Int>>()

        board.forEachIndexed { row, chars ->
            chars.forEachIndexed { col, c ->
                if (c == 'O' && !flagArr[row][col]) {
                    val indexArr = arrayListOf<Pair<Int, Int>>()
                    val queue = ArrayDeque<Pair<Int, Int>>()
                    val firPair = row to col
                    queue.add(firPair)
                    flagArr[row][col] = true

                    while (queue.isNotEmpty()) {
                        val first = queue.removeFirst()
                        indexArr.add(firPair)
                        val row = first.first
                        val col = first.second

                        if (row - 1 >= 0 && board[row - 1][col] == 'O' && !flagArr[row - 1][col]) {
                            val curPair = row - 1 to col
                            queue.add(curPair)
                            indexArr.add(curPair)
                            flagArr[row - 1][col] = true
                        }

                        if (row + 1 < board.size && board[row + 1][col] == 'O' && !flagArr[row + 1][col]) {
                            val curPair = row + 1 to col
                            queue.add(curPair)
                            indexArr.add(curPair)
                            flagArr[row + 1][col] = true
                        }

                        if (col - 1 >= 0 && board[row][col - 1] == 'O' && !flagArr[row][col - 1]) {
                            val curPair = row to col - 1
                            queue.add(curPair)
                            indexArr.add(curPair)
                            flagArr[row][col - 1] = true
                        }

                        if (col + 1 < board[0].size && board[row][col + 1] == 'O' && !flagArr[row][col + 1]) {
                            val curPair = row to col + 1
                            queue.add(curPair)
                            indexArr.add(curPair)
                            flagArr[row][col + 1] = true
                        }
                    }

                    var flag = false
                    indexArr.forEachIndexed { index, pair ->
                        if (pair.first == 0 || pair.first == board.size - 1 || pair.second == 0 || pair.second == board[0].size - 1) {
                            flag = true
                        }
                    }

                    if (!flag) {
                        changePair.addAll(indexArr)
                    }
                }
            }
        }

        changePair.forEachIndexed { index, pair ->
            board[pair.first][pair.second] = 'X'
        }
    }
}

fun main() {
    val leet_90 = Leet_90()

    leet_90.solve(
        arrayOf(
            charArrayOf('O', 'X', 'O', 'O', 'X', 'X'),
            charArrayOf('O', 'X', 'X', 'X', 'O', 'X'),
            charArrayOf('X', 'O', 'O', 'X', 'O', 'O'),
            charArrayOf('X', 'O', 'X', 'X', 'X', 'X'),
            charArrayOf('O', 'O', 'X', 'O', 'X', 'X'),
            charArrayOf('X', 'X', 'O', 'O', 'O', 'O'),
        )
    )
}