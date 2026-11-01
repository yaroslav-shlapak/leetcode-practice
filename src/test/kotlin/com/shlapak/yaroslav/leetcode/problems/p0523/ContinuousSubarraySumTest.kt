package com.shlapak.yaroslav.leetcode.problems.p0523

import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.shouldBe

/**
 * Tests [ContinuousSubarraySum] with examples, length and zero-sum edge cases,
 * large values, input preservation, and exhaustive comparisons against subarray sums.
 */
class ContinuousSubarraySumTest : FreeSpec({
    val solution = ContinuousSubarraySum()

    "handles the problem examples" {
        solution.checkSubarraySum(intArrayOf(23, 2, 4, 6, 7), 6) shouldBe true
        solution.checkSubarraySum(intArrayOf(23, 2, 6, 4, 7), 6) shouldBe true
        solution.checkSubarraySum(intArrayOf(23, 2, 6, 4, 7), 13) shouldBe false
    }

    "requires at least two elements" {
        solution.checkSubarraySum(intArrayOf(), 6) shouldBe false
        solution.checkSubarraySum(intArrayOf(6), 6) shouldBe false
        solution.checkSubarraySum(intArrayOf(0), 6) shouldBe false
        solution.checkSubarraySum(intArrayOf(1, 6), 6) shouldBe false
    }

    "recognizes a divisible prefix and zero-sum subarrays" {
        solution.checkSubarraySum(intArrayOf(2, 4), 6) shouldBe true
        solution.checkSubarraySum(intArrayOf(0, 0), 7) shouldBe true
        solution.checkSubarraySum(intArrayOf(1, 0, 0), 7) shouldBe true
        solution.checkSubarraySum(intArrayOf(0, 1, 0), 7) shouldBe false
    }

    "keeps the earliest index when a remainder repeats" {
        solution.checkSubarraySum(intArrayOf(1, 0, 0), 2) shouldBe true
    }

    "handles one and the largest positive divisor" {
        solution.checkSubarraySum(intArrayOf(1, 2), 1) shouldBe true
        solution.checkSubarraySum(intArrayOf(Int.MAX_VALUE - 1, 1), Int.MAX_VALUE) shouldBe true
        solution.checkSubarraySum(intArrayOf(Int.MAX_VALUE - 1, 2), Int.MAX_VALUE) shouldBe false
    }

    "handles maximum input length without a qualifying subarray" {
        solution.checkSubarraySum(IntArray(100_000) { 1 }, Int.MAX_VALUE) shouldBe false
    }

    "preserves the input" {
        val nums = intArrayOf(23, 2, 4, 6, 7)
        val original = nums.toList()

        solution.checkSubarraySum(nums, 6) shouldBe true

        nums.toList() shouldBe original
    }

    "matches brute-force subarray sums for short arrays" {
        for (size in 0..6) {
            var combinations = 1
            repeat(size) { combinations *= 3 }
            for (encoding in 0 until combinations) {
                var remaining = encoding
                val nums = IntArray(size) {
                    val value = remaining % 3
                    remaining /= 3
                    value
                }
                for (k in 1..7) {
                    var expected = false
                    for (start in nums.indices) {
                        var sum = 0L
                        for (end in start until nums.size) {
                            sum += nums[end]
                            if (end - start >= 1 && sum % k == 0L) {
                                expected = true
                            }
                        }
                    }

                    solution.checkSubarraySum(nums, k) shouldBe expected
                }
            }
        }
    }
})

// TODO review
