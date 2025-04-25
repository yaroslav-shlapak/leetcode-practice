package com.shlapak.yaroslav.leetcode.problems101to200.problem143

import com.shlapak.yaroslav.leetcode.utils.ListNode
import java.util.LinkedList

/**
 * 143. Reorder List
 * https://leetcode.com/problems/reorder-list/description/
 */
class ReorderList {
    fun reorderList(head: ListNode?): Unit {
        // find middle
        var slow = head
        var fast = head?.next
        while (fast?.next != null) {
            slow = slow?.next
            fast = fast.next?.next
        }

        // reverse second half
        var prev: ListNode? = null
        var curr = slow
        while (curr != null) {
            val temp = curr.next
            curr.next = prev
            prev = curr
            curr = temp
        }

        // merge two halves
        var tail = prev
        var start = head
        while (tail != null) {
            val startNext = start?.next
            val tailNext = tail.next
            start?.next = tail
            start?.next?.next = startNext
            tail = tailNext
            start = startNext
        }
    }

    fun reorderList_usingStack(head: ListNode?): Unit {
        val stack = LinkedList<ListNode>()

        var curr = head
        while (curr != null) {
            stack.addFirst(curr)
            curr = curr.next
        }

        curr = head
        for (i in 0 until stack.size / 2) {
            val next = curr?.next
            curr?.next = stack.removeFirst()
            curr?.next?.next = next
            curr = next
        }
        curr?.next = null
    }
}