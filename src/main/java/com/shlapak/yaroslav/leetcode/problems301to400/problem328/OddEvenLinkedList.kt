package com.shlapak.yaroslav.leetcode.problems301to400.problem328

import com.shlapak.yaroslav.leetcode.utils.ListNode

/**
 * 328. Odd Even Linked List
 * https://leetcode.com/problems/odd-even-linked-list/description/
 */
class OddEvenLinkedList {
    fun oddEvenList(head: ListNode?): ListNode? {
        var odd: ListNode? = ListNode(0)
        var even: ListNode? = ListNode(0)
        val evenStart = even
        var oddStart = odd
        var count = 1
        var curr = head
        while (curr != null) {
            if (count % 2 == 0) {
                even?.next = curr
                even = even?.next
            } else {
                odd?.next = curr
                odd = odd?.next
            }
            curr = curr.next
            count++
        }
        even.next = null
        odd.next = evenStart.next
        return oddStart.next
    }
}