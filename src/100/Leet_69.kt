package `100`

import java.util.*

class Leet_69 {

    fun isSameTree(p: TreeNode?, q: TreeNode?): Boolean {

//        if (p?.`val`!=q?.`val`||p?.left?.`val`!=q?.left?.`val`||q?.right?.`val`!=q?.right?.`val`){
//            return false
//        }
//
//        return isSameTree(p?.left,q?.left)&&isSameTree(p?.right,q?.right)

        val pStack = Stack<TreeNode?>()
        val qStack = Stack<TreeNode?>()

        pStack.push(p)
        qStack.push(q)

        while (pStack.isNotEmpty() && qStack.isNotEmpty()) {
            val pCur = pStack.pop()
            val qCur = qStack.pop()

            if (qCur?.`val` != pCur?.`val` || pCur?.left?.`val` != qCur?.left?.`val` || pCur?.right?.`val` != qCur?.right?.`val`) {
                return false
            }

            if (pCur?.left != null) {
                pStack.push(pCur.left)
            }

            if (pCur?.right != null) {
                pStack.push(pCur.right)
            }

            if (qCur?.left != null) {
                qStack.push(qCur.left)
            }
            if (qCur?.right != null) {
                qStack.push(qCur.right)
            }
        }

        if (pStack.isNotEmpty() || qStack.isNotEmpty()) {
            return false
        }
        return true
    }
}