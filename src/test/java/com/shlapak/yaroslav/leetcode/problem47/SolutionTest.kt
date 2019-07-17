package com.shlapak.yaroslav.leetcode.problem47

import io.kotlintest.matchers.collections.shouldContainAll
import io.kotlintest.specs.FreeSpec

/** tests for
 * @see com.shlapak.yaroslav.leetcode.problem47.Solution
 **/
class SolutionTest : FreeSpec() {

    init {
        "permuteUnique" - {
            val inputs = getInputs()
            inputs.asSequence().forEach { (input, expected) ->
                "input: ${input}, expected: ${expected}" {
                    val actual = Solution().permuteUnique(input)
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