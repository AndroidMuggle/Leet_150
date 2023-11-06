class Leet_10 {

    fun jump(nums: IntArray): Int {
        var maxPos = 0
        var end = 0
        var step = 0
        var index = 0
        while (index < nums.size-1) {
            maxPos =if(maxPos > nums[index] + index) maxPos else nums[index] + index
            if (index==end){
                end = maxPos
                step++
            }
            index++
        }
        return step
    }
}

fun main() {
    val leet10 = Leet_10()
    print("minStepCount = ${leet10.jump(intArrayOf(1,2,1,1,1))}")
}