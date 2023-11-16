package `100`

class Leet_55 {

    fun evalRPN(tokens: Array<String>): Int {
        val result = arrayListOf<Int>()
        tokens.forEach {
            if (it == "+" || it == "-" || it == "*" || it == "/") {
                val num1 = result[result.size - 2]
                val num2 = result[result.size - 1]
                result.removeAt(result.size - 1)
                result.removeAt(result.size - 1)
                when (it) {
                    "+" -> {
                        result.add(num1 + num2)
                    }
                    "-" -> {
                        result.add(num1 - num2)
                    }
                    "*" -> {
                        result.add(num1 * num2)
                    }
                    "/" -> {
                        result.add(num1 / num2)
                    }
                }
            } else {
                result.add(it.toInt())
            }
        }

        return result.first()
    }
}

fun main() {
    val leet55 = Leet_55()
    print("${leet55.evalRPN(arrayOf("4", "13", "5", "/", "+"))}")
}