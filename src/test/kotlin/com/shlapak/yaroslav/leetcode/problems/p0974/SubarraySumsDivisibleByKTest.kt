package com.shlapak.yaroslav.leetcode.problems.p0974

import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.shouldBe

/**
 * Tests [SubarraySumsDivisibleByK] with examples, negative values, repeated remainders,
 * input preservation, and exhaustive comparisons against subarray sums.
 */
class SubarraySumsDivisibleByKTest : FreeSpec({
    val solution = SubarraySumsDivisibleByK()

    "handles the problem examples" {
        solution.subarraysDivByK(intArrayOf(4, 5, 0, -2, -3, 1), 5) shouldBe 7
        solution.subarraysDivByK(intArrayOf(5), 9) shouldBe 0
    }

    "counts divisible single elements and prefixes" {
        solution.subarraysDivByK(intArrayOf(5), 5) shouldBe 1
        solution.subarraysDivByK(intArrayOf(-5), 5) shouldBe 1
        solution.subarraysDivByK(intArrayOf(0), 5) shouldBe 1
        solution.subarraysDivByK(intArrayOf(2, 3), 5) shouldBe 1
        solution.subarraysDivByK(intArrayOf(), 5) shouldBe 0
    }

    "normalizes negative remainders to match positive remainders" {
        solution.subarraysDivByK(intArrayOf(-1, 5), 5) shouldBe 1
        solution.subarraysDivByK(intArrayOf(4, -5), 5) shouldBe 1
        solution.subarraysDivByK(intArrayOf(-1, -2, -3), 3) shouldBe 3
    }

    "counts every pair of matching prefixes" {
        solution.subarraysDivByK(intArrayOf(0, 0, 0), 5) shouldBe 6
        solution.subarraysDivByK(intArrayOf(5, -5, 10), 5) shouldBe 6
    }

    "handles the maximum array length and value bounds" {
        solution.subarraysDivByK(IntArray(30_000) { 10_000 }, 10_000) shouldBe 450_015_000
        solution.subarraysDivByK(IntArray(30_000) { -10_000 }, 10_000) shouldBe 450_015_000
    }

    "preserves the input" {
        val nums = intArrayOf(4, 5, 0, -2, -3, 1)
        val original = nums.toList()

        solution.subarraysDivByK(nums, 5) shouldBe 7

        nums.toList() shouldBe original
    }

    "matches brute-force subarray sums for short arrays" {
        // Enumerate arrays of length 0 through 6 with values -2 through 2.
        for (size in 0..6) {
            var combinations = 1
            repeat(size) { combinations *= 5 }
            for (encoding in 0 until combinations) {
                var remaining = encoding
                val nums = IntArray(size) {
                    val value = remaining % 5 - 2
                    remaining /= 5
                    value
                }
                for (k in 2..6) {
                    var expected = 0
                    for (start in nums.indices) {
                        var sum = 0L
                        for (end in start until nums.size) {
                            sum += nums[end]
                            if (sum % k == 0L) expected++
                        }
                    }

                    solution.subarraysDivByK(nums, k) shouldBe expected
                }
            }
        }
    }
})

// TODO review
