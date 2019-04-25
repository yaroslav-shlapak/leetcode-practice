package com.shlapak.yaroslav.leetcode.problem19

/**
 * Created on 2019/04/25.
 */
/**
 * Example:
 * var li = ListNode(5)
 * var v = li.`val`
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 * https://leetcode.com/problems/remove-nth-node-from-end-of-list/
 */
class Solution {
    fun removeNthFromEndFirst(head: ListNode?, n: Int): ListNode? {
        return if (head == null) {
            null
        } else {
            val map = mutableMapOf<Int, ListNode?>()
            var next = head
            var count = 0
            while (next != null) {
                map.put(count, next)
                next = next.next
                count++
            }
            val key = count - 1 - n
            val ln = map[key]
            println("key: $key, val: ${ln?.`val`}")
            ln?.next = ln?.next?.next

            if (key < 0) head.next else head
        }
    }

    fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {
        return if (head == null) {
            null
        } else {
            val list = mutableListOf<ListNode?>()
            var next = head
            while (next != null) {
                list.add(next)
                next = next.next
            }
            val index = list.size - n - 1
            val ln = list.getOrNull(index)
            println("index: $index, val: ${ln?.`val`}")
            ln?.next = ln?.next?.next

            if (index < 0) head.next else head
        }
    }
}

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}