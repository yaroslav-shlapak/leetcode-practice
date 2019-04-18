package com.shlapak.yaroslav.leetcode.problem16

import io.kotlintest.shouldBe
import org.spekframework.spek2.Spek


/**
 * Created on 2019/04/18.
 */
/** tests for
 * @see com.shlapak.yaroslav.leetcode.problem16.Solution
 **/
object SolutionTest : Spek({

    val inputs = mapOf(
            Param(
                    nums = intArrayOf(-1, 2, 1, -4),
                    target = 1
            ) to 2
    )

    group("threeSumNaive") {
        inputs.asSequence().forEach { (param, expected) ->
            test("param.target: ${param.target}, expected: $expected") {
                val actual = Solution().threeSumClosest(
                        nums = param.nums,
                        target = param.target
                )

                actual shouldBe expected
            }
        }
    }
})

data class Param(
        val nums: IntArray,
        val target: Int
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is Param) return false

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