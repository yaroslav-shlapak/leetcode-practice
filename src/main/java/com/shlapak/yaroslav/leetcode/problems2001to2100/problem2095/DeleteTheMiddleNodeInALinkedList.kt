package com.shlapak.yaroslav.leetcode.problems2001to2100.problem2095

import com.shlapak.yaroslav.leetcode.utils.ListNode

/**
 * 2095. Delete the Middle Node of a Linked List
 * https://leetcode.com/problems/delete-the-middle-node-of-a-linked-list/description/
 */
class DeleteTheMiddleNodeInALinkedList {
    fun deleteMiddle(head: ListNode?): ListNode? {
        if (head?.next == null) return null
        var fast = head
        var slow = head
        var prev: ListNode? = null
        var count = 0
        while (fast?.next != null) {
            prev = slow
            slow = slow?.next
            fast = fast.next?.next
            count++
        }

        prev?.next = prev?.next?.next

        return head
    }
}