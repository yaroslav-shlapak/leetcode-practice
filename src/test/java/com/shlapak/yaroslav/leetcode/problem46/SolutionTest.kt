package com.shlapak.yaroslav.leetcode.problem46

import io.kotlintest.matchers.collections.shouldContainAll
import io.kotlintest.specs.FreeSpec

/** tests for
 * @see com.shlapak.yaroslav.leetcode.problem46.Solution
 **/
class SolutionTest : FreeSpec() {

    init {
        "multiply" - {
            val inputs = getInputs()
            inputs.asSequence().forEach { (input, expected) ->
                "input: ${input}, expected: ${expected}" {
                    val actual = Solution().permute(input)
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