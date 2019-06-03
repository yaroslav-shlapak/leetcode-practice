package com.shlapak.yaroslav.leetcode.problem25

import com.shlapak.yaroslav.leetcode.utils.ListNode
import com.shlapak.yaroslav.leetcode.utils.asString
import com.shlapak.yaroslav.leetcode.utils.toIntList
import com.shlapak.yaroslav.leetcode.utils.toListNode
import io.kotlintest.shouldBe
import io.kotlintest.specs.FreeSpec

/**
 * Created on 2019/05/12.
 */
/** tests for
 * @see com.shlapak.yaroslav.leetcode.problem25.Solution
 **/
class SolutionTest : FreeSpec({
    "reverseKGroup" - {
        val inputs = getInputs()
        inputs.asSequence().forEach { (input, expected) ->
            "input: ${input.k}, expected: ${expected.asString()}" {
                val actual = Solution().reverseKGroup(input.head, input.k)
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

private fun getInputs(): Map<SolutionTest.Parameter, ListNode?> {
    return mapOf(
            /*SolutionTest.Parameter(
                    listOf(1, 2, 3, 4, 5).toListNode(),
                    0
            ) to listOf(1, 2, 3, 4, 5).toListNode(),
            SolutionTest.Parameter(
                    listOf(1, 2, 3, 4, 5).toListNode(),
                    1
            ) to listOf(1, 2, 3, 4, 5).toListNode(),*/
            SolutionTest.Parameter(
                    listOf(1, 2, 3, 4, 5).toListNode(),
                    2
            ) to listOf(2, 1, 4, 3, 5).toListNode(),
            SolutionTest.Parameter(
                    listOf(1, 2, 3, 4, 5).toListNode(),
                    3
            ) to listOf(3, 2, 1, 4, 5).toListNode()

            /*
                    SolutionTest.Parameter(
                            listOf(1, 2).toListNode(),
                            1
                    ) to listOf(1, 2).toListNode(),
                    SolutionTest.Parameter(
                            listOf(1, 2).toListNode(),
                            0
                    ) to listOf(1, 2).toListNode(),
                    SolutionTest.Parameter(
                            listOf(1, 2).toListNode(),
                            2
                    ) to listOf(2, 1).toListNode() ,
                    SolutionTest.Parameter(
                            listOf(1, 2, 3, 4, 5).toListNode(),
                            4
                    ) to listOf(4, 3, 2, 1, 5).toListNode(),
                    SolutionTest.Parameter(
                            listOf(1, 2, 3, 4, 5).toListNode(),
                            5
                    ) to listOf(5, 4, 3, 2, 1).toListNode(),
             */
    )
}