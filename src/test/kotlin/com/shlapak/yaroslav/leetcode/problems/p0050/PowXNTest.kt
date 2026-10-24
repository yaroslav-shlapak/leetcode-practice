package com.shlapak.yaroslav.leetcode.problems.p0050

import io.kotest.matchers.shouldBe
import io.kotest.core.spec.style.FreeSpec

/**
 * Tests [PowXN].
 */
class PowXNTest : FreeSpec() {

    init {
        "myPow" - {
            val inputs = getInputs()
            inputs.asSequence().forEach { (input, expected) ->
                "input: ${input}, expected: ${expected}" {
                    val actual = PowXN().myPow(input.first, input.second)
                    println("actual: ${actual}")
                    println("expected: ${expected}")
                    actual shouldBe expected
                }
            }
        }
    }

    private fun getInputs(): Map<Pair<Double, Int>, Double> {
        return mapOf(
                Pair(2.0, 0) to 1.0,
                Pair(2.1, 3) to 9.26100,
                Pair(2.0, -2) to 0.25000,
                Pair(2.0, 10) to 1024.0,
                Pair(1.0, 2147483647) to 1.0
        )
    }
}
