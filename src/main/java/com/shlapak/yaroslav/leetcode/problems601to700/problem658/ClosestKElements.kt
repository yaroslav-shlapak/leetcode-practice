package com.shlapak.yaroslav.leetcode.problems601to700.problem658


import java.util.PriorityQueue
import kotlin.math.abs

/**
 * 658. Find K Closest Elements
 * https://leetcode.com/problems/find-k-closest-elements/
 */
class ClosestKElements {
    fun findClosestElements5(arr: IntArray, k: Int, x: Int): IntArray {
        // |a - x| < |b - x|, or
        // |a - x| == |b - x| and a < b
        // Input: arr = [1,1,2,3,4,5], k = 4, x = -1
        //Output: [1,1,2,3] -> 2,3,4,5
        //
        val minHeap = PriorityQueue<Int>(k + 1) { o1, o2 -> // 1, -1, 0
            if (abs(o1 - x) == abs(o2 - x)) {
                o2.compareTo(o1)  // 1, -1, 0
            } else {
                abs(o2 - x).compareTo(abs(o1 - x)) // 1,1,2,3 -> 2, 2, 3, 4
            }
        }

        for (a in arr) { // N
            minHeap.offer(a) // O(logN)
            if (minHeap.size > k) {
                minHeap.poll() // O(logN)
            }
        }

        val res = IntArray(k)

        for (i in 0 until minHeap.size) { // N
            res[i] = minHeap.poll()
        }
        res.sort()
        return res
    }

    fun findClosestElements(arr: IntArray, k: Int, x: Int): List<Int> {
        val res = mutableListOf<Int>()
        var l = 0
        var r = arr.size - k
        while (l < r) {
            val mid = (l + r) / 2
            if (x - arr[mid] > arr[mid + k] - x) {
                l = mid + 1
            } else {
                r = mid
            }
        }

        for (i in 0 until k) {
            res.add(arr[l + i])
        }
        return res
    }

    fun findClosestElements2(arr: IntArray, k: Int, x: Int): List<Int> {
        val minHeap = PriorityQueue<Pair<Int, Int>>() { o1, o2 ->
            if (o1.second == o2.second) {
                o2.first.compareTo(o1.first)
            } else {
                o2.second.compareTo(o1.second)
            }
        }
        for (e in arr) {
            minHeap.offer(e to abs(e - x))
            if (minHeap.size > k) {
                minHeap.poll()
            }
        }

        return minHeap.toList().map { it.first }.sorted()
    }


    fun findClosestElements3(arr: IntArray, k: Int, x: Int): List<Int> {
        val minHeap: PriorityQueue<Pair<Int, Int>> = PriorityQueue<Pair<Int, Int>>(
            compareBy<Pair<Int, Int>> { it.first }.thenBy { it.second }
        )

        for (i in 0 until arr.size) {
            minHeap.offer(Pair(abs(arr[i] - x), arr[i]))
        }

        val res = mutableListOf<Int>()

        repeat(k) {
            val (diff, value) = minHeap.poll()
            res.add(value)
        }

        return res.sorted()
    }

}

class Solution {
    fun findClosestElements(arr: IntArray, k: Int, x: Int): List<Int> {
        // Create a max heap that stores pairs of (element, absolute difference from x)
        // The heap is ordered by:
        // 1. Descending order of absolute difference (so largest differences are at top)
        // 2. Descending order of element value (so larger elements come first when differences are equal)
        // This ensures we can efficiently remove the "farthest" element when needed
        val maxHeapByDistance: PriorityQueue<Pair<Int, Int>> = PriorityQueue<Pair<Int, Int>>(
            compareByDescending<Pair<Int, Int>> { it.second }.thenByDescending { it.first }
        )

        for (element in arr) {
            val absDiff = abs(element - x)
            maxHeapByDistance.offer(element to absDiff)

            // If heap size exceeds k, remove the element according to the rule
            if (maxHeapByDistance.size > k) {
                maxHeapByDistance.poll()
            }
        }

        // Convert the heap to a list of the elements,
        // and sort them to return in ascending order
        return maxHeapByDistance.map { it.first }.sorted()
    }
}

