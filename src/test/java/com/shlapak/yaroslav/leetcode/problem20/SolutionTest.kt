package com.shlapak.yaroslav.leetcode.problem20

import io.kotlintest.shouldBe
import org.spekframework.spek2.Spek

/**
 * Created on 2019/05/03.
 */
/** tests for
 * @see com.shlapak.yaroslav.leetcode.problem20.Solution
 **/
object SolutionTest : Spek({
    val inputs = mapOf(
            "()" to true,
            "()[]{}" to true,
            "(]" to false,
            "([)]" to false,
            "{[]}" to true,
            "{{}[][[[]]]}" to true
    )

    group("isValid") {
        inputs.asSequence().forEach { (input, expected) ->
            test("input: $input, expected: $expected") {
                val actual = Solution().isValid(input)
                println(actual)
                actual shouldBe expected
            }
        }
    }
})