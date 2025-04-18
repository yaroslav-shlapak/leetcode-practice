package com.shlapak.yaroslav.leetcode.problems1to100.problem61

import com.shlapak.yaroslav.leetcode.utils.ListNode

/**
 * 61. Rotate linked list
 * https://leetcode.com/problems/rotate-list/description/
 */
class RotateLinkedList {
    fun rotateRight(head: ListNode?, k: Int): ListNode? {
        var fast = head
        var slow = head
        // find size
        var count = 1
        while (fast?.next != null) {
            count++
            fast = fast.next
        }

        // find the shift
        val rotations = k % count
        if (rotations == 0) return head // return head if rotation is not required
        count = 0
        fast = head
        while (count < rotations) {
            fast = fast?.next
            count++
        }

        // run to the end, so the slow.next points to the new head
        while (fast?.next != null) {
            fast = fast.next
            slow = slow?.next
        }

        // relink
        val res = slow?.next
        slow?.next = null
        fast?.next = head

        return res
    }
}