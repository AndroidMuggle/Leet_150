package `100`

class Leet_85 {

    fun zigzagLevelOrder(root: TreeNode?): List<List<Int>> {
        if (null == root) {
            return emptyList()
        }
        val queue = ArrayDeque<TreeNode>()
        queue.add(root)

        val ret = arrayListOf<List<Int>>()

        var directionFlag = false

        while (queue.isNotEmpty()) {
            var size = queue.size
            val arr = arrayListOf<Int>()
            while (size > 0) {
                val first = queue.removeFirst()

                arr.add(first.`val`)

                if (directionFlag) {
                    if (null != first.left) {
                        queue.add(first.left!!)
                    }
                    if (null != first.right) {
                        queue.add(first.right!!)
                    }
                } else {
                    if (null != first.right) {
                        queue.add(first.right!!)
                    }

                    if (null != first.left) {
                        queue.add(first.left!!)
                    }
                }

                size--
            }
            directionFlag = !directionFlag
            ret.add(arr)
        }
        return ret
    }
}

fun main() {
    val leet85 = Leet_85()
    leet85.zigzagLevelOrder(TreeNode(3).apply {
        left = TreeNode(9)
        right = TreeNode(20).apply {
            left = TreeNode(15)
            right = TreeNode(7)
        }
    })
}