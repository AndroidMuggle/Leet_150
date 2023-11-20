package `100`

class Leet_60 {

    fun copyRandomList(node: Node?): Node? {
        val nodeList = arrayListOf<Node>()
        var headNode = node
        while (headNode != null) {
            nodeList.add(headNode)
            headNode = headNode.next
        }

        val resultNodeList = Array<Node?>(nodeList.size) {
            null
        }

        nodeList.forEachIndexed { index, curNode ->
            val resultNode = if (resultNodeList[index] == null) Node(curNode.`val`) else resultNodeList[index]
            resultNodeList[index] = resultNode
            if (curNode.random != null) {
                val curNodeRandomIndex = nodeList.indexOf(curNode.random)
                if (resultNodeList[curNodeRandomIndex] != null) {
                    resultNode!!.random = resultNodeList[curNodeRandomIndex]
                } else {
                    resultNode!!.random = Node(curNode.random!!.`val`)
                    resultNodeList[curNodeRandomIndex] = resultNode.random
                }
            }
        }

        val result = Node(0)
        var temp = result
        resultNodeList.forEachIndexed { index, curNode ->
            temp.next = curNode
            temp = temp.next!!
        }
        return result.next
    }
}

class Node(var `val`: Int) {
    var next: Node? = null
    var random: Node? = null
}

fun main() {
    val leet60 = Leet_60()
    val arrList = arrayListOf<Node>()
    arrList.add(Node(7))
    arrList.add(Node(13))
    arrList.add(Node(11))
    arrList.add(Node(10))
    arrList.add(Node(1))
    arrList[1].random = arrList[0]
    arrList[2].random = arrList[4]
    arrList[3].random = arrList[2]
    arrList[4].random = arrList[0]
    val head = Node(0)
    var temp = head
    arrList.forEach {
        temp.next = it
        temp = temp.next!!
    }

    print("${leet60.copyRandomList(head.next)}")
}