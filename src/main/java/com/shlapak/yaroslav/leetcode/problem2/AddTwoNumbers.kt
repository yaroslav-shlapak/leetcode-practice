package com.shlapak.yaroslav.leetcode.problem2

/**
 * Created on 2019/04/08.
 */
/**
 * Example:
 * var li = ListNode(5)
 * var v = li.`val`
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */
class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

class Solution {
    fun addTwoNumbers2(l1: ListNode?, l2: ListNode?): ListNode? {

        if (l1 != null && l2 != null) {
            var next1 = l1
            var next2 = l2
            var div = 0
            var root: ListNode? = null
            var res: ListNode? = root
            while (next1 != null || next2 != null) {
                val sum = (next1?.`val` ?: 0) + (next2?.`val` ?: 0) + div
                val rem = sum % 10
                div = sum / 10
                if (root == null) {
                    root = ListNode(rem)
                    res = root
                } else {
                    res?.next = ListNode(rem)
                    res = res?.next
                }
                next1 = next1?.next
                next2 = next2?.next
                println("rem: $rem, sum: $sum, div: $div")
            }
            if (div > 0) {
                println("div: $div")
                res?.next = ListNode(div)
            }
            return root
        } else {
            return null
        }
    }

    fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {

        if (l1 != null && l2 != null) {
            var next1 = l1
            var next2 = l2
            var div = 0
            var root: ListNode? = null
            var res: ListNode? = root
            while (next1 != null || next2 != null) {
                val sum = (next1?.`val` ?: 0) + (next2?.`val` ?: 0) + div
                val rem = sum % 10
                div = sum / 10
                if (root == null) {
                    root = ListNode(rem)
                    res = root
                } else {
                    res?.next = ListNode(rem)
                    res = res?.next
                }
                next1 = next1?.next
                next2 = next2?.next
                println("rem: $rem, sum: $sum, div: $div")
            }
            if (div > 0) {
                println("div: $div")
                res?.next = ListNode(div)
            }
            return root
        } else {
            return null
        }
    }
}

fun main() {

}