package com.shlapak.yaroslav.leetcode.problems.p0049

import com.shlapak.yaroslav.leetcode.support.shouldMatchUnordered
import io.kotest.core.spec.style.FreeSpec

/**
 * Tests [GroupAnagrams.OptimalUsingCountAsKey].
 */
class GroupAnagramsTest : FreeSpec() {

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
                    val actual = GroupAnagrams.OptimalUsingCountAsKey().groupAnagrams(input)
                    println("actual: ${actual}")
                    println("expected: ${expected}")
                    actual.map { it.sorted() }.shouldMatchUnordered(expected.map { it.sorted() })
                }
            }
        }
    }

    data class TestCase(
            val input: Array<String>,
            val expected: List<List<String>>
    )
}
