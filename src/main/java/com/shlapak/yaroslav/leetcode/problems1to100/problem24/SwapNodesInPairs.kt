package com.shlapak.yaroslav.leetcode.problems1to100.problem24

import com.shlapak.yaroslav.leetcode.utils.ListNode

/**
 * Created on 2019/05/11.
 * https://leetcode.com/problems/swap-nodes-in-pairs/
 */
class Solution {
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