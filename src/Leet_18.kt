import kotlin.math.pow

class Leet_18 {
    fun intToRoman(num: Int): String {
        val intArr = arrayListOf<Int>()
        var inputNum = num
        while (inputNum != 0) {
            val curNum = num % 10
            intArr.add(curNum)
            inputNum /= 10
        }

        val time = 10.0
        val ret = arrayListOf<Int>()
        intArr.forEachIndexed { index, i ->
            ret.add(i * time.pow(index.toDouble()).toInt())
        }
        return ""
    }
}