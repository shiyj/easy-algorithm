import java.util.*

fun mergeSortTest() {
    val arr = intArrayOf(6, 5, 3, 1, 8, 7, 2, 4)
    val array = mergeSortRecursive(arr)
    println(Arrays.toString(array))
}

fun mergeSortRecursive(arr: IntArray): IntArray {
    val count = arr.count()
    if (count <= 1) {
        return arr
    }
    val mid = count / 2 - 1
    val leftRange = IntRange(0, mid)
    var left = arr.sliceArray(leftRange)
    val rightRange = IntRange(mid + 1, count - 1)
    var right = arr.sliceArray(rightRange)
    left = mergeSortRecursive(left)
    right = mergeSortRecursive(right)
    return merge(left, right)

}

fun merge(left: IntArray, right: IntArray): IntArray {
    val count = left.count() + right.count()
    val result = IntArray(count)

    var i = 0
    var j = 0
    var index = 0
    while (i <= left.count() || j <= right.count()) {

        if (i >= left.count()) {
            for (c in j..(right.count() - 1)) {
                result[index] = right[c]
                index += 1
            }
            return result
        }

        if (j >= right.count()) {
            for (c in i..(left.count() - 1)) {
                result[index] = left[c]
                index += 1
            }
            return result
        }

        val leftTop = left[i]
        val rightTop = right[j]

        if (leftTop <= rightTop) {
            result[index] = leftTop
            i += 1
        } else {
            result[index] = rightTop
            j += 1
        }

        index += 1

    }
    return result
}