package com.shlapak.yaroslav.leetcode.problem25

import com.shlapak.yaroslav.leetcode.utils.ListNode

/**
 * Created on 2019/05/12.
 * https://leetcode.com/problems/reverse-nodes-in-k-group/
 */
class Solution {
    fun reverseKGroup(head: ListNode?, k: Int): ListNode? {
        if (head == null || k < 2)
            return head

        val fake = ListNode(0)
        fake.next = head
        var prev: ListNode? = fake
        var i = 0

        var p = head
        while (p != null) {
            i++
            if (i % k == 0) {
                prev = reverse(prev, p?.next)
                p = prev?.next
            } else {
                p = p.next
            }
        }

        return fake.next
    }

    private fun reverse(prev: ListNode?, next: ListNode?): ListNode? {
        val last = prev?.next
        var curr = last?.next

        while (curr != next) {
            last?.next = curr?.next
            curr?.next = prev?.next
            prev?.next = curr
            curr = last?.next
        }

        return last
    }
}