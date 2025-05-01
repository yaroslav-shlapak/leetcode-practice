package com.shlapak.yaroslav.leetcode.problems701to800.problem703

import java.util.PriorityQueue

/**
 * 703. Kth Largest Element in a Stream
 * https://leetcode.com/problems/kth-largest-element-in-a-stream/
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

/**
 * Your KthLargest object will be instantiated and called as such:
 * var obj = KthLargest(k, nums)
 * var param_1 = obj.add(`val`)
 */