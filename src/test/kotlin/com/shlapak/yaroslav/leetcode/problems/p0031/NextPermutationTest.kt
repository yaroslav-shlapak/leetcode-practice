package com.shlapak.yaroslav.leetcode.problems.p0031

import com.shlapak.yaroslav.leetcode.support.asString
import io.kotest.matchers.shouldBe
import io.kotest.core.spec.style.FreeSpec

/**
 * Tests [NextPermutation].
 */
class NextPermutationTest : FreeSpec({

    "nextPermutation" - {
        val inputs = getInputs()
        inputs.asSequence().forEach { (input, expected) ->
            "nums: ${input.asString()}, expected: ${expected.asString()}" {
                NextPermutation().nextPermutation(input)
                println("actual:   ${input.asString()}")
                println("expected: ${expected.asString()}")
                input.toList() shouldBe expected.toList()
            }
        }
    }

})

private fun getInputs(): Map<IntArray, IntArray> {
    return mapOf(
            intArrayOf(1, 2, 3) to intArrayOf(1, 3, 2),
            intArrayOf(3, 2, 1) to intArrayOf(1, 2, 3),
            intArrayOf(1, 1, 5) to intArrayOf(1, 5, 1),
            intArrayOf(1, 3, 2) to intArrayOf(2, 1, 3),
            intArrayOf(1, 2, 3, 4, 5, 6, 7) to intArrayOf(1, 2, 3, 4, 5, 7, 6)
    )
}
