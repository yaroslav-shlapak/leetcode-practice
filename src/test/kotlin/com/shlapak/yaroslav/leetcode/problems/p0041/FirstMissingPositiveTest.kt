package com.shlapak.yaroslav.leetcode.problems.p0041

import com.shlapak.yaroslav.leetcode.support.asString
import io.kotest.matchers.shouldBe
import io.kotest.core.spec.style.FreeSpec

/**
 * Tests [FirstMissingPositive], [FirstMissingPositiveAlternative2], and
 * [FirstMissingPositive.HashSetScan].
 */
class FirstMissingPositiveTest : FreeSpec() {

    init {
        "combinationSum2" - {
            val inputs = getInputs()
            inputs.asSequence().forEach { (input, expected) ->
                "input: ${input.asString()}, expected: ${expected}" {
                    val actual = FirstMissingPositive().firstMissingPositive(input)
                    actual shouldBe expected
                }
            }
        }

        "combinationSum2 2" - {
            val inputs = getInputs()
            inputs.asSequence().forEach { (input, expected) ->
                "input: ${input.asString()}, expected: ${expected}" {
                    val actual = FirstMissingPositiveAlternative2().firstMissingPositive(input)
                    actual shouldBe expected
                }
            }
        }

        "hash set scan" - {
            getInputs().forEach { (input, expected) ->
                "input: ${input.asString()}, expected: $expected" {
                    val original = input.copyOf()
                    FirstMissingPositive.HashSetScan().firstMissingPositive(input) shouldBe expected
                    input.toList() shouldBe original.toList()
                }
            }
        }
    }

    private fun getInputs(): Map<IntArray, Int> {
        return mapOf(
                intArrayOf(1, 2, 0) to 3,
                intArrayOf(3, 4, -1, 1) to 2,
                intArrayOf(7, 8, 9, 11, 12) to 1,
                intArrayOf() to 1,
                intArrayOf(0) to 1,
                intArrayOf(1) to 2,
                intArrayOf(2) to 1,
                intArrayOf(3) to 1,
                intArrayOf(-1, -2) to 1,
                intArrayOf(1, 0) to 2,
                intArrayOf(1000, -1) to 1,
                intArrayOf(-5) to 1,
                intArrayOf(1, 1, Int.MIN_VALUE, Int.MAX_VALUE) to 2,
                intArrayOf(2, 1, 3) to 4,
                intArrayOf(-1, -2, 0, 2, 1, 3, 6, 5, 4) to 7
        )
    }

}
