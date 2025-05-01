package com.shlapak.yaroslav.leetcode.problems1001to1100.problem1046

import java.util.Collections
import java.util.PriorityQueue

/**
 * 1046. Last Stone Weight
 * https://leetcode.com/problems/last-stone-weight/description/
 */
class LastStoneWeight {
    fun lastStoneWeight(stones: IntArray): Int {
        // create max heap with the same size as an input array
        val maxHeap = PriorityQueue<Int>(stones.size) { a, b -> a - b }
        // put all stones to the max heap
        for (stone in stones) {
            maxHeap.offer(stone)
        }
        // [2,7,4,1,8,1] => [8,7,4,2,1,1] => [4,2,1,1,1] => [2,1,1,1] => [1,1,1] => [1]

        // evict two largest until we have less than 2 stones
        while (maxHeap.size > 1) {
            val y = maxHeap.poll()
            val x = maxHeap.poll()
            if (y > x) {
                // add to queue the difference
                maxHeap.offer(y - x)
            }
        }

        // evict the remaining stone or default to 0
        return maxHeap.poll() ?: 0
    }
}