package `100`

class Leet_77 {
    fun sumNumbers(root: TreeNode?): Int {

        val queue = ArrayDeque<TreeNode?>()
        val queueStr = ArrayDeque<String>()

        queue.add(root)
        queueStr.add(if (null == root?.`val`) "" else root.`val`.toString())

        val result = arrayListOf<String>()

        while (queue.isNotEmpty()) {
            val curNode = queue.removeFirst()
            val curStr = queueStr.removeFirst()

            if (curNode?.left == null && curNode?.right == null) {
                result.add(curStr)
            }

            if (curNode?.left != null) {
                queue.add(curNode.left)
                queueStr.add(curStr + if (null == curNode.left?.`val`) "" else curNode.left?.`val`.toString())
            }

            if (curNode?.right != null) {
                queue.add(curNode.right)
                queueStr.add(curStr + if (null == curNode.right?.`val`) "" else curNode.right?.`val`.toString())
            }
        }

        var sum = 0

        result.forEach {
            sum += it.toInt()
        }
        return sum
    }
}

fun main() {
    val leet77 = Leet_77()

    print(leet77.sumNumbers(TreeNode(4).apply {
        left = TreeNode(9).apply {
            left = TreeNode(5)
            right = TreeNode(1)
        }
        right = TreeNode(0)
    }))
}