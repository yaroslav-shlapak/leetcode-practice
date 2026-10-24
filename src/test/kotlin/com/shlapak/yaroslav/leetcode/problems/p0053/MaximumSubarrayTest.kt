package com.shlapak.yaroslav.leetcode.problems.p0053

import io.kotest.matchers.shouldBe
import io.kotest.core.spec.style.FreeSpec


class MaximumSubarrayTest : FreeSpec() {

    init {
        "maxSubArray" - {
            val inputs = getInputs()
            inputs.asSequence().forEach { (input, expected) ->
                "input: ${input}, expected: ${expected}" {
                    val actual = MaximumSubarray().maxSubArray(input.toIntArray())
                    println("actual: ${actual}")
                    println("expected: ${expected}")
                    actual shouldBe expected
                }
            }
        }

        "maxSubArray2" - {
            val inputs = getInputs()
            inputs.asSequence().forEach { (input, expected) ->
                "input: ${input}, expected: ${expected}" {
                    val actual = MaximumSubarrayAlternative2().maxSubArray(input.toIntArray())
                    println("actual: ${actual}")
                    println("expected: ${expected}")
                    actual shouldBe expected
                }
            }
        }

        "maxSubArray3" - {
            val inputs = getInputs()
            inputs.asSequence().forEach { (input, expected) ->
                "input: ${input}, expected: ${expected}" {
                    val actual = MaximumSubarrayAlternative3().maxSubArray(input.toIntArray())
                    println("actual: ${actual}")
                    println("expected: ${expected}")
                    actual shouldBe expected
                }
            }
        }
    }

    private fun getInputs(): Map<List<Int>, Int> {
        return mapOf(
                listOf(-2, 1, -3, 4, -1, 2, 1, -5, 4) to 6,
                listOf(1) to 1,
                listOf(1, 2, 3, 4) to 10,
                listOf(-1, -1, 2, -2, -3, 0) to 2,
                listOf(0, 0, 0, -1) to 0,
                listOf(-1) to -1
        )
    }
}