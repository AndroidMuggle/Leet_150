package `100`

class Leet_97 {


}

class Trie() {

    var isEnd: Boolean = false

    private var nextNode: Array<Trie?> = Array(26) { null }

    fun insert(word: String) {
        var cur = this
        word.forEach {
            nextNode[it - 'a'] = Trie()
            cur = cur.nextNode[it - 'a']!!
        }
        cur.isEnd = true
    }

    fun search(word: String): Boolean {
        val node = searchPrefix(word)
        return node != null && node.isEnd
    }

    fun startsWith(prefix: String): Boolean {
        return searchPrefix(prefix) != null
    }

    private fun searchPrefix(prefix: String): Trie? {
        var node = this
        prefix.forEachIndexed { _, c ->
            if (node.nextNode[c - 'a'] == null) {
                return null
            }
            node = node.nextNode[c - 'a']!!
        }
        return node
    }
}