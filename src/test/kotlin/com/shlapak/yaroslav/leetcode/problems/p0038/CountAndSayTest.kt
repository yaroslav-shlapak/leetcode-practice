package com.shlapak.yaroslav.leetcode.problems.p0038

import io.kotest.matchers.shouldBe
import io.kotest.core.spec.style.FreeSpec

/**
 * Tests [CountAndSay].
 */
internal class CountAndSayTest : FreeSpec({
    "countAndSay" - {
        val inputs = getInputs()
        inputs.asSequence().forEach { (input, expected) ->
            "input: ${input}, expected: ${expected}" {
                val actual = CountAndSay().countAndSay(input)
                actual shouldBe expected
            }
        }
    }
})

private fun getInputs(): Map<Int, String> {
    return mapOf(
            1 to "1",
            2 to "11",
            3 to "21",
            4 to "1211",
            5 to "111221"
    )
}
