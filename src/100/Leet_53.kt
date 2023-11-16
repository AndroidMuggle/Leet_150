package `100`

class Leet_53 {

    fun simplifyPath(path: String): String {
        val splitArr = path.split("/")
        val result = arrayListOf<String>()

        splitArr.forEach {
            if (it == ".") {
                return@forEach
            } else if (it == "..") {
                if (result.isNotEmpty()) {
                    result.removeAt(result.size - 1)
                }
            } else {
                if (it.isNotEmpty()) {
                    result.add(it)
                }
            }
        }
        return  result.joinToString("/", prefix = "/")
    }
}

fun main() {
    val leet53 = Leet_53()

    print("${leet53.simplifyPath("/home//foo/")}")
}