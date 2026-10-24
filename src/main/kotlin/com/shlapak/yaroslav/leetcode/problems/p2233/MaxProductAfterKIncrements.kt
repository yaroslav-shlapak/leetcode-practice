package com.shlapak.yaroslav.leetcode.problems.p2233

import java.util.PriorityQueue

/**
 * LeetCode 2233: Maximum Product after K Increments.
 *
 * Maximizes an array's product using k single-element increments.
 *
 * @see <a href="https://leetcode.com/problems/maximum-product-after-k-increments/">Problem statement</a>
 */
class MaxProductAfterKIncrements {
    fun maximumProduct(nums: IntArray, k: Int): Int {
        val minHeap = PriorityQueue<Int>()

        for (n in nums) {
            minHeap.offer(n)
        }

        for (i in 0 until k) {
            val min = minHeap.poll()
            minHeap.offer(min + 1)
        }

        var res = 1L
        val mod = 1_000_000_007
        for (n in minHeap) {
            res = res * n
            res = res % mod
        }

        return res.toInt()
    }
}
