package com.shlapak.yaroslav.leetcode.problems1to100.problem19

import com.shlapak.yaroslav.leetcode.utils.ListNode

/**
 * Created on 2019/04/25.
 */
/**
 * Example:
 * var li = ListNode(5)
 * var v = li.`val`
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 * https://leetcode.com/problems/remove-nth-node-from-end-of-list/
 */
class RemoveNthNodeFromEndOfList {
    fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {
        // Dummy node to handle edge cases (e.g., removing the first node)
        val dummy = ListNode(0)
        dummy.next = head
        // Two pointers initially pointing to the dummy node
        var first: ListNode? = dummy
        var second: ListNode? = dummy
        // Move the first pointer `n+1` steps ahead so that there's a gap of `n` between first and second
        for (i in 0..n) {
            first = first?.next
        }
        // Move both pointers until the first one reaches the end of the list
        while (first != null) {
            first = first.next
            second = second?.next
        }
        // Now, the second pointer is at the node before the one to be removed
        second?.next = second?.next?.next
        // Return the head, which might have changed if the first node was removed
        return dummy.next
    }
}

class Solution {
    fun removeNthFromEndFirst(head: ListNode?, n: Int): ListNode? {
        return if (head == null) {
            null
        } else {
            val map = mutableMapOf<Int, ListNode?>()
            var next = head
            var count = 0
            while (next != null) {
                map.put(count, next)
                next = next.next
                count++
            }
            val key = count - 1 - n
            val ln = map[key]
            println("key: $key, val: ${ln?.`val`}")
            ln?.next = ln?.next?.next

            if (key < 0) head.next else head
        }
    }

    fun removeNthFromEndSecond(head: ListNode?, n: Int): ListNode? {
        return if (head == null) {
            null
        } else {
            val list = mutableListOf<ListNode?>()
            var next = head
            while (next != null) {
                list.add(next)
                next = next.next
            }
            val index = list.size - n - 1
            val ln = list.getOrNull(index)
            println("index: $index, val: ${ln?.`val`}")
            ln?.next = ln?.next?.next

            if (index < 0) head.next else head
        }
    }

    fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {
        val dummy = ListNode(0)
        dummy.next = head
        var first: ListNode? = dummy
        var second: ListNode? = dummy
        for (i in 1..n + 1) {
            first = first?.next
        }
        while (first != null) {
            first = first.next
            second = second?.next
        }
        second?.next = second?.next?.next
        return dummy.next
    }
}

