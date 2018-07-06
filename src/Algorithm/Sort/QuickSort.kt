
fun quickSortTest() {
    val arr = intArrayOf(7, 3, 4, 2, 1)
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