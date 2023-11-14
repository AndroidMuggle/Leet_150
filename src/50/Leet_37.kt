package `50`

class Leet_37 {

    fun setZeroes(matrix: Array<IntArray>): Unit {

        val row = hashSetOf<Int>()
        val col = hashSetOf<Int>()

        matrix.forEachIndexed { index, ints ->
            ints.forEachIndexed { innerIndex, i ->
                if (i == 0) {
                    row.add(index)
                    col.add(innerIndex)
                }
            }
        }

        matrix.forEachIndexed { index, ints ->
            ints.forEachIndexed { innerIndex, i ->
                if (row.contains(index) || col.contains(innerIndex)) {
                    matrix[index][innerIndex] = 0
                }
            }
        }
    }
}