package com.shlapak.yaroslav.leetcode.problems2101ro2200.problem2196

import com.shlapak.yaroslav.leetcode.utils.TreeNode

/**
 * 2130 maximum twin sum of a linked list
 *
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
class MaximumTwinSumOfaLinkedList {

    class ReverseList {
        fun pairSum(head: ListNode?): Int {
            // find mid
            var s = head
            var f = head
            //f             |
            // [1,2,4,7,6,2]
            //s       |
            while (f != null) {
                s = s?.next
                f = f.next?.next
            }

            var cur = s
            var prev: ListNode? = null

            while (cur != null) {
                //  [1->2->4] -> [4->2->1->null
                //         |
                // 2->1->null
                val tmp = cur.next // 2
                cur.next = prev
                prev = cur // 1
                cur = tmp
            }

            /*
            [1,2,4,2,6,7] ->
                    |
            [1,2,4,7,6,2]

            */

            var m = prev
            s = head
            var max = 0
            while (m != null) {
                max = maxOf(max, (m?.`val` ?: 0) + (s?.`val` ?: 0))
                m = m.next
                s = s?.next
            }

            return max
        }
    }

    class BruteForce {
        fun pairSum(head: ListNode?): Int {
            val values = mutableListOf<Int>()
            var curr = head
            while (curr != null) {
                values.add(curr.`val`)
                curr = curr.next
            }
            var res = 0
            for (i in 0 until values.size / 2) {
                res = maxOf(res, values[i] + values[values.size - 1 - i])
            }
            return res
        }
    }
}