package com.shlapak.yaroslav.leetcode.problems.p0876

import com.shlapak.yaroslav.leetcode.common.ListNode

/**
 * LeetCode 876: Middle of the Linked List.
 *
 * Finds the middle node of a linked list.
 *
 * @see <a href="https://leetcode.com/problems/middle-of-the-linked-list/">Problem statement</a>
 */
class MiddleOfLinkedList {
    fun middleNode(head: ListNode?): ListNode? {
        var mid = head
        var curr = head?.next
        while(curr != null) {
            mid = mid?.next
            curr = curr.next?.next
        }
        return mid
    }

    fun middleNode2(head: ListNode?): ListNode? {
        var count = 1
        var curr = head
        while(curr?.next != null) {
            count++
            curr = curr.next
        }
        val mid = count / 2 + 1
        count = 1
        curr = head

        while(count < mid) {
            count++
            curr = curr?.next
        }
        return curr
    }
}
