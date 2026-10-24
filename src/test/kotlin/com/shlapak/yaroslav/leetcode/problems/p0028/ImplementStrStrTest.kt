package com.shlapak.yaroslav.leetcode.problems.p0028

import io.kotest.matchers.shouldBe
import io.kotest.core.spec.style.FreeSpec

/**
 * Tests [ImplementStrStr.TwoPointersSimple].
 */
class ImplementStrStrTest : FreeSpec({
    "strStr" - {
        val inputs = getInputs()
        inputs.asSequence().forEach { (input, expected) ->
            "input.haystack: ${input.haystack}, input.needle: ${input.needle} expected: $expected" {
                val actual = ImplementStrStr.TwoPointersSimple().strStr(input.haystack, input.needle)
                println("actual:   $actual")
                println("expected: $expected")
                actual shouldBe expected
            }
        }
    }
}) {
    data class Parameter(
            val haystack: String,
            val needle: String
    )
}

fun getInputs(): Map<ImplementStrStrTest.Parameter, Int> {
    return mapOf(
            ImplementStrStrTest.Parameter(
                    haystack = "hello",
                    needle = "ll"
            ) to 2,
            ImplementStrStrTest.Parameter(
                    haystack = "aaaaa",
                    needle = "bba"
            ) to -1,
            ImplementStrStrTest.Parameter(
                    haystack = "llhello",
                    needle = "ll"
            ) to 0,
            ImplementStrStrTest.Parameter(
                    haystack = "ashell",
                    needle = "ll"
            ) to 4,
            ImplementStrStrTest.Parameter(
                    haystack = "ashel0",
                    needle = "l0"
            ) to 4,
            ImplementStrStrTest.Parameter(
                    haystack = "mississippi",
                    needle = "issipi"
            ) to -1,
            ImplementStrStrTest.Parameter(
                    haystack = "mississippi",
                    needle = "issip"
            ) to 4
    )
}
