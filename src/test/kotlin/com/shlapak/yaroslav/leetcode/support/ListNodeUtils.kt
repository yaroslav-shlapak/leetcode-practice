package com.shlapak.yaroslav.leetcode.support

import com.shlapak.yaroslav.leetcode.common.ListNode

/**
 * Builds a new linked list containing these values in order.
 *
 * Returns null for a null or empty receiver.
 *
 * Time: O(n).
 * Space: O(n) for the returned nodes.
 */
fun List<Int>?.toListNode(): ListNode? {
    return if (this.isNullOrEmpty()) {
        null
    } else {
        val root = ListNode(this[0])
        var next: ListNode? = root
        this.asSequence().forEachIndexed { index, value ->
            if (index > 0) {
                next?.next = ListNode(this[index])
                next = next?.next
            }
        }
        root
    }
}

/**
 * Formats the node values separated by arrows for test diagnostics.
 *
 * Requires an acyclic list. A null receiver produces an empty string.
 *
 * Time: O(n), excluding integer formatting.
 * Space: O(n) for the result.
 */
fun ListNode?.asString(): String {
    val s = StringBuilder()
    if (this != null) {
        var next = this
        while (next != null) {
            s.append(next.`val`)
            if (next.next != null) {
                s.append(" -> ")
            }
            next = next.next
        }
    }
    return s.toString()
}

/**
 * Collects node values in traversal order.
 *
 * Requires an acyclic list. A null receiver produces an empty list.
 *
 * Time: O(n).
 * Space: O(n) for the result.
 */
fun ListNode?.toIntList(): List<Int> {
    val list = mutableListOf<Int>()
    if (this != null) {
        var next = this
        while (next != null) {
            list.add(next.`val`)
            next = next.next
        }
    }
    return list
}

/**
 * Copies the head node while sharing the remainder of the list.
 *
 * This is a shallow copy: the returned node retains the original next pointer.
 * Returns null for a null receiver.
 *
 * Time: O(1).
 * Space: O(1).
 */
fun ListNode?.copy(): ListNode? {
    return if (this == null) {
        null
    } else {
        val res = ListNode(this.`val`)
        val next = this.next
        res.next = this.next
        res
    }
}
