package com.shlapak.yaroslav.leetcode.problems.p0027

import io.kotest.matchers.shouldBe
import io.kotest.core.spec.style.FreeSpec

/**
 * Tests [RemoveElement].
 */
class RemoveElementTest : FreeSpec({

    "removeElement" - {
        val inputs = getInputs()
        inputs.asSequence().forEach { (input, expected) ->
            "input.nums: ${input.nums.asList()}, input.value: ${input.value} expected: $expected" {
                val actual = RemoveElement().removeElement(input.nums, input.value)
                println("actual:   $actual")
                println("expected: $expected")
                println("input:   ${input.nums.asList().take(expected)}")
                actual shouldBe expected
            }
        }
    }
}) {
    data class Parameter(
            val nums: IntArray,
            val value: Int
    ) {
        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (other !is Parameter) return false

            if (!nums.contentEquals(other.nums)) return false
            if (value != other.value) return false

            return true
        }

        override fun hashCode(): Int {
            var result = nums.contentHashCode()
            result = 31 * result + value
            return result
        }
    }
}

fun getInputs(): Map<RemoveElementTest.Parameter, Int> {
    return mapOf(
            RemoveElementTest.Parameter(
                    intArrayOf(3, 2, 2, 3),
                    2
            ) to 2,
            RemoveElementTest.Parameter(
                    intArrayOf(0, 1, 2, 2, 3, 0, 4, 2),
                    2
            ) to 5
    )
}
