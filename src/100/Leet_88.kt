package `100`

import java.util.*

class Leet_88 {

    fun isValidBST(root: TreeNode?): Boolean {
        val valArr = arrayListOf<Int>()
        val stack = Stack<TreeNode>()
        var node = root

        while (node != null || stack.isNotEmpty()) {
            node = if (node != null) {
                stack.push(node)
                node.left
            } else {
                val curNode = stack.pop()
                valArr.add(curNode.`val`)
                curNode.right
            }
        }


        valArr.forEachIndexed { index, i ->
            if (index > 0 && i <= valArr[index - 1]) {
                return false
            }
        }
        return true
    }
}