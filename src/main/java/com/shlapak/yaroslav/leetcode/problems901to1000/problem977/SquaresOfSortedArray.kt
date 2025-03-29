package com.shlapak.yaroslav.leetcode.problems901to1000.problem977

import kotlin.math.min
import kotlin.math.sqrt

class SquaresOfSortedArray {
    fun sortedSquares(nums: IntArray): IntArray {
        if (nums.isEmpty()) return nums
        val res = IntArray(nums.size)
        var l = 0
        var r = nums.size - 1
        var i = nums.size - 1

        while (r >= l) {
            val rNum = square(nums[r])
            val lNum = square(nums[l])

            if (rNum >= lNum) {
                res[i] = rNum
                i--
                r--
            } else {
                res[i] = lNum
                i--
                l++
            }
        }

        return res
    }

    private fun square(num: Int) = num * num
}
class SquaresOfSortedArray_BruteForce {
    fun sortedSquares(nums: IntArray): IntArray {
        return nums.map { it * it }.sorted().toIntArray()
    }
}