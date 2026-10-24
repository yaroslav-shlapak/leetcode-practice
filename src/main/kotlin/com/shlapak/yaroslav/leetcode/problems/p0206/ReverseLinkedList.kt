package com.shlapak.yaroslav.leetcode.problems.p0206

import com.shlapak.yaroslav.leetcode.common.ListNode

/**
 * LeetCode 206: Reverse Linked List.
 *
 * Reverses a singly linked list.
 *
 * @see <a href="https://leetcode.com/problems/reverse-linked-list/">Problem statement</a>
 */
class ReverseLinkedList {
    fun reverseList(head: ListNode?): ListNode? {
        var prev: ListNode? = null
        var curr = head

        while (curr != null) {
            val temp = curr.next
            curr.next = prev
            prev = curr
            curr = temp
        }
        return prev
    }
}
