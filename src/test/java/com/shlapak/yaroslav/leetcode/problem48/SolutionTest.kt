package com.shlapak.yaroslav.leetcode.problem48

import io.kotlintest.shouldBe
import io.kotlintest.specs.FreeSpec

/** tests for
 * @see com.shlapak.yaroslav.leetcode.problem48.Solution
 **/
class SolutionTest : FreeSpec() {

    init {
        "rotate" - {
            val inputs = getInputs()
            inputs.asSequence().forEach { (input, expected) ->
                "input: ${input.toList()}, expected: ${expected.toList()}" {
                    Solution().rotate(input)
                    println("actual: $input")
                    println("expected: $expected")
                    input shouldBe expected
                }
            }
        }
    }

    private fun getInputs(): Map<Array<IntArray>, Array<IntArray>> {
        return mapOf(
                arrayOf(
                        intArrayOf(1, 2, 3),
                        intArrayOf(4, 5, 6),
                        intArrayOf(7, 8, 9)
                ) to arrayOf(
                        intArrayOf(7, 4, 1),
                        intArrayOf(8, 5, 2),
                        intArrayOf(9, 6, 3)
                ),
                arrayOf(
                        intArrayOf(5, 1, 9, 11),
                        intArrayOf(2, 4, 8, 10),
                        intArrayOf(13, 3, 6, 7)
                ) to arrayOf(
                        intArrayOf(15, 13, 2, 5),
                        intArrayOf(14, 3, 4, 1),
                        intArrayOf(12, 6, 8, 9)
                )

        )
    }
}