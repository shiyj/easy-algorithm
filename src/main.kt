import java.util.*

fun main(args: Array<String>) {

//    fibonacciTest()
//    treeTest()
//    heapSortTest()
//    mergeSortTest()
//    quickSortTest()
    runSortTest({ quickSort(it) }, "quick sort")
    runSortTest({ heapSort(it) }, "heap sort")
    runSortTest({ mergeSort(it) }, "merge sort")

}

fun runSortTest(sort_fun: (arr: IntArray) -> Unit, name: String = "NOT SET") {
    println()
    println("====== " + name)
    val maxCount = 10000
    for (i in 1..maxCount) {

        val array = createNoRepetitionRandomArray(i)
        var resultArr = array.copyOf()
        sort_fun(resultArr)
        val progress = i.toFloat() / maxCount.toFloat()

        if (!checkResult(array, resultArr, progress)) {
            break
        }

        resultArr = array.copyOf()
        addRepetition(resultArr)
        sort_fun(resultArr)
        if (!checkResult(array, resultArr, progress)) {
            break
        }
    }
    println()
}

fun createNoRepetitionRandomArray(count: Int): IntArray {
    val array = IntArray(count, { i -> i + 1 })

    // randomAll
    var i = count - 1
    var tmp: Int

    while (i >= 0) {
        val j = (Math.random() * i).toInt()
        tmp = array[i]
        array[i] = array[j]
        array[j] = tmp
        i--
    }
    return array

}

fun addRepetition(array: IntArray) {
    var i = array.count() - 1

    while (i >= 0) {
        val j = (Math.random() * i).toInt()
        array[i] = array[j]
        i = i / 4 - 1
    }
}

fun checkResult(originArr: IntArray, resultArr: IntArray, progress: Float): Boolean {
    if (!checkResult(resultArr)) {
        println("-----Error Result:-----")
        println(Arrays.toString(resultArr))
        println("-----Error Origin-----")
        println(Arrays.toString(originArr))
        println()
        println()
        return false
    } else {
        print("\rProgress: %.2f%%".format(progress * 100))
        return true
    }
}

fun checkResult(array: IntArray): Boolean {
    for (i in array.indices) {
        if (0 == i) {
            continue
        }

        if (i == array.count() - 2) {
            break
        }

        val pre = array[i - 1]
        val current = array[i]
        if (current < pre) {
            return false
        }
    }
    return true
}