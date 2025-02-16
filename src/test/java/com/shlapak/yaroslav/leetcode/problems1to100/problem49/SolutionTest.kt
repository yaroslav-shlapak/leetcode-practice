package com.shlapak.yaroslav.leetcode.problems1to100.problem49

import io.kotest.matchers.collections.shouldContainAll
import io.kotest.core.spec.style.FreeSpec

/** tests for
 * @see com.shlapak.yaroslav.leetcode.problem49.Solution
 **/
class SolutionTest : FreeSpec() {

    init {
        "groupAnagrams" - {
            val inputs = listOf(
                    TestCase(
                            input = arrayOf(
                                    "eat", "tea", "tan", "ate", "nat", "bat"
                            ),
                            expected = listOf(
                                    listOf("eat", "tea", "ate"),
                                    listOf("tan", "nat"),
                                    listOf("bat")
                            )
                    ),
                    TestCase(
                            input = arrayOf(
                                    ""
                            ),
                            expected = listOf(
                                    listOf("")
                            )
                    ),
                    TestCase(
                            input = arrayOf(
                                    "a"
                            ),
                            expected = listOf(
                                    listOf("a")
                            )
                    )
            )
            inputs.forEach { (input, expected) ->
                "input: ${input.toList()}, expected: ${expected.toList()}" {
                    val actual = Solution().groupAnagrams(input)
                    println("actual: ${actual}")
                    println("expected: ${expected}")
                    actual shouldContainAll expected
                }
            }
        }
    }

    data class TestCase(
            val input: Array<String>,
            val expected: List<List<String>>
    )
}