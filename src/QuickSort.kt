
fun quickSortTest() {
//    val arr = intArrayOf(6, 5, 3, 9, 1, 8, 10, 7, 2, 4, 13, 11, 12)
    val arr = intArrayOf(7, 3, 4, 2, 1)
//    val arr = intArrayOf(17, 63, 99, 70, 16, 15, 41, 29, 26, 25, 72, 92, 93, 85, 94, 46, 66, 33, 71, 8, 57, 81, 65, 37, 5, 60, 56, 18, 7, 74, 2, 47, 40, 83, 30, 91, 4, 35, 89, 97, 78, 39, 24, 73, 43, 76, 36, 88, 61, 79, 3, 38, 87, 100, 80, 12, 19, 13, 31, 51, 55, 98, 86, 44, 10, 34, 32, 50, 95, 75, 54, 82, 27, 1, 68, 20, 14, 64, 59, 96, 28, 84, 23, 42, 53, 49, 90, 52, 62, 45, 6, 69, 67, 48, 21, 9, 11, 77, 58, 22)
    quickSort(arr)
}

fun quickSort(array: IntArray) {
    val start = 0
    val end = array.count() - 1

    quickSort(array, start, end)
}

fun quickSort(array: IntArray, start: Int, end: Int) {
    if (start >= end) {
        return
    }

    val mid = partition(array, start, end)
    quickSort(array, start, mid - 1)
    quickSort(array, mid + 1, end)
}

fun partition(array: IntArray, start: Int, end: Int): Int {

    val pivot = array[start]
    var i = start + 1
    var j = end
    var tmp: Int

    while (i < j) {
        when {
            array[i] <= pivot -> i += 1
            array[j] > pivot -> j -= 1
            else -> {
                tmp = array[i]
                array[i] = array[j]
                array[j] = tmp
            }
        }
    }

    tmp = array[i]
    if (tmp > pivot) {
        tmp = array[i - 1]
        array[i - 1] = pivot
        array[start] = tmp
        return i - 1
    } else {
        tmp = array[i]
        array[i] = pivot
        array[start] = tmp
        return i
    }
}