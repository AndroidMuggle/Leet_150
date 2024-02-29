package `100`

class Leet_91 {
    fun cloneGraph(node: GraphNode?): GraphNode? {
        if (null == node) {
            return null
        }
        val map = hashMapOf<Int, GraphNode>()
        val queue = ArrayDeque<GraphNode>()
        queue.add(node)
        while (queue.isNotEmpty()) {
            val fir = queue.removeFirst()
            val cloneFir = GraphNode(fir.`val`)
            fir.neighbors.forEach {
                if (map.contains(it?.`val`)) {
                    cloneFir.neighbors.add(map[it?.`val`])
                } else {
                    queue.add(it!!)
                    val curNode = GraphNode(it.`val`)
                    cloneFir.neighbors.add(curNode)
                    map[it.`val`] = curNode
                }
            }

            if (map.contains(cloneFir.`val`)) {
                map[cloneFir.`val`]?.neighbors = cloneFir.neighbors
            } else {
                map[cloneFir.`val`] = cloneFir
            }
        }
        return map[node.`val`]
    }
}

fun main() {
    val leet91 = Leet_91()
    val node1 = GraphNode(1)
    val node2 = GraphNode(2)
    val node3 = GraphNode(3)
    val node4 = GraphNode(4)

    node1.neighbors.add(node2)
    node1.neighbors.add(node4)

    node2.neighbors.add(node1)
    node2.neighbors.add(node3)

    node3.neighbors.add(node2)
    node3.neighbors.add(node4)

    node4.neighbors.add(node1)
    node4.neighbors.add(node3)

    leet91.cloneGraph(node1)
}

class GraphNode(var `val`: Int) {
    var neighbors: ArrayList<GraphNode?> = arrayListOf()
}