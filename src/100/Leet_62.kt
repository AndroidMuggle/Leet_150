package `100`

class Leet_62 {

    fun reverseKGroup(head: ListNode?, k: Int): ListNode? {
        var curNode = head
        var count = 0
        while (curNode != null) {
            curNode = curNode.next

            if (count++ % k == 0) {
                reverseBetween1(head, count - 3, count)
            }
        }
        return head
    }

    fun reverseBetween1(head: ListNode?, left: Int, right: Int): ListNode? {
        val resultNode = ListNode(-1)
        resultNode.next = head
        var temp = resultNode
        var index = 0
        while (index < left - 1) {
            temp = temp.next!!
            index++
        }

        var curNode = temp.next
        var next: ListNode?
        var startIndex = 0
        while (startIndex < right - left) {
            next = curNode?.next
            curNode?.next = next?.next
            next?.next = temp.next
            temp.next = next
            startIndex++
        }
        return resultNode.next
    }
}