package com.shlapak.yaroslav.leetcode.problems1501to1600.problem1574

/**
 * 1574. Shortest Subarray to be Removed to Make Array Sorted
 * https://leetcode.com/problems/shortest-subarray-to-be-removed-to-make-array-sorted/description/
 */
class ShortestSubarrayToBeRemovedToMakeArraySorted {
    class TwoPointers {
        fun findLengthOfShortestSubarray(arr: IntArray): Int {
            val n = arr.size
            var r = n - 1
            var l = 0
            while (r > 0 && arr[r] >= arr[r - 1]) {
                r--
            }
            if (r == 0) return 0

            var res = r

            while (l < n) {
                if (l > 0 && arr[l] < arr[l - 1]) {
                    break
                }
                /*
                arr = [1, 2, 3, 10, 4, 2, 3, 5]
                             l         r
                 */

                while (r < n && arr[l] > arr[r]) {
                    r++
                    println("l: $l, r: $r")
                }

                res = minOf(res, r - l - 1)

                l++
            }

            return res
        }
    }
}