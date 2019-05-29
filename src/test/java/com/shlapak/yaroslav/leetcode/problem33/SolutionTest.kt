package com.shlapak.yaroslav.leetcode.problem33

import com.shlapak.yaroslav.leetcode.utils.getSting
import io.kotlintest.shouldBe
import org.spekframework.spek2.Spek


/**
 * Created on 2019/05/29.
 */
/** tests for
 * @see com.shlapak.yaroslav.leetcode.problem33.Solution
 **/
object SolutionTest : Spek({

    group("search") {
        val inputs = getInputs()
        inputs.asSequence().forEach { (input, expected) ->
            test("input.nums: ${input.nums.getSting()}, input.target: ${input.target}, expected: ${expected}") {
                val actual = Solution().search(input.nums, input.target)
                println("actual:   ${actual}")
                println("expected: ${expected}")
                actual shouldBe expected
            }
        }
    }

}) {
    data class Parameter(
            val nums: IntArray,
            val target: Int
    ) {
        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (other !is Parameter) return false

            if (!nums.contentEquals(other.nums)) return false
            if (target != other.target) return false

            return true
        }

        override fun hashCode(): Int {
            var result = nums.contentHashCode()
            result = 31 * result + target
            return result
        }
    }
}

private fun getInputs(): Map<SolutionTest.Parameter, Int> {
    return mapOf(
            SolutionTest.Parameter(
                    intArrayOf(4, 5, 6, 7, 0, 1, 2),
                    0
            ) to 4,
            SolutionTest.Parameter(
                    intArrayOf(4, 5, 6, 7, 0, 1, 2),
                    3
            ) to -1
    )
}