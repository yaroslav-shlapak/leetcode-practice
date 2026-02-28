package com.shlapak.yaroslav.leetcode.problems1to100.problem88

/**
 * 86. Partition List
 * https://leetcode.com/problems/partition-list/description/
 */
class PartitionList {
    fun partition(head: ListNode?, x: Int): ListNode? {
        if (head == null) return head
        var newHead: ListNode? = null
        var less: ListNode? = ListNode(0)
        var more: ListNode? = ListNode(0)
        val headLess = less
        val headMore = more
        var cur = head
        while (cur != null) {
            if (cur.`val` >= x) {
                more?.next = cur
                more = more?.next
            } else {
                less?.next = cur
                less = less?.next
            }
            cur = cur.next
        }
        more?.next = null

        less?.next = headMore?.next

        return headLess?.next
    }
}