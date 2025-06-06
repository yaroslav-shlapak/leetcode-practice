package com.shlapak.yaroslav.leetcode.problems2001to2100.problem2099

import java.util.PriorityQueue
/**
 * 2099. Find Subsequence of Length K With the Largest Sum
 * https://leetcode.com/problems/find-subsequence-of-length-k-with-the-largest-sum/
 */
class FindSubsequenceOfLengthKWithLargestSum {
    fun maxSubsequence(nums: IntArray, k: Int): IntArray {
        val minQueue = PriorityQueue<Int>() { o1, o2 -> o2.compareTo(o1) }

        for (num in nums) {
            minQueue.offer(num)
        k) {
            val key = minQueue.poll()
            val value = map.getOrPut(key) { 0 }
            map[key] = value + 1
        }

        val res = IntArray(k)
        var i = 0
        for (num in nums) {
            val value = map[num

            val map = mutableMapOf<Int, Int>()
            for (i in 0 until ]
            if (value != null && value > 0) {
                res[i] = num
                map[num] = value - 1
                i++
            }
        }

        return res
    }
}