package `100`

class Leet_89 {
    fun numIslands(grid: Array<CharArray>): Int {
        var count = 0

        grid.forEachIndexed { outIndex, chars ->
            chars.forEachIndexed { innerIndex, c ->

                if (c == '1') {
                    count++
                    grid[outIndex][innerIndex] = '0'
                    val queue = ArrayDeque<Pair<Int, Int>>()
                    queue.add(outIndex to innerIndex)

                    while (queue.isNotEmpty()) {
                        val first = queue.removeFirst()
                        val row = first.first
                        val col = first.second
                        if (row - 1 >= 0 && grid[row - 1][col] == '1') {
                            queue.add(row - 1 to col)
                            grid[row - 1][col] = '0'
                        }
                        if (row + 1 < grid.size && grid[row + 1][col] == '1') {
                            queue.add(row + 1 to col)
                            grid[row + 1][col] = '0'
                        }

                        if (col - 1 >= 0 && grid[row ][col-1] == '1') {
                            queue.add(row  to col-1)
                            grid[row ][col- 1] = '0'
                        }
                        if (col + 1 < grid[0].size && grid[row ][col+1] == '1') {
                            queue.add(row  to col+1)
                            grid[row ][col+1] = '0'
                        }
                    }
                }
            }
        }
        return count
    }
}