package `100`

class Leet_81 {

    fun lowestCommonAncestor(root: TreeNode?, p: TreeNode?, q: TreeNode?): TreeNode? {
        if (null == root) {
            return null
        }
        val queue = ArrayDeque<TreeNode>()
        queue.add(root)

        var curLevel = 0
        var qLevel = 0
        var pLevel = 0

        val levelSizeArr = arrayListOf<Int>()

        while (queue.isNotEmpty()) {
            var levelSize = queue.size
            levelSizeArr.add(levelSize)
            while (0 != levelSize) {
                val first = queue.removeFirst()
                if (first == p) {
                    pLevel = curLevel
                }

                if (first == q) {
                    qLevel = curLevel
                }

                if (null != first.left) {
                    queue.add(first.left!!)
                }

                if (null != first.right) {
                    queue.add(first.right!!)
                }
                --levelSize
            }
            curLevel++
        }

        return null
    }
}