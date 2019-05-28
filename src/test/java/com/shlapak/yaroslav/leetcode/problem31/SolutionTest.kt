package com.shlapak.yaroslav.leetcode.problem31

import com.shlapak.yaroslav.leetcode.utils.getSting
import io.kotlintest.shouldBe
import org.spekframework.spek2.Spek


/**
 * Created on 2019/05/28.
 */
/** tests for
 * @see com.shlapak.yaroslav.leetcode.problem31.Solution
 **/
object SolutionTest : Spek({

    group("nextPermutation") {
        val inputs = getInputs()
        inputs.asSequence().forEach { (input, expected) ->
            test("nums: ${input.getSting()}, expected: ${expected.getSting()}") {
                Solution().nextPermutation(input)
                println("actual:   ${input.getSting()}")
                println("expected: ${expected.getSting()}")
                input.getSting() shouldBe expected.getSting()
            }
        }
    }

})

private fun getInputs(): Map<IntArray, IntArray> {
    return mapOf(
            intArrayOf(1, 2, 3) to intArrayOf(1, 3, 2),
            intArrayOf(3, 2, 1) to intArrayOf(1, 2, 3),
            intArrayOf(1, 1, 5) to intArrayOf(1, 5, 1),
            intArrayOf(1, 3, 2) to intArrayOf(2, 1, 3)
    )
}