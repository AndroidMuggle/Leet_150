package `100`

import java.util.*

class Leet_80 {

    fun countNodes(root: TreeNode?): Int {
        if (root == null) {
            return 0
        }
        val stack = Stack<TreeNode>()
        stack.push(root)
        var count = 0
        while (stack.isNotEmpty()) {
            val top = stack.pop()
            count++
            if (top.left != null) {
                stack.push(top.left)
            }
            if (top.right != null) {
                stack.push(top.right)
            }
        }
        return count
    }

//    fun countNodes1(root: TreeNode?): Int {
//
//    }
}