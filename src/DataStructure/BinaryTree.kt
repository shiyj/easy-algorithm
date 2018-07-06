import kotlin.math.log

class Node {
    var left: Node? = null
    var right: Node? = null
    var value: Int = 0
}

open class BasicContainer {

    var arr: MutableList<Node> = mutableListOf()

    fun push(obj: Node?) {
        if (null != obj) {
            this.arr.add(obj)
        }
    }

    open fun top(): Node? {
        return null
    }

    fun pop(): Node? {
        val n = this.top()
        if (null != n) {
            this.arr.remove(n)
        }
        return n
    }
}

class Stack : BasicContainer() {

    override fun top(): Node? {
        if (this.arr.count() < 1) {
            return null
        }
        return this.arr.last()
    }
}

class Queue : BasicContainer() {

    override fun top(): Node? {
        if (this.arr.count() < 1) {
            return null
        }
        return this.arr.first()
    }
}

fun treeTest() {
    val node = generateNode()
    deepFirstSearch(node)
    println("======")
    deepFirstSearchRecursive(node)
    println("=====")
    breadthFirstSearch(node)
}

fun isBottomNode(i: Int, count: Int): Boolean {
    // '.' count= 2^(n+1) - 1
    // .'. n = log(count + 1) - 1

    val deep = Math.ceil(log((count + 1).toDouble(), 2.0) - 1).toInt()
    val currentDeep = Math.ceil(log((i + 1).toDouble(), 2.0) - 1).toInt()

    if (deep == currentDeep) {
        return true
    }
    return false
}

fun generateNode(): Node {
    val arr = intArrayOf(1, 2, 3, 4, 5, 6, 7)
    val node = Node()
    val q = Queue()
    q.push(node)

    for (i in arr) {
        val currentNode = q.pop()
        currentNode!!.value = i

        if (isBottomNode(i, arr.count())) {
            continue
        }

        if (null == currentNode.left) {
            currentNode.left = Node()
            q.push(currentNode.left)
        }

        if (null == currentNode.right) {
            currentNode.right = Node()
            q.push(currentNode.right)
        }
    }
    return node
}

fun deepFirstSearchRecursive(node: Node?) {
    if (null != node) {
        println(node.value)
        deepFirstSearchRecursive(node.left)
        deepFirstSearchRecursive(node.right)
    }
}


fun deepFirstSearch(node: Node) {

    val s = Stack()
    s.push(node)

    while (null != s.top()) {
        val currentNode = s.pop()
        println(currentNode!!.value)
        if (null != currentNode.right) {
            s.push(currentNode.right)
        }
        if (null != currentNode.left) {
            s.push(currentNode.left)
        }
    }

}

fun breadthFirstSearch(node: Node) {
    val q = Queue()
    q.push(node)
    while (null != q.top()) {
        val currentNode = q.pop()
        println(currentNode!!.value)
        q.push(currentNode.left)
        q.push(currentNode.right)
    }
}