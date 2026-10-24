package com.shlapak.yaroslav.leetcode.problems.p0029

import io.kotest.matchers.shouldBe
import io.kotest.core.spec.style.FreeSpec

/**
 * Tests [DivideTwoIntegers].
 */
class DivideTwoIntegersTest : FreeSpec({
    "divideNaive" - {
        val inputs = getInputs()
        inputs.asSequence().forEach { (input, expected) ->
            "input.dividend: ${input.dividend}, input.divisor: ${input.divisor} expected: $expected" {
                val actual = DivideTwoIntegers().divideNaive(input.dividend, input.divisor)
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

fun getInputs(): Map<DivideTwoIntegersTest.Parameter, Int> {
    return mapOf(
            DivideTwoIntegersTest.Parameter(
                    dividend = 10,
                    divisor = 3
            ) to 3,
            DivideTwoIntegersTest.Parameter(
                    dividend = 7,
                    divisor = -3
            ) to -2
    )
}
