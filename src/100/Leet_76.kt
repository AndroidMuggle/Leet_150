package `100`

import java.util.*

class Leet_76 {

    fun hasPathSum(root: TreeNode?, targetSum: Int): Boolean {

        val stack = Stack<TreeNode?>()
        stack.push(root)

        var curNum = targetSum

        while (stack.isNotEmpty()) {
            val top = stack.pop()

            if (curNum == top?.`val` && top.left == null && top.right == null) {
                return true
            }

            if (null != top?.right) {
                stack.push(top.right)
            }

            if (null != top?.left) {
                stack.push(top.left)
            }
        }
        return false
    }

    fun hasPathSum1(root: TreeNode?, targetSum: Int): Boolean {
        if (root == null ) {
            return false
        }

        if (root.`val` == targetSum && null == root.left && null == root.right) {
            return true
        }

        return (hasPathSum1(root.left, targetSum - (root.`val` ?: 0))
                || hasPathSum1(
            root.right,
            targetSum - (root.`val` ?: 0)
        ))
    }
}

fun main() {

    val lee76 = Leet_76()

    print(lee76.hasPathSum1(TreeNode(5).apply {
        left = TreeNode(4).apply {
            left = TreeNode(11).apply {
                left = TreeNode(7)
                right = TreeNode(2)
            }
        }
        right = TreeNode(8).apply {
            left = TreeNode(13)
            right = TreeNode(4).apply {
                right = TreeNode(1)
            }
        }
    }, 22))

    print("\n")

    print(lee76.hasPathSum1(TreeNode(1).apply {
        left = TreeNode(2)
        right = TreeNode(3)
    }, 5))

    print("\n")

    print(lee76.hasPathSum1(null, 0))
}