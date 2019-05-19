package com.shlapak.yaroslav.leetcode.problem28

import com.shlapak.yaroslav.leetcode.problem28.SolutionTest.getInputs
import io.kotlintest.shouldBe
import org.spekframework.spek2.Spek

/**
 * Created on 2019/05/19.
 */
/** tests for
 * @see com.shlapak.yaroslav.leetcode.problem28.Solution
 **/
object SolutionTest: Spek({
    group("strStr") {
        val inputs = getInputs()
        inputs.asSequence().forEach { (input, expected) ->
            test("input.haystack: ${input.haystack}, input.needle: ${input.needle} expected: $expected") {
                val actual = Solution().strStr(input.haystack, input.needle)
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

    fun getInputs(): Map<Parameter, Int> {
        return mapOf(
                Parameter(
                        haystack = "hello",
                        needle = "ll"
                ) to 2,
                Parameter(
                        haystack = "aaaaa",
                        needle = "bba"
                ) to -1,
                Parameter(
                        haystack = "llhello",
                        needle = "ll"
                ) to 0,
                Parameter(
                        haystack = "ashell",
                        needle = "ll"
                ) to 4,
                Parameter(
                        haystack = "ashel0",
                        needle = "l0"
                ) to 4,
                Parameter(
                        haystack = "mississippi",
                        needle = "issipi"
                ) to -1,
                Parameter(
                        haystack = "mississippi",
                        needle = "issip"
                ) to 4
        )
    }
}
