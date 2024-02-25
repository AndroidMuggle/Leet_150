package `100`

import java.util.*

class Leet_87 {
    fun kthSmallest(root: TreeNode?, k: Int): Int {
        val valArr = arrayListOf<Int>()
        val stack = Stack<TreeNode>()

        stack.push(root)
        while (stack.isNotEmpty()) {
            val top = stack.pop()
            valArr.add(top.`val`)

            if (null != top.left) {
                stack.push(top.left)
            }

            if (null != top.right) {
                stack.push(top.right)
            }
        }

        valArr.sort()

        return valArr[k-1]
    }
}