package com.shlapak.yaroslav.leetcode.problems101to200.problem138

/**
 * 138. Copy List with Random Pointer
 * https://leetcode.com/problems/copy-list-with-random-pointer/description/
 */
class CopyWithRandomPointer {
    fun copyRandomList(node: Node?): Node? {
        if (node == null) return null
        var curr = node
        // add each node to map with node created
        val map = mutableMapOf<Node, Node>()
        while (curr != null) {
            map[curr] = Node(curr.`val`)
            curr = curr.next
        }
        curr = node
        // Link each node
        while (curr != null) {
            val newCurr = map[curr]
            newCurr?.next = if (curr.next == null) null else map[curr.next]
            newCurr?.random = if (curr.random == null) null else map[curr.random]
            curr = curr.next
        }

        return map[node]
    }
}

class Node(var `val`: Int) {
    var next: Node? = null
    var random: Node? = null
}
