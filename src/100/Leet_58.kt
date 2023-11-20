package `100`

class Leet_58 {
    fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
        var curNode1 = l1
        var curNode2 = l2

        val result = ListNode(0)
        var curNode = result

        var flag = false

        while (curNode1 != null && curNode2 != null) {
            val sum = curNode1.`val` + curNode2.`val` + if (flag) 1 else 0
            val curNum = sum % 10
            curNode.next = ListNode(curNum)
            curNode = curNode.next!!
            flag = sum / 10 > 0
            curNode1 = curNode1.next
            curNode2 = curNode2.next
        }

        while (curNode1 != null) {
            val sum = curNode1.`val` + if (flag) 1 else 0
            val curNum = sum % 10
            curNode.next = ListNode(curNum)
            curNode = curNode.next!!
            flag = sum / 10 > 0
            curNode1 = curNode1.next
        }

        while (curNode2 != null) {
            val sum = curNode2.`val` + if (flag) 1 else 0
            val curNum = sum % 10
            curNode.next = ListNode(curNum)
            curNode = curNode.next!!
            flag = sum / 10 > 0
            curNode2 = curNode2.next
        }

        if (flag) {
            curNode.next = ListNode(1)
        }
        return result.next
    }
}

fun main() {
    val leet58 = Leet_58()
    print(
        "${
            leet58.addTwoNumbers(ListNode(2).apply {
                next = ListNode(4).apply {
                    next = ListNode(3)
                }
            }, ListNode(5).apply {
                next = ListNode(6).apply {
                    next = ListNode(4)
                }
            })
        }"
    )
}