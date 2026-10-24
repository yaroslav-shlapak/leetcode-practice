package com.shlapak.yaroslav.leetcode.problems.p0024

import com.shlapak.yaroslav.leetcode.common.ListNode

/**
 * LeetCode 24: Swap Nodes in Pairs.
 *
 * Swaps adjacent nodes in a linked list.
 *
 * @see <a href="https://leetcode.com/problems/swap-nodes-in-pairs/">Problem statement</a>
 */
class SwapNodesInPairs {
    fun swapPairs(head: ListNode?): ListNode? {
        if (head?.next == null) {
            return head
        }
        var next = head
        var nextNext = head?.next
        val first = ListNode(0)
        first.next = nextNext
        var prev: ListNode? = null
        while (next != null && nextNext != null) {

            next.next = nextNext.next
            nextNext.next = next
            prev?.next = nextNext
            prev = next

            next = next.next
            nextNext = next?.next
        }
        return first.next
    }
}
