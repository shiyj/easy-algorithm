import java.util.*
import kotlin.math.min

fun mergeSortTest() {
    val arr = intArrayOf(14, 6, 15, 3, 9, 1, 8, 10, 7, 2, 4, 13, 11, 12, 5)
    val array = mergeSortRecursive(arr.copyOf())
    println(Arrays.toString(array))
    mergeSort(arr)
    println(Arrays.toString(arr))
}

fun mergeSort(originArray: IntArray) {
    // arr仅为一个指针，没有内存分配
    var arr = originArray
    val count = arr.count()
    if (count < 2) {
        return
    }
    // 开辟等量内存块存放临时数据
    var result = IntArray(count)
    var tmp: IntArray
    var i = 1
    while (i < count) {
        var j = 0
        while (j < count) {
            val start = j
            // 右侧数组的开始位置
            val mid = min(j + i, count - 1)
            val end = min(j + i * 2 - 1, count - 1)
            merge(arr, start, mid, end, result)
            j = end + 1
        }

        tmp = arr
        arr = result
        result = tmp
        i *= 2
    }

    // 计算出了结果，将其写回原数据，如果刚好i是2的偶数次方合并，不需要交换
    if (arr != originArray) {
        for (i in arr.indices) {
            originArray[i] = arr[i];
        }
    }

    return
}

/*
 * 挪腾交换
 */
fun merge(arr: IntArray, start: Int, mid: Int, end: Int, result: IntArray) {

    if (start == end) {
        result[start] = arr[start]
        return
    }

    var i = start
    var j = mid
    for (c in start..end) {
        // 边界条件
        if (j > end) {
            result[c] = arr[i]
            i += 1
        } else if (i >= mid) {
            result[c] = arr[j]
            j += 1
        } else if (arr[i] <= arr[j]) {
            result[c] = arr[i]
            i += 1
        } else {
            result[c] = arr[j]
            j += 1
        }
    }

}

/*
 * 空间复杂度较高的递归，用于理解算法
 */
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