package com.shlapak.yaroslav.leetcode.problems1to100.problem2

import com.shlapak.yaroslav.leetcode.utils.ListNode

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

class AddTwoNumbers {
    fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
        var cur1 = l1
        var cur2 = l2
        var cur: ListNode = ListNode(0)
        val res = cur
        var quo = 0
        //Input: l1 = [2,4,3], l2 = [5,6,4]
        //Output: [7,0,8]
        //Input:
        // l1 = [9,9,9,9,9,9,9]
        // l2 = [9,9,9,9]
        //      [8,9,9,9,0,0,0,1]
        while (cur1 != null || cur2 != null || quo != 0) {
            val value = (cur1?.`val` ?: 0) + (cur2?.`val` ?: 0) + quo
            val rem = value % 10
            quo = value / 10
            val newNode = ListNode(rem)
            cur.next = newNode
            cur = newNode
            cur1 = cur1?.next
            cur2 = cur2?.next
        }
        return res.next
    }
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