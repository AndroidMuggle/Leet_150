package `100`

import java.util.*
import kotlin.math.max

class Leet_68 {

    fun maxDepth(root: TreeNode?): Int {
        if (root == null) {
            return 0
        }

        val stack = Stack<TreeNode>()
        stack.push(root)
        var maxDepth = 1
        while (stack.size != 1) {
            val top = stack.peek()
            if (top.left != null) {
                stack.push(top.left)
                maxDepth = max(maxDepth, stack.size)
            } else if (top.right != null) {
                stack.push(top.right)
                maxDepth = max(maxDepth, stack.size)
            } else {
                stack.pop()
            }
        }
        return maxDepth
    }
}

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}