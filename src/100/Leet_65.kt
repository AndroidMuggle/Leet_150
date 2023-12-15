package `100`

class Leet_65 {

    fun rotateRight(head: ListNode?, k: Int): ListNode? {
        var count = 0
        var curNode = head
        val valArr = arrayListOf<Int>()
        while (curNode != null) {
            valArr.add(curNode.`val`)
            count++
            curNode = curNode.next
        }

        if (count == 0) {
            return null
        }

        val realCount = k % count

        val left = valArr.subList(0, valArr.size - realCount)
        val right = valArr.subList(valArr.size - realCount, valArr.size)

        right.addAll(left)

        val resultHead = ListNode(-1)
        var tempHead = resultHead
        right.forEach {
            tempHead.next = ListNode(it)
            tempHead = tempHead.next!!
        }
        return resultHead.next
    }
}