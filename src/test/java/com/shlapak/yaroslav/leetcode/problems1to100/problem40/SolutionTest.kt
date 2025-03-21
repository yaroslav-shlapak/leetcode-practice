package com.shlapak.yaroslav.leetcode.problems1to100.problem40

import io.kotest.matchers.collections.shouldContainAll
import io.kotest.core.spec.style.FreeSpec

/** tests for
 * @see com.shlapak.yaroslav.leetcode.problem40.Solution
 **/
class SolutionTest : FreeSpec() {

    init {
        "combinationSum2" - {
            val inputs = getInputs()
            inputs.asSequence().forEach { (input, expected) ->
                "input: ${input}, expected: ${expected}" {
                    val actual = Solution().combinationSum2(input.first, input.second)
                    actual shouldContainAll expected
                }
            }
        }

        "combinationSum2 2" - {
            val inputs = getInputs()
            inputs.asSequence().forEach { (input, expected) ->
                "input: ${input}, expected: ${expected}" {
                    val actual = Solution2().combinationSum2(input.first, input.second)
                    actual shouldContainAll expected
                }
            }
        }
    }


    private fun getInputs(): Map<Pair<IntArray, Int>, List<List<Int>>> {
        return mapOf(
                Pair(intArrayOf(10, 1, 2, 7, 6, 1, 5), 8) to
                        listOf(
                                listOf(1, 7),
                                listOf(1, 2, 5),
                                listOf(2, 6),
                                listOf(1, 1, 6)
                        ),
                Pair(intArrayOf(2, 5, 2, 1, 2), 5) to
                        listOf(
                                listOf(1, 2, 2),
                                listOf(5)
                        )
        )
    }
}