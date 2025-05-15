package com.shlapak.yaroslav.leetcode.problems1to100.pronblem92

import com.shlapak.yaroslav.leetcode.utils.ListNode

class ReverseLinkedList2 {
    fun reverseBetween(head: ListNode?, left: Int, right: Int): ListNode? {
        // 0. Using dummy head is crucial here to address cases when reversal starts from the 1st node
        val dummy = ListNode(0)
        dummy.next = head

        // 1. Find the node before the reversal segment starts.
        var curr: ListNode? = dummy
        for (i in 1 until left) {
            curr = curr?.next
        }

        val beforeLeft = curr  // Node at index (left - 1)
        // The original node at index 'left', which will become the tail of the reversed segment.
        val reversalTail = curr?.next

        // 2. Reverse the nodes from 'left' to 'right'.
        var prev: ListNode? = null
        curr = reversalTail
        for (i in 0..(right - left)) {
            val temp = curr?.next
            curr?.next = prev
            prev = curr
            curr = temp
        }

        // The original node at index 'right', which is now the head of the reversed segment.
        val reversalHead = prev
        val afterRight = curr // Node at index (right + 1)

        // 3a. Connect the part before the segment to the new head of the reversed segment.
        beforeLeft?.next = reversalHead

        // 3b. Connect the new tail of the reversed segment (original 'left'-th node) to the part after the segment.
        reversalTail?.next = afterRight

        // 4.
        return dummy.next
    }
}