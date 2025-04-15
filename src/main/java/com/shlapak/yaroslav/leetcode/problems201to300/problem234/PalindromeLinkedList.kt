package com.shlapak.yaroslav.leetcode.problems201to300.problem234

import com.shlapak.yaroslav.leetcode.utils.ListNode

class PalindromeLinkedList {
    fun isPalindrome2(head: ListNode?): Boolean {
        if (head == null) return true
        val middle = head.findMiddle()
        println(middle?.next?.`val`)
        middle?.next = middle?.next?.reverse()
        println(middle?.next?.`val`)
        var p1 = head
        var p2 = middle?.next
        while (p1 != null && p2 != null && p1.`val` == p2.`val`) {
            p1 = p1.next
            p2 = p2.next
        }
        return p2 == null
    }

    private fun ListNode.findMiddle(): ListNode? {
        var slow: ListNode? = this
        var fast = slow?.next
        while (fast?.next != null) {
            slow = slow?.next
            fast = fast.next?.next
        }
        return slow
    }

    private fun ListNode.reverse(): ListNode? {
        var head: ListNode? = this
        var pointer: ListNode? = null
        while (head != null) {
            val temp = head.next
            head.next = pointer
            pointer = head
            head = temp
        }
        return pointer
    }

    fun isPalindrome(head: ListNode?): Boolean {
        if (head == null) return true

        // find middle - 1
        var mid = head
        var curr = head?.next
        while (curr?.next != null) {
            mid = mid?.next
            curr = curr.next?.next
        }

        // reverse the list to the right of mid
        var prev: ListNode? = null
        curr = mid?.next
        while (curr != null) {
            val temp = curr.next
            curr.next = prev
            prev = curr
            curr = temp
        }
        // check palindrome
        var head = head
        var tail = prev
        while (tail != null && head != null && head.`val` ==  tail.`val`) {
            tail = tail.next
            head = head.next
        }

        return tail == null
    }
}