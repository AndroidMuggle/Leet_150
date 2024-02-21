package `100`

import java.util.*
import kotlin.math.abs
import kotlin.math.min

class Leet_86 {

    fun getMinimumDifference(root: TreeNode?): Int {
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
        var ret = Int.MAX_VALUE

        valArr.forEachIndexed { index, i ->
            if (index > 0) {
                ret = min(abs(valArr[index - 1] - i), ret)
            }
        }
        return ret
    }
}