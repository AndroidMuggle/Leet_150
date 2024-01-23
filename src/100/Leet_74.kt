package `100`

import java.util.*

class Leet_74 {

    fun connect(root: NodeNext?): NodeNext? {

        val queue = ArrayDeque<NodeNext>()
        queue.offer(root)

//        val flagArr = arrayListOf<Boolean>()
//        flagArr.add(false)

        while (queue.isNotEmpty()) {
            val size = queue.size
            var index = 0
            var last: NodeNext? = null
            while (index < size) {
                val cur = queue.poll()
                if (null != cur.left) {
                    queue.offer(cur.left)
                }

                if (null != cur.right) {
                    queue.offer(cur.right)
                }

                if (index != 0) {
                    last?.next = cur
                }
                last = cur
                index++
            }
        }

        return root
    }
}

fun main() {
    val lee74 = Leet_74()

    print(
        lee74.connect(
            NodeNext(1).apply {
                left = NodeNext(2).apply {
                    left = NodeNext(4)
                    right = NodeNext(5)
                }
                right = NodeNext(3).apply {
                    right = NodeNext(7)
                }
            }
        )
    )
}

class NodeNext(var `val`: Int) {
    var left: NodeNext? = null
    var right: NodeNext? = null
    var next: NodeNext? = null
}