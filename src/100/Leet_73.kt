package `100`

class Leet_73 {

    fun buildTree(inorder: IntArray, postorder: IntArray): TreeNode? {
        if (inorder.isEmpty() || postorder.isEmpty()) {
            return null
        }

        val head = TreeNode(postorder[postorder.size - 1])

        val index = inorder.indexOf(postorder[postorder.size - 1])

        val inorderLeftArr = inorder.slice(IntRange(0, index - 1))
        val inorderRightArr = inorder.slice(IntRange(index + 1, inorder.size - 1))

        val postorderLeftArr = postorder.slice(IntRange(0, inorderLeftArr.size - 1))
        val postorderRightArr = postorder.slice(IntRange(inorderLeftArr.size, postorder.size - 2))

        head.left = buildTree(inorderLeftArr.toIntArray(), postorderLeftArr.toIntArray())
        head.right = buildTree(inorderRightArr.toIntArray(), postorderRightArr.toIntArray())
        return head
    }
}