fun euclideanTest() {
    euclideanValidate(12, 16, 4)
    euclideanValidate(13, 16, 1)
    euclideanValidate(24, 16, 8)
    euclideanValidate(30, 100, 10)
    euclideanValidate(10, 100, 10)
    euclideanValidate(12, 15, 3)

}

fun euclideanValidate(a: Int, b: Int, expect: Int) {
    val result = euclidean(a, b)
    if (result != expect) {
        println("error: expect is $expect, But result is $result")
    }
}

fun euclidean(a: Int, b: Int): Int {
    var max = a
    var min = b


    while (min > 0 && max > 0) {
        if (min > max) {
            val tmp = max
            max = min
            min = tmp
        }

        max -= min

    }

    return if (max > min) {
        max
    } else {
        min
    }

}