package com.shlapak.yaroslav.leetcode.problem36

import io.kotest.matchers.shouldBe
import io.kotest.core.spec.style.FreeSpec

/**
 * Created on 2019/06/07.
 */
/** tests for
 * @see com.shlapak.yaroslav.leetcode.problem36.Solution
 **/
internal class SolutionTest : FreeSpec({

    "isValidSudoku" - {
        val inputs = getInputs()
        inputs.asSequence().forEach { (input, expected) ->
            "input: ${input}, expected: ${expected}" {
                val actual = Solution().isValidSudoku(input)
                println("actual:   ${actual}")
                println("expected: ${expected}")
                actual shouldBe expected
            }
        }
    }

    "isValidSudoku2" - {
        val inputs = getInputs()
        inputs.asSequence().forEach { (input, expected) ->
            "input: ${input}, expected: ${expected}" {
                val actual = Solution2().isValidSudoku(input)
                println("actual:   ${actual}")
                println("expected: ${expected}")
                actual shouldBe expected
            }
        }
    }
})

private fun getInputs(): Map<Array<CharArray>, Boolean> {
    return mapOf(
            arrayOf(
                    charArrayOf('5', '3', '.', '.', '7', '.', '.', '.', '.'),
                    charArrayOf('6', '.', '.', '1', '9', '5', '.', '.', '.'),
                    charArrayOf('.', '9', '8', '.', '.', '.', '.', '6', '.'),
                    charArrayOf('8', '.', '.', '.', '6', '.', '.', '.', '3'),
                    charArrayOf('4', '.', '.', '8', '.', '3', '.', '.', '1'),
                    charArrayOf('7', '.', '.', '.', '2', '.', '.', '.', '6'),
                    charArrayOf('.', '6', '.', '.', '.', '.', '2', '8', '.'),
                    charArrayOf('.', '.', '.', '4', '1', '9', '.', '.', '5'),
                    charArrayOf('.', '.', '.', '.', '8', '.', '.', '7', '9')
            ) to true,
            arrayOf(
                    charArrayOf('8', '3', '.', '.', '7', '.', '.', '.', '.'),
                    charArrayOf('6', '.', '.', '1', '9', '5', '.', '.', '.'),
                    charArrayOf('.', '9', '8', '.', '.', '.', '.', '6', '.'),
                    charArrayOf('8', '.', '.', '.', '6', '.', '.', '.', '3'),
                    charArrayOf('4', '.', '.', '8', '.', '3', '.', '.', '1'),
                    charArrayOf('7', '.', '.', '.', '2', '.', '.', '.', '6'),
                    charArrayOf('.', '6', '.', '.', '.', '.', '2', '8', '.'),
                    charArrayOf('.', '.', '.', '4', '1', '9', '.', '.', '5'),
                    charArrayOf('.', '.', '.', '.', '8', '.', '.', '7', '9')
            ) to false,
            arrayOf(
                    charArrayOf('.', '8', '7', '6', '5', '4', '3', '2', '1'),
                    charArrayOf('2', '.', '.', '.', '.', '.', '.', '.', '.'),
                    charArrayOf('3', '.', '.', '.', '.', '.', '.', '.', '.'),
                    charArrayOf('4', '.', '.', '.', '.', '.', '.', '.', '.'),
                    charArrayOf('5', '.', '.', '.', '.', '.', '.', '.', '.'),
                    charArrayOf('6', '.', '.', '.', '.', '.', '.', '.', '.'),
                    charArrayOf('7', '.', '.', '.', '.', '.', '.', '.', '.'),
                    charArrayOf('8', '.', '.', '.', '.', '.', '.', '.', '.'),
                    charArrayOf('9', '.', '.', '.', '.', '.', '.', '.', '.')
            ) to true
    )
}



