package com.shlapak.yaroslav.leetcode.problem37

import io.kotlintest.shouldBe
import io.kotlintest.specs.FreeSpec

/**
 * Created on 2019/06/12.
 */
/** tests for
 * @see com.shlapak.yaroslav.leetcode.problem37.Solution
 **/
internal class SolutionTest : FreeSpec({

    "isValidSudoku" - {
        val inputs = getInputs()
        inputs.asSequence().forEach { (input, expected) ->
            "input: ${input}, expected: ${expected}" {
                val actual = Solution().solveSudoku(input)
                println("actual:   ${actual}")
                println("expected: ${expected}")
                actual shouldBe expected
            }
        }
    }
})

private fun getInputs(): Map<Array<CharArray>, Array<CharArray>> {
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
            ) to
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
                    )

    )
}
