package com.shlapak.yaroslav.leetcode.problems.p0047

import io.kotest.matchers.collections.shouldContainAll
import io.kotest.core.spec.style.FreeSpec

/**
 * Tests [Permutations2].
 */
class Permutations2Test : FreeSpec() {

    init {
        "permuteUnique" - {
            val inputs = getInputs()
            inputs.asSequence().forEach { (input, expected) ->
                "input: ${input}, expected: ${expected}" {
                    val actual = Permutations2().permuteUnique(input)
                    println("actual: $actual")
                    println("expected: $expected")
                    actual shouldContainAll expected
                }
            }
        }
    }

    private fun getInputs(): Map<IntArray, List<List<Int>>> {
        return mapOf(
                intArrayOf(1, 1, 2) to
                        listOf(
                                listOf(1, 1, 2),
                                listOf(1, 2, 1),
                                listOf(2, 1, 1)
                        )
        )
    }
}
