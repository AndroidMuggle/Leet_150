package `100`

import java.util.*

class Leet_70 {

    fun invertTree(root: TreeNode?): TreeNode? {
        if (null == root) {
            return null
        }

        val stack = Stack<TreeNode?>()

        stack.push(root)

        while (stack.isNotEmpty()) {
            val top = stack.pop()
            val left = top?.left
            top?.left = top?.right
            top?.right = left


            if (null != top?.right) {
                stack.push(top.right)
            }
            if (null != top?.left) {
                stack.push(top.left)
            }
        }
        return root
    }
}

fun main() {
    val leet70 = Leet_70()
    print(
        "${
            leet70.invertTree(
                TreeNode(4).apply {
                    left = TreeNode(2).apply {
                        left = TreeNode(1)
                        right = TreeNode(3)
                    }
                    right = TreeNode(7).apply {
                        left = TreeNode(6)
                        right = TreeNode(9)
                    }
                }
            )
        }"
    )
}