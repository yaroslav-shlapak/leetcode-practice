package com.shlapak.yaroslav.leetcode.problems1501to1600.problem1534

/**
 * 1534. Count Good Triplets
 * https://leetcode.com/problems/count-good-triplets/
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