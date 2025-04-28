package com.shlapak.yaroslav.leetcode.problems701to800.problem703

import java.util.PriorityQueue

/**
 * 703. Kth Largest Element in a Stream
 * https://leetcode.com/problems/kth-largest-element-in-a-stream/
 */

class KthLargest(private val k: Int, nums: IntArray) {
    private val minQueue = PriorityQueue<Int>()

    init {
        for (n in nums) {
            add(n)
        }
    }

    fun add(`val`: Int): Int {
        minQueue.offer(`val`)
        if (minQueue.size > k) {
            minQueue.poll()
        }
        return minQueue.peek()
    }

}