package com.shlapak.yaroslav.leetcode.problems.p0703

import java.util.PriorityQueue

/**
 * LeetCode 703: Kth Largest Element in a Stream.
 *
 * Maintains the kth largest value as numbers arrive in a stream.
 *
 * @see <a href="https://leetcode.com/problems/kth-largest-element-in-a-stream/">Problem statement</a>
 */
class KthLargest(private val k: Int, nums: IntArray) {

    private val minHeap = PriorityQueue<Int>() // space: O(N)

    init {
        for (n in nums) { // O(N log k)
            add(n)
        }
    }

    fun add(`val`: Int): Int {
        minHeap.offer(`val`) // O(log k)
        if (minHeap.size > k) {
            minHeap.poll() // O(log k)
        }
        return minHeap.peek() // O(1)
    }

}

class KthLargest2(private val k: Int, nums: IntArray) {

    private val store = PriorityQueue<Int>()

    init {
        for (n in nums) {
            store.offer(n)
        }
        while (store.size > k) {
            store.poll()
        }
    }

    fun add(`val`: Int): Int {
        store.offer(`val`)
        if (store.size > k) {
            store.poll()
        }
        return store.peek()
    }

}
