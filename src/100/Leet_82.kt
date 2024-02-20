package `100`

class Leet_82 {

    fun rightSideView(root: TreeNode?): List<Int> {
        if (root == null) {
            return emptyList()
        }
        val queue = ArrayDeque<TreeNode>()
        queue.add(root)

        val levelSizeArr = arrayListOf<Int>()

        while (queue.isNotEmpty()) {
            var levelSize = queue.size
            while (levelSize > 0) {
                val first = queue.removeFirst()
                if (1 == levelSize) {
                    levelSizeArr.add(first.`val`)
                }

                if (null != first.left) {
                    queue.add(first.left!!)
                }

                if (null != first.right) {
                    queue.add(first.right!!)
                }
                levelSize--
            }
        }
        return levelSizeArr
    }
}