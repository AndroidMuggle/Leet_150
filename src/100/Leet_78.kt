package `100`

import java.util.*

class Leet_78 {

    fun maxPathSum(root: TreeNode?): Int {
        val stack = Stack<TreeNode>()
        stack.push(root)

        val inorderArr = arrayListOf<TreeNode>()

        while (stack.isNotEmpty()) {
            val top = stack.pop()
            inorderArr.add(top)

            if (null != top.right) {
                stack.push(top.right)
            }

            if (null != top.left) {
                stack.push(top.left)
            }
        }
        return 0
    }
}