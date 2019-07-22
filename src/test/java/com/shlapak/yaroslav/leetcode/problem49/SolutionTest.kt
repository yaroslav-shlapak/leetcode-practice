package com.shlapak.yaroslav.leetcode.problem49

import io.kotlintest.matchers.collections.shouldContainAll
import io.kotlintest.specs.FreeSpec

/** tests for
 * @see com.shlapak.yaroslav.leetcode.problem49.Solution
 **/
class SolutionTest : FreeSpec() {

    init {
        "groupAnagrams" - {
            val inputs = getInputs()
            inputs.asSequence().forEach { (input, expected) ->
                "input: ${input.toList()}, expected: ${expected.toList()}" {
                    val actual = Solution().groupAnagrams(input)
                    println("actual: ${actual}")
                    println("expected: ${expected}")
                    actual shouldContainAll expected
                }
            }
        }
    }

    private fun getInputs(): Map<Array<String>, List<List<String>>> {
        return mapOf(
                arrayOf(
                        "eat", "tea", "tan", "ate", "nat", "bat"
                ) to listOf(
                        listOf("eat", "tea", "ate"),
                        listOf("tan", "nat"),
                        listOf("bat")
                )
        )
    }
}