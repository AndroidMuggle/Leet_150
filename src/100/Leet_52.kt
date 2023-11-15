package `100`

class Leet_52 {

    fun isValid(s: String): Boolean {
        val result = arrayListOf<Char>()
        s.forEach {
            if (it == '(' || it == '{' || it == '[') {
                result.add(it)
            } else {
                if (result.isEmpty()){
                    return false
                }
                if (it == ')' && result[result.size - 1] == '(') {
                    result.removeAt(result.size - 1)
                } else if (it == ']' && result[result.size - 1] == '[') {
                    result.removeAt(result.size - 1)
                } else if (it == '}' && result[result.size - 1] == '{') {
                    result.removeAt(result.size - 1)
                } else {
                    return false
                }
            }
        }
        return result.size == 0
    }
}