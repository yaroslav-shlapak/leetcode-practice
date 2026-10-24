package com.shlapak.yaroslav.leetcode.problems.p0019

import com.shlapak.yaroslav.leetcode.common.ListNode
import com.shlapak.yaroslav.leetcode.support.toIntList
import com.shlapak.yaroslav.leetcode.support.toListNode
import io.kotest.matchers.shouldBe
import io.kotest.core.spec.style.FreeSpec

/**
 * Tests [RemoveNthNodeFromEndOfListLegacy].
 */
class RemoveNthNodeFromEndOfListTest : FreeSpec({

    "removeNthFromEndFirst" - {
        val inputs = getInputs()
        inputs.asSequence().forEach { (input, expected) ->
            "input.head: ${input.head.toString()}, input.n: ${input.n}, expected: ${expected.toString()}" {
                val actual = com.shlapak.yaroslav.leetcode.problems.p0019.RemoveNthNodeFromEndOfListLegacy()
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
                val actual = com.shlapak.yaroslav.leetcode.problems.p0019.RemoveNthNodeFromEndOfListLegacy()
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
                val actual = com.shlapak.yaroslav.leetcode.problems.p0019.RemoveNthNodeFromEndOfListLegacy()
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

private fun getInputs(): Map<RemoveNthNodeFromEndOfListTest.Prameter, ListNode?> {
    return mapOf(
            RemoveNthNodeFromEndOfListTest.Prameter(
                    listOf(1, 2, 3, 4, 5).toListNode(),
                    0
            ) to listOf(1, 2, 3, 4, 5).toListNode(),
            RemoveNthNodeFromEndOfListTest.Prameter(
                    listOf(1, 2, 3, 4, 5).toListNode(),
                    1
            ) to listOf(1, 2, 3, 4).toListNode(),
            RemoveNthNodeFromEndOfListTest.Prameter(
                    listOf(1, 2, 3, 4, 5).toListNode(),
                    2
            ) to listOf(1, 2, 3, 5).toListNode(),
            RemoveNthNodeFromEndOfListTest.Prameter(
                    listOf(1, 2, 3, 4, 5).toListNode(),
                    3
            ) to listOf(1, 2, 4, 5).toListNode(),
            RemoveNthNodeFromEndOfListTest.Prameter(
                    listOf(1, 2, 3, 4, 5).toListNode(),
                    4
            ) to listOf(1, 3, 4, 5).toListNode(),
            RemoveNthNodeFromEndOfListTest.Prameter(
                    listOf(1, 2, 3, 4, 5).toListNode(),
                    5
            ) to listOf(2, 3, 4, 5).toListNode(),
            RemoveNthNodeFromEndOfListTest.Prameter(
                    listOf(1, 2).toListNode(),
                    1
            ) to listOf(1).toListNode(),
            RemoveNthNodeFromEndOfListTest.Prameter(
                    listOf(1, 2).toListNode(),
                    2
            ) to listOf(2).toListNode(),
            RemoveNthNodeFromEndOfListTest.Prameter(
                    listOf(1, 2).toListNode(),
                    0
            ) to listOf(1, 2).toListNode(),
            RemoveNthNodeFromEndOfListTest.Prameter(
                    listOf(1).toListNode(),
                    0
            ) to listOf(1).toListNode(),
            RemoveNthNodeFromEndOfListTest.Prameter(
                    listOf(1).toListNode(),
                    1
            ) to null,
            RemoveNthNodeFromEndOfListTest.Prameter(
                    listOf(1, 2, 3, 4, 5, 6).toListNode(),
                    2
            ) to listOf(1, 2, 3, 4, 6).toListNode()
    )
}
