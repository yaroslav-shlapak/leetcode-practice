package com.shlapak.yaroslav.leetcode.problems1to100.problem19

import com.shlapak.yaroslav.leetcode.utils.ListNode
import com.shlapak.yaroslav.leetcode.utils.toIntList
import com.shlapak.yaroslav.leetcode.utils.toListNode
import io.kotest.matchers.shouldBe
import io.kotest.core.spec.style.FreeSpec

/**
 * Created on 2019/04/25.
 */
/** tests for
 * @see com.shlapak.yaroslav.leetcode.problem19.Solution
 **/
class SolutionTest : FreeSpec({

    "removeNthFromEndFirst" - {
        val inputs = getInputs()
        inputs.asSequence().forEach { (input, expected) ->
            "input.head: ${input.head.toString()}, input.n: ${input.n}, expected: ${expected.toString()}" {
                val actual = com.shlapak.yaroslav.leetcode.problems1to100.problem19.Solution()
                    .removeNthFromEndFirst(input.head, input.n)
                println("actual:   ${actual.toIntList()}")
                println("expected: ${expected.toIntList()}")
                actual.toIntList() shouldBe expected.toIntList()
            }
        }
    }

    "removeNthFromEndSecond" - {
        val inputs = getInputs()
        inputs.asSequence().forEach { (input, expected) ->
            "input.head: ${input.head.toString()}, input.n: ${input.n}, expected: ${expected.toString()}" {
                val actual = com.shlapak.yaroslav.leetcode.problems1to100.problem19.Solution()
                    .removeNthFromEndSecond(input.head, input.n)
                println("actual:   ${actual.toIntList()}")
                println("expected: ${expected.toIntList()}")
                actual.toIntList() shouldBe expected.toIntList()
            }
        }
    }

    "removeNthFromEnd" - {
        val inputs = getInputs()
        inputs.asSequence().forEach { (input, expected) ->
            "input.head: ${input.head.toString()}, input.n: ${input.n}, expected: ${expected.toString()}" {
                val actual = com.shlapak.yaroslav.leetcode.problems1to100.problem19.Solution()
                    .removeNthFromEnd(input.head, input.n)
                println("actual:   ${actual.toIntList()}")
                println("expected: ${expected.toIntList()}")
                actual.toIntList() shouldBe expected.toIntList()
            }
        }
    }

}) {
    data class Prameter(
            val head: ListNode?,
            val n: Int
    )
}

private fun getInputs(): Map<SolutionTest.Prameter, ListNode?> {
    return mapOf(
            SolutionTest.Prameter(
                    listOf(1, 2, 3, 4, 5).toListNode(),
                    0
            ) to listOf(1, 2, 3, 4, 5).toListNode(),
            SolutionTest.Prameter(
                    listOf(1, 2, 3, 4, 5).toListNode(),
                    1
            ) to listOf(1, 2, 3, 4).toListNode(),
            SolutionTest.Prameter(
                    listOf(1, 2, 3, 4, 5).toListNode(),
                    2
            ) to listOf(1, 2, 3, 5).toListNode(),
            SolutionTest.Prameter(
                    listOf(1, 2, 3, 4, 5).toListNode(),
                    3
            ) to listOf(1, 2, 4, 5).toListNode(),
            SolutionTest.Prameter(
                    listOf(1, 2, 3, 4, 5).toListNode(),
                    4
            ) to listOf(1, 3, 4, 5).toListNode(),
            SolutionTest.Prameter(
                    listOf(1, 2, 3, 4, 5).toListNode(),
                    5
            ) to listOf(2, 3, 4, 5).toListNode(),
            SolutionTest.Prameter(
                    listOf(1, 2).toListNode(),
                    1
            ) to listOf(1).toListNode(),
            SolutionTest.Prameter(
                    listOf(1, 2).toListNode(),
                    2
            ) to listOf(2).toListNode(),
            SolutionTest.Prameter(
                    listOf(1, 2).toListNode(),
                    0
            ) to listOf(1, 2).toListNode(),
            SolutionTest.Prameter(
                    listOf(1).toListNode(),
                    0
            ) to listOf(1).toListNode(),
            SolutionTest.Prameter(
                    listOf(1).toListNode(),
                    1
            ) to null,
            SolutionTest.Prameter(
                    listOf(1, 2, 3, 4, 5, 6).toListNode(),
                    2
            ) to listOf(1, 2, 3, 4, 6).toListNode()
    )
}
