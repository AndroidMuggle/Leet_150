package `100`

class Leet_57 {

    /**
     * 暴力解法，推荐快慢指针解法
     */
    fun hasCycle(head: ListNode?): Boolean {
        val set = hashSetOf<String>()
        var curNode = head
        while (curNode?.next != null) {
            if (!set.add(curNode.hashCode().toString())) {
                return true
            }
            curNode = curNode.next
        }
        return false
    }

    fun hasCycle1(head: ListNode?): Boolean {
        if (head == null) {
            return false
        }
        var slow = head
        var fast = head?.next
        while (slow != fast) {
            slow = slow?.next
            fast = fast?.next?.next
            if (fast == null) {
                return false
            }
        }
        return true
    }
}

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}
