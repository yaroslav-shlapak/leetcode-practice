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

    "solveSudoku" - {
        val inputs = getInputs()
        inputs.asSequence().forEach { (input, expected) ->
            "input: ${input}, expected: ${expected}" {
                Solution().solveSudoku(input)
                for (i in 0 until 9) {
                    for (j in 0 until 9) {
                        input[i][j] shouldBe expected[i][j]
                    }
                }
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
                            charArrayOf('5', '3', '4', '6', '7', '8', '9', '1', '2'),
                            charArrayOf('6', '7', '2', '1', '9', '5', '3', '4', '8'),
                            charArrayOf('1', '9', '8', '3', '4', '2', '5', '6', '7'),
                            charArrayOf('8', '5', '9', '7', '6', '1', '4', '2', '3'),
                            charArrayOf('4', '2', '6', '8', '5', '3', '7', '9', '1'),
                            charArrayOf('7', '1', '3', '9', '2', '4', '8', '5', '6'),
                            charArrayOf('9', '6', '1', '5', '3', '7', '2', '8', '4'),
                            charArrayOf('2', '8', '7', '4', '1', '9', '6', '3', '5'),
                            charArrayOf('3', '4', '5', '2', '8', '6', '1', '7', '9')
                    )

    )
}
