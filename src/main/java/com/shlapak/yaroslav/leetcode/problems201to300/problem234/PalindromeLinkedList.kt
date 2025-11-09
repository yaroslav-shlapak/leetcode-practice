package com.shlapak.yaroslav.leetcode.problems201to300.problem234

import com.shlapak.yaroslav.leetcode.utils.ListNode


/**
 * https://leetcode.com/problems/palindrome-linked-list/
 */
class PalindromeLinkedList {

    class BruteForce {
        fun isPalindrome(head: ListNode?): Boolean {
            val values = mutableListOf<Int>()
            var pointer = head
            while (pointer != null) {
                values.add(pointer.`val`)
                pointer = pointer.next
            }
            var l = 0
            var r = values.size - 1
            while (l < r) {
                if (values[l] != values[r]) return false
                l++
                r--
            }
            return true
        }
    }

    class InPlaceReversal {
        class Solution {
            fun isPalindrome(head: ListNode?): Boolean {
                // find middle then reverse the remaining part then check if values are the same
                var p1 = head
                var p2 = head?.next
                var p3: ListNode? = null
                // find middle
                while (p2 != null) {
                    p3 = p1
                    p1 = p1?.next
                    p2 = p2?.next?.next
                }
                p3?.next = null
                p2 = reverseList(p1)
                p1 = head
                while (p1 != null) {
                    if (p1?.`val` != p2?.`val`) {
                        return false
                    }
                    p1 = p1?.next
                    p2 = p2?.next
                }
                return true
            }

            fun reverseList(head: ListNode?): ListNode? {
                var cur = head
                var prev: ListNode? = null
                while (cur != null) {
                    val temp = cur.next
                    cur.next = prev
                    prev = cur
                    cur = temp
                }

                return prev
            }

        }
    }

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