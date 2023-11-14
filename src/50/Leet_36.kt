package `50`

class Leet_36 {

    fun rotate(matrix: Array<IntArray>): Unit {
        val temp = Array(matrix.size) {
            matrix[it].clone()
        }

        temp.forEachIndexed { index, ints ->
            ints.forEachIndexed { innerIndex, i ->
                matrix[innerIndex][matrix.size - 1 - index] = temp[index][innerIndex]
            }
        }
    }
}