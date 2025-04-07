package com.shlapak.yaroslav.leetcode.problems101to200.problem141

class LinkedListCycle {
    fun hasCycle2(head: ListNode?): Boolean {
        var p1 = head
        var p2 = head?.next
        while (p1 != null && p2 != null) {
            if (p1 == p2) {
                return true
            }
            p1 = p1.next
            p2 = p2.next?.next
        }
        return false
    }

    fun hasCycle(head: ListNode?): Boolean {
        var p1 = head
        var p2 = head
        while (p2?.next != null) {
            p1 = p1?.next
            p2 = p2.next?.next
            if (p1 == p2) {
                return true
            }

        }
        return false
    }
}

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}