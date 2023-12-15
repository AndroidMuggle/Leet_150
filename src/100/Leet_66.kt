package `100`

class Leet_66 {
    fun partition(head: ListNode?, x: Int): ListNode? {
        var curNode = head
        val lessArr = arrayListOf<Int>()
        val greatArr = arrayListOf<Int>()
        while (curNode != null) {
            if (x > curNode.`val`) {
                lessArr.add(curNode.`val`)
            } else {
                greatArr.add(curNode.`val`)
            }
            curNode = curNode.next
        }
        lessArr.addAll(greatArr)

        val head = ListNode(-1)
        var tempNode = head

        lessArr.forEach {
            tempNode.next = ListNode(it)
            tempNode = tempNode.next!!
        }
        return head.next
    }
}