package `100`

import java.util.*
import kotlin.math.max

class Leet_68 {

    fun maxDepth(root: TreeNode?): Int {
        if (root == null) {
            return 0
        }

        val stack = Stack<TreeNode>()
        val hashSet = hashSetOf<TreeNode>()
        stack.push(root)
        var maxDepth = 1
        while (stack.isNotEmpty()) {
            val top = stack.peek()
            if (top.left != null && !hashSet.contains(top.left)) {
                stack.push(top.left)
                hashSet.add(top.left!!)
                maxDepth = max(maxDepth, stack.size)
            } else if (top.right != null && !hashSet.contains(top.right)) {
                stack.push(top.right)
                hashSet.add(top.right!!)
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

fun main() {
    val leet68 = Leet_68()

    print(
        "${
            leet68.maxDepth(TreeNode(3).apply {
                left = TreeNode(9)
                right = TreeNode(20).apply {
                    left = TreeNode(15)
                    right = TreeNode(7)
                }
            })
        }"
    )
}