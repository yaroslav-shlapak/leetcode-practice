package com.shlapak.yaroslav.leetcode.problem26


import io.kotlintest.shouldBe
import io.kotlintest.specs.FreeSpec

/**
 * Created on 2019/05/14.
 */
/** tests for
 * @see com.shlapak.yaroslav.leetcode.problem26.Solution
 **/
class SolutionTest : FreeSpec({

    "removeDuplicates1" - {
        val inputs = getInputs()
        inputs.asSequence().forEach { (input, expected) ->
            "input: ${input.asList()}, expected: $expected" {
                val actual = Solution().removeDuplicates1(input)
                println("actual:   $actual")
                println("expected: $expected")
                println("input:   ${input.asList().take(expected)}")
                actual shouldBe expected
            }
        }
    }

    "removeDuplicates" - {
        val inputs = getInputs()
        inputs.asSequence().forEach { (input, expected) ->
            "input: ${input.asList()}, expected: $expected" {
                val actual = Solution().removeDuplicates(input)
                println("actual:   $actual")
                println("expected: $expected")
                println("input:   ${input.asList().take(expected)}")
                actual shouldBe expected
            }
        }
    }
})

fun getInputs(): Map<IntArray, Int> {
    return mapOf(
            intArrayOf(1, 1, 2) to 2,
            intArrayOf(0, 0, 1, 1, 1, 2, 2, 3, 3, 4) to 5,
            intArrayOf(0, 1, 2, 3, 4) to 5,
            intArrayOf() to 0,
            intArrayOf(0) to 1,
            intArrayOf(1, 2) to 2,
            intArrayOf(1, 1) to 1,
            intArrayOf(1, 1, 1, 1, 1, 1, 1, 1) to 1,
            intArrayOf(1, 1, 1, 1, 1, 1, 1, 2) to 2
    )
}
