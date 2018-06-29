import java.util.*

fun main(args: Array<String>) {

//    fibonacciTest()
//    treeTest()
//    heapSortTest()
//    mergeSortTest()
    quickSortTest()

    for (i in 0..10) {
        val arrayCount = 100 + i

        val array = createNoRepetitionRandomArray(arrayCount)
        val originArr = array.copyOf()
        var resultArr = array.copyOf()
        quickSort(resultArr)
        checkResult(originArr, resultArr)

        resultArr = array.copyOf()
        addRepetition(resultArr)
        quickSort(resultArr)
        checkResult(originArr, resultArr)
    }

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
        i = i/4 - 1
    }
}

fun checkResult(originArr: IntArray, resultArr: IntArray) {
    if (!checkResult(resultArr)) {
        println("-----Error Result:-----")
        println(Arrays.toString(resultArr))
        println("-----Error Origin-----")
        println(Arrays.toString(originArr))
        println()
        println()
    } else {
        println("-----SUCCESS-----")
        println()
        println()

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