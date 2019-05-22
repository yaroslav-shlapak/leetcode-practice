package com.shlapak.yaroslav.leetcode.problem29

import io.kotlintest.shouldBe
import org.spekframework.spek2.Spek

/**
 * Created on 2019/05/22.
 */
/** tests for
 * @see com.shlapak.yaroslav.leetcode.problem29.Solution
 **/
object SolutionTest : Spek({
    group("divideNaive") {
        val inputs = getInputs()
        inputs.asSequence().forEach { (input, expected) ->
            test("input.dividend: ${input.dividend}, input.divisor: ${input.divisor} expected: $expected") {
                val actual = Solution().divideNaive(input.dividend, input.divisor)
                println("actual:   $actual")
                println("expected: $expected")
                actual shouldBe expected
            }
        }
    }
}) {
    data class Parameter(
            val dividend: Int,
            val divisor: Int
    )
}

fun getInputs(): Map<SolutionTest.Parameter, Int> {
    return mapOf(
            SolutionTest.Parameter(
                    dividend = 10,
                    divisor = 3
            ) to 3,
            SolutionTest.Parameter(
                    dividend = 7,
                    divisor = -3
            ) to -2
    )
}