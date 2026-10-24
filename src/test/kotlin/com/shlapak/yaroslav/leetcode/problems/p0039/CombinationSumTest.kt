package com.shlapak.yaroslav.leetcode.problems.p0039

import io.kotest.matchers.collections.shouldContainAll
import io.kotest.core.spec.style.FreeSpec

/**
 * Tests [CombinationSum.BacktrackingMemo] and [CombinationSum.Backtracking].
 */
class CombinationSumTest : FreeSpec() {

    init {
        "BacktrackingMemo" - {
            val inputs = getInputs()
            inputs.asSequence().forEach { (input, expected) ->
                "input: ${input}, expected: ${expected}" {
                    val actual = CombinationSum.BacktrackingMemo().combinationSum(input.first, input.second)
                    actual shouldContainAll expected
                }
            }
        }


        "Backtracking" - {
            val inputs = getInputs()
            inputs.asSequence().forEach { (input, expected) ->
                "input: ${input}, expected: ${expected}" {
                    val actual = CombinationSum.Backtracking().combinationSum(input.first, input.second)
                    actual shouldContainAll expected
                }
            }
        }
    }


    private fun getInputs(): Map<Pair<IntArray, Int>, List<List<Int>>> {
        return mapOf(
                Pair(intArrayOf(2, 3, 6, 7), 7) to
                        listOf(
                                listOf(7),
                                listOf(2, 2, 3)
                        ),
                Pair(intArrayOf(2, 3, 5), 8) to
                        listOf(
                                listOf(2, 2, 2, 2),
                                listOf(2, 3, 3),
                                listOf(3, 5)
                        )
        )
    }

}
