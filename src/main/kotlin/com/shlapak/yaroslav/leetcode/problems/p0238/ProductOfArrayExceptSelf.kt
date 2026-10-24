package com.shlapak.yaroslav.leetcode.problems.p0238

class ProductOfArraysExceptSelf3 {
    fun productExceptSelf(nums: IntArray): IntArray {
        val res = IntArray(nums.size) { 1 }

        var lastPrefix = 1
        for (i in 0 until nums.size) {
            res[i] = lastPrefix
            lastPrefix *= nums[i]
        }

        var lastSuffix = 1
        for (i in nums.size - 1 downTo 0) {
            res[i] *= lastSuffix
            lastSuffix *= nums[i]
        }

        return res
    }
}

class ProductOfArrayExceptSelf2 {

    fun productExceptSelf(nums: IntArray): IntArray {
        val prefixes = IntArray(nums.size)
        val suffixes = IntArray(nums.size)
        val res = IntArray(nums.size)
        for (i in nums.indices) {
            when (i) {
                0 -> prefixes[i] = 1
                else -> prefixes[i] = prefixes[i - 1] * nums[i - 1]
            }
        }

        for (i in nums.size - 1 downTo 0) {
            when (i) {
                nums.size - 2 -> suffixes[i] = 1
                else -> suffixes[i] = suffixes[i + 1] * nums[i + 1]
            }
        }

        for (i in nums.indices) {
            res[i] = suffixes[i] * prefixes[i]
        }
        return res
    }
}

/**
 * LeetCode 238: Product of Array Except Self.
 *
 * Computes the product of every array element except the element at each index.
 *
 * @see <a href="https://leetcode.com/problems/product-of-array-except-self/">Problem statement</a>
 */
class ProductOfArrayExceptSelf {

    fun productExceptSelf(nums: IntArray): IntArray {
        val prefixes = IntArray(nums.size)
        val suffixes = IntArray(nums.size)
        val res = IntArray(nums.size)
        for (i in nums.indices) {
            when (i) {
                0 -> prefixes[i] = 1
                1 -> {
                    prefixes[i] = nums[i - 1]
                }

                else -> {
                    prefixes[i] = prefixes[i - 1] * nums[i - 1]
                }
            }
        }
        for (i in nums.size - 1 downTo 0) {
            when (i) {
                nums.size - 1 -> suffixes[i] = 1
                nums.size - 2 -> {
                    suffixes[i] = nums[i + 1]
                }

                else -> {
                    suffixes[i] = suffixes[i + 1] * nums[i + 1]
                }
            }
            // res[i] = prefixes[i] * suffixes[i] not sure why but moving this one here makes it slower
        }

        for (i in nums.indices) {
            res[i] = prefixes[i] * suffixes[i]
        }
        return res
    }
}
