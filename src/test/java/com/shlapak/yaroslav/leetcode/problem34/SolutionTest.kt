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

    group("search2") {
        val inputs = getInputs()
        inputs.asSequence().forEach { (input, expected) ->
            test("input.nums: ${input.nums.getSting()}, input.target: ${input.target}, expected: ${expected.getSting()}") {
                val actual = Solution2().searchRange(input.nums, input.target)
                println("actual:   ${actual.getSting()}")
                println("expected: ${expected.getSting()}")
                actual shouldBe expected
            }
        }
    }

    group("search3") {
        val inputs = getInputs()
        inputs.asSequence().forEach { (input, expected) ->
            test("input.nums: ${input.nums.getSting()}, input.target: ${input.target}, expected: ${expected.getSting()}") {
                val actual = Solution3().searchRange(input.nums, input.target)
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
    val size = 1000000
    val number = 8
    val longArray = IntArray(size)
    for (i in 0 until size) {
        longArray[i] = number
    }
    return mapOf(
            Parameter(
                    intArrayOf(5, 7, 7, 8, 8, 10),
                    8
            ) to intArrayOf(3, 4),
            Parameter(
                    intArrayOf(5, 7, 7, 8, 8, 10),
                    6
            ) to intArrayOf(-1, -1),
            Parameter(
                    intArrayOf(5, 7, 7, 8, 8, 8),
                    8
            ) to intArrayOf(3, 5),
            Parameter(
                    intArrayOf(8, 8, 8, 8, 8, 8),
                    8
            ) to intArrayOf(0, 5),
            Parameter(
                    longArray,
                    number
            ) to intArrayOf(0, size - 1)
    )
}