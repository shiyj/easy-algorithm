
fun fibonacciTest() {
    val n = 10

    val result = fibonacciRecursive(n)
    println("result is $result")
    println("=============")
    fibonacciBottomUp(n)
}

// O(2^n)
fun fibonacciRecursive(n: Int): Int {
    if (1 == n || 2 == n) {
        return 1
    }
    return fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2)
}

// O(n)
fun fibonacciBottomUp(n: Int) {
    if (1 == n || 2 == n) {
        println("result is 1")
        return
    }

    var first = 1
    var second = 1
    var result = 0
    for (i in 3..n) {
        result = first + second
        first = second
        second = result
        println("$i => $result")
    }
    println("result is $result")
}