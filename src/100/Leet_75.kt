package `100`

import java.util.*

class Leet_75 {

    fun flatten(root: TreeNode?): Unit {

        val arr = arrayListOf<TreeNode?>()

        val stack = Stack<TreeNode?>()

        stack.push(root)

        while (stack.isNotEmpty()) {
            val top = stack.pop()
            arr.add(top)
            if (top?.right != null) {
                stack.push(top.right)
            }

            if (top?.left != null) {
                stack.push(top.left)
            }
        }

        arr.forEachIndexed { index, treeNode ->
            if (index < arr.size - 1) {
                treeNode?.left = null
                treeNode?.right = arr[index + 1]
            } else if (index == arr.size - 1) {
                treeNode?.left = null
                treeNode?.right = null
            }
        }

    }
}