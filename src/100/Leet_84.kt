package `100`

class Leet_84 {
    fun levelOrder(root: TreeNode?): List<List<Int>> {
        if (null == root) {
            return emptyList()
        }
        val queue = ArrayDeque<TreeNode>()
        queue.add(root)

        val ret = arrayListOf<List<Int>>()

        while (queue.isNotEmpty()) {
            var size = queue.size

            val arr = arrayListOf<Int>()
            while (size > 0) {
                val first = queue.removeFirst()

                arr.add(first.`val`)

                if (null != first.left) {
                    queue.add(first.left!!)
                }
                if (null != first.right) {
                    queue.add(first.right!!)
                }
                size--
            }
            ret.add(arr)
        }
        return ret
    }
}