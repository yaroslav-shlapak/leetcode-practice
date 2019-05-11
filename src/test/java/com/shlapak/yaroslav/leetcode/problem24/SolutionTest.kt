package com.shlapak.yaroslav.leetcode.problem24

import com.shlapak.yaroslav.leetcode.utils.ListNode
import com.shlapak.yaroslav.leetcode.utils.asString
import com.shlapak.yaroslav.leetcode.utils.toIntList
import com.shlapak.yaroslav.leetcode.utils.toListNode
import io.kotlintest.shouldBe
import org.spekframework.spek2.Spek

/**
 * Created on 2019/05/11.
 */
/** tests for
 * @see com.shlapak.yaroslav.leetcode.problem24.Solution
 **/
object SolutionTest : Spek({
    group("swapPairs") {
        val inputs = getInputs()
        inputs.asSequence().forEach { (input, expected) ->
            test("input: ${input.asString()}, expected: ${expected.asString()}") {
                val actual = Solution().swapPairs(input)
                println("actual:   ${actual.asString()}")
                println("expected: ${expected.asString()}")
                actual.toIntList() shouldBe expected.toIntList()
            }
        }
    }
})

private fun getInputs(): Map<ListNode?, ListNode?> {
    return mapOf(
            //1->2->3->4, you should return the list as 2->1->4->3
            listOf(1, 2, 3, 4).toListNode() to listOf(2, 1, 4, 3).toListNode(),
            listOf(1, 2, 3, 4, 5).toListNode() to listOf(2, 1, 4, 3, 5).toListNode(),
            listOf(1, 2, 3, 4, 5, 6).toListNode() to listOf(2, 1, 4, 3, 6, 5).toListNode(),
            listOf(1).toListNode() to listOf(1).toListNode()
    )
}