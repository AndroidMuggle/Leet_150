package `100`

class Leet_61 {

    /**
     * 会形成环链
     */
    fun reverseBetween(head: ListNode?, left: Int, right: Int): ListNode? {
        var temp = head
        val resultList = arrayListOf<ListNode>()

        while (temp != null) {
            resultList.add(temp)
            temp = temp.next
        }

        val startList = resultList.subList(0, left - 1)
        val middleList = resultList.subList(left - 1, right)
        val endList = resultList.subList(right, resultList.size)

        val result = arrayListOf<ListNode>()
        result.addAll(startList)
        result.addAll(middleList.reversed())
        result.addAll(endList)
        val resultNode = ListNode(0)
        var curNode = resultNode
        result.forEach {
            curNode.next = it
            curNode = curNode.next!!
        }
        return resultNode.next
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

fun main() {
    val leet61 = Leet_61()
    print(
        "${
            leet61.reverseBetween1(ListNode(1).apply {
                next = ListNode(2).apply {
                    next = ListNode(3).apply {
                        next = ListNode(4).apply {
                            next = ListNode(5)
                        }
                    }
                }
            }, 2, 4)
        }"
    )
}