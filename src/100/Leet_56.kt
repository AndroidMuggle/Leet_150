package `100`

class Leet_56 {

    fun calculate(s: String): Int {
        val temp = s.replace(" ", "")
        val splitArr = temp.split('+', '-', '(', ')')
        val numArr = arrayListOf<Int>()
        splitArr.forEach {
            if (it.isNotEmpty() && it[0].isDigit()) {
                numArr.add(it.toInt())
            }
        }
        val signArr = arrayListOf<Char>()
        temp.forEach {
            if (it == '(' || it == ')' || it == '+' || it == '-') {
                signArr.add(it)
            }
        }
        signArr.forEach {
            if (it == '+' || it == '-') {

            } else {

            }
        }

        return 0
    }
}

fun main() {
    val leet56 = Leet_56()
    print("${leet56.calculate("(1+(4+5+2)-3)+(6+8)")}")
}
