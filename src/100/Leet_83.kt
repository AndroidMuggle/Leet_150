package `100`

class Leet_83 {
    fun averageOfLevels(root: TreeNode?): DoubleArray {
        if (root == null) {
            return doubleArrayOf()
        }
        val queue = ArrayDeque<TreeNode>()
        queue.add(root)

        val levelSizeArr = arrayListOf<Double>()

        while (queue.isNotEmpty()) {
            val curLevelSize = queue.size
            var levelSize = queue.size
            var sum = 0.0
            while (levelSize > 0) {
                val first = queue.removeFirst()
                sum += first.`val`

                if (null != first.left) {
                    queue.add(first.left!!)
                }

                if (null != first.right) {
                    queue.add(first.right!!)
                }
                levelSize--
            }
            levelSizeArr.add(sum / curLevelSize)
        }
        return levelSizeArr.toDoubleArray()
    }
}