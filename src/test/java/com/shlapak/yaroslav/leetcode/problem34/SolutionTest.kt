package com.shlapak.yaroslav.leetcode.problem34

import com.shlapak.yaroslav.leetcode.utils.getSting
import io.kotlintest.shouldBe
import org.spekframework.spek2.Spek

/**
 * Created on 2019/05/31.
 */
object SolutionTest : Spek({

    group("search") {
        val inputs = getInputs()
        inputs.asSequence().forEach { (input, expected) ->
            test("input.nums: ${input.nums.getSting()}, input.target: ${input.target}, expected: ${expected.getSting()}") {
                val actual = Solution().searchRange(input.nums, input.target)
                println("actual:   ${actual.getSting()}")
                println("expected: ${expected.getSting()}")
                actual shouldBe expected
            }
        }
    }
})

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

private fun getInputs(): Map<Parameter, IntArray> {
    return mapOf(
            Parameter(
                    intArrayOf(5, 7, 7, 8, 8, 10),
                    8
            ) to intArrayOf(3, 4),
            Parameter(
                    intArrayOf(5, 7, 7, 8, 8, 10),
                    6
            ) to intArrayOf(-1, -1)
    )
}