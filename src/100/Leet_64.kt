package `100`

class Leet_64 {

    /**
     * 这个是一种做法，更常见也更容易想到的做法是遍历两次统计频次
     */
    fun deleteDuplicates(head: ListNode?): ListNode? {
        if (head == null) {
            return head;
        }

        val dummy =  ListNode(-10000).apply {
            next = head
        }

        var cur = dummy
        while (cur.next != null && cur.next?.next != null) {
            if (cur.next?.`val` == cur.next?.next?.`val`) {
                val  x = cur.next?.`val`
                while (cur.next != null && cur.next?.`val` == x) {
                    cur.next = cur.next?.next
                }
            } else {
                cur = cur.next!!
            }
        }

        return dummy.next
    }
}

fun main() {
    val leet64 = Leet_64()

    print(
        "${
            leet64.deleteDuplicates(ListNode(1).apply {
                next = ListNode(1).apply {
                    next = ListNode(1).apply {
                        next = ListNode(2).apply {
                            next = ListNode(3)
                        }
                    }
                }
            })
        }"
    )
}