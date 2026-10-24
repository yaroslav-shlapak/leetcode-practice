package com.shlapak.yaroslav.leetcode.problems.p0046

import io.kotest.matchers.collections.shouldContainAll
import io.kotest.core.spec.style.FreeSpec

/**
 * Tests [Permutations].
 */
class PermutationsTest : FreeSpec() {

    init {
        "permute" - {
            val inputs = getInputs()
            inputs.asSequence().forEach { (input, expected) ->
                "input: ${input}, expected: ${expected}" {
                    val actual = Permutations().permute(input)
                    println("actual: $actual")
                    println("expected: $expected")
                    actual shouldContainAll expected
                }
            }
        }
    }

    private fun getInputs(): Map<IntArray, List<List<Int>>> {
        return mapOf(
                intArrayOf(1, 2, 3) to
                        listOf(
                                listOf(1, 2, 3),
                                listOf(1, 3, 2),
                                listOf(2, 1, 3),
                                listOf(2, 3, 1),
                                listOf(3, 1, 2),
                                listOf(3, 2, 1)
                        )
        )
    }
}
