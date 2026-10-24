package com.shlapak.yaroslav.leetcode.problems.p0962

import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.shouldBe

/**
 * Tests [MaximumWidthRamp.PrefixSuffixTwoPointers] and [MaximumWidthRamp.MonotonicStack].
 *
 * Covers example cases, equal endpoints, monotone arrays, input preservation, and exhaustive
 * comparisons against the ramp definition for short arrays.
 */
class MaximumWidthRampTest : FreeSpec({
    val implementations: Map<String, (IntArray) -> Int> = mapOf(
        "prefix minima and suffix maxima" to MaximumWidthRamp.PrefixSuffixTwoPointers()::maxWidthRamp,
        "monotonic stack" to MaximumWidthRamp.MonotonicStack()::maxWidthRamp,
    )

    for ((name, solve) in implementations) {
        name - {
            "finds the widest ramp in the first example" {
                solve(intArrayOf(6, 0, 8, 2, 1, 5)) shouldBe 4
            }

            "does not stop at the first invalid pair" {
                solve(intArrayOf(9, 8, 1, 0, 1, 9, 4, 0, 4, 1)) shouldBe 7
            }

            "includes pairs with equal endpoint values" {
                solve(intArrayOf(5, 5, 5, 5)) shouldBe 3
                solve(intArrayOf(5, 0, 5)) shouldBe 2
            }

            "spans an increasing array" {
                solve(intArrayOf(1, 2, 3, 4, 5)) shouldBe 4
            }

            "returns zero for a strictly decreasing array" {
                solve(intArrayOf(5, 4, 3, 2, 1)) shouldBe 0
            }

            "handles arrays with fewer than two elements" {
                solve(intArrayOf()) shouldBe 0
                solve(intArrayOf(7)) shouldBe 0
            }

            "preserves the input" {
                val nums = intArrayOf(9, 8, 1, 0, 1, 9, 4, 0, 4, 1)
                val original = nums.toList()

                solve(nums) shouldBe 7

                nums.toList() shouldBe original
            }

            "matches all valid index pairs for short arrays" {
                // Enumerate arrays of length 0 through 7 with values 0, 1, and 2.
                for (size in 0..7) {
                    var combinations = 1
                    repeat(size) { combinations *= 3 }
                    for (encoding in 0 until combinations) {
                        var remaining = encoding
                        val nums = IntArray(size) {
                            val value = remaining % 3
                            remaining /= 3
                            value
                        }
                        var expected = 0
                        for (i in nums.indices) {
                            for (j in i + 1 until nums.size) {
                                if (nums[i] <= nums[j]) {
                                    expected = maxOf(expected, j - i)
                                }
                            }
                        }

                        solve(nums) shouldBe expected
                    }
                }
            }
        }
    }
})
