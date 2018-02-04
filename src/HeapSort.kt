import java.util.*

fun heapSortTest() {
    var arr = intArrayOf(4, 5, 3, 2, 6, 1)
    heapSort(arr)
    arr = intArrayOf(49, 38, 65, 97, 76, 13, 27, 49)
    heapSort(arr)
    arr = intArrayOf( 6, 5, 3, 1, 8, 7, 2, 4)
    heapSort(arr)
}

fun leftLeafIndex(i: Int): Int {
    return i * 2 + 1
}

fun swap(array: IntArray, i: Int, j: Int) {
    val tmp = array[i]
    array[i] = array[j]
    array[j] = tmp
}

/*
 * 假设topIndex的子树都是具有堆属性的,但是topIndex本身未知
 * 那么当topIndex进行了交换后，需要更新叶子树，不交换则不更新
 *
*/

fun adjustHeap(array: IntArray, index: Int, length: Int) {

    var topIndex = index
    var maxChildIndex: Int

    while (topIndex < length) {
        maxChildIndex = leftLeafIndex(topIndex)
        // no leaf
        if (maxChildIndex >= length) {
            break
        }

        if (maxChildIndex <= length - 2) {
            if (array[maxChildIndex + 1] > array[maxChildIndex]) {
                maxChildIndex += 1
            }
        }

        if (array[topIndex] < array[maxChildIndex]) {
            swap(array, topIndex, maxChildIndex)
            topIndex = maxChildIndex
        } else {
            break
        }
    }

}

fun heapSort(array: IntArray) {
    // first build heap

    val len = array.count()
    val start = len / 2

    for (i in start downTo 0) {
        adjustHeap(array, i, len)
    }

    for (i in array.count() downTo 1) {
        swap(array, 0, i - 1)
        adjustHeap(array, 0, i - 1)
    }
    println(Arrays.toString(array))
}