package com.shlapak.yaroslav.leetcode.problems.p0025

import com.shlapak.yaroslav.leetcode.common.ListNode
import com.shlapak.yaroslav.leetcode.support.asString
import com.shlapak.yaroslav.leetcode.support.toIntList
import com.shlapak.yaroslav.leetcode.support.toListNode
import io.kotest.matchers.shouldBe
import io.kotest.core.spec.style.FreeSpec

/**
 * Created on 2019/05/12.
 */
/** tests for
 * @see com.shlapak.yaroslav.leetcode.problems.p0025.ReverseNodesInKGroup
 **/
class ReverseNodesInKGroupTest : FreeSpec({
    "reverseKGroup" - {
        val inputs = getInputs()
        inputs.asSequence().forEach { (input, expected) ->
            "input: ${input.k}, expected: ${expected.asString()}" {
                val actual = ReverseNodesInKGroup().reverseKGroup(input.head, input.k)
                println("actual:   ${actual.asString()}")
                println("expected: ${expected.asString()}")
                actual.toIntList() shouldBe expected.toIntList()
            }
        }
    }
}) {
    data class Parameter(
            val head: ListNode?,
            val k: Int
    )
}

private fun getInputs(): Map<ReverseNodesInKGroupTest.Parameter, ListNode?> {
    return mapOf(
            /*ReverseNodesInKGroupTest.Parameter(
                    listOf(1, 2, 3, 4, 5).toListNode(),
                    0
            ) to listOf(1, 2, 3, 4, 5).toListNode(),
            ReverseNodesInKGroupTest.Parameter(
                    listOf(1, 2, 3, 4, 5).toListNode(),
                    1
            ) to listOf(1, 2, 3, 4, 5).toListNode(),*/
            ReverseNodesInKGroupTest.Parameter(
                    listOf(1, 2, 3, 4, 5).toListNode(),
                    2
            ) to listOf(2, 1, 4, 3, 5).toListNode(),
            ReverseNodesInKGroupTest.Parameter(
                    listOf(1, 2, 3, 4, 5).toListNode(),
                    3
            ) to listOf(3, 2, 1, 4, 5).toListNode()

            /*
                    ReverseNodesInKGroupTest.Parameter(
                            listOf(1, 2).toListNode(),
                            1
                    ) to listOf(1, 2).toListNode(),
                    ReverseNodesInKGroupTest.Parameter(
                            listOf(1, 2).toListNode(),
                            0
                    ) to listOf(1, 2).toListNode(),
                    ReverseNodesInKGroupTest.Parameter(
                            listOf(1, 2).toListNode(),
                            2
                    ) to listOf(2, 1).toListNode() ,
                    ReverseNodesInKGroupTest.Parameter(
                            listOf(1, 2, 3, 4, 5).toListNode(),
                            4
                    ) to listOf(4, 3, 2, 1, 5).toListNode(),
                    ReverseNodesInKGroupTest.Parameter(
                            listOf(1, 2, 3, 4, 5).toListNode(),
                            5
                    ) to listOf(5, 4, 3, 2, 1).toListNode(),
             */
    )
}