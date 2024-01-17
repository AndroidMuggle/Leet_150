package `100`

import java.util.*

class Leet_71 {

    fun isSymmetric(root: TreeNode?): Boolean {
//        if (root?.left?.`val` != root?.right?.`val`) {
//            return false
//        }
//        return isSymmetric(root?.left) && isSymmetric(root?.right)

        val queue = ArrayDeque<TreeNode?>()
        queue.offer(root)
        queue.offer(root)


        while (queue.isNotEmpty()) {
            val first = queue.poll()
            val second = queue.poll()

            if (first?.`val` != second?.`val` ||
                first?.left?.`val` != second?.right?.`val` ||
                first?.right?.`val` != second?.left?.`val`
            ) {
                return false
            }

            if (null != first?.left) {
                queue.offer(first?.left)
            }

            if (null != second?.right) {
                queue.offer(second?.right)
            }

            if (null != first?.right) {
                queue.offer(first?.right)
            }

            if (null != second?.left) {
                queue.offer(second?.left)
            }
        }
        return true
    }
}

fun main() {
    val leet71 = Leet_71()
    print(
        "${
            leet71.isSymmetric(
                TreeNode(1).apply {
                    left = TreeNode(2).apply {
                        right = TreeNode(3)
                    }
                    right = TreeNode(2).apply {
                        right = TreeNode(3)
                    }
                }
            )
        }"
    )
}