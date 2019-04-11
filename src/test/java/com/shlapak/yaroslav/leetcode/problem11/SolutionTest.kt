package com.shlapak.yaroslav.leetcode.problem11

import io.kotlintest.shouldBe
import org.spekframework.spek2.Spek

/**
 * Created on 2019/04/11.
 */
object SolutionTest : Spek({
    val inputs = mapOf(
            intArrayOf(1, 8, 6, 2, 5, 4, 8, 3, 7) to 49
    )

    group("maxArea") {
        inputs.asSequence().forEach { (input, expected) ->
            test("input: ${input.asList()}, expected: $expected") {
                Solution().maxArea(input) shouldBe expected
            }
        }
    }
})