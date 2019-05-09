package com.shlapak.yaroslav.leetcode.utils

/**
 * Created on 2019/05/09.
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

fun ListNode?.toString(): String {
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