class Leet_34 {

    fun isValidSudoku(board: Array<CharArray>): Boolean {
        var result = true

        /**
         * 每一行
         */
        board.forEach {
            val map = hashSetOf<Char>()
            it.forEach { c ->
                if (c != '.' && map.contains(c)) {
                    return false
                } else {
                    map.add(c)
                }
            }
        }

        /**
         * 每一列
         */
        var col = 0
        while (col < 9) {
            val map = hashSetOf<Char>()
            board.forEach {
                if (it[col] != '.' && map.contains(it[col])) {
                    return false
                } else {
                    map.add(it[col])
                }
            }
            col++
        }

        var region = 0

        while (region < 9) {
            val map = hashSetOf<Char>()
            board.forEachIndexed { index, chars ->
                chars.forEachIndexed { innerIndex, c ->
                    if (index / 3 * 3 + innerIndex / 3 == region) {
                        if (c != '.' && map.contains(c)) {
                            return false
                        } else {
                            map.add(c)
                        }
                    }
                }
            }

            region++
        }


        return true
    }
}

fun main() {
    val leet34 = Leet_34()
    print(
        "${
            leet34.isValidSudoku(
                arrayOf(
                    charArrayOf('8', '3', '.', '.', '7', '.', '.', '.', '.'),
                    charArrayOf('6', '.', '.', '1', '9', '5', '.', '.', '.'),
                    charArrayOf('.', '9', '8', '.', '.', '.', '.', '6', '.'),
                    charArrayOf('8', '.', '.', '.', '6', '.', '.', '.', '3'),
                    charArrayOf('4', '.', '.', '8', '.', '3', '.', '.', '1'),
                    charArrayOf('7', '.', '.', '.', '2', '.', '.', '.', '6'),
                    charArrayOf('.', '6', '.', '.', '.', '.', '2', '8', '.'),
                    charArrayOf('.', '.', '.', '4', '1', '9', '.', '.', '5'),
                    charArrayOf('.', '.', '.', '.', '8', '.', '.', '7', '9'),
                )
            )
        }"
    )
}