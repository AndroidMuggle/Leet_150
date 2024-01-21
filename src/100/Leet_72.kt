package `100`

class Leet_72 {
    fun buildTree(preorder: IntArray, inorder: IntArray): TreeNode? {
        if (preorder.isEmpty() || inorder.isEmpty()) {
            return null
        }

        val head = TreeNode(preorder[0])
//        val flag = BooleanArray(preorder.size) {
//            it == 0
//        }

        val index = inorder.indexOfFirst { it == preorder[0] } ?: 0

        val preorderLeftArr = arrayListOf<Int>()
        val preorderRightArr = arrayListOf<Int>()

        val inorderLeftArr = inorder.slice(IntRange(0, index ))
        val inorderRightArr = inorder.slice(IntRange(index + 1, preorder.size - 1))

        preorder.forEach {
            inorderLeftArr.forEach { inorderLeftV ->
                if (it == inorderLeftV) {
                    preorderLeftArr.add(it)
                }
            }

            inorderRightArr.forEach { inorderRightV ->
                if (it == inorderRightV) {
                    preorderRightArr.add(it)
                }
            }
        }


        head.left = buildTree(preorderLeftArr.toIntArray(), inorderLeftArr.toIntArray())
        head.right = buildTree(preorderRightArr.toIntArray(), inorderRightArr.toIntArray())
        return head
    }

    fun buildTree1(preorder: IntArray, inorder: IntArray): TreeNode? {
        if (preorder.isEmpty() || inorder.isEmpty()) {
            return null
        }

        val head = TreeNode(preorder[0])

        val index = inorder.indexOfFirst { it == preorder[0] } ?: 0


        val inorderLeftArr = inorder.slice(IntRange(0, index - 1))
        val preorderLeftArr = preorder.slice(IntRange(1, inorderLeftArr.size))

        val inorderRightArr = inorder.slice(IntRange(index + 1, preorder.size - 1))
        val preorderRightArr = preorder.slice(IntRange(inorderLeftArr.size + 1, preorder.size - 1))




        head.left = buildTree1(preorderLeftArr.toIntArray(), inorderLeftArr.toIntArray())
        head.right = buildTree1(preorderRightArr.toIntArray(), inorderRightArr.toIntArray())
        return head
    }
}

fun main() {
    val leet_72 = Leet_72()

    print(leet_72.buildTree1(intArrayOf(3, 9, 20, 15, 7), intArrayOf(9, 3, 15, 20, 7)))
}