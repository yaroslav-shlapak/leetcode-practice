package com.shlapak.yaroslav.leetcode.problems.p0011

import io.kotest.matchers.shouldBe
import io.kotest.core.spec.style.FreeSpec

/**
 * Tests [ContainerWithMostWaterLegacy].
 */
class ContainerWithMostWaterTest : FreeSpec({
    val inputs = mapOf(
            intArrayOf(1, 8, 6, 2, 5, 4, 8, 3, 7) to 49
    )

    "maxArea" - {
        inputs.asSequence().forEach { (input, expected) ->
            "input: ${input.asList()}, expected: $expected" {
                ContainerWithMostWaterLegacy().maxArea(input) shouldBe expected
            }
        }
    }
})
