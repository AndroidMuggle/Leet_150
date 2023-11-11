class Leet_35 {

    fun spiralOrder(matrix: Array<IntArray>): List<Int> {
        val recordArr = Array(matrix.size) {
            BooleanArray(matrix[0].size) {
                false
            }
        }
        val result = arrayListOf<Int>()

        var col = 0
        var row = 0

        /**
         * 方向：0：向右；1：向下；2：向左；3：向上
         */
        var drec = 0
        var count = matrix.size * matrix[0].size

        while (row < matrix.size && col < matrix[0].size) {
            result.add(matrix[row][col])
            recordArr[row][col] = true
            count--
            if (count == 0
            ) {
                return result
            }
            when (drec) {
                0 -> {
                    if ((col + 1 < matrix[0].size && recordArr[row][col + 1]) || col == matrix[0].size - 1) {
                        drec = 1
                        row++
                    } else {
                        col++
                    }
                }
                1 -> {
                    if ((row + 1 < matrix.size && recordArr[row + 1][col]) || row == matrix.size - 1) {
                        drec = 2
                        col--
                    } else {
                        row++
                    }
                }
                2 -> {
                    if ((col - 1 >= 0 && recordArr[row][col - 1]) || col == 0) {
                        drec = 3
                        row--
                    } else {
                        col--
                    }
                }
                3 -> {
                    if ((row - 1 >= 0 && recordArr[row - 1][col]) || row == 0) {
                        drec = 0
                        col++
                    } else {
                        row--
                    }
                }
            }
        }
        return result
    }
}

fun main() {
    val leet35 = Leet_35()
    print("${leet35.spiralOrder(arrayOf(intArrayOf(1, 2, 3), intArrayOf(4, 5, 6), intArrayOf(7, 8, 9)))}")
}