package com.shlapak.yaroslav.leetcode.problems.p0033

import com.shlapak.yaroslav.leetcode.support.asString
import io.kotest.matchers.shouldBe
import io.kotest.core.spec.style.FreeSpec


/**
 * Created on 2019/05/29.
 */
/** tests for
 * @see com.shlapak.yaroslav.leetcode.problems.p0033.SearchInRotatedSortedArrayLegacy
 **/
class SearchInRotatedSortedArrayTest : FreeSpec({

    "search" - {
        val inputs = getInputs()
        inputs.asSequence().forEach { (input, expected) ->
            "input.nums: ${input.nums.asString()}, input.target: ${input.target}, expected: ${expected}" {
                val actual = SearchInRotatedSortedArrayLegacy().search(input.nums, input.target)
                println("actual:   ${actual}")
                println("expected: ${expected}")
                actual shouldBe expected
            }
        }
    }

    "search2" - {
        val inputs = getInputs()
        inputs.asSequence().forEach { (input, expected) ->
            "input.nums: ${input.nums.asString()}, input.target: ${input.target}, expected: ${expected}" {
                val actual = SearchInRotatedSortedArrayAlternative2().search(input.nums, input.target)
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

private fun getInputs(): Map<SearchInRotatedSortedArrayTest.Parameter, Int> {
    return mapOf(
            SearchInRotatedSortedArrayTest.Parameter(
                    intArrayOf(4, 5, 6, 7, 0, 1, 2),
                    0
            ) to 4,
            SearchInRotatedSortedArrayTest.Parameter(
                    intArrayOf(4, 5, 6, 7, 0, 1, 2),
                    3
            ) to -1
    )
}