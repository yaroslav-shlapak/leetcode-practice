package com.shlapak.yaroslav.leetcode.problem19

import io.kotlintest.shouldBe
import org.spekframework.spek2.Spek

/**
 * Created on 2019/04/25.
 */
object SolutionTest : Spek({
    val inputs = mapOf(
            Prameter(
                    listOf(1, 2, 3, 4, 5).toListNode(),
                    0
            ) to listOf(1, 2, 3, 4, 5).toListNode(),
            Prameter(
                    listOf(1, 2, 3, 4, 5).toListNode(),
                    1
            ) to listOf(1, 2, 3, 4).toListNode(),
            Prameter(
                    listOf(1, 2, 3, 4, 5).toListNode(),
                    2
            ) to listOf(1, 2, 3, 5).toListNode(),
            Prameter(
                    listOf(1, 2, 3, 4, 5).toListNode(),
                    3
            ) to listOf(1, 2, 4, 5).toListNode(),
            Prameter(
                    listOf(1, 2, 3, 4, 5).toListNode(),
                    4
            ) to listOf(1, 3, 4, 5).toListNode(),
            Prameter(
                    listOf(1, 2, 3, 4, 5).toListNode(),
                    5
            ) to listOf(2, 3, 4, 5).toListNode(),
            Prameter(
                    listOf(1, 2).toListNode(),
                    1
            ) to listOf(1).toListNode(),
            Prameter(
                    listOf(1).toListNode(),
                    0
            ) to listOf(1).toListNode(),
            Prameter(
                    listOf(1).toListNode(),
                    1
            ) to null,
            Prameter(
                    listOf(1, 2, 3, 4, 5, 6).toListNode(),
                    2
            ) to listOf(1, 2, 3, 4, 6).toListNode()

    )



    group("removeNthFromEnd") {
        inputs.asSequence().forEach { (input, expected) ->
            test("input.head: ${input.head.toString()}, input.n: ${input.n}, expected: ${expected.toString()}") {
                val actual = Solution().removeNthFromEnd(input.head, input.n)
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

fun List<Int>?.toListNode(): ListNode? {
    return if (this.isNullOrEmpty()) {
        null
    } else {
        val root = ListNode(this[0])
        var next: ListNode? = root
        this.asSequence().forEachIndexed { index, value ->
            if (index > 0) {
                next?.next = ListNode(this[index])
                next = next?.next
            }
        }
        root
    }
}

fun ListNode?.toString(): String {
    val s = StringBuilder()
    if (this != null) {
        var next = this
        while (next != null) {
            s.append(next.`val`)
            if (next.next != null) {
                s.append(" -> ")
            }
            next = next.next
        }
    }
    return s.toString()
}

fun ListNode?.toIntList(): List<Int> {
    val list = mutableListOf<Int>()
    if (this != null) {
        var next = this
        while (next != null) {
            list.add(next.`val`)
            next = next.next
        }
    }
    return list
}

fun ListNode?.copy(): ListNode? {
    return if (this == null) {
        null
    } else {
        val res = ListNode(this.`val`)
        val next = this.next
        res.next = this.next
        res
    }
}
