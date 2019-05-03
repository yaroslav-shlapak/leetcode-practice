package com.shlapak.yaroslav.leetcode.problem21

import com.shlapak.yaroslav.leetcode.problem19.ListNode
import com.shlapak.yaroslav.leetcode.problem19.toIntList
import com.shlapak.yaroslav.leetcode.problem19.toListNode
import io.kotlintest.shouldBe
import org.spekframework.spek2.Spek


/**
 * Created on 2019/05/03.
 */
/** tests for
 * @see com.shlapak.yaroslav.leetcode.problem21.Solution
 **/
object SolutionTest : Spek({

    group("mergeTwoLists") {
        val inputs = getInputs()
        inputs.asSequence().forEach { (input, expected) ->
            test("input.l1: ${input.l1.toString()}, input.l2: ${input.l2.toString()}, expected: ${expected.toString()}") {
                val actual = Solution().mergeTwoLists(input.l1, input.l2)
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

private fun getInputs(): Map<SolutionTest.Prameter, ListNode?> {
    return mapOf(
            SolutionTest.Prameter(
                    listOf(1, 2, 4).toListNode(),
                    listOf(1, 3, 4).toListNode()
            ) to listOf(1, 1, 2, 3, 4, 4).toListNode()
    )
}