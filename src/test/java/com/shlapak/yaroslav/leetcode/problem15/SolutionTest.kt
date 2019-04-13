package com.shlapak.yaroslav.leetcode.problem15

import io.kotlintest.shouldBe
import org.spekframework.spek2.Spek

import org.junit.jupiter.api.Assertions.*

/**
 * Created on 2019/04/13.
 */
/** tests for
 * @see com.shlapak.yaroslav.leetcode.problem15.Solution
 **/
object SolutionTest : Spek({
    val inputs = mapOf(
            intArrayOf(-1, 0, 1, 2, -1, -4) to
                    listOf(
                            listOf(-1, 0, 1),
                            listOf(-1, -1, 2)
                    )
    )

    group("longestCommonPrefix") {
        inputs.asSequence().forEach { (input, expected) ->
            test("input: ${input.asList()} expected: $expected") {
                Solution().threeSum(input) shouldBe expected
            }
        }
    }
})