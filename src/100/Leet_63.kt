package `100`

class Leet_63 {

    /**
     * 这是进行了多次扫描，题目中要求一次扫描并删除
     */
    fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {

        var temp = head
        var count = 0
        while (temp != null) {
            count++
            temp = temp.next
        }
        if (count == 1) {
            return null
        }

        var curNode = head
        var index = 0
        while (curNode != null) {
            if (index == count - n - 1) {
                break
            }
            index++
            curNode = curNode.next
        }
        curNode?.next = curNode?.next?.next
        return head
    }

    /**
     * 快慢指针
     */
    fun removeNthFromEnd1(head: ListNode?, n: Int): ListNode? {
        return null
    }

}

fun main() {
    val leet63 = Leet_63()

    print(
        "${
            leet63.removeNthFromEnd(ListNode(1).apply {
                next = ListNode(2)
            }, 1)
        }"
    )
}