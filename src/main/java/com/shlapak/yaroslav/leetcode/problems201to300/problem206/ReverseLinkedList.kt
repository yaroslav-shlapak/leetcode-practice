package com.shlapak.yaroslav.leetcode.problems201to300.problem206

import com.shlapak.yaroslav.leetcode.utils.ListNode

/**
 * 206. Reverse Linked List
 * https://leetcode.com/problems/reverse-linked-list/description/
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