class Leet_38 {

    fun gameOfLife(board: Array<IntArray>): Unit {
        val temp = Array(board.size) {
            IntArray(board[0].size) {
                0
            }
        }

        board.forEachIndexed { index, ints ->
            ints.forEachIndexed { innerIndex, i ->
                temp[index][innerIndex] = if (getLiveState(i, getList(index, innerIndex, board))) 1 else 0
            }
        }

        temp.forEachIndexed { index, ints ->
            ints.forEachIndexed { innerIndex, i ->
                board[index][innerIndex] = i
            }
        }
    }

    fun getList(row: Int, col: Int, board: Array<IntArray>): List<Int> {
        val result = arrayListOf<Int>()

        if (row - 1 in board.indices && col - 1 in board[0].indices) {
            result.add(board[row - 1][col - 1])
        }

        if (row - 1 in board.indices && col in board[0].indices) {
            result.add(board[row - 1][col])
        }

        if (row - 1 in board.indices && col + 1 in board[0].indices) {
            result.add(board[row - 1][col + 1])
        }

        if (row in board.indices && col - 1 in board[0].indices) {
            result.add(board[row][col - 1])
        }

        if (row in board.indices && col + 1 in board[0].indices) {
            result.add(board[row][col + 1])
        }

        if (row + 1 in board.indices && col - 1 in board[0].indices) {
            result.add(board[row + 1][col - 1])
        }

        if (row + 1 in board.indices && col in board[0].indices) {
            result.add(board[row + 1][col])
        }

        if (row + 1 in board.indices && col + 1 in board[0].indices) {
            result.add(board[row + 1][col + 1])
        }

        return result
    }

    fun getLiveState(curState: Int, list: List<Int>): Boolean {
        var countLive = 0
        list.forEach {
            if (it == 1) {
                countLive++
            }
        }
        return if (curState == 1) {
            return if (countLive < 2) {
                false
            } else countLive == 2 || countLive == 3
        } else {
            countLive == 3
        }
    }
}