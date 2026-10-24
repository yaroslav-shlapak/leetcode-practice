package com.shlapak.yaroslav.leetcode.problems.p0021

import com.shlapak.yaroslav.leetcode.common.ListNode
import com.shlapak.yaroslav.leetcode.support.toIntList
import com.shlapak.yaroslav.leetcode.support.toListNode
import io.kotest.matchers.shouldBe
import io.kotest.core.spec.style.FreeSpec


/**
 * Created on 2019/05/03.
 */
/** tests for
 * @see com.shlapak.yaroslav.leetcode.problems.p0021.MergeTwoSortedListsLegacy
 **/
class MergeTwoSortedListsTest : FreeSpec({

    "mergeTwoLists" - {
        val inputs = getInputs()
        inputs.asSequence().forEach { (input, expected) ->
            "input.l1: ${input.l1.toString()}, input.l2: ${input.l2.toString()}, expected: ${expected.toString()}" {
                val actual = MergeTwoSortedListsLegacy().mergeTwoLists(input.l1, input.l2)
                println("actual:   ${actual.toIntList()}")
                println("expected: ${expected.toIntList()}")
                actual.toIntList() shouldBe expected.toIntList()
            }
        }
    }
}) {
    data class Prameter(
            val l1: ListNode?,
            val l2: ListNode?
    )
}

private fun getInputs(): Map<MergeTwoSortedListsTest.Prameter, ListNode?> {
    return mapOf(
            MergeTwoSortedListsTest.Prameter(
                    listOf(1, 2, 4).toListNode(),
                    listOf(1, 3, 4).toListNode()
            ) to listOf(1, 1, 2, 3, 4, 4).toListNode()
    )
}