package `100`

class Leet_59 {
    fun mergeTwoLists(list1: ListNode?, list2: ListNode?): ListNode? {
        var curNode1 = list1
        var curNode2 = list2

        val result = ListNode(0)
        var curNode = result

        while (curNode1 != null && curNode2 != null) {
            if (curNode1.`val` < curNode2.`val`) {
                curNode.next = ListNode(curNode1.`val`)
                curNode = curNode.next!!
                curNode1 = curNode1.next
            } else {
                curNode.next = ListNode(curNode2.`val`)
                curNode = curNode.next!!
                curNode2 = curNode2.next
            }
        }

        while (curNode1 != null) {
            curNode.next = ListNode(curNode1.`val`)
            curNode = curNode.next!!
            curNode1 = curNode1.next
        }

        while (curNode2 != null) {
            curNode.next = ListNode(curNode2.`val`)
            curNode = curNode.next!!
            curNode2 = curNode2.next
        }
        return result.next
    }
}