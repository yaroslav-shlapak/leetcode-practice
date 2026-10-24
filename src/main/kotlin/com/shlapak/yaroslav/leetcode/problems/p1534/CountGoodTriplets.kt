package com.shlapak.yaroslav.leetcode.problems.p1534

/**
 * LeetCode 1534: Count Good Triplets.
 *
 * Counts index-ordered triplets satisfying three distance bounds.
 *
 * @see <a href="https://leetcode.com/problems/count-good-triplets/">Problem statement</a>
 */
class CountGoodTriplets {
    fun countGoodTriplets(arr: IntArray, a: Int, b: Int, c: Int): Int {
        var count = 0
        for (i in arr.indices) {
            for (j in i + 1 until arr.size) {
                if (abs(arr[i] - arr[j]) > a) continue
                for (k in j + 1 until arr.size) {
                    if (
                        abs(arr[j] - arr[k]) <= b &&
                        abs(arr[i] - arr[k]) <= c
                    ) {
                        count++
                    }
                }
            }
        }
        return count
    }
}
