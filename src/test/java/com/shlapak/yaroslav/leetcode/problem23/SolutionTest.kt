package com.shlapak.yaroslav.leetcode.problem23

import com.shlapak.yaroslav.leetcode.utils.ListNode
import com.shlapak.yaroslav.leetcode.utils.asString
import com.shlapak.yaroslav.leetcode.utils.toIntList
import com.shlapak.yaroslav.leetcode.utils.toListNode
import io.kotlintest.shouldBe
import org.spekframework.spek2.Spek

/**
 * Created on 2019/05/09.
 */
/** tests for
 * @see com.shlapak.yaroslav.leetcode.problem23.Solution
 **/
object SolutionTest : Spek({

    group("mergeKListsNaive") {
        val inputs = getInputs()
        inputs.asSequence().forEach { (input, expected) ->
            test("input: $input, expected: ${expected.asString()}") {
                val actual = Solution().mergeKListsNaive(input)
                println("actual:   ${actual.toIntList()}")
                println("expected: ${expected.toIntList()}")
                actual.toIntList() shouldBe expected.toIntList()
            }
        }
    }

    group("mergeKListsNaive2") {
        val inputs = getInputs()
        inputs.asSequence().forEach { (input, expected) ->
            test("input: $input, expected: ${expected.asString()}") {
                val actual = Solution().mergeKListsNaive2(input)
                println("actual:   ${actual.toIntList()}")
                println("expected: ${expected.toIntList()}")
                actual.toIntList() shouldBe expected.toIntList()
            }
        }
    }

    group("mergeKLists") {
        val inputs = getInputs()
        inputs.asSequence().forEach { (input, expected) ->
            test("input: $input, expected: ${expected.asString()}") {
                val actual = Solution().mergeKLists(input)
                println("actual:   ${actual.toIntList()}")
                println("expected: ${expected.toIntList()}")
                actual.toIntList() shouldBe expected.toIntList()
            }
        }
    }
})

private fun getInputs(): Map<Array<ListNode?>, ListNode?> {
    return mapOf(
            arrayOf(
                    listOf(1, 4, 5).toListNode(),
                    listOf(1, 3, 4).toListNode(),
                    listOf(2, 6).toListNode()
            ) to listOf(1, 1, 2, 3, 4, 4, 5, 6).toListNode(),
            arrayOf(
                    listOf(1, 2, 4).toListNode(),
                    listOf(1, 3, 4).toListNode()
            ) to listOf(1, 1, 2, 3, 4, 4).toListNode()
    )
}